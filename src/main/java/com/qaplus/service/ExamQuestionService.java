package com.qaplus.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qaplus.constant.DiffStage;
import com.qaplus.constant.QCategory;
import com.qaplus.entity.QaExamQuestion;
import com.qaplus.entity.vo.ExamQuestionVo;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;

public interface ExamQuestionService {
	ResponseData<ExamQuestionVo> queryAllForPage(String title, String[] categorys, Page page);

	void updateById(QaExamQuestion question);

	void deleteById(Long id);

	void addExamQuestion(ExamQuestionVo examQuestionVo);
	
	List<QaExamQuestion> queryStageQuestions(DiffStage diffStage,QCategory category);
	
	List<ExamQuestionVo> queryByIds(List<Long> ids);

	void exportExamQuestion(String title, String[] categorys,HttpServletResponse response);
	
	void downloadExamQuestionTemplate(HttpServletResponse response);
	
	void importExamQuestion(MultipartHttpServletRequest request);

	List<ExamQuestionVo> queryAllErrorQuestions(Long stuId,String[] categorys);

	void removeErrorQuestion(Long stuId, Long questionId);
}
