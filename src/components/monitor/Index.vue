<template>
	<div class="wraperBox">
		<div class="header titleHea">
				<span>数据监控</span>
				<p><em class="iconfont">&#xe778;</em>首页：<b>监测></b><b>数据监控</b></p>
			</div>
			<div class="wrapper-md">
				<headerBar class="txtCon" :flag="flag">
					<p slot="headerBar">全公司用电量曲线</p>
				</headerBar>
				<div class="chartWrap">
					<div id="allCompanyChart" :style="{width:'100%', height: '280px'}"></div>
				</div>
				<div class="monthChartWrap">
					<div class="monthChartLeft">
						<headerBar class="monthCon" :flag="flag">
							<p slot="headerBar">本月购电量排行</p>
							<a slot="seeMore" href="javascript:void(0);">查看更多</a>
						</headerBar>
						<div id="monthElecChartBar" :style="{width:'100%', height: '280px'}"></div>
					</div>
					<div class="monthTxtRight">
						<headerBar class="monthCon singLe" :flag="flag">
							<p slot="headerBar">本月用电量排行</p>
						</headerBar>
						<div id="monthGouElecChart" :style="{width:'100%',height:'280px'}">

						</div>
					</div>
				</div>

			</div>
	</div>
</template>
<script>
	import TreeList from 'vue-jstree';
	import headerBar from "../common/headerBar.vue";
	export default {
		components: {
			TreeList,
			headerBar
		},
		data() {
			return {
				flag: false,
				companyKeyword: '',
				companys: [{
						"text": "郑州市",
						"icon": "",
						"opened": true,
						"children": [{
								"text": "登封市鑫浩耐磨材料有限公司",
								"children": [{
										"text": "户号(509273589)"
									},
									{
										"text": "户号(509273560)"
									}
								]
							},
							{
								"text": "河南省鸿润建材发展有限公司"
							},
							{
								"text": "河南金水电缆集团有限公司"
							}
						]
					},
					{
						"text": "开封市",
					},
					{
						"text": "平顶山市",
					},
					{
						"text": "洛阳市",
					}
				]
			}
		},
		mounted() {
			this.allCompanyElecChart();
			this.monthElecChartBar();
			this.monthGouElecChart()
		},
		methods: {
			itemClick(node) {
				console.log(node.model.text + ' clicked !')
			},
			SearchCompany: function() {
				var text = this.companyKeyword
				const patt = new RegExp(text);
				this.$refs.tree.handleRecursionNodeChilds(this.$refs.tree, function(node) {
					if(text !== '') {
						const str = node.model.text
						if(patt.test(str)) {
							node.$el.querySelector('.tree-anchor').style.color = 'red';
							var el = node.$el.querySelector('.tree-anchor');
							el.parentElement.parentElement.previousElementSibling.closest("div").style.color = 'red';
						} else {
							node.$el.querySelector('.tree-anchor').style.color = '#000'
						} // or other operations
					} else {
						node.$el.querySelector('.tree-anchor').style.color = '#000'
					}
				})
			},
			allCompanyElecChart() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('allCompanyChart'))
				// 绘制图表
				chart.setOption({
					title: {
						text: ''
					},
					tooltip: {
						trigger: 'axis'
					},
					legend: {
						data: ['邮件营销', '联盟广告', '视频广告', '直接访问', '搜索引擎']
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
			monthElecChartBar() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('monthElecChartBar'))
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
			monthGouElecChart() {
				let chart = this.echarts.init(document.getElementById('monthGouElecChart'))
				// 绘制图表
				chart.setOption({
					color: ['#999'],
					tooltip: {
						trigger: 'axis',
						axisPointer: { // 坐标轴指示器，坐标轴触发有效
							type: 'line' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					xAxis: [{
						type: 'category',
						data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
						axisTick: {
							alignWithLabel: true
						}
					}],
					yAxis: [{
						type: 'value'
					}],
					series: [{
						name: '直接访问',
						type: 'bar',
						barWidth: '1%',
						data: [10, 52, 200, 334, 390, 330, 220]
					}]
				});

			}
		}
	}
</script>
<style scoped="scoped">
	.wraperBox{
		width:100%;
	}
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
	
	.txtCon {
		width: 100%;
		height: 20px;
		line-height: 20px;
	}
	
	.chartWrap {
		width: 100%;
		margin-bottom: 20px;
	}
	
	.monthChartWrap {
		width: 100%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
	}
	
	.monthChartWrap:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.monthChartLeft {
		width: 49%;
		float: left;
		margin-right: 2%;
	}
	
	.monthChartWrap .monthCon {
		width: 100%;
		height: 20px;
	}
	
	.monthCon p {
		float: left;
		width: 70%;
	}
	
	.monthCon a {
		float: right;
		text-align: right;
		width: 20%;
		color: #000;
		text-decoration: none;
	}
	
	.monthCon a:hover {
		color: #005DE6;
	}
	
	#monthElecChartBar {
		width: 100%;
	}
	
	.monthTxtRight {
		float: right;
		width: 49%;
	}
	
	.singLe p {
		width: 90%;
	}

</style>