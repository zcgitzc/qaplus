package com.qaplus.utils;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date工具类
 * <dl>
 * <dt>作用:</dt>
 * <dd>1.java.util.Calendar和java.sql.Timestamp的相互转换</dd>
 * <dd>2.得到计算机当前时间</dd>
 * <dd>3.输入的日期(字符串)与当前时间相差的天数</dd>
 * <dd>4.根据日期得到年龄</dd>
 * <dd>5.得到计算机当前时间的第一天日期eg:现在是：2016-02-25 --> 结果：2016-02-01</dd>
 * <dd>6.根据字符串日期得到星期几 格式:2016-02-01 12:02:13</dd>
 * <dd>7.解析字符串(将字符串转换为日期格式)</dd>
 * <dd>8.计算两个日期相差的天数</dd>
 * </dl>
 * 
 * @author zc
 */

public class DateUtil {
	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * 定义常见的时间格式
	 */
	private static String[] dateFormat = { "yyyy-MM-dd HH:mm:ss",
			"yyyy/MM/dd HH:mm:ss", "yyyy年MM月dd日HH时mm分ss秒", "yyyy-MM-dd",
			"yyyy/MM/dd", "yy-MM-dd", "yy/MM/dd", "yyyy年MM月dd日", "HH:mm:ss",
			"yyyyMMddHHmmss", "yyyyMMdd", "yyyy.MM.dd", "yy.MM.dd",
			"yyyy.MM.dd　HH:mm" };

	/**
	 * 将日期格式从 java.util.Calendar 转到 java.sql.Timestamp 格式
	 * 
	 * @param date
	 *            java.util.Calendar 格式表示的日期
	 * @return java.sql.Timestamp 格式表示的日期
	 * 
	 */
	public static Timestamp convUtilCalendarToSqlTimestamp(Calendar date) {
		if (date == null)
			return null;
		else
			return new Timestamp(date.getTimeInMillis());
	}

	/**
	 * 将日期格式从 java.util.Timestamp 转到 java.util.Calendar 格式
	 * 
	 * @param date
	 *            java.sql.Timestamp 格式表示的日期
	 * @return java.util.Calendar 格式表示的日期
	 */
	public static Calendar convSqlTimestampToUtilCalendar(Timestamp date) {
		if (date == null)
			return null;
		else {
			java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			return gc;
		}
	}

	public static String getFirstDayOfMonth(int year, int month) {

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);

		cal.set(Calendar.MONTH, month - 1);

		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
		return new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());

	}

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
	 * 得到计算机当前时间 eg:2016-02-01
	 * 
	 * @return 当前时间
	 */
	public static String getCurrDay() {
		Calendar calendar = Calendar.getInstance();
		Date d = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format(d);
		return s;
	}

	/**
	 * 判断日期和当前时间相差的天数 格式：2016-02-10
	 * 
	 * @param time
	 *            输入的时间
	 * @return 相差的天数
	 */
	public static int getDays(String time) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		long from = 0;
		try {
			from = df.parse(time).getTime();
		} catch (ParseException e) {
			logger.error(String.format("解析为Date格式出错:%s", time), e);
		}
		long to = new Date().getTime();

		long between_days = (to - from) / (1000 * 60 * 60 * 24);
		if (to - from < 0) {
			return Math.abs(Integer.parseInt(String.valueOf(between_days))) + 1;
		} else {
			return Integer.parseInt(String.valueOf(between_days));
		}
	}

	/**
	 * 根据日期得到年龄
	 * 
	 * @param birthday
	 *            生日
	 * @return
	 */
	public static String getAge(String birthday) {
		String result;
		int age;
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String s = df.format(date);

		String[] ss = s.split("-");

		int year = Integer.parseInt(birthday.substring(0, 4));
		int month = Integer.parseInt(birthday.substring(5, 7));
		int day = Integer.parseInt(birthday.substring(8, 10));

		age = Integer.parseInt(ss[0]) - year;
		if (Integer.parseInt(ss[1]) - month > 0) {
			result = age + "";
		} else {
			age = age - 1;
			result = age + "";
		}

		if (Integer.parseInt(ss[1]) - month == 0
				&& Integer.parseInt(ss[2]) - day < 0) {

			age = age - 1;
			result = age + "";
		} else {
			result = age + "";
		}

		if (age == 0) {
			int days = 0;
			days = getDays(birthday);
			if (days >= 30) {
				return days / 30 + "个月";
			} else if (days / 30 == 0 && days >= 7) {
				return days / 7 + "周";
			}
			return day + "天前";
		}
		return result;
	}

	public static int strToInt(String s) {
		int i = Integer.parseInt(s);
		return i;
	}

	public static Date strToDate(String dateString) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			logger.error(String.format("解析为Date格式出错:%s", dateString), e);
		}

		return date;

	}

	/**
	 * 得到计算机当前时间的第一天日期eg:现在是：2016-02-25 --> 结果：2016-02-01
	 * 
	 * @return
	 */
	public static String getFirstDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
		Date d = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format(d);
		return s;
	}

	/**
	 * 根据字符串日期得到星期几 格式:2016-02-01 12:02:13
	 * 
	 * @param dateString
	 * @return 这个时间的星期数
	 * @throws ParseException
	 */
	public static String getWeek(String dateString) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd EE HH:mm:ss");
		String ctime = formatter.format(parseDate(dateString));
		ctime = ctime.substring(ctime.indexOf(" "), ctime.lastIndexOf(" "));
		return ctime;
	}

	/**
	 * 解析一个字符串，形成一个Calendar对象，适应各种不同的日期表示法
	 * 
	 * @param dateStr
	 *            期望解析的字符串，注意，不能传null进去，否则出错
	 * @return 返回解析后的Calendar对象 <br>
	 * <br>
	 *         可输入的日期字串格式如下： <br>
	 *         "yyyy-MM-dd HH:mm:ss", <br>
	 *         "yyyy/MM/dd HH:mm:ss", <br>
	 *         "yyyy年MM月dd日HH时mm分ss秒", <br>
	 *         "yyyy-MM-dd", <br>
	 *         "yyyy/MM/dd", <br>
	 *         "yy-MM-dd", <br>
	 *         "yy/MM/dd", <br>
	 *         "yyyy年MM月dd日", <br>
	 *         "HH:mm:ss", <br>
	 *         "yyyyMMddHHmmss", <br>
	 *         "yyyyMMdd", <br>
	 *         "yyyy.MM.dd", <br>
	 *         "yy.MM.dd"
	 */
	public static Date parseDate(String dateStr) {
		if (dateStr == null || dateStr.trim().length() == 0)
			return null;
		return parseDate(dateStr, 0);
	}

	/**
	 * 计算两个日期相差的天数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long calGapDays(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			return 0;
		}
		return Math.abs((d1.getTime() - d2.getTime()) / (3600 * 24000));
	}

	/**
	 * 内部方法，根据某个索引中的日期格式解析日期
	 * 
	 * @param dateStr
	 *            期望解析的字符串
	 * @param index
	 *            日期格式的索引
	 * 
	 * @return 返回解析结果
	 */
	public static Date parseDate(String dateStr, int index) {
		DateFormat df = null;
		try {
			df = new SimpleDateFormat(dateFormat[index]);
			return df.parse(dateStr);
		} catch (ParseException pe) {
			return parseDate(dateStr, index + 1);
		} catch (ArrayIndexOutOfBoundsException aioe) {
			return null;
		}
	}
}
