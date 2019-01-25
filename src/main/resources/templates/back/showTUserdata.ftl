<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>测试普通用户列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${base}/static/layui/dist/css/layui.css"
	media="all">
<script src="${base}/static/jquery/jQuery-2.2.0.min.js"></script>
<script src="${base}/static/jquery/artTemp.js"></script>

	<link rel="stylesheet" href="${base}/static/elementui/index.css" media="all">
	<script src="${base}/static/elementui/vue.min.js"></script><#--使用element必须先引用vue-->
	<script src="${base}/static/elementui/index.js"></script>
	<#--vue的ajax请求-->
	<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>





</head>
<body>
<div id="app">
	<input type="hidden" id="pageValue" value="1">
	<input type="hidden" id="sizeValue" value="10">
	<div class="layui-row">
		<div class="layui-col-md12">
			<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend style="color: #888;">普通用户列表</legend>
			</fieldset>
			<div class="layui-form " style="margin-top: 1%;">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">姓名</label>
						<div class="layui-input-inline">
							<input type="text" id="thename" name="number" autocomplete="off"
								   class="layui-input">
						</div>
						<button class="layui-btn" @click="queryAllTUserData()">搜索</button>
					</div>
				</div>
			</div>

			<div style="padding-bottom: 100px;height: 100%;">
				<div style="border-bottom:solid 2px;border-top:solid 2px;border-top-color: #e6e6e6;border-bottom-color: #009688;">
					<div>
						<#-- 展示后台返回数据的 模板-->
						<el-table :data="msg"  style="width: 100%;">
							<el-table-column type="selection" style="width: 5%;">
							</el-table-column>
							<el-table-column type="index" style="width: 5%;">
							</el-table-column>
							<el-table-column prop="id" label="id" style="width: 5%;" sortable>
							</el-table-column>
							<el-table-column prop="username" label="姓名" style="width: 10%;" sortable>
							</el-table-column>
							<el-table-column prop="powerid" label="权限" style="width: 5%;"  sortable>
							</el-table-column>
							<el-table-column prop="headimg" label="头像" style="width: 15%;" >
							</el-table-column>
							<el-table-column prop="lastuptime" label="上次更改时间" style="width: 10%;" sortable>
							</el-table-column>
							<el-table-column prop="creattime" label="创建时间" style="width: 10%;" sortable>
							</el-table-column>
							<el-table-column label="操作" style="width: 20%;">
								<template scope="scope">
									<el-button size="small">编辑</el-button>
									<el-button type="danger" size="small">删除</el-button>
								</template>
							</el-table-column>
						</el-table>
					</div>

					<div style="padding-top: 10px;">
						<template>
							<div class="block" style="text-align: center;">
								<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage"
											   :page-sizes="[5, 10, 30, 50, 100]"
											   :page-size="10"
											   layout="total, sizes, prev, pager, next<#--, jumper-->"
											   :total="total"
											   background >
								</el-pagination>
							</div>
						</template>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>

	<script src="${base}/static/layui/dist/layui.js" charset="utf-8"></script>
	<script src="${base}/static/js/common/common.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>

	window.onload = function(){
		var vm = new Vue({
			el:'#app',
			data:{
				msg:'',
				currentPage: 1,//默认当前页
				total:15
			},
			methods:{
				queryAllTUserData:function(){
					//发送 post 请求
					var thename=$("#thename").val();
					var params = {
						page:$("#pageValue").val()
						,limit:$("#sizeValue").val()
						,name:thename
						,order:"id"
					} ;
					this.$http.post('${base}/tuserdataController/tuserdatalist',params,{emulateJSON:true}).then(function(res){
						//document.write(res.body);
						this.msg = res.body.list;
						console.log(res.body.list);

					},function(res){
						console.log("后台管理-普通用户列表请求失败");
					});
					/*$.post('/tuserdataController/tuserdatalist',params,function(data){
						console.log(data.list);
						this.msg = data;
					})*/
				},
				handleSizeChange(val) {
					$("#sizeValue").val(val);
					this.queryAllTUserData();
					console.log('每页 ' + val + ' 条');
				},
				handleCurrentChange(val) {
					$("#pageValue").val(val);
					this.queryAllTUserData();
					console.log('当前页: '+ val);
				}
			},
			mounted() {
				this.queryAllTUserData();
			}
		});
	}

	//分页
	/*var Main = {
		methods: {
			handleSizeChange(val) {
				console.log(`每页 100 条`);
			},
			handleCurrentChange(val) {
				console.log(`当前页: 1`);
			}
		},
		data() {
			return {
				currentPage1: 5,
				currentPage2: 5,
				currentPage3: 5,
				currentPage4: 4
			};
		}
	}
	var Ctor = Vue.extend(Main)
	new Ctor().$mount('#app')*/
</script>

</body>
</html>