<template>
	<div class="contentCon">
		<div class="headerCon">
			<router-link to="/customer/customerinformation"><i class="el-icon-arrow-left"></i><span>返回</span></router-link>
			<h5 style="font-size:18px;">修改客户信息</h5>
		</div>
		<div class="formCon">
			<form>
				<div class="main">
					<div class="mainCon">
						<div class="leftFrom">
							<el-form class="form" :label-position="right" label-width="130px" size="mini" :model="formLabelAlign">
								<el-form-item style="font-size:12px;" label="企业名称" :rules="[
						      { required: true, message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input class="formInput"  v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item label="所属行业">
									<el-cascader style="width:170px;" class="formInput"  :options="options" v-model="selectedOptions" @change="handleChange">
									</el-cascader>
								</el-form-item>
								
							</el-form>
						</div>
						<div class="rightForm">
							<el-form class="form" :label-position="right" label-width="130px" size="mini" :model="formLabelAlign">
								<el-form-item label="企业简称" :rules="[
						      { required: true, message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input class="formInput"  v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item  label="客户负责人" required>
									<el-cascader style="width:170px;" class="formInput"  :options="options" v-model="selectedOptions" @change="handleChange">
									</el-cascader>
								</el-form-item>
							</el-form>
						</div>
					</div>
				</div>

				<div class="main">
					<h6>客户基本信息</h6>
					<div class="mainCon">
						<div class="leftFrom">
							<el-form class="form" :label-position="right" label-width="130px" size="mini" :model="formLabelAlign">
								<el-form-item size="mini"  label="营业执照注册号" :rules="[
						      {message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input class="formInput" placeholder="请输入15位或18位的统一社会信用代码" v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item label="法人身份证号" :rules="[
						      {message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input class="formInput" placeholder="请输入有效身份证号" v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item label="交易中心账号" :rules="[
						      {  message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input class="formInput" placeholder="请如实填写" v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item label="交易中心密码" :rules="[
						      {  message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input class="formInput" placeholder="请如实填写" v-model="formLabelAlign.name"></el-input>
								</el-form-item>
							</el-form>
						</div>
						<div class="rightForm">
							<el-form class="form" :label-position="right" label-size="12px" label-width="130px" size="mini" :model="formLabelAlign">
								<el-form-item label="与营业执照上一致" :rules="[
						      { message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input class="formInput" placeholder="请如实填写" v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item style="font-size:12px;" label="注册资本" :rules="[
						      {  message: '价格不能为空'},
						      { type: 'number', message: '价格必须为字符串'}
						    ]">
									<el-input class="formInput" placeholder="请如实填写" v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item label="成立日期" :rules="[
						      {  message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input class="formInput" placeholder="请如实填写 格式2011-1-1" v-model="formLabelAlign.name"></el-input>
								</el-form-item>
								<el-form-item label="客户产品" :rules="[
						      {  message: '名称不能为空'},
						      { type: 'string', message: '名称必须为字符串'}
						    ]">
									<el-input class="formInput" placeholder="请如实填写" v-model="formLabelAlign.name"></el-input>
								</el-form-item>
							</el-form>
						</div>
					</div>
					<div class="area" style="width:100%;height:30px;">
						<area-select :level='2' type="text" size="small" v-modal="selected"></area-select>
					</div>
				</div>

				<div class="main">
					
					<div class="btnCon">
						
						<el-button class="btnB" type="primary">保存</el-button>
						<router-link class="btnB" style="text-decoration:none;border:1px solid #409EFF;padding:9px 20px;border-radius:5px;" to="/customer/customerinformation">取消</router-link>
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
				selected:[
				'440000','440300','440305'
				],
				options: [{
					value: 'zhinan',
					label: '指南',
					children: [{
						value: 'shejiyuanze',
						label: '设计原则',
						children: [{
							value: 'yizhi',
							label: '一致'
						}, {
							value: 'fankui',
							label: '反馈'
						}, {
							value: 'xiaolv',
							label: '效率'
						}, {
							value: 'kekong',
							label: '可控'
						}]
					}, {
						value: 'daohang',
						label: '导航',
						children: [{
							value: 'cexiangdaohang',
							label: '侧向导航'
						}, {
							value: 'dingbudaohang',
							label: '顶部导航'
						}]
					}]
				}, {
					value: 'zujian',
					label: '组件',
					children: [{
						value: 'basic',
						label: 'Basic',
						children: [{
							value: 'layout',
							label: 'Layout 布局'
						}, {
							value: 'color',
							label: 'Color 色彩'
						}, {
							value: 'typography',
							label: 'Typography 字体'
						}, {
							value: 'icon',
							label: 'Icon 图标'
						}, {
							value: 'button',
							label: 'Button 按钮'
						}]
					}, {
						value: 'form',
						label: 'Form',
						children: [{
							value: 'radio',
							label: 'Radio 单选框'
						}, {
							value: 'checkbox',
							label: 'Checkbox 多选框'
						}, {
							value: 'input',
							label: 'Input 输入框'
						}, {
							value: 'input-number',
							label: 'InputNumber 计数器'
						}, {
							value: 'select',
							label: 'Select 选择器'
						}, {
							value: 'cascader',
							label: 'Cascader 级联选择器'
						}, {
							value: 'switch',
							label: 'Switch 开关'
						}, {
							value: 'slider',
							label: 'Slider 滑块'
						}, {
							value: 'time-picker',
							label: 'TimePicker 时间选择器'
						}, {
							value: 'date-picker',
							label: 'DatePicker 日期选择器'
						}, {
							value: 'datetime-picker',
							label: 'DateTimePicker 日期时间选择器'
						}, {
							value: 'upload',
							label: 'Upload 上传'
						}, {
							value: 'rate',
							label: 'Rate 评分'
						}, {
							value: 'form',
							label: 'Form 表单'
						}]
					}, {
						value: 'data',
						label: 'Data',
						children: [{
							value: 'table',
							label: 'Table 表格'
						}, {
							value: 'tag',
							label: 'Tag 标签'
						}, {
							value: 'progress',
							label: 'Progress 进度条'
						}, {
							value: 'tree',
							label: 'Tree 树形控件'
						}, {
							value: 'pagination',
							label: 'Pagination 分页'
						}, {
							value: 'badge',
							label: 'Badge 标记'
						}]
					}, {
						value: 'notice',
						label: 'Notice',
						children: [{
							value: 'alert',
							label: 'Alert 警告'
						}, {
							value: 'loading',
							label: 'Loading 加载'
						}, {
							value: 'message',
							label: 'Message 消息提示'
						}, {
							value: 'message-box',
							label: 'MessageBox 弹框'
						}, {
							value: 'notification',
							label: 'Notification 通知'
						}]
					}, {
						value: 'navigation',
						label: 'Navigation',
						children: [{
							value: 'menu',
							label: 'NavMenu 导航菜单'
						}, {
							value: 'tabs',
							label: 'Tabs 标签页'
						}, {
							value: 'breadcrumb',
							label: 'Breadcrumb 面包屑'
						}, {
							value: 'dropdown',
							label: 'Dropdown 下拉菜单'
						}, {
							value: 'steps',
							label: 'Steps 步骤条'
						}]
					}, {
						value: 'others',
						label: 'Others',
						children: [{
							value: 'dialog',
							label: 'Dialog 对话框'
						}, {
							value: 'tooltip',
							label: 'Tooltip 文字提示'
						}, {
							value: 'popover',
							label: 'Popover 弹出框'
						}, {
							value: 'card',
							label: 'Card 卡片'
						}, {
							value: 'carousel',
							label: 'Carousel 走马灯'
						}, {
							value: 'collapse',
							label: 'Collapse 折叠面板'
						}]
					}]
				}, {
					value: 'ziyuan',
					label: '资源',
					children: [{
						value: 'axure',
						label: 'Axure Components'
					}, {
						value: 'sketch',
						label: 'Sketch Templates'
					}, {
						value: 'jiaohu',
						label: '组件交互文档'
					}]
				}],
				selectedOptions: [],
				formInline: {
					user: '',
					region: ''
				},
				arr: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月', '合计'],
				formLabelAlign: {
					name: '',
					region: '',
					type: '',
					date1: '',
					date2: '',
				},
				data: 13,
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
		font-weight: 900;
	}
	.form{
		font-size:12px;
	}
	.formCon {
		margin: 10px 20px 10px 10%;
	}
	
	.formInput{
		width:170px;
	}
	.main {
		padding: 10px 0px;
		width: 85%;
	}
	
	.main h6 {
		font-weight: 900;
		font-family: "微软雅黑";
		color: #495060;
		font-size: 18px;
		padding-bottom: 5px;
		text-indent: 10px;
		font-size: 14px;
		border-bottom: 1px solid #eee;
	}
	
	.mainCon {
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom: 1;
		padding-left: 10%;
		width: 90%;
	}
	
	.mainCon:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		clear: both;
		visibility: hidden;
	}
	
	.leftFrom {
		float: left;
		margin-top: 20px;
		margin-right: 40px;
		width:50%;
	}
	
	.rightForm {
		float: right;
		margin-top: 20px;
		width:48%;
		margin-left:2%;
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
	
	.el-form-item__label {
		font-size: 12px;
	}
	
	.main p span {
		display: inline-block;
		padding: 5px 10px;
		background: #f6f7fb;
		margin: 0px 5px;
		font-size: 12px;
		color: #495060;
		font-family: "微软雅黑";
	}
	
	.main p input {
		display: inline-block;
		margin: 0px 5px;
		width: 48px;
		border: none;
		border: 1px solid #dddee1;
		border-radius: 5px;
	}
	
	.btnCon {
		width: 100%;
		text-align: center;
		margin-bottom: 100px;
		margin-top: 20px;
	}
	
	.btnB span {
		height: 40px;
		line-height: 40px;
		font-size: 14px;
		text-align: center;
	}
</style>