<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生问题列表</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="table_content">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">学生问题列表：</h3>
			</div>
			<div class="panel-body">
				<div id="toolbar"></div>
				<div class="table_container">
					<table id="tableContainer"></table>
				</div>
			</div>
		</div>
	</div>
	<div class="answer">
		<div id="dialog_answer" title="教师答案："
			style="display: none; margin: 0 5px;">
			<div id="answerContent"></div>
		</div>
	</div>
</body>
</html>