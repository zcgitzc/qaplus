define(function(require, exports, module) {
    // 通过 require 引入依赖
    var $ = require("jQuery");
    var ajax = require("../../common/util/ajax");
    require('../../common/util/ajaxExt');
    var Util = require('../../common/util/util');
    var Handlebars = require("handlebars");
    var helpers = require("../../common/helpers");
    Handlebars.registerHelper(helpers);
    require("./errorQuestions.css");
    require("../../common/common.css");
    var tpl = require("./errorQuestions.tpl");
    var template = Handlebars.compile(tpl);
    require("../../common/common_require");
    var allErrorQuestions;

    $('.question_search input').on('ifChecked', function(e) {
        errorQuestions.search();
    });
    $('.question_search input').on('ifUnchecked', function(e) {
        errorQuestions.search();
    });
    $("#toggle").click(function() {
        if ($(this).text() == "查看答案") {
            $(this).text("隐藏答案").removeClass("btn-primary").addClass("btn-success");
            for (var i = allErrorQuestions.data.length - 1; i >= 0; i--) {
                var question = allErrorQuestions.data[i];
                question.canReadNote = "Y";
            };
        } else {
            $(this).text("查看答案").removeClass("btn-success").addClass("btn-primary");
            for (var i = allErrorQuestions.data.length - 1; i >= 0; i--) {
                var question = allErrorQuestions.data[i];
                question.canReadNote = "N";
            };
        }
        var html = template(allErrorQuestions);
        $("#errorQuestions").html(html);
    });
    var errorQuestions = {
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
            errorQuestions.search();
        },
        search:function(){
            ajax({
                url: "/qaplus/examQuestion/queryAllErrorQuestions.json",
                data:$("#searchForm").serialize(),
                success: function(result) {
                    allErrorQuestions = result;
                    $("#totalCount").html(result.data.length);
                    var html = template(result);
                    $("#errorQuestions").html(html);
                    $('.errorTip').on('mouseover', function() {
                        var that = this;
                        layer.tips('注意：下列是你当初选错的选项，点击右上方“查看答案”，显示正确答案。如果“单选”选中两个说明做错了两次', that, {
                            tips: 4
                        });
                    });

                    $(".remove").click(function(event) {
                        errorQuestions.remove($(this).data('id'));
                    });
                },
            });
        },
        remove:function(questionId){
            ajax({
                url:"/qaplus/examQuestion/removeErrorQuestion.json",
                data:"questionId="+questionId,
                success:function(){
                    errorQuestions.search();
                }
            });
        }
    };
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            errorQuestions.initPage();
        }
    };
});