define(function(require, exports, module) {
    // 通过 require 引入依赖
    var $ = require("jQuery");
    var ajax = require("../../common/util/ajax");
    require('../../common/util/ajaxExt');
    require("../../common/common.css")
    require("../../common/common_require");
    var Util = require("../../common/util/util");
    var Handlebars = require("handlebars");
    var helpers = require("../../common/helpers");
    Handlebars.registerHelper(helpers);
    require("./recommendFile.css");
    var leftNav = require("./leftNav.tpl");
    var rightContent = require("./rightContent.tpl");
    var leftNavTpl = Handlebars.compile(leftNav);
    var rightContentTpl = Handlebars.compile(rightContent);
    var commonLogicUtil = require('../../common/util/commonLogicUtil');
    var current = 1;
    var length = 5;
    var totalCount = 1;
    $("#title").keyup(function() {
        current = 1;
        recommendFile.search($(this).val(), true);
    });
    var recommendFile = {
        initPage: function() {
            $('.to-top').toTop();
            commonLogicUtil.questionSearchToolbar(["my"], ["QUESTION_CATEGORY", "MY_CATEGORY"], function() {
                current = 1;
                recommendFile.search($("#title").val(), true);
            });
            recommendFile.search($("#title").val(), true);
        },
        search: function(title, refeshPagintion) {
            if (!title) {
                title = "";
            }
            ajax({
                url: "/qaplus/recommend/recommend_file.json",
                data: $("#searchForm").serialize() + "&current=" + current + "&length=" + length + "&title=" + title,
                async: false,
                success: function(result) {
                    $("#myNav").html(leftNavTpl(result));
                    $("#rightContent").html(rightContentTpl(result));
                    $(".del").click(function() {
                        recommendFile.del($(this).data("id"));
                    });
                    $(".attach").click(function() {
                        Util.downloadAttach($(this).data("id"));
                    });
                    totalCount = result.count;
                    if (refeshPagintion) {
                        recommendFile.initPagintion(totalCount);
                    }
                },
            });
        },
        initPagintion: function(totalCount) {
            var totalPages = 0;
            if (totalCount <= 5) {
                totalPages = 1;
            } else if (totalCount % 5 != 0) {
                totalPages = parseInt(totalCount / 5) + 1;
            } else {
                totalPages = totalCount / 5;
            }
            // 填充分页栏
            var element = $('.pagination'); // 获得数据装配的位置
            // 初始化所需数据
            var options = {
                currentPage: 1, // 当前页数
                numberOfPages: 5, // 显示页码数标个数
                totalPages: totalPages, // 总共的数据所需要的总页数
                onPageClicked: function(e, originalEvent, type, page) {
                    // 单击当前页码触发的事件。若需要与后台发生交互事件可在此通过ajax操作。page为目标页数。
                    current = page;
                    recommendFile.search($("#title").val(), false);
                }
            };
            element.bootstrapPaginator(options); // 进行初始化
        },
        del: function(id) {
            // 询问框
            layer.confirm('您确认删除这个问题？温馨提示：删除之后可在数据恢复区保存5天，5天之后将永久删除', {
                btn: ['确认', '取消']
                // 按钮
            }, function(index) {
                ajax({
                    url: "/qaplus/recommend/del_recommend.json",
                    dataType: "json",
                    type: "post",
                    data: "id=" + id
                });
            }, function(index) {
                layer.close(index);
            });
        },
    }
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            recommendFile.initPage();
        }
    };
});