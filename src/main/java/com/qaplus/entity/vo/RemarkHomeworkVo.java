package com.qaplus.entity.vo;

import java.util.List;

public class RemarkHomeworkVo {
	private Long homeworkId;
	private String homeworkName;
	private String name;
	private List<QuestionAndAnswer> questionAndAnswers;
	
	public Long getHomeworkId() {
		return homeworkId;
	}
	public void setHomeworkId(Long homeworkId) {
		this.homeworkId = homeworkId;
	}
	public String getHomeworkName() {
		return homeworkName;
	}
	public void setHomeworkName(String homeworkName) {
		this.homeworkName = homeworkName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<QuestionAndAnswer> getQuestionAndAnswers() {
		return questionAndAnswers;
	}
	public void setQuestionAndAnswers(List<QuestionAndAnswer> questionAndAnswers) {
		this.questionAndAnswers = questionAndAnswers;
	}
	
}
