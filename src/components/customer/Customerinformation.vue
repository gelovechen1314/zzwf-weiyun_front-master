<template>
	<div class="contentCon">
		<div class="header titleHea">
			<span>客户列表</span>
		</div>
		<div class="searchCon">
			<p>
				<el-button class="addBtn" type="primary">
					<router-link style="color:#fff;cursor:pointer;text-decoration: none;" to="/customer/modifyconsumerinfo">+客户合同</router-link>
				</el-button>
				<el-select class="selectCon" v-model="value" placeholder="请选择">
					<el-option v-for="item in options1" :key="item.value" :label="item.label" :value="item.value">
					</el-option>
				</el-select>
				<el-input class="input" placeholder="请输入内容" v-model="input23">
					<i slot="prefix" class="el-input__icon el-icon-search"></i>
				</el-input>
				<el-button class="seraBtn" plain type="primary">搜索</el-button>
				<el-cascader class="selecArea" separator="" :options="options2" @active-item-change="handleItemChange" :props="props"></el-cascader>
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
				<el-table-column prop="address" label="企业名称" width="120" show-overflow-tooltip>
				</el-table-column>
				<el-table-column prop="name" label="分成比例" width="60">
				</el-table-column>
				<el-table-column prop="name" label="合同周期" width="100">
				</el-table-column>
				<el-table-column prop="name" label="合同电量" width="100">
				</el-table-column>
				<el-table-column prop="name" label="最大负荷" width="80">
				</el-table-column>
				<el-table-column prop="name" label="合同联系人及联系电话" width="120">
				</el-table-column>

				<el-table-column prop="tag" label="合同状态" width="100" :filters="[{ text: '已到期', value: '已到期' }, { text: '进行中', value: '进行中' },{ text: '未开始', value: '未开始'}]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="tag" label="绑定状态" width="80" :filters="[{ text: '未绑定', value: '未绑定' }, { text: '已绑定', value: '已绑定' },{ text: '提交中', value: '提交中'},{ text: '驳回', value: '驳回'}]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="tag" label="审批状态" width="100" :filters="[{ text: '未绑定', value: '未绑定' }, { text: '已绑定', value: '已绑定' },{ text: '提交中', value: '提交中'},{ text: '驳回', value: '驳回'}]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="tag" label="操作" width="140">
					<template slot-scope="scope">
						<el-button style="display:inline-block;" @click="open4(scope.$index,true)" type="text" size="small">
							备注
						</el-button>
						<router-link style="color:#409EFF;cursor:pointer;text-decoration: none;" to="/customer/modifyconsumerinfo">修改</router-link>
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
				<div class="beiZmsg" id="beiZmsg">
					<div id="wrap">
						<div class="contentWrap">
							<p><span></span><i>2018-06</i><b></b></p>
							<ul class="lists">
								<li>
									<div class="indexNum">
										<strong>1</strong><h6>大众联合</h6><strong>2018-06-07 9:46:12</strong>
									</div>
									<div class="conTxt">
										考虑到是个娘炮；是了；热过荆门市天萝卜们耐热lot说的；氯化钠门关上了口很牛逼；劳动时间；人
									</div>
								</li>
								
							</ul>
						</div>
					</div>
					<div class="con"><span>添加备注：</span><textarea id="text"></textarea><button class="btnSave">保存</button></div>
					<div class="btmBtn">
						<button class="cancelBtn" @click="close1()">取消</button><button @click="submitCon" id="sureBtn" class="sureBtn">确定</button>
					</div>
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
											<el-input v-model="ruleForm.name"></el-input>
										</el-form-item>
									</el-col>
									<el-col :span="11">
										<el-form-item label="甲方" prop="name">
											<el-input v-model="ruleForm.name"></el-input>
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
											<el-input v-model="ruleForm.name"></el-input>
										</el-form-item>
									</el-col>
									<el-col :span="11">
										<el-form-item label="甲方" prop="name">
											<el-input v-model="ruleForm.name"></el-input>
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
									<el-input v-model="ruleForm.name"></el-input>
								</el-form-item>
							</el-form>
						</div>
					</div>
					<div class="submitBtn">
						<el-button class="confirm" type="primary">确定</el-button>
						<el-button @click="close2()" class="cancel" plain>取消</el-button>
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
				listsArr:[],
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
			this.creatDiv()
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
			submitCon(){
				var txt = $("#text").val();
				if(txt==""){
					this.flag = false;
					return this.flag;
				}
				else{
					var oDate=new Date();
				}
				
					
					$("#text").value="";
					var scrollTop = oContent.offsetHeight - oWrap.offsetHeight;
					oWrap.scrollTop = scrollTop;
			},
			creatDiv() {
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

<style scoped="scoped">
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
		height: 40px;
	}
	
	.titleHea span {
		width: 90%;
	}
	
	.searchCon {
		padding: 12px;
	}
	
	.searchCon p {
		display: inline-block;
		width: 40%;
		height: 38px;
		position: relative;
	}
	
	.searchCon span {
		float: right;
	}
	
	.input {
		position: absolute;
		left: 230px;
		top: 0px;
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
	
	.seraBtn {
		position: absolute;
		background: none;
		right: -110px;
		height: 40px;
		top: 0px;
		border-radius: 0px;
		border-top-right-radius: 5px;
		border-bottom-right-radius: 5px;
	}
	
	.selecArea {
		position: absolute;
		background: none;
		right: -315px;
		height: 40px;
		top: 0px;
		border-radius: 0px;
		border-top-right-radius: 5px;
		border-bottom-right-radius: 5px;
	}
	
	.selectCon {
		position: absolute;
		left: 109px;
	}
	
	.el-input {
		width: 60%;
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
		border-radius: 5px;
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
		padding: 10px 32px;
	}
	
	.txtCon h6 {
		font-size: 18px;
		color: #495060;
		font-family: "微软雅黑";
		font-weight: 900;
	}
	
	.beiZmsg {
		/*padding: 10px 0px;*/
	}
	
	#wrap {
		height: 300px;
		overflow: hidden;
		overflow-y: auto;
		margin: 0 auto;
	}
	
	.con {
		padding: 10px 20px;
	}
	
	.con span {
		font-size: 12px;
		color: #999;
	}
	
	#text {
		width: 80%;
		height: 80px;
		border: 1px solid #dddee1;
		border-radius: 5px;
		font-size: 14px;
		color: #999;
		padding: 5px 10px;
	}
	
	#text:hover {
		border: 1px solid #2d8cf0;
	}
	
	.btnSave {
		color: #2d8cf0;
		border: none;
		background: none;
		outline: none;
		font-size: 12px;
	}
	
	.btmBtn {
		width: 100%;
		border-top: 1px solid #e9eaec;
		padding: 10px 0px;
		text-align: right;
		padding-right: 20px;
	}
	
	.btmBtn button {
		padding: 10px 20px;
		border: none;
		font-size: 14px;
	}
	
	.cancelBtn {
		color: #999;
		background: #fff;
		margin-right: 10px;
		border: 1px solid #fff;
	}
	
	.cancelBtn:hover {
		color: #2d8cf0;
		box-sizing: border-box;
		border-color: #2d8cf0;
		border-radius: 5px;
	}
	
	.sureBtn {
		background: #2d8cf0;
		color: #fff;
		border-radius: 5px;
	}
	.contentWrap{
		padding:0px 5px;
		
	}
	.contentWrap p{
		width:100%;
		line-height:20px;
		height:20px;
		
	}
	.contentWrap p span{
		display: inline-block;
		width:3%;
		height:10px;
		border-bottom:1px solid #ddd;
		float:left;
		
	}
	.contentWrap p b{
		display:inline-block;
		width:88%;
		float:right;
		height:10px;
		border-bottom:1px solid #ddd;
	}
	.contentWrap p i{
		width:8%;
		text-align: center;
		font-style:normal;
		font-size:12px;
		display: inline-block;
		float:left;
	}
	.lists{
		padding:0px 25px;
	}
	.lists li{
		width:100%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom:1;
		padding:0px 0px 10px;
	}
	.lists li:after{
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	.lists li .indexNum{
		float:left;
		margin-right: 10px;
		width:35%;
		
	}
	.lists li .indexNum strong{
		display: inline-block;
		font-weight: normal;
		font-size:12px;
		margin-right:10px;
	}
	.lists li .indexNum h6{
		display: inline-block;
		font-size:12px;
		margin-right:10px;
	}
	.lists li .conTxt{
		/*width:68%;*/
		float:right;
		font-size:12px;
	}
	
	/*修改合同弹窗*/
	
	.editContractCon {
		min-height: 200px;
		width: 70%;
		background: #fff;
		position: absolute;
		top: 100px;
		height: 85%;
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
	
	.submitBtn {
		width: 100%;
		padding-top: 15px;
		border-top: 1px solid #e9eaec;
	}
	
	.cancel {
		float: right;
		margin-right: 10px;
	}
	
	.confirm {
		float: right;
		margin-right: 20px;
	}
</style>