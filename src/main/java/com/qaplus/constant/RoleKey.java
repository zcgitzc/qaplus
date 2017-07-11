package com.qaplus.constant;

public enum RoleKey {

	ROLE_STU("ROLE_STU", "在校学生"),
	
	ROLE_GRAD("ROLE_GRAD", "毕业学生"),
	
	ROLE_TEA("ROLE_TEA", "老师"),
	
	ROLE_PRIN("ROLE_PRIN", "校长"),
	;

	String value;
	String desc;
	
	RoleKey(String value, String desc) {
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
