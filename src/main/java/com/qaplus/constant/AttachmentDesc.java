package com.qaplus.constant;

public enum AttachmentDesc {

	STU_QUESTION_ATTACH("STU_QUESTION_ATTACH", "学生问题附件"),

	QUESTION_COUNT_TOO_LARGE("QUESTION_COUNT_TOO_LARGE", "每天只能提三个问题，别贪心，自己思考一下，也让老师休息一下，明日再战    ^_^  "),;

	private String value;
	private String desc;

	AttachmentDesc(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
