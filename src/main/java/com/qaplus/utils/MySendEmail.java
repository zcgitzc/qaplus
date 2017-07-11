package com.qaplus.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 这个是对的
 * 
 * @author Administrator 最好用的一个版本
 */
public class MySendEmail {
	public static void main(String[] args) {
		try {
			// 用户名
			String userName = "18274948638@163.com";
			// 密码
			String password = "mylzabkdcsehejho";
			// 发邮件所有的服务器名称
			String smtp_server = "smtp.163.com";
			// 发件人
			String from_mail_address = userName;
			// 接收者
			String to_mail_address = "486289410@qq.com";

			// 对用户名和密码认证
			Authenticator auth = new PopupAuthenticator(userName, password);

			// 邮件属性
			Properties mailProps = new Properties();
			// 设置属性
			mailProps.put("mail.smtp.host", smtp_server);
			mailProps.put("mail.smtp.auth", "true");
			mailProps.put("username", userName);
			mailProps.put("password", password);

			// 得到session对象
			Session mailSession = Session.getDefaultInstance(mailProps, auth);
			// 在控制台输出信息调试
			mailSession.setDebug(true);
			// 设置邮件内容
			MimeMessage message = new MimeMessage(mailSession);
			// 来自哪里
			message.setFrom(new InternetAddress(from_mail_address));
			// 接收者
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					to_mail_address));
			// 标题
			message.setSubject("Mail Testw");

			MimeMultipart multi = new MimeMultipart();

			BodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("测试邮件");
			multi.addBodyPart(textBodyPart);

			message.setContent(multi);
			message.saveChanges();

			// 发送
			Transport.send(message);
		} catch (Exception ex) {
			System.err.println("邮件发送失败的原因是：" + ex.getMessage());
			System.err.println("具体的错误原因");
			ex.printStackTrace(System.err);
		}
	}
}

class PopupAuthenticator extends Authenticator {
	private String username;
	private String password;

	public PopupAuthenticator(String username, String pwd) {
		this.username = username;
		this.password = pwd;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(this.username, this.password);
	}
}
