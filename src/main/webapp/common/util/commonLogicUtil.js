define(function(require, exports, module) {
    var $ = require("jQuery");
    var numeral = require('numeral');
    var ajax = require("./ajax");
    require('./ajaxExt');
    var Handlebars = require("handlebars");
    var tpl = require("./questionSearchToolbar.tpl");
    var template = Handlebars.compile(tpl);
    var commonLogicUtil = {
        questionCategory: function($target, defaultValue) {
            ajax({
                url: "/qaplus/systemConstant/queryByCategorys.json",
                data: "categorys=QUESTION_CATEGORY",
                success: function(result) {
                    for (var i = result.data.length - 1; i >= 0; i--) {
                        if (result.data[i].code == defaultValue) {
                            result.data[i].selected = true;
                        }
                        result.data[i].id = result.data[i].code;
                    };
                    $target.select2({
                        data: result.data,
                    });
                }
            });
        },
        questionSearchToolbar: function(defaultValues, categorys, callback) {
            var param = [];
            for (var i = categorys.length - 1; i >= 0; i--) {
                param[i] = "categorys=" + categorys[i];
            };
            ajax({
                url: "/qaplus/systemConstant/queryByCategorys.json",
                data: param.join("&"),
                async: false,
                success: function(result) {
                    for (var i = result.data.length - 1; i >= 0; i--) {
                        for (var j = defaultValues.length - 1; j >= 0; j--) {
                            if (result.data[i].name == defaultValues[j]) {
                                result.data[i].checked = "Y";
                            }
                            if (result.data[i].name == 'my') {
                                result.data[i].code = $("#currId").val();
                            }
                        };
                    };
                    var html = template(result);
                    $("#toolbar").html(html);
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
                    $('.question_search input').on('ifChecked', function(e) {
                        if (typeof callback === "function") {
                            callback();
                        }
                    });
                    $('.question_search input').on('ifUnchecked', function(e) {
                        if (typeof callback === "function") {
                            callback();
                        }
                    });
                }
            });
        },
    }
    module.exports = commonLogicUtil;
});