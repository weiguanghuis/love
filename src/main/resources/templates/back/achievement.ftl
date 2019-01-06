﻿<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>个人报表</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="${base}/static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${base}/static/css/font-awesome.min.css">
<link rel="stylesheet" href="${base}/static/css/index.css">

<link rel="stylesheet" href="${base}/static/layui/dist/css/layui.css"
	media="all">
<script src="${base}/static/jquery/jQuery-2.2.0.min.js"></script>
<script src="${base}/static/jquery/artTemp.js"></script>
<script src="${base}/static/js/Chart.js"></script>
<script src="${base}/static/layui/dist/layui.js" charset="utf-8"></script>
<script src="${base}/static/js/common/common.js" charset="utf-8"></script>
<script>
        $(function () {

        	layui.use(['table', 'laydate'], function(){
        		var laydate = layui.laydate;
        		
        		  laydate.render({
        		    elem: '#date1'
        		    	,range: true
        		    	,format: 'yyyy年MM月dd日'
        		  });
        		
        	 
        		
        	});
        	getDate();
            Canvas1();
            Canvas2();
            Canvas3();
        });

        function getDate(){
            var time=$("#date1").val();
        	$.post("/achievement/countData","time="+time,function(data){
            	$("#allcount").html(data.numberOne+"<span>位</span>");
            	$("#docount").html(data.numberTwo+"<span>位</span>");
            	$("#allmoney").html(data.getmoney+"<span>元</span>");
            	var getthis=data.getmoney-data.putmoney;
            	if(data.percent==""){
                	
            		$("#gethandmoney").html((getthis)+"<span>元(未设置百分比)</span>");
                }else{
                	
                	$("#gethandmoney").html(getthis*(data.percent)/100+"<span>元("+data.percent+"%)</span>");
                 }
            	
				 
				 
		       },"JSON")
         }
        function Canvas1() {
            var randomScalingFactor = function () { return Math.round(Math.random() * 100) };
            var doughnutData = [
                {
                    value: randomScalingFactor(),
                    color: "#F7464A",
                    highlight: "#FF5A5E",
                    label: "事假"
                },
                {
                    value: randomScalingFactor(),
                    color: "#46BFBD",
                    highlight: "#5AD3D1",
                    label: "病假"
                },
                {
                    value: randomScalingFactor(),
                    color: "#FDB45C",
                    highlight: "#FFC870",
                    label: "公休假"
                },
                {
                    value: randomScalingFactor(),
                    color: "#949FB1",
                    highlight: "#A8B3C5",
                    label: "调休假"
                }
            ];
            var ctx = document.getElementById("Canvas1").getContext("2d");
            window.myDoughnut = new Chart(ctx).Doughnut(doughnutData, { responsive: false });
        }
        function Canvas2() {
            var randomScalingFactor = function () { return Math.round(Math.random() * 100) };
            var lineChartData = {
                labels: ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
                datasets: [
                    {
                        fillColor: "rgba(220,220,220,0.2)",
                        strokeColor: "rgba(220,220,220,1)",
                        pointColor: "rgba(220,220,220,1)",
                        pointStrokeColor: "#fff",
                        pointHighlightFill: "#fff",
                        pointHighlightStroke: "rgba(220,220,220,1)",
                        data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
                    }
                ]
            }
            var ctx = document.getElementById("Canvas2").getContext("2d");
            window.myLine = new Chart(ctx).Line(lineChartData, {
                bezierCurve: false,
            });
        }
        function Canvas3() {
            var randomScalingFactor = function () { return Math.round(Math.random() * 100) };
            var lineChartData = {
                labels: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "8月", "10月", "11月", "12月"],
                datasets: [
                    {
                        fillColor: "#578ebe",
                        data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
                    }
                ]
            }
            var ctx = document.getElementById("Canvas3").getContext("2d");
            window.myLine = new Chart(ctx).Bar(lineChartData, {
                bezierCurve: false,
             
            });
        }
    </script>
