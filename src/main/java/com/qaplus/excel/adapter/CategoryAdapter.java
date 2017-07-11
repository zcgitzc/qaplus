package com.qaplus.excel.adapter;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

import com.qaplus.constant.QCategory;
import com.qaplus.entity.QaExcelConfig;
import com.qaplus.utils.excel.CommonAdapter;

@Component("categoryAdapter")
public class CategoryAdapter implements CommonAdapter {

	@Override
	public Object callback(BeanWrapper beanWrapper, QaExcelConfig columnName) {
		try {
			String oldVal = (String) beanWrapper.getPropertyValue(columnName.getProperty());
			return QCategory.valueOf(oldVal).getDesc();
		} catch (BeansException e) {
			return beanWrapper.getPropertyValue(columnName.getProperty());
		}
	}

}
