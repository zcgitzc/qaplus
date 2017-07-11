package com.qaplus.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QaExcelConfigExample {
    /**
     * qa_excel_config
     */
    protected String orderByClause;

    /**
     * qa_excel_config
     */
    protected boolean distinct;

    /**
     * qa_excel_config
     */
    protected List<Criteria> oredCriteria;

    public QaExcelConfigExample() {
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
     * qa_excel_config 2017-03-04
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

        public Criteria andPrimaryKeyIsNull() {
            addCriterion("primary_key is null");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyIsNotNull() {
            addCriterion("primary_key is not null");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyEqualTo(String value) {
            addCriterion("primary_key =", value, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyNotEqualTo(String value) {
            addCriterion("primary_key <>", value, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyGreaterThan(String value) {
            addCriterion("primary_key >", value, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyGreaterThanOrEqualTo(String value) {
            addCriterion("primary_key >=", value, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyLessThan(String value) {
            addCriterion("primary_key <", value, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyLessThanOrEqualTo(String value) {
            addCriterion("primary_key <=", value, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyLike(String value) {
            addCriterion("primary_key like", value, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyNotLike(String value) {
            addCriterion("primary_key not like", value, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyIn(List<String> values) {
            addCriterion("primary_key in", values, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyNotIn(List<String> values) {
            addCriterion("primary_key not in", values, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyBetween(String value1, String value2) {
            addCriterion("primary_key between", value1, value2, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPrimaryKeyNotBetween(String value1, String value2) {
            addCriterion("primary_key not between", value1, value2, "primaryKey");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNull() {
            addCriterion("property is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNotNull() {
            addCriterion("property is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyEqualTo(String value) {
            addCriterion("property =", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotEqualTo(String value) {
            addCriterion("property <>", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThan(String value) {
            addCriterion("property >", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("property >=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThan(String value) {
            addCriterion("property <", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThanOrEqualTo(String value) {
            addCriterion("property <=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLike(String value) {
            addCriterion("property like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotLike(String value) {
            addCriterion("property not like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyIn(List<String> values) {
            addCriterion("property in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotIn(List<String> values) {
            addCriterion("property not in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyBetween(String value1, String value2) {
            addCriterion("property between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotBetween(String value1, String value2) {
            addCriterion("property not between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andHeaderNameIsNull() {
            addCriterion("header_name is null");
            return (Criteria) this;
        }

        public Criteria andHeaderNameIsNotNull() {
            addCriterion("header_name is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderNameEqualTo(String value) {
            addCriterion("header_name =", value, "headerName");
            return (Criteria) this;
        }

        public Criteria andHeaderNameNotEqualTo(String value) {
            addCriterion("header_name <>", value, "headerName");
            return (Criteria) this;
        }

        public Criteria andHeaderNameGreaterThan(String value) {
            addCriterion("header_name >", value, "headerName");
            return (Criteria) this;
        }

        public Criteria andHeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("header_name >=", value, "headerName");
            return (Criteria) this;
        }

        public Criteria andHeaderNameLessThan(String value) {
            addCriterion("header_name <", value, "headerName");
            return (Criteria) this;
        }

        public Criteria andHeaderNameLessThanOrEqualTo(String value) {
            addCriterion("header_name <=", value, "headerName");
            return (Criteria) this;
        }

        public Criteria andHeaderNameLike(String value) {
            addCriterion("header_name like", value, "headerName");
            return (Criteria) this;
        }

        public Criteria andHeaderNameNotLike(String value) {
            addCriterion("header_name not like", value, "headerName");
            return (Criteria) this;
        }

        public Criteria andHeaderNameIn(List<String> values) {
            addCriterion("header_name in", values, "headerName");
            return (Criteria) this;
        }

        public Criteria andHeaderNameNotIn(List<String> values) {
            addCriterion("header_name not in", values, "headerName");
            return (Criteria) this;
        }

        public Criteria andHeaderNameBetween(String value1, String value2) {
            addCriterion("header_name between", value1, value2, "headerName");
            return (Criteria) this;
        }

        public Criteria andHeaderNameNotBetween(String value1, String value2) {
            addCriterion("header_name not between", value1, value2, "headerName");
            return (Criteria) this;
        }

        public Criteria andColumnKeyIsNull() {
            addCriterion("column_key is null");
            return (Criteria) this;
        }

        public Criteria andColumnKeyIsNotNull() {
            addCriterion("column_key is not null");
            return (Criteria) this;
        }

        public Criteria andColumnKeyEqualTo(String value) {
            addCriterion("column_key =", value, "columnKey");
            return (Criteria) this;
        }

        public Criteria andColumnKeyNotEqualTo(String value) {
            addCriterion("column_key <>", value, "columnKey");
            return (Criteria) this;
        }

        public Criteria andColumnKeyGreaterThan(String value) {
            addCriterion("column_key >", value, "columnKey");
            return (Criteria) this;
        }

        public Criteria andColumnKeyGreaterThanOrEqualTo(String value) {
            addCriterion("column_key >=", value, "columnKey");
            return (Criteria) this;
        }

        public Criteria andColumnKeyLessThan(String value) {
            addCriterion("column_key <", value, "columnKey");
            return (Criteria) this;
        }

        public Criteria andColumnKeyLessThanOrEqualTo(String value) {
            addCriterion("column_key <=", value, "columnKey");
            return (Criteria) this;
        }

        public Criteria andColumnKeyLike(String value) {
            addCriterion("column_key like", value, "columnKey");
            return (Criteria) this;
        }

        public Criteria andColumnKeyNotLike(String value) {
            addCriterion("column_key not like", value, "columnKey");
            return (Criteria) this;
        }

        public Criteria andColumnKeyIn(List<String> values) {
            addCriterion("column_key in", values, "columnKey");
            return (Criteria) this;
        }

        public Criteria andColumnKeyNotIn(List<String> values) {
            addCriterion("column_key not in", values, "columnKey");
            return (Criteria) this;
        }

        public Criteria andColumnKeyBetween(String value1, String value2) {
            addCriterion("column_key between", value1, value2, "columnKey");
            return (Criteria) this;
        }

        public Criteria andColumnKeyNotBetween(String value1, String value2) {
            addCriterion("column_key not between", value1, value2, "columnKey");
            return (Criteria) this;
        }

        public Criteria andSerialIsNull() {
            addCriterion("serial is null");
            return (Criteria) this;
        }

        public Criteria andSerialIsNotNull() {
            addCriterion("serial is not null");
            return (Criteria) this;
        }

        public Criteria andSerialEqualTo(Integer value) {
            addCriterion("serial =", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotEqualTo(Integer value) {
            addCriterion("serial <>", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThan(Integer value) {
            addCriterion("serial >", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial >=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThan(Integer value) {
            addCriterion("serial <", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThanOrEqualTo(Integer value) {
            addCriterion("serial <=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialIn(List<Integer> values) {
            addCriterion("serial in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotIn(List<Integer> values) {
            addCriterion("serial not in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialBetween(Integer value1, Integer value2) {
            addCriterion("serial between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotBetween(Integer value1, Integer value2) {
            addCriterion("serial not between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andFormatStyleIsNull() {
            addCriterion("format_style is null");
            return (Criteria) this;
        }

        public Criteria andFormatStyleIsNotNull() {
            addCriterion("format_style is not null");
            return (Criteria) this;
        }

        public Criteria andFormatStyleEqualTo(String value) {
            addCriterion("format_style =", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleNotEqualTo(String value) {
            addCriterion("format_style <>", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleGreaterThan(String value) {
            addCriterion("format_style >", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleGreaterThanOrEqualTo(String value) {
            addCriterion("format_style >=", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleLessThan(String value) {
            addCriterion("format_style <", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleLessThanOrEqualTo(String value) {
            addCriterion("format_style <=", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleLike(String value) {
            addCriterion("format_style like", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleNotLike(String value) {
            addCriterion("format_style not like", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleIn(List<String> values) {
            addCriterion("format_style in", values, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleNotIn(List<String> values) {
            addCriterion("format_style not in", values, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleBetween(String value1, String value2) {
            addCriterion("format_style between", value1, value2, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleNotBetween(String value1, String value2) {
            addCriterion("format_style not between", value1, value2, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andCommonKeyIsNull() {
            addCriterion("common_key is null");
            return (Criteria) this;
        }

        public Criteria andCommonKeyIsNotNull() {
            addCriterion("common_key is not null");
            return (Criteria) this;
        }

        public Criteria andCommonKeyEqualTo(String value) {
            addCriterion("common_key =", value, "commonKey");
            return (Criteria) this;
        }

        public Criteria andCommonKeyNotEqualTo(String value) {
            addCriterion("common_key <>", value, "commonKey");
            return (Criteria) this;
        }

        public Criteria andCommonKeyGreaterThan(String value) {
            addCriterion("common_key >", value, "commonKey");
            return (Criteria) this;
        }

        public Criteria andCommonKeyGreaterThanOrEqualTo(String value) {
            addCriterion("common_key >=", value, "commonKey");
            return (Criteria) this;
        }

        public Criteria andCommonKeyLessThan(String value) {
            addCriterion("common_key <", value, "commonKey");
            return (Criteria) this;
        }

        public Criteria andCommonKeyLessThanOrEqualTo(String value) {
            addCriterion("common_key <=", value, "commonKey");
            return (Criteria) this;
        }

        public Criteria andCommonKeyLike(String value) {
            addCriterion("common_key like", value, "commonKey");
            return (Criteria) this;
        }

        public Criteria andCommonKeyNotLike(String value) {
            addCriterion("common_key not like", value, "commonKey");
            return (Criteria) this;
        }

        public Criteria andCommonKeyIn(List<String> values) {
            addCriterion("common_key in", values, "commonKey");
            return (Criteria) this;
        }

        public Criteria andCommonKeyNotIn(List<String> values) {
            addCriterion("common_key not in", values, "commonKey");
            return (Criteria) this;
        }

        public Criteria andCommonKeyBetween(String value1, String value2) {
            addCriterion("common_key between", value1, value2, "commonKey");
            return (Criteria) this;
        }

        public Criteria andCommonKeyNotBetween(String value1, String value2) {
            addCriterion("common_key not between", value1, value2, "commonKey");
            return (Criteria) this;
        }
    }

    /**
     * qa_excel_config
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * qa_excel_config 2017-03-04
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