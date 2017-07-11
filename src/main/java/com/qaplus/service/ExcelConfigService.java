package com.qaplus.service;

import java.util.List;

import com.qaplus.constant.ExcelPrimaryKey;
import com.qaplus.entity.QaExcelConfig;

public interface ExcelConfigService {
	List<QaExcelConfig> queryByPrimaryKey(ExcelPrimaryKey key);
}
