define(function(require, exports, module) {
    // 通过 require 引入依赖
    var $ = require("jQuery");
    var ajax = require("../../common/util/ajax");
    require('../../common/util/ajaxExt');
    require("./questionChart.css");
    require("../../common/common.css");
    require("../../common/common_require");
    require("../../static/echarts/echarts.common.min.js")
    var qChart = {
        initPieForSolve: function() {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('solve'));
            myChart.showLoading();
            ajax({
                url: "/qaplus/q/query_solve_pie.json",
                success: function(result) {
                    // 指定图表的配置项和数据
                    var item = [];
                    for (var i = 0; i < result.data.length; i++) {
                        item[i] = result.data[i].name;
                    }
                    var option = {
                        title: {
                            text: '所有问题统计',
                            subtext: '已解决、未解决',
                            x: 'center'
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                dataView: {
                                    show: true,
                                    readOnly: false
                                },
                                magicType: {
                                    show: true,
                                    type: ['line', 'bar']
                                },
                                restore: {
                                    show: true
                                },
                                saveAsImage: {
                                    show: true
                                }
                            }
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c} ({d}%)"
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                            data: item
                        },
                        series: [{
                            name: '解决情况',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            data: result.data,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                },
                            }
                        }],
                        animationType: 'scale',
                        animationEasing: 'elasticOut',
                        animationDelay: function(idx) {
                            return Math.random() * 200;
                        }
                    };
                    myChart.hideLoading();
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                },
            });
        },
        initColumnForCategroy: function() {
            var myChartColumn = echarts.init(document.getElementById('categroy'));
            myChartColumn.showLoading();
            // 显示标题，图例和空的坐标轴
            myChartColumn.setOption({
                title: {
                    text: '已解决问题统计',
                    subtext: '类别',
                    x: 'left'
                },
                tooltip: {},
                legend: {
                    data: ['已解决']
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataView: {
                            show: true,
                            readOnly: false
                        },
                        magicType: {
                            show: true,
                            type: ['line', 'bar']
                        },
                        restore: {
                            show: true
                        },
                        saveAsImage: {
                            show: true
                        }
                    }
                },
                xAxis: {
                    data: []
                },
                yAxis: {},
                series: [{
                    name: '已解决',
                    type: 'bar',
                    data: []
                }]
            });
            ajax({
                url: "/qaplus/q/query_category_column.json",
                success: function(result) {
                    myChartColumn.hideLoading();
                    var item = [];
                    var data = [];
                    for (var i = 0; i < result.data.length; i++) {
                        item[i] = result.data[i].name;
                        data[i] = result.data[i].value;
                    }
                    // 填入数据
                    myChartColumn.setOption({
                        xAxis: {
                            data: item,
                            // 设置成 0 强制显示所有标签
                            axisLabel: {
                                interval: 0
                            },
                            axisTick: {
                                alignWithLabel: true
                            }
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '已解决',
                            data: data
                        }]
                    });
                },
            });
        },
        initColumnForDate: function() {
            var myChartColumn = echarts.init(document.getElementById('date'));
            myChartColumn.showLoading();
            // 显示标题，图例和空的坐标轴
            myChartColumn.setOption({
                title: {
                    text: '已解决问题统计',
                    subtext: '解决时间',
                    x: 'left'
                },
                tooltip: {},
                legend: {
                    data: ['已解决']
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataView: {
                            show: true,
                            readOnly: false
                        },
                        magicType: {
                            show: true,
                            type: ['line', 'bar']
                        },
                        restore: {
                            show: true
                        },
                        saveAsImage: {
                            show: true
                        }
                    }
                },
                xAxis: {
                    data: []
                },
                yAxis: {},
                series: [{
                    name: '已解决',
                    type: 'bar',
                    data: []
                }]
            });
            ajax({
                url: "/qaplus/q/query_date_column.json",
                success: function(result) {
                    myChartColumn.hideLoading();
                    var item = [];
                    var data = [];
                    for (var i = 0; i < result.data.length; i++) {
                        item[i] = result.data[i].name;
                        data[i] = result.data[i].value;
                    }
                    // 填入数据
                    myChartColumn.setOption({
                        xAxis: {
                            data: item,
                            // 设置成 0 强制显示所有标签
                            axisLabel: {
                                interval: 0
                            },
                            axisTick: {
                                alignWithLabel: true
                            }
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '已解决',
                            data: data
                        }]
                    });
                },
            });
        }
    }
    // 输出接口，让boot.js启动
    module.exports = {
        init: function() {
            qChart.initPieForSolve();
            qChart.initColumnForCategroy();
            qChart.initColumnForDate();
        }
    };
});