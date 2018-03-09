<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分销商级别分布图</title>
<link rel="stylesheet" href="../../css/drp.css">
<script src="../../js/echarts.min.js"></script>
<script src="../../js/jquery.min.js"></script>
</head>

<body class="body1">
	<form name="clientLevelChartForm" target="_self"
		id="clientLevelChartForm">
		<div align="center">
			<table width="95%" border="0" cellspacing="0" cellpadding="0"
				height="35">
				<tr>
					<td class="p1" height="18" nowrap>&nbsp;</td>
				</tr>
				<tr>
					<td width="522" class="p1" height="17" nowrap><img
						src="../../images/mark_arrow_02.gif" width="14" height="14">
						&nbsp; <b>统计/报表管理&gt;&gt;分销商级别分布图</b></td>
				</tr>
			</table>
			<hr width="100%" align="center" size=0>
			<table width="95%" height="40" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="14%" height="40">
						<div align="right">分销大区:&nbsp;</div>
					</td>
					<td width="13%"><select name="region" class="select1"
						id="region">
							<option value="0">--全部--</option>
							<option value="1">华北区</option>
							<option value="2">东北区</option>
							<option value="3">华南区</option>
					</select></td>
					<td width="13%">
						<div align="right">分销省:&nbsp;</div>
					</td>
					<td width="16%"><select name="province" class="select1"
						id="province">
							<option value="0">--全部--</option>
					</select></td>
					<td width="16%"><input name="radiobutton" type="radio"
						value="radiobutton" checked> 饼图 <input name="radiobutton"
						type="radio" value="radiobutton"> 柱状图</td>
					<td width="28%"><input name="btnQuery" type="button"
						class="button1" id="btnQuery" value="查询"></td>
				</tr>
			</table>
			<hr width="100%" align="center" size=0>
			<div align="center"></div>
		</div>
		<table width="95%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div id="main" style="width: 600px; height: 400px; margin: 0 auto"></div>
				</td>
			</tr>
		</table>
		<p>&nbsp;</p>
	</form>
	<script type="text/javascript">
		$(function() {
			drawPie();
			function drawPie() {
				var myChart = echarts.init(document.getElementById('main'));
				var option = {
					title : {
						text : '某站点用户访问来源',
						subtext : '纯属虚构',
						x : 'center'
					},
					tooltip : {
						trigger : 'item',
						formatter : "{a} <br/>{b} : {c} ({d}%)"
					},
					legend : {
						orient : 'vertical',
						left : 'left',
						data : []
					},
					series : [ {
						name : '访问来源',
						type : 'pie',
						radius : '55%',
						center : [ '50%', '60%' ],
						data : [],
						itemStyle : {
							emphasis : {
								shadowBlur : 10,
								shadowOffsetX : 0,
								shadowColor : 'rgba(0, 0, 0, 0.5)'
							}
						}
					} ]
				};
				myChart.showLoading({
					text : "图表数据正在努力加载..."
				});
				var path = "${pageContext.request.contextPath}/getPie.action";
				$.ajax({
					type : 'GET',
					url : path,
					dataType : 'json',
					success : function(data) {
						var legendData = [];
						var seriesData = [];
						if (data != null && data.length > 0) {
							for (var i = 0; i < data.length; i++) {
								legendData = data[i].num;
								seriesData.push({
									'value' : data[i].num,
									'name' : data[i].name,
								});
							}
						}
						;
						option.legend.data = legendData;
						option.series[0]['data'] = seriesData;
						myChart.setOption(option);
					},

					error : function() {
						//数据接口异常处理  
						var legendData = [ '' ];
						var seriesData = [ {
							name : '',
							type : 'bar',
							data : [ 0 ]
						} ];
						option.legend.data = legendData;
						option.series.data = seriesData;
						myChart.setOption(option);
					},

					complete : function() {
						//不管数据接口成功或异常，都终于载入提示        
						myChart.hideLoading();//停止动画载入提示   
					}
				});
			}
			function drawbar() {
				var myChart = echarts.init(document.getElementById('main'));

				option = {
					title : {
						text : '分销商',
						subtext : 'Feature Sample: Gradient Color, Shadow, Click Zoom'
					},
					xAxis : {
						data : [],
						axisLabel : {
							inside : false,
							textStyle : {
								color : '#000'
							}
						},
						axisTick : {
							show : false
						},
						axisLine : {
							show : false
						},
						z : 10
					},
					yAxis : {
						axisLine : {
							show : false
						},
						axisTick : {
							show : false
						},
						axisLabel : {
							textStyle : {
								color : '#999'
							}
						}
					},
					dataZoom : [ {
						type : 'inside'
					} ],
					series : [
							{ // For shadow
								type : 'bar',
								itemStyle : {
									normal : {
										color : 'rgba(0,0,0,0.05)'
									}
								},
								barGap : '-100%',
								barCategoryGap : '40%',
								data : [],
								animation : false
							},
							{
								type : 'bar',
								itemStyle : {
									normal : {
										color : new echarts.graphic.LinearGradient(
												0, 0, 0, 1, [ {
													offset : 0,
													color : '#83bff6'
												}, {
													offset : 0.5,
													color : '#188df0'
												}, {
													offset : 1,
													color : '#188df0'
												} ])
									},
									emphasis : {
										color : new echarts.graphic.LinearGradient(
												0, 0, 0, 1, [ {
													offset : 0,
													color : '#2378f7'
												}, {
													offset : 0.7,
													color : '#2378f7'
												}, {
													offset : 1,
													color : '#83bff6'
												} ])
									}
								},
								data : []
							} ]
				};

				myChart.showLoading({
					text : "图表数据正在努力加载..."
				});

				var path = "${pageContext.request.contextPath}/getPie.action";
				$.ajax({
					type : 'GET',
					url : path,
					dataType : 'json',
					success : function(data) {
						var xAxisData = [];
						var seriesData = [];
						if (data != null && data.length > 0) {
							for (var i = 0; i < data.length; i++) {
								xAxisData.push(data[i].name);
								seriesData.push(data[i].num);
							}
						}
						option.xAxis.data = xAxisData;
						option.series[0].data = seriesData;
						myChart.setOption(option);
					},

					error : function() {
						//数据接口异常处理  

					},

					complete : function() {
						//不管数据接口成功或异常，都终于载入提示        
						myChart.hideLoading();//停止动画载入提示   
					}
				});
			}

		})
	</script>


</body>

</html>