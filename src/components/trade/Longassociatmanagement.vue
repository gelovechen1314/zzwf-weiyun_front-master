<template>
	<div class="contentCon">
		<div class="top">
			<div class="header titleHea">
				<span>长协统计</span>
				<p>
					<el-date-picker  v-model="value5" type="year" placeholder="选择年">
						
					</el-date-picker>
				</p>
			</div>
			<div class="wrapper-md wrapperCon">
				<div class="barBox" id="barBox" :style="{height:'400px'}"></div>

			</div>
		</div>
		<div class="kong"></div>
		<div class="tableCon">
			<el-table class="table1" :data="tableData1" size="mini" row-class-name="rowS" :row-style="{'font-size':'12px','color':'#495060'}" stripe  fit style="width: 100%">
				<el-table-column  prop="name" label="类型" width="140">
				</el-table-column>
				<el-table-column  prop="num" v-for="item in label" label="item" width="80">
				</el-table-column>
				<el-table-column  prop="sum" label="合计">
				</el-table-column>
			</el-table>
		</div>
		<div class="kong"></div>
		<div class="SigningBox">
			<div class="titleTab">
				<h5>签约统计</h5>
				 <b-button class="btnMain" to="/trade/addlongassociate"  variant="primary">+长协合同</b-button>
				<!-- <el-button class="btnMain" to="/trade/addlongassociate" type="primary">+长协合同</el-button>-->
			</div>
			<el-table class="tableCon" size="mini" :row-style="{'height':'30px','font-size':'12px','color':'#495060'}" :data="tableData2" border style="width: 100%">
				<el-table-column  prop="date" label="合同编号" width="150">
				</el-table-column>
				<el-table-column prop="name" label="电厂名称" width="160">
				</el-table-column>
				<el-table-column prop="province" label="签约电量" width="120">
				</el-table-column>
				<el-table-column prop="city" label="签约日期" width="120">
				</el-table-column>
				<el-table-column prop="address" label="执行日期" width="300">
				</el-table-column>
				<el-table-column prop="zip" label="联系人" width="120">
				</el-table-column>
				<el-table-column prop="phone" label="联系电话" width="120">
				</el-table-column>
				<el-table-column  label="操作" width="100">
					<template slot-scope="scope">
						<el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
					</template>
				</el-table-column>
			</el-table>
		</div>
	</div>
</template>

<script>
	
	import "../../assets/css/com.css"
	export default {

		data() {
			return {
				value5: '',
				label:['01月','02月','03月','04月','05月','06月','07月','08月','09月','10月','11月','12月'],
				tableData1: [{
					name:'长年度预测合计',
					num: '243254',
					
				}, {
					name:'长年度预测合计',
					num: '243254',
				}, {
					name:'长年度预测合计',
					num: '243254',
				}, {
					name:'长年度预测合计',
					num: '243254',
				}],
				tableData2: [{
					date: '2016-05-03',
					name: '王小虎',
					province: '上海',
					city: '普陀区',
					address: '上海市普陀区金沙江路 1518 弄',
					zip: 200333
				}, {
					date: '2016-05-02',
					name: '王小虎',
					province: '上海',
					city: '普陀区',
					address: '上海市普陀区金沙江路 1518 弄',
					zip: 200333,
					phone:'1294732325435',
				}, {
					date: '2016-05-04',
					name: '王小虎',
					province: '上海',
					city: '普陀区',
					address: '上海市普陀区金沙江路 1518 弄',
					zip: 200333,
					phone:'1294732325435',
				}, {
					date: '2016-05-01',
					name: '王小虎',
					province: '上海',
					city: '普陀区',
					address: '上海市普陀区金沙江路 1518 弄',
					zip: 200333,
					phone:'1294732325435'
				}]

			}
		},
		mounted() {
			this.barBox()
		},
		methods: {
			currentChange(currentRow, oldCurrentRow){
				currentRow.style="background:#f00"
			},
			
			barBox() {
				let chart = this.echarts.init(document.getElementById('barBox'))
				// 绘制图表
				chart.setOption({

					tooltip: {
						trigger: 'axis',
						axisPointer: { // 坐标轴指示器，坐标轴触发有效
							type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					legend: {
						data: ['直接访问', '邮件营销']
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					xAxis: {
						type: 'category',
						data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
					},
					yAxis: {
						type: 'value'
					},

					series: [{
							name: '直接访问',
							type: 'bar',
							stack: '总量',
							color: '#4f8af9',
							label: {
								normal: {
									show: true,
									position: 'insideRight'
								}
							},
							data: [320, 302, 301, 334, 390, 330, 320, 302, 301, 334, 390, 330]
						},
						{
							name: '邮件营销',
							type: 'bar',
							stack: '总量',
							color: '#6ec71e',
							label: {
								normal: {
									show: true,
									position: 'insideRight'
								}
							},
							data: [120, 132, 101, 134, 90, 230, 210, 302, 301, 334, 390, 330]
						},

					]
				});
			}

		},
		computed: {

		},
		watch: {
			value5() {
				/*alert('111')*/
			}
		}
	};
</script>

<style scoped="scoped">
	::-webkit-scrollbar-thumb {
		height: 100%;
		background: #f00;
	}
	
	.contentCon {
		padding: 10px;
		height: 100%;
		overflow-y: scroll;
	}
	
	.top {
		margin-bottom: 5px;
		border: .5px solid #e9eaec;
		border-radius: 5px;
	}
	
	.top:hover {
		box-shadow: 0px 0px 5px 1px #ccc;
	}
	
	.titleHea {
		background: #fff;
	}
	
	.wrapperCon {
		background: #fff;
	}
	
	.kong {
		width: 100%;
		height: 5px;
		background: #f0f0f0;
	}
	
	.SigningBox {
		margin-top: 5px;
		border: .5px solid #e9eaec;
		background: #fff;
		border-radius: 5px;
	}
	
	.SigningBox:hover {
		box-shadow: 0px 0px 5px 1px #ccc;
	}
	
	.titleTab {
		height: 55px;
		width: 100%;
		border-bottom: 1px solid #e9eaec;
		margin-bottom: 10px;
	}
	
	.titleTab h5 {
		float: left;
		font-size: 20px;
		line-height: 55px;
		padding-left: 20px;
		color: #495060;
	}
	
	.btnMain {
		float: right;
		height: 40px;
		margin-top: 7.5px;
		margin-right: 10px;
	}
	.tableCon{
		font-size:14px;
	}
	.trCo:hover tr{
		background:#ebf7ff
	}
	.el-table th, .el-table tr td{
		font-size:10px;
	}
	.el-table td, .el-table th{
		padding:0px !important ;
	}
	
	.el-table .cell{
		font-size:14px ;
	}
	.rowS:hover{
		background:#f00;
	}
	
</style>