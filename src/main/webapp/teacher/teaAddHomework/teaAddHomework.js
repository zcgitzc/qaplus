	define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var ajax = require("../../common/util/ajax");
	require("../../common/util/ajaxExt");
	var moment = require("moment");
	var Util = require("../../common/util/util");
	var Handlebars = require("handlebars");
	var helpers = require("../../common/helpers");
	Handlebars.registerHelper(helpers);
	require("./teaAddHomework.css");
	var tpl = require("./teaAddHomework.tpl");
	var template = Handlebars.compile(tpl);

	require("../../common/common_require");
	$("#addHomeworkContinueBtn").click(function(){
		addHomework.addHomework(true);	
	});
	$("#addHomeworkBtn").click(function(){
		addHomework.addHomework(false);	
	});
	
	
	var addHomework = {
		initPage : function() {
			$(".submit_time").datetimepicker({
				language:"zh-CN",
				format : 'yyyy-mm-dd hh:ii:ss'
			});
		},
		initQuestion : function() {
			ajax({
				url : "/qaplus/q/query_tea_qs.json",
				data : "ids=" + Util.getUrlParam("ids", null),
				success : function(result) {
					$("#homeworkQuestionsDiv").html(template(result));
				},
			});

		},
		initTree : function() {
			var setting = {
				view : {
					dblClickExpand : false,
					showLine : true,
					selectedMulti : false
				},
				check : {
					enable : true
				},
				data : {
					simpleData : {
						enable : true,
						idKey : "treeId",
						pIdKey : "parentId",
						rootPId : ""
					}
				},
				callback : {
					beforeClick : function(treeId, treeNode) {
						var zTree = $.fn.zTree.getZTreeObj("stuTree");
						if (treeNode.isParent) {
							zTree.expandNode(treeNode);
							return false;
						} else {
							return true;
						}
					}
				}
			};

			ajax({
				url : "/qaplus/user/build_class_stu_tree.json",
				success : function(result) {
					$.fn.zTree.init($("#stuTree"), setting, result.data);
				},
			});
		},
		addHomework : function(isContinue) {
			var treeObj = $.fn.zTree.getZTreeObj("stuTree");
			var nodes = treeObj.getCheckedNodes(true);
			var stuIds = [];

			for (var i = 0; i < nodes.length; i++) {
				if (!nodes[i].open) {
					stuIds.push(nodes[i].treeId);
				}
			}
			ajax({
				url : "/qaplus/homework/add_homework.json",
				data : $("#homeworkForm").serialize() + "&stuIds=" + stuIds
						+ "&ids=" + Util.getUrlParam("ids", null),
				success : function(result) {
					if(isContinue){
						window.location.reload(true);
					}else{
						window.location.href = "/qaplus/teacher/homeworkManage/homeworkManage.jsp";
					}
				},
			});
		}
	};

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			addHomework.initTree();
			addHomework.initQuestion();
			addHomework.initPage();
		}
	};
});
