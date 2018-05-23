<template>
	<div>
		<div class="header titleHea">
			<span>负载率分析</span>
			<p>
				<a href="/"><em class="iconfont">&#xe778;</em>首页</a>：<b>客户></b><b>供应商</b></p>
		</div>
		 <div class="panel">
            <div class="panel-header">
                <div class="row">
                    <div class="col-md-8 formBox">
                        <form action="" class="form-inline formlLine">
                            <div class="form-group">
                            	所属区域：
                                <input type="text" class="form-control" placeholder="" v-model="filter">
                            </div>
                            <div class="form-group">
                            	客户编码：
                                <input type="text" class="form-control" placeholder="" v-model="filter">
                            </div>
                            <div class="form-group">
                            	客户名称：
                                <input type="text" class="form-control" placeholder="" v-model="filter">
                            </div>
                            <button class="btn btn-primary">查询</button>
                            <button class="btn btn-primary">重置</button>
                        </form>
                    </div>
                    
                </div>
            </div>
            <div class="panel-body">
                <b-table striped hover :items="items" :fields="fields" :current-page="currentPage" :per-page="perPage" :filter="filter" @filtered="onFiltered">
                    <template slot="id" slot-scope="data">
                        <input @click.stop type="checkbox" :value="data.item.id" v-model="selected">
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
	 var items = [
        { id: 1, sn: 'SN20152306', name: '林州市电力炭素有限公司', category: '工程电力', address: '林州市电厂路西段',level:'一级' },
        { id: 2, sn: 'SN20152305', name: '林州市鸿兴精密制造有限公司', category: '工程电力', address: '林州市电厂路西段',level:'一级' }
    ];
    export default {
        data () {
            return {
                items: items,
                fields: {
                    id:{
                        label: '序号'
                    },
                    sn: {
                        label: '客户编码',
                        sortable: true
                    },
                    name: {
                        label: '客户名称'
                    },
                    category: {
                        label: '行业类别'
                    },
                    address: {
                        label: '地址'
                    },
                    level: {
                        label: '用电级别'
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
        computed: {

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
	.formBox{
		width:100%;
		
	}
	.formlLine{
		width:100%;
	}
	
	
</style>