import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store/store'
import * as types from '../store/types'
const Home  = r => require.ensure([], () => r(require('../components/Home.vue')), 'home')
const Dashboard  = r => require.ensure([], () => r(require('../components/Dashboard.vue')), 'dashboard')
const Login  = r => require.ensure([], () => r(require('../components/Login.vue')), 'login')
const Monitor  = r => require.ensure([], () => r(require('../components/Monitor.vue')), 'monitor')
const Customer  = r => require.ensure([], () => r(require('../components/customer/Customer.vue')), 'customer')

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'dashboard',
        meta: {
            requireAuth: true,
        },
        component: Home,
        children:[
            {
                path: '/',
                component: Dashboard
            },
            {
                path: '/monitor',
                component: Monitor
            },
            {
                path:'/customer',
                component:Customer,
                children:[
                    {
                        path: '/',
                        component: r => require.ensure([], () => r(require('../components/customer/Index.vue')), 'customer')
                    },
                    {
                        path: '/customer/create',
                        component: r => require.ensure([], () => r(require('../components/customer/Create.vue')), 'customer')
                    }
                ]
            }
        ]
    },
    {
        path: '/login',
        name: 'login',
        component: Login
    }
];


// 页面刷新时，重新赋值token
if (window.localStorage.getItem('token')) {
    store.commit(types.LOGIN, window.localStorage.getItem('token'))
}

const router = new VueRouter({
    mode:'history',
    routes
});

router.beforeEach((to, from, next) => {
    if (to.matched.some(r => r.meta.requireAuth)) {
        if (store.state.token) {
            next();
        }
        else {
            next({
                path: '/login',
                query: {redirect: to.fullPath}
            })
        }
    }
    else {
        next();
    }
})

export default router;