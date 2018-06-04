<template>
	<div class="contentCon">
		<div class="header titleHea">
			<span>电厂发电计划</span>
		</div>
		<div class="searchCon">
			<p>
				<el-input placeholder="请输入内容" v-model="input23">
					<i slot="prefix" class="el-input__icon el-icon-search"></i>
				</el-input>
				<el-button class="seraBtn" type="primary">搜索</el-button>
			</p>
			<span><i class="el-icon-refresh el-icon"></i><i class="el-icon-share el-icon"></i></span>
		</div>
		<div class="tablbWrap">
			<el-table size="mini" row-class-name="rowTr" class="tableTop" :data="tableData" style="width: 100%" :default-sort="{prop: 'date', order: 'descending'}" >
				<el-table-column   prop="date" label="电厂名称" :formatter="formatter" sortable width="230">
				</el-table-column>
				<el-table-column prop="name" label="一月" width="65">
				</el-table-column>
				<el-table-column prop="name" label="二月" width="65">
				</el-table-column>
				<el-table-column prop="name" label="三月"width="65" >
				</el-table-column>
				<el-table-column prop="name" label="四月" width="65">
				</el-table-column>
				<el-table-column prop="name" label="五月"width="65" >
				</el-table-column>
				<el-table-column prop="name" label="六月"width="65" >
				</el-table-column>
				<el-table-column prop="name" label="七月"width="65" >
				</el-table-column>
				<el-table-column prop="name" label="八月"width="65" >
				</el-table-column>
				<el-table-column prop="name" label="九月"width="65" >
				</el-table-column>
				<el-table-column prop="name" label="十月"width="65" >
				</el-table-column>
				<el-table-column prop="name" label="十一月"width="60" >
				</el-table-column>
				<el-table-column prop="name" label="十二月"width="65" >
				</el-table-column>
				<el-table-column prop="sum" label="合计"width="65" >
				</el-table-column>
				<el-table-column prop="sum" label="签约电量"width="65" >
				</el-table-column>
				<el-table-column prop="sum" label="签约价格"width="70" >
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
				currentPage4: 4,
				labelData:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
				tableData: [{
					date: '2016-05-02',
					name: '王小虎',
					sum:"2323",
					address: '上海市普陀区金沙江路 1518 弄'
				}, {
					date: '2016-05-04',
					name: '王小虎',
					sum:"2323",
					address: '上海市普陀区金沙江路 1517 弄'
				}, {
					date: '2016-05-01',
					name: '王小虎',
					sum:"2323",
					address: '上海市普陀区金沙江路 1519 弄'
				}, {
					date: '2016-05-03',
					name: '王小虎',
					sum:"2323",
					address: '上海市普陀区金沙江路 1516 弄'
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
			}
		}
	}
</script>

<style scoped="scoped">
	/*@import url("../../assets/css/com.css")*/
	
	.contentCon {
		margin: 10px;
		background: #fff;
		height:98%;
		border: .5px solid #e9eaec;
		padding-bottom:100px;
		overflow-y:scroll;
		position:relative;
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
	
	.seraBtn {
		position: absolute;
		right: 0px;
		height: 40px;
		top: 0px;
		background:#409eff;
		border-radius: 0px;
		border-top-right-radius: 5px;
		border-bottom-right-radius: 5px;
	}
	
	.el-icon-search {
		color: #495060;
		font-weight: 900;
	}
	
	.tablbWrap {
		margin: 10px 0px 20px;
		height:80%;
	}
	
	.el-table thead {
		border-top: 1px solid #e9eaec
	}
	
	.el-table td,
	.el-table th.is-leaf {
		border-top: 1px solid #e9eaec
	}
	.tableTop{
		padding-left:0px;
		border-top: 1px solid #e9eaec
	}
	.tableTop .hover_row{
		background:#ebf7ff
	}
	.el-table td, .el-table th{
		padding-top:0px !important ;
		padding-bottom:0px !important ;
		padding-left:12px !important;
	}
	.panginatoinPage{
		width:100%;
		position: absolute;
		bottom:10px;
		margin:10px auto;
		text-align: center;
	}
	
</style>