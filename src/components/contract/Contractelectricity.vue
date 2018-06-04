<template>
	<div class="contentCon">
		<div class="header titleHea">
			<span>售电合同</span>
			<b-button class="btnMain" @click="showEditModal()" variant="primary">+售电合同</b-button>
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
				<el-table-column prop="data" label="查看" width="30">
					<template slot-scope="scope" class="imgBox">
						<img v-if="show" src="../../assets/images/ic_pdf1.jpg" />
						<img v-if="!show" src="../../assets/images/ic_pdf2.jpg" />
					</template>
				</el-table-column>
				<el-table-column prop="name" label="合同编号" width="90">
				</el-table-column>
				<el-table-column prop="address" label="企业名称" width="140" show-overflow-tooltip>
				</el-table-column>
				<el-table-column prop="name" label="分成比例" width="60">
				</el-table-column>
				<el-table-column prop="name" label="合同周期" width="120">
				</el-table-column>
				<el-table-column prop="name" label="合同电量" width="100">
				</el-table-column>
				<el-table-column prop="name" label="最大负荷" width="80">
				</el-table-column>
				<el-table-column prop="name" label="合同联系人及联系电话" width="150">
				</el-table-column>

				<el-table-column prop="tag" label="合同状态" width="100" :filters="[{ text: '已到期', value: '已到期' }, { text: '进行中', value: '进行中' },{ text: '未开始', value: '未开始'}]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="tag" label="绑定状态" width="100" :filters="[{ text: '未绑定', value: '未绑定' }, { text: '已绑定', value: '已绑定' },{ text: '提交中', value: '提交中'},{ text: '驳回', value: '驳回'}]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="tag" label="审批状态" width="100" :filters="[{ text: '未绑定', value: '未绑定' }, { text: '已绑定', value: '已绑定' },{ text: '提交中', value: '提交中'},{ text: '驳回', value: '驳回'}]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="tag" label="操作" width="80">
					<template slot-scope="scope">
						<el-button @click="open4(scope.$index,true)" type="text" size="small">
							备注
						</el-button>
						<el-button @click="open2()" type="text" size="small">
							审
						</el-button>
						<el-button @click="showEditModal(scope.$index)" type="text" size="small">
							修
						</el-button>
						<el-button @click.native.prevent="deleteRow(scope.$index, tableData3)" type="text" size="small">
							删
						</el-button>
					</template>
				</el-table-column>
			</el-table>

		</div>
		<div class="paginationPage">
			<div class="radioCheckBox">
				<el-checkbox v-model="checked" type="selection">全选</el-checkbox>
				<el-button type="primary" class="priBtn">绑定提交中</el-button>
				<el-button class="priBtn" type="primary">导入绑定名单</el-button>

			</div>
			<div class="pagCon">
				<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :background='true' :current-page="currentPage4" :page-sizes="[100, 200, 300, 400]" :page-size="100" layout="total, sizes, prev, pager, next, jumper" :total="400">
				</el-pagination>
			</div>
		</div>
		<!--备注弹窗-->
		<modal v-if="flag">
			<div class="modalCon" slot="content">
				<div class="titleCon">
					<b class="imgBox"><img src="../../assets/images/ic_warn.png"/></b><span>售电合同备注</span><i class="el-icon-close closeBtn" @click="close1()"></i>
				</div>
				<div class="txtCon">
					<h6>备注内容</h6>
				</div>
				<div class="beiZmsg">

				</div>
			</div>
		</modal>
		<!--修改合同弹窗-->
		<modal v-if="showEditContract">
			<div class="editContractCon" slot="content">
				<div class="editContractTit">
					<span>售电合同备注</span><i class="el-icon-close closeBtn" @click="close2()"></i>
				</div>
				<div class="formCon">
					<div class="contractPerson">
						<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
							<el-form-item label="甲方" prop="name">
								<el-input v-model="ruleForm.name"></el-input>
							</el-form-item>
							<el-form-item label="乙方" prop="name">
								<el-input v-model="ruleForm.name" :disabled='true'></el-input>
							</el-form-item>
						</el-form>
					</div>
					<div class="basicMsg">
						<div class="titleTxt">
							<h5>基本信息</h5></div>
						<div class="basicFormMsg">
							<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
								<el-form-item label="合同编号" prop="name">
									<el-input v-model="ruleForm.name"></el-input>
								</el-form-item>
								<el-form-item label="乙方" prop="name">
									<el-date-picker v-model="value6" type="daterange" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']">
									</el-date-picker>
								</el-form-item>
								<el-form-item required label="合同方式" prop="region" width="100%">
									<el-select v-model="ruleForm.region" placeholder="分成模式">
										<el-option label="保底模式" value="shanghai"></el-option>
										<el-option label="分成保底" value="beijing"></el-option>
									</el-select>
								</el-form-item>
								<el-form-item label="合同保底" prop="name">
									<el-input v-model="ruleForm.name" :disabled='true'></el-input>
								</el-form-item>
								<el-form-item label="分成比例" prop="name">
									<el-col :span="11">
										<el-form-item label="乙方" prop="name">
											<el-input v-model="ruleForm.name" ></el-input>
										</el-form-item>
									</el-col>
									<el-col :span="11">
										<el-form-item label="甲方" prop="name">
											<el-input v-model="ruleForm.name" ></el-input>
										</el-form-item>
									</el-col>
								</el-form-item>
							</el-form>
						</div>
					</div>
					<!--业务信息-->
					<div class="basicMsg">
						<div class="titleTxt">
							<h5>业务信息</h5></div>
						<div class="basicFormMsg">
							<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
								<el-form-item label="合同编号" prop="name">
									<el-input v-model="ruleForm.name"></el-input>
								</el-form-item>
								<el-form-item label="乙方" prop="name">
									<el-date-picker v-model="value6" type="daterange" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']">
									</el-date-picker>
								</el-form-item>
								<el-form-item required label="合同方式" prop="region" width="100%">
									<el-select v-model="ruleForm.region" placeholder="分成模式">
										<el-option label="保底模式" value="shanghai"></el-option>
										<el-option label="分成保底" value="beijing"></el-option>
									</el-select>
								</el-form-item>
								<el-form-item label="合同保底" prop="name">
									<el-input v-model="ruleForm.name" :disabled='true'></el-input>
								</el-form-item>
								<el-form-item label="分成比例" prop="name">
									<el-col :span="11">
										<el-form-item label="乙方" prop="name">
											<el-input v-model="ruleForm.name" ></el-input>
										</el-form-item>
									</el-col>
									<el-col :span="11">
										<el-form-item label="甲方" prop="name">
											<el-input v-model="ruleForm.name" ></el-input>
										</el-form-item>
									</el-col>
								</el-form-item>
							</el-form>
						</div>
					</div>
					<!--上传备份-->
					<div class="basicMsg">
						<div class="titleTxt">
							<h5>上传备份</h5></div>
						<div class="basicFormMsg">
							<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
								<el-form-item label="合同上传" prop="name">
											<el-input v-model="ruleForm.name" ></el-input>
										</el-form-item>
							</el-form>
						</div>
					</div>
					<div class="submitBtn">
						<el-button class="confirm" type="primary">确定</el-button><el-button @click="close2()" class="cancel" plain>取消</el-button>
					</div>
				</div>
			</div>
		</modal>
	</div>

