define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var _=require("underscore");
	var helpers = require("../../common/helpers");
	var Handlebars = require("handlebars");
	Handlebars.registerHelper(helpers);
	require("./homeworkManage.css");
	var tpl = require("./homeworkManage.tpl");
	var template = Handlebars.compile(tpl);
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	var Util = require("../../common/util/util");
	var moment = require("moment");
	require("../../common/ellipsis/ellipsis");
	require("../../common/common.css");
	require("../../common/common_require");
	
	require('../../common/datatables.fixedcolumns/datatables.fixedcolumns');
	require('../../common/datatables.fixedheader/datatables.fixedheader');
	
	var current = 1;
	var length = 10;

	var homeworkManage = {
		initHomeworkData : function() {
			$('#homework_list')
					.bootstrapTable(
							{
								url : "/qaplus/homework/query_homework.json",
								method : 'post',
								dataType : "json",
								contentType : "application/x-www-form-urlencoded",
								sidepagination : "server", // 服务端请求
								height:600,
								queryParamsType : "limit",
								cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
								queryParams : homeworkManage.queryParams,// 传递参数（*）
								detailView : true,
								detailFormatter : homeworkManage.detailFormatter,
								pagination : true,
								toolbar:"#toolbar",
								search : true,
								formatSearch:function(){
									return "输入标题模糊搜索";
								},
								searchText:Util.getUrlParam("title"),
								responseHandler : homeworkManage.responseHandler,
								striped : true,
								formatNoMatches : function() {
									return '无符合条件的记录';
								},
								onLoadSuccess : function(result) {
									// 解决：标题或者内容太长的情况
									$('#homework_list .ellip').ellipsis({
										maxLine : 1,
										maxWidth : 200,
									});
									$(".del").click(function(){
										homeworkManage.delHomework($(this).data("id"));
									});
									$(".fixup").click(function(){
										homeworkManage.fixup($(this).data("id"));
									});
									$(".detail-icon").trigger("click");
								},
								columns : [
										{
											field : 'i',
											title : '序号',
											formatter : function(value, row,
													index) {
												return index + 1;
											}
										},
										{
											field : 'title',
											title : '作业标题',
											class : "ellip"
										},
										{
											field : 'createPerson',
											title : '布置作业人',
											class : "ellip"
										},
										{
											field : 'recCreateDate',
											title : '创建时间',
											formatter : function(value, row,
													index) {
												return moment(value).format(
														"YYYY-MM-DD");
											}
										},
										{
											title : '操作',
											field : 'operator',
											formatter : function(value, row,
													index) {
												//TODO 可以再数据库中添加字段（也可以sql查询），已经布置给学生做了，就不能够删除了
												var d = '<span class="label label-danger del" style="cursor:pointer;" data-id='+row.id+'>删除</span>&nbsp;';
												var t = '<span class="label label-primary fixup" style="cursor:pointer;" data-id='+row.id+'>给学生做</span>&nbsp;';
												return t + d;
											}
										} ]
							});
		},
		fixedTableHeader : function(tableObj) {
			var table = tableObj.dataTable({
				"ordering" : false,
				"searching" : false,
				"info" : false,
				"paging" : false,
				"scrollCollapse" : true,
				"bAutoWidth" : true
			});

			new $.fn.dataTable.FixedHeader(table, {/*
				leftColumns : leftColumns,
				rightColumns : rightColumns
			*/});
		},
		fixedTableColumn : function(tableObj, leftColumns, rightColumns) {
			var table = tableObj.dataTable({
				"ordering" : false,
				"searching" : false,
				"info" : false,
				"paging" : false,
				"scrollCollapse" : true,
				"scrollX" : true,
				"bAutoWidth" : true
			});

			new $.fn.dataTable.FixedColumns(table, {
				leftColumns : leftColumns,
				rightColumns : rightColumns
			});
		},
		queryParams : function(params) {
			var paramObj = {
				"begin" : params.offset,
				"end" : params.limit,
				"title":params.search
			}
			return paramObj;
		},
		responseHandler : function(result) {
			if (result.hasError) {
				layer.msg(result.msg, {
					// 关闭后的操作
					icon : 5
				});
				return {
					"rows" : [],
					"total" : 0
				};
			} else {
				return {
					"rows" : result.data,
					"total" : result.count
				};
			}

		},
		delHomework : function(id) {
			// 询问框
			layer.confirm('您确认删除这个问题？温馨提示：删除之后可在数据恢复区保存5天，5天之后将永久删除', {
				btn : [ '确认', '取消' ]
			// 按钮
			}, function(index) {
				ajax({
					url : "/qaplus/homework/delete_homework.json",
					data : "id=" + id,
					success : function(result) {
						layer.close(index);
						window.location.reload(true);
					}
				});
			}, function(index) {
				layer.close(index);
			});
		},
		fixup : function(id) {
			ajax({
				url : "/qaplus/q/queryHomeworkQuestions.json",
				data : "homeworkId=" + id,
				async : false,
				success : function(result) {
					var ids = [];
					for (var i = 0; i < result.data.length; i++) {
						ids.push(result.data[i].id);
					}
					window.open(
							"/qaplus/teacher/teaAddHomework/teaAddHomework.jsp?ids=" + ids.join(","),
							"布置家庭作业", null, null);
				}
			});
		},
		detailFormatter : function(index, row) {
			var html = "";
			ajax({
				url : "/qaplus/homework/queryHomeworkDetail.json",
				async : false,
				data : "homeworkId=" + row.id,
				success : function(result) {
					html = template(result.data[0]);
				}
			});
			return html;
		}
	}
	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			homeworkManage.initHomeworkData();
		}
	};
});
