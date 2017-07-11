define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var helpers = require("../../common/helpers");
	var Handlebars = require("handlebars");
	Handlebars.registerHelper(helpers);
	require("./addRecommend.css");
	require("../../common/common.css");
	var Util=require("../../common/util/util")
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	require("../../common/common_require");
	 var commonLogicUtil = require('../../common/util/commonLogicUtil');
	$("#addRecommendBtnContinue").click(function() {
		addRecommend.add(true);
	});

	$("#addRecommendBtn").click(function() {
		addRecommend.add(false);
	});

	var addRecommend = {
		initPage : function() {
			commonLogicUtil.questionCategory($("#category"));
			Util.uploadAttach($("#file-3"),$("#attachmentId"),{browseLabel:"上传附件&hellip;"});
			$('#summernote').summernote({
				height : 270,
				minHeight : null,
				placeholder : "编写资料",
				dialogsFade : true,// Add fade effect on dialogs
				dialogsInBody : true,// Dialogs can be placed in body, not in
				disableDragAndDrop : false,// default false You can disable
				maxHeight : null
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
		},
		add : function(isContinue) {
			$("#recommendFileContent").val($('#summernote').summernote('code'));
			ajax({
				url : '/qaplus/recommend/add_recommend.json',
				data : $("#addRecommendForm").serialize(),// 附加参数，json格式
				success : function(result) {
					if (isContinue) {
						window.location.reload(true);
					} else {
						window.location.href = "/qaplus/user/recommendFile/recommendFile.jsp";
					}
				}
			});
		},
	}

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			addRecommend.initPage();
		}
	};
});
