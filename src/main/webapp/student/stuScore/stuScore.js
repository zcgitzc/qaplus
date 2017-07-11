define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	var Util = require("../../common/util/util");
	require("../../common/ellipsis/ellipsis");
	require("../../common/common.css");
	var moment = require("moment");
	var Handlebars = require("handlebars");
	var helpers = require("../../common/helpers");
	Handlebars.registerHelper(helpers);
	require("./stuScore.css");
	require("../../common/common_require");

	var current = 1;
	var length = 10;

	$('input').on('ifChecked', function(e) {
		$("#stuScore").bootstrapTable('refresh', {
			url : '/qaplus/score/queryStuScores.json'
		});
	});
	$('input').on('ifUnchecked', function(e) {
		$("#stuScore").bootstrapTable('refresh', {
			url : '/qaplus/score/queryStuScores.json'
		});
	});

	var stuScore = {
		initPage : function() {
			$('.question_search input').each(function() {
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
		// 自己尝试一下对Bootstrap封装一下，设置一下默认值
		initTableData : function() {
			$('#stuScore').bootstrapTable({
				url : "/qaplus/score/queryStuScores.json",
				method : 'get',
				cache : false,
				pagination : true,
				queryParamsType : "limit",
				search : true,
				formatSearch : function() {
					return "输入试卷名称模糊搜索";
				},
				searchText : Util.getUrlParam("title"),
				searchAlign : "right",
				queryParams : stuScore.queryParams,// 传递参数（*）
				responseHandler : stuScore.responseHandler,
				onLoadSuccess : function() {
				},
				columns : [ {
					field : 'id',
					title : '序号',
					formatter : function(value, row, index) {
						return index + 1;
					}
				}, {
					field : 'paperTitle',
					title : '试卷名称',
				}, {
					field : 'invigilateName',
					title : '监考老师',
				}, {
					field : 'paperPersonName',
					title : '出卷人',
				}, {
					field : 'paperCategory',
					title : '试卷分类',
				}, {
					field : 'examDate',
					title : '考试时间',
					formatter : function(value, row, index) {
						return moment(value).format("YYYY-MM-DD HH:mm:ss");
					}
				}, {
					field : 'totalScore',
					title : '试卷总分',
					formatter:function(value, row, index){
						return "<span style='color:green'>"+value+"</span>";
					},
				}, {
					field : 'avgScore',
					title : '平均分',
					formatter:function(value, row, index){
						return "<span style='color:blue'>"+value+"</span>";
					},
				}, {
					field : 'score',
					title : '分数',
					formatter:function(value, row, index){
						return "<span style='color:red'>"+value+"</span>";
					},
				}, ]
			});
		},
		queryParams : function(params) {
			return "begin=" + params.offset
					+ "&end=" + params.limit + "&title=" + params.search;
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
	};

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			stuScore.initPage();
			stuScore.initTableData();
		},
	};
});
