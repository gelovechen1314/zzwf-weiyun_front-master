<template>
	<div class="conentCon">
		<div class="top">
			<div class="heaLeft">
				<div class="header titleHea">
					<span>交易基础数据分析</span>
					<p>
						<el-date-picker class="dateCon" v-model="value5" type="year" placeholder="选择年"></el-date-picker>
					</p>
				</div>
				<div class="circleCon">
					<div class="circleChart" id="circleChart" :style="{width:'440px', height: '315px'}">
					</div>
					<div class="monthCon">
						<div class="monthData">
							<div class="dataHeader">
								<h6>月度</h6>
							</div>
							<div class="dataCon">
								<p class="undeLine"><span>长协</span><strong>6.00</strong><b>100.0%</b></p>
								<p><span>竞价</span><strong>0.00</strong><b>00.0%</b></p>
							</div>
						</div>
					</div>
					<div class="yearCon">
						<div class="monthData">
							<div class="dataHeader">
								<h6>月度</h6>
							</div>
							<div class="dataCon">
								<p class="undeLine"><span>长协</span><strong>6.00</strong><b>100.0%</b></p>
								<p><span>竞价</span><strong>0.00</strong><b>00.0%</b></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="heaRight">
				<div class="header titleHea">
					<span>月度交易占比</span>
				</div>
				<div class="setletCon"></div>
				<div class="pieChart" id="pieChart" :style="{'width':'100%','height':'200px'}">

				</div>
			</div>
		</div>
		<div class="kong"></div>
		<div class="barChartCon">
			<div class="header titleHea">
				<span>每月交易概况</span>
			</div>
			<div class="barChart" id="barChart" :style="{width:'100%', height: '300px'}"></div>
		</div>
		<div class="barChartCon">
			<div class="header titleHea">
				<span>发电集团剩余电量</span>
			</div>
			<div class="mianTableCon">
				<div class="leftTableCon">
					<table class="table">
						<thead>
							<tr>
								<th>公司名称</th>
								<th>发电方式</th>
								<th>机组容量</th>
								<th>总电量</th>
								<th>剩余电量</th>
								<th>已售电量</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>-</td>
								<td>-</td>
								<td>-MW</td>
								<td>-MWh</td>
								<td>
									<el-progress :text-inside="true" :stroke-width="18" :percentage="100" status="success"></el-progress>
								</td>
								<td>-MWh</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="rightTableCon">
					<table class="table">
						<thead>
							<tr>
								<th>公司名称</th>
								<th>发电方式</th>
								<th>机组容量</th>
								<th>总电量</th>
								<th>剩余电量</th>
								<th>已售电量</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>-</td>
								<td>-</td>
								<td>-MW</td>
								<td>-MWh</td>
								<td>
									<el-progress :text-inside="true" :stroke-width="18" :percentage="100" status="success"></el-progress>
								</td>
								<td>-MWh</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!--分页-->
			<div class="paginationPage">
				<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :background='true' :current-page="currentPage4" :page-sizes="[100, 200, 300, 400]" :page-size="100" layout="total, sizes, prev, pager, next, jumper" :total="400">
				</el-pagination>
			</div>
		</div>
	</div>
</template>

