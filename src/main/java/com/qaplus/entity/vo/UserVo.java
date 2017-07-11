package com.qaplus.entity.vo;

import com.qaplus.entity.QaUser;

public class UserVo extends QaUser {
	private Long[] classIds;
	private String[] classNames;
	// select2搜索使用
	private String text;
	private String examStatus;
	
	private int score;

	public Long[] getClassIds() {
		return classIds;
	}

	public void setClassIds(Long[] classIds) {
		this.classIds = classIds;
	}

	public String[] getClassNames() {
		return classNames;
	}

	public void setClassNames(String[] classNames) {
		this.classNames = classNames;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
