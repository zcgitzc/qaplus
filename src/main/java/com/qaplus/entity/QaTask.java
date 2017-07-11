package com.qaplus.entity;

import java.util.Date;

public class QaTask {
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
     * 任务key
     */
    private String operKey;

    /**
     * 任务内容
     */
    private String content;

    /**
     * 触发任务者
     */
    private String triggerPerson;

    /**
     * 是否处理
     */
    private String isSolve;

    /**
     * 处理结果 N-不同意  Y-同意  ''-未处理
     */
    private String isAgree;

    /**
     * 审批意见
     */
    private String auditMsg;

    /**
     * 任务信息（问题标题、注册的人...）
     */
    private String keyword;

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
     * 任务key
     * @return oper_key 任务key
     */
    public String getOperKey() {
        return operKey;
    }

    /**
     * 任务key
     * @param operKey 任务key
     */
    public void setOperKey(String operKey) {
        this.operKey = operKey == null ? null : operKey.trim();
    }

    /**
     * 任务内容
     * @return content 任务内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 任务内容
     * @param content 任务内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 触发任务者
     * @return trigger_person 触发任务者
     */
    public String getTriggerPerson() {
        return triggerPerson;
    }

    /**
     * 触发任务者
     * @param triggerPerson 触发任务者
     */
    public void setTriggerPerson(String triggerPerson) {
        this.triggerPerson = triggerPerson == null ? null : triggerPerson.trim();
    }

    /**
     * 是否处理
     * @return is_solve 是否处理
     */
    public String getIsSolve() {
        return isSolve;
    }

    /**
     * 是否处理
     * @param isSolve 是否处理
     */
    public void setIsSolve(String isSolve) {
        this.isSolve = isSolve == null ? null : isSolve.trim();
    }

    /**
     * 处理结果 N-不同意  Y-同意  ''-未处理
     * @return is_agree 处理结果 N-不同意  Y-同意  ''-未处理
     */
    public String getIsAgree() {
        return isAgree;
    }

    /**
     * 处理结果 N-不同意  Y-同意  ''-未处理
     * @param isAgree 处理结果 N-不同意  Y-同意  ''-未处理
     */
    public void setIsAgree(String isAgree) {
        this.isAgree = isAgree == null ? null : isAgree.trim();
    }

    /**
     * 审批意见
     * @return audit_msg 审批意见
     */
    public String getAuditMsg() {
        return auditMsg;
    }

    /**
     * 审批意见
     * @param auditMsg 审批意见
     */
    public void setAuditMsg(String auditMsg) {
        this.auditMsg = auditMsg == null ? null : auditMsg.trim();
    }

    /**
     * 任务信息（问题标题、注册的人...）
     * @return keyword 任务信息（问题标题、注册的人...）
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 任务信息（问题标题、注册的人...）
     * @param keyword 任务信息（问题标题、注册的人...）
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
}