package com.qaplus.utils.excel;

import org.springframework.beans.BeanWrapper;

import com.qaplus.entity.QaExcelConfig;

public interface CommonAdapter {
	public Object callback(BeanWrapper beanWrapper, QaExcelConfig columnName);
}
