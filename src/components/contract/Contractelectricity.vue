<template>
	<div class="contentCon">
		<div class="header titleHea">
			<span>售电合同</span>
			<b-button class="btnMain" to="/trade/addlongassociate" variant="primary">+售电合同</b-button>
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
		<div class="tableWrap">
			<el-table size="mini" class="tableTop" ref="multipleTable" :data="tableData3" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
				<el-table-column type="selection" width="55">
				</el-table-column>
				<el-table-column prop="data" label="查看" width="20">
					<!--	<template slot-scope="scope">{{ scope.row.date }}</template>-->
				</el-table-column>
				<el-table-column prop="name" label="合同编号" width="80">
				</el-table-column>
				<el-table-column prop="address" label="企业名称" width="120" show-overflow-tooltip>
				</el-table-column>
				<el-table-column prop="name" label="分成比例" width="60">
				</el-table-column>
				<el-table-column prop="name" label="合同周期" width="80">
				</el-table-column>
				<el-table-column prop="name" label="合同电量" width="80">
				</el-table-column>
				<el-table-column prop="name" label="最大负荷" width="80">
				</el-table-column>
				<el-table-column prop="name" label="合同联系人及联系电话" width="80">
				</el-table-column>

				<el-table-column prop="tag" label="合同状态" width="100" :filters="[{ text: '已到期', value: '已到期' }, { text: '进行中', value: '进行中' },{ text: '未开始', value: '未开始'}]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
			</el-table>
			<el-table-column prop="tag" label="绑定状态" width="100" :filters="[{ text: '未绑定', value: '未绑定' }, { text: '已绑定', value: '已绑定' },{ text: '提交中', value: '提交中'},{ text: '驳回', value: '驳回'}]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
			</el-table>
			<el-table-column prop="name" label="绑定状态" width="80">
			</el-table-column>
			<el-table-column prop="name" label="审批状态" width="80">
			</el-table-column>
			<el-table-column prop="name" label="操作" width="80">
			</el-table-column>
			</el-table>
		</div>
		<div class="paginationPage">
			<div class="radioCheckBox">
				 <el-checkbox v-model="checked">备选项</el-checkbox><el-button type="primary">主要按钮</el-button><el-button type="primary">主要按钮</el-button>
				 
			</div>
			<div class="pagCon">
				<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :background='true' :current-page="currentPage4" :page-sizes="[100, 200, 300, 400]" :page-size="100" layout="total, sizes, prev, pager, next, jumper" :total="400">
				</el-pagination>
			</div>
		</div>
	</div>
</template>

<script>
	import "../../assets/css/com.css"
	export default {
		data() {
			return {
				currentPage4: 4,
				checked:true,
				tableData3: [{
					date: '2016-05-03',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag:'进行中'
				}, {
					date: '2016-05-02',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag:'未开始'
				}, {
					date: '2016-05-04',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag:'已到期'
				}, {
					date: '2016-05-01',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag:'进行中'
				}, {
					date: '2016-05-08',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag:'进行中'
				}, {
					date: '2016-05-06',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag:'进行中'
				}, {
					date: '2016-05-07',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag:'进行中'
				}],
				multipleSelection: []
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
			toggleSelection(rows) {
				if(rows) {
					rows.forEach(row => {
						this.$refs.multipleTable.toggleRowSelection(row);
					});
				} else {
					this.$refs.multipleTable.clearSelection();
				}
			},
			handleSelectionChange(val) {
				this.multipleSelection = val;
			}
		}
	}
</script>

<style>
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
	
	.btnMain {
		float: right;
		height: 40px;
		margin-top: 7.5px;
		margin-right: 10px;
	}
	
	.titleHea span {
		width: 90%;
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
		border-radius: 0px;
		border-top-right-radius: 5px;
		border-bottom-right-radius: 5px;
	}
	
	.el-icon-search {
		color: #495060;
		font-weight: 900;
	}
	
	.tableWrap {
		margin: 10px 0px;
	}
	
	.tableTop {
		padding-left: 0px;
		border-top: 1px solid #e9eaec
	}
	.paginationPage{
		position:absolute;
		width:95%;
		bottom:50px;
		left:2.5%;
		
	}
	.radioCheckBox{
		width:45%;
		float:left;
	}
	.pagCon{
		width:50%;
		float:right;
	}
</style>