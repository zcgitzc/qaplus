package com.qaplus.service;

import com.qaplus.entity.QaLog;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;

public interface LogService {
	void insertLog(QaLog qaLog);

	ResponseData<QaLog> queryAllLog(String searchKey, Page page,String rightLog);

}
