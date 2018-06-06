<template>
	<div class="contentCon">
		<div class="equipInstallCon">
			<div class="header titleHea">
				<span>设备安装概况</span>
				<!--<p><a href="/"><em class="iconfont">&#xe778;</em>首页：</a><b>客户></b><b>客户总览</b></p>-->
			</div>
			<div class="installDetail">
				<div class="circleChartDetail" id="circleChartDetail">

				</div>
				<div class="num">
					<p>4</p>
					<p>0</p>
					<p>0</p>
				</div>
				<div class="msgDetail">
					<p>三相三线</p>
					<div class="barLine"></div>
					<p>三相四线</p>
					<div class="barLine"></div>
				</div>
				<div class="dataDetail">
					<p>三相三线:<span>3</span></p>
					<p>三相三线:<span>3</span></p>
				</div>
			</div>
		</div>
		<div class="equipRunDetail">
			<div class="header titleHea">
				<span>设备运行状况</span>
			</div>
			<div class="equipLine" style="height:400px;" id="equipLine"></div>
		</div>
	</div>
</template>

<script>
	import "../../assets/css/com.css"
	export default {
		data() {
			return {

			}
		},
		mounted() {
			this.circleChartDetail()
			this.equipLine()
			console.log(document.body.clientHeight)
		},
		methods: {
			circleChartDetail() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('circleChartDetail'))
				// 绘制图表
				chart.setOption({
					tooltip: {
						trigger: 'item',
						formatter: "{a} <br/>{b}: {c} ({d}%)"
					},
					legend: {
						type: 'scroll',
						orient: 'vertical',
						right: 10,
						top: '30%',
						bottom: 20,
						width: '50%',
						data: ['已经安装', '等待安装', '设备库存'],

					},
					series: [{
						name: '访问来源',
						type: 'pie',
						radius: ['70%', '0%'],
						avoidLabelOverlap: false,
						label: {
							normal: {
								show: false,
								position: 'center'
							},
							emphasis: {
								funnel: {
									x: '35%',
									width: '50%',
									funnelAlign: 'right',
									max: 400
								},
								show: true,
								textStyle: {
									fontSize: '20',
									fontWeight: 'bold'
								}
							}
						},
						labelLine: {
							normal: {
								show: false
							}
						},
						data: [{
								value: 4,
								name: '已经安装',

							},
							{
								value: 0,
								name: '等待安装'
							},
							{
								value: 0,
								name: '设备库存'
							}
						]
					}]
				});
			},
			equipLine() {
				let chart = this.echarts.init(document.getElementById('equipLine'))
				// 绘制图表
				let data = [
					["2000-06-05", 116],
					["2000-06-06", 129],
					["2000-06-07", 135],
					["2000-06-08", 86],
					["2000-06-09", 73],
					["2000-06-10", 85],
					["2000-06-11", 73],
					["2000-06-12", 68],
					["2000-06-13", 92],
					["2000-06-14", 130],
					["2000-06-15", 245],
					["2000-06-16", 139],
					["2000-06-17", 115],
					["2000-06-18", 111],
					["2000-06-19", 309],
					["2000-06-20", 206],
					["2000-06-21", 137],
					["2000-06-22", 128],
					["2000-06-23", 85],
					["2000-06-24", 94],
					["2000-06-25", 71],
					["2000-06-26", 106],
					["2000-06-27", 84],
					["2000-06-28", 93],
					["2000-06-29", 85],
					["2000-06-30", 73],
					["2000-07-01", 83],
					["2000-07-02", 125],
					["2000-07-03", 107],
					["2000-07-04", 82],
					["2000-07-05", 44],
					["2000-07-06", 72],
					["2000-07-07", 106],
					["2000-07-08", 107],
					["2000-07-09", 66],
					["2000-07-10", 91],
					["2000-07-11", 92],
					["2000-07-12", 113],
					["2000-07-13", 107],
					["2000-07-14", 131],
					["2000-07-15", 111],
					["2000-07-16", 64],
					["2000-07-17", 69],
					["2000-07-18", 88],
					["2000-07-19", 77],
					["2000-07-20", 83],
					["2000-07-21", 111],
					["2000-07-22", 57],
					["2000-07-23", 55],
					["2000-07-24", 60]
				];

				var dateList = data.map(function(item) {
					return item[0];
				});
				var valueList = data.map(function(item) {
					return item[1];
				});

				let option = {

					// Make gradient line here
					visualMap: [/*{
						show: false,
						type: 'continuous',
						seriesIndex: 0,
						min: 0,
						max: 400
					},*/ {
						show: false,
						type: 'continuous',
						seriesIndex: 1,
						dimension: 0,
						min: 0,
						max: dateList.length - 1
					}],

					title: [{
						left: 'center',
						text: '在线率'
					}],
					tooltip: {
						trigger: 'axis'
					},
					xAxis: [{
						/*data: [] ,*/
					}, {
						data: dateList,
						gridIndex: 1
					}],
					yAxis: [{
						/*splitLine: {
							show: ''
						}*/
					}, {
						splitLine: {
							show: false
						},
						gridIndex: 1
					}],
					grid: [{
						/*bottom: '60%'*/
					}, {
						top: '60%'
					}],
					series: [{
						type: 'line',
						showSymbol: false,
						data: valueList,
						xAxisIndex: 1,
						yAxisIndex: 1
					}]
				};
				chart.setOption(option);
				

			}
		},
	}
</script>

<style scoped="scoped">
	.contentCon {
		height: 98%;
		overflow-y: auto;
		margin: 10px;
	}
	
	.equipInstallCon {
		background: #fff;
		border: .5px solid #e9eaec;
		border-radius: 5px;
		margin: 2px;
		margin-bottom: 10px;
	}
	
	.equipInstallCon:hover,
	.equipRunDetail:hover {
		box-shadow: 0px 0px 5px 1px #ccc;
	}
	
	.installDetail {
		width: 100%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.installDetail:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.circleChartDetail {
		width: 42%;
		float: left;
		height: 220px;
	}
	
	.num {
		padding: 0px 10px;
		margin-top: 70px;
		float: left;
	}
	
	.num p {
		margin: 0px;
		line-height: 23px;
	}
	
	.msgDetail {
		width: 33%;
		height: 100%;
		margin-top: 40px;
		float: left;
	}
	
	.msgDetail p {
		width: 70%;
		margin: 0px auto;
		text-align: left;
		font-size: 14px;
	}
	
	.barLine:nth-of-type(1) {
		background: #57a3f3;
	}
	
	.barLine {
		width: 70%;
		margin: 0px auto;
		height: 20px;
		margin-bottom: 10px;
		background: #eee;
	}
	
	.dataDetail {
		width: 25%;
		float: right;
		margin-top: 40px;
	}
	
	.dataDetail p {
		width: 100%;
		margin: 20px auto;
		font-size: 14px;
		text-align: center;
	}
	
	.dataDetail p span {
		font-size: 20px;
		color: #495060;
		margin-left: 5px;
		font-family: "微软雅黑";
	}
	
	.equipRunDetail {
		background: #fff;
		border: .5px solid #e9eaec;
		border-radius: 5px;
		margin: 2px;
	}
</style>