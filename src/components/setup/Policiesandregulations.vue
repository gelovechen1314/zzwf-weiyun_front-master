<template>
	<div id="conWrap" class="panel">
		<table id="tableCon">
			<thead>
				<tr>
					<th><input type="checkbox" /></th>
					<th>序号</th>
					<th>标题</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="(item,index) in tableData">
					<td><input type="checkbox" /></td>
					<td v-html="item.num"></td>
					<td v-html="item.title"></td>
					<td><span v-html="item.change"></span><span v-html="item.delete"></span></td>
				</tr>
			</tbody>
		</table>
		<div class="pageN">
			<button class="btn">删除</button>
			<el-pagination class="pagenition" @size-change="handleSizeChange" @current-change="handleCurrentChange" :background='true' :current-page="currentPage" :page-sizes="[100, 200, 300, 400]" :page-size="100" layout="total, sizes, prev, pager, next, jumper" :total="400">
			</el-pagination>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				currentPage:1,
				tableData: [{
						num: '109',
						title: '哦订婚过上了大学改进松岛枫哈伦裤',
						change: '修改',
						delete: '删除'
					},
					{
						num: '109',
						title: '哦订婚过上了大学改进松岛枫哈伦裤',
						change: '修改',
						delete: '删除'
					},
					{
						num: '109',
						title: '哦订婚过上了大学改进松岛枫哈伦裤',
						change: '修改',
						delete: '删除'
					},
					{
						num: '109',
						title: '哦订婚过上了大学改进松岛枫哈伦裤',
						change: '修改',
						delete: '删除'
					}
				]
			}
		},
		methods: {
			handleSizeChange(val) {
				console.log('每页 ${val} 条');
			},
			handleCurrentChange(val) {
				console.log('当前页: ${val}');
			},
		}
	}
</script>

<style scoped="scoped">
	#conWrap {
		padding: 20px;
		height:98%;
		overflow-y:auto;
	}
	
	#tableCon {
		width: 100%;
		border: none;
		margin-bottom:20px;
	}
	
	#tableCon thead tr {
		background: #d7d7d7;
	}
	
	#tableCon thead tr th {
		padding: 10px 0px;
		font-weight: normal;
		color: #000;
		font-size: 12px;
		text-align: center;
	}
	
	#tableCon thead tr th:nth-of-type(3),
	#tableCon tbody tr td:nth-of-type(3) {
		text-align: left;
	}
	
	#tableCon tbody tr td {
		padding: 10px 0px;
		font-weight: normal;
		color: #000;
		font-size: 12px;
		text-align: center;
	}
	
	#tableCon tbody tr td span {
		margin: 0px 5px;
		cursor: pointer;
	}
	
	#tableCon tbody tr td:nth-of-type(4) {
		font-size: 14px;
	}
	.pageN{
		border-top:1px solid #999;
		padding:10px 0px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom:1;
	}
	.pageN:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	.btn{
		float:left;
		padding:5px 20px;
		border:1px solid #999;
		border-radius:5px;
		background:none;
		font-size:12px;
	}
	.pagenition{
		float:right;
		text-align: right;
		width:90%;
	}
</style>