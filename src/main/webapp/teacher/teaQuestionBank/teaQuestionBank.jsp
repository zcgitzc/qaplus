<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师题库</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content_wrap">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">题库列表：</h3>
			</div>
			<div class="panel-body">
					<div  id="toolbar" class="pull-left">
					</div>

					<div id="operateBtn" class="pull-right">
						<button type="button" class="btn btn-primary" id="toAddQuestion">扩充题库</button>
						<button type="button" class="btn btn-primary" id="toAddHomework">布置作业</button>
						<div class="btn-group">
							<button type="button" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown">
								导入/导出 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu" style="min-width: 100px;text-align: center;">
								<li><a href="javascript:void(0);" id="importTQuestion">[导入]</a></li>
								<li><a href="javascript:void(0);" id="exportTQuestion">[导出]</a></li>
							</ul>
					</div>
				</div>
				<table id="tableContainer">
				</table>
			</div>
		</div>
	</div>


	<div id="addOrUpdateQuestionDiv"
		style="display: none; width: 95%; margin: 0 auto;">
		<form role="form" id="addOrUpdateTeacherQuestionForm">
			<input type="hidden" name="id" id="id"> <input type="hidden"
				name="questionAttachmentId" id="questionAttachmentId"> <input
				type="hidden" name="answerAttachmentId" id="answerAttachmentId">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="问题标题"
					name="title" id="titleUpdate">
			</div>
			<div class="form-group">
				<textarea class="form-control" rows="3" placeholder="问题内容"
					name="content" id="content"></textarea>
			</div>
			<div class="form-group">
				<textarea class="form-control" rows="3" placeholder="问题答案"
					name="answer" id="answer"></textarea>
			</div>

			<div class="form-group">
				<select class="form-control" id="categray" name="category">
								<option value="J2SE">J2SE</option>
								<option value="J2EE">J2EE</option>
								<option value="JAVASCRIPT">JAVASCRIPT</option>
								<option value="JQUERY">JQUERY</option>
								<option value="FRONT">前端</option>
								<option value="DEV_TOOL">开发工具</option>
								<option value="OTHER">其他</option>
							</select>
			</div>

			<div class="form-group">
				<input id="questionAttach" type="file" multiple=true> <input
					id="answerAttach" type="file" multiple=true> <span
					style="color: green" id="oldQuestionAttachment"></span> <span
					style="color: green" id="oldAnswerAttachment"></span>
			</div>

			<div id="btnFormGroup">
				<button type="button" class="btn btn-primary"
					onclick="questionList.closeWindow()">关闭窗口</button>
				<button type="button" class="btn btn-primary" data-oper="add"
					id="addOrUpdateButton">扩充题库</button>
			</div>
		</form>
	</div>
	
	
	<div id="importTQuestionDiv" style="display: none;">
		<div style="margin: 10;">
			<a href="/qaplus/q/download_t_question_template.json">请先下载Excel模板文件便于填写</a><br> <br>
			<input id="file-3" type="file" multiple=false>
		</div>
	</div>
</body>
</html>