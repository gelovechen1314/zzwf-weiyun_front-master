<template>
	<div class="contentCon">
		<div class="headerCon">
			<a href="/trade/longassociatmanagement"><i class="el-icon-arrow-left"></i><span>返回</span></a>
			<h5>添加长协合同</h5>
		</div>
		<div class="formCon">
			<form>
				<div class="main">
					<h6>基本信息</h6>
					<div class="mainCon">
						<div class="leftFrom">
							<el-form :label-position="right" label-width="80px" size="mini" :model="formLabelAlign">
								<el-form-item label="合同编号" :rules="[
						      { required: true, message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item required='true' label="签约电厂">
									<el-select v-model="formLabelAlign.region" placeholder="签约电厂">
										<el-option label="区域一" value="shanghai"></el-option>
										<el-option label="区域二" value="beijing"></el-option>
									</el-select>
								</el-form-item>
								<el-form-item required='true' label="合同状态">
									<el-select v-model="formLabelAlign.region" placeholder="合同状态">
										<el-option label="区域一" value="shanghai"></el-option>
										<el-option label="区域二" value="beijing"></el-option>
									</el-select>
								</el-form-item>
								<el-form-item label="签约价格" :rules="[
						      { required: true, message: '价格不能为空'},
						      { type: 'number', message: '价格必须为字符串'}
						    ]">
									<el-input v-model="formLabelAlign.name"></el-input>
								</el-form-item>
							</el-form>
						</div>
						<div class="rightForm">
							<el-form :label-position="right" label-width="80px" size="mini" :model="formLabelAlign">
								<el-form-item label="合同编号" :rules="[
						      { required: true, message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item required='true' label="签约电厂">
									<el-select v-model="formLabelAlign.region" placeholder="签约电厂">
										<el-option label="区域一" value="shanghai"></el-option>
										<el-option label="区域二" value="beijing"></el-option>
									</el-select>
								</el-form-item>
								<el-form-item required='true' label="合同状态">
									<el-select v-model="formLabelAlign.region" placeholder="合同状态">
										<el-option label="区域一" value="shanghai"></el-option>
										<el-option label="区域二" value="beijing"></el-option>
									</el-select>
								</el-form-item>
								<el-form-item label="签约价格" :rules="[
						      { required: true, message: '价格不能为空'},
						      { type: 'number', message: '价格必须为字符串'}
						    ]">
									<el-input v-model="formLabelAlign.name"></el-input>
								</el-form-item>
							</el-form>
						</div>
					</div>
				</div>

				<div class="main">
					<h6>联系信息</h6>
					<div class="mainCon">
						<div class="leftFrom">
							<el-form :label-position="right" label-width="80px" size="mini" :model="formLabelAlign">
								<el-form-item label="合同编号" :rules="[
						      { required: true, message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item required='true' label="签约电厂">
									<el-select v-model="formLabelAlign.region" placeholder="签约电厂">
										<el-option label="区域一" value="shanghai"></el-option>
										<el-option label="区域二" value="beijing"></el-option>
									</el-select>
								</el-form-item>
								<el-form-item required='true' label="合同状态">
									<el-select v-model="formLabelAlign.region" placeholder="合同状态">
										<el-option label="区域一" value="shanghai"></el-option>
										<el-option label="区域二" value="beijing"></el-option>
									</el-select>
								</el-form-item>
								<el-form-item label="签约价格" :rules="[
						      { required: true, message: '价格不能为空'},
						      { type: 'number', message: '价格必须为字符串'}
						    ]">
									<el-input v-model="formLabelAlign.name"></el-input>
								</el-form-item>
							</el-form>
						</div>
						<div class="rightForm">
							<el-form :label-position="right" label-width="80px" size="mini" :model="formLabelAlign">
								<el-form-item label="合同编号" :rules="[
						      { required: true, message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item required='true' label="签约电厂">
									<el-select v-model="formLabelAlign.region" placeholder="签约电厂">
										<el-option label="区域一" value="shanghai"></el-option>
										<el-option label="区域二" value="beijing"></el-option>
									</el-select>
								</el-form-item>
								<el-form-item required='true' label="合同状态">
									<el-select v-model="formLabelAlign.region" placeholder="合同状态">
										<el-option label="区域一" value="shanghai"></el-option>
										<el-option label="区域二" value="beijing"></el-option>
									</el-select>
								</el-form-item>
								<el-form-item label="签约价格" :rules="[
						      { required: true, message: '价格不能为空'},
						      { type: 'number', message: '价格必须为字符串'}
						    ]">
									<el-input v-model="formLabelAlign.name"></el-input>
								</el-form-item>
							</el-form>
						</div>
					</div>
				</div>
				<div class="main">
					<h6>电子合同备查</h6>
					<div class="mainCon">
						<el-form :inline="true" size="mini" :model="formInline" class="demo-form-inline">
							<el-form-item required='true' label="合同上传">

							</el-form-item>
							<el-form-item>
								<el-upload class="upload-demo" ref="upload" action="https://jsonplaceholder.typicode.com/posts/" :on-preview="handlePreview" :on-remove="handleRemove" :file-list="fileList" :auto-upload="false" accept=".pdf">
									<el-input v-model="formInline.user" placeholder="请选择文件"></el-input>
									<el-button class="rightBtn" size="small" type="primary">点击上传</el-button>
									<div slot="tip" class="el-upload__tip">只能上传pdf文件，且不超过500kb</div>
								</el-upload>
							</el-form-item>
						</el-form>
					</div>
				</div>
				<div class="main">
					<h6>电子合同备查</h6>
					<p><span v-for="item in arr" v-html="item"></span></p>
					<p>
						<input v-for="item in data" v-html="" placeholder="-"/>
					</p>
					<div class="btnCon">
						<el-button class="btnB" type="primary">保存并继续添加</el-button>
						<el-button class="btnB"  type="primary">保存</el-button>
						<el-button class="btnB"  plain>取消</el-button>
					</div>
				</div>
			</form>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				labelPosition: 'right',
				date1: '',
				formInline: {
					user: '',
					region: ''
				},
				arr:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月','合计'],
				formLabelAlign: {
					name: '',
					region: '',
					type: '',
					date1: '',
					date2: '',
				},
				data:13,
				fileList: [],

			}
		},
		methods: {
			submitUpload() {
				this.$refs.upload.submit();
			},
			handleRemove(file, fileList) {
				console.log(file, fileList);
			},
			handlePreview(file) {
				console.log(file);
			}
		}
	}
