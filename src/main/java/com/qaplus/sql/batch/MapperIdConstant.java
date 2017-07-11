package com.qaplus.sql.batch;

public enum MapperIdConstant {
	
	INSERT_SELECTIVE("insertSelective"), 
	DELETE_BY_PRIMARYKEY("deleteByPrimaryKey"),
	UPDATE_BY_PRIMARYKEY_SELECTIVE("updateByPrimaryKeySelective"), ;

	MapperIdConstant(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
