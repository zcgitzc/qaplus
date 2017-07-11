package com.qaplus.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.entity.QaUserTask;
import com.qaplus.mapper.QaUserTaskMapperExt;
import com.qaplus.service.UserTaskService;
@Service
public class UserTaskServiceImpl implements UserTaskService {
	@Resource
	private QaUserTaskMapperExt userTaskMapperExt;
	
	
	@Override
	public void addUserTask(QaUserTask record) {
		userTaskMapperExt.insertSelective(record);
	}


	@Override
	public void delUserTask(Long taskId) {
		userTaskMapperExt.delUserTask(taskId);
	}

}
