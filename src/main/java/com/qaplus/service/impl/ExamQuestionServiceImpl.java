package com.qaplus.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qaplus.common.CommonBusiLogic;
import com.qaplus.constant.CommonBoolean;
import com.qaplus.constant.DiffStage;
import com.qaplus.constant.ExamQuestoinType;
import com.qaplus.constant.ExcelPrimaryKey;
import com.qaplus.constant.QCategory;
import com.qaplus.entity.QaExamQuestion;
import com.qaplus.entity.QaExamQuestionExample;
import com.qaplus.entity.QaExamQuestionItem;
import com.qaplus.entity.QaPaperStuDetail;
import com.qaplus.entity.vo.ExamQuestionItemVo;
import com.qaplus.entity.vo.ExamQuestionVo;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.excel.adapter.ExportExamQuestionExcelAdapter;
import com.qaplus.mapper.QaExamQuestionItemMapperExt;
import com.qaplus.mapper.QaExamQuestionMapperExt;
import com.qaplus.service.ExamQuestionItemService;
import com.qaplus.service.ExamQuestionService;
import com.qaplus.service.PaperStudentDetailService;
import com.qaplus.service.UserService;
import com.qaplus.sql.batch.BatchSupport;
import com.qaplus.sql.batch.MapperIdConstant;
import com.qaplus.utils.StreamConvertUtil;
import com.qaplus.utils.SuperDate;
import com.qaplus.utils.excel.ExcelUtil;
import com.qaplus.utils.excel.sheet.ExcelSheet;

@Service
public class ExamQuestionServiceImpl implements ExamQuestionService {
	private static final Logger logger = LoggerFactory.getLogger(ExamQuestionServiceImpl.class);
	@Resource
	private QaExamQuestionMapperExt examQuestionMapperExt;
	@Resource
	private ExamQuestionItemService examQuestionItemService;
	@Resource
	private UserService userService;
	@Resource
	private PaperStudentDetailService paperStudentDetailService;
	private static final String SEPARATOR = ",";

	@Override
	public ResponseData<ExamQuestionVo> queryAllForPage(String title, String[] categorys, Page page) {
		// 如果前端有可能传begin end 也有可能传 current length
		if (page != null && page.getEnd() == 0) {
			CommonBusiLogic.setPageBeginByPage(page);
		}
		List<ExamQuestionVo> data = examQuestionMapperExt.queryAllForPage(title, categorys, page);
		for (ExamQuestionVo examQuestionVo : data) {
			examQuestionVo.setItems(examQuestionItemService.queryByExamQuestionId(examQuestionVo.getId()));
		}
		int count = examQuestionMapperExt.countAllForPage(title, categorys);
		return new ResponseData<ExamQuestionVo>(data, count);
	}

	@Override
	public void updateById(QaExamQuestion question) {
		examQuestionMapperExt.updateByPrimaryKeySelective(question);
	}

	@Override
	public void deleteById(Long id) {
		QaExamQuestion question = examQuestionMapperExt.selectByPrimaryKey(id);
		if (question == null) {
			throw new RuntimeException("问题不存在，请刷新重试");
		}
		question.setIsDeleted(CommonBoolean.Y.name());
		this.updateById(question);
		// 删除选项
		List<ExamQuestionItemVo> items = examQuestionItemService.queryByExamQuestionId(id);
		for (ExamQuestionItemVo examQuestionItemVo : items) {
			examQuestionItemVo.setIsDeleted(CommonBoolean.Y.name());
		}
		BatchSupport.updateBatch(QaExamQuestionItemMapperExt.class, MapperIdConstant.UPDATE_BY_PRIMARYKEY_SELECTIVE.getValue(), items);
	}

	@Override
	public void addExamQuestion(ExamQuestionVo examQuestionVo) {
		examQuestionVo.setQuestionPerson(userService.getCurrUserBySession().getUsername());
		examQuestionVo.setTitle(examQuestionVo.getContent());
		// 新增的题目，难易程度随机
		Random r = new Random(DiffStage.values().length - 1);
		examQuestionVo.setDiffStage(DiffStage.values()[r.nextInt()].name());
		examQuestionMapperExt.insertSelective(examQuestionVo);
		QaExamQuestionItem item = null;
		for (int i = 0; i < examQuestionVo.getItemContent().length; i++) {
			item = new QaExamQuestionItem();
			item.setExamQuestionId(examQuestionVo.getId());
			item.setIsRightItem(examQuestionVo.getIsRightItem()[i]);
			item.setItemContent(examQuestionVo.getItemContent()[i]);
			examQuestionItemService.add(item);
		}
	}

