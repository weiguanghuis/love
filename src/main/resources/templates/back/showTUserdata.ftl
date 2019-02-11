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
	<#--<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>-->

<style>
	.add-user-class{
		display: inline-block;
		height: 38px;
		line-height: 38px;
		padding: 0 18px;
		background-color: #009688 !important;
		color: #fff !important;
		white-space: nowrap;
		text-align: center;
		font-size: 14px;
		border: none;
		border-radius: 2px;
		cursor: pointer;

	}

</style>



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
                    <div class="layui-inline">
                        <label class="layui-form-label"></label>
                        <div class="layui-input-inline">
                            <#--<button class="layui-btn"  id="addPat">添加用户信息</button>-->
							<!-- Form -->
							<el-button type="text" @click="showAddUserBox" class="add-user-class">添加用户信息</el-button>
                        </div>

                    </div>
				</div>
			</div>

			<div style="padding-bottom: 100px;height: 100%;">
				<div style="border-bottom:solid 2px;border-top:solid 2px;border-top-color: #e6e6e6;border-bottom-color: #009688;">
					<div>
						<#-- 展示后台返回数据的 模板-->
						<el-table :data="msg"  style="width: 100%; text-align: center" stripe="true">
							<el-table-column type="selection" style="width: 5%;" >
							</el-table-column>
							<el-table-column type="index" label="序号" style="width: 5%;" >
							</el-table-column>
							<el-table-column prop="id" label="id" style="width: 5%;" sortable v-if="show=false">
							</el-table-column>
							<el-table-column prop="username" label="姓名" max-width style="width: 10%;" sortable>
							</el-table-column>
							<el-table-column prop="powerid" label="权限" min-width="50px" sortable>
							</el-table-column>
							<el-table-column prop="headimg" label="头像" :show-overflow-tooltip="true" style="width: 10%;" >
							</el-table-column>
							<el-table-column prop="lastuptimestr" label="上次更改时间"  :formatter="formatterDate" style="width: 10%;" sortable>
							</el-table-column>
							<el-table-column prop="creattimestr" label="创建时间" :formatter="formatterDate" style="width: 10%;" sortable>
							</el-table-column>
							<el-table-column label="操作" min-width="150px">
								<template scope="scope">
									<el-button size="small" type="primary" @click="editUser(scope.$index,scope.row)" >编辑</el-button>
									<el-button size="small" type="info" @click="showUser(scope.$index,scope.row)" >查看</el-button>
									<el-button size="small" type="danger" @click="delUser(scope.$index,scope.row)">删除</el-button>
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

	<#--弹出框-新增用户-->
	<el-dialog :title='dialogTitle' :visible.sync="dialogFormVisible"  style="display: none;">
		<el-form :model="form" style="display: none;">
			<el-form-item label="用户id" :label-width="formLabelWidth">
				<el-input v-model="form.id" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<el-form :model="form">
			<el-form-item label="用户名称" :label-width="formLabelWidth">
				<el-input v-model="form.username" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<el-form :model="form">
			<el-form-item label="用户权限" :label-width="formLabelWidth">
				<el-radio-group v-model="form.powerid">
					<el-radio :label="1" name="" >默认权限1</el-radio>
					<el-radio :label="2" name="">权限2</el-radio>
					<el-radio :label="3" name="">权限3</el-radio>
					<el-radio :label="4" name="">权限4</el-radio>
				</el-radio-group>
			</el-form-item>

		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button @click="dialogFormVisible = false">取 消</el-button>
			<el-button type="primary" @click="submint">确 定</el-button>
		</div>
	</el-dialog>

	<#--查看用户-->
	<el-dialog title="查看用户" :visible.sync="dialogFormVisibleShowUser" id="changeTitle"  style="display: none;">
		<el-form :model="form_showUser" >
			<el-form-item label="id" :label-width="formLabelWidth">
				<el-input v-model="form_showUser.id" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<el-form :model="form_showUser" >
			<el-form-item label="用户名" :label-width="formLabelWidth">
				<el-input v-model="form_showUser.username" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<el-form :model="form_showUser" >
			<el-form-item label="openid" :label-width="formLabelWidth">
				<el-input v-model="form_showUser.openid" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<el-form :model="form_showUser" >
			<el-form-item label="token" :label-width="formLabelWidth">
				<el-input v-model="form_showUser.token" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<el-form :model="form_showUser" >
			<el-form-item label="头像" :label-width="formLabelWidth">
				<el-input v-model="form_showUser.headimg" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<el-form :model="form_showUser" >
			<el-form-item label="上次修改时间" :label-width="formLabelWidth">
				<el-input v-model="form_showUser.lastuptimestr" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<el-form :model="form_showUser">
			<el-form-item label="创建时间" :label-width="formLabelWidth">
				<el-input v-model="form_showUser.creattimestr" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<el-form :model="form_showUser">
			<el-form-item label="权限" :label-width="formLabelWidth">
				<el-radio-group v-model="form_showUser.powerid">
					<el-radio :label="1" name="" >默认权限1</el-radio>
					<el-radio :label="2" name="">权限2</el-radio>
					<el-radio :label="3" name="">权限3</el-radio>
					<el-radio :label="4" name="">权限4</el-radio>
				</el-radio-group>
			</el-form-item>
		</el-form>
		<el-form :model="form_showUser">
			<el-form-item label="状态" :label-width="formLabelWidth">
				<el-input v-model="form_showUser.status" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button @click="dialogFormVisibleShowUser = false">发回</el-button>
		</div>
	</el-dialog>

