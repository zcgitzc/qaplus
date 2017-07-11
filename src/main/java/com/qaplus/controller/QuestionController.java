package com.qaplus.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qaplus.constant.BaseVoid;
import com.qaplus.constant.ErrorCode;
import com.qaplus.entity.QaSQuestion;
import com.qaplus.entity.QaTQuestion;
import com.qaplus.entity.cond.QueryQuestionCond;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.StuQuestionVo;
import com.qaplus.entity.vo.TeacherQuestionVo;
import com.qaplus.service.QuestionService;
import com.qaplus.service.UserService;

/**
 * 学生问题列表
 * 
 * @author wb-zc189961;
 * 
 */
@Controller
@RequestMapping("q")
public class QuestionController extends SuperController {
	@Resource
	private QuestionService questionService;
	@Resource
	private UserService userService;


	@RequestMapping("query_s_question")
	public ResponseData<QaSQuestion> querySQuestionForPage(Page page,QueryQuestionCond cond) {
		try {
			return questionService.querySQuestionForPage(page,cond);
		} catch (Exception e) {
			return new ResponseData<QaSQuestion>(ErrorCode.FAUILURE, ErrorCode.FAUILURE.getDesc(), null, true);
		}
	}
	
	@RequestMapping("query_t_question")
	public ResponseData<QaTQuestion> queryTQuestionForPage(Page page,QueryQuestionCond cond) {
		try {
			return questionService.queryTQuestionForPage(page,cond); 
		} catch (Exception e) {
			return new ResponseData<QaTQuestion>(ErrorCode.FAUILURE, ErrorCode.FAUILURE.getDesc(), null, true);
		}
	}

	@RequestMapping("export_t_question")
	public BaseVoid exportTQuestion(QueryQuestionCond cond,HttpServletResponse response) {
		questionService.exportTQuestion(cond, response);
		return new BaseVoid();
	}
	
	@RequestMapping("import_t_question")
	public BaseVoid importTQuestion(MultipartHttpServletRequest request) {
		questionService.importTQuestion(request);
		return new BaseVoid();
	}
	
	@RequestMapping("download_t_question_template")
	public BaseVoid downloadTQuestionTemplate(HttpServletResponse response) {
		questionService.downloadTQuestionTemplate(response);
		return new BaseVoid();
	}

	@RequestMapping("count_all_my_q")
	public Integer countAllMyQuestion() {
		return questionService.countAllMyQuestion();
	}

	@RequestMapping("query_solve_pie")
	public List<Map<Object, Object>> querySQuestionForPie() {
		return questionService.queryForSolve();
	}

	@RequestMapping("query_category_column")
	public List<Map<Object, Object>> querySQuestionForColumn() {
		return questionService.queryForCategory();
	}

	@RequestMapping("query_date_column")
	public List<Map<Object, Object>> querySQuestionForDate() {
		return questionService.queryForDate();
	}

	@RequestMapping("add_q")
	public BaseVoid addSQuestion(QaSQuestion question) {
		questionService.addStuQuestion(question);
		return new BaseVoid();
	}

	@RequestMapping("add_tea_q")
	public BaseVoid addTeacherQuestion(QaTQuestion question) {
		questionService.addTeacherQuestion(question);
		return new BaseVoid();
	}

	// 查询学生问题
	@RequestMapping("query_stu_q")
	public StuQuestionVo queryStuQuestionById(Long id) {
		return questionService.queryStuQuestionById(id);
	}

	// 查看老师问题及问题附件信息
	@RequestMapping("query_tea_q")
	public TeacherQuestionVo queryTeaQuestionById(Long id) {
		return questionService.queryTeaQuestionById(id);
	}

	// 查看老师问题及答案附件信息
	@RequestMapping("query_tea_a")
	public TeacherQuestionVo queryTeaAnswerById(Long id) {
		return questionService.queryTeaAnswerById(id);
	}

	// 查询家庭作业中的所有问题
	@RequestMapping("query_tea_qs")
	public List<QaTQuestion> queryTeaQuestionByIds(String ids) {
		// TODO 这里写一个工具类
		String[] idsArr = ids.split(",");
		Long[] idss = new Long[idsArr.length];
		for (int i = 0; i < idsArr.length; i++) {
			if (!StringUtils.isEmpty(idsArr[i])) {
				idss[i] = Long.parseLong(idsArr[i]);
			}
		}
		return questionService.queryTeaQuestionByIds(idss);
	}

	// 查询我的家庭作业
	@RequestMapping("query_my_homework_q")
	public List<QaTQuestion> queryMyHomeworkQuestion(Long id) {
		return questionService.queryMyHomeworkQuestion(id);
	}

	// 查询老师没有解决的问题
	@RequestMapping("query_unsolve_q")
	public QaSQuestion queryAUnSovlve(HttpServletRequest request) {
		QaSQuestion question = questionService.queryMyAUnSovlve();
		if (null == question) {
			// TODO 以后处理，这个应该不属于runtimeException ，new BussinessException()
			throw new RuntimeException(ErrorCode.ALL_QUESTION_SOLVE.getDesc());
		} else {
			return question;
		}
	}
	
	@RequestMapping("queryHomeworkQuestions")
	public List<QaTQuestion> queryHomeworkQuestions(Long homeworkId){
		return questionService.queryHomeworkQuestions(homeworkId);
	}
	// 修改学生问题
	@RequestMapping("update_stu_q")
	public BaseVoid updateStuQuestionById(QaSQuestion question) {
		questionService.updateStuQuestion(question);
		return new BaseVoid();
	}

	// 修改老师题库问题
	@RequestMapping("update_tea_q")
	public BaseVoid updateTeacherQuestionById(QaTQuestion question) {
		questionService.updateTeaQuestion(question);
		return new BaseVoid();
	}

	// 删除学生问题
	@RequestMapping("delete_q")
	public BaseVoid deleteStuQuestionById(QaSQuestion question) {
		questionService.deleteStuQuestion(question);
		return new BaseVoid();
	}

	// 删除老师问题
	@RequestMapping("delete_tea_q")
	public BaseVoid deleteTeacherQuestionById(QaTQuestion question) {
		questionService.deleteTeaQuestion(question);
		return new BaseVoid();
	}

	// 回答问题
	@RequestMapping("answer_q")
	public BaseVoid answerQuestion(QaSQuestion question) {
		questionService.solveQuestion(question);
		return new BaseVoid();
	}

	// 回答问题
	@RequestMapping("markSolved")
	public BaseVoid markSolved(Long id) {
		questionService.markSolved(id);
		return new BaseVoid();
	}

}
