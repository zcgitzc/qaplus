package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaPaperStuDetail;

public interface PaperStudentDetailService {
	void add(QaPaperStuDetail paperStudentDetail);

	QaPaperStuDetail queryByPaperIdAndQuestionId(Long paperId, Long questionId, Long userId);

	void update(QaPaperStuDetail paperStudentDetail);

	List<QaPaperStuDetail> queryByPaperId(Long paperId);
	
	List<QaPaperStuDetail> queryByStuIdAndQuestionId(Long stuId,Long qId);
}
