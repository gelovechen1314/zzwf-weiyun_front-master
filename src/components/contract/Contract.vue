<template>
    <div class="hbox">
        <div class="col left">
            <div class="header">
                	合同
            </div>
            <div class="wrapper">
                <b-nav pills vertical>
                	 <b-nav-item>售电合同</b-nav-item>
                    <b-nav-item >长协合同</b-nav-item>
                    <b-nav-item >合同模板</b-nav-item>
                   
                </b-nav>
            </div>
        </div>
        <div class="col">
            <router-view></router-view>
        </div>
    </div>
</template>
<script>
    
</script>
<style scoped="scoped">
	.col{
		padding-bottom:20px;
		
	}
</style>