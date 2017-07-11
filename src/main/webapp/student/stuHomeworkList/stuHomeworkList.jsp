<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生家庭作业列表</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content">
		<div id="stuHomework" data-curr-user="${CURRENT_OPERATOR.id }"></div>
	</div>
</body>
</html>