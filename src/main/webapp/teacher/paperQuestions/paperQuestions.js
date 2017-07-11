define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	var Handlebars = require("handlebars");
	var helpers = require("../../common/helpers");
	Handlebars.registerHelper(helpers);
	require("./paperQuestions.css");
	require("../../common/common.css");
	var moment = require("moment");
	var tpl = require("./paperQuestions.tpl");
	var template = Handlebars.compile(tpl);
	var Util = require("../../common/util/util");
	require("../../common/ellipsis/ellipsis");
	require("../../common/common_require");


	var paperQuestions = {
		initPage : function() {
			ajax({
				url:"/qaplus/paper/paperQuestions.json",
				data:"paperId="+Util.getUrlParam("paperId"),
				success:function(result){
					$("#paperName").html(result.data[0].paperName);
					$("#stuName").html(result.data[0].stuName);
					$("#score").html("试卷总分："+result.data[0].paperTotalScore+"");
					var html=template(result.data[0]);
					$("#stuQuestions").html(html);
				},
			});
		},
	};

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			paperQuestions.initPage();
		}
	};
});
