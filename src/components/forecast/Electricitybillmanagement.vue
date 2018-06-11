<template>
	<div class="contentCon">
		<div class="header titleHea">
			<span style="width:18%;">电费单管理</span>
			<p style="width:80%;"><span>已审核：<b>1</b></span><span>未审核：<b>0</b></span><span>人工已预测：<b>1</b></span><span>人工未预测：<b>1</b></span><span>系统已预测：<b>1</b></span><span>系统未预测：<b>1</b></span></p>
		</div>
		<div class="searchCon">
			<p>
				<el-select class="selectCon" v-model="value" placeholder="企业名称">
					<el-option v-for="item in options1" :key="item.value" :label="item.label" :value="item.value">
					</el-option>
				</el-select>
				<el-input class="input" placeholder="请输入内容" v-model="input23">
					<i slot="prefix" class="el-input__icon el-icon-search"></i>
				</el-input>
				<el-button class="seraBtn5" plain type="primary">搜索</el-button>
				
			</p>
			<div class='div'>
				<el-date-picker style="width:120px;margin-right:10px;height:20px;background:#eaf6fe;color:#2d8cf0;" v-model="value1" type="year" placeholder="2018">
				</el-date-picker><i class="el-icon-refresh el-icon"></i><i class="el-icon-share el-icon"></i></div>
		</div>
		<div class="tablbWrap">
			<el-table size="mini" class="tableTop" ref="multipleTable" :data="tableData3" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
				<el-table-column type="selection" width="55">
				</el-table-column>
				<el-table-column type="expand">
					<template slot-scope="props">
						<el-form label-position="left" inline class="demo-table-expand">
							<table class="tableCon">
								<tr>
									<td>43452346437</td>
									<td>43t564</td>
									<td>25</td>
									<td>25</td>
									<td>25</td>
									<td><input @blur="focusState = false" v-focus="focusState" type="text" ref="inpt" v-bind:value="inptDefault" v-on:blur="changeCount()"><i class="el-icon-edit" @click="focusclick"></i></td>
									<td>25</td>
									<td>12</td>
									<td>154</td>
									<td>25</td>
									<td><span>记录</span><span>备注</span>
										<span>审核</span><span>删除</span></td>
								</tr>
								<tr>
									<td>43452346437</td>
									<td>43t564</td>
									<td>23446</td>
									<td>25</td>
									<td>23446</td>
									<td><input @blur="focusState = false" v-focus="focusState" type="text" ref="inpt" v-bind:value="inptDefault" v-on:blur="changeCount()"><i class="el-icon-edit" @click="focusclick"></i></td>
									<td>23446</td>
									<td>12</td>
									<td>154</td>
									<td>25</td>
										<td><span>记录</span><span>备注</span>
										<span>审核</span><span>删除</span></td>
								</tr>
								<tr>
									<td>43452346437</td>
									<td>43t564</td>
									<td>4</td>
									<td>23446</td>
									<td>25</td>
									<td><input @blur="focusState = false" v-focus="focusState" type="text" ref="inpt" v-bind:value="inptDefault" v-on:blur="changeCount()"><i class="el-icon-edit" @click="focusclick"></i></td>
									<td>23446</td>
									<td>23446</td>
									<td>154</td>
									<td>25</td>
										<td><span>记录</span><span>备注</span>
										<span>审核</span><span>删除</span></td>
								</tr>

							</table>

						</el-form>
					</template>
				</el-table-column <el-table-column prop="name" label="客户名称" sortable width="150">
				</el-table-column>
				<el-table-column prop="address" label="历史电量" width="120" show-overflow-tooltip>
				</el-table-column>
				<el-table-column prop="name" label="总有功电量" width="100">
				</el-table-column>
				<el-table-column prop="name" label="电量缴费" width="100">
				</el-table-column>
				<el-table-column prop="name" label="基本电费" width="100">
				</el-table-column>
				<el-table-column prop="name" label="力调电费" width="80">
				</el-table-column>
				<el-table-column prop="name" label="抄表日期" width="80">
				</el-table-column>
				<el-table-column prop="name" label="提报人" width="120">
				</el-table-column>
				<el-table-column prop="tag" label="状态" width="80" :filters="[{ text: '未绑定', value: '未绑定' }, { text: '已绑定', value: '已绑定' },{ text: '提交中', value: '提交中'},{ text: '驳回', value: '驳回'}]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="name" label="审核人" width="80">
				</el-table-column>
				<el-table-column prop="tag" label="操作" width="140">
					<template slot-scope="scope">
						<el-button style="display:inline-block;" @click="open4(scope.$index,true)" type="text" size="small">
							备注
						</el-button>
						<router-link style="color:#409EFF;cursor:pointer;text-decoration: none;" to="/customer/modifyconsumerinfo">审核</router-link>
						<el-button style="display:inline-block;" @click="open2()" type="text" size="small">
							删除
						</el-button>
					</template>
				</el-table-column>
			</el-table>
		</div>
		<div class="paginationPage">
			<div class="radioCheckBox">
				<el-checkbox v-model="checked" type="selection">全选</el-checkbox>
				<el-button type="primary" class="priBtn">批量删除</el-button>
				<el-button class="priBtn" type="primary">批量审核</el-button>

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
	import modal from "../common/modal/index.vue"
	export default {
		data() {
			return {
				focusState: false,
				input23: '',
				inptDefault: '123',
				value1: '',
				listsArr: [],
				options1: [{
					value: '选项1',
					label: '黄金糕'
				}, {
					value: '选项2',
					label: '双皮奶'
				}, {
					value: '选项3',
					label: '蚵仔煎'
				}, {
					value: '选项4',
					label: '龙须面'
				}, {
					value: '选项5',
					label: '北京烤鸭'
				}],
				value: '',
				value6: [],
				options2: [{
					label: '江苏',
					cities: []
				}, {
					label: '浙江',
					cities: []
				}],
				props: {
					value: 'label',
					children: 'cities'
				},
				selectedOptions: [],
				selectedOptions2: [],
				ruleForm: {
					name: '',
					region: '',

				},
				rules: {
					name: [{
							required: true,
							message: '请输入活动名称',
							trigger: 'blur'
						},
						{
							min: 3,
							max: 5,
							message: '长度在 3 到 5 个字符',
							trigger: 'blur'
						}
					],
				},
				flag: false,
				showEditContract: false,
				show: true,
				currentPage4: 4,
				checked: true,
				tableData3: [{
					date: '2016-05-03',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag: '进行中',
					id: '1'
				}, {
					date: '2016-05-02',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag: '未开始',
					id: '2'
				}, {
					date: '2016-05-04',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag: '已到期',
					id: '3'
				}, {
					date: '2016-05-01',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag: '进行中',
					id: '4'
				}, {
					date: '2016-05-08',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag: '进行中',
					id: '5'
				}, {
					date: '2016-05-06',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag: '进行中',
					id: '6'
				}, {
					date: '2016-05-07',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄',
					tag: '进行中',
					id: '7'
				}],
				multipleSelection: []
			}
		},
		components: {
			modal,

		},
		mounted() {

		},
		computed: {
			close1() {
				this.flag = false;
				return this.flag;
			},
			close2() {
				this.showEditContract = false;
				return this.showEditContract;
			}
		},
		//自定义指令
		directives: {
			focus: {
				update: function(el, {
					value
				}) {
					if(value) {
						el.focus()
					}
				}
			}
		},
		wacth: {
			
		},
		methods: {
			changeCount: function() {
				this.inptDefault=this.$refs.inpt.value;
			},
			focusclick() {
				this.focusState = true;
			},
			submitCon() {
				var txt = $("#text").val();
				if(txt == "") {
					this.flag = false;
					return this.flag;
				} else {
					var oDate = new Date();
				}

				$("#text").value = "";
				var scrollTop = oContent.offsetHeight - oWrap.offsetHeight;
				oWrap.scrollTop = scrollTop;
			},

			handleItemChange(val) {
				console.log('active item:', val);
				setTimeout(_ => {
					if(val.indexOf('江苏') > -1 && !this.options2[0].cities.length) {
						this.options2[0].cities = [{
							label: '南京'
						}];
					} else if(val.indexOf('浙江') > -1 && !this.options2[1].cities.length) {
						this.options2[1].cities = [{
							label: '杭州'
						}];
					}
				}, 300);
			},
			open4(index, flag) {
				this.flag = flag;
			},
			showEditModal(index) {
				this.showEditContract = true;
			},
			open2() {
				this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					this.$message({
						type: 'success',
						message: '删除成功!'
					});
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					});
				});
			},
			deleteRow(index, rows) {
				rows.splice(index, 1);
			},
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
		width: 70%;
		height: 38px;
		/*position: relative;*/
	}
	
	.searchCon .div {
		float: right;
	}
	
	.input {
		float: left;
		display: inline-block;
		width: 15%;
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
	
	.addBtn {
		position: absolute;
		left: 0px;
		height: 40px;
		top: 0px;
		border-radius: 0px;
		border-top-left-radius: 5px;
		border-bottom-left-radius: 5px;
	}
	
	.recordBtn {
		border: none;
		background: #eaf6fe;
		font-size: 14px;
		padding: 5px 10px;
		color: #2d8cf0;
		margin-right: 10px;
		outline: none;
	}
	
	.recordBtn:hover,
	.recordBtn:active {
		background: #c5e5fb;
	}
	
	.seraBtn5 {
		float: left;
		border-radius: 0px;
		border-top-right-radius: 5px;
		border-bottom-right-radius: 5px;
	}
	
	.selecArea {
		float: left;
		width: 15%;
		display: inline-block;
		border-radius: 0px;
		border-top-right-radius: 5px;
		border-bottom-right-radius: 5px;
	}
	
	.selectCon {
		float: left;
		width: 15%;
		color: #2d8cf0;
		display: inline-block;
	}
	
	.el-input {
		width: 30%;
	}
	
	.el-icon-search {
		color: #495060;
		font-weight: 900;
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
	
	.paginationPage {
		position: absolute;
		width: 95%;
		bottom: 50px;
		left: 2.5%;
	}
	
	.radioCheckBox {
		width: 45%;
		float: left;
	}
	
	.pagCon {
		width: 50%;
		float: right;
	}
	
	.priBtn {
		margin-left: 10px;
	}
	
	
		.tableCon {
			width: 110%;
			padding: 0px;
			margin: -20px -50px;
	}
	
	.tableCon td {
		line-height: 20px;
		padding: 6px 0px;
		width:90px;
		text-align: center;
	}
	
	.tableCon td:nth-of-type(1) {
		width: 170px;
		text-align: center;
	}
	
	.tableCon td input {
		width: 60px;
		border: none;
	}
	
	.tableCon td:nth-of-type(11) {
		width: 60px;
	}
	
	.tableCon td:nth-of-type(11) span {
		margin-right: 5px;
		color:#409EFF;
	}
	
	.tableCon td:nth-of-type(11) span:hover {
		cursor: pointer
	}
	
	.el-icon-edit {
		margin-left: 0px;
	}
	
	.el-icon-edit:hover {
		cursor: pointer;
		color: #257edc
	}
</style>