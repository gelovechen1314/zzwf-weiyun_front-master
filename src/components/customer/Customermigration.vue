<template>
	<div class="contentCon">
		<div class="conBox">
			<div class="leftCon">
				<longBheader class="txtCon">
					<p slot="headerBar">选择居间</p>
				</longBheader>
				<div class="listsBox">
					<ul class="compLists">
						<li>郑州耀光科技有限公司</li>
						<li>郑州耀光科技有限公司</li>
						<li>郑州耀光科技有限公司</li>
						<li>郑州耀光科技有限公司</li>
						<li>郑州耀光科技有限公司</li>
					</ul>
				</div>
			</div>
			<div class="leftCon">
				<longBheader class="txtCon">
					<p slot="headerBar">选择业务员</p>
				</longBheader>
				<div class="listsBox scrollLists">
					<div class="nameLists">
						<h6>业务一部</h6>
						<ul class="lists">
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							
						</ul>
					</div>
				</div>
			</div>
			<div class="leftCon">
				<longBheader class="txtCon">
					<p slot="headerBar">选择导入业务员</p>
				</longBheader>
				<div class="listsBox scrollLists">
					<div class="nameLists">
						<h6>业务一部</h6>
						<ul class="lists">
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							
						</ul>
					</div>
					<div class="nameLists">
						<h6>业务一部</h6>
						<ul class="lists">
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							
						</ul>
					</div>
					<div class="nameLists">
						<h6>业务一部</h6>
						<ul class="lists">
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							<li>孙悟空</li>
							
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import "../../assets/css/com.css";
	import longBheader from "../common/longBheader.vue";
	export default{
		data(){
			return{
				
			}
		},
		components: {
			longBheader,
		},
	}
</script>

<style scoped="scoped">
	.contentCon{
		width:100%;
	}
	.conBox{
		width:100%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		zoom:1;
		margin-top:24px;
		margin-bottom:200px;
	}
	.conBox:after{
		content:"";
		line-height:0;
		height:0;
		visibility: hidden;
		clear:both;
		display:block;
	}
	.txtCon p{
		font-size:16px;
		color:#4c4c4c;
	}
	.leftCon{
		float:left;
		width:300px;
		margin-left:20px;
	}
	.listsBox{
		width:100%;
		height:180px;
		color:#000;
		border:1px solid #dcdcdc;
	}
	.compLists{
		padding:15px 18px;
	}
	.compLists li{
		font-size:12px;
	}
	.nameLists h6{
		font-size:12px;
		
	}
	.lists{
		padding:0px 18px 10px;
	}
	.lists li{
		font-size:12px;
	}
	.scrollLists{
		overflow-y: scroll;
	}
</style>