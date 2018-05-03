<template>
    <div class="hbox">
        <div class="col left">
            <div class="header">
                客户管理
            </div>
            <div class="wrapper">
                <b-nav pills vertical>
                    <b-nav-item active>客户管理</b-nav-item>
                    <b-nav-item>负荷监测</b-nav-item>
                    <b-nav-item>电流监测</b-nav-item>
                    <b-nav-item>功率因数监测</b-nav-item>
                    <b-nav-item>数据采集</b-nav-item>
                    <b-nav-item>用电监控</b-nav-item>
                    <b-nav-item>设备监测</b-nav-item>
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