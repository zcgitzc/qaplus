$(function() {
	selectMyBoard();
	queryMyResource();
	initPage();
});

function initPage() {
//	$('#startTime').datetimepicker({
//		showSecond : true,
//		timeFormat : 'hh:mm:ss'
//	});
//	$('#endTime').datetimepicker({
//		showSecond : true,
//		timeFormat : 'hh:mm:ss'
//	});

}

function b() {
	t = parseInt(x.css('top'));
	y.css('top', '19px');
	x.animate({
		top : t - 19 + 'px'
	}, 'slow'); // 19为每个li的高度
	if (Math.abs(t) == h - 19) { // 19为每个li的高度
		y.animate({
			top : '0px'
		}, 'slow');
		z = x;
		x = y;
		y = z;
	}
	setTimeout(b, 3000);// 滚动间隔时间 现在是3秒
}

function queryMyResource() {
	$
			.ajax({
				url : "/qaplus/resource/query_my_resource.json",
				dataType : "json",
				type : "post",
				success : function(result) {
					if (result.hasError) {
						layer.msg(result.msg, {
							// 关闭后的操作
							icon : 5
						});
					} else {
						var menu = [];
						var treeMap = {};
						if (!result.data) {
							return;
						}
						for (var i = 0; i < result.data.length; i++) {
							if (result.data[i].type == 0) {
								menu[i] = result.data[i];
							} else {
								var treeMapValue = treeMap[result.data[i].parentId];
								if (null == treeMapValue) {
									treeMapValue = [];
									treeMap[result.data[i].parentId] = treeMapValue;
								}
								treeMapValue.push(result.data[i]);
							}

						}

						var menuHtml = '<ul class="nav navbar-nav">';

						for (var i = 0; i < menu.length; i++) {
							if (menu[i]) {
								if (menu[i].id in treeMap) {
									var prefixHtml = '<li class="dropdown" style="margin-left:5px;width:100px;"><a href="#" style="color:white" class="dropdown-toggle" data-toggle="dropdown">'
											+ menu[i].name
											+ '<b class="caret"></b></a>';

									var prefixSubUlHtml = '<ul class="dropdown-menu" style="text-align: center;">';

									var prefixSubLiHtml = "";
									for (var j = 0; j < treeMap[menu[i].id].length; j++) {

										prefixSubLiHtml += '<li><a href='
												+ treeMap[menu[i].id][j].resUrl
												+ '  target="_blank">'
												+ treeMap[menu[i].id][j].name
												+ '</a></li>';
									}
									menuHtml += prefixHtml + prefixSubUlHtml
											+ prefixSubLiHtml + "</ul></li>";
								}
							}
						}

						$("#menuBar").html(menuHtml + "</ul>");

						// 自动展开
						$('.nav .dropdown').mouseover(function() {
							$(this).addClass('open');
						});
						// 自动关闭
						$('.nav .dropdown').mouseout(function() {
							$(this).removeClass('open');
						});

					}
				},
				error : function(result) {
					layer.msg('请求失败,状态码：' + result.status, function() {

					});
				}
			});
}
function selectMyBoard() {
	$
			.ajax({
				url : "/qaplus/board/select_all_my_board.json",
				dataType : "json",
				type : "post",
				success : function(result) {
					if (result.hasError) {
						layer.msg(result.msg, {
							// 关闭后的操作
							icon : 5
						});
					} else {
						var newsHtml = "";
						for (var i = 0; i < result.data.length; i++) {
							newsHtml += '<li><a href="/qaplus/index/to_board.json" target="_blank">'
									+ result.data[i].content + '</a></li>';
						}
						$(".news_li").html(newsHtml);
						// $(".swap").jsonl(newsHtml);

						$('.swap').html($('.news_li').html());
						x = $('.news_li');
						y = $('.swap');
						h = $('.news_li li').length * 19; // 19为每个li的高度
						setTimeout(b, 3000);// 滚动间隔时间 现在是3秒

					}
				},
				error : function(result) {
					layer.msg('请求失败,状态码：' + result.status, function() {

					});
				}
			})
}

function getFestival() {
	$
			.ajax({
				url : "/qaplus/common/get_festivals.json",
				dataType : "json",
				type : "post",
				success : function(result) {
					if (result.hasError) {
						layer.msg(result.msg, {
							// 关闭后的操作
							icon : 5
						});
					} else {

						var festivalHtml = "";

						for (var i = 0; i < result.data.length; i++) {
							var tip = '<span class="badge">已过去</span>';
							if (result.data[i].rangeDays > 0) {
								tip = '<span class="badge" style="background-color:red;">还剩：'
										+ result.data[i].rangeDays + '</span>';
							}
							festivalHtml += '<a href="#" class="list-group-item">'
									+ tip
									+ result.data[i].name
									+ '('
									+ result.data[i].date + ')</a>'
						}

						$("#festival").html(festivalHtml);

						// 页面层
						layer.open({
							type : 1,
							title : "您的假期情况（我们一起算着天数过日子）：",
							skin : 'layui-layer-lan', //
							area : [ '620px', '350px' ], // 宽高
							content : $("#festival")
						});

					}
				},
				error : function(result) {
					layer.msg('请求失败,状态码：' + result.status, function() {

					});
				}
			})
}

function logout() {
	$.ajax({
		url : "/qaplus/user/logout.json",
		dataType : "json",
		type : "post",
		success : function(result) {
			if (result.hasError) {
				layer.msg(result.msg, {
					// 关闭后的操作
					icon : 5
				});
			} else {
				window.location.href = "/qaplus/index/to_login.json";
			}
		},
		error : function(result) {
			layer.msg('请求失败,状态码：' + result.status, function() {

			});
		}
	})
}
var index;
function addBoard() {

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
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				if (treeNode.isParent) {
					zTree.expandNode(treeNode);
					return false;
				} else {
					return true;
				}
			}
		}
	};

	$.ajax({
		url : "/qaplus/user/build_all_user_tree.json",
		dataType : "json",
		type : "post",
		success : function(result) {
			if (result.hasError) {
				layer.msg(result.msg, {
					// 关闭后的操作
					icon : 5
				});
			} else {
				$.fn.zTree.init($("#treeDemo"), setting, result.data);
			}
		},
		error : function(result) {
			layer.msg('请求失败,状态码：' + result.status, function() {

			});
		}
	})

	// 页面层
	index = layer.open({
		type : 1,
		title : "添加公告：",
		skin : 'layui-layer-lan', //
		area : [ '700px', '550px' ], // 宽高
		content : $("#board")
	});
}

function doAddBoard(isContainue) {
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes = treeObj.getCheckedNodes(true);
	var stuIds = [];

	for (var i = 0; i < nodes.length; i++) {
		if (!nodes[i].open) {
			stuIds.push(nodes[i].treeId);
		}
	}
	
	console.log(stuIds);
	
	$.ajax({
		url : "/qaplus/board/add_board.json",
		dataType : "json",
		data : $("#addBoardForm").serialize()+"&stuIds="+stuIds,
		type : "post",
		success : function(result) {
			if (result.hasError) {
				layer.msg(result.msg, {
					// 关闭后的操作
					icon : 5
				});
			} else {
				console.log(result);
				if (isContainue) {

				} else {
					layer.close(index);
				}
			}
		},
		error : function(result) {
			layer.msg('请求失败,状态码：' + result.status, function() {

			});
		}
	})
}