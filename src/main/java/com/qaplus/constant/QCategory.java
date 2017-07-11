package com.qaplus.constant;

public enum QCategory {
	J2SE("J2SE", "J2SE"),
	
	J2EE("J2EE","J2EE"),
	
	JAVASCRIPT("JAVASCRIPT", "JAVASCRIPT"),
	
	JQUERY("JQUERY","JQUERY"),
	
	FRONT("FRONT","前端"),
	
	DEV_TOOL("DEV_TOOL","开发工具"),
	
	OTHER("OTHER","其他"),
	
	MIX("MIX","综合"),
	;
	

	private String value;
	private String desc;

	QCategory(String value, String desc) {
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
