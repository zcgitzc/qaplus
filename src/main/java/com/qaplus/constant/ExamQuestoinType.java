package com.qaplus.constant;

public enum ExamQuestoinType {
	RADIO("单选"), CHECKBOX("复选");
	private String desc;

	ExamQuestoinType(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
