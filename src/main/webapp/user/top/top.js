define(function(require, exports, module) {
    // 通过 require 引入依赖
    var $ = require("jQuery");
    var Handlebars = require("handlebars");
    var helpers = require("../../common/helpers");
    Handlebars.registerHelper(helpers);
    var festival = require("./festival.tpl");
    var festivalTpl = Handlebars.compile(festival);
    require("./top.css");
    var ajax = require("../../common/util/ajax");
    require('../../common/util/ajaxExt');
    require("../../common/common_require");
    var index;
    $("#toAddBoard").click(function() {
        top.addBoard();
    });
    $("#getFestival").click(function() {
        top.getFestival();
    });
    $("#addBoardBtn").click(function() {
        top.doAddBoard();
    });
    $("#logout").click(function() {
        top.logout();
    });
    var top = {
        selectMyBoard: function() {
            ajax({
                url: "/qaplus/board/select_all_my_board.json",
                success: function(result) {
                    if (result.data <= 0) {
                        $("#boardTip").remove();
                    }
                }
            })
        },
        queryMyResource: function() {
            ajax({
                url: "/qaplus/resource/query_my_resource.json",
                success: function(result) {
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
                    var menuHtml = '<ul class="nav navbar-nav"  style="margin-left: 100px;">';
                    for (var i = 0; i < menu.length; i++) {
                        if (menu[i]) {
                            if (menu[i].id in treeMap) {
                                var prefixHtml = '<li class="dropdown" style="margin-left:5px;width:100px;"><a href="#" style="color:white" class="dropdown-toggle" data-toggle="dropdown">' + menu[i].name + '<b class="caret"></b></a>';
                                var prefixSubUlHtml = '<ul class="dropdown-menu" style="text-align: center;">';
                                var prefixSubLiHtml = "";
                                for (var j = 0; j < treeMap[menu[i].id].length; j++) {
                                    prefixSubLiHtml += '<li><a href=' + treeMap[menu[i].id][j].resUrl + '  target="_blank">' + treeMap[menu[i].id][j].name + '</a></li>';
                                }
                                menuHtml += prefixHtml + prefixSubUlHtml + prefixSubLiHtml + "</ul></li>";
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
            });
        },
        initPage: function() {
            top.queryMyResource();
            top.selectMyBoard();
        },
        getFestival: function() {
            ajax({
                url: "/qaplus/common/get_festivals.json",
                success: function(result) {
                    $("#festival").html(festivalTpl(result));
                    // 页面层
                    layer.open({
                        type: 1,
                        title: "您的假期情况（我们一起算着天数过日子）：",
                        skin: 'layui-layer-lan', //
                        area: ['620px', '350px'], // 宽高
                        content: $("#festival")
                    });
                }
            })
        },
        logout: function() {
            ajax({
                url: "/qaplus/user/logout.json",
                success: function(result) {
                    window.location.href = "/qaplus/user/login/login.jsp";
                },
            })
        },
        initClassStuTree: function(obj) {
            var setting = {
                view: {
                    dblClickExpand: false,
                    showLine: true,
                    selectedMulti: false
                },
                check: {
                    enable: true
                },
                data: {
                    simpleData: {
                        enable: true,
                        idKey: "treeId",
                        pIdKey: "parentId",
                        rootPId: ""
                    }
                },
                callback: {
                    beforeClick: function(treeId, treeNode) {
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
            ajax({
                url: "/qaplus/user/build_class_stu_tree.json",
                success: function(result) {
                    $.fn.zTree.init(obj, setting, result.data);
                }
            })
        },
        addBoard: function() {
            top.initClassStuTree($("#treeDemo"));
            $("#startTime").datetimepicker({
                language: "zh-CN",
                format: 'yyyy-mm-dd hh:ii:ss'
            });
            $("#endTime").datetimepicker({
                language: "zh-CN",
                format: 'yyyy-mm-dd hh:ii:ss'
            });
            $('.boardOption input').each(function() {
                var self = $(this);
                var label = self.next();
                var label_text = label.text();
                label.remove();
                self.iCheck({
                    checkboxClass: 'icheckbox_sm-blue',
                    radioClass: 'radio_sm-blue',
                    insert: label_text
                });
            });
            // 页面层
            index = layer.open({
                type: 1,
                title: "添加公告：",
                skin: 'layui-layer-lan', //
                area: ['700px', '550px'], // 宽高
                content: $("#board")
            });
        },
        doAddBoard: function(isContinue) {
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
            var nodes = treeObj.getCheckedNodes(true);
            var stuIds = [];
            for (var i = 0; i < nodes.length; i++) {
                if (!nodes[i].open) {
                    stuIds.push(nodes[i].treeId);
                }
            }
            if (stuIds.length < 1) {
                layer.msg("请选择可以查看的公告的学生", {
                    icon: 5
                })
                return;
            }
            ajax({
                url: "/qaplus/board/add_board.json",
                data: $("#addBoardForm").serialize() + "&stuIds=" + stuIds,
            })
        }
    }
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            top.initPage();
            //注册ESC事件
            $(document).keydown(function(event) {
                if (event.keyCode == 27) {
                    layer.closeAll(); //疯狂模式，关闭所有层
                }
            });
            // $(document).keydown(function(event) {
            //     if (event.keyCode == 37) {
            //         alert('左');
            //     } else if (event.keyCode == 39) {
            //         alert('右');
            //     } else if (event.keyCode == 27) {
            //         alert('esc键');
            //     } else if (event.keyCode == 13) {
            //         alert('回车键');
            //     } else {
            //         alert('这按钮的ASCII码,是' + event.keyCode);
            //     }
            // });
        }
    };
});