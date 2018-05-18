<template>
	<div class="hbox">
		<div class="col left">
			<div class="header">
				账号管理
			</div>
			<div class="wrapper">
			<b-nav pills vertical>
				<b-nav-item to="/accountnumber/personaldata">个人资料</b-nav-item>
			    <b-nav-item to="/accountnumber/rolepermission">角色权限</b-nav-item>
			    <b-nav-item to="/accountnumber/operationlog">操作日志</b-nav-item>
			    <b-nav-item to="/accountnumber/loginrecord">登录记录</b-nav-item>
			</b-nav>
			</div>
		</div>
		<div class="col">
			<router-view></router-view>
		</div>
		
	</div>
</template>

<script>
</script>

<style>
</style>