package com.qaplus.constant;


public enum SolveType {
	UN_SOLVE("UN_SOLVE", "未解决"),
	 
	SOLVE("SOLVE", "已解决"),;
 

	String value;
	String desc;

	SolveType(String value, String desc) {
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
