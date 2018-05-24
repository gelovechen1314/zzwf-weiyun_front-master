<template>
	<div class="conentCon">
		<div class="top">
			<div class="heaLeft">
				<div class="header titleHea">
					<span>交易基础数据分析</span>
					<p>
						<el-date-picker  class="dateCon" v-model="value5" type="year" placeholder="选择年"></el-date-picker>	
					</p>
				</div>
				<div class="circleCon">
					<div class="circleChart"></div>
					<div class="monthCon"></div>
					<div class="yearCon"></div>
				</div>
			</div>
			<div class="kongCen"></div>
			<div class="heaRight">
				

			</div>
		</div>
		<div class="kong"></div>
		<div class="barChartCon">
			<div class="header titleHea">
				<span>每月交易概况</span>
			</div>
			<div class="barChart" id="barChart" :style="{width:'100%', height: '300px'}"></div>
		</div>
	</div>
</template>

<script>
	import "../../assets/css/com.css"
	export default{
		data(){
			return{
				
			}
		},
		mounted(){
			this.barChart()
		},
		methods:{
			
			barChart() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('barChart'))
				// 绘制图表
				chart.setOption({

					title: {
						text: '',
						subtext: ''
					},
					tooltip: {
						trigger: 'axis'
					},
					legend: {
						data: ['历史预测电量', '实际用电', '预测电量']
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
					calculable: true,
					xAxis: [{
						type: 'category',
						data: ['2014', '2015', '2016', '2017', '2018', '2019', '2020', '2021']
					}],
					yAxis: [{
						type: 'value'
					}],
					series: [{
							name: '蒸发量',
							type: 'bar',
							color: '#00c5dc',
							data: [500, 480, 700, 800, 900, 850, 900, 1200],

						},
						{
							name: '蒸发量',
							color: '#5867c3',
							type: 'bar',
							data: [500, 480, 850, 800, 1100, 850, 900, 1200],

						},
						{
							name: '降水量',
							type: 'bar',
							olor: "#ff4d5a",
							data: [500, 480, 700, 800, 900, 1000, 900, 1200],

						}
					]
				});
			},
		}
	}
	
</script>

<style scoped="scoped">
	.conentCon {
		margin: 10px;
		background: #fff;
		height: 100%;
		overflow-y: scroll;
	}
	.top{
		width:100%;
		height:375px;
		border:.5px solid #e9eaec;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	.top:after{
		content:"";
		height:0;
		line-height: 0;
		display:block;
		clear:both;
		visibility: hidden;
	}
	.kong{
		width:100%;
		height:10px;
		background:#f0f0f0;
	}
	.heaLeft{
		width:74%;
		float:left;
	}
	.kongCen{
		width:20px;
		float:left;
		height:100%;
		background:#f0f0f0;
	}
	.heaRight{
		width:23%;
		float:right;
	}
	.headerCon{
		width:100%;
		height:57px;
		border-bottom:1px solid #e9eaec;
	}
	.circleCon{
		width:100%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	.circleCon:after{
		content:"";
		height:0;
		line-height: 0;
		display:block;
		clear:both;
		visibility: hidden;
	}
	.circleChart{
		width:35%;
		float:left;
	}
	.monthCon{
		width:30%;
		float:left;
		margin-left:2.5%;
	}
	.yearCon{
		width:30%;
		float:right;
		margin-left:2.5%;
	}
</style>