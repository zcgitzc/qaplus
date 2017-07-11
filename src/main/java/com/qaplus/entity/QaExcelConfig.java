package com.qaplus.entity;

import java.util.Date;

public class QaExcelConfig {
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
     * Excel数据组的唯一标识
     */
    private String primaryKey;

    /**
     * 属性值
     */
    private String property;

    /**
     * Excel头部显示名称
     */
    private String headerName;

    /**
     * 需要特殊处理的Key值
     */
    private String columnKey;

    /**
     * 排序
     */
    private Integer serial;

    /**
     * 格式化
     */
    private String formatStyle;

    /**
     * 公共处理的Key
     */
    private String commonKey;

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
     * Excel数据组的唯一标识
     * @return primary_key Excel数据组的唯一标识
     */
    public String getPrimaryKey() {
        return primaryKey;
    }

    /**
     * Excel数据组的唯一标识
     * @param primaryKey Excel数据组的唯一标识
     */
    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey == null ? null : primaryKey.trim();
    }

    /**
     * 属性值
     * @return property 属性值
     */
    public String getProperty() {
        return property;
    }

    /**
     * 属性值
     * @param property 属性值
     */
    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    /**
     * Excel头部显示名称
     * @return header_name Excel头部显示名称
     */
    public String getHeaderName() {
        return headerName;
    }

    /**
     * Excel头部显示名称
     * @param headerName Excel头部显示名称
     */
    public void setHeaderName(String headerName) {
        this.headerName = headerName == null ? null : headerName.trim();
    }

    /**
     * 需要特殊处理的Key值
     * @return column_key 需要特殊处理的Key值
     */
    public String getColumnKey() {
        return columnKey;
    }

    /**
     * 需要特殊处理的Key值
     * @param columnKey 需要特殊处理的Key值
     */
    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey == null ? null : columnKey.trim();
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

    /**
     * 格式化
     * @return format_style 格式化
     */
    public String getFormatStyle() {
        return formatStyle;
    }

    /**
     * 格式化
     * @param formatStyle 格式化
     */
    public void setFormatStyle(String formatStyle) {
        this.formatStyle = formatStyle == null ? null : formatStyle.trim();
    }

    /**
     * 公共处理的Key
     * @return common_key 公共处理的Key
     */
    public String getCommonKey() {
        return commonKey;
    }

    /**
     * 公共处理的Key
     * @param commonKey 公共处理的Key
     */
    public void setCommonKey(String commonKey) {
        this.commonKey = commonKey == null ? null : commonKey.trim();
    }
}