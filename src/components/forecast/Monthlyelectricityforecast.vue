<template>
	<div class="contentCon">
		<div class="header titleHea">
			<span>月度预测<strong>当月需购电量<i>235</i>MwH（1家企业未预测）</strong></span>
			<p><span>已审核：<b>1</b></span><span>未审核：<b>0</b></span><span>人工已预测：<b>1</b></span><span>人工未预测：<b>1</b></span><span>系统已预测：<b>1</b></span><span>系统未预测：<b>1</b></span></p>
		</div>
		<div class="searchCon">
			<p>
				<el-input style="width:100%;" placeholder="请输入内容" v-model="input23">
					<i slot="prefix" class="el-input__icon el-icon-search"></i>
				</el-input>
				<el-button class="seraBtn3" type="primary">搜索</el-button>
				<el-button type="primary" class="allCustomer active" plain>全部客户</el-button>
				<el-button type="primary" class="myCustomer" plain>我的客户</el-button>
			</p>
			<div class='div'>
				<el-date-picker style="width:120px;margin-right:10px;height:20px;background:#eaf6fe;color:#2d8cf0;" v-model="value1" type="year" placeholder="2018">
				</el-date-picker><i class="el-icon-refresh el-icon"></i><i class="el-icon-share el-icon"></i></div>
		</div>
		<div class="tablbWrap">
			<el-table :data="tableData5" size="mini" style="width: 100%;border-top:1px solid #ebeef5;">
				<el-table-column class="temp" type="expand">
					<template slot-scope="props">
						<table class="tableCon">
							<tr>
								<td>43452346437</td>
								<td>43t564</td>
								<td>4</td>
								<td>45243</td>
								<td>2346</td>
								<td>252</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>25</td>
								<td>154</td>
								<td>25</td>
								<td><span>修改</span><span>确认</span><span>修改</span></td>
							</tr>
							<tr>
								<td>43452346437</td>
								<td>43t564</td>
								<td>4</td>
								<td>45243</td>
								<td>2346</td>
								<td>23446</td>
								<td>23446</td>
								<td>25</td>
								<td>23446</td>
								<td>23446</td>
								<td>23446</td>
								<td>12</td>
								<td>154</td>
								<td><span>修改</span><span>确认</span><span>修改</span></td>
							</tr>
							<tr>
								<td>43452346437</td>
								<td>4</td>
								<td>45243</td>
								<td>23446</td>
								<td>252</td>
								<td>25fdh</td>
								<td>23446</td>
								<td>25</td>
								<td>23446</td>
								<td>23446</td>
								<td>23446</td>
								<td>154</td>
								<td>25</td>
								<td><span>修改</span><span>确认</span><span>修改</span></td>
							</tr>

						</table>

					</template>
				</el-table-column>
				<el-table-column label="客户名称" sortable width="120" prop="id">
					<template scope="scope">
						<div style="color:#4fa8f9;text-decoration:none;cursor:pointer;" @click="getMore(scope.row)">{{ scope.row.name }}</div>
					</template>
				</el-table-column>
				<el-table-column width="80" label='已购电量' sortable prop="shopId">
				</el-table-column>
				<el-table-column width="70" label='已用电量' prop="shopId">
				</el-table-column>
				<el-table-column width="90" label='本月监控电量' prop="shopId">
				</el-table-column>
				<el-table-column width="70" label='剩余电量' sortable prop="shopId">
				</el-table-column>
				<el-table-column width="90" label='下月已购电量' sortable prop="shopId">
				</el-table-column>
				<el-table-column width="90" label='下月系统预测' sortable prop="shopId">
				</el-table-column>
				<el-table-column prop="tag" label="下月人工预测" width="90" :filters="[{ text: '未审核', value: '未审核' }, { text: '已审核', value: '已审核' }]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column width="80" label='下月申报电量' prop="shopId">
				</el-table-column>
				<el-table-column width="80" label='本月需购' prop="shopId">
				</el-table-column>
				<el-table-column width="70" label='预测人' prop="shopId">
				</el-table-column>
				<el-table-column width="70" label='审核人' prop="shopId">
				</el-table-column>
				<el-table-column prop="tag" label="状态" width="70" :filters="[{ text: '未审核', value: '未审核' }, { text: '已审核', value: '已审核' }]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag style="border:none;background:none;color:#666;" disable-transitions>{{scope.row.shopId}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column label="操作" width="100px">

					<template slot-scope="scope">
						<!--<el-button @click="handleClick(scope.row)" type="text" size="small">记录</el-button>-->
						<el-button type="text" style="color:#999;" size="small">审核</el-button>
					</template>

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
				value1: '',
				currentPage4: 4,
				labelData: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
				tableData5: [{
					id: '12987122',
					name: 'gsfhdhfh',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333',
					tag: '已审核'
				}, {
					id: '12987123',
					name: '发货收到方向键',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333',
					tag: '未审核'
				}, {
					id: '12987125',
					name: '过放电是否能',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333',
					tag: '未审核'
				}, {
					id: '12987126',
					name: '好滋好味鸡蛋仔',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333',
					tag: '未审核'
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
			handleClick(row) {
				console.log(row);
			},
			filterTag(value, row) {
				return row.tag === value;
			},
		}
	}
</script>

<style scoped="scoped">
	/*@import url("../../assets/css/com.css")*/
	
	.titleHea p span {
		font-size: 12px;
		font-weight: normal;
		color: #0099ff;
	}
	
	.titleHea p span b {
		font-style: normal;
		color: #ff9900
	}
	
	.titleHea span strong {
		font-size: 10px;
	}
	
	.titleHea span strong i {
		color: #ff9900;
		font-style: normal;
		margin: 0px 5px;
	}
	
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
	
	.searchCon .div {
		display: inline-block;
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
	
	.recordBtn {
		border: none;
		background: #eaf6fe;
		font-size: 14px;
		padding: 0px 10px;
		color: #2d8cf0;
		outline: none;
	}
	
	.recordBtn:hover,
	.recordBtn:active {
		background: #c5e5fb;
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
		width: 110%;
		padding: 0px;
		margin: -20px -50px;
	}
	
	.tableCon td {
		line-height: 20px;
		padding: 6px 0px;
		width: 70px;
		text-align: center;
	}
	
	.tableCon td:nth-of-type(1) {
		width: 140px;
		text-align: center;
	}
	
	.tableCon td:nth-of-type(14) {
		width: 100px;
	}
	
	.tableCon td:nth-of-type(14) span {
		margin-right: 10px;
	}
	
	.tableCon td:nth-of-type(14) span:hover {
		cursor: pointer;
	}
	
	.el-table__expanded-cell {
		padding: 0;
	}
	
	.temp {
		padding: 0px;
	}
</style>