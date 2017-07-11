package com.qaplus.entity;

import java.util.Date;

public class QaStuHwAnswer {
    /**
     * 主键
     */
    private Long id;

    /**
     * 是否已经删除
     */
    private String isDeleted;

    /**
     * 记录创建时间
     */
    private Date recCreateDate;

    /**
     * 最近修改时间
     */
    private Date recUpdateDate;

    /**
     * 最近修改人
     */
    private String recUpdateUser;

    /**
     * 创建人
     */
    private String recCreateUser;

    /**
     * 
     */
    private Long homeworkId;

    /**
     * 
     */
    private Long questionId;

    /**
     * 
     */
    private Long stuId;

    /**
     * 
     */
    private String commitContent;

    /**
     * 老师批注
     */
    private String teacherRemark;

    /**
     * 
     */
    private String hasAttachment;

    /**
     * 
     */
    private Long attachmentId;

    /**
     * 主键
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 是否已经删除
     * @return is_deleted 是否已经删除
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否已经删除
     * @param isDeleted 是否已经删除
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    /**
     * 记录创建时间
     * @return rec_create_date 记录创建时间
     */
    public Date getRecCreateDate() {
        return recCreateDate;
    }

    /**
     * 记录创建时间
     * @param recCreateDate 记录创建时间
     */
    public void setRecCreateDate(Date recCreateDate) {
        this.recCreateDate = recCreateDate;
    }

    /**
     * 最近修改时间
     * @return rec_update_date 最近修改时间
     */
    public Date getRecUpdateDate() {
        return recUpdateDate;
    }

    /**
     * 最近修改时间
     * @param recUpdateDate 最近修改时间
     */
    public void setRecUpdateDate(Date recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }

    /**
     * 最近修改人
     * @return rec_update_user 最近修改人
     */
    public String getRecUpdateUser() {
        return recUpdateUser;
    }

    /**
     * 最近修改人
     * @param recUpdateUser 最近修改人
     */
    public void setRecUpdateUser(String recUpdateUser) {
        this.recUpdateUser = recUpdateUser == null ? null : recUpdateUser.trim();
    }

    /**
     * 创建人
     * @return rec_create_user 创建人
     */
    public String getRecCreateUser() {
        return recCreateUser;
    }

    /**
     * 创建人
     * @param recCreateUser 创建人
     */
    public void setRecCreateUser(String recCreateUser) {
        this.recCreateUser = recCreateUser == null ? null : recCreateUser.trim();
    }

    /**
     * 
     * @return homework_id 
     */
    public Long getHomeworkId() {
        return homeworkId;
    }

    /**
     * 
     * @param homeworkId 
     */
    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    /**
     * 
     * @return question_id 
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * 
     * @param questionId 
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    /**
     * 
     * @return stu_id 
     */
    public Long getStuId() {
        return stuId;
    }

    /**
     * 
     * @param stuId 
     */
    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    /**
     * 
     * @return commit_content 
     */
    public String getCommitContent() {
        return commitContent;
    }

    /**
     * 
     * @param commitContent 
     */
    public void setCommitContent(String commitContent) {
        this.commitContent = commitContent == null ? null : commitContent.trim();
    }

    /**
     * 老师批注
     * @return teacher_remark 老师批注
     */
    public String getTeacherRemark() {
        return teacherRemark;
    }

    /**
     * 老师批注
     * @param teacherRemark 老师批注
     */
    public void setTeacherRemark(String teacherRemark) {
        this.teacherRemark = teacherRemark == null ? null : teacherRemark.trim();
    }

    /**
     * 
     * @return has_attachment 
     */
    public String getHasAttachment() {
        return hasAttachment;
    }

    /**
     * 
     * @param hasAttachment 
     */
    public void setHasAttachment(String hasAttachment) {
        this.hasAttachment = hasAttachment == null ? null : hasAttachment.trim();
    }

    /**
     * 
     * @return attachment_id 
     */
    public Long getAttachmentId() {
        return attachmentId;
    }

    /**
     * 
     * @param attachmentId 
     */
    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }
}