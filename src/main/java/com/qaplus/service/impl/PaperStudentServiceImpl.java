package com.qaplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.qaplus.constant.CommonBoolean;
import com.qaplus.entity.QaPaperStu;
import com.qaplus.entity.QaPaperStuExample;
import com.qaplus.entity.QaScore;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.vo.UserVo;
import com.qaplus.mapper.QaPaperStuMapperExt;
import com.qaplus.service.PaperStudentService;
import com.qaplus.service.ScoreService;
import com.qaplus.service.UserService;

@Service
public class PaperStudentServiceImpl implements PaperStudentService {
	@Resource
	private QaPaperStuMapperExt paperStuMapperExt;
	@Resource
	private UserService userService;
	@Resource
	private ScoreService scoreService;

	@Override
	public void add(QaPaperStu paperStudent) {
		paperStuMapperExt.insertSelective(paperStudent);
	}

	@Override
	public QaPaperStu queryByPaperIdAndStuId(Long paperId,Long stuId) {
		QaPaperStuExample example = new QaPaperStuExample();
		example.createCriteria().andPaperIdEqualTo(paperId).andStuIdEqualTo(stuId);
		List<QaPaperStu> paperStus = paperStuMapperExt.selectByExample(example);
		return CollectionUtils.isNotEmpty(paperStus) && paperStus.size() > 0 ? paperStus.get(0) : null;
	}

	@Override
	public void update(QaPaperStu paperStudent) {
		paperStuMapperExt.updateByPrimaryKeySelective(paperStudent);
	}

	@Override
	public List<QaPaperStu> queryAllUnSumit(Long paperId) {
		QaPaperStuExample example = new QaPaperStuExample();
		example.createCriteria().andIsSubmitEqualTo(CommonBoolean.N.name());
		List<QaPaperStu> paperStus = paperStuMapperExt.selectByExample(example);
		return paperStus;
	}

	@Override
	public List<QaPaperStu> queryAllByPaperId(Long paperId) {
		QaPaperStuExample example = new QaPaperStuExample();
		example.createCriteria().andPaperIdEqualTo(paperId);
		return paperStuMapperExt.selectByExample(example);
	}

	@Override
	public List<UserVo> queryAllStusByPaperId(Long paperId) {
		List<QaPaperStu> paperStus=this.queryAllByPaperId(paperId);
		List<UserVo> users=new ArrayList<UserVo>(paperStus.size());
		for (QaPaperStu qaPaperStu : paperStus) {
			QaUser user=userService.queryById(qaPaperStu.getStuId());
			UserVo vo=new UserVo();
			BeanUtils.copyProperties(user, vo);
			vo.setExamStatus(qaPaperStu.getExamStatus());
			QaScore score=scoreService.queryByPaperIdAndStuId(paperId,qaPaperStu.getStuId());
			if(score!=null){
				vo.setScore(score.getScore());
			}else {
				vo.setScore(0);
			}
			users.add(vo);
		}
		return users;
	}

}
