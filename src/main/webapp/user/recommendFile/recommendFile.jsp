<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>资料列表</title>
</head>
<body data-spy="scroll" data-target="#myScrollspy">
	<jsp:include page="../top/top.jsp"></jsp:include>
	<div class="container" id="warp" data-curr="${CURRENT_OPERATOR.id}">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">资料列表：</h3>
			</div>
			<div class="panel-body">
				<div id="searchBar">
					<div id="toolbar">
						
					</div>
					<div class="input-group pull-right">
						<input type="text" placeholder="输入标题模糊搜索" name="title" id="title" class="form-control" />
					</div>
				</div>

				<div class="row" style="clear: both;">
					<div class="col-xs-3" id="myScrollspy">
						<ul class="nav nav-tabs nav-stacked" id="myNav">
						</ul>
					</div>
					<div class="col-xs-9" id="rightContent"></div>
				</div>
				<div id="pageToolbar" class="pull-right">
					<ul class="pagination">
					</ul>
				</div>
			</div>
		</div>
		<a class="to-top"> <span
			class="glyphicon glyphicon-circle-arrow-up"></span></a>
	</div>
	<div id="update_recommend" style="display: none;">
		<div id="content">
			<div id="form">
				<form class="form-horizontal" role="form" id="recommendUpdateForm">
					<input type="hidden" name="id" id="recommendId" /> <input
						type="hidden" name="attachmentId" id="attachmentId" />
					<div class="form-group">
						<div class="col-sm-12">
							<input id="recommendTitle" class="form-control" type="text"
								name="title" placeholder="请输入资料标题" autofocus="autofocus" />
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
					</div>
					<input id="file-3" type="file" multiple=true />
					<div class="form-group">
						<div class="col-sm-12">
							<span id="old_attach" class="pull-left" style="color: green"></span>
							<button type="button" class="btn btn-default pull-right"
								onclick="window.open('/qaplus/user/addRecommend/addRecommend.jsp', '添加资料', null, null)">跑去添加</button>
							<button type="button" class="btn btn-default pull-right"
								id="doUpdate">确认修改</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
