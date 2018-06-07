<template>
	<div class="conWrap" style="">
		<div class="header titleHea">
			<span>客户CRM</span>
			<p><em class="iconfont">&#xe778;</em>首页：<b>客户></b><b>客户总览</b></p>
		</div>
		<div class="panel" style="background:#fff;">
			<div class="panel-header">
				<div class="row">
					<div class="md" style="width:100%;margin-bottom:10px;">
						<form action="" class="form-inline" style="padding-left:20px;">
							<div class="form-group">
								<b-button to="/customer/create" style="padding:5px 25px;background:#2d8cf0;border-radius:5px;" variant="success">新增</b-button>
							</div>
							<div class="form-group">
								区域：
								<input type="text" class="form-control" placeholder="河南/郑州" v-model="filter">
							</div>
							<div class="form-group">
								名称：
								<input type="text" class="form-control" placeholder="郑州耀光" v-model="filter">
							</div>
							<div class="form-group">
								状态：
								<select name="" class="form-control">
									<option value="">未联系</option>
								</select>
							</div>
							<button class="btn btn-primary" style="padding:5px 25px;">查询</button>
						</form>
					</div>
					<div class="col-md-4" style="width:10%;">

						<!-- <b-button href="#" variant="danger">删除</b-button>-->
					</div>
				</div>
			</div>
			<div class="panel-body">
				<b-table class="tableFi" hover :items="items" :fields="fields" :current-page="currentPage" :per-page="perPage" :filter="filter" @filtered="onFiltered">
					<!--<template slot="id" slot-scope="data">
						<input @click.stop type="checkbox" :value="data.item.id" v-model="selected">
					</template>-->
					<template slot="opration" slot-scope="data">
						<b-link @click="showAddMsg=true" >添加</b-link>
						<b-link :href="'/customer/'+data.item.id">修改</b-link>
						<b-link :href="'/customer/'+data.item.id">备注</b-link>
					</template>
				</b-table>
				<b-pagination style="display: none;" :total-rows="totalRows" :per-page="perPage" v-model="currentPage" class="pager" />
				<el-pagination style="float:right;margin-bottom:20px;font-size:12px;color:#666;" @size-change="handleSizeChange" @current-change="handleCurrentChange" :background='true' :current-page="currentPage" :page-sizes="[100, 200, 300, 400]" :page-size="100" layout="total, sizes, prev, pager, next, jumper" :total="totalRows">
				</el-pagination>
			</div>
		</div>
		<!-----------添加------------>
		<div class="addCallParnter" v-if="showAddMsg">
			<div class="warningMsg">
				<p>添加联系人：客户公司也有几个联系人，可以添加</p>
				<p>修改：修改客户信息，下次预约时间等</p>
				<p>备注：修改备注信息</p>
			</div>
			<div class="formCon">
				<el-form ref="form" :model="sizeForm" label-width="150px" size="mini">
					<el-form-item required label="添加联系企业名称">
						<el-input style="width:35%;" v-model="sizeForm.name"></el-input>
					</el-form-item>
					<el-form-item required label="联系人姓名">
						<el-input style="width:35%;" v-model="sizeForm.name"></el-input>
					</el-form-item>
					<el-form-item label="联系人职务">
						<el-select style="width:35%;" v-model="sizeForm.region" placeholder="请选择联系人职务">
							<el-option label="区域一" value="shanghai"></el-option>
							<el-option label="区域二" value="beijing"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item label="联系人手机号">
						<el-input style="width:35%;" v-model="sizeForm.name"></el-input>
					</el-form-item>
					<el-form-item label="联系人固定电话">
						<el-input style="width:35%;" v-model="sizeForm.name"></el-input>
					</el-form-item>
					<el-form-item label="联系人传真号码">
						<el-input style="width:35%;" v-model="sizeForm.name"></el-input>
					</el-form-item>
					<el-form-item label="联系人邮箱地址">
						<el-input style="width:35%;" v-model="sizeForm.name"></el-input>
					</el-form-item>
					<el-form-item label="业务联系人通讯地址">
						省：
						<select class="select" v-model="UnitSelected">
							<option v-for="item in UnitList" :value="item.id">{{item.name}}</option>
						</select>
						市：
						<select class="select"  v-model="DepartmentSelected">
							<option v-for="item in DepartmentList" :value="item.id">{{item.name}}</option>
						</select>
						区：
						<select class="select"  v-model="UserSelected">
							<option v-for="item in UserList" :value="item.id">{{item.name}}</option>
						</select>
						<el-input style="width:20%;" v-model="sizeForm.name"></el-input>
						<el-input style="width:10%;" v-model="sizeForm.name"></el-input>
					</el-form-item>
					<el-form-item size="large">
						<el-button type="primary" @click="onSubmit">保存</el-button>
						<el-button @click="showAddMsg=false">取消</el-button>
					</el-form-item>
				</el-form>
			</div>
		</div>
	</div>
