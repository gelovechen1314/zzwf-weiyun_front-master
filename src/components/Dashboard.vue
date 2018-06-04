<template>
	<div class="row wrapCon">
		<div class="topMain">
			<div class="tpLeftCon" ref="tleftH">
				<div class="tpLftTop">
					<div class="itemLcon">
						<ul class="lists">
							<li style="background:#669bd8">
								<p>0</p>
								<span>离线预警</span>
							</li>
							<li style="background:#5ecfb8">
								<p>0</p>
								<span>离线预警</span>
							</li>
							<li style="background:#fea06f">
								<p>0</p>
								<span>离线预警</span>
							</li>
							<li style="background:#f78181">
								<p>0</p>
								<span>离线预警</span>
							</li>
							<li style="background:#ca94ec">
								<p>0</p>
								<span>离线预警</span>
							</li>
						</ul>
					</div>
					<div class="itemRcon">
						<div class="header titleHea">
							<span>工作提醒</span>
						</div>
						<div class="msgCon">
							<p><span>电量申报</span><b>23</b></p>
							<p><span>电量申报</span><b>23</b></p>
						</div>
					</div>
				</div>
				<div class="tpLftBtm">
					<div class="header titleHea">
						<span>数据指数</span>
					</div>
					<div class="tableCon">
						<div class="itemTable">
							<table>
								<tr>
									<td>实际月用电量</td>
									<td>同比</td>
									<td>环比</td>
									<td>偏差</td>
								</tr>
								<tr>
									<td>12</td>
									<td>13%<span></span></td>
									<td>12%<span v-if="resize"><img src="../assets/images/rise.png"/></span><span v-else><img src="../assets/images/fall.png"/></span></td>
									<td>0</td>
								</tr>
							</table>
						</div>
						<div class="itemTable">
							<table>
								<tr>
									<td>预测月偏差</td>
									<td>环比</td>

								</tr>
								<tr>
									<td>12</td>
									<td>13%<span v-if="resize"><img src="../assets/images/rise.png"/></span><span v-else><img src="../assets/images/fall.png"/></span></td>

								</tr>
							</table>
						</div>
						<div class="itemTable">
							<table>
								<tr>
									<td>申报月偏差</td>
									<td>环比</td>

								</tr>
								<tr>
									<td>12</td>
									<td>13%<span v-if="resize"><img src="../assets/images/rise.png"/></span><span v-else><img src="../assets/images/fall.png"/></span></td>

								</tr>
							</table>
						</div>
						<div class="itemTable">
							<table>
								<tr>
									<td>上月监测偏差</td>
									<td>环比</td>

								</tr>
								<tr>
									<td>12</td>
									<td>13%<span v-if="!resize"><img src="../assets/images/rise.png"/></span><span v-else><img src="../assets/images/fall.png"/></span></td>

								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="tpRightCon" ref="topInfo">
				<div class="header titleHea">
					<span style="inlne-block;width:80%;">计划进度提醒</span>
					<i class="el-icon-setting"></i>
				</div>
				<div class="dateWrap">
					<div class="dateMsg">
						<p><b>{{dataMsg}}</b><span>{{dayMsg}}</span></p>
						<h5>距离<strong>本月竞价</strong>还有</h5>
						<div class="date"><span>0</span>天</div>
					</div>
					
					<!--<div class="calendar">
						<vue-event-calendar class="riLI" :events="demoEvents" @monthChanged="" @dayChanged=""></vue-event-calendar>
					</div>-->
				</div>
			</div>
		</div>
		<div class="centerMain">
			<div class="useElecPro">
				<div class="header titleHea">
					<span>用电实时进度</span>
					<b class="txt">单位：<i>MWh</i>(每十五分钟一更新)</b>
				</div>
				<div class="progressCon">
					<p><span><b></b>已购电量</span><span><b></b>已用电量</span><span><b></b>超出电量</span></p>
					<el-progress :text-inside="true" :stroke-width="24" :percentage="70" color="#4fa8f9"></el-progress>
					<div class="dataTxt">
						<span>已购<strong>6.00</strong></span><span>已用<strong>6.00</strong></span><span>超出<strong>6.00</strong></span><span>剩余<strong>6.00</strong></span>
					</div>
				</div>
			</div>
			<div class="elecTime">
				<div class="header titleHea">
					<span style="width:75%;">用电实时段分布</span>
					<p class="tabP"><b :class="{'active':!flag}" @click="flag = false">月</b><b @click="flag = true" :class="{'active':flag}">年</b></p>
				</div>
				<div class="timeIntervalCon" v-if="!flag">
					<div class="progressWrap">
						<div class="tit">谷段</div>
						<div class="proParent" ref="sumW">
							<div class="pro" ref="proW">{{data1.num}}</div>
							<span class="proPtxt">{{data1.sum}}</span>
						</div>
					</div>
					<div class="progressWrap">
						<div class="tit">谷段</div>
						<div class="proParent">
							<div class="pro">12%</div>
							<span class="proPtxt">5.159MWh</span>
						</div>
					</div>
					<div class="progressWrap">
						<div class="tit">谷段</div>
						<div class="proParent">
							<div class="pro">12%</div>
							<span class="proPtxt">5.159MWh</span>
						</div>
					</div>
				</div>
				<div class="timeIntervalCon" v-if="flag">
					<div class="progressWrap">
						<div class="tit">谷段</div>
						<div class="proParent" ref="sumW">
							<div class="pro" :style="'width:'+ ((data2.num)/100) *data2.sum +'%;'" ref="proW">{{data2.num}}%</div>
							<span class="proPtxt">{{data2.sum}}MWh</span>
						</div>
					</div>
					<div class="progressWrap">
						<div class="tit">谷段</div>
						<div class="proParent">
							<div class="pro">12%</div>
							<span class="proPtxt">5.159MWh</span>
						</div>
					</div>
					<div class="progressWrap">
						<div class="tit">谷段</div>
						<div class="proParent">
							<div class="pro">12%</div>
							<span class="proPtxt">5.159MWh</span>
						</div>
					</div>
				</div>
			</div>
			<div class="tradeCon">
				<div class="titleHea">
					<span style="width:75%;">交易分布</span>
				</div>
				<div class="circleChartCon" id="circleChartCon" style="height:160px;"></div>
			</div>
		</div>
		<div class="btmMain">
			<div class="header titleHea">
				<span style="width:68%;">用电实时段分布</span>
				<p class="tabP"><b v-for="(item,index) in arrData" :class="{'active':curIndex==index}" v-html="item" @click="selectTab(index)"></b></p>
			</div>
			<div class="btmCon" id="harfMonLine" v-show="curIndex==0" style="height:400px;">
			</div>
			<div class="btmCon" id="dayBar" v-show="curIndex==1" style="height:400px;">
			</div>
			<div class="btmCon" id="MonBar" v-show="curIndex==2" style="height:400px;">
			</div>
		</div>
	</div>

