define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	var Handlebars = require("handlebars");
	var helpers = require("../../common/helpers");
	Handlebars.registerHelper(helpers);
	require("./paperManage.css");
	require("../../common/common.css");
	var moment = require("moment");
	var tpl = require("./paperManage.tpl");
	var template = Handlebars.compile(tpl);
	var Util = require("../../common/util/util");
	require("../../common/ellipsis/ellipsis");
	require("../../common/common_require");

	var current = 1;
	var length = 10;

	$('.question_search input').on('ifChecked', function(e) {
		$("#paperList").bootstrapTable('refresh', {
			url : '/qaplus/paper/queryAllPaperForPage.json'
		});
	});
	$('.question_search input').on('ifUnchecked', function(e) {
		$("#paperList").bootstrapTable('refresh', {
			url : '/qaplus/paper/queryAllPaperForPage.json'
		});
	});

	var paperManage = {
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
		initTableData : function() {
			$('#paperList')
					.bootstrapTable(
							{
								url : "/qaplus/paper/queryAllPaperForPage.json",
								sidepagination : "server", // 服务端请求
								queryParamsType : "limit",
								height:600,
								queryParams : paperManage.queryParams,// 传递参数（*）
								detailView : true,
								detailFormatter : paperManage.detailFormatter,
								pagination : true,
								responseHandler : paperManage.responseHandler,
								search : true,
								showFooter : true,
								formatSearch : function() {
									return "输入标题模糊搜索";
								},
//								showToggle:true,
//								cardView:true,
								searchText : Util.getUrlParam("title"),
								onLoadSuccess : function(result) {
									$(".review").click(
											function() {
												var paperId = $(this)
														.data("id");
												window.open(
														"/qaplus/teacher/paperQuestions/paperQuestions.jsp?paperId="
																+ paperId,
														"试卷试题", null, null)
											});
									$(".delete").click(function() {
										var paperId = $(this).data("id");
										paperManage.deletePaper(paperId);
									});
									$(".publish").click(function() {
										var paperId = $(this).data("id");
										paperManage.publishPaper(paperId);
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
											field : 'paperTitle',
											title : '试卷标题',
											footerFormatter : paperManage.footerFormatter,
										},
										{
											field : 'paperCategory',
											title : '试卷分类',
										},
										{
											field : 'diffStage',
											title : '难易程度',
											formatter : function(value, row,
													index) {
												var result = "";
												if (value == 'EASY') {
													result = "简单";
												} else if (value == 'MIDDILE') {
													result = "中等";
												} else if (value == 'DIFFICULT') {
													result = "复杂";
												}
												return result;
											}
										},
										{
											field : 'examDate',
											title : '考试时间',
											formatter : function(value, row,
													index) {
												return moment(value).format(
														"YYYY-MM-DD HH:mm:ss");
											}
										},
										{
											field : 'examLong',
											title : '考试时长',
										},
										{
											field : 'upsetQuestion',
											title : '打乱试题顺序',
											formatter : function(value, row,
													index) {
												return value == "Y" ? "打乱"
														: "不打乱";
											}
										},
										{
											field : 'upsetItem',
											title : '打乱选项顺序',
											formatter : function(value, row,
													index) {
												return value == "Y" ? "打乱"
														: "不打乱";
											}
										},
										{
											field : "paperStatus",
											title : '试卷状态',
											formatter : function(value, row,
													index) {
												var result = "";
												if (value == 'UN_START') {
													result = "<span style='color:green'>未开始</span>";
												} else if (value == 'STARTING') {
													result = "<span style='color:red'>考试中</span>";
												} else if (value == 'STARTED') {
													result = "<span style='color:blue'>已结束</span>";
												}
												return result;
											}
										},
										{
											title : '操作',
											field : 'id',
											formatter : paperManage.operateFormatter
										} ]
							});
		},
		queryParams : function(params) {
			return $("#searchForm").serialize() + "&begin=" + params.offset
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
		detailFormatter : function(index, row) {
			var html = "";
			ajax({
				url : "/qaplus/paper/queryAllStusByPaperId.json",
				data : "paperId=" + row.id,
				async : false,
				success : function(result) {
					result.paperId = row.id;
					result.paperStatus=row.paperStatus;
					result.avgScore=row.avgScore;
					result.topThree=row.topThree;
					html = template(result);
				},
			});
			return html;
		},
		operateFormatter : function(value, row, index) {
			var d = '<span class="label label-success publish" title="使用这份试卷的试题，再从新制作一张试卷" style="cursor:pointer;" data-id='
					+ row.id + '>发布试卷</span>&nbsp;';
			var r = '<span class="label label-info review" style="cursor:pointer;" data-id='
					+ row.id + '>查看试题</span>&nbsp;';
			var a = '';
			if (row.paperStatus == 'UN_START') {
				a = '<span class="label label-danger delete" style="cursor:pointer;" data-id='
						+ row.id + '>删除</span>&nbsp;'
			}
			return d + a + r;
		},
		footerFormatter : function(data) {
			return "<span style='color:green'>点击左边 [+] 查看学生考试情况</span>";
		},
		deletePaper : function(paperId) {
			ajax({
				url : "/qaplus/paper/deletePaperById.json",
				data : "paperId=" + paperId,
			});
		},
		publishPaper : function(paperId) {
			$("#choiceClass").click(function(){
				paperManage.choiceClass();
			});
			
			$("#choiceStu").click(function(){
				paperManage.choiceStu();
			});
			
			
			$(".exam_date").datetimepicker({
				language : "zh-CN",
				format : 'yyyy-mm-dd hh:ii:ss'
			});

			// 页面层
			layer.open({
				type : 1,
				skin : 'layui-layer-lan', //
				area : [ '600px', '300px' ],
				shadeClose : true, // 开启遮罩关闭
				shift : 6,// 特效
				fix : false,
				title : "发布试卷",
				content : $('#publishPaper')
			});
			
			$("#submit").click(function(){
				paperManage.submit(paperId);
			});
		},
		submit:function(paperId){
			ajax({
				url:"/qaplus/paper/publish.json",
				data:$("#publishPaperForm").serialize()+"&paperId="+paperId,
			});
		},
		choiceClass : function() {
			ajax({
				url : "/qaplus/class/select_all_class.json",
				success : function(result) {
					var options = [];
					for (var i = 0; i < result.data.length; i++) {
						options.push("<option value=" + result.data[i].id + ">"
								+ result.data[i].name + "</option>");
					}
					$("#stuIdsDiv").hide();
					$("#classId").html(options.join(""));
					$("#classIdDiv").show();
				}
			});
		},
		choiceStu : function() {
			$("#classIdDiv").hide();
			$("#stuIdsDiv").show();
			$("#stuIds").select2({
				ajax : {
					url : "/qaplus/user/queryAllStusByLike.json",
					delay : 250,
					data : function(params) {
						return {
							searchKey : params.term,
							teacherId : $("#currId").val()
						};
					},
					processResults : function(result) {
						return {
							results : result.data
						};
					},
					cache : true
				},
				multiple : true,
				width : 375,
				escapeMarkup : function(markup) {
					return markup;
				},
				minimumInputLength : 1,
				formatInputTooShort : function() {
					return "输入学生姓名模糊匹配";
				},
			});
		},
	};

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			paperManage.initPage();
			paperManage.initTableData();
		}
	};
});
