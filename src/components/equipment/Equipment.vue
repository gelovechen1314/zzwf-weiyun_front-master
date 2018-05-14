<template>
	<div class="hbox">
        <div class="col left">
            <div class="header">
                	设备管理
            </div>
            <div class="wrapper">
                <b-nav pills vertical>
                    <b-nav-item to="equipment/customerinstallinformation">客户安装信息</b-nav-item>
                    <b-nav-item to="equipment/equipmentmanagement">设备管理</b-nav-item>
                    <b-nav-item  to="equipment/collectstatestatistics" >采集状态统计</b-nav-item>
                     <b-nav-item to="equipment/terminalinformation" >终端信息</b-nav-item>
                </b-nav>
            </div>
        </div>
        <div class="col">
           <router-view></router-view>
        </div>
        <div class="col right">
			<div class="header">
				选择企业
			</div>
			<div class="wrapper">
			<form action="">
				<div class="form-group">
					<input type="text" class="form-control"  @keyup="SearchCompany" v-model="companyKeyword">
				</div>
			</form>
			<TreeList :data="companys" noDots  @item-click="itemClick" ref="tree"></TreeList>
			</div>
		</div>
        
    </div>
</template>

<script>
</script>

<style>
</style>