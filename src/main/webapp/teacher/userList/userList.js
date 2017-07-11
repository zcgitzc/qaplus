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
    require("./userList.css");
    require("../../common/common_require");
    $("#addClass").click(function() {
        userList.add();
    });
    $("#addClassBtnContinue").click(function() {
        userList.doAddClass(true);
    });
    $("#addClassBtn").click(function() {
        userList.doAddClass(false);
    });
    var userList = {
        initPage: function() {
            $('#q_list').bootstrapTable({
                url: "/qaplus/user/queryAllUser.json",
                method: 'get',
                height: 600,
                dataType: "json",
                sidepagination: "server", // 服务端请求
                queryParamsType: "limit",
                queryParams: userList.queryParams, // 传递参数（*）
                pagination: true,
                search: true,
                formatSearch: function() {
                    return "输入姓名、用户名搜索";
                },
                searchText: Util.getUrlParam("title"),
                sidePagination: "server",
                toolbar: "#toolbar",
                responseHandler: userList.responseHandler,
                striped: true,
                onLoadSuccess: function(result) {
                    $(".del").click(function() {
                        userList.del($(this).data("id"));
                    });
                },
                columns: [{
                    field: 'i',
                    title: '序号',
                    formatter: function(value, row, index) {
                        return index + 1;
                    }
                }, {
                    field: 'name',
                    title: '姓名',
                }, {
                    field: 'username',
                    title: '用户名',
                }, {
                    field: 'sex',
                    title: '性别',
                }, {
                    field: 'age',
                    title: '年龄',
                }, {
                    field: 'email',
                    title: '邮件',
                }, {
                    field: 'phone',
                    title: '手机号',
                }, {
                    title: '操作',
                    field: 'id',
                    width: "165",
                    formatter: function(value, row, index) {
                        var a = '<span class="label label-danger del" data-id=' + row.id + ' style="cursor:pointer;">删除</span>&nbsp;'
                        return a;
                    }
                }]
            });
        },
        queryParams: function(params) {
            var paramObj = {
                "begin": params.offset,
                "end": params.limit,
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
                    url: "/qaplus/class/update_class.json",
                    data: "id=" + id + "&isDeleted=Y",
                    success: function(result) {
                        layer.close(index);
                        window.location.reload(true);
                    }
                });
            }, function(index) {
                layer.close(index);
            });
        },
    };
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            userList.initPage();
        }
    };
});