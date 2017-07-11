<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制作试卷</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div id="container">
		<div id="rootwizard">
			<ul>
				<li><a href="#tab1" data-toggle="tab"><span class="label">1</span>
						填写试卷基本信息</a></li>
				<li><a href="#tab2" data-toggle="tab"><span class="label">2</span>
						选择生成试题方式</a></li>
				<li><a href="#tab3" data-toggle="tab"><span class="label">3</span>
						试卷预览 </a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane" id="tab1">
					<form class="form-horizontal" role="form" id="paperBasicForm">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">试卷名称：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="paperTitle"
									name="paperTitle" placeholder="请输入试卷名称">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">监考人：</label>
							<div class="col-sm-10">
								<select class="form-control" id="invigilatePerson"
									name="invigilatePerson">
								</select>
							</div>
						</div>
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
							<label for="lastname" class="col-sm-2 control-label">题目数量：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									onkeyup="this.value=this.value.replace(/\D/g,'')"
									onafterpaste="this.value=this.value.replace(/\D/g,'')"
									name="questionAmount" placeholder="题目数量" />
							</div>
						</div>
						<!-- 暂时后台计算 -->
						<!-- <div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">试卷总分：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									onkeyup="this.value=this.value.replace(/\D/g,'')"
									onafterpaste="this.value=this.value.replace(/\D/g,'')"
									name="totalScore" placeholder="试卷总分" />
							</div>
						</div> -->
						<div class="form-group">
							<label class="col-sm-2 control-label">考试时间：</label>
							<div class="col-sm-10">
								<input type="text" readonly class="exam_date form-control"
									name="examTime"> <span class="add-on"><i
									class="icon-th"></i></span>
							</div>
						</div>
						<div class="form-group">
							<label for="commit_date" class="col-sm-2 control-label">试卷分类：</label>
							<div class="col-sm-10">
								<select class="form-control" id="categray" name="paperCategory">
									<option value="J2SE">J2SE</option>
									<option value="J2EE">J2EE</option>
									<option value="JAVASCRIPT">JAVASCRIPT</option>
									<option value="JQUERY">JQUERY</option>
									<option value="FRONT">前端</option>
									<option value="DEV_TOOL">开发工具</option>
									<option value="MIX">其他</option>
								</select>
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
										<select class="form-control" id="classId" name="classId" ></select>
									</div>
									<div id="stuIdsDiv" style="display: none">
										<select class="form-control" id="stuIds" name="stuIds"></select>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="tab-pane" id="tab2">
					<form class="form-horizontal" role="form"
						id="generateQuestionMethod">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">难易程度：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									onkeyup="this.value=this.value.replace(/\D/g,'')"
									onafterpaste="this.value=this.value.replace(/\D/g,'')"
									name="easy" placeholder="简单题目多少个" /><input type="text"
									class="form-control"
									onkeyup="this.value=this.value.replace(/\D/g,'')"
									onafterpaste="this.value=this.value.replace(/\D/g,'')"
									name="middle" placeholder="中等题目多少个" /><input type="text"
									class="form-control"
									onkeyup="this.value=this.value.replace(/\D/g,'')"
									onafterpaste="this.value=this.value.replace(/\D/g,'')"
									name="difficult" placeholder="复杂题目多少个" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">是否打乱试题顺序：</label>
							<div class="col-sm-10">
								<div id="radioset1">
									<ul>
										<li><input type="radio" id="upsetQuestion1"
											name="upsetQuestion" value="Y" /><label for="upsetQuestion1">打乱</label></li>
										<li><input type="radio" id="upsetQuestion2"
											name="upsetQuestion" checked="checked" value="N" /><label
											for="upsetQuestion2">不打乱</label></li>
									</ul>
								</div>
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-2 control-label">是否打乱选项顺序：</label>
							<div class="col-sm-10">
								<div id="radioset2">
									<ul>
										<li><input type="radio" id="upsetItem1" name="upsetItem"
											value="Y" /><label for="upsetItem1">打乱</label></li>
										<li><input type="radio" id="upsetItem2" name="upsetItem"
											checked="checked" value="N" /><label for="upsetItem2">不打乱</label></li>
									</ul>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="tab-pane" id="tab3">
					<div style="float: right; width:100%;">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">试卷预览</h3>
							</div>
							<div class="panel-body">
								<div id="preview"></div>
								<div id="pagination">
									<ul class="pager">
										<li class="previous" id="prevQuestion"><a href="#">&larr;
												上一题</a></li>
										<li class="next" id="nextQuestion"><a href="#">下一题
												&rarr;</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div style="clear: both;">
						<button type="button" class="btn btn-primary btn-lg btn-block"
							id="submit">已确认试卷所有信息，生成试卷</button>
					</div>
				</div>
				<div style="clear: both;">
					<ul class="pager wizard">
						<li class="previous"><a href="#">上一步</a></li>
						<li class="next"><a href="#">下一步</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>