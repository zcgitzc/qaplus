package com.qaplus.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QaResourcesExample {
    /**
     * qa_resources
     */
    protected String orderByClause;

    /**
     * qa_resources
     */
    protected boolean distinct;

    /**
     * qa_resources
     */
    protected List<Criteria> oredCriteria;

    public QaResourcesExample() {
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
     * qa_resources 2017-03-04
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andResKeyIsNull() {
            addCriterion("res_key is null");
            return (Criteria) this;
        }

        public Criteria andResKeyIsNotNull() {
            addCriterion("res_key is not null");
            return (Criteria) this;
        }

        public Criteria andResKeyEqualTo(String value) {
            addCriterion("res_key =", value, "resKey");
            return (Criteria) this;
        }

        public Criteria andResKeyNotEqualTo(String value) {
            addCriterion("res_key <>", value, "resKey");
            return (Criteria) this;
        }

        public Criteria andResKeyGreaterThan(String value) {
            addCriterion("res_key >", value, "resKey");
            return (Criteria) this;
        }

        public Criteria andResKeyGreaterThanOrEqualTo(String value) {
            addCriterion("res_key >=", value, "resKey");
            return (Criteria) this;
        }

        public Criteria andResKeyLessThan(String value) {
            addCriterion("res_key <", value, "resKey");
            return (Criteria) this;
        }

        public Criteria andResKeyLessThanOrEqualTo(String value) {
            addCriterion("res_key <=", value, "resKey");
            return (Criteria) this;
        }

        public Criteria andResKeyLike(String value) {
            addCriterion("res_key like", value, "resKey");
            return (Criteria) this;
        }

        public Criteria andResKeyNotLike(String value) {
            addCriterion("res_key not like", value, "resKey");
            return (Criteria) this;
        }

        public Criteria andResKeyIn(List<String> values) {
            addCriterion("res_key in", values, "resKey");
            return (Criteria) this;
        }

        public Criteria andResKeyNotIn(List<String> values) {
            addCriterion("res_key not in", values, "resKey");
            return (Criteria) this;
        }

        public Criteria andResKeyBetween(String value1, String value2) {
            addCriterion("res_key between", value1, value2, "resKey");
            return (Criteria) this;
        }

        public Criteria andResKeyNotBetween(String value1, String value2) {
            addCriterion("res_key not between", value1, value2, "resKey");
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

        public Criteria andResUrlIsNull() {
            addCriterion("res_url is null");
            return (Criteria) this;
        }

        public Criteria andResUrlIsNotNull() {
            addCriterion("res_url is not null");
            return (Criteria) this;
        }

        public Criteria andResUrlEqualTo(String value) {
            addCriterion("res_url =", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotEqualTo(String value) {
            addCriterion("res_url <>", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlGreaterThan(String value) {
            addCriterion("res_url >", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlGreaterThanOrEqualTo(String value) {
            addCriterion("res_url >=", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlLessThan(String value) {
            addCriterion("res_url <", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlLessThanOrEqualTo(String value) {
            addCriterion("res_url <=", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlLike(String value) {
            addCriterion("res_url like", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotLike(String value) {
            addCriterion("res_url not like", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlIn(List<String> values) {
            addCriterion("res_url in", values, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotIn(List<String> values) {
            addCriterion("res_url not in", values, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlBetween(String value1, String value2) {
            addCriterion("res_url between", value1, value2, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotBetween(String value1, String value2) {
            addCriterion("res_url not between", value1, value2, "resUrl");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
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
    }

    /**
     * qa_resources
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * qa_resources 2017-03-04
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