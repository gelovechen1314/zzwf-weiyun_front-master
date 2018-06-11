<template>
	<div class="wrapCon">
		<div class="topMain">
			<div class="tpLeftCon" ref="tleftH">
				<div class="tpLftBtm">
					<div class="tableCon">
						<div v-for="item in queData" class="itemTable">
							<div class="imgWrap">
								<img v-bind:src="item.imgurl" title="" alt="" />
							</div>
							<div class="txtCon">
								<p v-html="item.title"></p>
								<h3 v-html="item.num"></h3>
							</div>
						</div>
					</div>
				</div>
				<div class="tpLftTop">
					<div class="itemRcon">
						<div class="header titleHea">
							<span>企业年度购电偏差</span>
						</div>
						<div class="msgCon">
							<h3>0.00MWH</h3>
							<p>偏差比：0.00%</p>
							<p><span>上月偏差：</span><b>23</b></p>
						</div>
					</div>
					<div class="itemLcon">
						<div class="header titleHea">
							<span>模拟竞价统计</span>
						</div>
						<div class="biddingChart" id="biddingChart" style="width:100%;height:180px;"></div>
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
			<div class="cleftCon">
				<div class="centerLeft">
					<div class="useElecPro">
						<div class="header titleHea">
							<span style="display:inline-block;width:40%;">月度竞价模拟</span>
							<p><i class="el-icon-refresh"></i><button>+</button><button style="font-size:12px;">清空数据</button></p>
						</div>
						<div class="requireElecLine">
							<p>
								<a href="javascript:void(0):">修</a>
								<a href="javascript:void(0):">清</a>
							</p>
							<div id="requireElecLine" style="height:280px;margin-top:-20px"></div>
						</div>
					</div>
					<div class="elecTime">
						<div class="header titleHea">
							<span style="width:75%;">月度竞价供给侧数</span>
						</div>
						<div class="eleCon">
							<p>供给侧名称</p>
						</div>
					</div>
				</div>
				<div class="btmMain">
					<div class="header titleHea">
						<span style="width:68%;">月度竞价历史数据</span>
						<p class="tabP">gsdfg</p>
					</div>
					<div class="historyDataLine" id="historyDataLine" style="height:280px;width:100%;">

					</div>

				</div>
			</div>
			<div class="tradeCon">
				<div class="titleHea">
					<span style="width:75%;">月度竞价讨论</span>
				</div>
				<div class="circleChartCon" id="circleChartCon" style="height:160px;"></div>
			</div>
		</div>

	</div>
</template>

