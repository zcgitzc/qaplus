<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家庭作业维护</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div id="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">作业列表：</h3>
			</div>
			<div class="panel-body">
				<div id="toolbar">
					<button type="button" class="btn btn-primary" onclick="window.location.href='/qaplus/teacher/teaQuestionBank/teaQuestionBank.jsp'">制作新作业</button>
				</div>
				<table id="homework_list"></table>
			</div>
		</div>
	</div>
</body>
</html>