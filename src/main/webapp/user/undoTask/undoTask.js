define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var Handlebars = require("handlebars");
	var helpers = require("../../common/helpers");
	Handlebars.registerHelper(helpers);
	require("./undoTask.css");
	require('../../common/common.css');
	var tpl = require("./undoTask.tpl");
	var template = Handlebars.compile(tpl);
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	require("../../common/common_require");

	var undoTask = {
		initPage : function() {
			ajax({
				url : "/qaplus/task/select_my_task.json",
				success : function(result) {
					$("#undoTask").html(template(result));
					$(".agree").click(function() {
						undoTask.agree($(this).data("id"));
					});
					$(".reject").click(function() {
						undoTask.reject($(this).data("id"));
					});
					$(".queryQuestion").click(function() {
						undoTask.queryQuestion($(this).data("id"),$(this).data("title"));
					});
				}
			});
		},
		agree : function(id) {
			// 询问框
			layer.confirm('确认同意申请？', {
				btn : [ '确认', '取消' ]
			// 按钮
			}, function() {
				ajax({
					url : "/qaplus/task/agree.json",
					data : "id=" + id,
				});
			}, function(index) {
				layer.close(index);
			});
		},
		reject : function(id) {
			layer.prompt({
				title : '请输入拒绝原因：',
				formType : 2
			}, function(text) {
				ajax({
					url : "/qaplus/task/reject.json",
					data : "id=" + id + "&auditMsg=" + text,
				});
			});
		},
		queryQuestion : function(id,title) {
			ajax({
				url : "/qaplus/task/agree.json",
				data : "id=" + id,
				success : function(result) {
					window.open("/qaplus/student/stuQuestionList/stuQuestionList.jsp?title="+title, "学生问题列表",
							null, null);
				},
			});
		}
	};

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			undoTask.initPage();
		}
	};
});
