package com.qaplus.utils.mail;

import java.util.HashMap;
import java.util.Map;

public class MailMessageInfo {
	private Long sourceId;
	private String title;
	private String content;
	private String templateName;
	private String sender;
	private String[] receivers;
	private String description;
	private Map<String, String> attachmentMaps = new HashMap<String, String>();
	private Map<String, Object> variables = new HashMap<String, Object>(); // 填充模板集合

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String[] getReceivers() {
		return receivers;
	}

	public void setReceivers(String[] receivers) {
		this.receivers = receivers;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Map<String, String> getAttachmentMaps() {
		return attachmentMaps;
	}

	public void setAttachmentMaps(Map<String, String> attachmentMaps) {
		this.attachmentMaps = attachmentMaps;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}

	public Map<String, Object> getVariables() {
		return this.variables;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
