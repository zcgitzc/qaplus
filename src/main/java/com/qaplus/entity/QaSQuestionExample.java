package com.qaplus.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QaSQuestionExample {
    /**
     * qa_s_question
     */
    protected String orderByClause;

    /**
     * qa_s_question
     */
    protected boolean distinct;

    /**
     * qa_s_question
     */
    protected List<Criteria> oredCriteria;

    public QaSQuestionExample() {
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
     * qa_s_question 2017-03-04
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

        public Criteria andQuestionContentIsNull() {
            addCriterion("question_content is null");
            return (Criteria) this;
        }

        public Criteria andQuestionContentIsNotNull() {
            addCriterion("question_content is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionContentEqualTo(String value) {
            addCriterion("question_content =", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotEqualTo(String value) {
            addCriterion("question_content <>", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentGreaterThan(String value) {
            addCriterion("question_content >", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentGreaterThanOrEqualTo(String value) {
            addCriterion("question_content >=", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLessThan(String value) {
            addCriterion("question_content <", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLessThanOrEqualTo(String value) {
            addCriterion("question_content <=", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLike(String value) {
            addCriterion("question_content like", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotLike(String value) {
            addCriterion("question_content not like", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentIn(List<String> values) {
            addCriterion("question_content in", values, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotIn(List<String> values) {
            addCriterion("question_content not in", values, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentBetween(String value1, String value2) {
            addCriterion("question_content between", value1, value2, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotBetween(String value1, String value2) {
            addCriterion("question_content not between", value1, value2, "questionContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentIsNull() {
            addCriterion("answer_content is null");
            return (Criteria) this;
        }

        public Criteria andAnswerContentIsNotNull() {
            addCriterion("answer_content is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerContentEqualTo(String value) {
            addCriterion("answer_content =", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotEqualTo(String value) {
            addCriterion("answer_content <>", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentGreaterThan(String value) {
            addCriterion("answer_content >", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentGreaterThanOrEqualTo(String value) {
            addCriterion("answer_content >=", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLessThan(String value) {
            addCriterion("answer_content <", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLessThanOrEqualTo(String value) {
            addCriterion("answer_content <=", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLike(String value) {
            addCriterion("answer_content like", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotLike(String value) {
            addCriterion("answer_content not like", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentIn(List<String> values) {
            addCriterion("answer_content in", values, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotIn(List<String> values) {
            addCriterion("answer_content not in", values, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentBetween(String value1, String value2) {
            addCriterion("answer_content between", value1, value2, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotBetween(String value1, String value2) {
            addCriterion("answer_content not between", value1, value2, "answerContent");
            return (Criteria) this;
        }

        public Criteria andIsSolveIsNull() {
            addCriterion("is_solve is null");
            return (Criteria) this;
        }

        public Criteria andIsSolveIsNotNull() {
            addCriterion("is_solve is not null");
            return (Criteria) this;
        }

        public Criteria andIsSolveEqualTo(String value) {
            addCriterion("is_solve =", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveNotEqualTo(String value) {
            addCriterion("is_solve <>", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveGreaterThan(String value) {
            addCriterion("is_solve >", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveGreaterThanOrEqualTo(String value) {
            addCriterion("is_solve >=", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveLessThan(String value) {
            addCriterion("is_solve <", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveLessThanOrEqualTo(String value) {
            addCriterion("is_solve <=", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveLike(String value) {
            addCriterion("is_solve like", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveNotLike(String value) {
            addCriterion("is_solve not like", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveIn(List<String> values) {
            addCriterion("is_solve in", values, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveNotIn(List<String> values) {
            addCriterion("is_solve not in", values, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveBetween(String value1, String value2) {
            addCriterion("is_solve between", value1, value2, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveNotBetween(String value1, String value2) {
            addCriterion("is_solve not between", value1, value2, "isSolve");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentIsNull() {
            addCriterion("question_has_attachment is null");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentIsNotNull() {
            addCriterion("question_has_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentEqualTo(String value) {
            addCriterion("question_has_attachment =", value, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentNotEqualTo(String value) {
            addCriterion("question_has_attachment <>", value, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentGreaterThan(String value) {
            addCriterion("question_has_attachment >", value, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("question_has_attachment >=", value, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentLessThan(String value) {
            addCriterion("question_has_attachment <", value, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentLessThanOrEqualTo(String value) {
            addCriterion("question_has_attachment <=", value, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentLike(String value) {
            addCriterion("question_has_attachment like", value, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentNotLike(String value) {
            addCriterion("question_has_attachment not like", value, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentIn(List<String> values) {
            addCriterion("question_has_attachment in", values, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentNotIn(List<String> values) {
            addCriterion("question_has_attachment not in", values, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentBetween(String value1, String value2) {
            addCriterion("question_has_attachment between", value1, value2, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andQuestionHasAttachmentNotBetween(String value1, String value2) {
            addCriterion("question_has_attachment not between", value1, value2, "questionHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentIsNull() {
            addCriterion("answer_has_attachment is null");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentIsNotNull() {
            addCriterion("answer_has_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentEqualTo(String value) {
            addCriterion("answer_has_attachment =", value, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentNotEqualTo(String value) {
            addCriterion("answer_has_attachment <>", value, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentGreaterThan(String value) {
            addCriterion("answer_has_attachment >", value, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("answer_has_attachment >=", value, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentLessThan(String value) {
            addCriterion("answer_has_attachment <", value, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentLessThanOrEqualTo(String value) {
            addCriterion("answer_has_attachment <=", value, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentLike(String value) {
            addCriterion("answer_has_attachment like", value, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentNotLike(String value) {
            addCriterion("answer_has_attachment not like", value, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentIn(List<String> values) {
            addCriterion("answer_has_attachment in", values, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentNotIn(List<String> values) {
            addCriterion("answer_has_attachment not in", values, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentBetween(String value1, String value2) {
            addCriterion("answer_has_attachment between", value1, value2, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerHasAttachmentNotBetween(String value1, String value2) {
            addCriterion("answer_has_attachment not between", value1, value2, "answerHasAttachment");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdIsNull() {
            addCriterion("answer_attachment_id is null");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdIsNotNull() {
            addCriterion("answer_attachment_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdEqualTo(Long value) {
            addCriterion("answer_attachment_id =", value, "answerAttachmentId");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdNotEqualTo(Long value) {
            addCriterion("answer_attachment_id <>", value, "answerAttachmentId");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdGreaterThan(Long value) {
            addCriterion("answer_attachment_id >", value, "answerAttachmentId");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("answer_attachment_id >=", value, "answerAttachmentId");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdLessThan(Long value) {
            addCriterion("answer_attachment_id <", value, "answerAttachmentId");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdLessThanOrEqualTo(Long value) {
            addCriterion("answer_attachment_id <=", value, "answerAttachmentId");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdIn(List<Long> values) {
            addCriterion("answer_attachment_id in", values, "answerAttachmentId");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdNotIn(List<Long> values) {
            addCriterion("answer_attachment_id not in", values, "answerAttachmentId");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdBetween(Long value1, Long value2) {
            addCriterion("answer_attachment_id between", value1, value2, "answerAttachmentId");
            return (Criteria) this;
        }

        public Criteria andAnswerAttachmentIdNotBetween(Long value1, Long value2) {
            addCriterion("answer_attachment_id not between", value1, value2, "answerAttachmentId");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdIsNull() {
            addCriterion("question_attachment_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdIsNotNull() {
            addCriterion("question_attachment_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdEqualTo(Long value) {
            addCriterion("question_attachment_id =", value, "questionAttachmentId");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdNotEqualTo(Long value) {
            addCriterion("question_attachment_id <>", value, "questionAttachmentId");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdGreaterThan(Long value) {
            addCriterion("question_attachment_id >", value, "questionAttachmentId");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("question_attachment_id >=", value, "questionAttachmentId");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdLessThan(Long value) {
            addCriterion("question_attachment_id <", value, "questionAttachmentId");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdLessThanOrEqualTo(Long value) {
            addCriterion("question_attachment_id <=", value, "questionAttachmentId");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdIn(List<Long> values) {
            addCriterion("question_attachment_id in", values, "questionAttachmentId");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdNotIn(List<Long> values) {
            addCriterion("question_attachment_id not in", values, "questionAttachmentId");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdBetween(Long value1, Long value2) {
            addCriterion("question_attachment_id between", value1, value2, "questionAttachmentId");
            return (Criteria) this;
        }

        public Criteria andQuestionAttachmentIdNotBetween(Long value1, Long value2) {
            addCriterion("question_attachment_id not between", value1, value2, "questionAttachmentId");
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

        public Criteria andNeedFaceCommIsNull() {
            addCriterion("need_face_comm is null");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommIsNotNull() {
            addCriterion("need_face_comm is not null");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommEqualTo(String value) {
            addCriterion("need_face_comm =", value, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommNotEqualTo(String value) {
            addCriterion("need_face_comm <>", value, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommGreaterThan(String value) {
            addCriterion("need_face_comm >", value, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommGreaterThanOrEqualTo(String value) {
            addCriterion("need_face_comm >=", value, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommLessThan(String value) {
            addCriterion("need_face_comm <", value, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommLessThanOrEqualTo(String value) {
            addCriterion("need_face_comm <=", value, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommLike(String value) {
            addCriterion("need_face_comm like", value, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommNotLike(String value) {
            addCriterion("need_face_comm not like", value, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommIn(List<String> values) {
            addCriterion("need_face_comm in", values, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommNotIn(List<String> values) {
            addCriterion("need_face_comm not in", values, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommBetween(String value1, String value2) {
            addCriterion("need_face_comm between", value1, value2, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andNeedFaceCommNotBetween(String value1, String value2) {
            addCriterion("need_face_comm not between", value1, value2, "needFaceComm");
            return (Criteria) this;
        }

        public Criteria andSolveTimeIsNull() {
            addCriterion("solve_time is null");
            return (Criteria) this;
        }

        public Criteria andSolveTimeIsNotNull() {
            addCriterion("solve_time is not null");
            return (Criteria) this;
        }

        public Criteria andSolveTimeEqualTo(Date value) {
            addCriterion("solve_time =", value, "solveTime");
            return (Criteria) this;
        }

        public Criteria andSolveTimeNotEqualTo(Date value) {
            addCriterion("solve_time <>", value, "solveTime");
            return (Criteria) this;
        }

        public Criteria andSolveTimeGreaterThan(Date value) {
            addCriterion("solve_time >", value, "solveTime");
            return (Criteria) this;
        }

        public Criteria andSolveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("solve_time >=", value, "solveTime");
            return (Criteria) this;
        }

        public Criteria andSolveTimeLessThan(Date value) {
            addCriterion("solve_time <", value, "solveTime");
            return (Criteria) this;
        }

        public Criteria andSolveTimeLessThanOrEqualTo(Date value) {
            addCriterion("solve_time <=", value, "solveTime");
            return (Criteria) this;
        }

        public Criteria andSolveTimeIn(List<Date> values) {
            addCriterion("solve_time in", values, "solveTime");
            return (Criteria) this;
        }

        public Criteria andSolveTimeNotIn(List<Date> values) {
            addCriterion("solve_time not in", values, "solveTime");
            return (Criteria) this;
        }

        public Criteria andSolveTimeBetween(Date value1, Date value2) {
            addCriterion("solve_time between", value1, value2, "solveTime");
            return (Criteria) this;
        }

        public Criteria andSolveTimeNotBetween(Date value1, Date value2) {
            addCriterion("solve_time not between", value1, value2, "solveTime");
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

        public Criteria andQuestionPersonEqualTo(Long value) {
            addCriterion("question_person =", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonNotEqualTo(Long value) {
            addCriterion("question_person <>", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonGreaterThan(Long value) {
            addCriterion("question_person >", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonGreaterThanOrEqualTo(Long value) {
            addCriterion("question_person >=", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonLessThan(Long value) {
            addCriterion("question_person <", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonLessThanOrEqualTo(Long value) {
            addCriterion("question_person <=", value, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonIn(List<Long> values) {
            addCriterion("question_person in", values, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonNotIn(List<Long> values) {
            addCriterion("question_person not in", values, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonBetween(Long value1, Long value2) {
            addCriterion("question_person between", value1, value2, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andQuestionPersonNotBetween(Long value1, Long value2) {
            addCriterion("question_person not between", value1, value2, "questionPerson");
            return (Criteria) this;
        }

        public Criteria andSolvePersonIsNull() {
            addCriterion("solve_person is null");
            return (Criteria) this;
        }

        public Criteria andSolvePersonIsNotNull() {
            addCriterion("solve_person is not null");
            return (Criteria) this;
        }

        public Criteria andSolvePersonEqualTo(Long value) {
            addCriterion("solve_person =", value, "solvePerson");
            return (Criteria) this;
        }

        public Criteria andSolvePersonNotEqualTo(Long value) {
            addCriterion("solve_person <>", value, "solvePerson");
            return (Criteria) this;
        }

        public Criteria andSolvePersonGreaterThan(Long value) {
            addCriterion("solve_person >", value, "solvePerson");
            return (Criteria) this;
        }

        public Criteria andSolvePersonGreaterThanOrEqualTo(Long value) {
            addCriterion("solve_person >=", value, "solvePerson");
            return (Criteria) this;
        }

        public Criteria andSolvePersonLessThan(Long value) {
            addCriterion("solve_person <", value, "solvePerson");
            return (Criteria) this;
        }

        public Criteria andSolvePersonLessThanOrEqualTo(Long value) {
            addCriterion("solve_person <=", value, "solvePerson");
            return (Criteria) this;
        }

        public Criteria andSolvePersonIn(List<Long> values) {
            addCriterion("solve_person in", values, "solvePerson");
            return (Criteria) this;
        }

        public Criteria andSolvePersonNotIn(List<Long> values) {
            addCriterion("solve_person not in", values, "solvePerson");
            return (Criteria) this;
        }

        public Criteria andSolvePersonBetween(Long value1, Long value2) {
            addCriterion("solve_person between", value1, value2, "solvePerson");
            return (Criteria) this;
        }

        public Criteria andSolvePersonNotBetween(Long value1, Long value2) {
            addCriterion("solve_person not between", value1, value2, "solvePerson");
            return (Criteria) this;
        }
    }

    /**
     * qa_s_question
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * qa_s_question 2017-03-04
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