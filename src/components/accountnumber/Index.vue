<template>
	<div class="wraperBox">
		<div class="header titleHea">
			<span>账号管理</span>
			<p><a href="/"><em class="iconfont">&#xe778;</em>首页</a>：<b>账号></b><b>个人资料</b></p>
		</div>
		<div class="wrapper-md">
			
			

		</div>
	</div>
</template>
<script>
	import TreeList from 'vue-jstree';
	import headerBar from "../common/headerBar.vue";
	export default {
		components: {
			TreeList,
			headerBar
		},
		data() {
			return {
				
			}
		},
		mounted() {
			
		},
		methods: {
			

			}
		
	}
</script>
<style scoped="scoped">
	.wraperBox {
		width: 100%;
	}
	
	.titleHea {
		padding: 0px;
		height: 58px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
	}
	
	.titleHea:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.titleHea span {
		display: inline-block;
		padding: 0px 20px;
		line-height: 58px;
		border-bottom: 2px solid #0099ff;
	}
	
	.titleHea p {
		display: block;
		float: right;
		text-align: right;
		width: 80%;
		line-height: 58px;
		font-size: 14px;
	}
	
	
	.titleHea p b {
		font-weight: normal;
	}
	
	.txtCon {
		width: 100%;
		height: 20px;
		line-height: 20px;
	}
	
	.chartWrap {
		width: 100%;
		margin-bottom: 20px;
	}
	
	.monthChartWrap {
		width: 100%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
	}
	
	.monthChartWrap:after {
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	
	.monthChartLeft {
		width: 59%;
		float: left;
		margin-right: 2%;
	}
	
	.monthChartWrap .monthCon {
		width: 100%;
		height: 20px;
	}
	
	.monthCon p {
		float: left;
		width: 70%;
	}
	
	.monthCon a {
		float: right;
		text-align: right;
		width: 20%;
		color: #000;
		text-decoration: none;
	}
	
	.monthCon a:hover {
		color: #005DE6;
	}
	
	#monthElecChartBar {
		width: 100%;
	}
	
	.monthTxtRight {
		float: right;
		width: 39%;
	}
	
	.singLe p {
		width: 90%;
	}
</style>