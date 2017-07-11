<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>扩充考试试题库</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div id="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">扩充考试试题库：</h3>
			</div>
			<div class="panel-body">
				<div id="addExamQuestion">
					<form class="form-horizontal" role="form" id="addExamQuestionForm">
						<div class="form-group">
							<input type="text" class="form-control"
								onkeyup="this.value=this.value.replace(/\D/g,'')"
								onafterpaste="this.value=this.value.replace(/\D/g,'')"
								name="score" placeholder="请输入题目分值" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="note" placeholder="正确答案解释  NOTE:" />
						</div>
						<div class="form-group">
							<select class="form-control" id="category" name="category">
							</select>
						</div>

						<div class="form-group">
							<div class="addExamQuestionContent"></div>
							<input type="hidden" name="content" id="content">
						</div>
						<div id="radioset">
							<ul>
								<li><input type="radio" id="radio1" name="type"
									value="RADIO" /> <label for="radio1">单选</label></li>
								<li><input type="radio" id="radio2" name="type"
									value="CHECKBOX" /> <label for="radio2">多选</label></li>
							</ul>
						</div>


						<div>
							<ul class="list-group" id="itemList">
								<li class="list-group-item questionItem active">添加选项信息： <span
									class="glyphicon glyphicon-plus pull-right" id="addItemHtml"
									style="cursor: pointer;"></span>
								</li>
							</ul>
						</div>

						<div class="form-group" style="text-align: center;">
							<button type="button" class="btn btn-default"
								onclick="window.location.href='/qaplus/teacher/examQuestion/examQuestion.jsp'">查看题库</button>
							<button type="button" class="btn btn-primary"
								id="addExamQuestionBtn">确认添加</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>