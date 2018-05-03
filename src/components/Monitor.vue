<template>
	<div class="hbox">
		<div class="col left">
			<div class="header">
				系统监控
			</div>
			<div class="wrapper">
			<b-nav pills vertical>
			    <b-nav-item active>电量监测</b-nav-item>
			    <b-nav-item>负荷监测</b-nav-item>
			    <b-nav-item>电流监测</b-nav-item>
			    <b-nav-item>功率因数监测</b-nav-item>
			    <b-nav-item>数据采集</b-nav-item>
			    <b-nav-item>用电监控</b-nav-item>
			    <b-nav-item>设备监测</b-nav-item>
			</b-nav>
			</div>
		</div>
		<div class="col">
			<div class="header">负载率分析</div>
		</div>
		<div class="col right">
			<div class="header">
				选择企业
			</div>
			<div class="wrapper">
			<form action="">
				<div class="form-group">
					<input type="text" class="form-control"  @keyup="SearchCompany" v-model="companyKeyword">
				</div>
			</form>
			<TreeList :data="companys" noDots  @item-click="itemClick" ref="tree"></TreeList>
			</div>
		</div>
	</div>
</template>
<script>
	import TreeList from 'vue-jstree';
	export default {
        components:{TreeList},
        data () {
            return {
                companyKeyword: '',
                companys:[
					{
					    "text":"郑州市",
                        "icon": "",
                        "opened": true,
						"children":[
							{
                                "text":"登封市鑫浩耐磨材料有限公司",
                                "children":[
									{
                                        "text": "户号(509273589)"
									},
                                    {
                                        "text": "户号(509273560)"
                                    }
                                ]
							},
							{
							    "text":"河南省鸿润建材发展有限公司"
							},
                            {
                                "text":"河南金水电缆集团有限公司"
                            }
						]
					},
					{
                        "text":"开封市",
					},
                    {
                        "text":"平顶山市",
                    },
                    {
                        "text":"洛阳市",
                    }
				]
			}
        },
        methods: {
            itemClick (node) {
                console.log(node.model.text + ' clicked !')
            },
            SearchCompany: function () {
                var text = this.companyKeyword
                const patt = new RegExp(text);
                this.$refs.tree.handleRecursionNodeChilds(this.$refs.tree, function (node) {
                    if (text !== '') {
                        const str = node.model.text
                        if (patt.test(str)) {
                            node.$el.querySelector('.tree-anchor').style.color = 'red';
                            var el = node.$el.querySelector('.tree-anchor');
                            el.parentElement.parentElement.previousElementSibling.closest("div").style.color = 'red';
                        } else {
                            node.$el.querySelector('.tree-anchor').style.color = '#000'
                        } // or other operations
                    } else {
                        node.$el.querySelector('.tree-anchor').style.color = '#000'
                    }
                })
            }
        }
	}
</script>