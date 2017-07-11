package com.qaplus.entity;

import java.util.Date;

public class QaExamErrorQuestions {
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
     * 做错次数
     */
    private Integer errorCount;

    /**
     * 问题ID
     */
    private Long questionId;

    /**
     * 容错范围，错了几次
     */
    private Integer errorRange;

    /**
     * 学生ID
     */
    private Long stuId;

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
     * 做错次数
     * @return error_count 做错次数
     */
    public Integer getErrorCount() {
        return errorCount;
    }

    /**
     * 做错次数
     * @param errorCount 做错次数
     */
    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    /**
     * 问题ID
     * @return question_id 问题ID
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * 问题ID
     * @param questionId 问题ID
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    /**
     * 容错范围，错了几次
     * @return error_range 容错范围，错了几次
     */
    public Integer getErrorRange() {
        return errorRange;
    }

    /**
     * 容错范围，错了几次
     * @param errorRange 容错范围，错了几次
     */
    public void setErrorRange(Integer errorRange) {
        this.errorRange = errorRange;
    }

    /**
     * 学生ID
     * @return stu_id 学生ID
     */
    public Long getStuId() {
        return stuId;
    }

    /**
     * 学生ID
     * @param stuId 学生ID
     */
    public void setStuId(Long stuId) {
        this.stuId = stuId;
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