<script>
	import "../../assets/css/com.css"
	export default {
		data() {
			return {
				currentPage4: 4,

			}
		},
		mounted() {
			this.barChart();
			this.circleChart();
			this.pieChart()
		},
		methods: {
			handleSizeChange(val) {
				console.log('每页 ${val} 条');
			},
			handleCurrentChange(val) {
				console.log('当前页: ${val}');
			},
			pieChart() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('pieChart'))
				// 绘制图表
				chart.setOption({
					tooltip: {
						trigger: 'item',
						formatter: "{a} <br/>{b}: {c} ({d}%)"
					},
					/*grid: {
						left: '50%',
						right: '4%',
						bottom: '3%',
						containLabel: true,
						x: 130
					},*/
					legend: {
						orient: 'vertical',
						x: '20px',
						y: 'center',
						width: '50%',
						data: ['直接访问', '邮件营销', '联盟广告', '视频广告']
					},
					series: [{
						name: '访问来源',
						type: 'pie',
						radius: ['30%', '50%'],
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
								value: 335,
								name: '直接访问'
							},
							{
								value: 310,
								name: '邮件营销'
							},
							{
								value: 234,
								name: '联盟广告'
							},
							{
								value: 135,
								name: '视频广告'
							},

						]
					}]
				});
			},
			circleChart() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('circleChart'))
				// 绘制图表
				chart.setOption({
					tooltip: {
						trigger: 'item',
						formatter: "{a} <br/>{b}: {c} ({d}%)"
					},
					/*grid: {
						left: '50%',
						right: '4%',
						bottom: '3%',
						containLabel: true,
						x: 130
					},*/
					legend: {
						orient: 'vertical',
						x: '20px',
						y: 'center',
						width: '50%',
						data: ['直接访问', '邮件营销', '联盟广告', '视频广告']
					},
					series: [{
						name: '访问来源',
						type: 'pie',
						radius: ['30%', '50%'],
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
								value: 335,
								name: '直接访问'
							},
							{
								value: 310,
								name: '邮件营销'
							},
							{
								value: 234,
								name: '联盟广告'
							},
							{
								value: 135,
								name: '视频广告'
							},

						]
					}]
				});
			},
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
		height: 100%;
		overflow-y: scroll;
	}
	
	.top {
		width: 100%;
		height: 375px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.top:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		clear: both;
		visibility: hidden;
	}
	
	.heaLeft {
		background: #fff;
		width: 75%;
		margin: 10px;
		float: left;
		border-radius: 5px;
		border: .5px solid #e9eaec;
	}
	
	.heaLeft:hover {
		box-shadow: 0px 0px 5px 1px #ccc;
	}
	
	.heaRight {
		width: 23%;
		float: right;
		background: #fff;
		margin: 10px;
		border-radius: 5px;
		border: .5px solid #e9eaec;
	}
	
	.pieChart {
		/*margin-right:-200px;*/
	}
	
	.heaRight:hover {
		box-shadow: 0px 0px 5px 1px #ccc;
	}
	
	.headerCon {
		width: 100%;
		height: 57px;
		border-bottom: 1px solid #e9eaec;
	}
	
	.circleCon {
		width: 100%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.circleCon:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		clear: both;
		visibility: hidden;
	}
	
	.circleChart {
		margin-right: -80px;
		width: 35%;
		padding: 10px 0px;
		float: left;
		/*width:435px;*/
		/*text-align:right;*/
	}
	
	.circleChart div {
		min-width: 200px;
		text-align: right;
	}
	
	.monthCon {
		width: 30%;
		float: left;
		margin-left: 0;
	}
	
	.monthData {
		width: 100%;
		margin: 45px 0px 60px 0px;
		border: 1px solid #e9eaec;
		background: #f6f7fb;
		height: 210px;
		border-radius: 5px;
	}
	
	.monthData:hover {
		box-shadow: 0px 0px 5px 1px #ccc;
	}
	
	.dataHeader {
		height: 52px;
		padding-left: 22px;
		border-bottom: 1px solid #e9eaec;
	}
	
	.dataHeader h6 {
		line-height: 52px;
		font-size: 16px;
		font-family: "微软雅黑";
		color: #495060;
		font-weight: 900;
	}
	
	.dataCon {
		padding: 43px 22px;
	}
	
	.dataCon p {
		font-size: 14px;
		font-family: "微软雅黑";
		color: #666;
		width: 100%;
		padding-bottom: 5px;
		margin-bottom: 0px;
		position: relative;
	}
	
	.dataCon p b {
		float: right;
		font-weight: normal;
	}
	
	.dataCon p strong {
		position: absolute;
		left: 40px;
		top: 4px;
		font-size: 20px;
		color: #c6d0d4;
	}
	
	.undeLine {
		border-bottom: 1px solid #ccc;
	}
	
	.dataCon .undeLine strong {
		position: absolute;
		left: 40px;
		top: -8px;
		font-size: 20px;
		color: #c6d0d4;
	}
	
	.yearCon {
		width: 30%;
		float: right;
		margin-left: 2.5%;
		margin-right: 2.5%;
	}
	
	.barChartCon {
		background: #fff;
		margin: 0 10px 10px;
		border-radius: 5px;
		border: .5px solid #e9eaec;
	}
	
	.barChartCon:hover {
		box-shadow: 0 0 5px 1px #ccc;
	}
	
	.mianTableCon {
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
		padding: 20px;
	}
	
	.mianTableCon:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		clear: both;
		visibility: hidden;
	}
	
	.leftTableCon {
		float: left;
		width: 50%;
		margin-right: 20px;
	}
	
	.rightTableCon {
		float: right;
		width: 50%;
	}
	
	.table {
		width: 100%;
		border: 1px solid #e9eaec;
	}
	
	.table thead {
		background: #f8f8f9;
		border: none;
	}
	
	.table thead th {
		width: 15%;
		padding: 0px;
		border-bottom: none;
		border-top: none;
		line-height: 36px;
		font-size: 12px;
		font-family: "微软雅黑";
		color: #495060;
	}
	.paginationPage{
		margin:10px auto 30px;
		width:100%;
		text-align: center;
	}
	.el-pager .number{
		border:1px solid #dddee1;
		border-radius:5px;
		color:#ddd2cd
	}
</style>