	@Override
	public List<QaExamQuestion> queryStageQuestions(DiffStage diffStage, QCategory category) {
		QaExamQuestionExample example = new QaExamQuestionExample();
		if (QCategory.OTHER.equals(category)) {
			example.createCriteria().andDiffStageEqualTo(diffStage.name());
		} else {
			example.createCriteria().andDiffStageEqualTo(diffStage.name()).andCategoryEqualTo(category.name());
		}
		return examQuestionMapperExt.selectByExample(example);
	}

	@Override
	public List<ExamQuestionVo> queryByIds(List<Long> ids) {
		QaExamQuestionExample example = new QaExamQuestionExample();
		example.createCriteria().andIdIn(ids);
		List<QaExamQuestion> questions = examQuestionMapperExt.selectByExample(example);

		List<ExamQuestionVo> questionVos = new ArrayList<ExamQuestionVo>();
		ExamQuestionVo vo = null;
		for (QaExamQuestion question : questions) {
			vo = new ExamQuestionVo();
			BeanUtils.copyProperties(question, vo);
			vo.setItems(examQuestionItemService.queryByExamQuestionId(question.getId()));
			questionVos.add(vo);
		}
		return questionVos;
	}

	@Override
	public void exportExamQuestion(String title, String[] categorys, HttpServletResponse response) {
		try {
			List<ExamQuestionVo> data = this.queryAllForPage(title, categorys, null).getData();
			String fileName = "考试试题列表";
			fileName = fileName + SuperDate.formatAsDateString(new Date());
			response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
			response.setContentType("application/vnd.ms-excel");
			OutputStream outputStream = response.getOutputStream();

			ExcelSheet sheet = ExcelUtil.convert2Sheet("考试试题列表", data, new ExportExamQuestionExcelAdapter(), ExcelPrimaryKey.EXPORT_EXAM_QUESTION);
			ExcelUtil.exportExcel(Arrays.asList(sheet), outputStream);
		} catch (Exception e) {
			logger.error("导出教师考试试题列表为Excel文件失败", e.getMessage());
		}
	}

	@Override
	public void downloadExamQuestionTemplate(HttpServletResponse response) {
		try {
			// 设置基本信息
			String fileName = "模板";
			fileName = fileName + SuperDate.formatAsDateString(new Date());
			response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
			response.setContentType("application/vnd.ms-excel");
			OutputStream outputStream = response.getOutputStream();
			// 1、把Excel文件放到byteOutStream中
			ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
			ExcelUtil.exportExcel(Arrays.asList(ExcelUtil.convert2Sheet("考试问题列表", null, null, ExcelPrimaryKey.DOWNLOAD_EXAM_QUESTION_TEMPLATE)), byteOutStream);
			ByteArrayInputStream byteInStream = StreamConvertUtil.parse(byteOutStream);
			// 2、读取Excel设置指定的值
			Workbook workbook = ExcelUtil.openExcel(byteInStream);
			// 3、设置固定值
			Sheet sheet = workbook.getSheetAt(0);

			String[] examQuestionType = new String[ExamQuestoinType.values().length];
			for (int i = 0; i < ExamQuestoinType.values().length; i++) {
				examQuestionType[i] = ExamQuestoinType.values()[i].getDesc();
			}
			ExcelUtil.setValidation(sheet, examQuestionType, 1, 1000, 1, 1);

			String[] diffStage = new String[DiffStage.values().length];
			for (int i = 0; i < DiffStage.values().length; i++) {
				diffStage[i] = DiffStage.values()[i].getDesc();
			}
			ExcelUtil.setValidation(sheet, diffStage, 1, 1000, 3, 3);

			String[] categroys = new String[QCategory.values().length];
			for (int i = 0; i < QCategory.values().length; i++) {
				categroys[i] = QCategory.values()[i].getDesc();
			}
			ExcelUtil.setValidation(sheet, categroys, 1, 1000, 4, 4);
			sheet.createRow(1).createCell(6).setCellValue("（正确选项）这个选项是正确答案（这是第一个选项）|每个选项用竖线隔开（这是第二个选项）");
			// 4、导出去
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
			byteInStream.close();
			byteOutStream.close();
		} catch (Exception e) {
			logger.error("下载模板Excel文件失败", e.getMessage());
		}
	}

