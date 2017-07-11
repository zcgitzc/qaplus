package com.qaplus.entity;

import java.util.Date;

public class QaStuAnswer {
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
     * 试卷ID
     */
    private Long paperId;

    /**
     * 问题ID
     */
    private Long examQuestionId;

    /**
     * 学生ID
     */
    private Long userId;

    /**
     * 学生答案
     */
    private String answerItem;

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
     * 试卷ID
     * @return paper_id 试卷ID
     */
    public Long getPaperId() {
        return paperId;
    }

    /**
     * 试卷ID
     * @param paperId 试卷ID
     */
    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    /**
     * 问题ID
     * @return exam_question_id 问题ID
     */
    public Long getExamQuestionId() {
        return examQuestionId;
    }

    /**
     * 问题ID
     * @param examQuestionId 问题ID
     */
    public void setExamQuestionId(Long examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    /**
     * 学生ID
     * @return user_id 学生ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 学生ID
     * @param userId 学生ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 学生答案
     * @return answer_item 学生答案
     */
    public String getAnswerItem() {
        return answerItem;
    }

    /**
     * 学生答案
     * @param answerItem 学生答案
     */
    public void setAnswerItem(String answerItem) {
        this.answerItem = answerItem == null ? null : answerItem.trim();
    }
}