<script>
	export default {
		data() {
			return {
				queData: [{
						imgurl: require("../../assets/images/bg1.jpg"),
						title: '年度预测总电量',
						num: '92.80'
					},
					{
						imgurl: require("../../assets/images/bg2.jpg"),
						title: '年度竞价合计',
						num: '0.00'
					},
					{
						imgurl: require("../../assets/images/bg3.jpg"),
						title: '月度预测电量',
						num: '150.00'
					},
					{
						imgurl: require("../../assets/images/bg4.jpg"),
						title: '本月度计划新增购电量',
						num: '150.00'
					}
				],
				demoEvents: [
					/*{
										date: '2016/12/15',
										title: 'eat',
										desc: 'longlonglong description'
									}, {
										date: '2016/11/12',
										title: 'this is a title'
									}*/
				],
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

			this.dayBar()
		},
		mounted() {
			this.biddingChart();
			this.requireElecLine();
			this.historyDataLine();
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
			biddingChart() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('biddingChart'))
				// 绘制图表
				chart.setOption({
					xAxis: {
						type: 'category',
						data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						data: [820, 932, 901, 934, 1290, 1330, 1320],
						type: 'line'
					}]
				});
			},
			requireElecLine() {
				// 基于准备好的dom，初始化echarts实例
				let chart = this.echarts.init(document.getElementById('requireElecLine'))
				// 绘制图表
				chart.setOption({
					title: {
						text: ''
					},
					tooltip: {
						trigger: 'axis'
					},
					legend: {
						data: ['需求测电量']
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
						data: ['0', '0.2', '0.4', '0.6', '0.8', '1']
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						name: '需求测电量',
						type: 'line',
						stack: '总量',
						color: "#ff3636",
						data: [120, 132, 101, 134, 90, 230]
					}]
				});

			},
			historyDataLine() {
				let chart = this.echarts.init(document.getElementById('historyDataLine'))

				let option = {
					title: {
						text: ''
					},
					tooltip: {
						trigger: 'axis'
					},
					legend: {
						data: ['邮件营销', '联盟广告']
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
							name: '邮件营销',
							type: 'line',
							stack: '总量',
							color:'#4f8af9',
							data: [120, 132, 101, 134, 90, 230, 210]
						},
						{
							name: '联盟广告',
							type: 'line',
							stack: '总量',
							color:'#f35e7a',
							data: [220, 182, 191, 234, 290, 330, 310]
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
	};
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
	
	.tpLeftCon,
	.cleftCon {
		width: 72%;
		float: left;
		margin: 0px;
		padding: 0px;
	}
	
	.centerLeft {
		width: 100%;
		border: .5px solid #e9eaec;
		border-radius: 5px;
		background: #fff;
		margin-bottom: 10px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.cleftCon {
		margin-right: 10px;
	}
	
	.tpRightCon {
		width: 28%;
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
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.itemLcon {
		width: 66%;
		float: left;
		background: #fff;
		border: .5px solid #e9eaec;
		border-radius: 5px;
	}
	
	.itemRcon {
		width: 34%;
		background: #fff;
		margin-right: 10px;
		float: right;
		border: .5px solid #e9eaec;
		border-radius: 5px;
	}
	
	.msgCon {
		padding: 20px 0px;
		text-align: center
	}
	
	.msgCon p {
		width: 100%;
		text-align: center;
		line-height: 30px;
		margin-bottom: 5px;
		color: #c6a4cc;
		font-size: 12px;
	}
	
	.msgCon h3 {
		color: #c6a4cc
	}
	
	.msgCon p span {
		font-size: 12px;
		color: #3399ff;
	}
	
	.msgCon p b {
		font-size: 12px;
		color: #c6a4cc;
	}
	
	.tpLftBtm {
		width: 100%;
		margin-bottom: 10px;
		border: .5px solid #e9eaec;
		background: #fff;
		border-radius: 5px;
		padding: 0px;
	}
	
	.tableCon {
		padding: 20px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.tableCon:after,
	.msgCon p:after,
	.lists:after,
	.topMain:after,
	.centerLeft:after,
	.tpLftTop:after,
	.itemTable:after {
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
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
		width: 25%;
	}
	
	.imgWrap {
		width: 90px;
		height: 60px;
		float: left;
		margin-right: 10px;
	}
	
	.imgWrap img {
		width: 100%;
		height: 100%;
	}
	
	.txtCon p {
		font-size: 12px;
		color: #999;
		margin-bottom: 0px;
	}
	
	.itemTable:nth-of-type(1) h3 {
		color: #40a42b;
	}
	
	.itemTable:nth-of-type(2) h3 {
		color: #7ea7d0;
	}
	
	.itemTable:nth-of-type(3) h3 {
		color: #d18f75;
	}
	
	.itemTable:nth-of-type(4) h3 {
		color: #5f3f9f;
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
	
	.riLI {
		width: 100%;
		text-align: left;
	}
	
	.cal-wrapper {
		padding: 0px;
	}
	
	.riLI .events-wrapper {
		display: none;
		width: 0px;
		height: 0px;
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
	.tradeCon:hover,
	.btmMain:hover,
	.centerLeft:hover,
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
		width: 65%;
		float: left;
		margin-right: 10px;
		background: #fff;
	}
	
	.elecTime {
		width: 33%;
		height: 100%;
		float: left;
		background: #fff;
	}
	
	.titleHea p {
		margin: 0px;
		padding: 0px 0px 5px;
	}
	
	.titleHea p button {
		height: 30px;
		padding: 0px 15px;
		line-height: 30px;
		border: none;
		color: #fff;
		border-radius: 5px;
		background: #3399ff;
		margin-right: 10px;
	}
	
	.el-icon-refresh {
		padding: 6px 10px;
		background: #eaf6fe;
		color: #3399ff;
		margin-right: 10px;
		font-size: 18px;
	}
	
	.tradeCon {
		width: 28%;
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
	
	.requireElecLine {
		padding: 0px 10px 20px;
		height: 297px;
	}
	
	.requireElecLine p {
		width: 100%;
		text-align: right;
	}
	
	.requireElecLine p a {
		font-size: 12px;
		color: #3399ff;
		margin-right: 10px;
		cursor: pointer;
		text-decoration: none;
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
		margin-top: 10px;
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