</div>

	<script src="${base}/static/layui/dist/layui.js" charset="utf-8"></script>
	<script src="${base}/static/js/common/common.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
	var vm = new Vue({
		el:'#app',
		data:{
			msg:'',
			currentPage: 1,//默认当前页
			total:0,
			dialogFormVisible: false,
			dialogFormVisibleShowUser: false,
			dialogTitle:'',
			form: {
				id:0,
				username: '',
				powerid: 1
			},
			form_showUser: {
				id:0,
				openid: '',
				token: '',
				username: '',
				headimg: '',
				lastuptimestr: '',
				creationTimestr: '',
				powerid: 0,
				status: 0
			},
			formLabelWidth: '120px'

		},
		methods:{
			queryAllTUserData:function(){
				//发送 post 请求
				var thename=$("#thename").val();
				var params = {
					page:$("#pageValue").val()
					,limit:$("#sizeValue").val()
					,name:thename
					,order:"creattime desc"
				} ;
				/*this.$http.post('${base}/tuserdataController/tuserdatalist',params,{emulateJSON:true}).then(function(res){
					this.msg = res.body.list.data;
					this.total = res.body.list.count;
				},function(res){
					console.log("后台管理-普通用户列表请求失败");
				});*/
				$.post('${base}/tuserdataController/tuserdatalist',params,function(data){
					vm.msg = data.list.data;
					vm.total = data.list.count;
				},"JSON")
			},
			handleSizeChange(val) {
				$("#sizeValue").val(val);
				this.queryAllTUserData();
				//console.log('每页 ' + val + ' 条');
			},
			handleCurrentChange(val) {
				$("#pageValue").val(val);
				this.queryAllTUserData();
				//console.log('当前页: '+ val);
			},
			submint(){
				this.dialogFormVisible = false;
				//新增用户
				var username = this.form.username;
				var powerid = this.form.powerid;
				var id = this.form.id;
				var params = {
					id:id,
					username:username,
					powerid:powerid
				}
				if(vm.form.id == 0){
					$.post('${base}/tuserdataController/addUser',params,function(data){
						//console.log(data)
						if(data == 1){
							vm.$alert('新增用户成功', '提示', {
								confirmButtonText: '确定',
								callback: action => {
									window.location.href="${base}/tuserdataController/showTUserdata.html"
								}
							});
						}else{
							vm.$message.error('新增用户失败！');
						}
					},"JSON")
				}else{
					$.post('${base}/tuserdataController/updateUser',params,function(data){
						//console.log(data)
						if(data == 1){
							vm.$alert('修改用户成功', '提示', {
								confirmButtonText: '确定',
								callback: action => {
									window.location.href="${base}/tuserdataController/showTUserdata.html"
								}
							});
						}else{
							vm.$message.error('修改用户失败！');
						}
					},"JSON")
				}
				return;


			},
			showAddUserBox(){
				vm.dialogTitle = '新增用户';
				//初始化
				vm.form.id=0;
				vm.form.username='';
				vm.form.powerid=1;
			//	vm.form.resetFields();
				vm.dialogFormVisible = true
			},
			editUser(index,row){
				vm.dialogFormVisible = true;
				vm.form = Object.assign({}, row);
				vm.dialogTitle = '编辑用户';
			},
			showUser(index,row){
				vm.dialogFormVisibleShowUser = true;
				vm.form_showUser = Object.assign({}, row);
			},
			delUser(index,row){
				this.$confirm('是否删除用户【' + row.username + '】？', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					$.post('${base}/tuserdataController/deleteUser',"id=" + row.id,function(data){
						//console.log(data)
						if(data == 1){
							vm.$alert('删除用户成功', '提示', {
								confirmButtonText: '确定',
								callback: action => {
									window.location.href="${base}/tuserdataController/showTUserdata.html"
								}
							});
						}else{
							vm.$message.error('删除用户失败！');
						}
					},"JSON")
				});
			},
			formatterDate(row, column, value){
				//console.log(value)
				return value.split(" ")[0];
			}
		},
		mounted() {
			this.queryAllTUserData();
		}
	});

</script>

</body>
</html>