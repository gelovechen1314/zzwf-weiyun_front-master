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
			<div class="equipLine" id="equipLine"></div>
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
			console.log( document.body.clientHeight)
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
			equipLine(){
				
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