import Vue from 'vue'
import BootstrapVue from "bootstrap-vue"
import ElementUI from 'element-ui'

import axios from './config/http'
import store from './store/store'
import App from './App.vue'
import modal from './components/common/modal/index.vue'
import headerBar from './components/common/headerBar.vue'
import headerLong from './components/common/headerLong.vue'
import longBheader from './components/common/longBheader.vue'
import pages from './components/common/pages.vue'
import router from './config/router'
// 引入echarts
import echarts from 'echarts'
//省是三级联动
import VueAreaLinkage from "vue-area-linkage"

Vue.prototype.axios = axios;
Vue.prototype.echarts = echarts

import TreeList from 'vue-jstree';

import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap-vue/dist/bootstrap-vue.css"
import 'element-ui/lib/theme-chalk/index.css'
import 'vue-area-linkage/dist/index.css'
import "./assets/css/app.css"
Vue.use(BootstrapVue)
Vue.use(ElementUI)
Vue.use(VueAreaLinkage)
//公用组件在此注册，之后使用就不需要导包\
Vue.component('modal', modal);
Vue.component('headerBar', headerBar);
Vue.component('headerLong', headerLong);
Vue.component('longBheader', longBheader);
Vue.component('pages', pages);
Vue.component('TreeList', TreeList);


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
