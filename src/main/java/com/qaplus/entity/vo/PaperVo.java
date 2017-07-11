package com.qaplus.entity.vo;

import com.qaplus.entity.QaPaper;

public class PaperVo extends QaPaper {
	private int easy;
	private int middle;
	private int difficult;
	private String upsetQuestion;
	private String upsetItem;
	// 分配给多个学生做
	private String stuIds;
	// 分配给某个班级做
	private Long classId;
	private String examTime;
	// 出卷人姓名
	private String paperPersonName;
	// 监考人姓名
	private String invigilateName;
	// 试卷平均分
	private int avgScore;
	// 试卷前三名
	private String topThree;

	public int getEasy() {
		return easy;
	}

	public void setEasy(int easy) {
		this.easy = easy;
	}

	public int getMiddle() {
		return middle;
	}

	public void setMiddle(int middle) {
		this.middle = middle;
	}

	public int getDifficult() {
		return difficult;
	}

	public void setDifficult(int difficult) {
		this.difficult = difficult;
	}

	public String getUpsetQuestion() {
		return upsetQuestion;
	}

	public void setUpsetQuestion(String upsetQuestion) {
		this.upsetQuestion = upsetQuestion;
	}

	public String getUpsetItem() {
		return upsetItem;
	}

	public void setUpsetItem(String upsetItem) {
		this.upsetItem = upsetItem;
	}

	public String getStuIds() {
		return stuIds;
	}

	public void setStuIds(String stuIds) {
		this.stuIds = stuIds;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getPaperPersonName() {
		return paperPersonName;
	}

	public void setPaperPersonName(String paperPersonName) {
		this.paperPersonName = paperPersonName;
	}

	public String getInvigilateName() {
		return invigilateName;
	}

	public void setInvigilateName(String invigilateName) {
		this.invigilateName = invigilateName;
	}

	public int getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
	}

	public String getTopThree() {
		return topThree;
	}

	public void setTopThree(String topThree) {
		this.topThree = topThree;
	}

}
