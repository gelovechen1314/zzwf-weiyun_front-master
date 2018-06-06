<template>
	<div class="hbox">
		<div class="col left">
			<div class="header">
				数据监控
			</div>
			<div class="wrapper">
				<b-nav pills vertical>
					<b-nav-item to="/setup/electricmonitor">用户管理</b-nav-item>
					<b-nav-item to="/setup/loadmonitor">新闻中心</b-nav-item>
					<b-nav-item to="/setup/loadrateanalysis">短消息</b-nav-item>
					
				</b-nav>
			</div>
		</div>
		<div class="col">
			<router-view></router-view>
		</div>
		<!--<div class="col right">
			<div class="header">

			</div>
			<div class="wrapper">
				<form action="">
					<div class="form-group">
						<input type="text" class="form-control" @keyup="SearchCompany" v-model="companyKeyword">
					</div>
				</form>
				<TreeList :data="companys" noDots @item-click="itemClick" ref="tree"></TreeList>
			</div>
		</div>-->

	</div>
</template>
<script>
	 export default {
    }
	
</script>
<style scoped="scoped">
	
</style>