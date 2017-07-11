package com.qaplus.utils.excel.sheet;


import java.util.List;

/**
 * @author karl on 14-12-29.
 */
public class ExcelSheet {

    //标题栏
    private String             title;
    //第一列
    private List<SheetColumn>  headers;
    //数据
    private List<List<Object>> data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SheetColumn> getHeaders() {
        return headers;
    }

    public void setHeaders(List<SheetColumn> headers) {
        this.headers = headers;
    }

    public List<List<Object>> getData() {
        return data;
    }

    public void setData(List<List<Object>> data) {
        this.data = data;
    }
}
