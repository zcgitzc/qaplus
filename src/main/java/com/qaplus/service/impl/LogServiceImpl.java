package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.common.CommonBusiLogic;
import com.qaplus.entity.QaLog;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.mapper.QaLogMapperExt;
import com.qaplus.service.LogService;

@Service
public class LogServiceImpl implements LogService {
	@Resource
	private QaLogMapperExt logMapperExt;

	@Override
	public void insertLog(QaLog qaLog) {
		logMapperExt.insertSelective(qaLog);
	}

	@Override
	public ResponseData<QaLog> queryAllLog(String searchKey, Page page, String rightLog) {
		// 如果前端有可能传begin end 也有可能传 current length
		if (page != null && page.getEnd() == 0) {
			CommonBusiLogic.setPageBeginByPage(page);
		}
		List<QaLog> data = logMapperExt.queryAllLog(searchKey, page, rightLog);
		int count = logMapperExt.countForQueryAll(searchKey, rightLog);
		return new ResponseData<QaLog>(data, count);
	}

}
