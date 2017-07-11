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
    require("./stuQuestionList.css");
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
        // 自己尝试一下对Bootstrap封装一下，设置一下默认值
        initTableData: function() {
            $('#tableContainer').bootstrapTable({
                url: "/qaplus/q/query_s_question.json",
                method: 'get',
                pagination: true,
                height: 600,
                queryParamsType: "limit",
                detailView: true,
                search: true,
                formatSearch: function() {
                    return "输入标题模糊搜索";
                },
                searchText: Util.getUrlParam("title"),
                searchAlign: "right",
                detailFormatter: questionList.detailFormatter,
                queryParams: questionList.queryParams, // 传递参数（*）
                responseHandler: questionList.responseHandler,
                onLoadSuccess: function() {
                    $(".del").click(function() {
                        questionList.del($(this).data("id"));
                    });
                    $(".update").click(function() {
                        questionList.update($(this).data("id"));
                    });
                    $(".attach").click(function() {
                        Util.downloadAttach($(this).data("id"));
                    });
                    $(".answer").click(function() {
                        questionList.answer($(this).data("id"));
                    });
                    $(".ellip").ellipsis({
                        maxWidth:250
                    });
                },
                columns: [{
                    field: 'id',
                    title: '序号',
                    formatter: function(value, row, index) {
                        return index + 1;
                    }
                }, {
                    field: 'title',
                    title: '问题标题',
                    class:'ellip'
                }, {
                    field: 'questionContent',
                    title: '问题描述',
                    class:'ellip'
                }, {
                    field: 'recCreateDate',
                    title: '提问时间',
                    order: 'asc',
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
                    field: 'solvePerson',
                    title: '解决老师'
                }, {
                    field: 'questionHasAttachment',
                    visible: false,
                }, {
                    field: 'isSolve',
                    title: '试题状态',
                    formatter: function(value, row, index) {
                        return value == "N" || value == undefined ? "未解决" : "已解决";
                    }
                }, {
                    title: '操作',
                    field: 'id',
                    formatter: questionList.operatorFormatter
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
                if (key == 'title' || key == 'questionContent' || key == 'recCreateDate' || key == "solveTime" || key == "solvePerson" || key == 'answerContent') {
                    var val = "";
                    if (key == 'title') {
                        val = "问题标题";
                    } else if (key == 'questionContent') {
                        val = "问题描述";
                    } else if (key == 'recCreateDate') {
                        val = "提问时间";
                        if (value) {
                            value = moment(value).format("YYYY-MM-DD");
                        } else {
                            value = "暂为解决";
                        }
                    } else if (key == 'solveTime') {
                        val = "解决时间";
                        if (value) {
                            value = moment(value).format("YYYY-MM-DD");
                        } else {
                            value = "暂为解决";
                        }
                    } else if (key == 'solvePerson') {
                        val = "解决老师";
                    } else if (key == 'answerContent') {
                        val = "问题答案";
                        if (!value) {
                            value = "暂为解决";
                        }
                    }
                    html.push('<p><b>' + val + ':</b> ' + value + '</p>');
                }
            });
            return html.join('');
        },
        operatorFormatter: function(value, row, index) {
            var a = "";
            var d = "";
            var f = "";
            var currId = $("#currId").val();
            if ("Y" == row.isSolve) {
                a = '<span class="label label-success answer"  style="cursor:pointer;" data-id=' + row.id + '>答案</span>&nbsp;';
            } else if (currId == row.questionPerson) {
                d = '<span class="label label-danger del" style="cursor:pointer;"data-id=' + row.id + '>删除</span>&nbsp;'
            }
            if ('Y' == row.questionHasAttachment) {
                f = '<span class="label label-info attach" style="cursor:pointer;" data-id=' + row.questionAttachmentId + '>附件</span>&nbsp; ';
            }
            return d + a + f;
        },
        del: function(id) {
            // 询问框
            layer.confirm('您确认删除这个问题？温馨提示：删除之后可在数据恢复区保存5天，5天之后将永久删除', {
                btn: ['确认', '取消']
                // 按钮
            }, function(index) {
                ajax({
                    url: "/qaplus/q/delete_q.json",
                    data: "id=" + id,
                    success: function(result) {
                        layer.close(index);
                        window.location.reload(true);
                    },
                });
            }, function(index) {
                layer.close(index);
            });
        },
        answer: function(id) {
            ajax({
                url: "/qaplus/q/query_stu_q.json",
                data: "id=" + id,
                success: function(result, status) {
                    // 询问框
                    layer.confirm(result.data[0].answerContent, {
                        btn: ['看完了', '看看附件'], // 按钮
                        title: "教师答案",
                        area: ['600px', '500px']
                    }, function(index) {
                        layer.close(index);
                    }, function() {
                        if (result.data[0].answerHasAttachment == 'Y') {
                            Util.downloadAttach(result.data[0].answerAttachmentId);
                        } else {
                            layer.msg('老师没有给你附件，真是小气...', {
                                icon: 5
                            });
                        }
                    });
                },
            });
        },
    };
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            questionList.initPage();
            questionList.initTableData();
        },
    };
});