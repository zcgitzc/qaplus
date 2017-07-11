<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<div id="pageContainer">
		<!-- 登陆 -->
		<section id="tabs" style="float: right;
    margin-top: 20%;
    margin-right: 10%;">
			<ul id="myTab" class="nav nav-tabs">
				<li class="active"><a href="#usernameLogin" data-toggle="tab">
						账号登录 </a></li>
				<li><a href="#phoneLogin" data-toggle="tab">手机登录</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="usernameLogin">
					<form id="loginForm" class="form-horizontal" role="form">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">用户名：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="firstname"
									name="username" placeholder="支持手机号、邮箱、用户名">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">密码：</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="lastname"
									name="password" placeholder="请输入密码6~14">
							</div>
						</div>
						<div class="form-group" id="buttonFromGroup">
							<div class="col-sm-12">
								<button type="button" class="btn btn-primary" id="register">注册</button>
								<button type="button" class="btn btn-primary" id="userLogin">登录</button>
							</div>
						</div>
					</form>
				</div>
				<div class="tab-pane fade" id="phoneLogin">暂未开发</div>
			</div>
		</section>

		<!-- 注册 -->
		<section id="registerContainer" style="display: none">
			<form id="registerForm" class="form-horizontal" role="form">
				<div class="form-group">
					<label for="username" class="col-sm-2 control-label">用户名：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username"
							name="username" placeholder="请输入用户名"> <span
							style="color: green" id="username_tip"></span>
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">密码：</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="请输入密码6~14">
					</div>
				</div>

				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">姓名：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="请输入真实姓名">
					</div>
				</div>

				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">Email:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="email" name="email"
							placeholder="请输入Email">
					</div>
				</div>

				<div class="form-group">
					<label for="phone" class="col-sm-2 control-label">手机号：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="phone" name="phone"
							placeholder="请输入手机号"> <span style="color: green"
							id="phone_tip"></span>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">所在班级:</label>
					<div class="col-sm-10">
						<select class="combox" id="sel_productTag" name="classIds" multiple>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">用户类型:</label>
					<div class="col-sm-10" id="radioset">
						<ul>
							<li><input type="radio" id="radio1" name="job" value="1"
								checked="checked" /> <label for="radio1">我是学生</label></li>
							<li><input type="radio" id="radio2" name="job" value="3" />
								<label for="radio2">我是老师</label></li>
						</ul>
					</div>
				</div>

				<div class="form-group" id="regBtnFormGroup">
					<div class="col-sm-offset-1 col-sm-11">
						<button type="button" class="btn btn-primary btn-lg btn-block" id="registerBtn">注册</button>
					</div>
				</div>
			</form>
		</section>
	</div>


	<script type="text/javascript" src="../../common/seajs/sea.js"></script>
	<script type="text/javascript" src="../../common/seajs/seajs-text.js"></script>
	<script type="text/javascript" src="../../common/boot.js"></script>
</body>
</html>