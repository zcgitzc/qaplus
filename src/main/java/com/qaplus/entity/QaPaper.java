package com.qaplus.entity;

import java.util.Date;

public class QaPaper {
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
     * 总分
     */
    private Integer totalScore;

    /**
     * 试题数目
     */
    private Integer questionAmount;

    /**
     * 试题编号（逗号分隔）
     */
    private String questionIds;

    /**
     * 试卷难易程度（难、中、易），根据试卷的考试结果判断
     */
    private String diffStage;

    /**
     * 监考老师
     */
    private Long invigilatePerson;

    /**
     * 出卷人
     */
    private Long paperPerson;

    /**
     * 试卷标题
     */
    private String paperTitle;

    /**
     * 试卷分类（Mix-综合试卷）
     */
    private String paperCategory;

    /**
     * 考试时间
     */
    private Date examDate;

    /**
     * 考试时长（单位：分钟）
     */
    private Integer examLong;

    /**
     * 打乱试题顺序
     */
    private String upsetQuestion;

    /**
     * 是否生效（时间判断）
     */
    private String isEffect;

    /**
     * 打乱选项顺序
     */
    private String upsetItem;

    /**
     * 试卷状态
     */
    private String paperStatus;

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
     * 总分
     * @return total_score 总分
     */
    public Integer getTotalScore() {
        return totalScore;
    }

    /**
     * 总分
     * @param totalScore 总分
     */
    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * 试题数目
     * @return question_amount 试题数目
     */
    public Integer getQuestionAmount() {
        return questionAmount;
    }

    /**
     * 试题数目
     * @param questionAmount 试题数目
     */
    public void setQuestionAmount(Integer questionAmount) {
        this.questionAmount = questionAmount;
    }

    /**
     * 试题编号（逗号分隔）
     * @return question_ids 试题编号（逗号分隔）
     */
    public String getQuestionIds() {
        return questionIds;
    }

    /**
     * 试题编号（逗号分隔）
     * @param questionIds 试题编号（逗号分隔）
     */
    public void setQuestionIds(String questionIds) {
        this.questionIds = questionIds == null ? null : questionIds.trim();
    }

    /**
     * 试卷难易程度（难、中、易），根据试卷的考试结果判断
     * @return diff_stage 试卷难易程度（难、中、易），根据试卷的考试结果判断
     */
    public String getDiffStage() {
        return diffStage;
    }

    /**
     * 试卷难易程度（难、中、易），根据试卷的考试结果判断
     * @param diffStage 试卷难易程度（难、中、易），根据试卷的考试结果判断
     */
    public void setDiffStage(String diffStage) {
        this.diffStage = diffStage == null ? null : diffStage.trim();
    }

    /**
     * 监考老师
     * @return invigilate_person 监考老师
     */
    public Long getInvigilatePerson() {
        return invigilatePerson;
    }

    /**
     * 监考老师
     * @param invigilatePerson 监考老师
     */
    public void setInvigilatePerson(Long invigilatePerson) {
        this.invigilatePerson = invigilatePerson;
    }

    /**
     * 出卷人
     * @return paper_person 出卷人
     */
    public Long getPaperPerson() {
        return paperPerson;
    }

    /**
     * 出卷人
     * @param paperPerson 出卷人
     */
    public void setPaperPerson(Long paperPerson) {
        this.paperPerson = paperPerson;
    }

    /**
     * 试卷标题
     * @return paper_title 试卷标题
     */
    public String getPaperTitle() {
        return paperTitle;
    }

    /**
     * 试卷标题
     * @param paperTitle 试卷标题
     */
    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle == null ? null : paperTitle.trim();
    }

    /**
     * 试卷分类（Mix-综合试卷）
     * @return paper_category 试卷分类（Mix-综合试卷）
     */
    public String getPaperCategory() {
        return paperCategory;
    }

    /**
     * 试卷分类（Mix-综合试卷）
     * @param paperCategory 试卷分类（Mix-综合试卷）
     */
    public void setPaperCategory(String paperCategory) {
        this.paperCategory = paperCategory == null ? null : paperCategory.trim();
    }

    /**
     * 考试时间
     * @return exam_date 考试时间
     */
    public Date getExamDate() {
        return examDate;
    }

    /**
     * 考试时间
     * @param examDate 考试时间
     */
    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    /**
     * 考试时长（单位：分钟）
     * @return exam_long 考试时长（单位：分钟）
     */
    public Integer getExamLong() {
        return examLong;
    }

    /**
     * 考试时长（单位：分钟）
     * @param examLong 考试时长（单位：分钟）
     */
    public void setExamLong(Integer examLong) {
        this.examLong = examLong;
    }

    /**
     * 打乱试题顺序
     * @return upset_question 打乱试题顺序
     */
    public String getUpsetQuestion() {
        return upsetQuestion;
    }

    /**
     * 打乱试题顺序
     * @param upsetQuestion 打乱试题顺序
     */
    public void setUpsetQuestion(String upsetQuestion) {
        this.upsetQuestion = upsetQuestion == null ? null : upsetQuestion.trim();
    }

    /**
     * 是否生效（时间判断）
     * @return is_effect 是否生效（时间判断）
     */
    public String getIsEffect() {
        return isEffect;
    }

    /**
     * 是否生效（时间判断）
     * @param isEffect 是否生效（时间判断）
     */
    public void setIsEffect(String isEffect) {
        this.isEffect = isEffect == null ? null : isEffect.trim();
    }

    /**
     * 打乱选项顺序
     * @return upset_item 打乱选项顺序
     */
    public String getUpsetItem() {
        return upsetItem;
    }

    /**
     * 打乱选项顺序
     * @param upsetItem 打乱选项顺序
     */
    public void setUpsetItem(String upsetItem) {
        this.upsetItem = upsetItem == null ? null : upsetItem.trim();
    }

    /**
     * 试卷状态
     * @return paper_status 试卷状态
     */
    public String getPaperStatus() {
        return paperStatus;
    }

    /**
     * 试卷状态
     * @param paperStatus 试卷状态
     */
    public void setPaperStatus(String paperStatus) {
        this.paperStatus = paperStatus == null ? null : paperStatus.trim();
    }
}