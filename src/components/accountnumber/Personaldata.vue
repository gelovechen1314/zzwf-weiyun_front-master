<template>
	<div>
		<div class="header titleHea">
			<span>个人资料</span>
			<p>
				<a href="/"><em class="iconfont">&#xe778;</em>首页</a>：<b>个人资料></b><b>角色权限</b></p>
		</div>
		<div class="wrapper-md wrapperCon">
			<div class="boxShadow">
				<div class="mainBox">
					<form>
						<div class="formCon">
							<p>
								<label for="name">账号：</label>
								<input type="text" id="name" placeholder="Whc" />
							</p>
							<p>
								<label for="name"><span>*</span>姓名：</label>
								<input type="text" id="name" placeholder="Whc" />
							</p>
							<p>
								<label for="name">账户状态：</label>
								<input type="text" id="name" placeholder="Whc" />
							</p>
							<p>
								<label for="name"><span>*</span>联系电话：</label>
								<input type="text" id="name" placeholder="Whc" />
							</p>
							<p>
								<label for="name">账号：</label>
								<input type="text" id="name" placeholder="Whc" />
							</p>
							<p>
								<label for="name">账号：</label>
								<input type="text" id="name" placeholder="Whc" />
							</p>
							<p>
								<label for="name">账号：</label>
								<input type="text" id="name" placeholder="Whc" />
							</p>
							
						</div>
						<div class="txtCon">
							<label for="txt">备注：</label>
						    <textarea id="txt"></textarea>
						</div>
						<div class="btnBox">
							<button>修改密码</button>
							<button>修改资料</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	
</script>

<style scoped>
	.titleHea {
		padding: 0px;
		height: 58px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom:1;
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
	.wrapperCon{
		background:#fff;
		padding:25px 15px;
		font-size:12px;
	}
	.boxShadow{
		border: 6px solid #efeff1;
	}
	.mainBox{
		width:100%;
		margin:10px auto;
		
	}

	.formCon{
		width:100%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		-webkit-flex-wrap:wrap;
	    -webkit-box-lines:multiple;
	    -moz-flex-wrap:wrap;
	    flex-wrap:wrap;
	    zoom:1;
		
	}
	.formCon:after{
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	.formCon p{
		display:block;
		width:49%;
		height:30px;
		line-height:30px;
		float:left;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		font-size:12px;
		
	}
	.formCon p:even{
		margin-left:2%;
		
	}
	.formCon p label{
		display:inline-block;
		width:30%;
		float:left;
		font-size:12px;
		text-align: right;
	}
	.formCon p label span{
		color:#f00;
	}
	.formCon p input{
		display:inline-block;
		float:right;
		width:70%;
		font-size:14px;
		border:none;
		border:1px solid #e5e5e5;
		background:#f5f5f5;
		border-radius:5px;
		text-indent:10px;
	}
	.txtCon{
		width:100%;
		padding-bottom: 20px;
		border-bottom:1px solid #eee;
	}
	.txtCon label{
		width:15%;
		font-size:12px;
		text-align: right;
		
	}
	.txtCon textarea{
		width:82%;
		height:92px;
		resize: none;
		font-size:14px;
		border:1px solid #e5e5e5;
	}
	.btnBox{
		margin:20px 0;
		width:100%;
		text-align:center
	}
	.btnBox button{
		width:100px;
		line-height: 30px;
		background:#37b3e0;
		color:#fff;
		border:none;
		border-radius:4px;
	}
</style>