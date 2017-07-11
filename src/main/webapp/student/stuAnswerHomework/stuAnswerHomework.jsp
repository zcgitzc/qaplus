<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回答家庭作业</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div id="content">
		<div id="form">
			<form class="form-horizontal" role="form" id="answerForm">
				<input type="hidden" id="attachmentId" name="attachmentId">
				<input type="hidden" id="homeworkId" name="homeworkId"> <input
					type="hidden" id="questionId" name="questionId">
				<div class="form-group">
					<div class="col-sm-12">
						<textarea id="questionContent" class="form-control" rows="3"
							style="width: 100%; margin-top: 20px;" name="questionContent"
							disabled="disabled"></textarea>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-12">
						<textarea rows="13" cols="131" class="form-control" id="commitContent" name="commitContent">请认真做家庭作业</textarea>
					</div>
				</div>


				<div class="form-group"
					style="padding-bottom: 10px; margin-top: 10px;">
					<div class="col-sm-12">
						<ul class="pager">
							<li class="previous disabled" id="prev"><a href="#">&larr;上一题</a></li>
							<li><span class="btn btn-primary attach"
								style="background-color: #2e6da4;"> 查看问题附件</span></li>
							<li><span style="display: none;background-color: #2e6da4;" id="submitHomework"
								class="btn btn-primary">提交作业</span></li>
							<li class="next" id="next"><a href="#">下一题 &rarr;</a></li>
						</ul>
					</div>
				</div>

				<input id="file-3" type="file" multiple=true />
			</form>

			<div id="questionCountProcess">
				<div class="progress progress-striped">
					<div class="progress-bar" role="progressbar" aria-valuenow="0"
						aria-valuemin="0" aria-valuemax="0" style="width: 0%;">
						<span></span>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>