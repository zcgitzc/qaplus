package com.qaplus.entity;

import java.util.Date;

public class QaTQuestion {
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
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 答案
     */
    private String answer;

    /**
     * 分类
     */
    private String category;

    /**
     * 用户ID
     */
    private Long userId;

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
     * 标题
     * @return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 答案
     * @return answer 答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 答案
     * @param answer 答案
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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
     * 用户ID
     * @return user_id 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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
}