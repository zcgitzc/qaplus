package com.qaplus.service;

import java.util.List;

import com.qaplus.entity.QaStuHwAnswer;
import com.qaplus.entity.vo.MarkingHomeworkVo;

public interface HomeworkAnswerService {
	int addHomeworkAnswer(QaStuHwAnswer homeworkAnswer);

	void answerHomework(Long homeworkId, Long questionId, String commitContent, Long attachmentId, String finishHomework);
	
	List<MarkingHomeworkVo> markingStuHomework(Long stuId,Long homeworkId);
	
	List<QaStuHwAnswer> queryStuAnswers(Long stuId,Long homeworkId);

	void teacherUpdateRemark(Long id, String remarkContent);
}
