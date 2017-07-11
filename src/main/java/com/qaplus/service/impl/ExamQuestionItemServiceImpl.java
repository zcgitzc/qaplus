package com.qaplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.qaplus.entity.QaExamQuestionItem;
import com.qaplus.entity.QaExamQuestionItemExample;
import com.qaplus.entity.vo.ExamQuestionItemVo;
import com.qaplus.mapper.QaExamQuestionItemMapperExt;
import com.qaplus.service.ExamQuestionItemService;

@Service
public class ExamQuestionItemServiceImpl implements ExamQuestionItemService {
	@Resource
	private QaExamQuestionItemMapperExt examQuestionItemMapperExt;

	@Override
	public void updateById(QaExamQuestionItem item) {
		examQuestionItemMapperExt.updateByPrimaryKeySelective(item);
	}

	@Override
	public List<ExamQuestionItemVo> queryByExamQuestionId(Long questionId) {
		List<ExamQuestionItemVo> result = new ArrayList<ExamQuestionItemVo>();
		QaExamQuestionItemExample example = new QaExamQuestionItemExample();
		example.createCriteria().andExamQuestionIdEqualTo(questionId);
		List<QaExamQuestionItem> questions = examQuestionItemMapperExt.selectByExample(example);
		ExamQuestionItemVo vo = null;
		for (QaExamQuestionItem qaExamQuestionItem : questions) {
			vo = new ExamQuestionItemVo();
			BeanUtils.copyProperties(qaExamQuestionItem, vo);
			result.add(vo);
		}
		return result;
	}

	@Override
	public void add(QaExamQuestionItem item) {
		examQuestionItemMapperExt.insertSelective(item);
	}

	@Override
	public ExamQuestionItemVo queryById(Long id) {
		ExamQuestionItemVo vo=new ExamQuestionItemVo();
		QaExamQuestionItem questionItem = examQuestionItemMapperExt.selectByPrimaryKey(id);
		BeanUtils.copyProperties(questionItem, vo);
		return vo;
	}

}
