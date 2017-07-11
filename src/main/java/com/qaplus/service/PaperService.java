package com.qaplus.service;

import java.util.List;

import com.qaplus.constant.PaperStatus;
import com.qaplus.entity.QaPaper;
import com.qaplus.entity.vo.ExamQuestionVo;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.PaperVo;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.StuStartExam;

public interface PaperService {
	PaperVo makePaper(PaperVo paper);

	List<ExamQuestionVo> preview(Long paperId);

	StuStartExam startExam(Long paperId,Long stuId);
	
	List<QaPaper> queryAllEffectPaper();
	
	void update(QaPaper paper);

	StuStartExam endExam(StuStartExam exam);
	
	//获取试卷的平均分
	int getPaperAvg(Long paperId);
	
	List<QaPaper> queryAll();

	ResponseData<PaperVo> queryAllPaperForPage(Page page, String[] categorys, String title, Long my,String[] status);
	
	PaperStatus generatePaperStatus(QaPaper paper);
	
	StuStartExam queryStuPaper(Long paperId,Long stuId);

	StuStartExam paperQuestions(Long paperId);

	List<PaperVo> queryCurrStuPapers();
	
	QaPaper queryById(Long id);

	void deletePaperById(Long paperId);

	void publish(Long paperId, Integer examLong, String examTime, String stuIds, Long classId);

}
