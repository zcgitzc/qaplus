package com.qaplus.constant;

public enum ErrorCode {

	SUCCESS("SUCCESS", "操作成功"),

	NOT_LOGIN("NOT_LOGIN", "没有登陆"),

	FAUILURE("FAUILURE", "操作失败"),

	PAGE_PARAM_NOT_FOUND("PAGE_PARAM_NOT_FOUND", "分页参数未找到"),

	NOT_DATA_FOUND("NOT_DATA_FOUND", "数据不存在"),

	NO_ATTACHMENT("NO_ATTACHMENT", "不好意思，没有附件"),

	LOGIN_FAIL("LOGIN_FAIL", "登录失败，可能没有注册，或者用户名密码错误"),

	USER_VALIDATE_NULL("LOGIN_VALIDATE_FAIL", "用户名或密码不能为空"),

	USER_VALIDATE_LENGTH("USER_VALIDATE_LENGTH", "密码长度必须为6-22位"), 

	CLASS_NOT_FOUND("CLASS_NOT_FOUND", "没有选择班级"),
	
	DELETE_OLD_FILE_FAIL("DELETE_OLD_FILE_FAIL", "删除原来文件失败"),
	
	GET_PHONE_INFO_FAIL("GET_PHONE_INFO_FAIL", "获取手机号信息失败"),
	
	USERNAME_EXIST("USERNAME_EXIST", "用户已存在"),
	
	USERNAME_VALIDATE("USERNAME_VALIDATE", "用户名可用"),
	
	ALL_QUESTION_SOLVE("ALL_QUESTION_SOLVE", "感谢您这么积极的解决问题，可是没有待解决问题了，您辛苦了，休息一下吧  ^_^"),
	
	QUESTION_COUNT_TOO_LARGE("QUESTION_COUNT_TOO_LARGE", "每天只能提三个问题，别贪心，自己思考一下，也让老师休息一下，明日再战    ^_^  "),;

	private String value;
	private String desc;

	ErrorCode(String value, String desc) {
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
