define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	var Handlebars = require("handlebars");
	var helpers = require("../../common/helpers");
	Handlebars.registerHelper(helpers);
	require("./teaRemarkPaper.css");
	require("../../common/common.css");
	var moment = require("moment");
	var tpl = require("./teaRemarkPaper.tpl");
	var template = Handlebars.compile(tpl);
	var Util = require("../../common/util/util");
	require("../../common/ellipsis/ellipsis");
	require("../../common/common_require");


	var teaRemarkPaper = {
		initPage : function() {
			ajax({
				url:"/qaplus/paper/teaRemarkPaper.json",
				data:"paperId="+Util.getUrlParam("paperId")+"&stuId="+Util.getUrlParam("stuId"),
				success:function(result){
					$("#paperName").html(result.data[0].paperName);
					$("#stuName").html(result.data[0].stuName);
					$("#score").html("分数："+result.data[0].totalScore+"（试卷总分："+result.data[0].paperTotalScore+"）");
					//判断题目有没有做对
					for (var i = 0; i < result.data[0].questions.length; i++) {
						var rightItem="";
						var userChoiceItem="";
						for (var j = 0; j < result.data[0].questions[i].items.length; j++) {
							if(result.data[0].questions[i].items[j].isRightItem=="Y"){
								rightItem+=result.data[0].questions[i].items[j].id;
							}
							if(result.data[0].questions[i].items[j].isUserChoice=="Y"){
								userChoiceItem+=result.data[0].questions[i].items[j].id;
							}
						}
						if(rightItem!=userChoiceItem){
							result.data[0].questions[i].right="N";
						}else{
							result.data[0].questions[i].right="Y";
						}
					}
					var html=template(result.data[0]);
					$("#stuQuestions").html(html);
				},
			});
		},
	};

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			teaRemarkPaper.initPage();
		}
	};
});
