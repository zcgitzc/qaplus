package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaScore;
import com.qaplus.entity.vo.ScoreVo;

public interface ScoreService {
	// 修改学生分数
	void updateStuPaperScore(Long paperId, Long stuId, int score);

	// 添加分数
	void add(QaScore score);

	// 某个学生，试卷的分数
	QaScore queryByPaperIdAndStuId(Long paperId, Long stuId);

	// 前三名
	List<QaScore> queryTopThree(Long paperId);

	// 查看试卷的分数
	List<QaScore> queryAllByPaperId(Long paperId);

	// 查看当前学生的分数
	List<ScoreVo> queryStuScores(String title);
}
