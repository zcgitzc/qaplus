define(function(require, exports, module) {
    // 通过 require 引入依赖
    var $ = require("jQuery");
    var ajax = require("../../common/util/ajax");
    require('../../common/util/ajaxExt');
    var Handlebars = require("handlebars");
    var helpers = require("../../common/helpers");
    Handlebars.registerHelper(helpers);
    require("./teaQuestionList.css");
    require("../../common/common.css");
    var moment = require("moment");
    var Util = require("../../common/util/util");
    require("../../common/ellipsis/ellipsis");
    require("../../common/common_require");
    var commonLogicUtil = require('../../common/util/commonLogicUtil');
    var current = 1;
    var length = 10;
    var questionList = {
        initPage: function() {
            commonLogicUtil.questionSearchToolbar(["my", "solveType"], ["QUESTION_CATEGORY", "MY_CATEGORY", "SOLVE_CATEGORY"], function() {
                $("#tableContainer").bootstrapTable('refresh', {
                    url: "/qaplus/q/query_s_question.json"
                });
            });
        },
        initTableData: function() {
            $('#tableContainer').bootstrapTable({
                url: "/qaplus/q/query_s_question.json",
                method: 'get',
                contentType: "application/json",
                sidepagination: "server", // 服务端请求
                queryParamsType: "limit",
                height: 600,
                queryParams: questionList.queryParams, // 传递参数（*）
                detailView: true,
                rowStyle: function(row, index) {
                    var classes = ['active', 'success', 'info', 'warning', 'danger'];
                    if (row.needFaceComm == 'Y') {
                        return {
                            classes: classes[4]
                        };
                    }
                    return {};
                },
                detailFormatter: questionList.detailFormatter,
                pagination: true,
                responseHandler: questionList.responseHandler,
                search: true,
                formatSearch: function() {
                    return "输入标题模糊搜索";
                },
                searchText: Util.getUrlParam("title"),
                showFooter: true,
                formatNoMatches: function() {
                    return '客官，对不起，没有符合条件的记录';
                },
                onLoadSuccess: function(result) {
                    $(".answer").click(function() {
                        questionList.answer($(this).data("id"));
                    });
                    $(".isSolved").click(function() {
                        questionList.isSolved($(this).data("id"));
                    });
                    $(".attach").click(function() {
                        Util.downloadAttach($(this).data("id"));
                    });
                    $(".ellip").ellipsis({
                        maxWidth: 200
                    });
                },
                columns: [{
                    field: 'i',
                    title: '序号',
                    formatter: function(value, row, index) {
                        return index + 1;
                    }
                }, {
                    field: 'title',
                    title: '问题标题',
                    class: 'ellip',
                    footerFormatter: questionList.footerFormatter,
                }, {
                    field: 'questionContent',
                    title: '问题描述',
                    class: 'ellip'
                }, {
                    field: 'recUpdateDate',
                    title: '提问时间',
                    formatter: function(value, row, index) {
                        return moment(value).format("YYYY-MM-DD");
                    }
                }, {
                    field: 'solveTime',
                    title: '解决时间',
                    formatter: function(value, row, index) {
                        if (value == undefined) {
                            return "暂为解决";
                        } else {
                            return moment(value).format("YYYY-MM-DD");
                        }
                    }
                }, {
                    field: 'questionPerson',
                    title: '提问学生'
                }, {
                    field: 'isSolve',
                    title: '试题状态',
                    formatter: function(value, row, index) {
                        return value == "N" || value == undefined ? "未解决" : "已解决";
                    }
                }, {
                    field: "questionHasAttachment",
                    visible: false,
                }, {
                    title: '操作',
                    field: 'id',
                    formatter: questionList.operateFormatter
                }]
            });
        },
        queryParams: function(params) {
            return $("#searchForm").serialize() + "&begin=" + params.offset + "&end=" + params.limit + "&title=" + params.search;
        },
        responseHandler: function(result) {
            if (result.hasError) {
                layer.msg(result.msg, {
                    // 关闭后的操作
                    icon: 5
                });
                return {
                    "rows": [],
                    "total": 0
                };
            } else {
                return {
                    "rows": result.data,
                    "total": result.count
                };
            }
        },
        detailFormatter: function(index, row) {
            var html = [];
            $.each(row, function(key, value, index) {
                if (key == 'title' || key == 'questionContent' || key == 'recCreateDate' || key == "solveTime" || key == "questionPerson") {
                    var val = "";
                    if (key == 'title') {
                        val = "问题标题";
                    } else if (key == 'questionContent') {
                        val = "问题描述";
                    } else if (key == 'recCreateDate') {
                        val = "提问时间";
                    } else if (key == 'solveTime') {
                        val = "解决时间";
                    } else if (key == 'questionPerson') {
                        val = "提问学生";
                    }
                    if (!value) {
                        value = "";
                    }
                    html.push('<p><b>' + val + ':</b> ' + value + '</p>');
                }
            });
            return html.join('');
        },
        operateFormatter: function(value, row, index) {
            var d = "";
            var a = "";
            var f = "";
            if (row.isSolve == "N" || row.isSolve == undefined) {
                d = '<span class="label label-success answer" style="cursor:pointer;" data-id=' + row.id + '>回答</span>&nbsp;';
                a = '<span class="label label-danger isSolved" style="cursor:pointer;" data-id=' + row.id + '>已解决</span>&nbsp;'
            }
            if (row.questionHasAttachment == "Y") {
                f = '<span class="label label-info attach" style="cursor:pointer;" data-id=' + row.questionAttachmentId + '>附件</span>&nbsp;';
            }
            return d + a + f;
        },
        footerFormatter: function(data) {
            return "<span style='color:green'>带有背景色的问题需要与学生当面交流</span>";
        },
        isSolved: function(id) {
            // 询问框
            layer.confirm('确定已解决这个问题？', {
                btn: ['确定', '取消']
                // 按钮
            }, function() {
                ajax({
                    url: "/qaplus/q/upload_a.json",
                    data: "id=" + id,
                    success: function(result) {
                        window.location.reload(true);
                    },
                });
            }, function(index) {
                layer.close(index);
            });
        },
        answer: function(id) {
            window.open("/qaplus/teacher/teaAnswerQuestion/teaAnswerQuestion.jsp?id=" + id, "教师回答", null, null);
        }
    };
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            questionList.initPage();
            questionList.initTableData();
        }
    };
});