define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	var Handlebars = require("handlebars");
	var helpers = require("../../common/helpers");
	Handlebars.registerHelper(helpers);
	var tpl = require("./teaRemarkHomework.tpl");
	var template = Handlebars.compile(tpl);
	require("./teaRemarkHomework.css");
	require("../../common/common.css");
	var Util = require("../../common/util/util");
	require("../../common/common_require");

	var teaRemarkHomework = {
		initPage : function() {
			var stuId=Util.getUrlParam("stuId");
			var homeworkId=Util.getUrlParam("homeworkId");
			ajax({
				url : "/qaplus/homework/teacherRemarkHomework.json",
				data : "homeworkId=" + homeworkId+"&stuId="+stuId,
				success : function(result) {
					$("#homeworkTitle").html(result.data[0].homeworkName);
					$("#commitUserName").html(result.data[0].name);
					
					result.data[0].isStudent=Util.getUrlParam("isStudent");
					$("#form").html(template(result.data[0]));
					
					$(".remarkBtn").click(function(){
						if($(this).hasClass("disabled")){
							return ;
						}
						var id=$(this).data("id");
						var remarkContent=$(this).parent().prev().val();
						teaRemarkHomework.remarkStuHomework($(this),id,remarkContent);
					});
					
					$(".questionAttach").click(function(){
						Util.downloadAttach($(this).data("id"));
					});
					
					$(".answerAttach").click(function(){
						Util.downloadAttach($(this).data("id"));
					});
					
					$(".stuAnswerAttach").click(function(){
						Util.downloadAttach($(this).data("id"));
					});
					
				}
			});
		},
		remarkStuHomework:function(_this,id,remarkContent){
			ajax({
				url:"/qaplus/homework/teacherUpdateRemark.json",
				data:"id="+id+"&remarkContent="+remarkContent,
				success:function(){
					_this.addClass("disabled");
				}
			});
		}
	};

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			teaRemarkHomework.initPage();
		}
	};
});