</template>
<script>
	import "../assets/css/com.css"
	export default {
		data() {
			return {
				demoEvents: [/*{
					date: '2016/12/15',
					title: 'eat',
					desc: 'longlonglong description'
				}, {
					date: '2016/11/12',
					title: 'this is a title'
				}*/],
				arrData: ['15', '日', '月'],
				data1: {
					'num': 23,
					'sum': '32434',
				},
				data2: {
					'num': 454,
					'sum': '2324',
				},
				month: true,
				resize: true,
				curIndex: 0,
				flag: false,
				activeName2: 'first'
			}
		},
		components: {

		},
		created() {
			this.harfMonLine();
			this.MonBar();
			this.dayBar()
		},
		mounted() {
			this.circleChartCon();
			this.harfMonLine();
			this.MonBar();
			this.dayBar()
			var sW = this.$refs.sumW.height;
			this.$refs.proW.height = sW * (parseInt(this.data1.num) / 100)
			this.$nextTick(() => {

			})

		},
		computed: {
			dataMsg() {
				var mydate = new Date();
				var str = "" + mydate.getFullYear();
				var mm = mydate.getMonth() + 1
				if(mydate.getMonth() > 9) {
					str += "-" + mm + '-';
					vub
				} else {
					str += "-0" + mm + '-';
				}
				if(mydate.getDate() > 9) {
					str += mydate.getDate();
				} else {
					str += "-0" + mydate.getDate() + '-';
				}
				return str;

			},
			dayMsg() {
				var day = new Date().getDay();
				var x = '';
				switch(day) {
					case 0:
						x = "星期日";
						break;
					case 1:
						x = "星期一";
						break;
					case 2:
						x = "星期二";
						break;
					case 3:
						x = "星期三";
						break;
					case 4:
						x = "星期四";
						break;
					case 5:
						x = "星期五";
						break;
					case 6:
						x = "星期六";
						break;
				}
				return x;

			}
		},
		methods: {
			monthChange(month) {
				console.log(month)
			},
			dayChange(day) {
				console.log(day)
			},
			selectTab(index) {
				this.curIndex = index;
				console.log(this.curIndex)
			},
			circleChartCon() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('circleChartCon'))
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
						top: 20,
						bottom: 20,
						width: '50%',
						data: ['直接访问', '邮件营销', '联盟广告', '视频广告']
					},
					series: [{
						name: '访问来源',
						type: 'pie',
						radius: ['50%', '70%'],
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
			harfMonLine() {
				let chart = this.echarts.init(document.getElementById('harfMonLine'))
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
					visualMap: [{
						show: false,
						type: 'continuous',
						seriesIndex: 0,
						min: 0,
						max: 400
					}, {
						show: false,
						type: 'continuous',
						seriesIndex: 1,
						dimension: 0,
						min: 0,
						max: dateList.length - 1
					}],

					title: [{
						left: 'center',
						text: 'Gradient along the y axis'
					}, {
						top: '55%',
						left: 'center',
						text: 'Gradient along the x axis'
					}],
					tooltip: {
						trigger: 'axis'
					},
					xAxis: [{
						data: dateList
					}, {
						data: dateList,
						gridIndex: 1
					}],
					yAxis: [{
						splitLine: {
							show: false
						}
					}, {
						splitLine: {
							show: false
						},
						gridIndex: 1
					}],
					grid: [{
						bottom: '60%'
					}, {
						top: '60%'
					}],
					series: [{
						type: 'line',
						showSymbol: false,
						data: valueList
					}, {
						type: 'line',
						showSymbol: false,
						data: valueList,
						xAxisIndex: 1,
						yAxisIndex: 1
					}]
				};
				chart.setOption(option);

			},
			MonBar() {
				let chart = this.echarts.init(document.getElementById('MonBar'))

				let option = {
					tooltip: {
						trigger: 'axis',
						axisPointer: { // 坐标轴指示器，坐标轴触发有效
							type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					legend: {
						data: ['邮件营销', '联盟广告', '视频广告', '搜索引擎', '百度', '谷歌', '必应', '其他']
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					xAxis: [{
						type: 'category',
						data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
					}],
					yAxis: [{
						type: 'value'
					}],
					series: [{
							name: '邮件营销',
							type: 'bar',
							stack: '广告',
							data: [120, 132, 101, 134, 90, 230, 210]
						},
						{
							name: '联盟广告',
							type: 'bar',
							stack: '广告',
							data: [220, 182, 191, 234, 290, 330, 310]
						},
						{
							name: '视频广告',
							type: 'bar',
							stack: '广告',
							data: [150, 232, 201, 154, 190, 330, 410]
						},
						{
							name: '搜索引擎',
							type: 'bar',
							color: '#4fa8f9',
							data: [862, 1018, 964, 1026, 1679, 1600, 1570],
							markLine: {
								lineStyle: {
									normal: {
										type: 'dashed'
									}
								},
								data: [
									[{
										type: 'min'
									}, {
										type: 'max'
									}]
								]
							}
						},

					]
				};
				chart.setOption(option);

			},
			dayBar() {
				let chart = this.echarts.init(document.getElementById('dayBar'))

				let option = {
					tooltip: {
						trigger: 'axis',
						axisPointer: { // 坐标轴指示器，坐标轴触发有效
							type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					legend: {
						data: ['实时电量', '谷段电量', '平段电量', '峰段电量']
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					xAxis: [{
						type: 'category',
						data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
					}],
					yAxis: [{
						type: 'value'
					}],
					series: [{
							name: '实时电量',
							type: 'bar',
							color: '#4f8af9',
							data: [862, 1018, 964, 1026, 1679, 1600, 1570],
							markLine: {
								lineStyle: {
									normal: {
										type: 'dashed'
									}
								},
								data: [
									[{
										type: 'min'
									}, {
										type: 'max'
									}]
								]
							}
						},

						{
							name: '谷段电量',
							type: 'bar',
							color: '#6ec71e',
							stack: '广告',
							data: [220, 182, 191, 234, 290, 330, 310]
						},
						{
							name: '平段电量',
							type: 'bar',
							color: '#f56e6a',
							stack: '广告',
							data: [150, 232, 201, 154, 190, 330, 410]
						},
						{
							name: '峰段电量',
							type: 'bar',
							color: '#fc8b40',
							stack: '广告',
							data: [120, 132, 101, 134, 90, 230, 210]
						},

					]
				};
				chart.setOption(option);
			}

		}
	}
</script>
<style scoped="scoped">
	.wrapCon {
		margin: 10px;
		height: 98%;
		overflow: auto;
	}
	
	.topMain {
		width: 100%;
		margin-bottom: 10px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.topMain:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.tpLeftCon {
		width: 70%;
		float: left;
		margin: 0px;
		padding: 0px;
	}
	
	.tpRightCon {
		width: 30%;
		float: right;
		margin-left: 10px;
		background: #fff;
		border: .5px solid #e9eaec;
		border-radius: 5px;
	}
	
	.el-icon-setting {
		float: right;
		text-align: right;
		width: 15%;
		line-height: 52px;
		color: #aaa;
	}
	
	.tpLftTop {
		width: 100%;
		margin-bottom: 10px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.tpLftTop:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.itemLcon {
		width: 66%;
		float: left;
		background: #fff;
		border: .5px solid #e9eaec;
		border-radius: 5px;
	}
	
	.lists {
		padding: 30px 5px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
		margin: 0px;
	}
	
	.lists:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.lists li {
		width: 20%;
		padding: 10px 0px;
		color: #fff;
		margin: 0px 10px;
		float: left;
		text-align: center;
	}
	
	.lists li p {
		line-height: 100px;
		font-size: 40px;
		font-weight: 900;
		margin-bottom: 0;
	}
	
	.lists li span {
		font-size: 14px;
	}
	
	.itemRcon {
		width: 34%;
		background: #fff;
		margin-left: 10px;
		float: right;
		border: .5px solid #e9eaec;
		border-radius: 5px;
	}
	
	.msgCon {
		padding: 20px 40px;
	}
	
	.msgCon p {
		width: 100%;
		line-height: 50px;
		background: #f6f7fb;
		margin-bottom: 5px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.msgCon p:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.msgCon p span {
		font-size: 12px;
		color: #999;
		margin-left: 20px;
		float: left;
		width: 50%;
	}
	
	.msgCon p b {
		font-size: 32px;
		color: #108cee;
		float: right;
		width: 48%;
		text-align: left;
	}
	
	.tpLftBtm {
		width: 100%;
		border: .5px solid #e9eaec;
		background: #fff;
		border-radius: 5px;
		margin: 0px;
		padding: 0px;
	}
	
	.tableCon {
		padding: 20px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.tableCon:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.itemTable {
		margin-right: 10px;
		float: left;
	}
	
	.itemTable table tr:nth-of-type(1) {
		background: #f2f7fb;
	}
	
	.itemTable table td {
		padding: 10px;
		font-size: 14px;
		text-align: center;
	}
	
	@media (min-width: 1024px) {
		.itemTable table td {
			font-size: 10px
		}
	}
	/*>=1024的设备*/
	
	@media (min-width: 1100px) {
		.itemTable table td {
			font-size: 12px
		}
	}
	/*>=1100的设备*/
	
	@media (min-width: 1280px) {
		.itemTable table td {
			font-size: 12px;
		}
	}
	/*>=1280的设备*/
	
	@media (min-width: 1366px) {
		.itemTable table td {
			font-size: 14px;
		}
	}
	
	.itemTable table td span {
		width: 16px;
		height: 16px;
	}
	
	.dateWrap {
		width: 100%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.dateWrap:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.dateMsg {
		color: #fff;
		width: 40%;
		float: left;
		margin: 20px 0px 20px 5px;
		background: #5ecfb8;
	}
	
	.dateMsg p {
		padding: 10px;
	}
	
	.dateMsg p b {
		font-size: 12px;
	}
	
	.dateMsg p span {
		margin-left: 10px;
		font-size: 14px;
	}
	
	.dateMsg h5 {
		font-size: 12px;
		padding: 0px 10px;
	}
	
	.dateMsg h5 strong {
		font-size: 1rem;
		margin: 0px 5px;
	}
	
	.calendar {
		float: right;
		width: 62%;
	}
	.riLI{
		width:100%;
		text-align: left;
	}
	.cal-wrapper{
		padding:0px;
	}
	.riLI .events-wrapper{
		display:none;
		width:0px;
		height:0px;
	}
	
	.date {
		padding: 10px;
		/*margin-bottom: 2rem;*/
	}
	
	.date span {
		display: inline-block;
		padding: 20px 40px;
		background: #fff;
		border-radius: 5px;
		font-size: 44px;
		color: #fea06f;
		font-weight: 900;
	}
	/*划过有阴影*/
	
	.tpRightCon:hover,
	.itemLcon:hover,
	.itemRcon:hover,
	.useElecPro:hover,
	.elecTime:hover,
	.tradeCon:hover,
	.btmMain:hover,
	.tpLftBtm:hover {
		box-shadow: 0px 0px 5px 1px #ccc;
	}
	/*用电时实分布一行*/
	
	.centerMain {
		width: 100%;
		margin-bottom: 10px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.centerMain:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.useElecPro {
		width: 39.5%;
		float: left;
		background: #fff;
		border: .5px solid #e9eaec;
		border-radius: 5px;
		margin-right: 10px;
	}
	
	.elecTime {
		width: 30%;
		height: 100%;
		float: left;
		background: #fff;
		border: .5px solid #e9eaec;
		border-radius: 5px;
		margin-right: 10px;
	}
	
	.tradeCon {
		width: 30%;
		height: 100%;
		float: right;
		background: #fff;
		border: .5px solid #e9eaec;
		border-radius: 5px;
	}
	
	.txt {
		font-size: 12px;
		color: #999;
		font-family: "微软雅黑";
		line-height: 52px;
	}
	
	.txt i {
		font-style: normal;
		color: #4fa8f9;
	}
	
	.progressCon {
		padding: 0px 20px 20px;
	}
	
	.progressCon p {
		padding-top: 1rem;
	}
	
	.progressCon p span {
		margin: 0px 10px;
		font-size: 12px;
	}
	
	.progressCon p span b {
		display: inline-block;
		margin-right: 5px;
		width: 15px;
		height: 15px;
	}
	
	.progressCon p span:nth-of-type(1) b {
		background: #eeeeee;
	}
	
	.progressCon p span:nth-of-type(2) b {
		background: #4fa8f9;
	}
	
	.progressCon p span:nth-of-type(3) b {
		background: #f35e7a;
	}
	
	.el-progress-bar__outer {
		background: #f00;
	}
	
	.dataTxt {
		padding-top: 1rem;
	}
	
	.dataTxt span {
		font-size: 12px;
		margin-right: 10px;
	}
	
	.dataTxt span strong {
		font-size: 18px;
		color: #0089f0;
		margin-left: 10px;
	}
	
	.tabP {
		display: inline-block;
		float: right;
		margin-top: 12px;
		height: 30px;
		width: 30%;
		text-align: right;
		line-height: 30px;
	}
	
	.tabP b {
		padding: 0px 10px;
		height: 100%;
		display: inline-block;
		color: #3399ff;
		background: #eaf6fe;
		font-size: 12px;
		cursor: pointer;
		border: 1px solid #aed7fe;
	}
	
	.tabP .active {
		background: #2d8cf0;
		color: #fff;
	}
	
	.tabP b:hover {
		background: #2c75c2;
		color: #fff;
	}
	
	.tabP b:active {
		box-shadow: 0 0 5px 1px #aed7fe;
	}
	
	.timeIntervalCon {
		padding: 20px 20px 20px 10px;
	}
	
	.progressWrap {
		width: 100%;
		margin-bottom: 10px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.progressWrap:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.tit {
		width: 20%;
		text-align: center;
		float: left;
		line-height: 30px;
		font-size: 12px;
	}
	
	.proParent {
		width: 78%;
		float: left;
		line-height: 30px;
		background: #eee;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
		font-size: 12px;
	}
	
	.proParent:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.pro {
		background: #4fa8f9;
		text-align: center;
		float: Left;
		color: #fff;
	}
	
	.proPtxt {
		display: inline-block;
		float: left;
		color: #a8a8a8;
	}
	
	.circleChartCon {
		width: 100%;
		text-align: center;
	}
	
	.btmMain {
		width: 100%;
		background: #fff;
		border: .5px solid #e9eaec;
		border-radius: 5px;
		margin-bottom: 10px;
	}
	
	@media (min-width: 1024px) {
		#dayBar,
		#MonBar {
			width: 900px;
		}
	}
	/*>=1024的设备*/
	
	@media (min-width: 1100px) {
		#dayBar,
		#MonBar {
			width: 1000px;
		}
	}
	/*>=1100的设备*/
	
	@media (min-width: 1280px) {
		#dayBar,
		#MonBar {
			width: 1100px;
		}
	}
	
	@media (min-width: 1366px) {
		#dayBar,
		#MonBar {
			width: 1200px;
		}
	}
	
	@media (min-width: 1440px) {
		#dayBar,
		#MonBar {
			width: 1300px;
		}
	}
	
	@media (min-width: 1680px) {
		#dayBar,
		#MonBar {
			font-size: 1450px;
		}
	}
	
	@media (min-width: 1920px) {
		#dayBar,
		#MonBar {
			font-size: 1700px;
		}
	}
</style>