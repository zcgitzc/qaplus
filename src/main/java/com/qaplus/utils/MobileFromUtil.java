package com.qaplus.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class MobileFromUtil {
	private static final Logger logger = LoggerFactory.getLogger(MobileFromUtil.class);
	/**
	 * 测试手机号码是来自哪个城市的，利用淘宝的API
	 * 
	 * @param mobileNumber
	 *            手机号码
	 * @return
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws MalformedURLException
	 */
	public static PhoneInfo calcMobileCity(String mobileNumber)
			throws UnsupportedEncodingException {
		String urlString = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="
				+ mobileNumber;
		String result = getJsonContent(urlString);
		result = result.substring(result.indexOf("{"), result.length());
		return JSONObject.parseObject(result, PhoneInfo.class);
	}

	public static String getJsonContent(String urlStr) {
		try {// 获取HttpURLConnection连接对象
			URL url = new URL(urlStr);
			HttpURLConnection httpConn = (HttpURLConnection) url
					.openConnection();
			// 设置连接属性
			httpConn.setConnectTimeout(3000);
			httpConn.setDoInput(true);
			httpConn.setRequestMethod("GET");
			// 获取相应码
			int respCode = httpConn.getResponseCode();
			if (respCode == 200) {
				return ConvertStream2Json(httpConn.getInputStream());
			}
		} catch (MalformedURLException e) {
			logger.error("获取手机信息失败", e);
		} catch (IOException e) {
			logger.error("获取手机信息失败", e);
		}
		return "";
	}

	private static String ConvertStream2Json(InputStream inputStream) {
		// 解决乱码问题
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new InputStreamReader(inputStream,
					"gb2312"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String jsonStr = "";
		// ByteArrayOutputStream相当于内存输出流
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		String line = null;
		// 将输入流转移到内存输出流中
		try {
			while ((line = buffer.readLine()) != null) {
				out.write(line.getBytes());
			}
			// 将内存流转换为字符串
			jsonStr = new String(out.toByteArray());
		} catch (IOException e) {
			logger.error("获取手机信息失败", e);
		}
		return jsonStr;
	}

	public static void main(String[] args) throws Exception {
		String testMobileNumber = "15821285717";
		System.out.println(calcMobileCity(testMobileNumber));;
	}
}