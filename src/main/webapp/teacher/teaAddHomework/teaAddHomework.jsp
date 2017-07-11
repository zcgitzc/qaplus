<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>布置家庭作业</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content_wrap">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">布置家庭作业：</h3>
			</div>
			<div class="panel-body">

				<div id="formDiv">
					<form class="form-horizontal" role="form" id="homeworkForm">
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">作业标题：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="作业标题：J2SE第一次作业">
							</div>
						</div>

						<div class="form-group">
							<label for="commit_date" class="col-sm-2 control-label">提交时间：</label>
							<div class="col-sm-10">
								<input type="text" readonly class="submit_time form-control"
									name="commitDate"> <span class="add-on"><i
									class="icon-th"></i></span>
							</div>
						</div>
					</form>
				</div>
				<div style="width: 100%; height: 500px;">
					<div style="width: 55%; float: left;">
						<div id="homeworkQuestionsDiv"></div>
						<div style="text-align: center;" class="list-group-item">
							<button type="button" class="btn btn-default"
								id="addHomeworkContinueBtn">继续布置</button>
							<button type="button" class="btn btn-primary" id="addHomeworkBtn">确认布置</button>
						</div>
					</div>
					<div
						style="width: 10%; float: left; text-align: center; height: 100%;">
						<span class="glyphicon glyphicon-arrow-right"
							style="font-size: 60px; color: #0088CC; line-height: 200px"></span>
					</div>

					<div style="width: 35%; float: left;">
						<ul class="list-group">
							<li class="list-group-item active">选择需要完成作业的学生：</li>
							<li class="list-group-item"><ul id="stuTree" class="ztree"
									style="width: 560px; overflow: auto;"></ul></li>
						</ul>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>