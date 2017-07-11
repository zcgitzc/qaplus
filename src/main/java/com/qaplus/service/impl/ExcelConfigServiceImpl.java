package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.constant.ExcelPrimaryKey;
import com.qaplus.entity.QaExcelConfig;
import com.qaplus.entity.QaExcelConfigExample;
import com.qaplus.mapper.QaExcelConfigMapperExt;
import com.qaplus.service.ExcelConfigService;
@Service
public class ExcelConfigServiceImpl implements ExcelConfigService {
	@Resource
	private QaExcelConfigMapperExt excelConfigMapperExt;
	
	@Override
	public List<QaExcelConfig> queryByPrimaryKey(ExcelPrimaryKey key) {
		QaExcelConfigExample example=new QaExcelConfigExample();
		example.createCriteria().andPrimaryKeyEqualTo(key.name());
		example.setOrderByClause("serial asc");
		return excelConfigMapperExt.selectByExample(example);
	}

}
