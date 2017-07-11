package com.qaplus.entity;

import java.util.Date;

public class QaSQuestion {
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
     * 问题标题
     */
    private String title;

    /**
     * 问题内容
     */
    private String questionContent;

    /**
     * 答案内容
     */
    private String answerContent;

    /**
     * 是否解决
     */
    private String isSolve;

    /**
     * 问题是否有附件
     */
    private String questionHasAttachment;

    /**
     * 回答是否要附件
     */
    private String answerHasAttachment;

    /**
     * 回答附件路劲
     */
    private Long answerAttachmentId;

    /**
     * 问题附件名称
     */
    private Long questionAttachmentId;

    /**
     * 分类
     */
    private String category;

    /**
     * 是否需要当面交流
     */
    private String needFaceComm;

    /**
     * 解决时间
     */
    private Date solveTime;

    /**
     * 提问者
     */
    private Long questionPerson;

    /**
     * 解决者
     */
    private Long solvePerson;

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
     * 问题标题
     * @return title 问题标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 问题标题
     * @param title 问题标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 问题内容
     * @return question_content 问题内容
     */
    public String getQuestionContent() {
        return questionContent;
    }

    /**
     * 问题内容
     * @param questionContent 问题内容
     */
    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    /**
     * 答案内容
     * @return answer_content 答案内容
     */
    public String getAnswerContent() {
        return answerContent;
    }

    /**
     * 答案内容
     * @param answerContent 答案内容
     */
    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent == null ? null : answerContent.trim();
    }

    /**
     * 是否解决
     * @return is_solve 是否解决
     */
    public String getIsSolve() {
        return isSolve;
    }

    /**
     * 是否解决
     * @param isSolve 是否解决
     */
    public void setIsSolve(String isSolve) {
        this.isSolve = isSolve == null ? null : isSolve.trim();
    }

    /**
     * 问题是否有附件
     * @return question_has_attachment 问题是否有附件
     */
    public String getQuestionHasAttachment() {
        return questionHasAttachment;
    }

    /**
     * 问题是否有附件
     * @param questionHasAttachment 问题是否有附件
     */
    public void setQuestionHasAttachment(String questionHasAttachment) {
        this.questionHasAttachment = questionHasAttachment == null ? null : questionHasAttachment.trim();
    }

    /**
     * 回答是否要附件
     * @return answer_has_attachment 回答是否要附件
     */
    public String getAnswerHasAttachment() {
        return answerHasAttachment;
    }

    /**
     * 回答是否要附件
     * @param answerHasAttachment 回答是否要附件
     */
    public void setAnswerHasAttachment(String answerHasAttachment) {
        this.answerHasAttachment = answerHasAttachment == null ? null : answerHasAttachment.trim();
    }

    /**
     * 回答附件路劲
     * @return answer_attachment_id 回答附件路劲
     */
    public Long getAnswerAttachmentId() {
        return answerAttachmentId;
    }

    /**
     * 回答附件路劲
     * @param answerAttachmentId 回答附件路劲
     */
    public void setAnswerAttachmentId(Long answerAttachmentId) {
        this.answerAttachmentId = answerAttachmentId;
    }

    /**
     * 问题附件名称
     * @return question_attachment_id 问题附件名称
     */
    public Long getQuestionAttachmentId() {
        return questionAttachmentId;
    }

    /**
     * 问题附件名称
     * @param questionAttachmentId 问题附件名称
     */
    public void setQuestionAttachmentId(Long questionAttachmentId) {
        this.questionAttachmentId = questionAttachmentId;
    }

    /**
     * 分类
     * @return category 分类
     */
    public String getCategory() {
        return category;
    }

    /**
     * 分类
     * @param category 分类
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 是否需要当面交流
     * @return need_face_comm 是否需要当面交流
     */
    public String getNeedFaceComm() {
        return needFaceComm;
    }

    /**
     * 是否需要当面交流
     * @param needFaceComm 是否需要当面交流
     */
    public void setNeedFaceComm(String needFaceComm) {
        this.needFaceComm = needFaceComm == null ? null : needFaceComm.trim();
    }

    /**
     * 解决时间
     * @return solve_time 解决时间
     */
    public Date getSolveTime() {
        return solveTime;
    }

    /**
     * 解决时间
     * @param solveTime 解决时间
     */
    public void setSolveTime(Date solveTime) {
        this.solveTime = solveTime;
    }

    /**
     * 提问者
     * @return question_person 提问者
     */
    public Long getQuestionPerson() {
        return questionPerson;
    }

    /**
     * 提问者
     * @param questionPerson 提问者
     */
    public void setQuestionPerson(Long questionPerson) {
        this.questionPerson = questionPerson;
    }

    /**
     * 解决者
     * @return solve_person 解决者
     */
    public Long getSolvePerson() {
        return solvePerson;
    }

    /**
     * 解决者
     * @param solvePerson 解决者
     */
    public void setSolvePerson(Long solvePerson) {
        this.solvePerson = solvePerson;
    }
}