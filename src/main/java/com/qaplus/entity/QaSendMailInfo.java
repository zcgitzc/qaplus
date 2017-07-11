package com.qaplus.entity;

import java.util.Date;

public class QaSendMailInfo {
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
     * 发送者
     */
    private String sender;

    /**
     * 接收者
     */
    private String receivers;

    /**
     * 状态
     */
    private String status;

    /**
     * 邮件内容
     */
    private String mailContent;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件模板名称
     */
    private String templateName;

    /**
     * 来源ID
     */
    private Long sourceId;

    /**
     * 描述
     */
    private String description;

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
     * 发送者
     * @return sender 发送者
     */
    public String getSender() {
        return sender;
    }

    /**
     * 发送者
     * @param sender 发送者
     */
    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    /**
     * 接收者
     * @return receivers 接收者
     */
    public String getReceivers() {
        return receivers;
    }

    /**
     * 接收者
     * @param receivers 接收者
     */
    public void setReceivers(String receivers) {
        this.receivers = receivers == null ? null : receivers.trim();
    }

    /**
     * 状态
     * @return status 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 邮件内容
     * @return mail_content 邮件内容
     */
    public String getMailContent() {
        return mailContent;
    }

    /**
     * 邮件内容
     * @param mailContent 邮件内容
     */
    public void setMailContent(String mailContent) {
        this.mailContent = mailContent == null ? null : mailContent.trim();
    }

    /**
     * 邮件主题
     * @return subject 邮件主题
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 邮件主题
     * @param subject 邮件主题
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * 邮件模板名称
     * @return template_name 邮件模板名称
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 邮件模板名称
     * @param templateName 邮件模板名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    /**
     * 来源ID
     * @return source_id 来源ID
     */
    public Long getSourceId() {
        return sourceId;
    }

    /**
     * 来源ID
     * @param sourceId 来源ID
     */
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}