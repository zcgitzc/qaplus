package com.qaplus.constant;

public enum JobType {
	STU(1, "在校学生"),

	TEA(2, "在校老师"),
	;

	Integer value;
	String desc;

	JobType(Integer value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
