<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看学生家庭作业</title>
</head>
<body>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content_wrap">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><span id="homeworkTitle"></span>[<span id="commitUserName"></span>]做题情况</h3>
			</div>
			<div class="panel-body">
				<div id="form"></div>
			</div>
		</div>
	</div>
</body>
</html>