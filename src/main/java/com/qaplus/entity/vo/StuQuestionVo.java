package com.qaplus.entity.vo;

import com.qaplus.entity.QaSQuestion;

public class StuQuestionVo extends QaSQuestion{
    private String attachmentPath;

    private String attachmentName;

    private String attachmentRealName;

    private String attachmentDesc;

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentRealName() {
		return attachmentRealName;
	}

	public void setAttachmentRealName(String attachmentRealName) {
		this.attachmentRealName = attachmentRealName;
	}

	public String getAttachmentDesc() {
		return attachmentDesc;
	}

	public void setAttachmentDesc(String attachmentDesc) {
		this.attachmentDesc = attachmentDesc;
	}
    
    
}
