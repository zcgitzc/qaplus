<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试题库</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div id="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">试卷试题列表：</h3>
				<div id="operateBtn" class="pull-right" style="margin-top: -26px;">
					<button type="button" class="btn btn-primary"
						onclick="window.open('/qaplus/teacher/addExamQuestion/addExamQuestion.jsp', '扩充考试试题库', null, null)">扩充题库</button>
					<div class="btn-group">
						<button type="button" class="btn btn-primary dropdown-toggle"
							data-toggle="dropdown">
							导入/导出 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu"
							style="min-width: 100px; text-align: center;">
							<li><a href="javascript:void(0);" id="import">[导入]</a></li>
							<li><a href="javascript:void(0);" id="export">[导出]</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel-body">
				<div id="searchFromDiv"
					style="margin-top: -17px; margin-left: -50px;">
					<form action="/qaplus/stu/query_s_question.htm" method="post"
						id="searchForm">
						<div class="question_search">
							<ul>
								<li><input type="checkbox" id="check2" name="categorys"
									value="J2SE" /> <label for="check2">J2SE</label></li>
								<li><input type="checkbox" id="check3" name="categorys"
									value="J2EE" /> <label for="check3">J2EE</label></li>
								<li><input type="checkbox" id="check4" name="categorys"
									value="JAVASCRIPT" /> <label for="check4">JAVASCRIPT</label></li>
								<li><input type="checkbox" id="check5" name="categorys"
									value="JQUERY" /> <label for="check5">JQUERY</label></li>
								<li><input type="checkbox" id="check6" name="categorys"
									value="FRONT" /> <label for="check6">前端</label></li>
								<li><input type="checkbox" id="check7" name="categorys"
									value="DEV_TOOL" /> <label for="check7">开发工具</label></li>
								<li><input type="checkbox" id="check8" name="categorys"
									value="OTHER" /> <label for="check8">其他</label></li>
							</ul>
						</div>
						<div class="pull-right" style="margin-left: 15px;">
							<button type="button" class="btn btn-primary" id="toggle">全部收起</button>
						</div>
						<div class="input-group pull-right">
							<input type="text" placeholder="输入标题模糊搜索" name="title" id="title"
								class="form-control" />
						</div>
					</form>
				</div>
				<div id="accordion" style="clear: both; padding-top: 10px;"></div>
				<div id="pageToolbar" class="pull-right">
					<ul class="pagination">
					</ul>
				</div>
			</div>
		</div>

		<div id="importTQuestionDiv" style="display: none;">
			<div style="margin: 10;">
				<a href="/qaplus/examQuestion/downloadExamQuestionTemplate.json">请先下载Excel模板文件便于填写</a><br>
				<br> <input id="file-3" type="file" multiple=false>
			</div>
		</div>
	</div>
</body>
</html>