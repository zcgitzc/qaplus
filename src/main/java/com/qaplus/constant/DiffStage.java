package com.qaplus.constant;

public enum DiffStage {
	EASY(1,"简单"), MIDDLE(5,"中等"), DIFFICULT(10,"复杂");

	private int stage;
	private String desc;

	DiffStage(int stage,String desc) {
		this.stage = stage;
		this.desc=desc;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
