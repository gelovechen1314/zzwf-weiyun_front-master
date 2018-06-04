<template>
    <div class="hbox">
        <div class="col left">
            <div class="header">
                	客户中心
            </div>
            <div class="wrapper">
                <b-nav pills vertical>
                	<b-nav-item to="/customer/supplier">客户概况</b-nav-item>
                    <b-nav-item to="/customer/customerinformation" >客户信息</b-nav-item>
                    <b-nav-item to="/customer/customermanagement/">客户管理</b-nav-item>
                   
                </b-nav>
            </div>
        </div>
        <div class="col">
            <router-view></router-view>
        </div>
    </div>
</template>
<script>
    export default {
    }
</script>
<style scoped="scoped">
	.col{
		margin-bottom:20px;
		height:100%;
		overflow-y: auto;
	}
</style>