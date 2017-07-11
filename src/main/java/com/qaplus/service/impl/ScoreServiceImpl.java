package com.qaplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.qaplus.constant.QCategory;
import com.qaplus.entity.QaPaper;
import com.qaplus.entity.QaScore;
import com.qaplus.entity.QaScoreExample;
import com.qaplus.entity.vo.ScoreVo;
import com.qaplus.mapper.QaScoreMapperExt;
import com.qaplus.service.PaperService;
import com.qaplus.service.ScoreService;
import com.qaplus.service.UserService;

@Service
public class ScoreServiceImpl implements ScoreService {
	@Resource
	private QaScoreMapperExt scoreMapperExt;
	@Resource
	private UserService userService;
	@Resource
	private PaperService paperService;

	@Override
	public void updateStuPaperScore(Long paperId, Long stuId,int score) {
		scoreMapperExt.updateStuPaperScore(paperId, stuId, score);
	}

	@Override
	public void add(QaScore score) {
		scoreMapperExt.insertSelective(score);
	}

	@Override
	public QaScore queryByPaperIdAndStuId(Long paperId, Long stuId) {
		QaScoreExample example = new QaScoreExample();
		example.createCriteria().andPaperIdEqualTo(paperId).andStuIdEqualTo(stuId);
		List<QaScore> scores = scoreMapperExt.selectByExample(example);
		return CollectionUtils.isNotEmpty(scores) && scores.size() > 0 ? scores.get(0) : null;
	}

	@Override
	public List<QaScore> queryTopThree(Long paperId) {
		return scoreMapperExt.queryTopThree(paperId);
	}

	@Override
	public List<QaScore> queryAllByPaperId(Long paperId) {
		QaScoreExample example = new QaScoreExample();
		example.createCriteria().andPaperIdEqualTo(paperId);
		return scoreMapperExt.selectByExample(example);
	}

	@Override
	public List<ScoreVo> queryStuScores(String title) {
		Long stuId=userService.getCurrUserBySession().getId();
		QaScoreExample example=new QaScoreExample();
		example.createCriteria().andStuIdEqualTo(stuId);
		List<QaScore> scores=scoreMapperExt.selectByExample(example);
		
		List<ScoreVo> result=new ArrayList<ScoreVo>(scores.size());
		ScoreVo vo=null;
		for (QaScore score : scores) {
			vo=new ScoreVo();
			QaPaper paper=paperService.queryById(score.getPaperId());
			if(paper!=null && paper.getPaperTitle().contains(title)){
				vo.setPaperTitle(paper.getPaperTitle());
				vo.setInvigilateName(userService.queryById(paper.getInvigilatePerson()).getName());
				vo.setPaperPersonName(userService.queryById(paper.getPaperPerson()).getName());
				vo.setPaperCategory(QCategory.valueOf(paper.getPaperCategory()).getDesc());
				vo.setExamDate(paper.getExamDate());
				vo.setTotalScore(paper.getTotalScore());
				vo.setAvgScore(paperService.getPaperAvg(paper.getId()));
				vo.setScore(score.getScore());
				result.add(vo);
			} 
		} 
		return result;
	}

}
