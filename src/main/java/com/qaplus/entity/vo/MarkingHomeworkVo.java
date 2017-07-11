package com.qaplus.entity.vo;

import com.qaplus.entity.QaTQuestion;

public class MarkingHomeworkVo extends QaTQuestion{
	private String homeworkTitle;
	private String commitContent;
	private String stuAnswerAttachmentId;
	private String stuHasAnswerAttachment;
	private String teacherRemark;
	
	public String getHomeworkTitle() {
		return homeworkTitle;
	}
	public void setHomeworkTitle(String homeworkTitle) {
		this.homeworkTitle = homeworkTitle;
	}
	public String getCommitContent() {
		return commitContent;
	}
	public void setCommitContent(String commitContent) {
		this.commitContent = commitContent;
	}
	public String getStuAnswerAttachmentId() {
		return stuAnswerAttachmentId;
	}
	public void setStuAnswerAttachmentId(String stuAnswerAttachmentId) {
		this.stuAnswerAttachmentId = stuAnswerAttachmentId;
	}
	public String getStuHasAnswerAttachment() {
		return stuHasAnswerAttachment;
	}
	public void setStuHasAnswerAttachment(String stuHasAnswerAttachment) {
		this.stuHasAnswerAttachment = stuHasAnswerAttachment;
	}
	public String getTeacherRemark() {
		return teacherRemark;
	}
	public void setTeacherRemark(String teacherRemark) {
		this.teacherRemark = teacherRemark;
	}
	
	
	
}
