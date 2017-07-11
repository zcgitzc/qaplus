package com.qaplus.utils.excel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddressList;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.qaplus.constant.ExcelPrimaryKey;
import com.qaplus.entity.QaExcelConfig;
import com.qaplus.service.ExcelConfigService;
import com.qaplus.utils.excel.sheet.ExcelSheet;
import com.qaplus.utils.excel.sheet.SheetColumn;

/**
 * 可以导出到文件系统中：(response.getOutStream() outputStream=new FileOutputStream())
 * OutputStream outputStream=new FileOutputStream(new
 * File("D:"+File.separator+"111.xlsx")); ExcelUtil.exportExcel(sheet,
 * outputStream);
 * 
 * @author zc
 *
 */
public class ExcelUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	private static String SPILT = ".";

	private static int maxColumnWidth = 60 * 256; // The maximum column width
													// for
													// an individual cell is 255
													// characters
	private static int minColumnWidth = 15 * 256;

	private static ThreadLocal<Workbook> workBook = new ThreadLocal<Workbook>();

	/** 用于去除EXCEL中头尾的换行和空格 */
	private static Pattern BLANK_PATTERN = Pattern.compile("^[\\s|\\t|\\r|\\n|\u00A0|\u3000]*(.*?)[\\s|\\t|\\r|\\n|\u00A0|\u3000]*$", Pattern.DOTALL);

	
	private static ExcelConfigService excelConfigService;


	/**
	 * 
	 * @param title
	 * @param list
	 * @param columnAdapter
	 * @param excelPrimaryKey
	 * @return
	 */
	public static ExcelSheet convert2Sheet(String title, List<?> list, ColumnAdapter columnAdapter,ExcelPrimaryKey excelPrimaryKey) {
		ExcelSheet sheet = new ExcelSheet();
		sheet.setTitle(title);
		List<QaExcelConfig> columnNames=excelConfigService.queryByPrimaryKey(excelPrimaryKey);
		sheet.setHeaders(convert2SheetHeader(columnNames));
		sheet.setData(convert2SheetLines(list, columnNames, columnAdapter));
		return sheet;
	}

	public void setExcelConfigService(ExcelConfigService excelConfigService) {
		ExcelUtil.excelConfigService = excelConfigService;
	}

	public static void exportExcel(List<ExcelSheet> excelSheets, OutputStream out) throws Exception {
		// 声明一个工作薄
		workBook.set(new SXSSFWorkbook(1000));
		for (ExcelSheet excelSheet : excelSheets) {
			createSheet(excelSheet);
		}
		workBook.get().write(out);
		workBook.remove();
	}

	public static InputStream getInputStream(FileItem item) throws IOException {
		if (item == null) {
			return null;
		}
		InputStream is = item.getInputStream();
		return is;
	}

	public static Workbook openExcel(InputStream is) throws IOException {
		if (!is.markSupported()) {
			is = new PushbackInputStream(is, 8);
		}
		if (POIFSFileSystem.hasPOIFSHeader(is)) {
			return new HSSFWorkbook(is);
		}
		try {
			if (POIXMLDocument.hasOOXMLHeader(is)) {
				return new XSSFWorkbook(OPCPackage.open(is));
			}
		} catch (Exception e) {
			throw new RuntimeException("导入Excel失败", e);
		}
		throw new RuntimeException("导入Excel失败");
	}

	public static String getValue(Cell hssfCell) {
		if (hssfCell == null) {
			return null;
		}
		hssfCell.setCellType(Cell.CELL_TYPE_STRING);
		if (hssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			String result = hssfCell.getStringCellValue();
			if (result == null) {
				return "";
			}
			Matcher m = BLANK_PATTERN.matcher(result);
			// 去除行尾的空格和换行等
			if (m.matches()) {
				return m.group(1);
			}
			return result;
		}
	}

	/**
	 * 设置某些列的值只能输入预制的数据,显示下拉框.
	 * 
	 * @param sheet
	 *            要设置的sheet.
	 * @param textlist
	 *            下拉框显示的内容
	 * @param firstRow
	 *            开始行
	 * @param endRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param endCol
	 *            结束列
	 * @return 设置好的sheet.
	 */
	public static Sheet setValidation(Sheet sheet, String[] textlist, int firstRow, int endRow, int firstCol, int endCol) {
		if (sheet instanceof XSSFSheet) {
			XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper((XSSFSheet) sheet);
			XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper.createExplicitListConstraint(textlist);
			CellRangeAddressList data = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
			XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, data);
			sheet.addValidationData(validation);
		} else if (sheet instanceof HSSFSheet) {
			DVConstraint constraint = DVConstraint.createExplicitListConstraint(textlist);
			// 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
			CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
			DataValidation dataValidation = new HSSFDataValidation(regions, constraint);
			sheet.addValidationData(dataValidation);
		}
		return sheet;
	}

	/**
	 * Excel导出的列名
	 * 
	 * @param columnNames
	 * @return
	 */
	private static List<SheetColumn> convert2SheetHeader(List<QaExcelConfig> columnNames) {
		List<SheetColumn> headers = new LinkedList<SheetColumn>();
		for (QaExcelConfig columnName : columnNames) {
			SheetColumn sheetColumn = new SheetColumn();
			sheetColumn.setColumnName(columnName.getHeaderName());
			sheetColumn.setFormatStyle(columnName.getFormatStyle());
			headers.add(sheetColumn);
		}
		return headers;
	}

    private static Object dealCommonColumn(BeanWrapper beanWrapper, QaExcelConfig columnName) {
    	CommonAdapter adapter = applicationContext.getBean(columnName.getCommonKey(), CommonAdapter.class);
        return adapter.callback(beanWrapper, columnName);
    }
    
	/**
	 * 转换List<?>为数据
	 * 
	 * @param list
	 * @param columnNames
	 * @param columnAdapter
	 * @return
	 */
	private static List<List<Object>> convert2SheetLines(List<?> list, List<QaExcelConfig> columnNames, ColumnAdapter columnAdapter) {
		List<List<Object>> data = new ArrayList<List<Object>>();
		if (CollectionUtils.isEmpty(list)) {
			return data;
		}
		for (Object obj : list) {
			data.add(convert2SheetLine(obj, columnNames, columnAdapter));
		}
		return data;
	}

	/**
	 * 将object转换为一行
	 * 
	 * @param object
	 * @param columnNames
	 * @param columnAdapter
	 * @return 返回List<Object> 表示一行,支持Date类型和String类型
	 */
	private static List<Object> convert2SheetLine(Object object, List<QaExcelConfig> columnNames, ColumnAdapter columnAdapter) {
		List<Object> line = new LinkedList<Object>();
		Map<String, Object> specialColumn = null;
		// 取得Adapter的特殊列处理结果
		if (columnAdapter != null) {
			specialColumn = columnAdapter.callBack(object);
		}
		if (specialColumn == null) {
			specialColumn = new HashMap<String, Object>();
		}
		BeanWrapper beanWrapper = new BeanWrapperImpl(object);
		for (QaExcelConfig columnName : columnNames) {
			if (specialColumn.containsKey(columnName.getColumnKey())) {
				line.add(specialColumn.get(columnName.getColumnKey()));
			} else if (StringUtils.isNotBlank(columnName.getCommonKey())) {
                line.add(dealCommonColumn(beanWrapper, columnName));
            } else {
				line.add(dealPropertyColumn(beanWrapper, columnName.getProperty()));
			}
		}
		return line;
	}

	/**
	 * 根据property属性名递归的获取beanWrapper对应的属性值
	 * 
	 * @param beanWrapper
	 * @param property
	 *            属性名，对应app_resource_gws.value_2
	 * @return
	 */
	private static Object dealPropertyColumn(BeanWrapper beanWrapper, String property) {
		if (StringUtils.isEmpty(property)) {
			return "";
		}
		return getPropertyValue(beanWrapper, property);
	}

	// 递归获取属性,用.分割递归
	private static Object getPropertyValue(BeanWrapper beanWrapper, String property) {
		String[] properties = StringUtils.split(property, SPILT);
		for (int i = 0; i < properties.length; i++) {
			Object object = beanWrapper.isReadableProperty(properties[i]) ? beanWrapper.getPropertyValue(properties[i]) : null;
			if (i + 1 == properties.length || object == null) {
				return object;
			}
			beanWrapper = new BeanWrapperImpl(object);
		}
		return null;
	}

	private static void createSheet(ExcelSheet mySheet) {

		// 生成一个表格
		Sheet sheet = workBook.get().createSheet(mySheet.getTitle());
		List<CellStyle> formats = createHeaders(sheet, mySheet.getHeaders());
		// 第0行为header，第一行开始为data
		int index = 1;
		for (List<Object> list : mySheet.getData()) {
			createLine(index, sheet, list, formats);
			index++;
		}
		initColumnWidth(sheet, mySheet);
	}

	private static void initColumnWidth(Sheet sheet, ExcelSheet mySheet) {
		// 锁定第一行作为header
		for (int index = 0; index < mySheet.getHeaders().size(); index++) {
			sheet.autoSizeColumn(index);
			int width = sheet.getColumnWidth(index);
			if (width > maxColumnWidth) {
				sheet.setColumnWidth(index, maxColumnWidth);
			} else if (width < minColumnWidth) {
				sheet.setColumnWidth(index, minColumnWidth);
			}
		}
		sheet.createFreezePane(0, 1);
	}

	private static void createLine(int index, Sheet sheet, List<Object> list, List<CellStyle> formats) {
		Row row = sheet.createRow(index);
		for (int i = 0; i < list.size(); i++) {
			Cell cell = row.createCell(i);
			insertValueByType(cell, list.get(i));
			if (null != formats.get(i)) {
				cell.setCellStyle(formats.get(i));
			}
		}
	}

	private static List<CellStyle> createHeaders(Sheet sheet, List<SheetColumn> headers) {
		Row row = sheet.createRow(0);
		List<CellStyle> cellStyleList = new ArrayList<CellStyle>();
		for (int i = 0; i < headers.size(); i++) {
			if (StringUtils.isEmpty(headers.get(i).getFormatStyle())) {
				cellStyleList.add(null);
			} else {
				DataFormat dataFormat = workBook.get().createDataFormat();
				int index = dataFormat.getFormat(headers.get(i).getFormatStyle());
				CellStyle style = workBook.get().createCellStyle();
				style.setDataFormat((short) index);
				cellStyleList.add(style);
			}
			Cell cell = row.createCell(i);
			XSSFRichTextString text = new XSSFRichTextString(headers.get(i).getColumnName());
			cell.setCellValue(text);
		}
		return cellStyleList;
	}

	private static void insertValueByType(Cell cell, Object value) {
		if (value == null) {
			return;
		}
		if (value instanceof Boolean) {
			if (Boolean.FALSE.equals(value)) {
				cell.setCellValue("N");
			} else {
				cell.setCellValue("Y");
			}
		} else if (value instanceof Date) {
			Date date = (Date) value;
			cell.setCellValue(date);
		} else if (value instanceof BigDecimal) {
			cell.setCellValue(((BigDecimal) value).doubleValue());
		} else {
			cell.setCellValue(value.toString());
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ExcelUtil.applicationContext = applicationContext;
	}

}
