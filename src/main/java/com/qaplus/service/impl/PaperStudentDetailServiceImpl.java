package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.qaplus.entity.QaPaperStuDetail;
import com.qaplus.entity.QaPaperStuDetailExample;
import com.qaplus.mapper.QaPaperStuDetailMapperExt;
import com.qaplus.service.PaperStudentDetailService;

@Service
public class PaperStudentDetailServiceImpl implements PaperStudentDetailService {
	@Resource
	private QaPaperStuDetailMapperExt paperStuDetailMapperExt;

	@Override
	public void add(QaPaperStuDetail paperStudentDetail) {
		paperStuDetailMapperExt.insertSelective(paperStudentDetail);
	}

	@Override
	public QaPaperStuDetail queryByPaperIdAndQuestionId(Long paperId, Long questionId, Long userId) {
		QaPaperStuDetailExample example = new QaPaperStuDetailExample();
		example.createCriteria().andPaperIdEqualTo(paperId).andExamQuestionIdEqualTo(questionId).andStuIdEqualTo(userId);
		List<QaPaperStuDetail> paperStuDetails = paperStuDetailMapperExt.selectByExample(example);
		return CollectionUtils.isNotEmpty(paperStuDetails) && paperStuDetails.size() > 0 ? paperStuDetails.get(0) : null;
	}

	@Override
	public void update(QaPaperStuDetail paperStudentDetail) {
		paperStuDetailMapperExt.updateByPrimaryKeySelective(paperStudentDetail);
	}

	@Override
	public List<QaPaperStuDetail> queryByPaperId(Long paperId) {
		QaPaperStuDetailExample example = new QaPaperStuDetailExample();
		example.createCriteria().andPaperIdEqualTo(paperId);
		return paperStuDetailMapperExt.selectByExample(example);
	}

	@Override
	public List<QaPaperStuDetail> queryByStuIdAndQuestionId(Long stuId,Long qId) {
		QaPaperStuDetailExample example = new QaPaperStuDetailExample();
		example.createCriteria().andStuIdEqualTo(stuId).andExamQuestionIdEqualTo(qId);
		return paperStuDetailMapperExt.selectByExample(example);
	}

}
