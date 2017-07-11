package com.qaplus.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qaplus.constant.BaseVoid;
import com.qaplus.entity.vo.ExamQuestionVo;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.PaperVo;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.StuStartExam;
import com.qaplus.entity.vo.UserVo;
import com.qaplus.service.PaperService;
import com.qaplus.service.PaperStudentService;
import com.qaplus.service.UserService;

@Controller
@RequestMapping("paper")
public class PaperController extends SuperController {
	@Resource
	private PaperService paperService;
	@Resource
	private PaperStudentService paperStudentService;
	@Resource
	private UserService userService;
	
	@RequestMapping("makePaper")
	public PaperVo makePaper(PaperVo paper) {
		return paperService.makePaper(paper);
	}

	@RequestMapping("preview")
	public List<ExamQuestionVo> preview(Long paperId) {
		return paperService.preview(paperId);
	}

	@RequestMapping("startExam")
	public StuStartExam startExam(Long paperId) {
		Long userId = userService.getCurrUserBySession().getId();
		return paperService.startExam(paperId,userId);
	}

	@RequestMapping("endExam")
	public StuStartExam endExam(@RequestBody StuStartExam exam) {
		return paperService.endExam(exam);
	}
	
	@RequestMapping("queryAllPaperForPage")
	public ResponseData<PaperVo> queryAllPaperForPage(Page page,String[] categorys,String title,Long my,String[] status) {
		return paperService.queryAllPaperForPage(page,categorys,title,my,status);
	}
	
	@RequestMapping("queryAllStusByPaperId")
	public List<UserVo> queryAllStusByPaperId(Long paperId) {
		return paperStudentService.queryAllStusByPaperId(paperId);
	}
	
	@RequestMapping("teaRemarkPaper")
	public StuStartExam teaRemarkPaper(Long paperId,Long stuId) {
		return paperService.queryStuPaper(paperId,stuId);
	}

	@RequestMapping("paperQuestions")
	public StuStartExam paperQuestions(Long paperId) {
		return paperService.paperQuestions(paperId);
	}
	
	@RequestMapping("queryStuPapers")
	public List<PaperVo> queryStuPapers(){
		return paperService.queryCurrStuPapers();
	}
	
	@RequestMapping("deletePaperById")
	public BaseVoid deletePaperById(Long paperId){
		paperService.deletePaperById(paperId);
		return new BaseVoid();
	}
	
	@RequestMapping("publish")
	public BaseVoid publish(Long paperId,Integer examLong,String examTime,String stuIds,Long classId){
		paperService.publish(paperId,examLong,examTime,stuIds,classId);
		return new BaseVoid();
	}
	
}
