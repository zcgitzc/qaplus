package com.qaplus.utils.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.qaplus.constant.SendMailInfoStatus;
import com.qaplus.entity.QaSendMailInfo;
import com.qaplus.mapper.QaSendMailInfoMapperExt;
import com.qaplus.sql.batch.BatchSupport;
import com.qaplus.sql.batch.MapperIdConstant;
import com.qaplus.utils.VeloctiyTemplateUtil;

/**
 * 邮件发送
 */
public class SendMailUtil {

	private static final Logger log = LoggerFactory.getLogger(SendMailUtil.class);

	private static final String EMAILENCODING = "UTF-8";
	private static JavaMailSender mailSender;
	private static String sender;

	public SendMailUtil() {
		super();
	}

	/**
	 * 简单邮件发送
	 * 
	 * @param messageInfo
	 */
	public static void sendSimpleMail(MailMessageInfo messageInfo) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		String sender2 = messageInfo.getSender();
		if (StringUtils.isEmpty(sender2)) {
			sender2 = sender;
		}
		simpleMessage.setFrom(sender2);
		// 邮件标题
		simpleMessage.setSubject(messageInfo.getTitle());
		// 邮件内容
		simpleMessage.setText(messageInfo.getContent());
		// 设置多个收件人，也可以单独发送给一个人
		simpleMessage.setTo(messageInfo.getReceivers());
		// 发送
		mailSender.send(simpleMessage);
		log.info("mail sended from {}, to {}", sender, Arrays.toString(messageInfo.getReceivers()));
	}

	/**
	 * 获得邮件模板
	 * 
	 * @param templateName
	 * @param vars
	 * @return
	 */
	private static String getContent(String templateName, Map<String, Object> vars) {
		return VeloctiyTemplateUtil.getContent(templateName, vars);
	}

	/**
	 * 带附件的邮件发送
	 * 
	 * @param messageInfo
	 * @throws Exception
	 */
	public static void sendHtmlMail(MailMessageInfo messageInfo) throws Exception {

		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = mailSender.createMimeMessage();

		// multipart模式为true时发送附件 可以设置html格式
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, EMAILENCODING);
		String realSender = messageInfo.getSender();
		if (StringUtils.isEmpty(realSender)) {
			realSender = sender;
		}
		// 设置多个收件人，也可以单独发送给一个人
		messageHelper.setFrom(realSender);
		messageHelper.setTo(messageInfo.getReceivers());
		messageHelper.setSubject(messageInfo.getTitle());

		String content = getContent(messageInfo.getTemplateName(), messageInfo.getVariables());
		log.debug(content);
		messageHelper.setText(content, true);

		// 设置附件信息
		for (Map.Entry<String, String> entry : messageInfo.getAttachmentMaps().entrySet()) {
			String fileName = entry.getKey().toString();
			String filePath = entry.getValue().toString();

			FileSystemResource file = new FileSystemResource(new File(filePath)); // 读取附件
			messageHelper.addAttachment(MimeUtility.encodeWord(fileName), file);
		}
		try {
			mailSender.send(mailMessage);
			// 发送邮件
			sendEmailLog(messageInfo, true, content);
		} catch (Exception e) {
			sendEmailLog(messageInfo, false, content);
		}
	}

	public static void sendEmailLog(MailMessageInfo messageInfo, boolean isSuccess, String content) {
		List<QaSendMailInfo> sendMailInfos = new ArrayList<QaSendMailInfo>(messageInfo.getReceivers().length);
		// 发送邮件
		for (String receiver : messageInfo.getReceivers()) {
			QaSendMailInfo sendMailInfo = new QaSendMailInfo();
			sendMailInfo.setDescription(messageInfo.getDescription());
			sendMailInfo.setMailContent(content);
			sendMailInfo.setReceivers(receiver);
			sendMailInfo.setSender(messageInfo.getSender());
			sendMailInfo.setSourceId(messageInfo.getSourceId());
			sendMailInfo.setSubject(messageInfo.getTitle());
			sendMailInfo.setTemplateName(messageInfo.getTemplateName());
			sendMailInfo.setStatus(isSuccess ? SendMailInfoStatus.SUCCESS.name() : SendMailInfoStatus.FAILURE.name());
			sendMailInfos.add(sendMailInfo);
		}
		BatchSupport.insertBatch(QaSendMailInfoMapperExt.class, MapperIdConstant.INSERT_SELECTIVE.getValue(), sendMailInfos);
		log.info("mail from {}, to {} ,{}", "system", Arrays.toString(messageInfo.getReceivers()), isSuccess);
	}

	@Resource
	public void setMailSender(JavaMailSender mailSender) {
		SendMailUtil.mailSender = mailSender;
	}

	public void setSender(String sender) {
		SendMailUtil.sender = sender;
	}
}
