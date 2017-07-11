define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	var moment = require("moment");
	require("../../common/common.css");
	require("./classList.css");
	require("../../common/common_require");
	
	$("#addClass").click(function() {
		classList.add();
	});
	$("#addClassBtnContinue").click(function() {
		classList.doAddClass(true);
	});
	$("#addClassBtn").click(function() {
		classList.doAddClass(false);
	});

	var classList = {
		initPage : function() {
			$('#classList').on('editable-save.bs.table',
							function(e, field, row, old, $el) {
								ajax({
									url : "/qaplus/class/update_class.json",
									data : "id=" + row.id + "&name=" + row.name+ "&person=" + row.person,
									success : function(result) {
										var $els = $('#classList').find('.editable');
										var next = $els.index($el) + 1;
										if (next >= $els.length) {
											return;
										}
										$els.eq(next).editable('show');
									}
								});
							});
		},
		initTableData : function() {
			$('#classList')
					.bootstrapTable(
							{
								url : "/qaplus/class/select_all_class.json",
								method : 'post',
								height : 600,
								cache : false,
								dataType : "json",
								contentType : "application/x-www-form-urlencoded",
								sidepagination : "server", // 服务端请求
								queryParamsType : "limit",
								queryParams : classList.queryParams,// 传递参数（*）
								pagination : true,
								sidePagination : "server",
								toolbar : "#toolbar",
								responseHandler : classList.responseHandler,
								onLoadSuccess : function(result) {
									$(".del").click(function() {
										classList.del($(this).data("id"));
									});
								},
								columns : [
										{
											field : 'i',
											width : '50',
											title : '序号',
											formatter : function(value, row,
													index) {
												return index + 1;
											}
										},
										{
											field : 'name',
											title : '班级名称',
											editable : {
												type : 'text'
											}
										},
										{
											field : 'person',
											title : '班级人数',
											editable : {
												type : 'text'
											}
										},
										{
											field : 'recCreateDate',
											width : "100",
											title : '创建时间',
											formatter : function(value, row,
													index) {
												return moment(value).format(
														"YYYY-MM-DD");
											}
										},
										{
											title : '操作',
											field : 'id',
											width : "165",
											formatter : function(value, row,
													index) {
												var a = '<span class="label label-danger del" data-id='
														+ row.id
														+ ' style="cursor:pointer;">删除</span>&nbsp;'
												return a;
											}
										} ]
							});
		},
		queryParams : function(params) {
			var paramObj = {
				"begin" : params.offset,
				"end" : params.limit
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
		del : function(id) {
			// 询问框
			layer.confirm('您确认删除这个问题？温馨提示：删除之后可在数据恢复区保存5天，5天之后将永久删除', {
				btn : [ '确认', '取消' ]
			// 按钮
			}, function(index) {
				ajax({
					url : "/qaplus/class/update_class.json",
					data : "id=" + id + "&isDeleted=Y",
					success : function(result) {
						layer.close(index);
						window.location.reload(true);
					}
				});
			}, function(index) {
				layer.close(index);
			});

		},
		add : function() {
			ajax({
				url : "/qaplus/user/select_all_tea.json",
				success : function(result) {
					$('#sel_class').select2({
						placeholder : "请至少选择一个老师",
						tags : true,
						width : '495px'
					});

					var optionHtml = "";
					for (var i = 0; i < result.data.length; i++) {
						optionHtml += "<option value=" + result.data[i].id
								+ ">" + result.data[i].name + "</option>"
					}
					$("#sel_class").html(optionHtml);

					// 捕获页
					layer.open({
						type : 1,
						skin : 'add_class', // 样式类名
						area : [ '640px', '340px' ], // 宽高
						shade : false,
						title : "添加班级", // 不显示标题
						content : $('#add_class')
					});

				}
			});

		},
		doAddClass : function(isContinue) {
			ajax({
				url : "/qaplus/class/add_class.json",
				data : $("#addClassForm").serialize(),
				success : function(result) {
					if (isContinue) {
						$("#class_name").val("");
						$("#class_person").val("");
					} else {
						layer.msg(result.msg, {
							icon : 6,
							time : "1000",
						}, function() {
							window.location.reload(true);
						});
					}
				}
			});
		}
	};

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			classList.initPage();
			classList.initTableData();
		}
	};
});
