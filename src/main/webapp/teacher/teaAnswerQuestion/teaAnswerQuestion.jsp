<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师回答</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content_wrap" style="background-color: #dde1e5;margin-top: -20px;">
		<div id="content">
			<div id="form">
				<form class="form-horizontal" role="form" id="answerForm">
					<input type="hidden" name="answerAttachmentId" id="attachmentId" />
					<input type="hidden" name="id" id="questionId" />
					<div class="form-group">
						<div class="col-sm-12">
							<textarea id="questionContent" class="form-control" rows="3"
								style="width: 100%; margin-top: 20px;" name="questionContent"
								disabled="disabled"></textarea>
						</div>
					</div>

					<div id="summernote"></div>
					<input type="hidden" name="answerContent" id="answerContent">

					<div class="form-group"
						style="padding-bottom: 10px; margin-top: 10px;">
						<div class="col-sm-12">
							<input id="file-3" type="file" multiple=true class="pull-right" />
							<button type="button" class="btn btn-default pull-right"
								id="continueAnswerBtn">继续回答</button>
							<button type="button" class="btn btn-default pull-right"
								id="answerBtn">确认回答</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>