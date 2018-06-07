<template>
	<div class="contentCon">
		<div class="header titleHea">
			<span>年度预测</span>
		</div>
		<div class="searchCon">
			<p>
				<el-input style="width:100%;"  placeholder="请输入内容" v-model="input23">
					<i slot="prefix" class="el-input__icon el-icon-search"></i>
				</el-input>
				<el-button class="seraBtn3" type="primary">搜索</el-button>
				<el-button type="primary" class="allCustomer active" plain>全部客户</el-button>
				<el-button type="primary" class="myCustomer" plain>我的客户</el-button>
			</p>
			<span><i class="el-icon-refresh el-icon"></i><i class="el-icon-share el-icon"></i></span>
		</div>
		<div class="tablbWrap">
			<el-table :data="tableData5" size="mini"  style="width: 100%;border-top:1px solid #ebeef5;">
				<el-table-column class="temp" type="expand">
					<template   slot-scope="props">
						<table class="tableCon">
							<tr>
								<td rowspan='3'>43452346437</td>
								<td>合计</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
								<td>45243</td>
								<td>2346</td>
								<td>2345</td>
								<td>252</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>12</td>
								<td>154</td>
							</tr>
							<tr>
								<td>长协</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
								<td>45243</td>
								<td>2346</td>
								<td>2345</td>
								<td>252</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>12</td>
								<td>154</td>
							</tr>
							<tr>
								<td>月竟</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
								<td>45243</td>
								<td>2346</td>
								<td>2345</td>
								<td>436</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>12</td>
								<td>154</td>
							</tr>
							<tr>
								<td rowspan='3'>43452346437</td>
								<td>合计</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
								<td>45243</td>
								<td>2346</td>
								<td>2345</td>
								<td>252</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>12</td>
								<td>154</td>
							</tr>
							<tr>
								<td>长协</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
								<td>45243</td>
								<td>2346</td>
								<td>2345</td>
								<td>252</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>12</td>
								<td>154</td>
							</tr>
							<tr>
								<td>月竟</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
								<td>45243</td>
								<td>2346</td>
								<td>2345</td>
								<td>436</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>12</td>
								<td>154</td>
							</tr>
						</table>

					</template>
				</el-table-column>
				<el-table-column label="客户名称" sortable prop="id">
				</el-table-column>
				<el-table-column v-for="item in labelData" v-modal="item"  width="60" label='item' prop="shopId">
				</el-table-column>
				<el-table-column label="匹配电厂" prop="desc">
				</el-table-column>
				<el-table-column label="合计" prop="shopId">
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
				labelData: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
				tableData5: [{
					id: '12987122',
					name: 'gsfhdhfh',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333'
				}, {
					id: '12987123',
					name: '发货收到方向键',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333'
				}, {
					id: '12987125',
					name: '过放电是否能',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333'
				}, {
					id: '12987126',
					name: '好滋好味鸡蛋仔',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333'
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
	
	.seraBtn3 {
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
		margin:-20px -50px;
		
	}
	.tableCon  td{
		line-height:20px;
		padding:6px 10px;
		width:100px;
	}
	
	.el-table__expanded-cell{
		padding: 0;
	}
	.temp{
		padding:0px;
	}
</style>