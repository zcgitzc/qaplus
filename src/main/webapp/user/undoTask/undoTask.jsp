<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>待办事项</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content_wrap">
		<div class="panel panel-primary">
			<div class="panel-heading">
				待办任务：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>请认真处理下面的任务，以避免不必要的麻烦</b>
			</div>
			<div class="panel-body">
				<ul class="list-group" id="undoTask">
				</ul>
			</div>
		</div>
	</div>
</body>
</html>