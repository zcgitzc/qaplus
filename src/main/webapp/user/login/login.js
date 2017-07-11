define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	require('../../common/common.css');
	var Handlebars = require("handlebars");
	var helpers = require("../../common/helpers");
	Handlebars.registerHelper(helpers);
	require("./login.css");
	var tpl = require("./login.tpl");
	var template = Handlebars.compile(tpl);
	require("../../common/common_require");
	
	$("#userLogin").click(function() {
		login.userLogin();
	});
	$("#register").click(function(){
		login.register();
	});
	$("#username").blur(function(){
		login.checkUsername();
	});
	$("#phone").blur(function(){
		login.getPhoneAddress();
	});
	$("#registerBtn").click(function(){
		login.doRegister();
	});


	var login = {
		initPage : function() {
			
			document.onkeydown = function(event) {
				var e = event || window.event || arguments.callee.caller.arguments[0];
				if (e && e.keyCode == 27) { // 按 Esc
				}
				if (e && e.keyCode == 113) { // 按 F2
				}
				if (e && e.keyCode == 13) { // enter 键
					login.userLogin();
				}
			};
		},
		userLogin : function() {
			ajax({
				url : "/qaplus/user/user_login.json",
				data : $("#loginForm").serialize(),
				success : function(result) {
					if(result.data[0]){
						window.location.href=result.data[0];
					}else{
						window.location.href = "/qaplus/user/home/home.jsp";
					}
				},
			});
		},
		register : function() {
			ajax({
				url : "/qaplus/class/select_all_class.json",
				success : function(result) {
					var optionHtml = "";
					for (var i = 0; i < result.data.length; i++) {
						optionHtml += "<option value=" + result.data[i].id
								+ ">" + result.data[i].name + "</option>"
					}
					$("#sel_productTag").html(optionHtml);
					
					$('#sel_productTag').select2({
						placeholder : "请至少选择一个班级",
						tags : true,
						createTag : function(decorated, params) {
							return null;
						},
						width : '445px'
					});
					
					$('#radioset input').each(function() {
						var self = $(this);
						var label = self.next();
						var label_text = label.text();
						label.remove();
						self.iCheck({
							checkboxClass : 'icheckbox_sm-blue',
							radioClass : 'radio_sm-blue',
							insert : label_text
						});
					});

					layer.open({
						type : 1,//0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
						area : [ '600px', '530px' ], 
						shade : [0.8, '#d6d6d6'],
						scrollbar: false,
						title : "用户注册(注意：学生注册需要对应班级老师同意，老师注册需要任意一个老师同意)", 
						content : $('#registerContainer')
					});
				}
			});

		},
		doRegister : function() {
			ajax({
				url : "/qaplus/user/user_reg.json",
				data : $("#registerForm").serialize(),
				success : function(result) {
					window.location.reload(true);
				},
			});
		},
		getPhoneAddress : function() {
			ajax({
				url : "/qaplus/common/get_phone_supplier.json",
				data : "phone=" + $("#phone").val(),
				success : function(result) {
					if (result.data[0].catName && result.data[0].province
							&& result.data[0].carrier) {
						$("#phone_tip").html(
								result.data[0].catName + "&nbsp;"
										+ result.data[0].province + "&nbsp;"
										+ result.data[0].carrier);
					}
				},
			});
		},
		checkUsername : function() {
			ajax({
				url : "/qaplus/user/check_username.json",
				data : "username=" + $("#username").val(),
				success : function(result) {
					if (result.msg) {
						$("#username_tip").html(result.msg);
					}
				},
			});
		}
	}

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			login.initPage();
		}
	};
});