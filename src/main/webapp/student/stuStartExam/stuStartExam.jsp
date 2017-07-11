<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生正式考试</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content_wrap">
		<div class="pull-right">
			<div id="showExamTime">
				<div id="countdown" title="考试时间剩余15min，系统会提醒"></div>
				<button type="button" class="btn btn-primary" style="width: 240px;"
					id="timeToogle" title="考试时间剩余15min，系统会提醒">隐藏时间</button>
			</div>
			<span class="label label-success" style="display: none;font-size: 20px;" id="scoreShow"></span>
		</div>
		<div id="question" style="width: 78%;"></div>
		<div id="pagination">
			<ul class="pager" style="text-align: right;">
				<li id="prev"><a href="#">上一题</a></li>
				<li id="next"><a href="#">下一题</a></li>
				<li id="submit"><a href="#">提交试卷</a></li>
			</ul>
		</div>
		<div class="progress">
			<div class="progress-bar" role="progressbar" aria-valuenow="60"
				aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
				<span></span>
			</div>
		</div>
		<div id="questionIndex"></div>
	</div>
</body>
</html>