</script>

<style scoped="scoped">
	.contentCon {
		margin: 10px;
		border: .5px solid #e9eaec;
		background: #fff;
		height: 100%;
		overflow-y: scroll;
	}
	
	.contentCon:hover {
		box-shadow: 0px 0px 5px 1px #ccc;
	}
	
	.headerCon {
		width: 100%;
		height: 56px;
		border-bottom: 1px solid #e9eaec;
	}
	
	.el-icon-arrow-left {
		font-size: 18px;
		color: #4e5060;
		font-weight: 900;
		margin-left: 15px;
		line-height: 56px;
	}
	
	.headerCon span {
		font-size: 14px;
		color: #5f656e;
		display: inline-block;
		line-height: 54px;
	}
	
	.headerCon h5 {
		display: inline-block;
		margin-left: 20px;
		font-family: "微软雅黑";
		color: #495060;
		font-size: 20px;
	}
	
	.formCon {
		margin: 10px 20px 10px 15%;
	}
	
	.main {
		padding: 10px 0px;
	}
	
	.main h6 {
		font-weight: 900;
		font-family: "微软雅黑";
		color: #495060;
		font-size: 18px;
	}
	
	.mainCon {
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
		padding-left: 40px;
	}
	.mainCon:after{
		content:"";
		height:0;
		line-height: 0;
		display:block;
		clear:both;
		visibility: hidden;
	}
	
	.leftFrom {
		float: left;
		margin-top: 20px;
		margin-right: 40px;
	}
	
	.rightForm {
		float: right;
		margin-top: 20px;
	}
	
	.rightBtn {
		position: relative;
		top: -30px;
		right: -180px;
	}
	
	.el-upload__tip {
		position: relative;
		top: -30px;
	}
	
	.el-upload-list {
		position: relative;
		top: -30px;
	}
	
	.upload-demo {
		height: 60px;
	}
	
	.el-upload-list--text {
		position: relative;
		top: -30px;
	}
	.main p span{
		display: inline-block;
		padding:5px 10px;
		background:#f6f7fb;
		margin:0px 5px;
		font-size:14px;
		color:#495060;
		font-family: "微软雅黑";
	}
	.main p input{
		display: inline-block;
		margin:0px 5px;
		width:48px;
		border:none;
		border:1px solid #dddee1;
		border-radius:5px;
		
	}
	.btnCon{
		width:60%;
		text-align: center;
		margin-bottom:100px;
		margin-top:20px;
	}
	.btnB span{
		height:40px;
		line-height: 40px;
		font-size:14px;
		text-align: center;
	}
</style>