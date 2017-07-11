package com.qaplus.constant;

import java.io.File;

public enum Common {

	PROJECT_NAME("qaplus", "项目名称"),

	CURRENT_OPERATOR("CURRENT_OPERATOR", "当前登入者"),

	SUCCESS("SUCCESS", "操作成功"),

	IMG_FILE_SUFFIX(".png", "图片后缀名"),

	ZIP_FILE_SUFFIX(".zip", "压缩文件后缀名"),

	UPLOAD_FILE_DIR("upload", "文件上传的文件夹名称"),

	TEMP_ZIP_DIR("temp_zip", "临时压缩包存放的文件夹名称"),
	
	TEMP_FILE_DIR("temp_file", "临时压缩包存放的文件夹名称"),

	FILE_PATH(Thread.currentThread().getContextClassLoader().getResource("").getPath() + UPLOAD_FILE_DIR.getValue() + File.separator, "文件路劲"),

	TEMP_ZIP_PATH(Thread.currentThread().getContextClassLoader().getResource("").getPath() + UPLOAD_FILE_DIR.getValue() + File.separator + TEMP_ZIP_DIR.getValue() + File.separator, "文件路劲"),

	TEMP_FILE_PATH(Thread.currentThread().getContextClassLoader().getResource("").getPath() + UPLOAD_FILE_DIR.getValue() + File.separator + TEMP_FILE_DIR.getValue() + File.separator, "文件路劲"),
	
	LOGIN_COOKIE("LOGIN_COOKIE", "登录cookie"),

	FAILURE("FAILURE", "操作失败"), ;

	String value;
	String desc;

	Common(String value, String desc) {
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
