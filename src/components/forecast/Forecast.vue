<template>
	<div class="hbox">
		<div class="col left">
			<div class="header" >
				购电辅助决策
			</div>
			<div class="wrapper">
			<b-nav pills vertical>
			    <b-nav-item to="/forecast/annualelectricityforecast">年度电量预测</b-nav-item>
			    <b-nav-item to="/forecast/monthlyelectricityforecast">月度电量预测</b-nav-item>
			     <b-nav-item to="/forecast/userdeclaration">用户申报</b-nav-item>
			    <b-nav-item to="/forecast/electricitybillmanagement">电费单管理</b-nav-item>
			</b-nav>
			</div>
		</div>
		<div class="col">
			<router-view></router-view>
		</div>
		<!--<div class="col right">
			<div class="header">

			</div>
			<div class="wrapper">
				<form action="">
					<div class="form-group">
						<input type="text" class="form-control" @keyup="SearchCompany" v-model="companyKeyword">
					</div>
				</form>
				<TreeList :data="companys" noDots @item-click="itemClick" ref="tree"></TreeList>
			</div>
		</div>-->
	</div>
</template>

<script>
	import TreeList from 'vue-jstree';
	 export default {
	 	components: {
			TreeList,
			
		},
        data() {
			return {
				flag: false,
				companyKeyword: '',
				companys: [{
						"text": "郑州市",
						"icon": "",
						"opened": true,
						"children": [{
								"text": "登封市鑫浩耐磨材料有限公司",
								"children": [{
										"text": "户号(509273589)"
									},
									{
										"text": "户号(509273560)"
									}
								]
							},
							{
								"text": "河南省鸿润建材发展有限公司"
							},
							{
								"text": "河南金水电缆集团有限公司"
							}
						]
					},
					{
						"text": "开封市",
					},
					{
						"text": "平顶山市",
					},
					{
						"text": "洛阳市",
					}
				]
			}
		},
        components:{
        	
        },
        computed: {

        },
        methods:{
           itemClick(node) {
				console.log(node.model.text + ' clicked !')
			},
			SearchCompany: function() {
				var text = this.companyKeyword
				const patt = new RegExp(text);
				this.$refs.tree.handleRecursionNodeChilds(this.$refs.tree, function(node) {
					if(text !== '') {
						const str = node.model.text
						if(patt.test(str)) {
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
			},
        }
    }
	
	
</script>

<style>
</style>