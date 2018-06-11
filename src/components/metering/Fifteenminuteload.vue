<template>
	<div>
		<div class="wrapper-md wrapperCon">
			<div class="timeBox">
				开始时间:<input type="text" placeholder="2018-01-30" />结束时间：<input type="text" placeholder="2018-01-30" /><button>采集电量</button><button>预测电量</button>
			</div>
			<div class="dayElecQue" id="dayElecQue" style="width:100%;height:360px;">
			</div>
			<div class="lineBtn">
				<button>生成叠加</button><button>生成平均</button><button>清空全部曲线</button>
				<!--<el-switch v-model="value3" active-text="" inactive-text="异常标志">
				</el-switch>-->
			</div>
			<div class="tableCon">
				<table class="table">
					<thead>
						<tr>
							<th><input @click="checkedAll" :checked="checkboxModel.length === data.length" type="checkbox" /></th>
							<th>序号</th>
							<th>名称</th>
							<th>数据来源</th>
							<th>时段</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr :key="index"  v-if="data.length" v-for="(item,index) in data">
							<td><input :checked="checkboxModel.indexOf(item.id)>=0" type="checkbox" @click="checkedOne(item.id)" /></td>
							<td>{{index+1}}</td>
							<td>{{item.name}}</td>
							<td>{{item.datafrom}}</td>
							<td>{{item.time}}</td>
							<td><span @click="deleteData(index,data)">{{item.delete}}</span><span>{{item.edit}}</span></td>
						</tr>
						<tr v-else>
							<td colspan="6" style="text-align: center;">暂无数据</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				value3: false,
				checkboxModel: [],
				// 初始化全选按钮, 默认不选
				isCheckedAll: false,
				checked: '',
				data: [{
						id: '1',
						name: '河南银河铝业有限公司',
						datafrom: '采集电量',
						time: '2018-5-20到2018-6-2',
						edit: '导出',
						delete: '移除'

					},
					{
						id: '2',
						name: '河南银河铝业有限公司',
						datafrom: '采集电量',
						time: '2018-5-20到2018-6-2',
						edit: '导出',
						delete: '移除'

					},
					{
						id: '3',
						name: '河南银河铝业有限公司',
						datafrom: '采集电量',
						time: '2018-5-20到2018-6-2',
						edit: '导出',
						delete: '移除'

					}
				],
				multipleSelection: '',
			}
		},
		components: {

		},
		mounted() {
			this.dayElecQue();

		},
		computed: {

		},
		watch: {
			
		},
		methods: {
			dayElecQue() {
				let chart = this.echarts.init(document.getElementById('dayElecQue'))
				// 绘制图表
				chart.setOption({
					title: {
						text: '折线图堆叠'
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
							data: [120, 132, 101, 134, 90, 230, 210]
						},
						{
							name: '联盟广告',
							type: 'line',
							stack: '总量',
							data: [220, 182, 191, 234, 290, 330, 310]
						},
						

					]
				});

			},
			deleteData(index, data) {
				data.splice(index, 1)
			},
			checkedAll() {
				this.isCheckedAll = !this.isCheckedAll
				if(this.isCheckedAll) {
					// 全选时
					this.checkboxModel = []
					this.data.forEach(function(item) {
						this.checkboxModel.push(item.id)
					}, this)
				} else {
					this.checkboxModel = []
				}
			},
			checkedOne(id) {
				let idIndex = this.checkboxModel.indexOf(id)
				if(idIndex >= 0) {
					// 如果已经包含了该id, 则去除(单选按钮由选中变为非选中状态)
					this.checkboxModel.splice(idIndex, 1);
				} else {
					// 选中该checkbox
					this.checkboxModel.push(id)
				}
			},
		}

	}
</script>

<style scoped="scoped">
	.wrapperCon {
		width: 100%;
		height: 100%;
	}
	
	.timeBox {
		width: 100%;
		margin: 10px 0px;
		height: 30px;
		line-height: 30px;
	}
	
	.timeBox input {
		width: 15%;
		border: 1px solid #e5e5e5;
		border-radius: 5px;
		text-indent: 10px;
		font-size: 14px;
		background: #f5f5f5;
		margin-right: 10px;
	}
	
	.timeBox button {
		border: none;
		background: #37b3e0;
		color: #fff;
		padding: 0px 20px;
		margin-right: 10px;
		border-radius: 5px;
	}
	
	.dayElecQue {
		margin-top: 10px;
	}
	
	.lineBtn {
		width: 100%;
		margin: 10px 0px;
	}
	
	.lineBtn button {
		padding: 5px 20px;
		border: none;
		border-radius: 5px;
		background: #37b3e0;
		color: #fff;
		margin-right: 10px;
		font-size: 14px;
	}
	
	.tableCon {
		width: 100%;
		border: none;
	}
	
	.table thead tr {
		background: #f5f5f5;
	}
	
	.table thead tr th {
		padding: 5px 20px;
		text-align: center;
		font-size: 12px;
	}
	
	.table tbody tr td {
		padding: 5px 20px;
		text-align: center;
		font-size: 12px;
	}
	
	.table tbody tr td span {
		color: #37b3e0;
		cursor: pointer;
		margin-right: 10px;
	}
</style>