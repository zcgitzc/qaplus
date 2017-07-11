package com.qaplus.constant;


/**
 * 任务内容
 * @author wb-zc189961
 *
 */
public enum TaskContent {
 
	USER_REGISTER("USER_REGISTER", "用户注册"),
	
	TEA_SOLVE_QUESTION("TEA_SOLVE_QUESTION", "老师回答问题"),
	;

	String value;
	String desc;

	TaskContent(String value, String desc) {
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