</head>
<body>
<div class="layui-form-item" style="margin-top: 1%;">
				<div class="layui-inline " style="width:353px;">

					<label class="layui-form-label">日期</label>
					<div class="layui-input-block">
						<input type="text" name="date" id="date1" 
							autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline" onclick="getDate()">
					<button class="layui-btn"  id="querydata">搜索</button>
				</div>
			</div>
	<div id="areascontent">
		<div class="rows" style="margin-bottom: 0.8%; overflow: hidden;">
			<div style="float: left; width: 69.2%;">
				<div
					style="height: 100%; border: 1px solid #e6e6e6; overflow: hidden;">
					
					
					
					
			
			
			<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #4f5c65; margin-bottom: 0px;">
							<h2 class="m-top-none" id="allcount"><span>位</span></h2>
							<h5>总预约数</h5>
							<div class="stat-icon">
								<i class="fa fa-file-text-o"></i>
							</div>

						</div>
					</div>



					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #14aae4; margin-bottom: 0px;">
							<h2 class="m-top-none" id="docount">
								<span>位</span>
							</h2>
							<h5>总完成预约数</h5>
							<div class="stat-icon">
								<i class="fa fa-coffee"></i>
							</div>

						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #949FB1; margin-bottom: 0px;">
							<h2 class="m-top-none" id="allmoney">
								355<span>件</span>
							</h2>
							<h5>总收款</h5>
							<div class="stat-icon">
								<i class="fa fa-shopping-cart"></i>
							</div>
							
						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #f29503; margin-right: 0px; margin-bottom: 0px;">
							<h2 class="m-top-none" id="gethandmoney">
								3335<span>元</span>
							</h2>
							<h5>总业绩提成</h5>
							<div class="stat-icon">
								<i class="fa fa-rmb" style="padding-left: 10px;"></i>
							</div>
						</div>
					</div>
					
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #578ebe;">
							<div class="stat-icon">
								<i class="fa fa-clock-o"></i>
							</div>
							<h2 class="m-top-none">
								${appAllNum}<span>位</span>
							</h2>
							<h5>今日总预约</h5>
						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #e35b5a;">
							<h2 class="m-top-none">
								${appDoNum}<span>位</span>
							</h2>
							<h5>今日完成预约</h5>
							<div class="stat-icon">
								<i class="fa fa-gavel"></i>
							</div>


						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #44b6ae;">

							<h2 class="m-top-none">
								${backAllNum}<span>位</span>
							</h2>

							<h5>今日总回访</h5>
							<div class="stat-icon">
								<i class="fa fa-bell"></i>
							</div>



						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #8775a7; margin-right: 0px;">

							<h2 class="m-top-none">
								${backDoNum}<span>位</span>
							</h2>

							<h5>今日已回访数</h5>
							<div class="stat-icon">
								<i class="fa fa-envelope-o"></i>
							</div>

						</div>
					</div>
			
			
			
			
			

				</div>
			</div>
			<div style="float: right; width: 30%;">
				<div
					style="height: 221px; border: 1px solid #e6e6e6; background-color: #fff;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-area-chart fa-lg" style="padding-right: 5px;"></i>成交订单
						</div>
						<div class="panel-body">
							<canvas id="Canvas2" style="height: 165px; width: 100%;"></canvas>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- //= -->
			
 

		<div class="rows" style="margin-bottom: 0.8%; overflow: hidden;">
			<div style="float: left; width: 69.2%;">
				<div
					style="height: 290px; border: 1px solid #e6e6e6; background-color: #fff;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-bar-chart fa-lg" style="padding-right: 5px;"></i>本年总业绩
						</div>
						<div class="panel-body">
							<canvas id="Canvas3" style="height: 230px; width: 100%;"></canvas>
						</div>
					</div>
				</div>
			</div>
			<div style="float: right; width: 30%;">
				<div
					style="height: 290px; border: 1px solid #e6e6e6; background-color: #fff;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-pie-chart fa-lg" style="padding-right: 5px;"></i>请假统计
						</div>
						<div class="panel-body">
							<canvas id="Canvas1"
								style="height: 180px; width: 100%; margin-top: 10px;"></canvas>
							<div style="text-align: center; padding-top: 15px;">
								<span><i class="fa fa-square"
									style="color: #F7464A; font-size: 20px; padding-right: 5px; vertical-align: middle; margin-top: -3px;"></i>事假</span>
								<span style="margin-left: 10px;"><i class="fa fa-square"
									style="color: #46BFBD; font-size: 20px; padding-right: 5px; vertical-align: middle; margin-top: -3px;"></i>病假</span>
								<span style="margin-left: 10px;"><i class="fa fa-square"
									style="color: #FDB45C; font-size: 20px; padding-right: 5px; vertical-align: middle; margin-top: -3px;"></i>公休假</span>
								<span style="margin-left: 10px;"><i class="fa fa-square"
									style="color: #949FB1; font-size: 20px; padding-right: 5px; vertical-align: middle; margin-top: -3px;"></i>调休假</span>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>


	</div>
	<style>
#copyrightcontent {
	height: 30px;
	line-height: 29px;
	overflow: hidden;
	position: absolute;
	top: 100%;
	margin-top: -30px;
	width: 100%;
	background-color: #fff;
	border: 1px solid #e6e6e6;
	padding-left: 10px;
	padding-right: 10px;
}

.dashboard-stats {
	float: left;
	width: 25%;
}

.dashboard-stats-item {
	position: relative;
	overflow: hidden;
	color: #fff;
	cursor: pointer;
	height: 105px;
	margin-right: 10px;
	margin-bottom: 10px;
	padding-left: 15px;
	padding-top: 20px;
}

.dashboard-stats-item .m-top-none {
	margin-top: 5px;
}

.dashboard-stats-item h2 {
	font-size: 28px;
	font-family: inherit;
	line-height: 1.1;
	font-weight: 500;
	padding-left: 70px;
}

.dashboard-stats-item h2 span {
	font-size: 12px;
	padding-left: 5px;
}

.dashboard-stats-item h5 {
	font-size: 12px;
	font-family: inherit;
	margin-top: 1px;
	line-height: 1.1;
	padding-left: 70px;
}

.dashboard-stats-item .stat-icon {
	position: absolute;
	top: 18px;
	font-size: 50px;
	opacity: .3;
}

.dashboard-stats i.fa.stats-icon {
	width: 50px;
	padding: 20px;
	font-size: 50px;
	text-align: center;
	color: #fff;
	height: 50px;
	border-radius: 10px;
}

.panel-default {
	border: none;
	border-radius: 0px;
	margin-bottom: 0px;
	box-shadow: none;
	-webkit-box-shadow: none;
}

.panel-default>.panel-heading {
	color: #777;
	background-color: #fff;
	border-color: #e6e6e6;
	padding: 10px 10px;
}

.panel-default>.panel-body {
	padding: 10px;
	padding-bottom: 0px;
}

.panel-default>.panel-body ul {
	overflow: hidden;
	padding: 0;
	margin: 0px;
	margin-top: -5px;
}

.panel-default>.panel-body ul li {
	line-height: 27px;
	list-style-type: none;
	white-space: nowrap;
	text-overflow: ellipsis;
}

.panel-default>.panel-body ul li .time {
	color: #a1a1a1;
	float: right;
	padding-right: 5px;
}
</style>
</body>
</html>
