package com.qaplus.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QaSendMailInfoExample {
    /**
     * qa_send_mail_info
     */
    protected String orderByClause;

    /**
     * qa_send_mail_info
     */
    protected boolean distinct;

    /**
     * qa_send_mail_info
     */
    protected List<Criteria> oredCriteria;

    public QaSendMailInfoExample() {
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
     * qa_send_mail_info 2017-03-04
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

        public Criteria andSenderIsNull() {
            addCriterion("sender is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("sender is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("sender =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("sender <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("sender >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("sender >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("sender <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("sender <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("sender like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("sender not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("sender in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("sender not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("sender between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andReceiversIsNull() {
            addCriterion("receivers is null");
            return (Criteria) this;
        }

        public Criteria andReceiversIsNotNull() {
            addCriterion("receivers is not null");
            return (Criteria) this;
        }

        public Criteria andReceiversEqualTo(String value) {
            addCriterion("receivers =", value, "receivers");
            return (Criteria) this;
        }

        public Criteria andReceiversNotEqualTo(String value) {
            addCriterion("receivers <>", value, "receivers");
            return (Criteria) this;
        }

        public Criteria andReceiversGreaterThan(String value) {
            addCriterion("receivers >", value, "receivers");
            return (Criteria) this;
        }

        public Criteria andReceiversGreaterThanOrEqualTo(String value) {
            addCriterion("receivers >=", value, "receivers");
            return (Criteria) this;
        }

        public Criteria andReceiversLessThan(String value) {
            addCriterion("receivers <", value, "receivers");
            return (Criteria) this;
        }

        public Criteria andReceiversLessThanOrEqualTo(String value) {
            addCriterion("receivers <=", value, "receivers");
            return (Criteria) this;
        }

        public Criteria andReceiversLike(String value) {
            addCriterion("receivers like", value, "receivers");
            return (Criteria) this;
        }

        public Criteria andReceiversNotLike(String value) {
            addCriterion("receivers not like", value, "receivers");
            return (Criteria) this;
        }

        public Criteria andReceiversIn(List<String> values) {
            addCriterion("receivers in", values, "receivers");
            return (Criteria) this;
        }

        public Criteria andReceiversNotIn(List<String> values) {
            addCriterion("receivers not in", values, "receivers");
            return (Criteria) this;
        }

        public Criteria andReceiversBetween(String value1, String value2) {
            addCriterion("receivers between", value1, value2, "receivers");
            return (Criteria) this;
        }

        public Criteria andReceiversNotBetween(String value1, String value2) {
            addCriterion("receivers not between", value1, value2, "receivers");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMailContentIsNull() {
            addCriterion("mail_content is null");
            return (Criteria) this;
        }

        public Criteria andMailContentIsNotNull() {
            addCriterion("mail_content is not null");
            return (Criteria) this;
        }

        public Criteria andMailContentEqualTo(String value) {
            addCriterion("mail_content =", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentNotEqualTo(String value) {
            addCriterion("mail_content <>", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentGreaterThan(String value) {
            addCriterion("mail_content >", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentGreaterThanOrEqualTo(String value) {
            addCriterion("mail_content >=", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentLessThan(String value) {
            addCriterion("mail_content <", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentLessThanOrEqualTo(String value) {
            addCriterion("mail_content <=", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentLike(String value) {
            addCriterion("mail_content like", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentNotLike(String value) {
            addCriterion("mail_content not like", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentIn(List<String> values) {
            addCriterion("mail_content in", values, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentNotIn(List<String> values) {
            addCriterion("mail_content not in", values, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentBetween(String value1, String value2) {
            addCriterion("mail_content between", value1, value2, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentNotBetween(String value1, String value2) {
            addCriterion("mail_content not between", value1, value2, "mailContent");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNull() {
            addCriterion("template_name is null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNotNull() {
            addCriterion("template_name is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameEqualTo(String value) {
            addCriterion("template_name =", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotEqualTo(String value) {
            addCriterion("template_name <>", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThan(String value) {
            addCriterion("template_name >", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("template_name >=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThan(String value) {
            addCriterion("template_name <", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("template_name <=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLike(String value) {
            addCriterion("template_name like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotLike(String value) {
            addCriterion("template_name not like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIn(List<String> values) {
            addCriterion("template_name in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotIn(List<String> values) {
            addCriterion("template_name not in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameBetween(String value1, String value2) {
            addCriterion("template_name between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotBetween(String value1, String value2) {
            addCriterion("template_name not between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(Long value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(Long value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(Long value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(Long value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(Long value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<Long> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<Long> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(Long value1, Long value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(Long value1, Long value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }
    }

    /**
     * qa_send_mail_info
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * qa_send_mail_info 2017-03-04
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