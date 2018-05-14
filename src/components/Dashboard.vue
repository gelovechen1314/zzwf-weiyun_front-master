<template>
    <div class="row">
        <div class="col-md-10">
            <div class="panel">
                <div class="header">
                    仪表盘
                    <span class="subtitle">管理控制台首页</span>
                </div>
                <div class="wrapper-md">
                    <div class="data-item row">
                        <div class="col-md-2"><div class="item">268400<span>月度用电情况(度)</span></div></div>
                        <div class="col-md-2"><div class="item bg-purple">68532<span>月度预测电量(度)</span></div></div>
                        <div class="col-md-2"><div class="item">268400<span>本月最大负荷</span></div></div>
                        <div class="col-md-3"><div class="item bg-blue">268400<span>年度合约总电量(KW.h)</span></div></div>
                        <div class="col-md-3"><div class="item full"><div id="totalChart" :style="{width: '80px', height: '80px',float:'left',top:'-12px'}"></div>268400<span>年度合约剩余电量(KW.h)</span></div></div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="week-charts">
                                <div class="charts"><div id="monthChart" :style="{width: '100%', height: '280px'}"></div></div>
                                <div class="data-progress bg-lightblue" style="height:100%;">
                                    用电时段占比统计
                                    <div class="items purple">
                                        <div class="text"><span>60%</span>峰：140,000.00</div>
                                        <div class="progress">
                                            <div class="progress-bar" role="progressbar" style="width: 60%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                    <div class="items blue">
                                        <div class="text"><span>60%</span>谷：6,000.00</div>
                                        <div class="progress">
                                            <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                    <div class="items yellow">
                                        <div class="text"><span>60%</span>平：5,400.00</div>
                                        <div class="progress">
                                            <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                    <p>峰段(7.00-11.00,19.00-23.00), 谷段
                                        (23.00-第二天的7.00). 平段(11.00
                                        -19.00) 因有时差原因,各地的具体时间有
                                        可能提前或推迟一个小时.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="col-md-2 slider">
            <div class="table-list">
                <div class="thead"><p>通知公告</p></div>
                <div class="lists">
                    <li><a href="">加大政策支持力度 促进“煤改电”持续发展</a></li>
                    <li><a href="">公司女职工工作捷报频传</a></li>
                    <li><a href="">【战风雨·保供电】风雨之中，电力人奋力</a></li>
                    <li><a href="">公司全力做好两会和元宵节期间保电工作</a></li>
                    <li><a href="">公司圆满完成春节保电工作</a></li>
                    <li><a href="">公司春节保供电工作进入关键时期</a></li>
                </div>
            </div>
        </div>
    </div>

</template>
<script>
    export default {
        data () {
            return {}
        },
        mounted() {
            this.yearChart();
            this.monthChart();
        },
        components : {
            //'vue-event-calendar': require('vue-event-calendar')
        },
        methods: {
            yearChart(){
                let chart = this.echarts.init(document.getElementById('totalChart'))
                chart.setOption({
                    color:['#27c24c','#eb6100'],
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    series: [
                        {
                            name:'年度电量',
                            type:'pie',
                            radius: ['50%', '70%'],
                            avoidLabelOverlap: false,
                            labelLine: {
                                normal: {
                                    show: false
                                }
                            },
                            data:[
                                {value:310, name:'剩余电量'},
                                {value:335, name:'签约电量'}

                            ]
                        }
                    ]
                });
            },
            monthChart() {
                // 基于准备好的dom，初始化echarts实例
                let chart = this.echarts.init(document.getElementById('monthChart'))
                // 绘制图表
                chart.setOption({
                   /* color:'#9be8ad',*/
                title: {
                        x:'12px',
                        y:'12px',
                        text:'本周电量实际消费',
                        textStyle:{
                            fontWeight:'600',
                            //字体大小
                            fontSize:16
                        },
                        subtext:'7天电量使用情况统计',
                        subtextStyle:{
                            //文字颜色
                            color:'#999999',
                            fontWeight:'normal',
                            //字体大小
                            fontSize:12
                        }
                    },
                    tooltip: {},
                    grid: [{
                        top:70,
                        left: 60,
                        right: 30,
                        bottom:30
                    }],
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: [820, 932, 901, 934, 1290, 1330, 1320],
                        type: 'line',
                        areaStyle: {}
                    }]
                });
            }
        }
    }
</script>
<style>
    .week-charts{
        background-color: #fff;
        border-radius: 3px;
        overflow: hidden;
    }
    .week-charts > .charts{
        float: left;width:80%;overflow: hidden;
    }
    .data-progress{padding: 20px;width:20%;float: left;height:100%}
    .progress{background-color: #fff;height: .6rem;}
    .data-progress .items{padding-top: 15px;line-height: 24px}
    .data-progress .items .text span{float: right}
    .data-progress .items.purple .progress-bar{
        background-color: #7266ba!important;
    }
    .data-progress .items.purple span{
        color: #7266ba
    }
    .data-progress .items.blue .progress-bar{
        background-color: #23b7e5!important;
    }
    .data-progress .items.blue span{
        color: #23b7e5
    }
    .data-progress .items.yellow .progress-bar{
        background-color: #f8b551!important;
    }
    .data-progress .items.yellow span{
        color: #f8b551
    }
    .data-progress p{padding-top: 15px;color:#9da6b0;font-size: 12px;}
    .slider{
        background-color: #fefefe;
    }
    .table-list{}
    .table-list div.thead{
        border-bottom:1px #dfdfdf solid;
        padding: 0;
    }
    .table-list div.thead p{
        border-bottom: 2px #23b7e5 solid;
        display: inline-block;
        padding-top: 15px;
        padding-bottom: 10px;
        margin: 0;
        bottom:-1px;
        position: relative;
    }
    .table-list div.lists{
        padding-top: 15px;
    }
    .table-list div.lists li{
        padding-top: 4px;
        padding-bottom: 4px;
    }
    .calendar .comp-full-calendar{
        padding: 0;
        padding-right: 15px;
    }
    .calendar .full-calendar-body .dates .dates-events .events-week .events-day{
        min-height: 60px;overflow: hidden;
    }
</style>