<template>
	<div class="box" v-if="flag">
		<span></span><slot class="leftSlot" name="headerBar"></slot>
		
	</div>
	<div class="box" v-else>
		<span></span><slot class="leftSlot" name="headerBar"></slot>
		<slot name="seeMore" class="rightSlot" v-if="true"></slot>
	</div>
</template>

<script>
	 export default {
    props: {
    	flag: {
        type: Boolean,
        default: true
      }
    },
    data(){
      return {
      	
      };
    },
    methods: {
//      click_mask(){
//        this.$emit('click_mask');
//      }
    }
  }
</script>

<style scoped="scoped">
	.box{
		width:100%;
		height:100%;
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		line-height:100%;
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
		width:4px;
		display:inline-block;
		height:14px;
		background:#37b3e0;
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