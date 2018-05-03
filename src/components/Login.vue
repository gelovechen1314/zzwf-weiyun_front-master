<template>
    <div class="bg">
        <div class="login">
            <h5>售电云运维管理系统</h5>
            <form action="" @submit.stop.prevent="login">
                <div class="form-group">
                    <label for="">账号</label>
                    <input type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="">密码</label>
                    <input type="password" class="form-control" v-model="token">
                </div>
                <button class="btn btn-primary btn-full">登陆</button>
            </form>
        </div>
    
    </div>
</template>
<script>
    import * as types from '../store/types'
    export default {
        data () {
            return {
                msg: '',
                token: ''
            }
        },
        methods: {
            login(){
                if (this.token) {
                    this.$store.commit(types.LOGIN, this.token)
                    let redirect = decodeURIComponent(this.$route.query.redirect || '/');
                    this.$router.push({
                        path: redirect
                    })
                }else{
                    alert();
                }
            }
        }
    }
</script>
<style>
    .bg{
        position: relative;
        background: url(../assets/images/15670463369_ed7ae1bd73_h.jpg) no-repeat center center;
        background-size: 100%;
        height:100%;
        box-sizing:border-box;
        z-index: 1;
    }
    .login{
        position: relative;
        top:30%;
        overflow: hidden;
        background: #fff;
        padding: 30px;
        width:300px;
        margin:auto;
        border-radius: 4px;
        z-index: 10
    }
</style>