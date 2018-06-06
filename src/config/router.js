import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store/store'
import * as types from '../store/types'
const Home  = r => require.ensure([], () => r(require('../components/Home.vue')), 'home')
const Dashboard  = r => require.ensure([], () => r(require('../components/Dashboard.vue')), 'dashboard')
const Login  = r => require.ensure([], () => r(require('../components/Login.vue')), 'login')
const Trade  = r => require.ensure([], () => r(require('../components/trade/Trade.vue')), 'trade')
const Contract  = r => require.ensure([], () => r(require('../components/contract/Contract.vue')), 'contract')
const Monitor  = r => require.ensure([], () => r(require('../components/monitor/Monitor.vue')), 'monitor')
const Customer  = r => require.ensure([], () => r(require('../components/customer/Customer.vue')), 'customer')
const Customermanagement  = r => require.ensure([], () => r(require('../components/customer/Customermanagement.vue')), 'customer')
const Forecast  = r => require.ensure([], () => r(require('../components/forecast/Forecast.vue')), 'forecast')
const Equipment  = r => require.ensure([], () => r(require('../components/equipment/Equipment.vue')), 'equipment')
const Accountnumber  = r => require.ensure([], () => r(require('../components/accountnumber/Accountnumber.vue')), 'accountnumber')

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
                component: Monitor,
                children:[
                 {
                        path: '/',
                        component: r => require.ensure([], () => r(require('../components/monitor/Index.vue')), 'monitor')
                    },
                    {
                        path: '/monitor/electricmonitor',
                        component: r => require.ensure([], () => r(require('../components/monitor/Electricmonitor.vue')), 'monitor')
                    },
                    {
                        path: '/monitor/loadmonitor',
                        component: r => require.ensure([], () => r(require('../components/monitor/Loadmonitor.vue')), 'monitor')
                    },
                    {
                        path: '/monitor/loadrateanalysis',
                        component: r => require.ensure([], () => r(require('../components/monitor/Loadrateanalysis.vue')), 'monitor')
                    },
                    {
                        path: '/monitor/requirementanalysis',
                        component: r => require.ensure([], () => r(require('../components/monitor/Requirementanalysis.vue')), 'monitor')
                    },
                ]
            },
            {
                path: '/trade',
                component: Trade,
                children:[
                	{
                        path: '/',
                        component: r => require.ensure([], () => r(require('../components/trade/index.vue')), 'trade')
                    },
                     
                 	{
                        path: '/trade/transactionprofile',
                        component: r => require.ensure([], () => r(require('../components/trade/Transactionprofile.vue')), 'trade')
                    },
                    {
                        path: '/trade/longassociatmanagement',
                        component: r => require.ensure([], () => r(require('../components/trade/Longassociatmanagement.vue')), 'trade')
                    },
                      {
                        path: '/trade/addlongassociate',
                        component: r => require.ensure([], () => r(require('../components/trade/Addlongassociate.vue')), 'trade')
                    },
                    {
                        path: '/trade/powerplantplan',
                        component: r => require.ensure([], () => r(require('../components/trade/Powerplantplan.vue')), 'trade')
                    },
                     {
                        path: '/trade/remainingpowerplant',
                        component: r => require.ensure([], () => r(require('../components/trade/Remainingpowerplant.vue')), 'trade')
                    },{
                        path: '/trade/powerpurchasedetails',
                        component: r => require.ensure([], () => r(require('../components/trade/Powerpurchasedetails.vue')), 'trade')
                    },
                    
                   
                ]
            },
            {
                path: '/contract',
                component: Contract,
                children:[
                 	{
                        path: '/',
                        component: r => require.ensure([], () => r(require('../components/contract/Index.vue')), 'contract')
                    },
                    {
                        path: '/contract/contractelectricity',
                        component: r => require.ensure([], () => r(require('../components/contract/Contractelectricity.vue')), 'contract')
                    },
                   
                ]
            },
             {
                path: '/forecast',
                component: Forecast,
                children:[
                 	{
                        path: '/',
                        component: r => require.ensure([], () => r(require('../components/forecast/Index.vue')), 'forecast')
                    },
                    {
                        path: '/forecast/annualelectricityforecast',
                        component: r => require.ensure([], () => r(require('../components/forecast/Annualelectricityforecast.vue')), 'forecast')
                    },
                     {
                        path: '/forecast/monthlyelectricityforecast',
                        component: r => require.ensure([], () => r(require('../components/forecast/Monthlyelectricityforecast.vue')), 'forecast')
                    },
                ]
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
                    },
                    {
                        path: '/customer/customerinformation',
                        component: r => require.ensure([], () => r(require('../components/customer/Customerinformation.vue')), 'customer')
                    },
                    {
                        path: '/customer/customermanagement',
                        component:Customermanagement,
	                        children:[
		                         {
		                        path: '/customer/customermanagement/',
		                        component: r => require.ensure([], () => r(require('../components/customer/Customerimport.vue')), 'customer')
		                   	 	},
		                   	 	{
		                        path: '/customer/customermanagement/customermigration',
		                        component: r => require.ensure([], () => r(require('../components/customer/Customermigration.vue')), 'customer')
		                    	},
		                    	 {
		                        path: '/customer/customermanagement/incrementalacquisition',
		                        component: r => require.ensure([], () => r(require('../components/customer/Incrementalacquisition.vue')), 'customer')
		                    },
		                    	
	                        ]
                        /*component: r => require.ensure([], () => r(require('../components/customer/Customermanagement.vue')), 'customer')*/
                    },
                    {
                        path: '/customer/supplier',
                        component: r => require.ensure([], () => r(require('../components/customer/Supplier.vue')), 'customer')
                    },
                     {
                        path: '/customer/modifyconsumerinfo',
                        component: r => require.ensure([], () => r(require('../components/customer/Modifyconsumerinfo.vue')), 'customer')
                    },
                   
                    
                    
                ]
            },
            {
                path: '/equipment',
                component: Equipment,
                children:[
                 	{
                        path: '/',
                        component: r => require.ensure([], () => r(require('../components/equipment/Index.vue')), 'equipment')
                    },
                    {
                        path: '/equipment/equipmentapplication',
                        component: r => require.ensure([], () => r(require('../components/equipment/Equipmentapplication.vue')), 'equipment')
                    },
                     {
                        path: '/equipment/equipmentmanagement',
                        component: r => require.ensure([], () => r(require('../components/equipment/Equipmentmanagement.vue')), 'equipment')
                    },
                    {
                        path: '/equipment/collectstatestatistics',
                        component: r => require.ensure([], () => r(require('../components/equipment/Collectstatestatistics.vue')), 'equipment')
                    }, 
                    {
                        path: '/equipment/terminalinformation',
                        component: r => require.ensure([], () => r(require('../components/equipment/Terminalinformation.vue')), 'equipment')
                    },
                     
                    
                ]
            },
            {
                path: '/accountnumber',
                component: Accountnumber,
                children:[
                 {
                        path: '/',
                        component: r => require.ensure([], () => r(require('../components/accountnumber/Index.vue')), 'accountnumber')
                    },
                    {
                        path: '/accountnumber/personaldata',
                        component: r => require.ensure([], () => r(require('../components/accountnumber/Personaldata.vue')), 'accountnumber')
                    },
                    {
                        path: '/accountnumber/rolepermission',
                        component: r => require.ensure([], () => r(require('../components/accountnumber/Rolepermission.vue')), 'accountnumber')
                    },
                    {
                        path: '/accountnumber/operationlog',
                        component: r => require.ensure([], () => r(require('../components/accountnumber/Operationlog.vue')), 'accountnumber')
                    },
                    {
                        path: '/accountnumber/loginrecord',
                        component: r => require.ensure([], () => r(require('../components/accountnumber/Loginrecord.vue')), 'accountnumber')
                    },
                ]
            },
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