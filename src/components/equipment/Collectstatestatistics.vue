<template>
	<div class="contentCon">
		<div class="header titleHea">
			<span>设备统计日志</span>
		</div>
		<div class="searchCon">
			<p>
				<el-input style="width:100%;" placeholder="请输入内容" v-model="input23">
					<i slot="prefix" class="el-input__icon el-icon-search"></i>
				</el-input>
				<el-button class="seraBtn4" type="primary">搜索</el-button>
			</p>
			<span><el-checkbox v-model="checked" style="font-size:12px;margin-right:10px;">仅显示已掉线设备</el-checkbox> <i class="el-icon-refresh el-icon"></i></span>
		</div>
		<div class="tablbWrap">
			<el-table :data="tableData" size='mini' style="width: 100%;border-top:1px solid #e9eaec" :default-sort="{prop: 'date', order: 'descending'}">
				<el-table-column  prop="comname" label="公司名称">
					<template scope="scope">
						<div style="color:#4fa8f9;text-decoration:none;cursor:pointer;" @click="getMore(scope.row)">{{ scope.row.comname }}</div>
					</template>
					
				</el-table-column>
				<el-table-column prop="address" sortable label="逻辑地址" :formatter="formatter">
					<template scope="scope">
						<div style="color:#4fa8f9;text-decoration:none;cursor:pointer;" @click="getMore(scope.row)">{{ scope.row.address }}</div>
					</template>
				</el-table-column>
				<el-table-column prop="address" sortable label="生产厂家">
				</el-table-column>
				<el-table-column prop="address" sortable label="登录IP端口：">
				</el-table-column>
				<el-table-column prop="date" label="最新上线时间" sortable width="80">
				</el-table-column>
				<el-table-column prop="date" label="当前在线时长" sortable width="80">
				</el-table-column>
				<el-table-column prop="date" label="合计在线时长" sortable width="180">
				</el-table-column>
				<el-table-column prop="date" label="当前状态" sortable width="180">
				</el-table-column>
				<el-table-column prop="date" label="掉线时间" sortable width="80">
				</el-table-column>
				<el-table-column prop="name" label="采集成功率" sortable width="80">
				</el-table-column>
				<el-table-column prop="name" label="上线比率" sortable width="80">
				</el-table-column>

			</el-table>
		</div>
		<div class="panginatoinPage">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :background='true' :current-page="currentPage4" :page-sizes="[100, 200, 300, 400]" :page-size="100" layout="total, sizes, prev, pager, next, jumper" :total="400">
			</el-pagination>
		</div>

	</div>
</template>

<script>
	import "../../assets/css/com.css"
	export default {
		data() {
			return {
				checked:false,
				currentPage4: 4,
				value1: '',
				modal1: false,
				labelData: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
				tableData: [{
					comname: '河南众企联合售电有限公司',
					date: '2016-05-02',
					name: '王小虎',
					address: '1236575468'
				}, {
					comname: '河南众企联合售电有限公司',
					date: '2016-05-04',
					name: '王小虎',
					address: '236575468'
				}, {
					comname: '河南众企联合售电有限公司',
					date: '2016-05-01',
					name: '王小虎',
					address: '36575468'
				}, {
					comname: '河南众企联合售电有限公司',
					date: '2016-05-03',
					name: '王小虎',
					address: '6575468'
				}]
			}
		},
		methods: {

			handleSizeChange(val) {
				console.log('每页 ${val} 条');
			},
			handleCurrentChange(val) {
				console.log('当前页: ${val}');
			},
			formatter(row, column) {
				return row.address;
			},
			getMore(row) {
				console.log(row)
			}
		}
	}
</script>

<style scoped="scoped">
	/*@import url("../../assets/css/com.css")*/
	
	.contentCon {
		margin: 10px;
		background: #fff;
		height: 98%;
		border: .5px solid #e9eaec;
		padding-bottom: 100px;
		overflow-y: scroll;
		position: relative;
	}
	
	.contentCon:hover {
		box-shadow: 0px 0px 5px 1px #ccc;
	}
	
	.searchCon {
		padding: 12px;
	}
	
	.searchCon p {
		display: inline-block;
		width: 30%;
		height: 38px;
		position: relative;
	}
	
	.searchCon span {
		float: right;
		height: 40px;
		line-height: 40px;
	}
	
	.el-icon {
		color: #2d8cf0;
		font-size: 20px;
		font-weight: 900;
		padding: 5px;
		background: #eaf6fe;
		border-radius: 5px;
	}
	
	.el-icon-refresh {
		margin-right: 10px;
	}
	
	.seraBtn4 {
		position: absolute;
		right: 0px;
		height: 40px;
		top: 0px;
		border-radius: 0px;
		border-top-right-radius: 5px;
		border-bottom-right-radius: 5px;
	}
	
	.allCustomer {
		position: absolute;
		right: -100px;
		height: 40px;
		top: 0px;
		border-radius: 0px;
	}
	
	.active {
		color: #fff;
		background-color: #409EFF;
		border-color: #409EFF;
	}
	
	.myCustomer {
		position: absolute;
		right: -198px;
		height: 40px;
		top: 0px;
		border-radius: 0px;
	}
	
	.el-icon-search {
		color: #495060;
		font-weight: 900;
	}
	
	.tablbWrap {
		margin: 10px 0px 20px;
		height: 80%;
	}
	
	.el-table thead {
		border-top: 1px solid #e9eaec
	}
	
	.el-table td,
	.el-table th.is-leaf {
		border-top: 1px solid #e9eaec
	}
	
	.tableTop {
		padding-left: 0px;
		border-top: 1px solid #e9eaec
	}
	
	.tableTop .hover_row {
		background: #ebf7ff
	}
	
	.el-table td,
	.el-table th {
		/*padding-top: 0px !important;
		padding-bottom: 0px !important;
		padding-left: 12px !important;*/
	}
	
	.panginatoinPage {
		width: 100%;
		position: absolute;
		bottom: 10px;
		margin: 10px auto;
		text-align: center;
	}
	
	.demo-table-expand {
		font-size: 0;
	}
	
	.demo-table-expand label {
		width: 90px;
		color: #99a9bf;
	}
	
	.demo-table-expand .el-form-item {
		margin-right: 0;
		margin-bottom: 0;
		width: 50%;
	}
	
	.tableCon {
		width: 100%;
		padding: 0px;
		margin: -20px -50px;
	}
	
	.tableCon td {
		line-height: 20px;
		padding: 6px 10px;
		width: 100px;
	}
	
	.el-table__expanded-cell {
		padding: 0;
	}
	
	.temp {
		padding: 0px;
	}
</style>