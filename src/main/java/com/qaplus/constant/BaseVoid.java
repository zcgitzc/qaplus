package com.qaplus.constant;
/**
 * 用于Controller返回一个空的对象，因为如果直接在controller里面返回void 会导致WrapDataResponseBodyAdvice.java 拦截不到
 * @author zc
 *
 */
public class BaseVoid {
	private String voidStr;

	public String getVoidStr() {
		return voidStr;
	}

	public void setVoidStr(String voidStr) {
		this.voidStr = voidStr;
	}
	
	
}
