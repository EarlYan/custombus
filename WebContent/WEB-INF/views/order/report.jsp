<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="../echarts/echarts.min.js"></script>
    <link href="../user/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="../user/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="../user/css/plugins/footable/footable.core.css" rel="stylesheet">
    <link href="../user/css/animate.min.css" rel="stylesheet">
    <link href="../user/css/style.min.css?v=20161215001" rel="stylesheet">

</head>

<body class="gray-bg">
	     <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>订单统计报表</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="graph_flot.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div style="height:600px" id="main"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 全局js -->
    <script src="../user/js/jquery-2.1.1.min.js"></script>
    <script src="../user/js/bootstrap.min.js?v=3.4.0"></script>
	<!-- echarts -->
    <script type="text/javascript">
    var reportData =[];
    var reportDataAxi=[];
    <c:forEach var="oc" items="${orderCount}">
    	reportData.push('${oc.total}');
    	reportDataAxi.push('${oc.time}');
    </c:forEach>
    console.log(reportData);
    console.log(reportDataAxi);
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
	var dataAxis = reportDataAxi;
	var data = reportData;
	var yMax = 0;
	var dataShadow = [];
	
	for (var i = 0; i < data.length; i++) {
	    dataShadow.push(yMax);
	}

		option = {
		    title: {
		        text: '订单统计报表',
		        subtext: '当前数据为每日用户下单总金额数'
		    },
		    xAxis: {
		        data: dataAxis,
		        axisLabel: {
		            inside: true,
		            textStyle: {
		                color: '#fff'
		            }
		        },
		        axisTick: {
		            show: false
		        },
		        axisLine: {
		            show: false
		        },
		        z: 10
		    },
		    yAxis: {
		        axisLine: {
		            show: false
		        },
		        axisTick: {
		            show: false
		        },
		        axisLabel: {
		            textStyle: {
		                color: '#999'
		            }
		        }
		    },
		    dataZoom: [
		        {
		            type: 'inside'
		        }
		    ],
		    series: [
		        { // For shadow
		            type: 'bar',
		            itemStyle: {
		                normal: {color: 'rgba(0,0,0,0.05)'}
		            },
		            barGap:'-100%',
		            barCategoryGap:'40%',
		            data: dataShadow,
		            animation: false,
		        },
		        {
		            type: 'bar',
		            label: {
		                normal: {
		                    show: true,
		                    position: 'top'
		                }
		            },
		            itemStyle: {
		                normal: {
		                    color: new echarts.graphic.LinearGradient(
		                        0, 0, 0, 1,
		                        [
		                            {offset: 0, color: '#83bff6'},
		                            {offset: 0.5, color: '#188df0'},
		                            {offset: 1, color: '#188df0'}
		                        ]
		                    )
		                },
		                emphasis: {
		                    color: new echarts.graphic.LinearGradient(
		                        0, 0, 0, 1,
		                        [
		                            {offset: 0, color: '#2378f7'},
		                            {offset: 0.7, color: '#2378f7'},
		                            {offset: 1, color: '#83bff6'}
		                        ]
		                    )
		                },		            
		            },
		            data: data
		        }
		    ]
		};
		
		// Enable data zoom when user click bar.
		var zoomSize = 6;
		myChart.on('click', function (params) {
		    console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
		    myChart.dispatchAction({
		        type: 'dataZoom',
		        startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
		        endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
		    });
		});
	    // 使用刚指定的配置项和数据显示图表。
	    myChart.setOption(option);
	</script>
</body>
</html>