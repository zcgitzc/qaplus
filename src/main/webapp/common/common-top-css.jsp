<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	request.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link type="text/css" href="${basePath }static/bootstrap/bootstrap.css" rel="stylesheet" />
<link type="text/css" href="${basePath }static/bootstrap/bootstrap-table.css" rel="stylesheet" />
<link type="text/css" href="${basePath }static/bootstrap/bootstrap-editable.css" rel="stylesheet" />
<link type="text/css" href="${basePath }static/ztree/metro.css" rel="stylesheet" />
<link type="text/css" href="${basePath }static/select2/select2.min.css" rel="stylesheet" />
<link type="text/css" href="${basePath }static/fileinput/fileinput.min.css" rel="stylesheet" />
<link type="text/css" href="${basePath }static/layer/skin/layer.css" rel="stylesheet" />
<link type="text/css" href="${basePath }static/Jcrop/jquery.Jcrop.css" rel="stylesheet" />
<link type="text/css" href="${basePath }static/icheck/icheck.css" rel="stylesheet" />

<link type="text/css" href="${basePath }static/css/common.css" rel="stylesheet" />
<link type="text/css" href="${basePath }static/css/top.css" rel="stylesheet" />
<link rel="shortcut icon" type="image/x-icon" href="${basePath }static/img/favicon.jpg">