</template>

<script>
	import "../../assets/css/com.css"
	import modal from "../common/modal/index.vue";
	export default {
		data() {
			return {
				value6: [],
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
		methods: {
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
		background:#409eff;
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
	
	.imgBox {
		width: 15px;
		height: 20px;
	}
	
	.imgBox img {
		width: 100%;
		height: 100%;
	}
	/*备注弹窗样式*/
	
	.modalCon {
		background: #fff;
		width: 50%;
		position: absolute;
		top: 0px;
		min-height: 200px;
	}
	
	.titleCon {
		width: 100%;
		height: 53px;
		line-height: 52px;
		border-bottom: 1px solid #e9eaec;
	}
	
	.titleCon span {
		display: inline-block;
		font-size: 20px;
		color: #ff9900;
		font-weight: 900;
		font-family: "微软雅黑";
	}
	
	.imgBox {
		display: inline-block;
		width: 22px;
		height: 20px;
		margin-left: 20px;
		float: left;
	}
	
	.imgBox img {
		width: 100%;
		height: 100%;
	}
	
	.closeBtn {
		font-size: 28px;
		color: #a29999;
		float: right;
		margin-top: 10px;
		margin-right: 10px;
	}
	
	.txtCon {
		padding: 20px 32px;
	}
	
	.txtCon h6 {
		font-size: 18px;
		color: #495060;
		font-family: "微软雅黑";
		font-weight: 900;
	}
	/*修改合同弹窗*/
	
	.editContractCon {
		min-height: 200px;
		width: 70%;
		background: #fff;
		position: absolute;
		top: 100px;
		height:85%;
		overflow-y: scroll;
		border-radius: 5px;
		padding-bottom: 20px;
	}
	
	.editContractTit {
		width: 100%;
		height: 53px;
		line-height: 52px;
		border-bottom: 1px solid #e9eaec;
	}
	
	.editContractTit span {
		font-size: 20px;
		color: #1c2438;
		font-family: "微软雅黑";
		margin-left: 30px;
		font-weight: 900;
	}
	
	.contractPerson {
		margin-top: 35px;
		padding-left: 164px;
		width: 60%;
	}
	
	.basicMsg {
		margin-left: 84px;
	}
	
	.titleTxt {
		height: 25px;
		padding-bottom: 5px;
		border-bottom: 1px solid #e3e8ee;
		margin-bottom: 20px;
	}
	
	.titleTxt h5 {
		font-size: 16px;
		color: #495060;
		font-weight: 900;
		font-family: "微软雅黑";
		padding-left: 20px;
	}
	
	.basicFormMsg {
		padding-left: 82px;
		width: 54%;
	}
	.submitBtn{
		width:100%;
		padding-top:15px;
		border-top:1px solid #e9eaec;
		
	}
	.cancel{
		float:right;
		margin-right:10px;
	}
	.confirm{
		float:right;
		margin-right:20px;
	}
</style>