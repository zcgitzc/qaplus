define(function(require, exports, module) {
    // 通过 require 引入依赖
    var $ = require("jQuery");
    var _ = require("underscore");
    var helpers = require("../../common/helpers");
    var Handlebars = require("handlebars");
    Handlebars.registerHelper(helpers);
    require("./rightLog.css");
    var tpl = require("./rightLog.tpl");
    var template = Handlebars.compile(tpl);
    var ajax = require("../../common/util/ajax");
    require('../../common/util/ajaxExt');
    var Util = require("../../common/util/util");
    var moment = require("moment");
    require("../../common/ellipsis/ellipsis");
    require("../../common/common.css");
    require("../../common/common_require");
    require('../../common/datatables.fixedcolumns/datatables.fixedcolumns');
    require('../../common/datatables.fixedheader/datatables.fixedheader');
    var current = 1;
    var length = 10;
    var rightLog = {
        initHomeworkData: function() {
            $('#rightLogList').bootstrapTable({
                url: "/qaplus/log/queryAllLog.json",
                method: 'get',
                dataType: "json",
                sidepagination: "server", // 服务端请求
                height: 600,
                queryParamsType: "limit",
                queryParams: rightLog.queryParams, // 传递参数（*）
                detailView: true,
                detailFormatter: rightLog.detailFormatter,
                pagination: true,
                search: true,
                formatSearch: function() {
                    return "输入标题模糊搜索";
                },
                searchText: Util.getUrlParam("title"),
                responseHandler: rightLog.responseHandler,
                striped: true,
                onLoadSuccess: function(result) {
                    // 解决：标题或者内容太长的情况
                    $('#rightLogList .ellip').ellipsis({
                        maxLine: 1,
                        maxWidth: 200,
                    });
                    $(".del").click(function() {
                        rightLog.delHomework($(this).data("id"));
                    });
                },
                columns: [{
                    field: 'i',
                    title: '序号',
                    formatter: function(value, row, index) {
                        return index + 1;
                    }
                }, {
                    field: 'methodDesc',
                    title: '操作信息'
                }, {
                    field: 'ip',
                    title: 'IP地址'
                }, {
                    field: 'methodName',
                    title: '方法名称'
                }, {
                    field: 'recCreateDate',
                    title: '执行时间',
                    formatter: function(value, row, index) {
                        return moment(value).format("YYYY-MM-DD");
                    }
                }, {
                    field: 'recCreateUser',
                    title: '操作人',
                }, {
                    title: '操作',
                    field: 'operator',
                    formatter: function(value, row, index) {
                        var d = '<span class="label label-danger del" style="cursor:pointer;" data-id=' + row.id + '>删除</span>&nbsp;';
                        return d;
                    }
                }]
            });
        },
        queryParams: function(params) {
            var paramObj = {
                "begin": params.offset,
                "end": params.limit,
                "rightLog": "Y",
                "searchKey": params.search
            }
            return paramObj;
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
        del: function(id) {
            // 询问框
            layer.confirm('您确认删除这个问题？温馨提示：删除之后可在数据恢复区保存5天，5天之后将永久删除', {
                btn: ['确认', '取消']
                // 按钮
            }, function(index) {
                ajax({
                    url: "/qaplus/log/deleteLog.json",
                    data: "id=" + id,
                    success: function(result) {
                        layer.close(index);
                        rightLog.initHomeworkData();
                    }
                });
            }, function(index) {
                layer.close(index);
            });
        },
        detailFormatter: function(index, row) {
            var html = [];
            $.each(row, function(key, value) {
                if (key == "methodName") {
                    html.push('<p><b>方法名称:</b> ' + value + '</p>');
                } else if (key == "methodDesc") {
                    html.push('<p><b>操作信息:</b> ' + value + '</p>');
                }
            });
            return html.join('');
        }
    }
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            rightLog.initHomeworkData();
        }
    };
});