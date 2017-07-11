define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	var Handlebars = require("handlebars");
	var helpers = require("../../common/helpers");
	Handlebars.registerHelper(helpers);
	var Util = require("../../common/util/util");
	require("./updateMyInfo.css");
	require("../../common/common_require");

	$("#doUpdateUserInfo").click(function(){
		updateMyInfo.doUpdateUserInfo();
	});
	
	var index;
	var updateMyInfo = {
		initPage : function() {
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
			
			updateMyInfo.generateQrCode();
			updateMyInfo.queryMyClass();
			Util.uploadAttach($("#file-3"),$("#attachmentId"),{browseLabel:"选择头像"});
		},
		generateQrCode:function(){
			var name = $("#qrcode").attr("data-name");
			var phone = $("#qrcode").attr("data-phone");
			var email = $("#qrcode").attr("data-email");

			var qrcodeContent = "BEGIN:VCARD\nFN:" + name + "\nTEL:" + phone
					+ "\nORG:暂无组织\nEMAIL:" + email + "\nEND:VCARD";
			qrcodeContent = Util.utf16to8(qrcodeContent);
			$('#qrcode').qrcode({
				width : 150,
				height : 150,
				text : qrcodeContent
			});
		},
		doUpdateUserInfo : function() {
			ajax({
				url : "/qaplus/user/update_my_info.json",
				data : $("#updateMyInfoForm").serialize(),
				success : function(result) {
					window.location.href = "/qaplus/user/home/home.jsp";
				}
			});
		},
		queryMyClass : function() {
			ajax({
				url : "/qaplus/class/query_my_class.json",
				success : function(result) {
					var temp = "";
					for (var i = 0; i < result.data.length; i++) {
						temp += result.data[i].name + "、";
					}
					$("#class").val(temp);
				},
			});
		}
	}

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			updateMyInfo.initPage();
		}
	};
});
