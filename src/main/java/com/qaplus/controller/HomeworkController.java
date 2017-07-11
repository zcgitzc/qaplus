package com.qaplus.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qaplus.constant.BaseVoid;
import com.qaplus.entity.QaStuHomework;
import com.qaplus.entity.vo.HomeworkDetailVo;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.RemarkHomeworkVo;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.StuHomeworkVo;
import com.qaplus.service.HomeworkAnswerService;
import com.qaplus.service.HomeworkDetailService;
import com.qaplus.service.HomeworkService;

@Controller
@RequestMapping("homework")
public class HomeworkController extends SuperController {

	@Resource
	private HomeworkService homeworkService;
	@Resource
	private HomeworkDetailService homeworkDetailService;
	@Resource
	private HomeworkAnswerService homeworkAnswerService;
	/**
	 * 布置家庭作业
	 * 
	 * @param homework
	 * @param stuIds
	 *            布置给哪些学生
	 * @param ids
	 *            哪些问题
	 * @return
	 */
	@RequestMapping("add_homework")
	public BaseVoid addHomework(String title, String commitDate, String stuIds, String ids) {
		homeworkService.addHomework(title, commitDate, stuIds, ids);
		return new BaseVoid();
	}

	@RequestMapping("select_my_homework")
	public List<StuHomeworkVo> selectMyHomework(String title, String commitDate, String stuIds, String ids) {
		return homeworkService.selectMyHomework();
	}

	@RequestMapping("query_homework")
	public ResponseData<QaStuHomework> queryHomework(Page page, QaStuHomework homework) {
		return homeworkService.queryHomeworkForPage(homework, page);
	}

	@RequestMapping("delete_homework")
	public BaseVoid deleteHomework(Long id) {
		homeworkService.deleteHomework(id);
		return new BaseVoid();
	}
	
	@RequestMapping("homework_answer")
	public BaseVoid answerHomework(Long homeworkId, Long questionId, String commitContent, Long attachmentId, String finishHomework) {
		homeworkAnswerService.answerHomework(homeworkId, questionId, commitContent, attachmentId, finishHomework);
		return new BaseVoid();
	}
	@RequestMapping("count_my_homework")
	public int countMyHomework() {
		return homeworkDetailService.countMyHomework();
	}
	
	@RequestMapping("queryHomeworkDetail")
	public HomeworkDetailVo queryHomeworkDetail(Long homeworkId){
		return homeworkDetailService.queryHomeworkDetail(homeworkId);
	}
	
	@RequestMapping("teacherRemarkHomework")
	public RemarkHomeworkVo teacherRemarkHomework(Long stuId,Long homeworkId){
		return homeworkDetailService.teacherRemarkHomework(stuId,homeworkId);
	}
	
	@RequestMapping("teacherUpdateRemark")
	public BaseVoid teacherUpdateRemark(Long id,String remarkContent){
		homeworkAnswerService.teacherUpdateRemark(id,remarkContent);
		return new BaseVoid();
	}
	
	
}
