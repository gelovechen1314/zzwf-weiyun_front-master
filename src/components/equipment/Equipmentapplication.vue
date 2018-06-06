<template>
	<div class="contentCon">
		<div class="header titleHea">
			<span>设备申请</span>
		</div>
		<div class="searchCon">
			<p>
				<el-input placeholder="请输入内容" v-model="input23">
					<i slot="prefix" class="el-input__icon el-icon-search"></i>
				</el-input>
				<el-button class="seraBtn" type="primary">搜索</el-button>
			</p>
			<span> <el-date-picker
				style="width:120px;margin-right:10px;height:20px;background:#eaf6fe;color:#2d8cf0;"
      v-model="value1"
      type="year"
      placeholder="2018">
    </el-date-picker><i class="el-icon-refresh el-icon"></i></span>
		</div>
		<div class="tablbWrap">
			<el-table height="500" :data="tableData5" size="mini" style="width: 100%;border-top:1px solid #ebeef5;"row-key="id"
            :expand-row-keys="expands" >
				<el-table-column class="temp" type="expand">
					<template slot-scope="props">
						<el-form label-position="left" inline class="demo-table-expand">
							<el-form-item label="配电方式">
								<span>{{ props.row.name }}</span>
							</el-form-item>
							<el-form-item label="所属店铺">
								<span>{{ props.row.shop }}</span>
							</el-form-item>
							<el-form-item label="商品 ID">
								<span>{{ props.row.id }}</span>
							</el-form-item>
							<el-form-item label="店铺 ID">
								<span>{{ props.row.shopId }}</span>
							</el-form-item>
							<el-form-item label="商品分类">
								<span>{{ props.row.category }}</span>
							</el-form-item>
							<el-form-item label="店铺地址">
								<span>{{ props.row.address }}</span>
							</el-form-item>
							<el-form-item label="商品描述">
								<span>{{ props.row.desc }}</span>
							</el-form-item>
						</el-form>
					</template>
				</el-table-column>
				<el-table-column label="公司名称" prop="id">
				</el-table-column>
				<el-table-column v-modal="item" width="60" label='申报编号' prop="shopId">
				</el-table-column>
				<el-table-column label="申请日期" prop="desc">
				</el-table-column>
				<el-table-column prop="tag" label="是否有电工" width="100" :filters="[{ text: '是', value: '是' }, { text: '否', value: '否' }]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="tag" label="是否自主安装" width="100" :filters="[{ text: '是', value: '是' }, { text: '否', value: '否' }]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column label="负责人" prop="shopId">
				</el-table-column>
				<el-table-column label="手机号" prop="shopId">
				</el-table-column>
				<el-table-column label="计划安装日期" prop="shopId">
				</el-table-column>
				<el-table-column prop="tag" label="状态" width="100" :filters="[{ text: '审核中', value: '审核中' }, { text: '待安装', value: '待安装' },{ text: '已安装', value: '已安装' },{ text: '未通过', value: '未通过' }]" :filter-method="filterTag" filter-placement="bottom-end">
					<template slot-scope="scope">
						<el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'" disable-transitions>{{scope.row.tag}}</el-tag>
					</template>
				</el-table-column>
				<el-table-column label="实际安装人" prop="shopId">
				</el-table-column>
				<el-table-column fixed="right" label="操作" width="100">
					<template slot-scope="scope">
						<el-button type="text" @click="modal1 = true" size="small">指定安装人</el-button>
						<el-button @click="handleClick(scope.row)" type="text" size="small">详情</el-button>

					</template>
				</el-table-column>
			</el-table>
		</div>
		<div class="panginatoinPage">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :background='true' :current-page="currentPage4" :page-sizes="[100, 200, 300, 400]" :page-size="100" layout="total, sizes, prev, pager, next, jumper" :total="400">
			</el-pagination>
		</div>

	</div>
</template>

