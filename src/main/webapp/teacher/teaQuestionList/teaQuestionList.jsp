<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师问题列表</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content_wrap">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">问题列表：</h3>
			</div>
			<div class="panel-body">
				<div id="toolbar"></div>
				<table id="tableContainer"></table>
			</div>
		</div>
	</div>
</body>
</html>