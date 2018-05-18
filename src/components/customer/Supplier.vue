<template>
	<div>
		<div class="header titleHea">
			<span>供应商</span>
			<p>
				<a href="/"><em class="iconfont">&#xe778;</em>首页</a>：<b>客户></b><b>供应商</b></p>
		</div>
		<div class="wrapper-md wrapperCon">
			<div class="chartBarBox">
				<headerLong class="txtCon">
					<p slot="headerBar">供应商数据统计</p>
				</headerLong>
				<div class="monthChartBar" id="monthChartBar" :style="{height:'336px',width:'60%'}">
				</div>
				<div class="buttonBox">
					<a href="javascript:void(0):">增加供应商</a>
				</div>
			</div>
			<div class="tableWrap">
				<table>
					<tr>
						<td>联系日期</td>
						<td>企业</td>
						<td>联系人</td>
						<td>连系电话</td>
						<td>添加日期</td>
						<td>操作</td>
					</tr>
					<tr>
						<td>2018-5-10</td>
						<td>郑州耀光电子科技有限公司</td>
						<td>胡建辉</td>
						<td>12343256467</td>
						<td>2018-5-10</td>
						<td>
							<a href="javscript:void(0)">编辑</a><span>详情</span></td>
					</tr>
					<tr>
						<td>2018-5-10</td>
						<td>郑州耀光电子科技有限公司</td>
						<td>胡建辉</td>
						<td>12343256467</td>
						<td>2018-5-10</td>
						<td>
							<a href="javscript:void(0)">编辑</a><span>详情</span></td>
					</tr>
				</table>
			</div>
			<div class="pageCon">
				<div class="page" v-if="show">
					<div class="pagelist">
						<span class="jump" v-if="current_page>1" @click="current_page--">上一页</span>
						<span v-if="current_page>5" class="jump" @click="jumpPage(1)"></span>
						<span class="ellipsis" v-if="efont">...</span>
						<span class="jump" v-for="num in indexs" :class="{'bgprimary':current_page==num}" @click="jumpPage(num)">{{num}}</span>
						<span class="ellipsis" v-if="efont&&current_page<pages-4">...</span>
						<span class="jump" @click="current_page++">下一页</span>
						<span v-if="current_page<pages-1" class="jump" @click="jumpPage(pages)">{{pages}}</span>
						<span class="jumppoint">跳转到：</span>
						<span class="jumpinp"><input type="text" v-model="changePage"></span>
						<span class="jump gobtn" @click="jumpPage(changePage)">GO</span>
					</div>
				</div>
				<!--<pages class="pageShow" v-if="show"
					:current_page="current_page" 
					:pages="pages" 
					:changePage="changePage" 
					:nowIndex="nowIndex"
					:efont="efont"
					:show="show"
					:indexs="indexs"
					@jumpPage='jumpPage'
					@currentPage="currentPageJj"
					@currentPageReduce="currentPageReduce"
					></pages>-->
			</div>
		</div>

	</div>
</template>

<script>
	import headerLong from "../common/headerLong.vue";
	import pages from "../common/pages.vue";
	export default {
		data() {
			return { 
				current_page: 1, //当前页 
				pages: 100, //总页数 
				changePage: '', //跳转页 
				nowIndex: 0
			}
		},
		components: {
			headerLong,
			pages
		},
		mounted() {
			this.monthChartBar()
		},
		computed: {
			show: function() {
				return this.pages && this.pages != 1
			},
			efont: function() {
				if(this.pages <= 7) return false;
				return this.current_page > 5
			},
			indexs: function() {
				var left = 1,
					right = this.pages,
					ar = [];
				if(this.pages >= 7) {
					if(this.current_page > 5 && this.current_page < this.pages - 4) {
						left = Number(this.current_page) - 3;
						right = Number(this.current_page) + 3;
					} else {
						if(this.current_page <= 5) {
							left = 1;
							right = 7;
						} else {
							right = this.pages;

							left = this.pages - 6;
						}
					}
				}
				while(left <= right) {
					ar.push(left);
					left++;
				}
				return ar;
			},
		},

		methods: {
			jumpPage: function(id) {
				this.current_page = id;
				
			},
			currentPageJj:function(){
				this.current_page++;
				
			},
			currentPageReduce:function(){
				this.current_page--;
				
			},
			monthChartBar() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('monthChartBar'))
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
						data: ['成交电量', '计划电量', '生产电量']
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
							name: '成交电量',
							type: 'bar',
							color: '#00c5dc',
							data: [500, 480, 700, 800, 900, 850, 900, 1200],

						},
						{
							name: '计划电量',
							color: '#5867c3',
							type: 'bar',
							data: [500, 480, 850, 800, 1100, 850, 900, 1200],

						},
						{
							name: '生产电量',
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
		width: 100%;
		height: 100%;
		background: #fff;
	}
	
	.txtCon {
		width: 100%;
		height: 34px;
		line-height: 34px;
	}
	
	.chartBarBox {
		padding: 36px 20px 0px 65px;
		position: relative;
	}
	
	.buttonBox {
		position: absolute;
		right: 40px;
		bottom: 20px;
		width: 140px;
	}
	
	.buttonBox a {
		color: #fff;
		width: 100%;
		display: inline-block;
		height: 42px;
		line-height: 42px;
		text-align: center;
		background: #169bd5;
		border-radius: 5px;
		text-decoration: none;
	}
	
	.buttonBox a:hover {
		background: #20bbff
	}
	
	.buttonBox a:active {
		position: relative;
		top: 1px;
	}
	
	.tableWrap {
		padding: 25px;
	}
	
	.tableWrap tr:nth-of-type(1) {
		background: #F2F2F2;
	}
	
	.tableWrap tr:nth-of-type(1) td {
		line-height: 28px;
	}
	
	.tableWrap td {
		line-height: 20px;
		font-size: 14px;
		padding: 5px 20px;
		text-align: center;
	}
	
	.tableWrap td span {
		display: inline-block;
		margin-left: 10px;
	}
	
	.tableWrap td span:hover {
		color: #37b3e0
	}
	
	.tableWrap td a {
		text-decoration: none;
	}
	
	.pageCon {
		padding-right:40px;
		height:40px;
		margin-top:10px;
	}
	.pageShow{
		width:100%;
		height:100%;
		
	}
	.page {
		font-weight: 900;
		height: 40px;
		text-align: right;
		color: #888;
		margin: 20px auto 0;
		background: #f2f2f2;
	}
	
	.pagelist {
		font-size: 0;
		background: #fff;
		height: 50px;
		line-height: 50px;
	}
	
	.pagelist span {
		font-size: 14px;
	}
	
	.pagelist .jump {
		border: 1px solid #ccc;
		padding: 5px 8px;
		-webkit-border-radius: 4px;
		-moz-border-radius: 4px;
		border-radius: 4px;
		cursor: pointer;
		margin-left: 5px;
	}
	
	.pagelist .bgprimary {
		cursor: default;
		color: #fff;
		background: #337ab7;
		border-color: #337ab7;
	}
	
	.jumpinp input {
		width: 55px;
		height: 26px;
		font-size: 13px;
		border: 1px solid #ccc;
		-webkit-border-radius: 4px;
		-moz-border-radius: 4px;
		border-radius: 4px;
		text-align: center;
	}
	
	.ellipsis {
		padding: 0px 8px;
	}
	
	.jumppoint {
		margin-left: 30px;
	}
	
	.pagelist .gobtn {}
	
	.bgprimary {
		cursor: default;
		color: #fff;
		background: #337ab7;
		border-color: #337ab7;
	}
</style>