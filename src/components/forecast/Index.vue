<template>
	<div class="wraperBox">
		<div class="header titleHea">
			<span>购电辅助决策</span>
			<p><em class="iconfont">&#xe778;</em>首页：<b>监测></b><b>数据监控</b></p>
		</div>
		<div class="wrapper-md">
			<div class="monthChartWrap">
				<div class="monthChartLeft">
					<headerBar class="monthCon" :flag="!flag">
						<p slot="headerBar">长协电量预测</p>
					</headerBar>
					<div id="changXElecChartBar" :style="{width:'100%', height: '280px'}"></div>
				</div>
				<div class="monthTxtRight">
					<headerBar class="monthCon singLe" :flag="!flag">
						<p slot="headerBar">年度电量增加指标</p>
					</headerBar>
					<div id="yearElecChart" :style="{width:'100%',height:'280px'}">

					</div>
				</div>
			</div>
			<div class="monthChartWrap">
				<div class="monthChartLeft">
					<headerBar class="monthCon" :flag="flag">
						<p slot="headerBar">月度竞价缺口</p>
						<a slot="seeMore" href="javascript:void(0);">查看更多</a>
					</headerBar>
					<div id="monthElecChartBar" :style="{width:'100%', height: '280px'}"></div>
				</div>
				<div class="monthTxtRight">
					<headerBar class="monthCon singLe" :flag="!flag">
						<p slot="headerBar">半年签单增长指标</p>
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
			this.changXElecChartBar();
			this.monthElecChartBar();
			this.monthGouElecChart();
			this.yearElecChart()
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
			
			changXElecChartBar() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('changXElecChartBar'))
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
			yearElecChart(){
				let chart = this.echarts.init(document.getElementById('yearElecChart'));
				chart.setOption({
					xAxis: {
						type: 'category',
						data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月']
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						data: [820, 932, 901, 934, 1290, 1330, 1320],
						type: 'line',
						smooth: true,
						color:'#40d9b3'
					}]
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
			monthGouElecChart() {
				let chart = this.echarts.init(document.getElementById('monthGouElecChart'))
				// 绘制图表
				chart.setOption({
					xAxis: {
						type: 'category',
						data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月']
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						data: [820, 932, 901, 934, 1290, 1330, 1320],
						type: 'line',
						smooth: true,
						color:'#40d9b3'
					}]
				});

			}
		}
	}
</script>
<style scoped="scoped">
	.wraperBox {
		width: 100%;
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
		width: 59%;
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
		width: 39%;
	}
	
	.singLe p {
		width: 90%;
	}
</style>