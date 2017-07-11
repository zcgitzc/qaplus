package com.qaplus.entity;

import java.util.Date;

public class QaResources {
    /**
     * 
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
     * 资源名称
     */
    private String name;

    /**
     * 父类Id
     */
    private Long parentId;

    /**
     * 资源Key
     */
    private String resKey;

    /**
     * 权限类型，0．表示目录　1，表示菜单．2，表示按扭 3 , 首页的显示
     */
    private String type;

    /**
     * 资源链接
     */
    private String resUrl;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 描述
     */
    private String description;

    /**
     * 权限状态（可以回收权限）
     */
    private String status;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
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
     * 资源名称
     * @return name 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 资源名称
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 父类Id
     * @return parent_id 父类Id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父类Id
     * @param parentId 父类Id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 资源Key
     * @return res_key 资源Key
     */
    public String getResKey() {
        return resKey;
    }

    /**
     * 资源Key
     * @param resKey 资源Key
     */
    public void setResKey(String resKey) {
        this.resKey = resKey == null ? null : resKey.trim();
    }

    /**
     * 权限类型，0．表示目录　1，表示菜单．2，表示按扭 3 , 首页的显示
     * @return type 权限类型，0．表示目录　1，表示菜单．2，表示按扭 3 , 首页的显示
     */
    public String getType() {
        return type;
    }

    /**
     * 权限类型，0．表示目录　1，表示菜单．2，表示按扭 3 , 首页的显示
     * @param type 权限类型，0．表示目录　1，表示菜单．2，表示按扭 3 , 首页的显示
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 资源链接
     * @return res_url 资源链接
     */
    public String getResUrl() {
        return resUrl;
    }

    /**
     * 资源链接
     * @param resUrl 资源链接
     */
    public void setResUrl(String resUrl) {
        this.resUrl = resUrl == null ? null : resUrl.trim();
    }

    /**
     * 级别
     * @return level 级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 级别
     * @param level 级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 权限状态（可以回收权限）
     * @return status 权限状态（可以回收权限）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 权限状态（可以回收权限）
     * @param status 权限状态（可以回收权限）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}