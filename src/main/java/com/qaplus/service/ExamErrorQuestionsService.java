package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaExamErrorQuestions;


public interface ExamErrorQuestionsService {
	void add(QaExamErrorQuestions questions);
	List<QaExamErrorQuestions> queryByStuIdAndQuestionId(Long stuId,Long questionId);
	void updateById(QaExamErrorQuestions question);
}		
