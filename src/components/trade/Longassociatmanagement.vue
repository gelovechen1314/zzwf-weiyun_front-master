<template>
	<div class="contentCon">
		<div class="header titleHea">
			<span>长协统计</span>
			<p>
				<el-date-picker v-model="value5" type="year" placeholder="选择年">
				</el-date-picker>
			</p>
		</div>
		<div class="wrapper-md wrapperCon">
			<div class="barBox" id="barBox" :style="{height:'400px'}"></div>
		
		</div>
		<div class="kong"></div>
	</div>
</template>

<script>
	import "../../assets/css/com.css"
	export default {

		data() {
			return {
				value5: '',

			}
		},
		mounted(){
			this.barBox()
		},
		methods: {
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
						data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月','八月','九月','十月','十一月','十二月']
					},
					yAxis: {
						type: 'value'
					},

					series: [{
							name: '直接访问',
							type: 'bar',
							stack: '总量',
							color:'#4f8af9',
							label: {
								normal: {
									show: true,
									position: 'insideRight'
								}
							},
							data: [320, 302, 301, 334, 390, 330, 320,302, 301, 334, 390, 330]
						},
						{
							name: '邮件营销',
							type: 'bar',
							stack: '总量',
							color:'#6ec71e',
							label: {
								normal: {
									show: true,
									position: 'insideRight'
								}
							},
							data: [120, 132, 101, 134, 90, 230, 210,302, 301, 334, 390, 330]
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

.titleHea{
	background:#fff;
	margin:10px 10px 0px 10px;
}
.wrapperCon{
	background:#fff;
	margin:0px 10px 0px 10px;
}
.kong{
	width:100%;
	height:10px;
	background: #f0f0f0;
}
</style>