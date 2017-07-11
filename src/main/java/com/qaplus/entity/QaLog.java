package com.qaplus.entity;

import java.util.Date;

public class QaLog {
    /**
     * 主键
     */
    private Long id;

    /**
     * 是否删除
     */
    private String isDeleted;

    /**
     * 记录创建时间
     */
    private Date recCreateDate;

    /**
     * 修改日期
     */
    private Date recUpdateDate;

    /**
     * 修改人
     */
    private String recUpdateUser;

    /**
     * 创建人
     */
    private String recCreateUser;

    /**
     * 执行的方法名
     */
    private String methodName;

    /**
     * 执行方法的参数
     */
    private String params;

    /**
     * 是否成功
     */
    private String isSuccess;

    /**
     * 用户IP
     */
    private String ip;

    /**
     * 方法描述信息
     */
    private String methodDesc;

    /**
     * 错误提示：“用户名不存在”
     */
    private String errorTip;

    /**
     * 记录exception详细信息
     */
    private String errorMsg;

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
     * 是否删除
     * @return is_deleted 是否删除
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除
     * @param isDeleted 是否删除
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
     * 修改日期
     * @return rec_update_date 修改日期
     */
    public Date getRecUpdateDate() {
        return recUpdateDate;
    }

    /**
     * 修改日期
     * @param recUpdateDate 修改日期
     */
    public void setRecUpdateDate(Date recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }

    /**
     * 修改人
     * @return rec_update_user 修改人
     */
    public String getRecUpdateUser() {
        return recUpdateUser;
    }

    /**
     * 修改人
     * @param recUpdateUser 修改人
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
     * 执行的方法名
     * @return method_name 执行的方法名
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 执行的方法名
     * @param methodName 执行的方法名
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * 执行方法的参数
     * @return params 执行方法的参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 执行方法的参数
     * @param params 执行方法的参数
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    /**
     * 是否成功
     * @return is_success 是否成功
     */
    public String getIsSuccess() {
        return isSuccess;
    }

    /**
     * 是否成功
     * @param isSuccess 是否成功
     */
    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess == null ? null : isSuccess.trim();
    }

    /**
     * 用户IP
     * @return ip 用户IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 用户IP
     * @param ip 用户IP
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 方法描述信息
     * @return method_desc 方法描述信息
     */
    public String getMethodDesc() {
        return methodDesc;
    }

    /**
     * 方法描述信息
     * @param methodDesc 方法描述信息
     */
    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc == null ? null : methodDesc.trim();
    }

    /**
     * 错误提示：“用户名不存在”
     * @return error_tip 错误提示：“用户名不存在”
     */
    public String getErrorTip() {
        return errorTip;
    }

    /**
     * 错误提示：“用户名不存在”
     * @param errorTip 错误提示：“用户名不存在”
     */
    public void setErrorTip(String errorTip) {
        this.errorTip = errorTip == null ? null : errorTip.trim();
    }

    /**
     * 记录exception详细信息
     * @return error_msg 记录exception详细信息
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 记录exception详细信息
     * @param errorMsg 记录exception详细信息
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }
}