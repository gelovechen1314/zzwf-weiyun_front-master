<template>
	<div class="contentCon">
		<div class="buttonBox">
			<button>下载客户模板</button><button>上传客户文档</button>
		</div>
		<div class="tableCon">
			<table>
				<thead>
					<tr>
						<td>联系日期</td>
						<td>企业</td>
						<td>联系人</td>
						<td>联系电话</td>
						<td>客户来源</td>
						<td>添加日期</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>2018-02-20</td>
						<td>郑州耀光电子科技有限公司</td>
						<td>胡建辉</td>
						<td>1393902839589</td>
						<td>系统分配</td>
						<td>2019-04-29</td>
					</tr>
					<tr>
						<td>2018-02-20</td>
						<td>郑州耀光电子科技有限公司</td>
						<td>胡建辉</td>
						<td>1393902839589</td>
						<td>系统分配</td>
						<td>2019-04-29</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="pageCon">
				<div class="page" v-if="show">
					<div class="pagelist">
						<span class="jump" v-if="current_page>1" @click="current_page--">上一页</span>
						<span v-if="current_page>5" class="jump" @click="jumpPage(1)"></span>
						<span class="ellipsis" v-if="efont">...</span>
						<span class="jump" v-for="num in indexs" :class="{'bgprimary':current_page==num}" @click="jumpPage(num)">{{num}}</span>
						<span class="ellipsis" v-if="efont&&current_page<pages-4">...</span>
						<span class="jump" @click="current_page++">下一页</span>
						<span v-if="current_page<pages-1" class="jump" @click="jumpPage(pages)">{{pages}}</span>
						<span class="jumppoint">跳转到：</span>
						<span class="jumpinp"><input type="text" v-model="changePage"></span>
						<span class="jump gobtn" @click="jumpPage(changePage)">GO</span>
					</div>
				</div>
			</div>
	</div>
</template>

<script>
	import "../../assets/css/com.css";
	
	export default {
		data() {
			return { 
				current_page: 1, //当前页 
				pages: 100, //总页数 
				changePage: '', //跳转页 
				nowIndex: 0
			}
		},
		components: {
			
		},
		mounted() {
			
		},
		computed: {
			show: function() {
				return this.pages && this.pages != 1
			},
			efont: function() {
				if(this.pages <= 7) return false;
				return this.current_page > 5
			},
			indexs: function() {
				var left = 1,
					right = this.pages,
					ar = [];
				if(this.pages >= 7) {
					if(this.current_page > 5 && this.current_page < this.pages - 4) {
						left = Number(this.current_page) - 3;
						right = Number(this.current_page) + 3;
					} else {
						if(this.current_page <= 5) {
							left = 1;
							right = 7;
						} else {
							right = this.pages;

							left = this.pages - 6;
						}
					}
				}
				while(left <= right) {
					ar.push(left);
					left++;
				}
				return ar;
			},
		},

		methods: {
			jumpPage: function(id) {
				this.current_page = id;
				
			},
			currentPageJj:function(){
				this.current_page++;
				
			},
			currentPageReduce:function(){
				this.current_page--;
				
			},
		}
	}
</script>

<style scoped="scoped">
	
	.contentCon {
		width: 100%;
		padding-bottom:40px;
	}
	
	.buttonBox {
		width: 100%;
		padding: 16px 0px;
		height: 71px;
	}
	
	.buttonBox button {
		width: 118px;
		line-height: 38px;
		text-align: center;
		margin-left: 15px;
		border: none;
		color: #fff;
		font-size: 14px;
		background: #0fb8f5;
		border-radius: 2.5px;
	}
	
	.buttonBox button:hover {
		color: #fff;
		background: #20a5d5;
		cursor: pointer;
	}
	
	.buttonBox button:active {
		box-shadow: #37b3e0;
		border-color: #4e555b;
	}
	
	.tableCon {
		width: 100%;
	}
	
	.tableCon table {
		width: 100%;
	}
	
	.tableCon thead tr:nth-of-type(1) {
		background: #f2f2f2;
	}
	
	.tableCon tr td {
		line-height: 36px;
		width: 12.5%;
		text-align: center;
		font-size:14px;
	}
	
	.tableCon tr td:nth-of-type(2) {
		width: 25%;
	}
	
	.tableCon tr td:nth-of-type(6) {
		width: 25%;
	}
</style>