</template>
<script>
	var items = [{
			id: 1,
			sn: 'SN20152306',
			name: '林州市电力炭素有限公司',
			category: '工程电力',
			address: '林州市电厂路西段',
			level: '一级'
		},
		{
			id: 2,
			sn: 'SN20152305',
			name: '林州市鸿兴精密制造有限公司',
			category: '工程电力',
			address: '林州市电厂路西段',
			level: '一级'
		},
		{
			id: 2,
			sn: 'SN20152305',
			name: '林州市鸿兴精密制造有限公司',
			category: '工程电力',
			address: '林州市电厂路西段',
			level: '一级'
		}
	];
	var UnitRows = [{
			name: "1",
			id: "1"
		},
		{
			name: "2",
			id: "2"
		},
	];
	var DepartmentRows = [{
			name: "11",
			id: "1",
			pid: "1"
		},
		{
			name: "12",
			id: "2",
			pid: "1"
		},
		{
			name: "21",
			id: "3",
			pid: "2"
		},
		{
			name: "22",
			id: "4",
			pid: "2"
		}
	];
	var UserRows = [{
			name: "111",
			id: "1",
			pid: "1"
		},
		{
			name: "112",
			id: "2",
			pid: "1"
		},
		{
			name: "121",
			id: "3",
			pid: "2"
		},
		{
			name: "122",
			id: "4",
			pid: "2"
		},
		{
			name: "211",
			id: "5",
			pid: "3"
		},
		{
			name: "212",
			id: "6",
			pid: "3"
		},
		{
			name: "221",
			id: "7",
			pid: "4"
		},
		{
			name: "222",
			id: "8",
			pid: "4"
		}
	]
	export default {
		data() {
			return {
				showAddMsg:false,
				sizeForm: {
					name: '',
					region: '',
					delivery: false,

				},
				items: items,
				fields: {
					id: {
						label: '预约时间'
					},
					sn: {
						label: '客户编码',
						sortable: false
					},
					name: {
						label: '客户名称'
					},
					category: {
						label: '行业类别'
					},
					address: {
						label: '地址'
					},
					level: {
						label: '用电级别'
					},
					opration: {
						label: '操作'
					}
				},
				filter: null,
				currentPage: 1,
				perPage: 15,
				sortBy: null,
				sortDesc: false,
				totalRows: items.length,
				UnitSelected: "",
				UnitList: [],
				DepartmentSelected: "",
				DepartmentList: [],
				UserSelected: "",
				UserList: []
			}
		},
		computed: {

		},
		created: function() {
			this.UnitList = UnitRows;
			this.UnitSelected = this.UnitList.length > 0 ? this.UnitList[0].id : "";

			var val = this.UnitSelected;
			this.DepartmentList = DepartmentRows.filter(function(x) {
				return x.pid == val
			});
			this.DepartmentSelected = this.DepartmentList.length > 0 ? this.DepartmentList[0].id : "";

			val = this.DepartmentSelected;
			this.UserList = UserRows.filter(function(x) {
				return x.pid == val
			});
			this.UserSelected = this.UserList.length > 0 ? this.UserList[0].id : "";
		},
		watch: {
			UnitSelected: function(val) {
				this.DepartmentList = DepartmentRows.filter(function(x) {
					return x.pid == val
				});
				this.DepartmentSelected = this.DepartmentList.length > 0 ? this.DepartmentList[0].id : "";
			},
			DepartmentSelected: function(val) {
				this.UserList = UserRows.filter(function(x) {
					return x.pid == val
				});
				this.UserSelected = this.UserList.length > 0 ? this.UserList[0].id : "";
			}
		},
		methods: {
			onSubmit() {
				console.log('submit!');
			},
			selected() {
				alert();
			},
			handleSizeChange(val) {
				console.log('每页 ${val} 条');
			},
			handleCurrentChange(val) {
				console.log('当前页: ${val}');
			},
			onFiltered(filteredItems) {
				// Trigger pagination to update the number of buttons/pages due to filtering
				this.totalRows = filteredItems.length
				this.currentPage = 0
			}
		}
	}
</script>
<style scoped>
	.conWrap {
		height: 100%;
		overflow: auto;
	}
	.panel{
		height:90%;
	}
	
	.titleHea {
		padding: 0px;
		height: 58px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
	}
	
	.titleHea:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.titleHea span {
		display: inline-block;
		padding: 0px 20px;
		line-height: 58px;
		width: 140px;
		border-bottom: 2px solid #0099ff;
	}
	
	.titleHea p {
		display: block;
		float: right;
		text-align: right;
		width: 80%;
		line-height: 58px;
		font-size: 14px;
	}
	
	.titleHea p b {
		font-weight: normal;
	}
	
	.tableFi thead tr {
		background: #f2f2f2;
	}
	
	.addCallParnter {
		width: 100%;
		padding-top: 50px;
	}
	
	.warningMsg {
		padding: 10px 20px;
	}
	
	.warningMsg p {
		font-size: 12px;
		margin: 0px;
		color: #666;
	}
	
	.formCon {
		padding: 20px 20px 20px 70px ;
	}
	
	.select {
		width: 16%;
		border: 1px solid #dddee1;
		color: #999;
		font-size: 12px;
		border-radius:5px;
		padding:5px;
		outline: none;
		
	}
	.select:active,
	.select:hover
	{
		border:1px solid #3399ff;
	}
</style>