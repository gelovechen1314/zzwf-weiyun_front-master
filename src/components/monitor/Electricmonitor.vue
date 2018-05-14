<template>
	 <div>
        <div class="header">新增客户</div>
        <div class="panel">
                <form action="">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">客户名称</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">客户编码</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">合约起止时间</label>
                                <div class="controls">
                                    <calendar :value="start_date" placeholder="请输入起始时间" :format="format"></calendar>
                                    <label for="">至&nbsp;</label><calendar :value="start_date" ></calendar>
                                </div>

                            </div>
                            <div class="form-group">
                                <label for="">所在地区</label>
                                <TreeSelect
                                        v-model="city"
                                        :options="regions"
                                        :clearable="true"
                                        placeholder="请选择所在地区"
                                />
                            </div>
                            <div class="form-group">
                                <label for="">联系人</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">邮政编码</label>
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">所属行业</label>
                                <TreeSelect
                                        v-model="trade"
                                        :options="trades"
                                        :clearable="true"
                                        placeholder="请选择所属行业"
                                />
                            </div>
                            <div class="form-group">
                                <label for="">用电等级</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">详细地址</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">联系电话</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">备注</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">电表安装情况</label>
                                <div class="controls">
                                    <label class="form-check-inline"><input type="radio" name="status" class="form-check-input">已安装</label>
                                    <label class="form-check-inline"><input type="radio" name="status" class="form-check-input">未安装</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary">确定</button>
                        <button class="btn">取消</button>
                    </div>

                </form>
        </div>
    </div>
</template>

<script>
	 import "@riophae/vue-treeselect/dist/vue-treeselect.min.css"
    import TreeSelect from '@riophae/vue-treeselect'
    import 'vue2-slot-calendar/lib/calendar.min.css';
    import Calendar from 'vue2-slot-calendar/lib/calendar';

    export default {
        components: { TreeSelect,calendar: Calendar },
        data(){
            return {
                start_date: new Date().getFullYear()+"-"+new Date().getMonth()+"-"+new Date().getDay(),
                format:"yyyy-MM-dd",
                trade: null,
                city:null,
                trades: [
                    {
                        id:"1",
                        label: '农、林、牧、渔业',
                        children: [
                            {
                                id:"2",
                                label: '农业',
                            },
                            {
                                id:"3",
                                label: '林业',
                            },
                            {
                                id:"4",
                                label: '畜牧业',
                            },
                            {
                                id:"5",
                                label: '渔业',
                            },
                            {
                                id:"6",
                                label: '农、林、牧、渔专业及辅助性活动',
                            }
                        ],
                    },
                    {
                        id: '7',
                        label: '采矿业',
                        children: [
                            {
                                id:"8",
                                label: '煤炭开采和洗选业',
                            },
                            {
                                id:"9",
                                label: '石油和天然气开采业',
                            },
                            {
                                id:"10",
                                label: '黑色金属矿采选业',
                            },
                            {
                                id:"11",
                                label: '有色金属矿采选业',
                            },
                            {
                                id:"12",
                                label: '非金属矿采选业',
                            }
                        ],
                    },
                ],
                regions: [
                    {
                        id:"1",
                        label: '北京市',
                        children: [
                            {
                                id:"2",
                                label: '东城区',
                            },
                            {
                                id:"3",
                                label: '西城区',
                            },
                            {
                                id:"4",
                                label: '朝阳区',
                            },
                            {
                                id:"5",
                                label: '丰台区',
                            },
                            {
                                id:"6",
                                label: '石景山区',
                            }
                        ],
                    },
                    {
                        id: '7',
                        label: '天津市',
                        children: [
                            {
                                id:"8",
                                label: '和平区',
                            },
                            {
                                id:"9",
                                label: '河东区',
                            },
                            {
                                id:"10",
                                label: '河西区',
                            },
                            {
                                id:"11",
                                label: '南开区',
                            },
                            {
                                id:"12",
                                label: '河北区',
                            }
                        ],
                    },
                ],
            }

        }
    }
</script>

<style>
</style>