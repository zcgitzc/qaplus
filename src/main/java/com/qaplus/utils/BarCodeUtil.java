package com.qaplus.utils;

import java.util.Hashtable;
public class BarCodeUtil {

	/**
	 * 条形码转换
	 * @param s 条形码内容
	 * @param width 宽度
	 * @param height 高度
	 * @return 条形码的html
	 */
	public static String get39(String s, int width, int height) {
        Hashtable<Character, String> hsHashtable = new Hashtable<Character, String>();
        hsHashtable.put('A', "110101001011");
        hsHashtable.put('B', "101101001011");
        hsHashtable.put('C', "110110100101");
        hsHashtable.put('D', "101011001011");
        hsHashtable.put('E', "110101100101");
        hsHashtable.put('F', "101101100101");
        hsHashtable.put('G', "101010011011");
        hsHashtable.put('H', "110101001101");
        hsHashtable.put('I', "101101001101");
        hsHashtable.put('J', "101011001101");
        hsHashtable.put('K', "110101010011");
        hsHashtable.put('L', "101101010011");
        hsHashtable.put('M', "110110101001");
        hsHashtable.put('N', "101011010011");
        hsHashtable.put('O', "110101101001");
        hsHashtable.put('P', "101101101001");
        hsHashtable.put('Q', "101010110011");
        hsHashtable.put('R', "110101011001");
        hsHashtable.put('S', "101101011001");
        hsHashtable.put('T', "101011011001");
        hsHashtable.put('U', "110010101011");
        hsHashtable.put('V', "100110101011");
        hsHashtable.put('W', "110011010101");
        hsHashtable.put('X', "100101101011");
        hsHashtable.put('Y', "110010110101");
        hsHashtable.put('Z', "100110110101");
        hsHashtable.put('0', "101001101101");
        hsHashtable.put('1', "110100101011");
        hsHashtable.put('2', "101100101011");
        hsHashtable.put('3', "110110010101");
        hsHashtable.put('4', "101001101011");
        hsHashtable.put('5', "110100110101");
        hsHashtable.put('6', "101100110101");
        hsHashtable.put('7', "101001011011");
        hsHashtable.put('8', "110100101101");
        hsHashtable.put('9', "101100101101");
        hsHashtable.put('+', "100101001001");
        hsHashtable.put('-', "100101011011");
        hsHashtable.put('*', "100101101101");
        hsHashtable.put('/', "100100101001");
        hsHashtable.put('%', "101001001001");
        hsHashtable.put('$', "100100100101");
        hsHashtable.put('.', "110010101101");
        hsHashtable.put(' ', "100110101101");
        s = "*" + s.toUpperCase() + "*";
        StringBuffer result_bin = new StringBuffer();// 二进制串
        char[] sCharArray = s.toCharArray();
        for (char sChar : sCharArray) {
            result_bin.append(hsHashtable.get(sChar)).append("0");
        }

        String color = ""; // 颜色
        StringBuffer result_html = new StringBuffer();
        for (char c : result_bin.toString().toCharArray()) {
            color = c == '0' ? "#FFFFFF" : "#000000";
            result_html.append("<div style=\"width:" + width + "px;height:" + height + "px;float:left;background:"
                               + color + ";\"></div>");
        }
        result_html.append("<div style=\"clear:both\"></div>");
        int len = "100101101101".toString().length();
        for (char sChar : sCharArray) {
            result_html.append("<div style=\"width:" + (width * (len + 1))
                               + "px;float:left;color:#000000;text-align:center;\">" + sChar + "</div>");
        }
        result_html.append("<div style=\"clear:both\"></div>");
        StringBuffer resBuffer = new StringBuffer();
        resBuffer.append("<div style=\"background:#FFFFFF;padding:5px;font-size:").append(width * 8).append("px;font-family:'楷体';\">").append(result_html.toString()).append("</div>");
        return resBuffer.toString();
    }

    public static void main(String[] args) {
         System.out.println(get39("PN115265", 2, 60));
    }
}
