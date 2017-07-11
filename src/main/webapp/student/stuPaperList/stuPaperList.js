define(function(require, exports, module) {
    // 通过 require 引入依赖
    var $ = require("jQuery");
    var ajax = require("../../common/util/ajax");
    require('../../common/util/ajaxExt');
    var Handlebars = require("handlebars");
    var helpers = require("../../common/helpers");
    require("../../common/common.css");
    Handlebars.registerHelper(helpers);
    require("./stuPaperList.css");
    var tpl = require("./stuPaperList.tpl");
    var template = Handlebars.compile(tpl);
    require("../../common/common_require");
    var stuPaperList = {
        initPage: function() {
            ajax({
                url: "/qaplus/paper/queryStuPapers.json",
                success: function(result) {
                    $("#stuPapers").html(template(result));
                    $(".startExam").click(function() {
                        window.open("/qaplus/student/stuStartExam/stuStartExam.jsp?paperId=" + $(this).data("id"), "学生考试", null, null);
                    });
                }
            });
        },
    };
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            stuPaperList.initPage();
        }
    };
});