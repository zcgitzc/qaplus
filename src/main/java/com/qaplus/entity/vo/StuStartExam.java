package com.qaplus.entity.vo;

import java.util.List;

public class StuStartExam {
	private Long paperId;
	private String paperName;
	private String stuName;
	private Long leftTime;
	private List<ExamQuestionVo> questions;
	private int totalScore;
	private int paperTotalScore;

	public Long getPaperId() {
		return paperId;
	}

	public void setPaperId(Long paperId) {
		this.paperId = paperId;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Long getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(Long leftTime) {
		this.leftTime = leftTime;
	}

	public List<ExamQuestionVo> getQuestions() {
		return questions;
	}

	public void setQuestions(List<ExamQuestionVo> questions) {
		this.questions = questions;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getPaperTotalScore() {
		return paperTotalScore;
	}

	public void setPaperTotalScore(int paperTotalScore) {
		this.paperTotalScore = paperTotalScore;
	}
	
	

}
