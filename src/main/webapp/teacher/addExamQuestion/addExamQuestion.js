define(function(require, exports, module) {
    // 通过 require 引入依赖
    var $ = require("jQuery");
    var helpers = require("../../common/helpers");
    var Handlebars = require("handlebars");
    Handlebars.registerHelper(helpers);
    require("./addExamQuestion.css");
    require("../../common/common.css")
    var tpl = require("./addExamQuestion.tpl");
    var Util = require("../../common/util/util");
    var template = Handlebars.compile(tpl);
    var ajax = require("../../common/util/ajax");
    require('../../common/util/ajaxExt');
    require("../../common/common_require");
    var commonLogicUtil = require('../../common/util/commonLogicUtil');
    $("#addItemHtml").click(function() {
        $("#itemList").append(template());
        $(".deleteItem").click(function() {
            $(this).parent().parent().remove();
        });
        $(".isRightItem").click(function() {
            if ($(this).is(':checked')) {
                $(this).next().val("Y");
            } else {
                $(this).next().val("N");
            }
        });
    });
    $("#addExamQuestionBtn").click(function() {
        addExamQuestion.addExamQuestion();
    });
    var addExamQuestion = {
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
            $(".addExamQuestionContent").summernote({
                height: 300,
            });
            for (var i = 0; i < 4; i++) {
                $("#itemList").append(template());
            }
            $(".deleteItem").click(function() {
                $(this).parent().parent().remove();
            });
            $(".isRightItem").click(function() {
                if ($(this).is(':checked')) {
                    $(this).next().val("Y");
                } else {
                    $(this).next().val("N");
                }
            });
        },
        addExamQuestion: function() {
            $("#content").val($(".addExamQuestionContent").summernote("code"));
            ajax({
                url: "/qaplus/examQuestion/addExamQuestion.json",
                data: $("#addExamQuestionForm").serialize(),
            });
        },
    };
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            addExamQuestion.initPage();
        }
    };
});