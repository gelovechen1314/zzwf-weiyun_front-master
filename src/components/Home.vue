<template>
    <div class="app app-header-fixed">
        <header class="app-header">
            <b-navbar toggleable="md">
                <div class="navbar-header">
                <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
                <b-navbar-brand href="#" class="navbar-header"><img src="../assets/images/logo.png"></b-navbar-brand>
                </div>
                <b-collapse is-nav id="nav_collapse" class="box-shadow">
                    <div class="brand-name">微云售电运维管理系统</div>
                    <b-navbar-nav class="ml-auto" pills>
                        <b-nav-item href="#"><i class="iconfont icon-bell"></i><b-badge variant="danger" class="up badge-sm">4</b-badge></b-nav-item>
                        <b-nav-item-dropdown text="欢迎你，admin" right>
                            <div class="user">
                                <img src="../assets/images/a3.jpg" class="img-responsive img-circle"><h5>admin@admin.com</h5><span>系统管理员</span>
                            </div>
                            <div class="menu">
                                <b-dropdown-item href="/profile">个人资料</b-dropdown-item>
                                <b-dropdown-item href="/password">修改密码</b-dropdown-item>
                                <b-dropdown-item href="/logs">登陆日志</b-dropdown-item>
                                <b-button class="logout-btn" @click="logout" variant="danger" to="/logout">安全退出</b-button>
                            </div>
                        </b-nav-item-dropdown>
                    </b-navbar-nav>
                </b-collapse>
            </b-navbar>
        </header>

        <div class="app-side">
                <b-nav>
                    <b-nav-item to="/" exact><i class="iconfont icon-dashboard"></i>首页</b-nav-item>
                    <b-nav-item to="/monitor"><i class="iconfont icon-monitor"></i>监控</b-nav-item>
                    <b-nav-item to="/forecast"><i class="iconfont icon-divine"></i>预测</b-nav-item>
                    <b-nav-item><i class="iconfont icon-buy"></i>购电</b-nav-item>
                    <b-nav-item><i class="iconfont icon-sell"></i>售电</b-nav-item>
                    <b-nav-item to="/customer"><i class="iconfont icon-consumer"></i>客户</b-nav-item>
                    <b-nav-item to="/equipment"><i class="iconfont icon-device"></i>设备</b-nav-item>
                    <b-nav-item to="/accountnumber"><i class="iconfont icon-users"></i>账号</b-nav-item>
                    <b-nav-item><i class="iconfont icon-service"></i>客服</b-nav-item>
                    <b-nav-item><i class="iconfont icon-setting"></i>系统</b-nav-item>
                </b-nav>
        </div>
        <div class="app-content">
                <router-view><Dashboard></Dashboard></router-view>
        </div>
    </div>
</template>

<script>
    import Dashboard from './Dashboard.vue';
    import * as types from '../store/types'
    export default {
        components:{Dashboard},
        methods:{
            logout(event){
                this.$store.commit(types.LOGOUT);
                this.$router.replace({ path: '/login' });
            }
        }
    }
</script>