<template>
	<div>
		<div class="header titleHea">
			<span>客户管理</span>
			<p><a href="/"><em class="iconfont">&#xe778;</em>首页：</a><b>客户></b><b>客户总览</b></p>
		</div>
		<div class="wrapper-md wrapperBox">
			<div class="mainCon">
				<div class="navLists">
					<b-button class="btnA" to="/customer/customermanagement/">客户导入</b-button>
					<b-button class="btnA" to="/customer/customermanagement/incrementalacquisition">增量采集</b-button>
					<b-button class="btnA" to="/customer/customermanagement/customermigration">客户迁移</b-button>
				</div>
				 <div class="con">
				 	<router-view></router-view>
				 </div>
			</div>
			
		</div>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				
			}
		},
		components:{
        	
        },
		mounted(){
			this.navClick()
		},
		methods:{
			navClick(){
				$('.navLists a').on('click',function(){
					console.log($(this).index())
				$(this).addClass('active').siblings().removeClass('active')
			})
			}
		},
        computed: {
			
        },
	}
</script>

<style scoped="scoped">
	.titleHea {
		padding: 0px;
		height: 58px;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom:1;
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
	
	.wrapperBox{
		padding:10px 0 0 24px;
		background:#edf1f2;
	}
	.mainCon{
		background:#fff;
	}
	.navLists{
		width:100%;
		height:43px;
		border-bottom:1px solid #cccccc;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom:1;
	}
	.navLists:after{
		content: "";
		height: 0;
		line-height: 0;
		display: block;
		visibility: hidden;
		clear: both
	}
	.navLists .btn{
		display:inline-block;
		width:136px;
		height:42px;
		line-height:42px;
		padding:0px;
		color:#000;
		background:#fff;
		float:left;
		font-size:18px;
		text-align: center;
		text-decoration: none;
		border:none;
	}
	.btn-secondary:not(:disabled):not(.disabled).active{
		color:#fff;
		background:#0099ff;
		box-shadow: none;
	}
	.navLists a:hover
		{
			color:#fff;
			background:#0099ff;
		}
	.navLists .btnA a:active
		{
			color:#fff;
			background:#0099ff;
		}
	.navLists .active
		{
			color:#fff;
			background:#0099ff;
		}
	.con{
		width:100%;
		height:100%;
		background:#fff;
	}
</style>