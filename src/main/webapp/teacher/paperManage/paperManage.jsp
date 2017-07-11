<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷管理</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content_wrap">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">试卷列表：</h3>
			</div>
			<div class="panel-body">
				<div id="categray">
					<form action="/qaplus/stu/query_s_question.htm" method="post"
						id="searchForm">
						<div class="question_search">
							<ul>
								<li><input type="checkbox" id="check1" name="my"
									checked="checked" value="${CURRENT_OPERATOR.id }" /> <label
									for="check1">我的试卷</label></li>

								<li><input type="checkbox" id="check22" name="status"
									value="UN_START" /> <label for="check22">未开始</label></li>
								<li><input type="checkbox" id="check33" name="status"
									value="STARTING" checked="checked" /> <label for="check33">考试中</label></li>
								<li><input type="checkbox" id="check44" name="status"
									value="STARTED" /> <label for="check44">已结束</label></li>

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
									value="OTHER" /> <label for="check8">综合</label></li>
							</ul>
						</div>
					</form>
				</div>
				<table id="paperList">
				</table>
			</div>
		</div>



		<div id="publishPaper" style="display: none;">
			<form action="" id="publishPaperForm" class="form-horizontal"
				role="form" style="padding: 15px;">
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">考试时长：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')"
							name="examLong" placeholder="考试时长（分钟）" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">考试时间：</label>
					<div class="col-sm-10">
						<input type="text" readonly class="exam_date form-control"
							name="examTime"> <span class="add-on"><i
							class="icon-th"></i></span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">考试学生：</label>
					<div class="col-sm-10">
						<div class="input-group">
							<div class="input-group-btn">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown">
									选择方式 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="javascript:void(0);" id="choiceClass">指定班级</a></li>
									<li><a href="javascript:void(0);" id="choiceStu">指定学生</a></li>
								</ul>
							</div>
							<div id="classIdDiv" style="display: none">
								<select class="form-control" id="classId" name="classId"></select>
							</div>
							<div id="stuIdsDiv" style="display: none">
								<select class="form-control" id="stuIds" name="stuIds"></select>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group" style="width: 90%;text-align: center;margin: 10 auto;">
					<button type="button" class="btn btn-primary btn-lg btn-block"
						id="submit">已确认试卷所有信息，生成试卷</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>