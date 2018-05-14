<template>
    <div>
        <div class="header">客户信息</div>
        <div class="panel">
            <div class="panel-header">
                <div class="row">
                    <div class="col-md-8">
                        <form action="" class="form-inline">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="请输入客户名称" v-model="filter">
                            </div>
                            <div class="form-group">
                                <select name="" class="form-control">
                                    <option value="">所在城市</option></select>
                            </div>
                            <div class="form-group">
                                <select name="" class="form-control">
                                    <option value="">行业类别</option></select>
                            </div>
                            <button class="btn btn-primary">查询</button>
                        </form>
                    </div>
                    <div class="col-md-4 text-right">
                        <b-button to="/customer/create" variant="success">新增</b-button>
                        <b-button href="#" variant="danger">删除</b-button>
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