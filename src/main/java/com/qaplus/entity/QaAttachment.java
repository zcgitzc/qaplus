package com.qaplus.entity;

import java.util.Date;

public class QaAttachment {
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
     * 附件路径
     */
    private String attachmentPath;

    /**
     * 附件名字（唯一名字）
     */
    private String attachmentName;

    /**
     * 附件真实名称
     */
    private String attachmentRealName;

    /**
     * 附件描述
     */
    private String attachmentDesc;

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
     * 附件路径
     * @return attachment_path 附件路径
     */
    public String getAttachmentPath() {
        return attachmentPath;
    }

    /**
     * 附件路径
     * @param attachmentPath 附件路径
     */
    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath == null ? null : attachmentPath.trim();
    }

    /**
     * 附件名字（唯一名字）
     * @return attachment_name 附件名字（唯一名字）
     */
    public String getAttachmentName() {
        return attachmentName;
    }

    /**
     * 附件名字（唯一名字）
     * @param attachmentName 附件名字（唯一名字）
     */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    /**
     * 附件真实名称
     * @return attachment_real_name 附件真实名称
     */
    public String getAttachmentRealName() {
        return attachmentRealName;
    }

    /**
     * 附件真实名称
     * @param attachmentRealName 附件真实名称
     */
    public void setAttachmentRealName(String attachmentRealName) {
        this.attachmentRealName = attachmentRealName == null ? null : attachmentRealName.trim();
    }

    /**
     * 附件描述
     * @return attachment_desc 附件描述
     */
    public String getAttachmentDesc() {
        return attachmentDesc;
    }

    /**
     * 附件描述
     * @param attachmentDesc 附件描述
     */
    public void setAttachmentDesc(String attachmentDesc) {
        this.attachmentDesc = attachmentDesc == null ? null : attachmentDesc.trim();
    }
}