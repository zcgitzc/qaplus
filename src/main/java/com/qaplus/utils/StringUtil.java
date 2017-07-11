package com.qaplus.utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 字符串工具类<br/>
 * 作用：判断字符串数组是否为空、判断整数数组是否为空、将对象数组转换为字符串数组
 * 
 * @author zc
 *
 */
public class StringUtil {
	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

	private static StringUtil singleton;

	private StringUtil() {
	}

	public static StringUtil getInstance() {
		if (singleton == null) {
			singleton = new StringUtil();
		}
		return singleton;
	}

	/**
	 * 是不是中文
	 * @param s
	 * @return
	 */
	public static boolean isChineseWord(char s) {
		boolean trueOrFalse = true;
		String t = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_+='\";{}*&%$#@!/`~\\:,.[]()|0123456789";
		String tt = " ";
		char c = tt.charAt(0);
		int charInt = (int) c;
		for (int i = 0; i < t.length(); i++) {
			if (s == t.charAt(i) || charInt == (int) s) {

				trueOrFalse = false;
				break;
			}
		}

		return trueOrFalse;
	}

	/**
	 * 得到每个的第一天
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
		return new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());

	}

	/**
	 * 得到每个月的最后一天
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);
		return new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());

	}

	/**
	 * 判断字符串数组是否为空对象或者是空字符
	 * 
	 * @param strings
	 *            字符串数组
	 * @return true/false
	 */
	public static boolean judgeStringIfNull(String[] strings) {
		int j = 0;
		if (strings.length > 0) {
			for (int i = 0; i < strings.length; i++) {
				if (strings[i] == null || strings[i].equals("")) {
					j += 1;
				}
			}
		} else {
			j += 1;
		}

		if (j <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断int数组内容是否有0存在
	 * 
	 * @param ints
	 * @return
	 */
	public static boolean judgeIntIfNull(int[] ints) {
		int j = 0;
		if (ints.length > 0) {
			for (int i = 0; i < ints.length; i++) {
				if (ints[i] == 0) {
					j += 1;
				}
			}
		} else {
			j += 1;
		}

		if (j <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 将对象数组转换为字符串数组 eg: new Object[]{2.3,3.4} --> new String[]{"2.3",3.4}
	 * 对象数组只能放Integer、Long、Float、Double
	 * 
	 * @param objs
	 * @return String[]
	 */
	public static String[] objstostrs(Object[] objs) {
		String[] strings = new String[objs.length];
		if (objs.length > 0) {
			for (int i = 0; i < objs.length; i++) {
				if (objs[i] instanceof Integer || objs[i] instanceof Long
						|| objs[i] instanceof Float
						|| objs[i] instanceof Double) {
					strings[i] = String.valueOf(objs[i]);
				} else {
					if (objs[i] == null || objs[i].equals("")) {
						strings[i] = "";
					} else {
						strings[i] = (String) objs[i];
					}
				}
			}
		}
		return strings;
	}

	public static int doubleForChineseWord(StringBuffer s) {
		int lengthSouble = 0;
		for (int i = 0; i < s.length(); i++) {
			char tempChar = s.charAt(i);
			if (isChineseWord(tempChar)) {
				lengthSouble++;
				lengthSouble++;
			} else {
				lengthSouble++;
			}
		}
		return lengthSouble;
	}

	/**
	 * @param obj
	 * @param normalLength
	 * @return
	 */
	public static String addSpaceForAll(Object obj, int normalLength) {
		String spaceSigle = " ";
		StringBuffer s = new StringBuffer(obj.toString());
		int lengthS = doubleForChineseWord(s);

		if (null == s || "null".equals(s))
			return "";
		else {
			if (lengthS < normalLength) {
				for (int i = 1; i <= (normalLength - lengthS); i++) {
					s.append(spaceSigle);
				}
			} else if (lengthS > normalLength) {
				StringBuffer str = new StringBuffer();
				for (int i = 0; i < s.length(); i++) {
					str.append(s.charAt(i));
					int length_str = doubleForChineseWord(str);
					if (length_str == normalLength - 1) {
						str.append(spaceSigle);
						break;
					} else if (length_str == normalLength)
						break;
				}
				s = str;
			}
		}

		return s.toString();
	}
	
	/**
	 * 字符编码
	 * @param oldEncoding
	 * @param targetEncoding
	 * @param param
	 * @return
	 */
	public static String characterEncoding(String oldEncoding,String targetEncoding,String param){
		if(param==null){
			return null;
		}
		String result="";
		try {
			result = new String(param.getBytes(oldEncoding),targetEncoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
