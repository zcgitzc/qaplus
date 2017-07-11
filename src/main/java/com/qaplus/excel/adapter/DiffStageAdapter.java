package com.qaplus.excel.adapter;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

import com.qaplus.constant.DiffStage;
import com.qaplus.entity.QaExcelConfig;
import com.qaplus.utils.excel.CommonAdapter;

@Component("diffStageAdapter")
public class DiffStageAdapter implements CommonAdapter {

	@Override
	public Object callback(BeanWrapper beanWrapper, QaExcelConfig columnName) {
		try {
			String oldVal = (String) beanWrapper.getPropertyValue(columnName.getProperty());
			return DiffStage.valueOf(oldVal).getDesc();
		} catch (BeansException e) {
			return beanWrapper.getPropertyValue(columnName.getProperty());
		}
	}

}
