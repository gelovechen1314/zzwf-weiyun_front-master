<template>
    <div class="hbox">
        <div class="col left">
            <div class="header">
                	交易
            </div>
            <div class="wrapper">
                <b-nav pills vertical>
                	 <b-nav-item to="/trade/transactionprofile">交易概况</b-nav-item>
                    <b-nav-item to="/trade/customerinformation" >历史数据</b-nav-item>
                    <b-nav-item to="/trade/customermanagement/">模拟竞价</b-nav-item>
                    <b-nav-item to="/trade/longassociatmanagement" >长协管理</b-nav-item>
                    <b-nav-item to="/trade/customermanagement/">购电详情</b-nav-item>
                   <b-nav-item to="/trade/powerplantplan" >电厂计划</b-nav-item>
                    <b-nav-item to="/trade/customermanagement/">电厂剩余电量</b-nav-item>
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
		background:#f0f0f0;
		height:100%;
	}
</style>