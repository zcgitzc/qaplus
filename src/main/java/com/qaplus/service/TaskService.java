package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaTask;

public interface TaskService {
	int addTask(QaTask task);
	
	List<QaTask> queryMyTask();
	
	int agree(QaTask qaTask);
	
	int reject(QaTask qaTask);
	
}
