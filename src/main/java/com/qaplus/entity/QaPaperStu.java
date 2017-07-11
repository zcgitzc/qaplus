package com.qaplus.entity;

import java.util.Date;

public class QaPaperStu {
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
     * 是否提交试卷
     */
    private String isSubmit;

    /**
     * 学生考试状态（考试中、已提交）
     */
    private String examStatus;

    /**
     * 学生Id
     */
    private Long stuId;

    /**
     * 试卷ID
     */
    private Long paperId;

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
     * 是否提交试卷
     * @return is_submit 是否提交试卷
     */
    public String getIsSubmit() {
        return isSubmit;
    }

    /**
     * 是否提交试卷
     * @param isSubmit 是否提交试卷
     */
    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit == null ? null : isSubmit.trim();
    }

    /**
     * 学生考试状态（考试中、已提交）
     * @return exam_status 学生考试状态（考试中、已提交）
     */
    public String getExamStatus() {
        return examStatus;
    }

    /**
     * 学生考试状态（考试中、已提交）
     * @param examStatus 学生考试状态（考试中、已提交）
     */
    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus == null ? null : examStatus.trim();
    }

    /**
     * 学生Id
     * @return stu_id 学生Id
     */
    public Long getStuId() {
        return stuId;
    }

    /**
     * 学生Id
     * @param stuId 学生Id
     */
    public void setStuId(Long stuId) {
        this.stuId = stuId;
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
}