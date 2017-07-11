package com.qaplus.utils;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *ip地址
 * <dl>
 * <dt>作用:</dt>
 * <dd>1.获取ip地址</dd>
 * </dl>
 * 
 * @author zc
 */
public class IPUtil {
	private static final Logger logger = LoggerFactory.getLogger(IPUtil.class);

	/**
	 * 获取真实的ip地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteHost(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	/**
	 * 获得客户端真实IP地址
	 * 
	 * @param request
	 * @return msg : ip & how to get
	 */
	public static String[] getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		String[] msg = { ip, "(from-X-Forwarded-For)" };
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)
				|| ip.split("[.]").length != 4) {
			ip = request.getHeader("Proxy-Client-IP");
			msg[0] = ip;
			msg[1] = "(from-Proxy-Client-IP)";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)
				|| ip.split("[.]").length != 4) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			msg[0] = ip;
			msg[1] = "(from-WL-Proxy-Client-IP)";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)
				|| ip.split("[.]").length != 4) {
			ip = request.getHeader("HTTP_CLIENT_IP");
			msg[0] = ip;
			msg[1] = "(from-HTTP_CLIENT_IP)";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)
				|| ip.split("[.]").length != 4) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			msg[0] = ip;
			msg[1] = "(from-HTTP_X_FORWARDED_FOR)";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)
				|| ip.split("[.]").length != 4) {
			ip = request.getRemoteAddr();
			msg[0] = ip;
			msg[1] = "(from-request.getRemoteAddr())";
		}
		return msg;
	}
	
}
