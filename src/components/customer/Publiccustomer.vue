<template>
	<div class="conWrap">
		<div class="header titleHea">
			<span>公示客户</span>
			<p><em class="iconfont">&#xe778;</em>首页：<b>客户></b><b>客户总览</b></p>
		</div>
		<div class="panel" style="background:#fff;height:90%;">
			<div class="panel-header">
				<div class="row">
					<div class="md" style="width:100%;margin-bottom:10px;">
						<form action="" class="form-inline" style="padding-left:20px;">
							<div class="form-group">
								地区：
								<input type="text" class="form-control" placeholder="河南/郑州" v-model="filter">
							</div>
							<div class="form-group">
								行业：
								<input type="text" class="form-control" placeholder="工厂" v-model="filter">
							</div>
							<div class="form-group">
								数量：
								<input type="text" class="form-control" placeholder="100" v-model="filter">
							</div>
							<button class="btn">查询</button>
						</form>
					</div>
					<div class="col-md-4" style="width:10%;">

						<!-- <b-button href="#" variant="danger">删除</b-button>-->
					</div>
				</div>
			</div>
			<div class="panel-body">
				<table id="table">
					<thead>
						<tr>
							<th>选择</th>
							<th>企业</th>
							<th>联系人</th>
							<th>联系电话</th>
							<th>添加日期</th>
						</tr>
					</thead>
					<tbody>
						<tr v-for="(item,index) in data">
							<td>
								<input name="num" style="background:none;" value="index+1" type="radio" />
							</td>
							<td v-html="item.com"></td>
							<td v-html="item.name"></td>
							<td v-html="item.tel"></td>
							<td v-html="item.date"></td>
						</tr>
					</tbody>
				</table>
				<div class="btnCon"><button class="btn skyBlu">批量分配</button></div>
				<div class="pageNa">
					<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :background='true' :current-page="currentPage" :page-sizes="[100, 200, 300, 400]" :page-size="100" layout="total, sizes, prev, pager, next, jumper" :total="400">
					</el-pagination>
				</div>
			</div>
			<div class="leftCon">
				<longBheader class="txtCon" style="padding:5px 0px;background:#66ccff;">
					<p slot="headerBar" style="margin:0px;">选择导入业务员</p>
				</longBheader>
				<div class="listsBox scrollLists">
					<div class="nameLists">
						<h6>业务一部</h6>
						<ul class="lists">
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
						</ul>
					</div>
					<div class="nameLists">
						<h6>业务一部</h6>
						<ul class="lists">
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>

						</ul>
					</div>
					<div class="nameLists">
						<h6>业务一部</h6>
						<ul class="lists">
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				radio: 1,
				currentPage: 1,
				filter: null,
				data: [{
						com: '郑州耀光电子科技有限公司',
						name: '胡建辉',
						tel: '243354365',
						date: '2018-1-20'
					},
					{
						com: '郑州耀光电子科技有限公司',
						name: '胡建辉',
						tel: '243354365',
						date: '2018-1-20'
					},
					{
						com: '郑州耀光电子科技有限公司',
						name: '胡建辉',
						tel: '243354365',
						date: '2018-1-20'
					}
				]

			}
		},
		mounted() {

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
	.conWrap {
		width: 100%;
		height: 100%;
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
	
	.btn {
		padding: 5px 30px;
		background: #169bd5;
		color: #fff;
		font-size: 12px;
	}
	
	.skyBlu {
		background: #2d8cf0;
	}
	
	#table {
		border: none;
		margin-bottom: 20px;
		width: 100%;
	}
	
	#table thead tr th {
		background: #f2f2f2;
		font-weight: normal;
		font-size: 14px;
		padding: 5px 20px;
		border-top: !important none;
		line-height: none;
	}
	
	#table thead tr th:nth-of-type(5) {
		width: 40%;
		text-align: center;
	}
	
	#table tbody tr td {
		padding: 5px 20px;
		border-top: !important none;
		line-height: none;
	}
	
	#table tbody tr td:nth-of-type(5) {
		width: 40%;
		text-align: center;
	}
	
	.btnCon {
		width: 100%;
		margin-bottom: 10px;
	}
	
	.pageNa {
		width: 100%;
		text-align: right;
		height: 30px;
		margin-bottom: 20px;
	}
	
	.leftCon {
		width: 500px;
		margin-left: 20px;
		height:300px;
		border:1px solid #dcdcdc;
	}
	
	.listsBox {
		width: 60%;
		height: 60%;
		color: #000;
		margin:10px 20px;
		border: 1px solid #dcdcdc;
	}
	
	.compLists {
		padding: 15px 18px;
	}
	
	.compLists li {
		font-size: 12px;
	}
	
	.nameLists h6 {
		font-size: 12px;
	}
	
	.lists {
		padding: 0px 18px 10px;
	}
	
	.lists li {
		font-size: 12px;
	}
	
	.scrollLists {
		overflow-y: scroll;
	}
</style>