package com.qaplus.entity;

import java.util.Date;

public class QaExamQuestion {
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
     * 试题标题
     */
    private String title;

    /**
     * 试题内容
     */
    private String content;

    /**
     * 试题类型（单选、多选）
     */
    private String type;

    /**
     * 分值（2分一个）
     */
    private Integer score;

    /**
     * 难易程度（动态改变，根据错误率）
     */
    private String diffStage;

    /**
     * 出题人
     */
    private String questionPerson;

    /**
     * 学生可以标记这道题有问题
     */
    private String wrongFlag;

    /**
     * 题目有误描述
     */
    private String wrongFlagDesc;

    /**
     * 谁说这道题有问题
     */
    private String wrongFlagPerson;

    /**
     * 问题分类
     */
    private String category;

    /**
     * 对正确答案的解释
     */
    private String note;

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
     * 试题标题
     * @return title 试题标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 试题标题
     * @param title 试题标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 试题内容
     * @return content 试题内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 试题内容
     * @param content 试题内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 试题类型（单选、多选）
     * @return type 试题类型（单选、多选）
     */
    public String getType() {
        return type;
    }

    /**
     * 试题类型（单选、多选）
     * @param type 试题类型（单选、多选）
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 分值（2分一个）
     * @return score 分值（2分一个）
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 分值（2分一个）
     * @param score 分值（2分一个）
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 难易程度（动态改变，根据错误率）
     * @return diff_stage 难易程度（动态改变，根据错误率）
     */
    public String getDiffStage() {
        return diffStage;
    }

    /**
     * 难易程度（动态改变，根据错误率）
     * @param diffStage 难易程度（动态改变，根据错误率）
     */
    public void setDiffStage(String diffStage) {
        this.diffStage = diffStage == null ? null : diffStage.trim();
    }

    /**
     * 出题人
     * @return question_person 出题人
     */
    public String getQuestionPerson() {
        return questionPerson;
    }

    /**
     * 出题人
     * @param questionPerson 出题人
     */
    public void setQuestionPerson(String questionPerson) {
        this.questionPerson = questionPerson == null ? null : questionPerson.trim();
    }

    /**
     * 学生可以标记这道题有问题
     * @return wrong_flag 学生可以标记这道题有问题
     */
    public String getWrongFlag() {
        return wrongFlag;
    }

    /**
     * 学生可以标记这道题有问题
     * @param wrongFlag 学生可以标记这道题有问题
     */
    public void setWrongFlag(String wrongFlag) {
        this.wrongFlag = wrongFlag == null ? null : wrongFlag.trim();
    }

    /**
     * 题目有误描述
     * @return wrong_flag_desc 题目有误描述
     */
    public String getWrongFlagDesc() {
        return wrongFlagDesc;
    }

    /**
     * 题目有误描述
     * @param wrongFlagDesc 题目有误描述
     */
    public void setWrongFlagDesc(String wrongFlagDesc) {
        this.wrongFlagDesc = wrongFlagDesc == null ? null : wrongFlagDesc.trim();
    }

    /**
     * 谁说这道题有问题
     * @return wrong_flag_person 谁说这道题有问题
     */
    public String getWrongFlagPerson() {
        return wrongFlagPerson;
    }

    /**
     * 谁说这道题有问题
     * @param wrongFlagPerson 谁说这道题有问题
     */
    public void setWrongFlagPerson(String wrongFlagPerson) {
        this.wrongFlagPerson = wrongFlagPerson == null ? null : wrongFlagPerson.trim();
    }

    /**
     * 问题分类
     * @return category 问题分类
     */
    public String getCategory() {
        return category;
    }

    /**
     * 问题分类
     * @param category 问题分类
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 对正确答案的解释
     * @return note 对正确答案的解释
     */
    public String getNote() {
        return note;
    }

    /**
     * 对正确答案的解释
     * @param note 对正确答案的解释
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}