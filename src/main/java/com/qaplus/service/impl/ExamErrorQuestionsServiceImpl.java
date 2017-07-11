package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.entity.QaExamErrorQuestions;
import com.qaplus.entity.QaExamErrorQuestionsExample;
import com.qaplus.mapper.QaExamErrorQuestionsMapperExt;
import com.qaplus.service.ExamErrorQuestionsService;

@Service
public class ExamErrorQuestionsServiceImpl implements ExamErrorQuestionsService {
	@Resource
	private QaExamErrorQuestionsMapperExt examErrorQuestionsMapperExt;

	@Override
	public void add(QaExamErrorQuestions questions) {
		examErrorQuestionsMapperExt.insertSelective(questions);
	}

	@Override
	public List<QaExamErrorQuestions> queryByStuIdAndQuestionId(Long stuId, Long questionId) {
		QaExamErrorQuestionsExample example = new QaExamErrorQuestionsExample();
		example.createCriteria().andStuIdEqualTo(stuId).andQuestionIdEqualTo(questionId);
		return examErrorQuestionsMapperExt.selectByExample(example);
	}

	@Override
	public void updateById(QaExamErrorQuestions question) {
		examErrorQuestionsMapperExt.updateByPrimaryKeySelective(question);
	}

}
