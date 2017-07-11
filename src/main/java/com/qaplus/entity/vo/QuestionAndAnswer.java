package com.qaplus.entity.vo;

import com.qaplus.entity.QaStuHwAnswer;

public class QuestionAndAnswer {
	private QaStuHwAnswer stuHomeworkAnswer;
	private TeacherQuestionVo teacherQuestionVo;

	public QaStuHwAnswer getStuHomeworkAnswer() {
		return stuHomeworkAnswer;
	}

	public void setStuHomeworkAnswer(QaStuHwAnswer stuHomeworkAnswer) {
		this.stuHomeworkAnswer = stuHomeworkAnswer;
	}

	public TeacherQuestionVo getTeacherQuestionVo() {
		return teacherQuestionVo;
	}

	public void setTeacherQuestionVo(TeacherQuestionVo teacherQuestionVo) {
		this.teacherQuestionVo = teacherQuestionVo;
	}

	

}