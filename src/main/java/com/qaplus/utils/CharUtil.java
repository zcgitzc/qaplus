package com.qaplus.utils;

import java.util.HashMap;
import java.util.Map;

public class CharUtil{
	private static final String ASCII_EXPRESSION= "\\p{ASCII}";
	
	private static final Map<String, String> SPECIALCHARS = new HashMap<String, String>();
	
	static {
		SPECIALCHARS.put("℃", "C");
		SPECIALCHARS.put("“", "\"");
		SPECIALCHARS.put("”", "\"");		
		SPECIALCHARS.put("‘", "\'");
		SPECIALCHARS.put("’", "\'");
		SPECIALCHARS.put("。", ".");
	}
	
	/**
	 * 将字符全角转换成半角
	 * @param c 
	 * @return
	 */
	public static char toDBC(char c) {
		//全角空格是 12288 半角是 32，其他全角字符都比相对应的半角字符 大 65248
		if (c == 12288) {
			c = (char)32;				
		}else if (c> 65280 && c< 65375) {
			c = (char) (c - 65248);
		}		
		return c;
	}
	/**
	 * 将特殊字符转换成需要的字符
	 * @param c 特殊字符
	 * @return 需要的字符
	 */
	public static char specialCharConvertor(char c) {
		if (SPECIALCHARS.containsKey(String.valueOf(c))) {
			return ((String)SPECIALCHARS.get(String.valueOf(c))).charAt(0);			
		}		
		return c;
	}
	/**
	 * 判断字符是否是ASCII码
	 * @param c
	 * @return
	 */
	public static boolean isASCII(char c) {		
		return String.valueOf(c).matches(ASCII_EXPRESSION);
	}
	/**
	 * 验证字符是否符合XML标准字符
	 * 增加过滤掉0x7F非法字符    2012-12-12  lidm
	 * @param c
	 * @return
	 */
	public static boolean xmlValidCharacters(char c) {
		if ((c == 0x9) || (c == 0xA) || (c == 0xD)
                || ((c >= 0x20) && (c <0x7F))
                 || ((c > 0x7F) && (c <= 0xD7FF))
                || ((c >= 0xE000) && (c <= 0xFFFD))
                || ((c >= 0x10000) && (c <= 0x10FFFF)))
			return true;
		else
			return false;
	}
	
	/**
	 * 判断字符是否为中文
	 * @param c 字符
	 * @return true false
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
			    || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
			    || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
			    || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
			    || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
			    || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS)
			return true;
		else
			return false;
	}
	
	
	public static void main(String[] args) {
		String a="sdf方式来试试看附件是代理费";
		for (int i = 0; i < a.length(); i++) {
			char c=a.charAt(i);
			System.out.println(isChinese(c));
		}
		
		System.out.println(specialCharConvertor('”'));
		System.out.println(specialCharConvertor('“'));
		System.out.println(specialCharConvertor('℃'));
		
		
		
		
		
		
	}
}