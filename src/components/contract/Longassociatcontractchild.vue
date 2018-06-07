<template>
	<div class="longAssoCon">
		<div class="mainCon">
			<div class="md" style="width:100%;margin-bottom:10px;">
				<form action="" class="form-inline" style="padding-left:20px;">
					<div class="form-group">
						年度：
						<input style="background:#f5f5f5;" type="text" class="form-control" placeholder="2017" v-model="filter">
					</div>
					<div class="form-group">
						电厂名称：
						<input type="text" class="form-control" placeholder="" v-model="filter">
					</div>
					<div class="form-group">
						状态：
						<select name="" class="form-control">
							<option value="">全部</option>
						</select>
					</div>
					<button class="btn" style="">上一年</button>
					<button class="btn">查询</button>
					<button class="btn">下一年</button>
					<div class="form-group">
						<b-button class="btn" to="/customer/create" style="background:#169bd5;" variant="success">增加长协合同</b-button>
					</div>
				</form>
			</div>
			<div class="tableCon">
				<table class="table">
					<el-table :data="tableData" :row-class-name="tableRowClassName" size="mini" style="width: 100%" :default-sort="{prop: 'date', order: 'descending'}">
						<el-table-column prop="date" label="序号" sortable width="180">
						</el-table-column>
						<el-table-column prop="name" label="合同号" sortable width="180">
						</el-table-column>
						<el-table-column prop="name" label="电厂名称" sortable width="120">
						</el-table-column>
						<el-table-column prop="name" label="年度" sortable width="80">
						</el-table-column>
						<el-table-column prop="name" label="签约电量" sortable width="120">
						</el-table-column>
						<el-table-column prop="name" label="签约日期" sortable width="120">
						</el-table-column>
						<el-table-column prop="name" label="状态" sortable width="80">
						</el-table-column>
						<el-table-column prop="address" label="地址" :formatter="formatter">
						</el-table-column>
						<el-table-column fixed="right" label="操作" width="100">
							<template slot-scope="scope">
								<el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">删除</el-button>
								<el-button type="text" size="small">编辑</el-button>
							</template>
						</el-table-column>
					</el-table>
				</table>
				
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				tableData: [{
					date: '2016-05-02',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄'
				}, {
					date: '2016-05-04',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1517 弄'
				}, {
					date: '2016-05-01',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1519 弄'
				}, {
					date: '2016-05-03',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1516 弄'
				}]
			}
		},
		mounted() {

		},
		methods: {
			formatter(row, column) {
				return row.address;
			},
			deleteRow(index, rows) {
				rows.splice(index, 1);
			},
			tableRowClassName({
				row,
				rowIndex
			}) {
				if(rowIndex === 2) {
					return 'warning-row';
				} else if(rowIndex === 3) {
					return 'success-row';
				}
				return '';
			}
		}
	}
</script>

<style scoped="scoped">
	.longAssoCon {
		margin: 20px;
		background: #fff;
	}
	
	.mainCon {
		padding: 20px 10px;
	}
	
	.btn {
		padding: 5px 25px;
		background: #37b3e0;
		margin-right: 10px;
		color: #fff;
	}
	
	.tableCon {
		width: 100%;
		padding-top: 20px;
	}
	
	.table thead tr {
		background: #f5f5f5;
	}
	
	.table thead tr th,
	.table tbody tr td {
		padding: 5px 10px;
		font-size: 12px;
	}
	
	.table tbody tr:nth-child(even) {
		background: #fff8f1
	}
	
	.el-table .warning-row {
		background: #f00;
	}
	
	.el-table .success-row {
		background: #f0f9eb;
	}
</style>