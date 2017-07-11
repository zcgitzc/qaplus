package com.qaplus.utils;

public class LongUtil {

	public static boolean isNotNull(Long num) {
		return num != null && num != 0 ? true : false;
	}

	public static boolean isNull(Long num) {
		return num == null || num == 0 ? true : false;
	}

}
