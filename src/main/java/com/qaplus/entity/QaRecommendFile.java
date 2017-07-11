package com.qaplus.entity;

import java.util.Date;

public class QaRecommendFile {
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
    private String title;

    /**
     * 
     */
    private String content;

    /**
     * 是否有附件
     */
    private String hasAttachment;

    /**
     * 附件路径
     */
    private Long attachmentId;

    /**
     * 推荐者（可以是毕业的学生，可以是老师）
     */
    private Long recommendPerson;

    /**
     * 资料类别
     */
    private String category;

    /**
     * 所有人可见
     */
    private String allRead;

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
     * @return title 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 
     * @return content 
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content 
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 是否有附件
     * @return has_attachment 是否有附件
     */
    public String getHasAttachment() {
        return hasAttachment;
    }

    /**
     * 是否有附件
     * @param hasAttachment 是否有附件
     */
    public void setHasAttachment(String hasAttachment) {
        this.hasAttachment = hasAttachment == null ? null : hasAttachment.trim();
    }

    /**
     * 附件路径
     * @return attachment_id 附件路径
     */
    public Long getAttachmentId() {
        return attachmentId;
    }

    /**
     * 附件路径
     * @param attachmentId 附件路径
     */
    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * 推荐者（可以是毕业的学生，可以是老师）
     * @return recommend_person 推荐者（可以是毕业的学生，可以是老师）
     */
    public Long getRecommendPerson() {
        return recommendPerson;
    }

    /**
     * 推荐者（可以是毕业的学生，可以是老师）
     * @param recommendPerson 推荐者（可以是毕业的学生，可以是老师）
     */
    public void setRecommendPerson(Long recommendPerson) {
        this.recommendPerson = recommendPerson;
    }

    /**
     * 资料类别
     * @return category 资料类别
     */
    public String getCategory() {
        return category;
    }

    /**
     * 资料类别
     * @param category 资料类别
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 所有人可见
     * @return all_read 所有人可见
     */
    public String getAllRead() {
        return allRead;
    }

    /**
     * 所有人可见
     * @param allRead 所有人可见
     */
    public void setAllRead(String allRead) {
        this.allRead = allRead == null ? null : allRead.trim();
    }
}