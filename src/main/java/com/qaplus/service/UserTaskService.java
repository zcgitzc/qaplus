package com.qaplus.service;

import com.qaplus.entity.QaUserTask;

public interface UserTaskService {
	void addUserTask(QaUserTask record);
	void delUserTask(Long taskId);
}
