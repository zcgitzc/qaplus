define(function(require, exports, module) {
    // 通过 require 引入依赖
    var $ = require("jQuery");
    var ajax = require("../../common/util/ajax");
    require('../../common/util/ajaxExt');
    require("../../common/common.css");
    var Handlebars = require("handlebars");
    var helpers = require("../../common/helpers");
    Handlebars.registerHelper(helpers);
    var Util = require("../../common/util/util");
    require("../../common/ellipsis/ellipsis");
    var moment = require("moment");
    require("./teaQuestionBank.css");
    require("../../common/common_require");
    var commonLogicUtil = require('../../common/util/commonLogicUtil');
    var current = 1;
    var length = 10;
    var singleQuestionData;
    var index;
    $("#toAddHomework").click(function() {
        questionList.toAddHomework();
    });
    $("#toAddQuestion").click(function() {
        questionList.toAddOrUpdateQuestion('add');
    });
    $("#addOrUpdateButton").click(function() {
        if ($(this).data("oper") == "add") {
            questionList.doAddTeacherQuestion();
        } else if ($(this).data("oper") == "update") {
            questionList.doUpdateTeacherQuestion();
        }
    });
    $("#exportTQuestion").click(function() {
        questionList.exportTQuestion();
    });
    $("#importTQuestion").click(function() {
        questionList.importTQuestion();
    });
    var questionList = {
        initPage: function() {
            commonLogicUtil.questionSearchToolbar(["my"], "/qaplus/q/query_s_question.json", ["QUESTION_CATEGORY", "MY_CATEGORY"]);
        },
        initTableData: function() {
            $('#tableContainer').bootstrapTable({
                url: "/qaplus/q/query_t_question.json",
                method: 'get',
                dataType: "json",
                height: 600,
                contentType: "application/x-www-form-urlencoded",
                queryParamsType: "limit",
                queryParams: questionList.queryParams,
                detailView: true,
                search: true,
                formatSearch: function() {
                    return "输入标题模糊搜索";
                },
                searchText: Util.getUrlParam("title"),
                detailFormatter: function(index, row) {
                    var html = [];
                    $.each(row, function(key, value, index) {
                        if (key == 'title' || key == 'content' || key == 'recCreateDate' || key == 'category') {
                            var val = "";
                            if (key == 'title') {
                                val = "问题标题";
                            } else if (key == 'content') {
                                val = "问题描述";
                            } else if (key == 'recCreateDate') {
                                val = "提问时间";
                            } else if (key == 'category') {
                                val = "问题分类";
                            }
                            html.push('<p><b>' + val + ':</b> ' + value + '</p>');
                        }
                    });
                    return html.join('');
                },
                pagination: true,
                onClickRow: function(row, tr) {
                    /*if(tr.hasClass("selected")){
										tr.removeClass("selected");
									}else{
										tr.addClass("selected");
									}*/
                }, // 单击row事件
                responseHandler: questionList.responseHandler,
                onLoadSuccess: function(result) {
                    $(".del").click(function() {
                        questionList.del($(this).data("id"));
                    });
                    $(".update").click(function() {
                        questionList.update($(this).data("id"));
                    });
                    $(".questionAttach").click(function() {
                        Util.downloadAttach($(this).data("question-attach-id"));
                    });
                    $(".answerAttach").click(function() {
                        Util.downloadAttach($(this).data("answer-attach-id"));
                    });
                    $(".detail-icon").trigger("click");
                },
                columns: [{
                    field: 'state',
                    checkbox: true
                }, {
                    field: 'i',
                    title: '序号',
                    formatter: function(value, row, index) {
                        return index + 1;
                    }
                }, {
                    field: 'title',
                    title: '问题标题',
                }, {
                    field: 'content',
                    title: '问题描述',
                }, {
                    field: 'category',
                    title: '问题分类'
                }, {
                    field: 'recCreateDate',
                    title: '创建时间',
                    formatter: function(value, row, index) {
                        return moment(value).format("YYYY-MM-DD");
                    }
                }, {
                    field: "questionHasAttachment",
                    visible: false,
                }, {
                    title: '操作',
                    field: 'id',
                    formatter: function(value, row, index) {
                        var f = "";
                        var g = "";
                        var e = '<span class="label label-primary update" style="cursor:pointer;"  data-id=' + row.id + '>编辑</span>&nbsp;';
                        var d = '<span class="label label-danger del" style="cursor:pointer;"  data-id=' + row.id + '>删除</span>&nbsp;'
                        if (row.questionHasAttachment == "Y") {
                            f = '<span class="label label-info questionAttach" style="cursor:pointer;" data-question-attach-id=' + row.questionAttachmentId + ' title="问题附件">问题</span>&nbsp;	';
                        }
                        if (row.answerHasAttachment == "Y") {
                            g = '<span class="label label-info answerAttach" style="cursor:pointer;" data-answer-attach-id=' + row.answerAttachmentId + ' title="答案附件">答案</span>&nbsp;';
                        }
                        return e + d + f + g;
                    }
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
        exportTQuestion: function() {
            var searchText = $(".search input").val();
            $("#title").val(searchText);
            Util.downloadExcel("/qaplus/q/export_t_question.json", $("#searchForm"));
        },
        importTQuestion: function() {
            Util.uploadAttach($("#file-3"), null, {
                browseLabel: "上传Excel&hellip;",
                uploadUrl: "/qaplus/q/import_t_question.json",
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
        queryQuestionById: function(id) {
            ajax({
                url: "/qaplus/q/query_tea_q.json",
                data: "id=" + id,
                success: function(result, status) {
                    singleQuestionData = result;
                },
            });
        },
        del: function(id) {
            // 询问框
            layer.confirm('您确认删除这个问题？温馨提示：删除之后可在数据恢复区保存5天，5天之后将永久删除', {
                btn: ['确认', '取消']
                // 按钮
            }, function(index) {
                ajax({
                    url: "/qaplus/q/delete_tea_q.json",
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
        update: function(id) {
            ajax({
                url: "/qaplus/q/query_tea_q.json",
                data: "id=" + id,
                success: function(result) {
                    $("#id").val(result.data[0].id);
                    $("#titleUpdate").val(result.data[0].title);
                    $("#content").text(result.data[0].content);
                    $("#answer").text(result.data[0].answer);
                    $("#oldQuestionAttachment").text("");
                    if (result.data[0].questionHasAttachment != undefined && result.data[0].questionHasAttachment == 'Y') {
                        $("#oldQuestionAttachment").text("原来问题附件：" + result.data[0].attachmentRealName);
                    }
                    questionList.toAddOrUpdateQuestion("update");
                },
            });
            ajax({
                url: "/qaplus/q/query_tea_a.json",
                data: "id=" + id,
                success: function(result) {
                    if (result.data[0].answerHasAttachment != undefined && result.data[0].answerHasAttachment == 'Y') {
                        $("#oldAnswerAttachment").text("原来答案附件：" + result.data[0].attachmentRealName);
                    }
                },
            });
        },
        toAddHomework: function() {
            var selectedRows = $('#q_list').bootstrapTable("getSelections");
            var ids = [];
            for (var i = 0; i < selectedRows.length; i++) {
                ids.push(selectedRows[i].id);
            }
            window.open("/qaplus/teacher/teaAddHomework/teaAddHomework.jsp?ids=" + ids, "布置家庭作业", null, null);
        },
        toAddOrUpdateQuestion: function(oper) {
            var titleContent = "";
            if (oper == "add") {
                titleContent = "添加问题到题库";
                $("#id").val("");
                $("#titleUpdate").val("");
                $("#content").text("");
                $("#answer").text("");
                $("#oldQuestionAttachment").text("");
            } else if (oper == "update") {
                $("#addOrUpdateButton").text("确认修改");
                $("#addOrUpdateButton").data("oper", "update");
                titleContent = "修改问题";
            }
            //初始化 fileinput 
            Util.uploadAttach($("#questionAttach"), $("#questionAttachmentId"), {
                browseLabel: "问题附件&hellip;"
            });
            Util.uploadAttach($("#answerAttach"), $("#answerAttachmentId"), {
                browseLabel: "答案附件&hellip;"
            });
            // 捕获页
            index = layer.open({
                type: 1,
                area: ['600px', '550px'], // 宽高
                shade: false,
                title: titleContent, // 不显示标题
                content: $('#addOrUpdateQuestionDiv')
            });
        },
        doAddTeacherQuestion: function() {
            ajax({
                url: "/qaplus/q/add_tea_q.json",
                data: $("#addOrUpdateTeacherQuestionForm").serialize(),
            });
        },
        doUpdateTeacherQuestion: function() {
            ajax({
                url: "/qaplus/q/update_tea_q.json",
                data: $("#addOrUpdateTeacherQuestionForm").serialize(),
            });
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