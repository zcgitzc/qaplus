<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加资料</title>
</head>
<body>
<body>
	<jsp:include page="../top/top.jsp"></jsp:include>
	<div id="wrap">
		<div id="content">
			<div id="form">
				<form class="form-horizontal" role="form" id="addRecommendForm">
					<input type="hidden" name="attachmentId" id="attachmentId" />
					<div class="form-group">
						<div class="col-sm-12">
							<input id="title" class="form-control" type="text" name="title"
								placeholder="请输入资料标题" autofocus="autofocus" />
						</div>
					</div>
					<div id="summernote"></div>
					<input type="hidden" id="recommendFileContent" name="content">

					<div class="form-group">
						<div class="col-sm-5">
							<div id="radioset">
								<ul>
									<li><input type="radio" id="radio1" name="allRead"
										value="Y" /><label for="radio1">公开</label></li>
									<li><input type="radio" id="radio2" name="allRead"
										checked="checked" value="N" /><label for="radio2">不公开</label></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-7">
							<select class="form-control" id="category" name="category">
							</select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<input id="file-3" type="file" multiple=true />
							<button type="button" class="btn btn-default pull-right"
								id="addRecommendBtnContinue">继续添加</button>
							<button type="button" class="btn btn-default pull-right"
								id="addRecommendBtn">确认添加</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>