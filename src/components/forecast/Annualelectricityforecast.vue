<template>
	<div class="contentCon">
		<div class="header titleHea">
			<span>年度电量预测</span>
			<p>
				<a href="/"><em class="iconfont">&#xe778;</em>首页</a>：<b>预测></b><b>年度电量预测</b></p>
		</div>
		 <div class="panel">
            <div class="panel-body tableCon">
                <b-table striped hover :items="items" :fields="fields" :current-page="currentPage" :per-page="perPage" :filter="filter" @filtered="onFiltered">
                    <template slot="id" slot-scope="data">
                        <input @click.stop type="checkbox" :value="data.item.id" >
                    </template>
                    <template slot="opration" slot-scope="data">
                        <b-link :href="'/customer/'+data.item.id">查看</b-link>
                    </template>
                </b-table>
                <b-pagination :total-rows="totalRows" :per-page="perPage" v-model="currentPage" class="pager" />
            </div>
        </div>
		
	</div>
</template>

<script>
	import "../../assets/css/com.css"
	import headerLong from "../common/headerLong.vue";
	 var items = [
        { id: 1, sn: 'SN20152306', name: '林州市电力炭素有限公司', category: '工程电力', address: '林州市电厂路西段',level:'一级',month:'一月' },
        { id: 2, sn: 'SN20152305', name: '林州市鸿兴精密制造有限公司', category: '工程电力', address: '林州市电厂路西段',level:'一级',month:'一月' }
    ];
	export default{
		data(){
			return {
                items: items,
                fields: {
                    id:{
                        label: '选择'
                    },
                    sn: {
                        label: '所属区域',
                        sortable: true
                    },
                    category: {
                        label: '客户编码'
                    },
                    name: {
                        label: '客户名称'
                    },
                    month1: {
                        label: '一月'
                    },
                    month2: {
                        label: '二月'
                    },
                    month3: {
                        label: '三月'
                    },
                    month4: {
                        label: '四月'
                    },
                    month5: {
                        label: '五月'
                    },
                    month6: {
                        label: '六月'
                    },
                    month7:{
                    	label:'七月'
                    },
                    month8:{
                    	label:'八月'
                    },
                    month9:{
                    	label:'九月'
                    },
                    month10:{
                    	label:'十月'
                    },
                    month11:{
                    	label:'十一月'
                    },
                    month12:{
                    	label:'十二月'
                    },
                    sum:{
                    	label:'合计',
                    	sortable: true
                    },
                    change:{
                    	label:'修改人',
                    	sortable: true
                    },
                    sure:{
                    	label:'确认人',
                    	sortable: true
                    },
                    state:{
                    	label:'状态',
                    	sortable: true
                    },
                    opration:{
                        label:'操作'
                    }
                    
                },
                filter: null,
                currentPage: 1,
                perPage: 15,
                sortBy: null,
                sortDesc: false,
                totalRows: items.length
            }
		},
		components: {
			headerLong,
			
		},
		 methods:{
            selected(){
                alert();
            },
            onFiltered (filteredItems) {
                // Trigger pagination to update the number of buttons/pages due to filtering
                this.totalRows = filteredItems.length
                this.currentPage = 1
            }
        }
		
	}
</script>

<style scoped="scoped">
	.contentCon{
		padding-bottom:20px;
	}
	.tableCon{
		font-size:10px;
	}
</style>