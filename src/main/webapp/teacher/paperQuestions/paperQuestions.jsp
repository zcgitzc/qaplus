<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷试题</title>
</head>
<body>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content_wrap">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">[<span id="paperName"></span>]试卷试题信息如下：  <span id="score" class="pull-right"></span></h3>
			</div>
			<div class="panel-body">
				<div id="stuQuestions"></div>
			</div>
		</div>
	</div>
</body>
</html>