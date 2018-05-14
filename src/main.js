import Vue from 'vue'
import BootstrapVue from "bootstrap-vue"
import axios from './config/http'
import store from './store/store'
import App from './App.vue'
import headerBar from './components/common/headerBar.vue'
import router from './config/router'
// 引入echarts
import echarts from 'echarts'

Vue.prototype.axios = axios;
Vue.prototype.echarts = echarts

import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap-vue/dist/bootstrap-vue.css"
import "./assets/css/app.css"
Vue.use(BootstrapVue)
//公用组件在此注册，之后使用就不需要导包
Vue.component('headerBar', headerBar);


new Vue({
  el: '#app',
  axios,
  router,
  store,
  render: h => h(App)
}).$mount('#app');
// new Vue({
//     router,
//     render: h => h(App)
// }).$mount('#app');
