<%--
  Created by IntelliJ IDEA.
  User: caojx
  Date: 17-5-6
  Time: 上午10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售情况</title>
    <!-- 引入jquery.js -->
    <script src="/js/common/jquery.min.js"></script>
    <!-- ECharts单文件引入 -->
    <script src="/js/common/echarts.js"></script>
</head>
<body>
<div style="padding: 40px">
    <div id="main" style="height:400px;width: 500px;float: left"></div>
    <div id="main2" style="height:400px;width: 500px;float: right"></div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {

        /**
         * 初始化视图
         */
        var initView = function () {
            initAccessView();
            initSalesView();
        };

        /**
         * 获取访问情况数据
         */
        var initAccessView = function () {
            var name = new Array();
            var count = new Array();
            $.ajax({
                url: "/salesAnalysis/getAccessData",
                type: "post",
                success: function (data) {
                    if (data.status == 1) {
                        var accessDataList = data.accessDataList;
                        $.each(accessDataList, function (key1, itemList) {
                            name.push(itemList[0]);
                            count.push(itemList[1]);
                        });
                        initCharts(name, count);
                    } else {
                        alert(data.error);
                    }
                }
            });
        };

        /**
         * 获取销售数据
         */
        var initSalesView = function () {
            var array = [];
            $.ajax({
                url: "/salesAnalysis/getSalesData",
                type: "post",
                success: function (data) {
                    if (data.status == 1) {
                        var salesDataList = data.salesDataList;
                        $.each(salesDataList, function (key1, itemList) {
                            var item = {
                                name: itemList[0],
                                value: itemList[1]
                            };
                            array.push(item);
                        });
                        initCharts2(array);
                    } else {
                        alert(data.error);
                    }
                }
            });
        };

        /**
         *初始化图表数据
         */
        var initCharts = function (array1, array2) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = echarts.init(document.getElementById("main"));
            var option = {
                title: {
                    text: "15天用户访问量",
                },
                tooltip: {
                    show: true
                },
                legend: {
                    data: ["用户访问量"]
                },
                xAxis: [
                    {
                        type: 'category',
                        data: array1,
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        scale: true,
                        minInterval: 1
                    }
                ],
                series: [
                    {
                        "name": "用户访问量",
                        "type": "bar",
                        "data": array2,
                    },
                ]
            };
            // 为echarts对象加载数据
            myChart.setOption(option);
        }

        var initCharts2 = function (array1) {
            var myChart = echarts.init(document.getElementById("main2"));
            var option = {
                title: {
                    text: "15天销售情况",
                },
                tooltip: {
                    show: true,
                },
                legend: {
                    orient: 'vertical',
                    x: 'right',
                    data: ['校园代步', '电子设备', '电器', '电脑', '运动健身','衣物伞冒','图书教材','其他'],
                },
                series: [
                    {
                        name: '数量',
                        type: 'pie',
                        radius: ['50%', '70%'],
                        label: {
                            normal: {
                                show: false,
                                position: "center"
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'bold'
                                }
                            }
                        },
                        data: array1
                        /*[
                            {"name":"校园代步","value":1},
                            {"name":"衣物伞冒","value":2},
                        ]*/
                    }
                ]
            };
            myChart.setOption(option);
        }

        /**
         * 初始化
         */
        var init = function () {
            initView();
        };

        init();
    });

</script>
</html>
