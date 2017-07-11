define(function(require, exports, module) {
	var $ = require("jQuery");
	var Handlebars = require("handlebars");
// var underscore=require("../../common/underscore/underscore");
	// js没有作为模块输出，所以不能用别名
// require('../../common/datatables.fixedcolumns/datatables.fixedcolumns');
// require("../../common/ellipsis/ellipsis");
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	require("./home.css");
	var home_tpl = require("./home.tpl");
	var template = Handlebars.compile(home_tpl);
	require("../../common/common_require");

	var myTaskCount;
	var recommendFileCount;
	var questionCount;
	var myHomeworkCount;
	
	var home = {
		queryHomeResources : function() {
			ajax({
				url : "/qaplus/resource/query_home_resource.json",
				success : function(result) {
					for (var i = 0; i < result.data.length; i++) {
						// "我的问题"
						if(result.data[i].resKey=="RES_HOME_MY_PROBLEM_STU"){
							ajax({
								url : "/qaplus/q/count_all_my_q.json",
								async:false,
								success : function(result2) {
									var questionCount=result2.data[0];
									if(questionCount){
										result.data[i].name+="（"+questionCount+"）";	
									}
								}
							});
						}
						//"学生提问"
						if(result.data[i].resKey=="RES_HOME_MY_PROBLEM_TEA"){
							ajax({
								url : "/qaplus/q/count_all_my_q.json",
								async:false,
								success : function(result2) {
									var questionCount=result2.data[0];
									if(questionCount){
										result.data[i].name+="（"+questionCount+"）";	
									}
								}
							});
						}
						// "就业信息"
						if(result.data[i].resKey=="RES_HOME_GRAD_SITUATION"){
							
						}
						// "待办事项"
						if(result.data[i].resKey=="RES_HOME_UNDO_TASK"){
							ajax({
								url : "/qaplus/task/select_my_task.json",
								async:false,
								success : function(result2) {
									var myTaskCount=result2.data.length;
									if(myTaskCount){
										result.data[i].name+="（"+myTaskCount+"）";
									}
								}
							});
						}
						// "就业心得"
						if(result.data[i].resKey=="RES_HOME_GRAD_GET"){
							
						}
						// "资料管理"
						if(result.data[i].resKey=="RES_HOME_RESOURCE"){
							ajax({
								url : "/qaplus/recommend/count_recommend_file.json",
								async:false,
								success : function(result2) {
									var recommendFileCount=result2.data[0];
									if(recommendFileCount){
										result.data[i].name+="（"+recommendFileCount+"）";
									}
								}
							});
						}
						// "学生作业"
						if(result.data[i].resKey=="RES_HOME_RESOURCE_STU"){
							ajax({
								url : "/qaplus/homework/count_my_homework.json",
								async:false,
								success : function(result2) {
									var myHomeworkCount=result2.data[0];
									if(myHomeworkCount){
										result.data[i].name+="（"+myHomeworkCount+"）";
									}
								}
							});
							
						}
						
					}
					var html = template(result);
					$(".nav_container").html(html);
					$(".center-nav").click(function(){
						window.open($(this).data("url"), "", null, null);
					});
				}
			});
		}

	}

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			home.queryHomeResources();
		}
	};
});