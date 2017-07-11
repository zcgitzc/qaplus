package com.qaplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.constant.CommonBoolean;
import com.qaplus.entity.QaStuHomework;
import com.qaplus.entity.QaStuHwAnswer;
import com.qaplus.entity.QaStuHwDetail;
import com.qaplus.entity.QaStuHwDetailExample;
import com.qaplus.entity.QaTQuestion;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.vo.HomeworkDetailVo;
import com.qaplus.entity.vo.QuestionAndAnswer;
import com.qaplus.entity.vo.RemarkHomeworkVo;
import com.qaplus.entity.vo.TeacherQuestionVo;
import com.qaplus.mapper.QaStuHwDetailMapperExt;
import com.qaplus.service.AttachmentService;
import com.qaplus.service.HomeworkAnswerService;
import com.qaplus.service.HomeworkDetailService;
import com.qaplus.service.HomeworkService;
import com.qaplus.service.QuestionService;
import com.qaplus.service.UserService;

@Service
public class HomeworkDetailServiceImpl implements HomeworkDetailService {
	@Resource 
	private QaStuHwDetailMapperExt homeworkDetailExt;
	@Resource
	private UserService userService;
	@Resource
	private AttachmentService attachmentService;
	@Resource
	private QuestionService questionService;
	@Resource
	private HomeworkAnswerService homeworkAnswerService;
	@Resource
	private HomeworkService homeworkService;
	
	@Override
	public int countMyHomework() {
		QaUser user=userService.getCurrUserBySession();
		QaStuHwDetailExample example =new QaStuHwDetailExample();
		example.createCriteria().andIsCommitEqualTo(CommonBoolean.N.name()).andStuIdEqualTo(user.getId());
		return homeworkDetailExt.countByExample(example);
	}

	@Override
	public int updateByPrimaryKey(QaStuHwDetail detail) {
		return homeworkDetailExt.updateByPrimaryKeySelective(detail);
	}

	@Override
	public QaStuHwDetail selectByHomeworkIdAndStuId(Long homeworkId,Long stuId) {
		QaStuHwDetailExample example =new QaStuHwDetailExample();
		example.createCriteria().andStuIdEqualTo(stuId).andHomeworkIdEqualTo(homeworkId);
		List<QaStuHwDetail> details= homeworkDetailExt.selectByExample(example);
		return details==null?new QaStuHwDetail():details.get(0);
	}

	@Override
	public HomeworkDetailVo queryHomeworkDetail(Long homeworkId) {
		HomeworkDetailVo homeworkDetailVo=new HomeworkDetailVo();
		//查看家庭作业的所有问题
		List<QaTQuestion> questions=questionService.queryHomeworkQuestions(homeworkId);
		homeworkDetailVo.setQuestions(questions);
		//未提交人
		List<QaUser> unCommitUsers=userService.queryUncommitHomeworkUser(homeworkId);
		homeworkDetailVo.setUnCommitUsers(unCommitUsers);
		//提交人
		List<QaUser> commitUsers=userService.queryCommitHomeworkUser(homeworkId);
		homeworkDetailVo.setCommitUsers(commitUsers);
		homeworkDetailVo.setHomeworkId(homeworkId);
		return homeworkDetailVo;
	}

	@Override
	public RemarkHomeworkVo teacherRemarkHomework(Long stuId, Long homeworkId) {
		RemarkHomeworkVo remarkHomework=new RemarkHomeworkVo();
		remarkHomework.setHomeworkId(homeworkId);
		QaUser user=userService.queryById(stuId);
		remarkHomework.setName(user.getName());
		QaStuHomework homework=homeworkService.queryById(homeworkId);
		remarkHomework.setHomeworkName(homework.getTitle());
		List<QaStuHwAnswer> stuAnswers=homeworkAnswerService.queryStuAnswers(stuId, homeworkId);
		List<QuestionAndAnswer> questionAndAnswers=new ArrayList<QuestionAndAnswer>();
		QuestionAndAnswer questionAndAnswer=null;
		for (QaStuHwAnswer qaStuHwAnswer : stuAnswers) {
			questionAndAnswer=new QuestionAndAnswer();
			//学生答案
			questionAndAnswer.setStuHomeworkAnswer(qaStuHwAnswer);
			//老师问题
			TeacherQuestionVo teacherQuestionVo=questionService.queryTeaQuestionById(Long.parseLong(qaStuHwAnswer.getQuestionId().toString()));
			questionAndAnswer.setTeacherQuestionVo(teacherQuestionVo);
			questionAndAnswers.add(questionAndAnswer);
		}
		remarkHomework.setQuestionAndAnswers(questionAndAnswers);
		return remarkHomework;
	}

	

}
