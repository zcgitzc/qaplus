<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
</head>
<body>
	<jsp:include page="../top/top.jsp"></jsp:include>
	<div id="container">
		<section id="tabs">
			<ul id="myTab" class="nav nav-tabs">
				<li class="active"><a href="#usernameLogin" data-toggle="tab">个人信息
				</a></li>
				<li><a href="#phoneLogin" data-toggle="tab">修改信息</a></li>
			</ul>
		</section>

		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="usernameLogin">
				<div id="left">
					<form class="form-horizontal" role="form">
						<input type="hidden" name="id" value="${CURRENT_OPERATOR.id }" />
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名：</label>
							<div class="col-sm-10">
								<p class="form-control-static">${CURRENT_OPERATOR.username }</p>
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">姓名：</label>
							<div class="col-sm-10">
								<p class="form-control-static">${CURRENT_OPERATOR.name }</p>
							</div>
						</div>


						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Email：</label>
							<div class="col-sm-10">
								<p class="form-control-static">${CURRENT_OPERATOR.email }</p>
							</div>
						</div>


						<div class="form-group">
							<label for="phone" class="col-sm-2 control-label">手机号：</label>
							<div class="col-sm-10">
								<p class="form-control-static">${CURRENT_OPERATOR.phone }</p>
							</div>
						</div>

						<div class="form-group">
							<label for="sex" class="col-sm-2 control-label">性别：</label>
							<div class="col-sm-10">
								<c:if test="${CURRENT_OPERATOR.sex=='M' }">
									<p class="form-control-static">男</p>
								</c:if>

								<c:if test="${CURRENT_OPERATOR.sex=='F' }">
									<p class="form-control-static">女</p>
								</c:if>
								<c:if test="${empty CURRENT_OPERATOR.sex}">
									<p class="form-control-static">请补全</p>
								</c:if>
							</div>
						</div>

						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">年龄：</label>
							<div class="col-sm-10">
								<c:if test="${empty CURRENT_OPERATOR.age}">
									<p class="form-control-static">请补全</p>
								</c:if>
								<c:if test="${not empty CURRENT_OPERATOR.age}">
									<p class="form-control-static">${CURRENT_OPERATOR.age }</p>
								</c:if>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">职位：</label>
							<div class="col-sm-10">
								<c:if
									test="${CURRENT_OPERATOR.job==1}">
									<p class="form-control-static">学生</p>
								</c:if>
								<c:if
									test="${CURRENT_OPERATOR.job==2}">
									<p class="form-control-static">老师</p>
								</c:if>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">关联班级：</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="class">
									<c:forEach items="${CURRENT_OPERATOR.classNames }" var="className">
										${className }、
									</c:forEach>
								</p>
							</div>
						</div>
					</form>
				</div>



				<div id="myQrCodeSection">
					<div class="media">
						<c:if
							test="${CURRENT_OPERATOR.hasIcon==null || CURRENT_OPERATOR.hasIcon=='N' }">
							<a class="pull-left" href="#"><img data-toggle="popover"
								class="img-circle" alt="头像" width="50px" id="top_img"
								height="50px" src="../../static/img/icon_default.jpg"></a>
						</c:if>
						<c:if test="${CURRENT_OPERATOR.hasIcon=='Y' }">
							<a class="pull-left" href="#"><img data-toggle="popover"
								class="img-circle" alt="头像" width="50px" id="top_img"
								height="50px" src="/qaplus/user/preview_img.json"></a>
						</c:if>

						<div class="media-body">
							<h5 class="media-heading">
								<b>${CURRENT_OPERATOR.name }</b>
							</h5>
							手机：${CURRENT_OPERATOR.phone }
						</div>
					</div>
					<div id="qrCodeBg">
						<div style="padding-top: 12px;" id="qrcode"
							data-name="${CURRENT_OPERATOR.name }"
							data-phone="${CURRENT_OPERATOR.phone }"
							data-email="${CURRENT_OPERATOR.email }"></div>
					</div>
					<div style="text-align: center;">扫一扫快速添加我为联系人</div>
				</div>
			</div>

			<div class="tab-pane fade" id="phoneLogin">
				<div id="tab2-left">
					<form class="form-horizontal" role="form" id="updateMyInfoForm">
						<input type="hidden" name="id" value="${CURRENT_OPERATOR.id }" />
						<input type="hidden" name="attachmentId" id="attachmentId" />
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="username"
									value="${CURRENT_OPERATOR.username }" name="username"
									placeholder="请输入用户名">
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">姓名：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name"
									value="${CURRENT_OPERATOR.name }" name="name"
									placeholder="请输入姓名">
							</div>
						</div>


						<div class="form-group">
							<label for="password" class="col-sm-2 control-label">密码：</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="请输入密码">
							</div>
						</div>

						<div class="form-group">
							<label for="confirm_pwd" class="col-sm-2 control-label">确认密码：</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="confirm_pwd"
									placeholder="请再次输入密码">
							</div>
						</div>


						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Email：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="email"
									value="${CURRENT_OPERATOR.email }" name="email"
									placeholder="请输入Email">
							</div>
						</div>


						<div class="form-group">
							<label for="phone" class="col-sm-2 control-label">手机号：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="phone"
									value="${CURRENT_OPERATOR.phone }" name="phone"
									placeholder="请输入手机号">
							</div>
						</div>

						<div class="form-group">
							<label for="sex" class="col-sm-2 control-label">性别：</label>
							<div class="col-sm-10">
								<div id="radioset">
									<ul>
										<c:if test="${CURRENT_OPERATOR.sex=='M' }">
											<li><input type="radio" id="radio1" name="sex" value="M" checked="checked" /><label
												for="radio1" >男</label></li>
											<li><input type="radio" id="radio2" name="sex" value="F"
												/><label for="radio2">女</label></li>
										</c:if>
										<c:if test="${CURRENT_OPERATOR.sex=='F' }">
											<li><input type="radio" id="radio1" name="sex" value="M"
												 /><label for="radio1">男</label></li>
											<li><input type="radio" id="radio2" name="sex" value="F" checked="checked"/><label
												for="radio2">女</label></li>
										</c:if>
										<c:if test="${empty CURRENT_OPERATOR.sex}">
											<li><input type="radio" id="radio1" name="sex" value="M" /><label
												for="radio1">男</label></li>
											<li><input type="radio" id="radio2" name="sex" value="F"/><label for="radio2">女</label></li>
										</c:if>
									</ul>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">年龄：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="amount"
									onkeyup="this.value=this.value.replace(/\D/g,'')"
									onafterpaste="this.value=this.value.replace(/\D/g,'')"
									name="age" value="${CURRENT_OPERATOR.age }">
							</div>
						</div>

						<div class="form-group">
							<div style="width: 100px; margin: 0px auto;">
								<button type="button" class="btn btn-primary"
									id="doUpdateUserInfo">确认修改</button>
							</div>
						</div>
					</form>
				</div>




				<div id="tab2-right">
					<div id="updateIcon">
						<c:if
							test="${CURRENT_OPERATOR.hasIcon==null || CURRENT_OPERATOR.hasIcon=='N' }">
							<img data-toggle="popover" class="img-circle" alt="头像"
								width="140px" height="140px"
								src="../../static/img/icon_default.jpg" id="page_img">
						</c:if>
						<c:if test="${CURRENT_OPERATOR.hasIcon=='Y' }">
							<img data-toggle="popover" class="img-circle" alt="头像"
								width="140px" id="top_img" height="140px"
								src="/qaplus/user/preview_img.json">
						</c:if>

						<div class="caption" style="text-align: center;">
							<p>支持 jpg \ png \ gif 格式，建议尺寸大于100＊100，文件小于10M</p>
							<p>
								<input id="file-3" type="file" multiple=false>
							</p>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>