define(function(require, exports, module) {
    // 通过 require 引入依赖
    var $ = require("jQuery");
    var helpers = require("../../common/helpers");
    var Handlebars = require("handlebars");
    Handlebars.registerHelper(helpers);
    require("./examQuestion.css");
    require("../../common/common.css")
    var tpl = require("./examQuestion.tpl");
    var Util = require("../../common/util/util");
    var template = Handlebars.compile(tpl);
    var ajax = require("../../common/util/ajax");
    require('../../common/util/ajaxExt');
    require("../../common/common_require");
    var commonLogicUtil = require('../../common/util/commonLogicUtil');
    var current = 1;
    var length = 5;
    var totalCount = 1;
    $("#toggle").click(function() {
        if ($(this).text() == "全部收起") {
            $("#accordion .panel .collapse").each(function() {
                $(this).removeClass("in").attr("aria-expanded", "false").css("height", "0px");
            });
            $(this).text("全部展开").removeClass("btn-primary").addClass("btn-success");
        } else {
            $("#accordion .panel .collapse").each(function() {
                $(this).addClass("in").attr("aria-expanded", "true").removeAttr("style");
            });
            $(this).text("全部收起").removeClass("btn-success").addClass("btn-primary");
        }
    });
    $('input').on('ifChecked', function(e) {
        examQuestion.search();
    });
    $('input').on('ifUnchecked', function(e) {
        examQuestion.search();
    });
    $("#title").keyup(function() {
        current = 1;
        examQuestion.search($(this).val(), true);
    });
    $("#import").click(function() {
        examQuestion.importQuestion();
    });
    $("#export").click(function() {
        examQuestion.exportQuestion();
    });
    var examQuestion = {
        initPage: function() {
            $('.question_search input').each(function() {
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
            var title = Util.getUrlParam("title");
            $("#title").val(title);
            examQuestion.search($("#title").val(), true);
        },
        search: function(title, refeshPagintion) {
            if (!title) {
                title = "";
            }
            ajax({
                url: "/qaplus/examQuestion/queryAllForPage.json",
                data: $("#searchForm").serialize() + "&current=" + current + "&length=" + length,
                success: function(result) {
                    $("#accordion").html(template(result));
                    if (refeshPagintion) {
                        totalCount = result.count;
                        examQuestion.initPagintion(totalCount);
                    }
                    $(".del").click(function() {
                        examQuestion.del($(this).data("id"));
                    });
                    $(".examQuestionContent").click(function() {
                        $(this).summernote({
                            focus: true,
                            height: 185
                        });
                        $(this).prev().children().show();
                    });
                    $(".updateQuestionContent").click(function() {
                        var content = $(".examQuestionContent").eq($(this).data("index")).summernote("code");
                        examQuestion.updateQuestionContent($(this).data("id"), content);
                        var questionContentEle = $(this).parent().next();
                        questionContentEle.html(content);
                        questionContentEle.summernote('destroy');
                        $(this).hide();
                    });
                    var timer = null;
                    $(".questionItem").dblclick(function() {
                        clearTimeout(timer);
                        examQuestion.updateQuestionItem($(this).data("id"), null, $(this).data("right") == "Y" ? "N" : "Y");
                    }).click(function() {
                        var that = $(this);
                        clearTimeout(timer);
                        timer = setTimeout(function() {
                            var $input = that.next();
                            $input.val(that.text());
                            $input.attr("type", "text");
                            $input.focus().val($input.val());
                            that.hide();
                            $input.blur(function() {
                                $(this).prev().show();
                                $(this).prev().text($(this).val());
                                $(this).attr("type", "hidden");
                                examQuestion.updateQuestionItem($(this).data("id"), $(this).val(), null);
                            });
                        }, 300);
                    });
                    $(".note").blur(function() {
                        examQuestion.updateQuestionNote($(this).data("id"), $(this).val());
                    });
                }
            });
        },
        updateQuestionNote: function(id, note) {
            ajax({
                url: "/qaplus/examQuestion/updateById.json",
                data: "id=" + id + "&note=" + note,
                success: function(result) {
                    examQuestion.search($("#title").val(), true);
                }
            });
        },
        updateQuestionContent: function(id, content) {
            ajax({
                url: "/qaplus/examQuestion/updateById.json",
                data: "id=" + id + "&content=" + content,
                success: function(result) {
                    examQuestion.search($("#title").val(), true);
                }
            });
        },
        updateQuestionItem: function(id, content, isRightItem) {
            var data = "id=" + id;
            if (content) {
                data += "&itemContent=" + content;
            }
            if (isRightItem) {
                data += "&isRightItem=" + isRightItem;
            }
            ajax({
                url: "/qaplus/examQuestionItem/updateById.json",
                data: data,
                success: function(result) {
                    examQuestion.search($("#title").val(), true);
                }
            });
        },
        del: function(id) {
            // 询问框
            layer.confirm('您确认删除这个问题？温馨提示：删除之后无法恢复', {
                btn: ['确认', '取消']
                // 按钮
            }, function(index) {
                ajax({
                    url: "/qaplus/examQuestion/deleteById.json",
                    data: "id=" + id,
                    success: function() {
                        layer.close(index);
                        examQuestion.search($("#title").val(), true);
                    }
                });
            }, function(index) {
                layer.close(index);
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
                    examQuestion.search($("#title").val(), false);
                }
            };
            element.bootstrapPaginator(options); // 进行初始化
        },
        importQuestion: function() {
            Util.uploadAttach($("#file-3"), null, {
                browseLabel: "上传Excel&hellip;",
                uploadUrl: "/qaplus/examQuestion/importExamQuestion.json",
                ajaxSettings: {
                    success: function(result) {
                        window.location.reload(true);
                    }
                }
            });
            layer.open({
                type: 1, //0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                //				area : [ '430px', '180px' ], 
                title: "Excel导入试题",
                content: $('#importTQuestionDiv')
            });
        },
        exportQuestion: function() {
            Util.downloadExcel("/qaplus/examQuestion/exportExamQuestion.json", $("#searchForm"));
        }
    };
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            examQuestion.initPage();
        }
    };
});