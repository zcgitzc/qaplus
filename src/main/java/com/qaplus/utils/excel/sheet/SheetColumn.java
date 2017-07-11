package com.qaplus.utils.excel.sheet;

/**
 * @author karl on 15-5-4.
 */
public class SheetColumn {

    /*列名*/
    private String columnName;
    /*列格式化类型*/
    private String formatStyle;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getFormatStyle() {
        return formatStyle;
    }

    public void setFormatStyle(String formatStyle) {
        this.formatStyle = formatStyle;
    }
}
