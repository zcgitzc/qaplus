<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="shortcut icon" type="image/x-icon" href="../../static/img/favicon.jpg">
 --><link rel="shortcut icon" href="https://www.baidu.com/favicon.ico" type="image/x-icon">
</head>
<body>
	<input id="currId" value="${CURRENT_OPERATOR.id }" type="hidden">
	<nav class="navbar navbar-primary" role="navigation"
		style="background-color: #08c;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/qaplus/user/home/home.jsp">EXAM</a>
			</div>
			<div class="navbar-body" id="menuBar"></div>

			<div class="navbar-right">
				<ul class="nav navbar-nav">
					<li><a href="javascript:void(0);"> <span
							class="glyphicon glyphicon-log-out" id="logout"
							style="font-size: 23px; color: white; cursor: pointer;"></span>
					</a></li>
				</ul>
			</div>
			<div class="nav navbar-nav navbar-right"
				style="margin-top: 4px; cursor: pointer;">
				<c:if
					test="${CURRENT_OPERATOR.hasIcon==null || CURRENT_OPERATOR.hasIcon=='N' }">
					<img data-toggle="popover" class="img-circle" alt="头像" width="40px"
						id="top_img"
						onclick="window.open('/qaplus/user/updateMyInfo/updateMyInfo.jsp', '个人信息修改', null, null)"
						height="40px" src="../../static/img/icon_default.jpg">
				</c:if>
				<c:if test="${CURRENT_OPERATOR.hasIcon=='Y' }">
					<img data-toggle="popover" class="img-circle" alt="头像" width="40px"
						id="top_img"
						onclick="window.open('/qaplus/user/updateMyInfo/updateMyInfo.jsp', '个人信息修改', null, null)"
						height="40px" src="/qaplus/user/preview_img.json">
				</c:if>
			</div>

			<div class="navbar-right">
				<ul class="nav navbar-nav">
					<li><a href="javascript:void(0);" id="getFestival"> <span
							class="glyphicon glyphicon-calendar"
							style="font-size: 23px; color: white; cursor: pointer;"></span>
					</a></li>
					<li><a href="/qaplus/user/board/board.jsp" target="_blank"> <span
							class="glyphicon glyphicon-list-alt"
							style="font-size: 23px; color: white; cursor: pointer;"><i id="boardTip"></i></span>
					</a></li>

					<li><a href="javascript:void(0);" id="toAddBoard"> <span
							class="glyphicon glyphicon-plus"
							style="font-size: 23px; color: white; cursor: pointer;"></span>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="pull-right" style="color: white;">
			当前在线人：
			<c:forEach items="${applicationScope.allOnlineUser}" var="onlineUsers">
				<span class="badge pull-right" 
					style="background-color:red;margin-right: 5px;">${onlineUsers.name}</span>
			</c:forEach>
		</div>
		<div style="display: none" id="festival"></div>
	</nav>
	<div
		style="display: none; width: 95%; height: 100%; margin: 0 auto; text-align: center;"
		id="board">

		<div style="width: 55%; float: left;" id="homeworkDiv">
			<form role="form" id="addBoardForm">
				<div class="form-group" style="margin-top: 15px">
					<input type="text" class="form-control" id="startTime"
						name="startTime" readonly="readonly" placeholder="开始时间">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id="endTime" name="endTime"
						readonly="readonly" placeholder="结束时间">
				</div>
				<div class="form-group">
					<textarea class="form-control" rows="3" name="content"></textarea>
				</div>

				<div class="form-group">
					<div class="boardOption">
						<ul>
							<li><input type="checkbox" name="importantFlag" value="Y"
								id="importantFlag" /><label for="importantFlag">重要</label></li>
							<li><input type="checkbox" name="keepTopFlag" value="Y"
								id="keepTopFlag" /><label for="keepTopFlag">置顶</label></li>
						</ul>
					</div>
				</div>
			</form>
			<div id="btnGroup">
				<button type="button" class="btn btn-primary"
					onclick="window.open('/qaplus/user/board/board.jsp', '公告列表', null, null)">查看公告</button>
				<button type="button" class="btn btn-primary" id="addBoardBtn"
					style="margin-left: 45px;">发布公告</button>
			</div>
		</div>
		<div
			style="width: 10%; float: left; text-align: center; height: 100%;">
			<span class="glyphicon glyphicon-arrow-right"
				style="font-size: 60px; color: #0088CC; line-height: 200px"></span>
		</div>

		<div style="width: 35%; float: left;">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
	</div>
	<script type="text/javascript" src="../../common/seajs/sea.js"></script>
	<script type="text/javascript" src="../../common/seajs/seajs-text.js"></script>
	<script type="text/javascript" src="../../common/boot.js"></script>
</body>
</html>
