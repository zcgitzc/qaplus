package com.qaplus.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qaplus.entity.QaLog;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.service.LogService;

@Controller
@RequestMapping("log")
public class LogController extends SuperController {
	@Resource
	private LogService logService;

	@RequestMapping("queryAllLog")
	public ResponseData<QaLog> queryAllLog(String searchKey,Page page,String rightLog) {
		return logService.queryAllLog(searchKey,page,rightLog);
	}
}
