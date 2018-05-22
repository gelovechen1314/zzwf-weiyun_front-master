<template>
	<div>
		<div class="header titleHea">
			<span>角色权限</span>
			<p>
				<a href="/"><em class="iconfont">&#xe778;</em>首页</a>：<b>个人资料></b><b>角色权限</b></p>
		</div>
		<div class="wrapper-md wrapperCon">
			<div class="tableCon">
				<table > 
					<tr>
						<th>序号</th>
						<th>角色名</th>
						<th>操作</th>
					</tr>
					<tr>
						<td>11</td>
						<td>居间商</td>
						<td>编辑权限</td>
					</tr>
					<tr>
						<td>11</td>
						<td>居间商</td>
						<td>编辑权限</td>
					</tr>
					<tr>
						<td>11</td>
						<td>居间商</td>
						<td>编辑权限</td>
					</tr>
					<tr>
						<td>11</td>
						<td>居间商</td>
						<td>编辑权限</td>
					</tr>
				</table>
			</div>
			<div class="editCon">
				<h3>编辑权限</h3>
				<div class="editTable">
					<div class="leftLists">
						<h4>栏目名称</h4>
						<ul class="lists">
							<li>客户</li>
							<li>合同</li>
							<li>交易</li>
							<li>预测</li>
							<li>结算</li>
							<li>监控</li>
							<li>设备</li>
							<li>账号</li>
							<li>角色</li>
						</ul>
					</div>
					<div class="rightLists">
						<h4>详细</h4>
						<ul class="itemLists">
							<li>
								<input name="item" type="radio"/>客户信息
							</li>
							<li>
								<input name="item" type="radio"/>客户管理
							</li>
							<li>
								<input name="item" type="radio"/>供应商信息
							</li><br/>
							<li>
								<input name="item" type="radio"/>长协合同
							</li>
							<li>
								<input name="item" type="radio"/>月竞合同
							</li>
							<li>
								<input name="item" type="radio"/>售电合同
							</li>
							<li>
								<input name="item" type="radio"/>合同管理
							</li>
						</ul>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				
			}
		}
	}
</script>

<style scoped>
	.titleHea {
		padding: 0px;
		height: 58px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
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
	}
	.tableCon{
		padding:20px 10px;
	}
	.tableCon table{
		width:80%;
	}
	.tableCon td{
		line-height:48px;
	}
	.tableCon td:nth-of-type(1){
		width:15%;
		padding-left:10px;
	}
	.tableCon tr:nth-of-type(1){
		background:#efefef;
		padding-left:10px;
	}
	.tableCon th{
		line-height:48px;
	}
	.tableCon th:nth-of-type(1){
		width:15%;
		padding-left:10px;
	}
	.tableCon td:nth-of-type(2){
		width:60%;
	}
	.tableCon td:nth-of-type(3){
		width:20%;
		text-align:center;
	}
	.tableCon th:nth-of-type(3){
		width:20%;
		text-align:center;
	}
	.editCon{
		padding:0px 10px 20px;
	}
	.editCon h3{
		font-size:20px;
		width:100%;
		line-height:30px;
	}
	.editTable{
		width:80%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
	}
	.editTable:after{
		content:"";
		height:0px;
		line-height:0px;
		display:block;
		visibility: hidden;
		clear:both;
	}
	.leftLists{
		width:20%;
		margin-right:2%;
	}
	.leftLists h4{
		width:100%;
		height:46px;
		line-height:48px;
		background:#efefef;
		font-size:14px;
		text-align: center;
		margin-bottom:10px;
	}
	.lists{
		width:100%;
	}
	.lists li{
		font-size:16px;
		text-align:center;
		line-height:36px;
	}
	.rightLists{
		width:80%;
		
	}
	.rightLists h4{
		width:100%;
		line-height:46px;
		height:46px;
		background:#efefef;
		text-align:center;
		font-size:14px;
		margin-bottom:10px;
	}
	.itemLists{
		width:50%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		-webkit-flex-wrap:wrap;
	    -webkit-box-lines:multiple;
	    -moz-flex-wrap:wrap;
	    flex-wrap:wrap;
	}
	.itemLists:after{
		content:"";
		height:0px;
		line-height:0px;
		display:block;
		visibility: hidden;
		clear:both;
	}
	.itemLists li{
		float:left;
		line-height:20px;
		margin:10px;
		
	}
</style>