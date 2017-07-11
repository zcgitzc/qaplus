package com.qaplus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qaplus.annotation.SystemOperatorLog;
import com.qaplus.constant.CommonBoolean;
import com.qaplus.entity.QaStuHwAnswer;
import com.qaplus.entity.QaStuHwAnswerExample;
import com.qaplus.entity.QaStuHwDetail;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.vo.MarkingHomeworkVo;
import com.qaplus.mapper.QaStuHwAnswerMapperExt;
import com.qaplus.service.HomeworkAnswerService;
import com.qaplus.service.HomeworkDetailService;
import com.qaplus.service.UserService;

@Service
public class HomeworkAnswerServiceImpl implements HomeworkAnswerService {
	@Resource
	private QaStuHwAnswerMapperExt homeworkAnswerMapperExt;
	@Resource
	private UserService userService;
	@Resource
	private HomeworkDetailService homeworkDetailService;

	
	@Override
	public int addHomeworkAnswer(QaStuHwAnswer homeworkAnswer) {
		return homeworkAnswerMapperExt.insertSelective(homeworkAnswer);
	}

	/**
	 * 学生回答家庭作业
	 */
	@Override
	public void answerHomework(Long homeworkId, Long questionId, String commitContent, Long attachmentId, String finishHomework) {
		QaUser user = userService.getCurrUserBySession();
		QaStuHwAnswerExample example = new QaStuHwAnswerExample();
		example.createCriteria().andQuestionIdEqualTo(questionId).andHomeworkIdEqualTo(homeworkId).andStuIdEqualTo(user.getId());
		// 逻辑上只会查出一条数据
		List<QaStuHwAnswer> homeworkAnswers = homeworkAnswerMapperExt.selectByExample(example);
		QaStuHwAnswer homeworkAnswer = homeworkAnswers.get(0);

		if (attachmentId != null && attachmentId != 0) {
			homeworkAnswer.setHasAttachment(CommonBoolean.Y.name());
			homeworkAnswer.setAttachmentId(attachmentId);
		}
		homeworkAnswer.setCommitContent(commitContent);
		homeworkAnswerMapperExt.updateByPrimaryKeySelective(homeworkAnswer);

		if (CommonBoolean.Y.name().equals(finishHomework)) {
			// 修改作业已完成
			QaStuHwDetail detail = homeworkDetailService.selectByHomeworkIdAndStuId(homeworkId, user.getId());
			detail.setIsCommit(CommonBoolean.Y.name());
			homeworkDetailService.updateByPrimaryKey(detail);
		}
	}

	@Override
	public List<MarkingHomeworkVo> markingStuHomework(Long stuId, Long homeworkId) {
		return homeworkAnswerMapperExt.markingStuHomework(stuId, homeworkId);
	}

	@Override
	public List<QaStuHwAnswer> queryStuAnswers(Long stuId, Long homeworkId) {
		QaStuHwAnswerExample example = new QaStuHwAnswerExample();
		example.createCriteria().andStuIdEqualTo(stuId).andHomeworkIdEqualTo(homeworkId);
		return homeworkAnswerMapperExt.selectByExample(example);
	}

	@Override
	public void teacherUpdateRemark(Long id, String remarkContent) {
		QaStuHwAnswer record = new QaStuHwAnswer();
		record.setId(id);
		record.setTeacherRemark(remarkContent);
		homeworkAnswerMapperExt.updateByPrimaryKeySelective(record);
	}

}
