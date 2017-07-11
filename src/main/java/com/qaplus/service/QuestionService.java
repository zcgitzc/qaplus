package com.qaplus.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qaplus.entity.QaSQuestion;
import com.qaplus.entity.QaTQuestion;
import com.qaplus.entity.cond.QueryQuestionCond;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.StuQuestionVo;
import com.qaplus.entity.vo.TeacherQuestionVo;

public interface QuestionService {

	/** 搜索老师、学生问题 **/
	ResponseData<QaSQuestion> querySQuestionForPage(Page page,QueryQuestionCond cond);
	
	ResponseData<QaTQuestion> queryTQuestionForPage(Page page,QueryQuestionCond cond);
	
	void exportTQuestion(QueryQuestionCond cond,HttpServletResponse response);
	
	void importTQuestion(MultipartHttpServletRequest request);
	
	void downloadTQuestionTemplate(HttpServletResponse response);
	
	/** 查询老师、学生问题 **/
	StuQuestionVo queryStuQuestionById(Long id);
	
	TeacherQuestionVo queryTeaQuestionById(Long id);
	
	/** 老师问题及问题答案附件信息 **/
	TeacherQuestionVo queryTeaAnswerById(Long id);
	
	/** 修改、删除   老师、学生问题 **/
	void updateStuQuestion(QaSQuestion question);
	
	void updateTeaQuestion(QaTQuestion question);
	
	void deleteStuQuestion(QaSQuestion question);
	
	void deleteTeaQuestion(QaTQuestion question);
	
	void solveQuestion(QaSQuestion question);
	
	/** 学生问题件解决情况  图表显示 **/
	List<Map<Object, Object>> queryForSolve();
	
	List<Map<Object, Object>> queryForCategory();
	
	List<Map<Object, Object>>  queryForDate();
	
	Map<Object, Object> queryQuestionCountOneDay(String date,Long userId);
	
	/** 查询没有解决的问题 **/
	List<QaSQuestion> queryUnsolveQuestion(Long id);
	
	/** 查询一个没有解决的问题 **/
	QaSQuestion queryMyAUnSovlve();
	
	/** 查询我的问题 **/
	int countAllMyQuestion();
	
	/** 添加老师、学生问题 **/
	void addStuQuestion(QaSQuestion question);
	
	void addTeacherQuestion(QaTQuestion question);

	List<QaTQuestion> queryTeaQuestionByIds(Long[] ids);
	
	/** 查看家庭作业的所有问题 **/
	List<QaTQuestion> queryMyHomeworkQuestion(Long homeworkId);

	/** 查询家庭作业关联的教师问题 **/
	List<QaTQuestion> queryHomeworkQuestions(Long homeworkId);

	void markSolved(Long id);

}
