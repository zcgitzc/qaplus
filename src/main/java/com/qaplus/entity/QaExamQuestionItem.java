package com.qaplus.entity;

import java.util.Date;

public class QaExamQuestionItem {
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
     * 考试问题ID
     */
    private Long examQuestionId;

    /**
     * 选项内容(A\B\C.....）
     */
    private String itemContent;

    /**
     * 是否为正确选项
     */
    private String isRightItem;

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
     * 考试问题ID
     * @return exam_question_id 考试问题ID
     */
    public Long getExamQuestionId() {
        return examQuestionId;
    }

    /**
     * 考试问题ID
     * @param examQuestionId 考试问题ID
     */
    public void setExamQuestionId(Long examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    /**
     * 选项内容(A\B\C.....）
     * @return item_content 选项内容(A\B\C.....）
     */
    public String getItemContent() {
        return itemContent;
    }

    /**
     * 选项内容(A\B\C.....）
     * @param itemContent 选项内容(A\B\C.....）
     */
    public void setItemContent(String itemContent) {
        this.itemContent = itemContent == null ? null : itemContent.trim();
    }

    /**
     * 是否为正确选项
     * @return is_right_item 是否为正确选项
     */
    public String getIsRightItem() {
        return isRightItem;
    }

    /**
     * 是否为正确选项
     * @param isRightItem 是否为正确选项
     */
    public void setIsRightItem(String isRightItem) {
        this.isRightItem = isRightItem == null ? null : isRightItem.trim();
    }
}