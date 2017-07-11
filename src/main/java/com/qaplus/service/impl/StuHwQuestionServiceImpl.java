package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.entity.QaStuHwQuestion;
import com.qaplus.entity.QaStuHwQuestionExample;
import com.qaplus.mapper.QaStuHwQuestionMapperExt;
import com.qaplus.service.StuHwQuestionService;

@Service
public class StuHwQuestionServiceImpl implements StuHwQuestionService {
	@Resource
	private QaStuHwQuestionMapperExt stuHwQuestionMapperExt;

	@Override
	public QaStuHwQuestion selectByPrimary(Long id) {
		return stuHwQuestionMapperExt.selectByPrimaryKey(id);
	}

	@Override
	public List<QaStuHwQuestion> queryByHomeworkId(Long homeworkId) {
		QaStuHwQuestionExample example = new QaStuHwQuestionExample();
		example.createCriteria().andHomeworkIdEqualTo(homeworkId);
		return stuHwQuestionMapperExt.selectByExample(example);
	}

}
