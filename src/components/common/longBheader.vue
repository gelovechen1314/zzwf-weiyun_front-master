<template>
	<div class="box" >
		<span></span><slot class="leftSlot" name="headerBar"></slot>
	</div>
</template>

<script>
</script>

<style scoped>
	
	.box{
		width:100%;
		/*height:100%;*/
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		line-height:34px;
		font-size:20px;
	}
	.box:after{
		　content:"";
　　　　　　height:0;
　　　　　　line-height:0;
　　　　　　display:block;
　　　　　　visibility:hidden;
　　　　　　clear:both
	}
	.box span{
		width:7px;
		display:inline-block;
		height:32px;
		background:#3399ff;
		margin-right:5px;
		float:left;
	}
	.leftSlot{
		float:left;
	}
	.rightSlot{
		width:20%;
		float:right;
		text-align:right;
	}
</style>