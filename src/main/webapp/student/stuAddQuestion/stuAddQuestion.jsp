<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生提问</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content_wrap">
		<div class="wrap">
			<div class="panel panel-primary">
				<div class="panel-heading" id="recentQuestion">
					<h3 class="panel-title">最近同学提问</h3>
				</div>
				<div class="panel-body">
					<div class="question_list">
						<div class="panel-group" id="accordion"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="wrap" id="tooltip">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">我也要提问</h3>
				</div>
				<div class="panel-body">
					<div class="add_q">
						<form method="post" class="form-horizontal" role="form"
							id="addQuestionForm" action="/qaplus/stu/add_q.htm">
							<input type="hidden" value="${CURRENT_OPERATOR.id }"
								name="questionPerson"> <input type="hidden"
								name="questionAttachmentId" id="questionAttachmentId" />
							<div class="form-group">
								<label for="firstname" class="col-sm-2 control-label">标题：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="firstname"
										name="title" placeholder="请输入问题标题" title="问题标题只能是30个字">
								</div>
							</div>
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">描述：</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="3" title="填写详细便于老师理解"
										name="questionContent"></textarea>
								</div>
							</div>

							<div class="form-group">
								<label for="firstname" class="col-sm-2 control-label">附件：</label>
								<div class="col-sm-10 fileUploadTip">
									<input id="file-3" type="file" multiple=true>
								</div>
							</div>

							<div class="form-group">
								<label for="firstname" 
									class="col-sm-2 control-label">分类：</label>
								<div class="col-sm-10">
									<select class="form-control" id="category" 
										name="category"></select>
								</div>
							</div>

							<div class="form-group">
								<label for="firstname" class="col-sm-2 control-label">沟通:</label>
								<div class="col-sm-10">
									<div id="radioset">
										<ul>
											<li><input type="radio" id="radio1" name="needFaceComm"
												value="Y" /><label for="radio1">需要和老师当面沟通</label></li>
											<li><input type="radio" id="radio2" name="needFaceComm"
												checked="checked" value="N" /><label for="radio2">不需要当面沟通</label></li>
										</ul>
									</div>
								</div>
							</div>

							<div class="form-group" id="buttonFromGroup">
								<div class="col-sm-12">
									<button type="button" class="btn btn-primary"
										id="addQuestionContinue">继续提问</button>
									<button type="button" class="btn btn-primary" id="addQuestion">确认提问</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>