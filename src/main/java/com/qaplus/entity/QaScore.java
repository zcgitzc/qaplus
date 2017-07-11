package com.qaplus.entity;

import java.util.Date;

public class QaScore {
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
     * 分数
     */
    private Integer score;

    /**
     * 试卷ID（记得计算：班级和试卷的最高分、最低分、平均分）
     */
    private Long paperId;

    /**
     * 学生ID
     */
    private Long stuId;

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
     * 分数
     * @return score 分数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 分数
     * @param score 分数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 试卷ID（记得计算：班级和试卷的最高分、最低分、平均分）
     * @return paper_id 试卷ID（记得计算：班级和试卷的最高分、最低分、平均分）
     */
    public Long getPaperId() {
        return paperId;
    }

    /**
     * 试卷ID（记得计算：班级和试卷的最高分、最低分、平均分）
     * @param paperId 试卷ID（记得计算：班级和试卷的最高分、最低分、平均分）
     */
    public void setPaperId(Long paperId) {
        this.paperId = paperId;
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
}