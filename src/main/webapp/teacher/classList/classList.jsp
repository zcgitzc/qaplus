<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级维护</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="content_wrap">
		<div class="table_content">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">班级列表：</h3>
				</div>
				<div class="panel-body">
					<div id="toolbar">
						<button type="button" class="btn btn-primary"
							style="width: 90px; height: 35px" id="addClass">添加</button>
					</div>
					<table id="classList">
					</table>
				</div>
			</div>
		</div>


		<section>
			<div id="add_class"
				style="display: none; margin: 0 5px; width: 600px;">
				<div style="margin: 25px auto;">
					<form class="form-horizontal" role="form" id="addClassForm">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">班级名称：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="class_name"
									name="name" placeholder="请输入班级名称">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">班级人数：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="class_person"
									onkeyup="this.value=this.value.replace(/\D/g,'')"
									onafterpaste="this.value=this.value.replace(/\D/g,'')"
									name="person" placeholder="请输入班级人数">
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-2 control-label">归属老师:</label>
							<div class="col-sm-10">
								<select class="combox" id="sel_class" name="teacherId" multiple>
								</select>
							</div>
						</div>

						<div class="form-group" id="btnFormGroup">
							<div class="col-sm-12">
								<button type="button" class="btn btn-primary"
									id="addClassBtnContinue" style="margin-right: 85px;">继续添加</button>
								<button type="button" class="btn btn-primary" id="addClassBtn">确认添加</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</section>
	</div>
</body>
</html>