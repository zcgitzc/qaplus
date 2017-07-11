package com.qaplus.utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCorrect {
	// 检测用户名格式是否合法
	private static String c_name = "^(?![0-9]+$)[a-zA-Z0-9]{6,20}$";
	// 检测邮箱格式是否合法
	private static String c_email = "^\\w+([\\-_+\\.]\\w+)*@\\w+([\\-_\\.]\\w+)*\\.\\w+([\\-_\\.]\\w+)*$";
	// 检测手机格式是否合法
	// ^(1(([35][0-9])|(47)|[8][0126789]))\\d{8}$
	private static String c_mobile = "^(1(([35][0-9])|(47)|[8][0126789]))\\d{8}$";
	// 检测密码常规密码合法性
	private static String c_password = "^[a-zA-Z0-9]{6,22}$";
	// 检测手机密码合法性
	private static String c_mopassword = "^[a-zA-Z0-9]{6}$";
	// 检测用户昵称格式是否合法（数字英文汉字)
	private static String c_nicename = "^[0-9a-zA-Z_\\u4e00-\\u9fa5]{2,15}$";
	// 只能输入5-20个以字母开头、可带数字、"_"、"."的字串
	private static String c_string = "^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$";
	// 不能为空
	private static String c_notnull = "^[^.]+$";
	// 日期格式yyyy-MM-dd或yyyy/MM/dd
	private static String c_datebyYd = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\-\\s]?((((0?[13578])|(1[02]))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\-\\s]?((((0?[13578])|(1[02]))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\-\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
	// 日期格式yyyy-MM-dd hh:mm:ss或yyyy/MM/dd hh:mm:ss
	private static String c_datebyYs = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
	//检验URL是否合法 
	private static String c_url="^[a-zA-z]+://[^\\s]*";
	/**
	 * 第一个参数表示需要需要验证的字符串
	 * 第二个参数表示正则表达式
	 */
	public static boolean check(String f,String mf) {
		if (f != null) {
			Pattern pattern = Pattern.compile(mf);
			Matcher matcher = pattern.matcher(f);
			return matcher.matches();
		} else {
			return false;
		}
	}
	public static boolean checkUrl(String url){
		return check(url, c_url);
	}
	
	// 检测用户名格式是否合法
	public static boolean checkUserName(String username) {
		return check(username, c_name);
	}

	// 检测邮箱格式是否合法
	public static boolean checkEmail(String email) {
		return check(email, c_email);
	}

	// 检测手机格式是否合法
	// ^(1(([35][0-9])|(47)|[8][0126789]))\\d{8}$
	public static boolean checkMobile(String mobile) {
		return check(mobile, c_mobile);
	}

	// 检测密码常规密码合法性
	public static boolean checkPassword(String pass) {
		return check(pass, c_password);
	}

	// 检测手机密码合法性
	public static boolean checkMoPassword(String mopass) {
		return check(mopass, c_mopassword);
	}

	// 检测用户昵称格式是否合法（数字英文汉字）
	public static boolean checkNicename(String nicename) {
		return check(nicename, c_nicename);
	}

	// 只能输入5-20个以字母开头、可带数字、"_"、"."的字串
	public static boolean checkString(String str) {
		return check(str, c_string);
	}

	// 不能为空
	public static boolean checkNull(String str) {
		return check(str, c_notnull);
	}
		
	// 日期格式yyyy-MM-dd或yyyy/MM/dd
	public static boolean checkDateByYd(String date) {
		return check(date,c_datebyYd);
	}
		
	// 日期格式yyyy-MM-dd hh:mm:ss或yyyy/MM/dd hh:mm:ss
	public static boolean checkDateByYs(String date){
		return check(date, c_datebyYs);
	}
}
