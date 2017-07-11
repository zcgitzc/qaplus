package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaStuHwQuestion;

public interface StuHwQuestionService {
	QaStuHwQuestion selectByPrimary(Long id);
	
	List<QaStuHwQuestion> queryByHomeworkId(Long homeworkId);
}