	@Override
	public void importExamQuestion(MultipartHttpServletRequest request) {
		QaExamQuestion question = null;
		QaExamQuestionItem itemVo = null;
		List<QaExamQuestionItem> itemsVo = new ArrayList<QaExamQuestionItem>();
		for (Entry<String, List<MultipartFile>> entry : request.getMultiFileMap().entrySet()) {
			for (MultipartFile multipartFile : entry.getValue()) {
				try {
					Workbook workbook = ExcelUtil.openExcel(multipartFile.getInputStream());
					Sheet sheet = workbook.getSheetAt(0);
					for (int i = 0; i < sheet.getLastRowNum(); i++) {
						Row row = sheet.getRow(i + 1);
						question = new QaExamQuestion();
						question.setTitle(ExcelUtil.getValue(row.getCell(0)));
						question.setContent(ExcelUtil.getValue(row.getCell(0)));

						String examQuestionType = ExcelUtil.getValue(row.getCell(1));
						for (int j = 0; j < ExamQuestoinType.values().length; j++) {
							if (examQuestionType.equals(ExamQuestoinType.values()[j].getDesc())) {
								question.setType(ExamQuestoinType.values()[j].name());
							}
						}
						question.setScore(Integer.parseInt(ExcelUtil.getValue(row.getCell(2))));

						String diffStage = ExcelUtil.getValue(row.getCell(3));
						for (int j = 0; j < DiffStage.values().length; j++) {
							if (diffStage.equals(DiffStage.values()[j].getDesc())) {
								question.setDiffStage(DiffStage.values()[j].name());
							}
						}

						String category = ExcelUtil.getValue(row.getCell(4));
						for (int j = 0; j < QCategory.values().length; j++) {
							if (category.equals(QCategory.values()[j].getDesc())) {
								question.setCategory(QCategory.values()[j].name());
							}
						}

						question.setNote(ExcelUtil.getValue(row.getCell(5)));
						question.setQuestionPerson(userService.getCurrUserBySession().getUsername());
						question.setRecCreateUser(userService.getCurrUserBySession().getUsername());
						question.setRecUpdateUser(userService.getCurrUserBySession().getUsername());

						examQuestionMapperExt.insertSelective(question);
						String[] items = ExcelUtil.getValue(row.getCell(6)).split("\\|");
						for (String item : items) {
							itemVo = new ExamQuestionItemVo();
							itemVo.setExamQuestionId(question.getId());
							if (item.startsWith("（正确选项）")) {
								itemVo.setItemContent(item.substring(item.indexOf("（正确选项）") + 6, item.length()));
								itemVo.setIsRightItem(CommonBoolean.Y.name());
							} else {
								itemVo.setIsRightItem(CommonBoolean.N.name());
								itemVo.setItemContent(item);
							}
							itemVo.setRecCreateUser(userService.getCurrUserBySession().getUsername());
							itemVo.setRecUpdateUser(userService.getCurrUserBySession().getUsername());
							itemsVo.add(itemVo);
						}
					}
				} catch (IOException e) {
					logger.error("Excel上传试题失败", e);
				}
			}
		}
		BatchSupport.insertBatch(QaExamQuestionItemMapperExt.class, MapperIdConstant.INSERT_SELECTIVE.getValue(), itemsVo);
	}

	@Override
	public List<ExamQuestionVo> queryAllErrorQuestions(Long stuId,String[] categorys) {
		List<ExamQuestionVo> errorQuestions = examQuestionMapperExt.queryAllErrorQuestions(stuId,categorys);
		for (ExamQuestionVo examQuestionVo : errorQuestions) {
			examQuestionVo.setItems(examQuestionItemService.queryByExamQuestionId(examQuestionVo.getId()));
		}
		// 得到用户选择的选项
		for (ExamQuestionVo examQuestionVo : errorQuestions) {
			examQuestionVo.setCanReadNote(CommonBoolean.N.name());
			List<QaPaperStuDetail> paperStuDetails = paperStudentDetailService.queryByStuIdAndQuestionId(stuId, examQuestionVo.getId());
			for (QaPaperStuDetail paperStuDetail : paperStuDetails) {
				if (StringUtils.isNotEmpty(paperStuDetail.getChoiceItem())) {
					String[] choiceItems = paperStuDetail.getChoiceItem().split(SEPARATOR);
					for (ExamQuestionItemVo item : examQuestionVo.getItems()) {
						for (String choiceItem : choiceItems) {
							if (item.getId().toString().equals(choiceItem)) {
								item.setIsUserChoice(CommonBoolean.Y.name());
							}
						}
					}
				}
			}
		}
		return errorQuestions;
	}

	@Override
	public void removeErrorQuestion(Long stuId, Long questionId) {
		examQuestionMapperExt.removeErrorQuestion(stuId,questionId);
	}
}
