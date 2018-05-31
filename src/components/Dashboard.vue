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
					<div class="calendar"></div>
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
			</div>
			<div class="tradeCon"></div>
		</div>
		<div class="btmMain"></div>
	</div>

</template>
<script>
	import "../assets/css/com.css"
	export default {
		data() {
			return {
				resize: true,
				flag: false,
				activeName2: 'first'
			}
		},
		mounted() {
			this.yearChart();
			 let tabH = this.$refs.tleftH.offsetHeight;
				 console.log(tabH)
			this.$nextTick(function() {
				
			})
			

		},
		components: {

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
			handleClick(tab, event) {
				console.log(tab, event);
			},
			yearChart() {
				let chart = this.echarts.init(document.getElementById('totalChart'))
				chart.setOption({
					color: ['#27c24c', '#eb6100'],
					tooltip: {
						trigger: 'item',
						formatter: "{a} <br/>{b}: {c} ({d}%)"
					},
					series: [{
						name: '年度电量',
						type: 'pie',
						radius: ['50%', '70%'],
						avoidLabelOverlap: false,
						labelLine: {
							normal: {
								show: false
							}
						},
						data: [{
								value: 310,
								name: '剩余电量'
							},
							{
								value: 335,
								name: '签约电量'
							}

						]
					}]
				});
			},

		}
	}
</script>
<style scoped="scoped">
	.wrapCon {
		margin: 20px;
		height: 90%;
		overflow: auto;
	}
	
	.topMain {
		width: 100%;
		margin-bottom: 20px;
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
	}
	
	.tpRightCon {
		width: 30%;
		float: right;
		height: 100%;
		margin-left: 20px;
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
		margin-bottom: 20px;
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
		margin-left: 20px;
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
		margin-right: 20px;
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
	.tpLftBtm:hover {
		box-shadow: 0px 0px 5px 1px #ccc;
	}
	/*用电时实分布一行*/
	
	.centerMain {
		width: 100%;
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
		width: 37%;
		float: left;
		background: #fff;
		border: .5px solid #e9eaec;
		border-radius: 5px;
		margin-right: 20px;
	}
	
	.elecTime {
		width: 31.5%;
		height: 100%;
		float: left;
		background: #fff;
		border: .5px solid #e9eaec;
		border-radius: 5px;
		margin-right: 20px;
	}
	
	.tradeCon {
		width: 31.5%;
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
</style>