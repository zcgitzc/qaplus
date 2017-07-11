package com.qaplus.constant;


public enum AuditMsgDefault {
	AGREE("AGREE", "同意申请"),
	 
	REJECT("REJECT", "拒绝申请"),;
 

	String value;
	String desc;

	AuditMsgDefault(String value, String desc) {
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
