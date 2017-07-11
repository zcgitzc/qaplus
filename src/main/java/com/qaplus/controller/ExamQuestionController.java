package com.qaplus.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qaplus.constant.BaseVoid;
import com.qaplus.entity.QaExamQuestion;
import com.qaplus.entity.vo.ExamQuestionVo;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.service.ExamQuestionService;
import com.qaplus.service.UserService;

@Controller
@RequestMapping("examQuestion")
public class ExamQuestionController extends SuperController {
	@Resource
	private ExamQuestionService examQuestionService;
	@Resource
	private UserService userService;

	@RequestMapping("queryAllForPage")
	public ResponseData<ExamQuestionVo> queryAllForPage(String title, String[] categorys, Page page) {
		return examQuestionService.queryAllForPage(title, categorys, page);
	}

	@RequestMapping("updateById")
	public BaseVoid updateById(QaExamQuestion question) {
		examQuestionService.updateById(question);
		return new BaseVoid();
	}

	@RequestMapping("deleteById")
	public BaseVoid deleteById(Long id) {
		examQuestionService.deleteById(id);
		return new BaseVoid();
	}

	@RequestMapping("addExamQuestion")
	public BaseVoid addExamQuestion(ExamQuestionVo examQuestionVo) {
		examQuestionService.addExamQuestion(examQuestionVo);
		return new BaseVoid();
	}

	@RequestMapping("exportExamQuestion")
	public BaseVoid exportExamQuestion(String title, String[] categorys, HttpServletResponse response) {
		examQuestionService.exportExamQuestion(title, categorys, response);
		return new BaseVoid();
	}

	@RequestMapping("downloadExamQuestionTemplate")
	public BaseVoid downloadExamQuestionTemplate(HttpServletResponse response) {
		examQuestionService.downloadExamQuestionTemplate(response);
		return new BaseVoid();
	}

	@RequestMapping("importExamQuestion")
	public BaseVoid importExamQuestion(MultipartHttpServletRequest request) {
		examQuestionService.importExamQuestion(request);
		return new BaseVoid();
	}

	@RequestMapping("queryAllErrorQuestions")
	public List<ExamQuestionVo> queryAllErrorQuestions(String[] categorys){
		return examQuestionService.queryAllErrorQuestions(userService.getCurrUserBySession().getId(),categorys);
	}
	
	@RequestMapping("removeErrorQuestion")
	public BaseVoid removeErrorQuestion(Long questionId){
		examQuestionService.removeErrorQuestion(userService.getCurrUserBySession().getId(),questionId);
		return new BaseVoid();
	}
	
}
