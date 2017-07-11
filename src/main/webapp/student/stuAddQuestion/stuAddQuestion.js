define(function(require, exports, module) {
    // 通过 require 引入依赖
    var $ = require("jQuery");
    var ajax = require("../../common/util/ajax");
    require('../../common/util/ajaxExt');
    var Util = require('../../common/util/util');
    var commonLogicUtil=require('../../common/util/commonLogicUtil');
    var Handlebars = require("handlebars");
    var helpers = require("../../common/helpers");
    Handlebars.registerHelper(helpers);
    require("./stuAddQuestion.css");
    require("../../common/common.css");
    var tpl = require("./stuAddQuestion.tpl");
    var template = Handlebars.compile(tpl);
    require("../../common/common_require");
    $("#addQuestion").click(function() {
        addQuestion.addQuestion(false);
    });
    $("#addQuestionContinue").click(function() {
        addQuestion.addQuestion(true);
    });
    var addQuestion = {
        initPage: function() {
            commonLogicUtil.questionCategory($("#category"));
            $('#radioset input').each(function() {
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
            $('#addQuestionContinue').on('mouseover', function() {
                var that = this;
                layer.tips('注意：为了锻炼独立思考能力，以及减轻老师的负担，每天只能提三个问题，请慎重考虑', that, {
                    tips: 4
                });
            });
            $('#recentQuestion').on('mouseover', function() {
                var that = this;
                layer.tips('注意：此处只显示最近10条问题记录，如果想查看所有的，请到问题列表中查看', that, {
                    tips: 4
                });
            });
            $(".fileUploadTip").on('mouseover', function() {
                var that = this;
                layer.tips('选择文件之后，点击上传按钮', that, {
                    tips: 3,

                });
            });
            Util.uploadAttach($("#file-3"), $("#questionAttachmentId"), {
                browseLabel: "上传附件&hellip;"
            });
        },
        initLeftData: function() {
            ajax({
                url: "/qaplus/q/query_s_question.json",
                data: "current=1&length=10",
                success: function(result) {
                    addQuestion.generateLeftHtml(result);
                    $(".attach").click(function() {
                        Util.downloadAttach($(this).data("id"));
                    });
                }
            });
        },
        generateLeftHtml: function(result) {
            $("#accordion").html(template(result));
        },
        addQuestion: function(isContinue) {
            ajax({
                url: "/qaplus/q/add_q.json",
                data: $("#addQuestionForm").serialize(),
                success: function(result) {
                    // 继续添加的话，刷新页面
                    if (isContinue) {
                        window.location.reload(true);
                    } else {
                        // 到问题列表
                        window.location.href 
                            = "/qaplus/student/stuQuestionList/stuQuestionList.jsp";
                    }
                },
            });
        },
    };
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            addQuestion.initPage();
            addQuestion.initLeftData();
        }
    };
});