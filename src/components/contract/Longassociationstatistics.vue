<template>
	<div class="longAssoCon">
		<div class="mainCon">
			<div class="md" style="width:100%;margin-bottom:10px;">
				<form action="" class="form-inline" style="padding-left:20px;">
					<!--<div class="form-group">
						<b-button to="/customer/create" style="padding:5px 25px;background:#2d8cf0;border-radius:5px;" variant="success">新增</b-button>
					</div>-->
					<div class="form-group">
						年度：
						<input style="background:#f5f5f5;" type="text" class="form-control" placeholder="2017" v-model="filter">
					</div>
					<button class="btn" style="">上一年</button>
					<button class="btn" >查询</button>
					<button class="btn" >下一年</button>
					<div class="form-group">
						长协比例(0-100%0)：
						<input type="text" class="form-control" placeholder="2017" v-model="filter">
					</div>
					<button class="btn">生成</button>
				</form>
			</div>
			<div id="contractMsgBar" ></div>
			<div class="tableCon">
				<table class="table">
					<thead>
						<tr>
							<th>类型</th>
							<th>一月</th>
							<th>二月</th>
							<th>三月</th>
							<th>四月</th>
							<th>五月</th>
							<th>六月</th>
							<th>七月</th>
							<th>八月</th>
							<th>九月</th>
							<th>十月</th>
							<th>十一月</th>
							<th>十二月</th>
							<th>合计</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>年度预测合计(万kW-h)</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>长协合同合计(万kW-h)</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>2352.00</td>
							<td>463457</td>
							<td>32465.00</td>
							<td>6878.00</td>
							<td>233.00</td>
							<td>46543</td>
							<td>436</td>
						</tr>
						<tr>
							<td>长协比例(%)</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				
			}
		},
		mounted(){
			this.contractMsgBar()
		},
		methods:{
			contractMsgBar() {
				let chart = this.echarts.init(document.getElementById('contractMsgBar'))

				let option = {
					tooltip: {
						trigger: 'axis',
						axisPointer: { // 坐标轴指示器，坐标轴触发有效
							type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					legend: {
						data: ['合同号1', '合同号2', '合同号3', '合同号4','合同号5', '合同号6']
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					xAxis: [{
						type: 'category',
						data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月','八月', '九月', '十月', '十一月', '十二月',]
					}],
					yAxis: [{
						type: 'value'
					}],
					series: [{
							name: '合同号1',
							type: 'bar',
							stack: '广告',
							color:'#c23531',
							data: [120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90]
						},
						{
							name: '合同号2',
							type: 'bar',
							stack: '广告',
							color:'#2f4554',
							data: [220, 182, 191, 234, 290, 330, 310,220, 182, 191, 234, 290]
						},
						{
							name: '合同号3',
							type: 'bar',
							stack: '广告',
							color:'#61a0a8',
							data: [150, 232, 201, 154, 190, 330, 410,150, 232, 201, 154, 190]
						},
						{
							name: '合同号4',
							type: 'bar',
							stack: '广告',
							color:'#d48265',
							data: [220, 182, 191, 234, 290, 330, 310,220, 182, 191, 234, 290]
						},
						{
							name: '合同号5',
							type: 'bar',
							stack: '广告',
							color:'#91c7ae',
							data: [150, 232, 201, 154, 190, 330, 410,150, 232, 201, 154, 190]
						},
						{
							name: '合同号6',
							type: 'bar',
							stack: '广告',
							color: '#749f83',
							data: [150, 232, 201, 184, 190, 350, 410,130, 262, 201, 184, 190],
							
						},

					]
				};
				chart.setOption(option);

			},
		}
	}
</script>

<style scoped="scoped">
	.longAssoCon {
		margin: 20px;
		background: #fff;
	}
	.mainCon{
		padding:20px 10px;
	}
	
	.btn {
		padding: 5px 25px;
		background: #37b3e0;
		margin-right: 10px;
		color:#fff;
	}
	#contractMsgBar{
		width:100%;
		height:300px;
		margin-top:20px;
	}
	.tableCon{
		width:100%;
		padding-top:20px;
	}
	.table thead tr{
		background:#f5f5f5;
	}
	.table thead tr th,
	.table tbody tr td{
		padding:5px 10px;
		font-size:12px;
	}
	.table tbody tr:nth-child(even){
		background:#fff8f1
	}
</style>