package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaExamQuestionItem;
import com.qaplus.entity.vo.ExamQuestionItemVo;

public interface ExamQuestionItemService {
	void updateById(QaExamQuestionItem item);

	List<ExamQuestionItemVo> queryByExamQuestionId(Long questionId);

	void add(QaExamQuestionItem item);

	ExamQuestionItemVo queryById(Long id);
}