<script>
	import "../../assets/css/com.css"
	export default {
		data() {
			return {
				currentPage4: 4,
				value1:'',
				  expands: [],
				modal1: false,
				labelData: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
				tableData5: [{
					id: '12987122',
					name: 'gsfhdhfh',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333',
					tag: '已安装'
				}, {
					id: '12987123',
					name: '发货收到方向键',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333',
					tag: '已安装'
				}, {
					id: '12987125',
					name: '过放电是否能',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333',
					tag: '已安装'
				}, {
					id: '12987126',
					name: '好滋好味鸡蛋仔',
					category: '江浙小吃、小吃零食',
					desc: '荷兰优质淡奶，奶香浓而不腻',
					address: '上海市普陀区真北路',
					shop: '王小虎夫妻店',
					shopId: '10333',
					tag: '已安装'
				}]
			}
		},
		methods: {

			handleSizeChange(val) {
				console.log('每页 ${val} 条');
			},
			handleCurrentChange(val) {
				console.log('当前页: ${val}');
			},
			formatter(row, column) {
				return row.address;
			},
			handleClick(row) {
                Array.prototype.remove = function (val) {
                    let index = this.indexOf(val);
                    if (index > -1) {
                        this.splice(index, 1);
                    }
                };
 
                if (this.expands.indexOf(row.id) < 0) {
                    this.expands.push(row.id);
                } else {
                    this.expands.remove(row.id);
                }
 
            
			}
		}
	}
</script>

<style scoped="scoped">
	/*@import url("../../assets/css/com.css")*/
	
	.contentCon {
		margin: 10px;
		background: #fff;
		height: 98%;
		border: .5px solid #e9eaec;
		padding-bottom: 100px;
		overflow-y: scroll;
		position: relative;
	}
	
	.contentCon:hover {
		box-shadow: 0px 0px 5px 1px #ccc;
	}
	
	.searchCon {
		padding: 12px;
	}
	
	.searchCon p {
		display: inline-block;
		width: 30%;
		height: 38px;
		position: relative;
	}
	
	.searchCon span {
		float: right;
		height: 40px;
		line-height: 40px;
	}
	
	.el-icon {
		color: #2d8cf0;
		font-size: 20px;
		font-weight: 900;
		padding: 5px;
		background: #eaf6fe;
		border-radius: 5px;
	}
	
	.el-icon-refresh {
		margin-right: 10px;
	}
	
	.seraBtn {
		position: absolute;
		right: 0px;
		height: 40px;
		top: 0px;
		border-radius: 0px;
		border-top-right-radius: 5px;
		border-bottom-right-radius: 5px;
	}
	
	.allCustomer {
		position: absolute;
		right: -100px;
		height: 40px;
		top: 0px;
		border-radius: 0px;
	}
	
	.active {
		color: #fff;
		background-color: #409EFF;
		border-color: #409EFF;
	}
	
	.myCustomer {
		position: absolute;
		right: -198px;
		height: 40px;
		top: 0px;
		border-radius: 0px;
	}
	
	.el-icon-search {
		color: #495060;
		font-weight: 900;
	}
	
	.tablbWrap {
		margin: 10px 0px 20px;
		height: 80%;
	}
	
	.el-table thead {
		border-top: 1px solid #e9eaec
	}
	
	.el-table td,
	.el-table th.is-leaf {
		border-top: 1px solid #e9eaec
	}
	
	.tableTop {
		padding-left: 0px;
		border-top: 1px solid #e9eaec
	}
	
	.tableTop .hover_row {
		background: #ebf7ff
	}
	
	.el-table td,
	.el-table th {
		/*padding-top: 0px !important;
		padding-bottom: 0px !important;
		padding-left: 12px !important;*/
	}
	
	.panginatoinPage {
		width: 100%;
		position: absolute;
		bottom: 10px;
		margin: 10px auto;
		text-align: center;
	}
	
	.demo-table-expand {
		font-size: 0;
	}
	
	.demo-table-expand label {
		width: 90px;
		color: #99a9bf;
	}
	
	.demo-table-expand .el-form-item {
		margin-right: 0;
		margin-bottom: 0;
		width: 50%;
	}
	
	.tableCon {
		width: 100%;
		padding: 0px;
		margin: -20px -50px;
	}
	
	.tableCon td {
		line-height: 20px;
		padding: 6px 10px;
		width: 100px;
	}
	
	.el-table__expanded-cell {
		padding: 0;
	}
	
	.temp {
		padding: 0px;
	}
</style>