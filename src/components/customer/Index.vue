<template>
	<div>
		<div class="header titleHea">
			<span>客户总览</span>
			<p>
				<a href="/"><em class="iconfont">&#xe778;</em>首页</a>：<b>客户></b><b>客户总览</b></p>
		</div>
		<div class="wrapper-md wrapperCon">
			<div class="wrapperTop">
				<headerLong class="txtCon">
					<p slot="headerBar">30天客户增长情况</p>
				</headerLong>
				<div class="timeBox">
					开始时间:<input type="text" placeholder="2018-01-30" />结束时间：<input type="text" placeholder="2018-01-30" />
				</div>
				<div class="chartLineBox" id="chartLineBox" :style="{width:'100%',height:'280px'}">

				</div>
			</div>
			<div class="wrapperBtm">
				<div class="leftCon">
					<headerLong class="txtCon">
						<p slot="headerBar">居间统计</p>
					</headerLong>
					<div class="companyChartMsg" id="companyChartMsg" :style="{width:'100%',height:'200px'}"></div>
				</div>
				<div class="rightCon">
					<headerLong class="txtCon">
						<p slot="headerBar">待連系客戶</p>
					</headerLong>
					<div class="tableCon">
						<table>
							<tr>
								<td>联系日期</td>
								<td>企业</td>
								<td>联系人</td>
								<td>联系电话</td>
								<td>进展情况</td>
							</tr>
							<tr>
								<td>2018-5-10</td>
								<td>郑州耀光电子科技有限公司</td>
								<td>胡建辉</td>
								<td>23545754721</td>
								<td>待联系</td>
							</tr>
							<tr>
								<td>2018-5-10</td>
								<td>郑州耀光电子科技有限公司</td>
								<td>胡建辉</td>
								<td>23545754721</td>
								<td>待联系</td>
							</tr>
							<tr>
								<td>2018-5-10</td>
								<td>郑州耀光电子科技有限公司</td>
								<td>胡建辉</td>
								<td>23545754721</td>
								<td>待联系</td>
							</tr>
							<tr>
								<td>2018-5-10</td>
								<td>郑州耀光电子科技有限公司</td>
								<td>胡建辉</td>
								<td>23545754721</td>
								<td>待联系</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>
<script>
	import headerLong from "../common/headerLong.vue";
	export default {
		data() {
			return {
				
			}
		},
		components: {
			headerLong
		},
		mounted() {
			this.chartLineBox();
			this.companyChartMsg()
		},
		computed: {

		},

		methods: {
			chartLineBox() {
				let chart = this.echarts.init(document.getElementById('chartLineBox'))
				// 绘制图表
				chart.setOption({
					title: {
						text: ''
					},
					tooltip: {
						trigger: 'axis'
					},
					legend: {
						data: ['直接访问', '搜索引擎']
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					toolbox: {
						feature: {
							saveAsImage: {}
						}
					},
					xAxis: {
						type: 'category',
						boundaryGap: false,
						data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
					},
					yAxis: {
						type: 'value'
					},
					series: [{
							name: '直接访问',
							type: 'line',
							stack: '总量',
							itemStyle: {
								normal: {
									lineStyle: {
										color: '#000066'
									}
								}
							},
							data: [1300, 1300, 1300, 1300, 1300, 1300, 1300]
						},
						{
							name: '搜索引擎',
							type: 'line',
							stack: '总量',
							itemStyle: {
								normal: {
									lineStyle: {
										color: '#c6413d'
									}
								}
							},
							data: [820, 932, 901, 934, 1290, 1330, 1320]
						}
					]
				});

			},
			companyChartMsg() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('companyChartMsg'))
				// 绘制图表
				chart.setOption({
					title: {
						text: '',
						subtext: ''
					},
					tooltip: {
						trigger: 'axis',
						axisPointer: {
							type: 'shadow'
						}
					},
					legend: {
						data: []
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					xAxis: {
						type: 'value',
						boundaryGap: [0, 0.01]
					},
					yAxis: {
						type: 'category',
						data: ['巴西', '印尼', '美国', '印度', '中国', '世界人口(万)']
					},
					series: [{
							name: '2011年',
							type: 'bar',
							data: [18203, 23489, 29034, 104970, 131744, 630230]
						}

					]
				})

			},

		}
	}
</script>
<style scoped>
	.titleHea {
		padding: 0px;
		height: 58px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
	}
	
	.titleHea:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.titleHea span {
		display: inline-block;
		padding: 0px 20px;
		line-height: 58px;
		border-bottom: 2px solid #0099ff;
	}
	
	.titleHea p {
		display: block;
		float: right;
		text-align: right;
		width: 80%;
		line-height: 58px;
		font-size: 14px;
	}
	
	.titleHea p b {
		font-weight: normal;
	}
	
	.wrapperCon {
		margin: 10px 20px;
	}
	
	.wrapperTop {
		height: 60%;
		padding: 5px 10px;
		background: #fff;
		margin-bottom: 20px;
	}
	
	.txtCon {
		width: 100%;
		height: 34px;
		line-height: 34px;
	}
	
	.timeBox {
		margin-left: 60px;
		height: 30px;
		font-size: 14px;
		line-height: 30px;
		margin-bottom: 10px;
	}
	
	.timeBox input {
		margin-right: 20px;
		border: none;
		border: 1px solid #e5e5e5;
		background: #f5f5f5;
		text-indent: 10px;
		border-radius: 5px;
	}
	
	.wrapperBtm {
		padding: 20px 10px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
		background:#fff;
	}
	
	.wrapperBtm:after {
		content: "";
		height: 0;
		line-height: 0;
		visibility: hidden;
		clear: both;
		display: block;
	}
	.leftCon {
		float: left;
		width:49%;
		margin-right:2%;
		
	}
	.companyChartMsg{
		width:100%;
		margin-top:-20px;
		padding-bottom:20px;
	}
	.rightCon {
		float: right;
		width:49%;
	}
	.tableCon{
		width:100%;
		
	}
	.tableCon table tr{
		width:100%;
	}
	
	.tableCon table td{
		width:16.25%;
		text-align: center;
		font-size:14px;
		line-height:20px;
		padding:5px 0px;
	}
	.tableCon table td:nth-of-type(2){
		width:35%;
	}
</style>