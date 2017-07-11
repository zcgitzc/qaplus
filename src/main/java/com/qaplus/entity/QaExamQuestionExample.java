package com.qaplus.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QaExamQuestionExample {
    /**
     * qa_exam_question
     */
    protected String orderByClause;

    /**
     * qa_exam_question
     */
    protected boolean distinct;

    /**
     * qa_exam_question
     */
    protected List<Criteria> oredCriteria;

    public QaExamQuestionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * qa_exam_question 2017-03-04
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(String value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(String value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(String value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(String value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(String value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(String value) {
            addCriterion("is_deleted like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(String value) {
            addCriterion("is_deleted not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<String> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<String> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(String value1, String value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(String value1, String value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateIsNull() {
            addCriterion("rec_create_date is null");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateIsNotNull() {
            addCriterion("rec_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateEqualTo(Date value) {
            addCriterion("rec_create_date =", value, "recCreateDate");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateNotEqualTo(Date value) {
            addCriterion("rec_create_date <>", value, "recCreateDate");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateGreaterThan(Date value) {
            addCriterion("rec_create_date >", value, "recCreateDate");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("rec_create_date >=", value, "recCreateDate");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateLessThan(Date value) {
            addCriterion("rec_create_date <", value, "recCreateDate");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("rec_create_date <=", value, "recCreateDate");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateIn(List<Date> values) {
            addCriterion("rec_create_date in", values, "recCreateDate");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateNotIn(List<Date> values) {
            addCriterion("rec_create_date not in", values, "recCreateDate");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateBetween(Date value1, Date value2) {
            addCriterion("rec_create_date between", value1, value2, "recCreateDate");
            return (Criteria) this;
        }

        public Criteria andRecCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("rec_create_date not between", value1, value2, "recCreateDate");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateIsNull() {
            addCriterion("rec_update_date is null");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateIsNotNull() {
            addCriterion("rec_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateEqualTo(Date value) {
            addCriterion("rec_update_date =", value, "recUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateNotEqualTo(Date value) {
            addCriterion("rec_update_date <>", value, "recUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateGreaterThan(Date value) {
            addCriterion("rec_update_date >", value, "recUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("rec_update_date >=", value, "recUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateLessThan(Date value) {
            addCriterion("rec_update_date <", value, "recUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("rec_update_date <=", value, "recUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateIn(List<Date> values) {
            addCriterion("rec_update_date in", values, "recUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateNotIn(List<Date> values) {
            addCriterion("rec_update_date not in", values, "recUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateBetween(Date value1, Date value2) {
            addCriterion("rec_update_date between", value1, value2, "recUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRecUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("rec_update_date not between", value1, value2, "recUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserIsNull() {
            addCriterion("rec_update_user is null");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserIsNotNull() {
            addCriterion("rec_update_user is not null");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserEqualTo(String value) {
            addCriterion("rec_update_user =", value, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserNotEqualTo(String value) {
            addCriterion("rec_update_user <>", value, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserGreaterThan(String value) {
            addCriterion("rec_update_user >", value, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("rec_update_user >=", value, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserLessThan(String value) {
            addCriterion("rec_update_user <", value, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("rec_update_user <=", value, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserLike(String value) {
            addCriterion("rec_update_user like", value, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserNotLike(String value) {
            addCriterion("rec_update_user not like", value, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserIn(List<String> values) {
            addCriterion("rec_update_user in", values, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserNotIn(List<String> values) {
            addCriterion("rec_update_user not in", values, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserBetween(String value1, String value2) {
            addCriterion("rec_update_user between", value1, value2, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecUpdateUserNotBetween(String value1, String value2) {
            addCriterion("rec_update_user not between", value1, value2, "recUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserIsNull() {
            addCriterion("rec_create_user is null");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserIsNotNull() {
            addCriterion("rec_create_user is not null");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserEqualTo(String value) {
            addCriterion("rec_create_user =", value, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserNotEqualTo(String value) {
            addCriterion("rec_create_user <>", value, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserGreaterThan(String value) {
            addCriterion("rec_create_user >", value, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("rec_create_user >=", value, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserLessThan(String value) {
            addCriterion("rec_create_user <", value, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserLessThanOrEqualTo(String value) {
            addCriterion("rec_create_user <=", value, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserLike(String value) {
            addCriterion("rec_create_user like", value, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserNotLike(String value) {
            addCriterion("rec_create_user not like", value, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserIn(List<String> values) {
            addCriterion("rec_create_user in", values, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserNotIn(List<String> values) {
            addCriterion("rec_create_user not in", values, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserBetween(String value1, String value2) {
            addCriterion("rec_create_user between", value1, value2, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andRecCreateUserNotBetween(String value1, String value2) {
            addCriterion("rec_create_user not between", value1, value2, "recCreateUser");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andDiffStageIsNull() {
            addCriterion("diff_stage is null");
            return (Criteria) this;
        }

        public Criteria andDiffStageIsNotNull() {
            addCriterion("diff_stage is not null");
            return (Criteria) this;
        }

        public Criteria andDiffStageEqualTo(String value) {
            addCriterion("diff_stage =", value, "diffStage");
            return (Criteria) this;
        }

        public Criteria andDiffStageNotEqualTo(String value) {
            addCriterion("diff_stage <>", value, "diffStage");
            return (Criteria) this;
        }

        public Criteria andDiffStageGreaterThan(String value) {
            addCriterion("diff_stage >", value, "diffStage");
            return (Criteria) this;
        }

        public Criteria andDiffStageGreaterThanOrEqualTo(String value) {
            addCriterion("diff_stage >=", value, "diffStage");
            return (Criteria) this;
        }

        public Criteria andDiffStageLessThan(String value) {
            addCriterion("diff_stage <", value, "diffStage");
            return (Criteria) this;
        }

        public Criteria andDiffStageLessThanOrEqualTo(String value) {
            addCriterion("diff_stage <=", value, "diffStage");
            return (Criteria) this;
        }

        public Criteria andDiffStageLike(String value) {
            addCriterion("diff_stage like", value, "diffStage");
            return (Criteria) this;
        }

        public Criteria andDiffStageNotLike(String value) {
            addCriterion("diff_stage not like", value, "diffStage");
            return (Criteria) this;
        }

        public Criteria andDiffStageIn(List<String> values) {
            addCriterion("diff_stage in", values, "diffStage");
            return (Criteria) this;
        }

        public Criteria andDiffStageNotIn(List<String> values) {
            addCriterion("diff_stage not in", values, "diffStage");
            return (Criteria) this;
        }

        public Criteria andDiffStageBetween(String value1, String value2) {
            addCriterion("diff_stage between", value1, value2, "diffStage");
            return (Criteria) this;
        }

        public Criteria andDiffStageNotBetween(String value1, String value2) {
            addCriterion("diff_stage not between", value1, value2, "diffStage");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonIsNull() {
            addCriterion("question_person is null");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonIsNotNull() {
            addCriterion("question_person is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonEqualTo(String value) {
            addCriterion("question_person =", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonNotEqualTo(String value) {
            addCriterion("question_person <>", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonGreaterThan(String value) {
            addCriterion("question_person >", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonGreaterThanOrEqualTo(String value) {
            addCriterion("question_person >=", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonLessThan(String value) {
            addCriterion("question_person <", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonLessThanOrEqualTo(String value) {
            addCriterion("question_person <=", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonLike(String value) {
            addCriterion("question_person like", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonNotLike(String value) {
            addCriterion("question_person not like", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonIn(List<String> values) {
            addCriterion("question_person in", values, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonNotIn(List<String> values) {
            addCriterion("question_person not in", values, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonBetween(String value1, String value2) {
            addCriterion("question_person between", value1, value2, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonNotBetween(String value1, String value2) {
            addCriterion("question_person not between", value1, value2, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagIsNull() {
            addCriterion("wrong_flag is null");
            return (Criteria) this;
        }

        public Criteria andWrongFlagIsNotNull() {
            addCriterion("wrong_flag is not null");
            return (Criteria) this;
        }

        public Criteria andWrongFlagEqualTo(String value) {
            addCriterion("wrong_flag =", value, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagNotEqualTo(String value) {
            addCriterion("wrong_flag <>", value, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagGreaterThan(String value) {
            addCriterion("wrong_flag >", value, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagGreaterThanOrEqualTo(String value) {
            addCriterion("wrong_flag >=", value, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagLessThan(String value) {
            addCriterion("wrong_flag <", value, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagLessThanOrEqualTo(String value) {
            addCriterion("wrong_flag <=", value, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagLike(String value) {
            addCriterion("wrong_flag like", value, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagNotLike(String value) {
            addCriterion("wrong_flag not like", value, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagIn(List<String> values) {
            addCriterion("wrong_flag in", values, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagNotIn(List<String> values) {
            addCriterion("wrong_flag not in", values, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagBetween(String value1, String value2) {
            addCriterion("wrong_flag between", value1, value2, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagNotBetween(String value1, String value2) {
            addCriterion("wrong_flag not between", value1, value2, "wrongFlag");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescIsNull() {
            addCriterion("wrong_flag_desc is null");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescIsNotNull() {
            addCriterion("wrong_flag_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescEqualTo(String value) {
            addCriterion("wrong_flag_desc =", value, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescNotEqualTo(String value) {
            addCriterion("wrong_flag_desc <>", value, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescGreaterThan(String value) {
            addCriterion("wrong_flag_desc >", value, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescGreaterThanOrEqualTo(String value) {
            addCriterion("wrong_flag_desc >=", value, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescLessThan(String value) {
            addCriterion("wrong_flag_desc <", value, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescLessThanOrEqualTo(String value) {
            addCriterion("wrong_flag_desc <=", value, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescLike(String value) {
            addCriterion("wrong_flag_desc like", value, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescNotLike(String value) {
            addCriterion("wrong_flag_desc not like", value, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescIn(List<String> values) {
            addCriterion("wrong_flag_desc in", values, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescNotIn(List<String> values) {
            addCriterion("wrong_flag_desc not in", values, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescBetween(String value1, String value2) {
            addCriterion("wrong_flag_desc between", value1, value2, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagDescNotBetween(String value1, String value2) {
            addCriterion("wrong_flag_desc not between", value1, value2, "wrongFlagDesc");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonIsNull() {
            addCriterion("wrong_flag_person is null");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonIsNotNull() {
            addCriterion("wrong_flag_person is not null");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonEqualTo(String value) {
            addCriterion("wrong_flag_person =", value, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonNotEqualTo(String value) {
            addCriterion("wrong_flag_person <>", value, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonGreaterThan(String value) {
            addCriterion("wrong_flag_person >", value, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonGreaterThanOrEqualTo(String value) {
            addCriterion("wrong_flag_person >=", value, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonLessThan(String value) {
            addCriterion("wrong_flag_person <", value, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonLessThanOrEqualTo(String value) {
            addCriterion("wrong_flag_person <=", value, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonLike(String value) {
            addCriterion("wrong_flag_person like", value, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonNotLike(String value) {
            addCriterion("wrong_flag_person not like", value, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonIn(List<String> values) {
            addCriterion("wrong_flag_person in", values, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonNotIn(List<String> values) {
            addCriterion("wrong_flag_person not in", values, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonBetween(String value1, String value2) {
            addCriterion("wrong_flag_person between", value1, value2, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andWrongFlagPersonNotBetween(String value1, String value2) {
            addCriterion("wrong_flag_person not between", value1, value2, "wrongFlagPerson");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }
    }

    /**
     * qa_exam_question
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * qa_exam_question 2017-03-04
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}