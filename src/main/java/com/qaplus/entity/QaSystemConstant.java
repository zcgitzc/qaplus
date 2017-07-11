package com.qaplus.entity;

import java.util.Date;

public class QaSystemConstant {
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
     * 常量分类
     */
    private String category;

    /**
     * 常量Code（后台需要的值）
     */
    private String code;

    /**
     * 后台接收的属性名称
     */
    private String name;

    /**
     * 常量展示值
     */
    private String text;

    /**
     * 排序
     */
    private Integer serial;

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
     * 常量分类
     * @return category 常量分类
     */
    public String getCategory() {
        return category;
    }

    /**
     * 常量分类
     * @param category 常量分类
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 常量Code（后台需要的值）
     * @return code 常量Code（后台需要的值）
     */
    public String getCode() {
        return code;
    }

    /**
     * 常量Code（后台需要的值）
     * @param code 常量Code（后台需要的值）
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 后台接收的属性名称
     * @return name 后台接收的属性名称
     */
    public String getName() {
        return name;
    }

    /**
     * 后台接收的属性名称
     * @param name 后台接收的属性名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 常量展示值
     * @return text 常量展示值
     */
    public String getText() {
        return text;
    }

    /**
     * 常量展示值
     * @param text 常量展示值
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * 排序
     * @return serial 排序
     */
    public Integer getSerial() {
        return serial;
    }

    /**
     * 排序
     * @param serial 排序
     */
    public void setSerial(Integer serial) {
        this.serial = serial;
    }
}