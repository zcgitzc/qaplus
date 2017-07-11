package com.qaplus.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QaPaperExample {
    /**
     * qa_paper
     */
    protected String orderByClause;

    /**
     * qa_paper
     */
    protected boolean distinct;

    /**
     * qa_paper
     */
    protected List<Criteria> oredCriteria;

    public QaPaperExample() {
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
     * qa_paper 2017-03-04
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

        public Criteria andTotalScoreIsNull() {
            addCriterion("total_score is null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNotNull() {
            addCriterion("total_score is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreEqualTo(Integer value) {
            addCriterion("total_score =", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotEqualTo(Integer value) {
            addCriterion("total_score <>", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThan(Integer value) {
            addCriterion("total_score >", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_score >=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThan(Integer value) {
            addCriterion("total_score <", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("total_score <=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIn(List<Integer> values) {
            addCriterion("total_score in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotIn(List<Integer> values) {
            addCriterion("total_score not in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("total_score between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("total_score not between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountIsNull() {
            addCriterion("question_amount is null");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountIsNotNull() {
            addCriterion("question_amount is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountEqualTo(Integer value) {
            addCriterion("question_amount =", value, "questionAmount");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountNotEqualTo(Integer value) {
            addCriterion("question_amount <>", value, "questionAmount");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountGreaterThan(Integer value) {
            addCriterion("question_amount >", value, "questionAmount");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_amount >=", value, "questionAmount");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountLessThan(Integer value) {
            addCriterion("question_amount <", value, "questionAmount");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountLessThanOrEqualTo(Integer value) {
            addCriterion("question_amount <=", value, "questionAmount");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountIn(List<Integer> values) {
            addCriterion("question_amount in", values, "questionAmount");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountNotIn(List<Integer> values) {
            addCriterion("question_amount not in", values, "questionAmount");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountBetween(Integer value1, Integer value2) {
            addCriterion("question_amount between", value1, value2, "questionAmount");
            return (Criteria) this;
        }

        public Criteria andQuestionAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("question_amount not between", value1, value2, "questionAmount");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsIsNull() {
            addCriterion("question_ids is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsIsNotNull() {
            addCriterion("question_ids is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsEqualTo(String value) {
            addCriterion("question_ids =", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotEqualTo(String value) {
            addCriterion("question_ids <>", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsGreaterThan(String value) {
            addCriterion("question_ids >", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsGreaterThanOrEqualTo(String value) {
            addCriterion("question_ids >=", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsLessThan(String value) {
            addCriterion("question_ids <", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsLessThanOrEqualTo(String value) {
            addCriterion("question_ids <=", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsLike(String value) {
            addCriterion("question_ids like", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotLike(String value) {
            addCriterion("question_ids not like", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsIn(List<String> values) {
            addCriterion("question_ids in", values, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotIn(List<String> values) {
            addCriterion("question_ids not in", values, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsBetween(String value1, String value2) {
            addCriterion("question_ids between", value1, value2, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotBetween(String value1, String value2) {
            addCriterion("question_ids not between", value1, value2, "questionIds");
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

        public Criteria andInvigilatePersonIsNull() {
            addCriterion("invigilate_person is null");
            return (Criteria) this;
        }

        public Criteria andInvigilatePersonIsNotNull() {
            addCriterion("invigilate_person is not null");
            return (Criteria) this;
        }

        public Criteria andInvigilatePersonEqualTo(Long value) {
            addCriterion("invigilate_person =", value, "invigilatePerson");
            return (Criteria) this;
        }

        public Criteria andInvigilatePersonNotEqualTo(Long value) {
            addCriterion("invigilate_person <>", value, "invigilatePerson");
            return (Criteria) this;
        }

        public Criteria andInvigilatePersonGreaterThan(Long value) {
            addCriterion("invigilate_person >", value, "invigilatePerson");
            return (Criteria) this;
        }

        public Criteria andInvigilatePersonGreaterThanOrEqualTo(Long value) {
            addCriterion("invigilate_person >=", value, "invigilatePerson");
            return (Criteria) this;
        }

        public Criteria andInvigilatePersonLessThan(Long value) {
            addCriterion("invigilate_person <", value, "invigilatePerson");
            return (Criteria) this;
        }

        public Criteria andInvigilatePersonLessThanOrEqualTo(Long value) {
            addCriterion("invigilate_person <=", value, "invigilatePerson");
            return (Criteria) this;
        }

        public Criteria andInvigilatePersonIn(List<Long> values) {
            addCriterion("invigilate_person in", values, "invigilatePerson");
            return (Criteria) this;
        }

        public Criteria andInvigilatePersonNotIn(List<Long> values) {
            addCriterion("invigilate_person not in", values, "invigilatePerson");
            return (Criteria) this;
        }

        public Criteria andInvigilatePersonBetween(Long value1, Long value2) {
            addCriterion("invigilate_person between", value1, value2, "invigilatePerson");
            return (Criteria) this;
        }

        public Criteria andInvigilatePersonNotBetween(Long value1, Long value2) {
            addCriterion("invigilate_person not between", value1, value2, "invigilatePerson");
            return (Criteria) this;
        }

        public Criteria andPaperPersonIsNull() {
            addCriterion("paper_person is null");
            return (Criteria) this;
        }

        public Criteria andPaperPersonIsNotNull() {
            addCriterion("paper_person is not null");
            return (Criteria) this;
        }

        public Criteria andPaperPersonEqualTo(Long value) {
            addCriterion("paper_person =", value, "paperPerson");
            return (Criteria) this;
        }

        public Criteria andPaperPersonNotEqualTo(Long value) {
            addCriterion("paper_person <>", value, "paperPerson");
            return (Criteria) this;
        }

        public Criteria andPaperPersonGreaterThan(Long value) {
            addCriterion("paper_person >", value, "paperPerson");
            return (Criteria) this;
        }

        public Criteria andPaperPersonGreaterThanOrEqualTo(Long value) {
            addCriterion("paper_person >=", value, "paperPerson");
            return (Criteria) this;
        }

        public Criteria andPaperPersonLessThan(Long value) {
            addCriterion("paper_person <", value, "paperPerson");
            return (Criteria) this;
        }

        public Criteria andPaperPersonLessThanOrEqualTo(Long value) {
            addCriterion("paper_person <=", value, "paperPerson");
            return (Criteria) this;
        }

        public Criteria andPaperPersonIn(List<Long> values) {
            addCriterion("paper_person in", values, "paperPerson");
            return (Criteria) this;
        }

        public Criteria andPaperPersonNotIn(List<Long> values) {
            addCriterion("paper_person not in", values, "paperPerson");
            return (Criteria) this;
        }

        public Criteria andPaperPersonBetween(Long value1, Long value2) {
            addCriterion("paper_person between", value1, value2, "paperPerson");
            return (Criteria) this;
        }

        public Criteria andPaperPersonNotBetween(Long value1, Long value2) {
            addCriterion("paper_person not between", value1, value2, "paperPerson");
            return (Criteria) this;
        }

        public Criteria andPaperTitleIsNull() {
            addCriterion("paper_title is null");
            return (Criteria) this;
        }

        public Criteria andPaperTitleIsNotNull() {
            addCriterion("paper_title is not null");
            return (Criteria) this;
        }

        public Criteria andPaperTitleEqualTo(String value) {
            addCriterion("paper_title =", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleNotEqualTo(String value) {
            addCriterion("paper_title <>", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleGreaterThan(String value) {
            addCriterion("paper_title >", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleGreaterThanOrEqualTo(String value) {
            addCriterion("paper_title >=", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleLessThan(String value) {
            addCriterion("paper_title <", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleLessThanOrEqualTo(String value) {
            addCriterion("paper_title <=", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleLike(String value) {
            addCriterion("paper_title like", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleNotLike(String value) {
            addCriterion("paper_title not like", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleIn(List<String> values) {
            addCriterion("paper_title in", values, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleNotIn(List<String> values) {
            addCriterion("paper_title not in", values, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleBetween(String value1, String value2) {
            addCriterion("paper_title between", value1, value2, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleNotBetween(String value1, String value2) {
            addCriterion("paper_title not between", value1, value2, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryIsNull() {
            addCriterion("paper_category is null");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryIsNotNull() {
            addCriterion("paper_category is not null");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryEqualTo(String value) {
            addCriterion("paper_category =", value, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryNotEqualTo(String value) {
            addCriterion("paper_category <>", value, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryGreaterThan(String value) {
            addCriterion("paper_category >", value, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("paper_category >=", value, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryLessThan(String value) {
            addCriterion("paper_category <", value, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryLessThanOrEqualTo(String value) {
            addCriterion("paper_category <=", value, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryLike(String value) {
            addCriterion("paper_category like", value, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryNotLike(String value) {
            addCriterion("paper_category not like", value, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryIn(List<String> values) {
            addCriterion("paper_category in", values, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryNotIn(List<String> values) {
            addCriterion("paper_category not in", values, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryBetween(String value1, String value2) {
            addCriterion("paper_category between", value1, value2, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andPaperCategoryNotBetween(String value1, String value2) {
            addCriterion("paper_category not between", value1, value2, "paperCategory");
            return (Criteria) this;
        }

        public Criteria andExamDateIsNull() {
            addCriterion("exam_date is null");
            return (Criteria) this;
        }

        public Criteria andExamDateIsNotNull() {
            addCriterion("exam_date is not null");
            return (Criteria) this;
        }

        public Criteria andExamDateEqualTo(Date value) {
            addCriterion("exam_date =", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateNotEqualTo(Date value) {
            addCriterion("exam_date <>", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateGreaterThan(Date value) {
            addCriterion("exam_date >", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateGreaterThanOrEqualTo(Date value) {
            addCriterion("exam_date >=", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateLessThan(Date value) {
            addCriterion("exam_date <", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateLessThanOrEqualTo(Date value) {
            addCriterion("exam_date <=", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateIn(List<Date> values) {
            addCriterion("exam_date in", values, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateNotIn(List<Date> values) {
            addCriterion("exam_date not in", values, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateBetween(Date value1, Date value2) {
            addCriterion("exam_date between", value1, value2, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateNotBetween(Date value1, Date value2) {
            addCriterion("exam_date not between", value1, value2, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamLongIsNull() {
            addCriterion("exam_long is null");
            return (Criteria) this;
        }

        public Criteria andExamLongIsNotNull() {
            addCriterion("exam_long is not null");
            return (Criteria) this;
        }

        public Criteria andExamLongEqualTo(Integer value) {
            addCriterion("exam_long =", value, "examLong");
            return (Criteria) this;
        }

        public Criteria andExamLongNotEqualTo(Integer value) {
            addCriterion("exam_long <>", value, "examLong");
            return (Criteria) this;
        }

        public Criteria andExamLongGreaterThan(Integer value) {
            addCriterion("exam_long >", value, "examLong");
            return (Criteria) this;
        }

        public Criteria andExamLongGreaterThanOrEqualTo(Integer value) {
            addCriterion("exam_long >=", value, "examLong");
            return (Criteria) this;
        }

        public Criteria andExamLongLessThan(Integer value) {
            addCriterion("exam_long <", value, "examLong");
            return (Criteria) this;
        }

        public Criteria andExamLongLessThanOrEqualTo(Integer value) {
            addCriterion("exam_long <=", value, "examLong");
            return (Criteria) this;
        }

        public Criteria andExamLongIn(List<Integer> values) {
            addCriterion("exam_long in", values, "examLong");
            return (Criteria) this;
        }

        public Criteria andExamLongNotIn(List<Integer> values) {
            addCriterion("exam_long not in", values, "examLong");
            return (Criteria) this;
        }

        public Criteria andExamLongBetween(Integer value1, Integer value2) {
            addCriterion("exam_long between", value1, value2, "examLong");
            return (Criteria) this;
        }

        public Criteria andExamLongNotBetween(Integer value1, Integer value2) {
            addCriterion("exam_long not between", value1, value2, "examLong");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionIsNull() {
            addCriterion("upset_question is null");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionIsNotNull() {
            addCriterion("upset_question is not null");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionEqualTo(String value) {
            addCriterion("upset_question =", value, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionNotEqualTo(String value) {
            addCriterion("upset_question <>", value, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionGreaterThan(String value) {
            addCriterion("upset_question >", value, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("upset_question >=", value, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionLessThan(String value) {
            addCriterion("upset_question <", value, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionLessThanOrEqualTo(String value) {
            addCriterion("upset_question <=", value, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionLike(String value) {
            addCriterion("upset_question like", value, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionNotLike(String value) {
            addCriterion("upset_question not like", value, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionIn(List<String> values) {
            addCriterion("upset_question in", values, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionNotIn(List<String> values) {
            addCriterion("upset_question not in", values, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionBetween(String value1, String value2) {
            addCriterion("upset_question between", value1, value2, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andUpsetQuestionNotBetween(String value1, String value2) {
            addCriterion("upset_question not between", value1, value2, "upsetQuestion");
            return (Criteria) this;
        }

        public Criteria andIsEffectIsNull() {
            addCriterion("is_effect is null");
            return (Criteria) this;
        }

        public Criteria andIsEffectIsNotNull() {
            addCriterion("is_effect is not null");
            return (Criteria) this;
        }

        public Criteria andIsEffectEqualTo(String value) {
            addCriterion("is_effect =", value, "isEffect");
            return (Criteria) this;
        }

        public Criteria andIsEffectNotEqualTo(String value) {
            addCriterion("is_effect <>", value, "isEffect");
            return (Criteria) this;
        }

        public Criteria andIsEffectGreaterThan(String value) {
            addCriterion("is_effect >", value, "isEffect");
            return (Criteria) this;
        }

        public Criteria andIsEffectGreaterThanOrEqualTo(String value) {
            addCriterion("is_effect >=", value, "isEffect");
            return (Criteria) this;
        }

        public Criteria andIsEffectLessThan(String value) {
            addCriterion("is_effect <", value, "isEffect");
            return (Criteria) this;
        }

        public Criteria andIsEffectLessThanOrEqualTo(String value) {
            addCriterion("is_effect <=", value, "isEffect");
            return (Criteria) this;
        }

        public Criteria andIsEffectLike(String value) {
            addCriterion("is_effect like", value, "isEffect");
            return (Criteria) this;
        }

        public Criteria andIsEffectNotLike(String value) {
            addCriterion("is_effect not like", value, "isEffect");
            return (Criteria) this;
        }

        public Criteria andIsEffectIn(List<String> values) {
            addCriterion("is_effect in", values, "isEffect");
            return (Criteria) this;
        }

        public Criteria andIsEffectNotIn(List<String> values) {
            addCriterion("is_effect not in", values, "isEffect");
            return (Criteria) this;
        }

        public Criteria andIsEffectBetween(String value1, String value2) {
            addCriterion("is_effect between", value1, value2, "isEffect");
            return (Criteria) this;
        }

        public Criteria andIsEffectNotBetween(String value1, String value2) {
            addCriterion("is_effect not between", value1, value2, "isEffect");
            return (Criteria) this;
        }

        public Criteria andUpsetItemIsNull() {
            addCriterion("upset_item is null");
            return (Criteria) this;
        }

        public Criteria andUpsetItemIsNotNull() {
            addCriterion("upset_item is not null");
            return (Criteria) this;
        }

        public Criteria andUpsetItemEqualTo(String value) {
            addCriterion("upset_item =", value, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andUpsetItemNotEqualTo(String value) {
            addCriterion("upset_item <>", value, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andUpsetItemGreaterThan(String value) {
            addCriterion("upset_item >", value, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andUpsetItemGreaterThanOrEqualTo(String value) {
            addCriterion("upset_item >=", value, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andUpsetItemLessThan(String value) {
            addCriterion("upset_item <", value, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andUpsetItemLessThanOrEqualTo(String value) {
            addCriterion("upset_item <=", value, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andUpsetItemLike(String value) {
            addCriterion("upset_item like", value, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andUpsetItemNotLike(String value) {
            addCriterion("upset_item not like", value, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andUpsetItemIn(List<String> values) {
            addCriterion("upset_item in", values, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andUpsetItemNotIn(List<String> values) {
            addCriterion("upset_item not in", values, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andUpsetItemBetween(String value1, String value2) {
            addCriterion("upset_item between", value1, value2, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andUpsetItemNotBetween(String value1, String value2) {
            addCriterion("upset_item not between", value1, value2, "upsetItem");
            return (Criteria) this;
        }

        public Criteria andPaperStatusIsNull() {
            addCriterion("paper_status is null");
            return (Criteria) this;
        }

        public Criteria andPaperStatusIsNotNull() {
            addCriterion("paper_status is not null");
            return (Criteria) this;
        }

        public Criteria andPaperStatusEqualTo(String value) {
            addCriterion("paper_status =", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusNotEqualTo(String value) {
            addCriterion("paper_status <>", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusGreaterThan(String value) {
            addCriterion("paper_status >", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusGreaterThanOrEqualTo(String value) {
            addCriterion("paper_status >=", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusLessThan(String value) {
            addCriterion("paper_status <", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusLessThanOrEqualTo(String value) {
            addCriterion("paper_status <=", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusLike(String value) {
            addCriterion("paper_status like", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusNotLike(String value) {
            addCriterion("paper_status not like", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusIn(List<String> values) {
            addCriterion("paper_status in", values, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusNotIn(List<String> values) {
            addCriterion("paper_status not in", values, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusBetween(String value1, String value2) {
            addCriterion("paper_status between", value1, value2, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusNotBetween(String value1, String value2) {
            addCriterion("paper_status not between", value1, value2, "paperStatus");
            return (Criteria) this;
        }
    }

    /**
     * qa_paper
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * qa_paper 2017-03-04
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