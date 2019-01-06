$(function () {
	$.ajaxSetup({
		async:false
	})


	layui.use(['table', 'laydate','form'], function(){
		var table = layui.table;
		var laydate = layui.laydate;
		var form = layui.form;
		 
		laydate.render({
			elem: '#date1' //需显示日期的元素选择器
				,format: 'yyyy-MM-dd HH:mm'//日期格式
			    ,type: 'datetime'
		});
		tableReload(table);
		tableonthis(table);
		statusGet();

	});
});


function submitUpdata(name){

	$.ajaxSetup({
		async:false
	})
	layer.open({
		type: 1
		,title: '确定修改信息吗？' //不显示标题栏
			,closeBtn: false
			,area: '300px;'
				,shade: 0.8
				,id: 'LAY_layuipro' //设定一个id，防止重复弹出
					,btn: ['确定删除', '取消']
	,btnAlign: 'c'
		,moveType: 1 //拖拽模式，0或者1
		,content:'<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">确定修改患者【'+name+'】信息吗？</div>'

		,yes: function(index, layero){
			$.post("/back/downpatient","id="+id,function(data){
				layer.open({
					id: 'layerDemo1'+data.code //防止重复弹出
					,content: '<div style="padding: 20px 100px;">'+ data.code +'</div>'
					,btn: '关闭'
						,btnAlign: 'c' //按钮居中
							,shade: 0 //不显示遮罩
							,yes: function(){
								layer.closeAll();
							}
				});
				var table = layui.table;
				tableReload(table);
			},"JSON")
		}
	});

}


function statusGet(){

	$("#querydata").click(function(){
		
		
		var table = layui.table;
		tableReload(table)
	});
	$("#addPat").click(function(){
		addApp();
	});

	

}
function addtime(){
	$("#addtime").click(function () {

		var starttime=$(".startTime").val();
		var getmin=$(".addme").val();
		if (starttime!=""&&getmin!=""){

			var endtime=judgFailTime(starttime,Number(getmin)).split(" ")[1];
			$("#endTime").val(starttime.split(" ")[0]+" 【"+starttime.split(" ")[1].substring(0,5)+"-"+endtime.substring(0,5)+"】");


		}

	});
	
}

function  tableReload(table){
	$.ajaxSetup({
		async:false
	})
	var dfdf='0';
	var times=$("#date1").val();
	var thename=$("#thename").val();

	var event=$(".layui-form-checked span").text();
	if(event.length==3){
		dfdf='2';
	}else if(event.length==5){
		dfdf='0,2';
	}else if(event.length==2){
		dfdf='0';
	}
	table.reload('idTest', {
		initSort: {
			field: 'id' //排序字段，对应 cols 设定的各字段名
				,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
		},
		url: '/back/showPatient',
		method:'post',
		page: true,
		limit:10,
		where: {order:'id desc',status:dfdf,times:times,name:thename}, //设定异步数据接口的额外参数
	});
}
/*单个患者资治疗历史者信息*/

function  tableReloadOnly(pid){
	var table = layui.table;
	 
	table.reload('idTests', {
		initSort: {
		    field: 'id' //排序字段，对应 cols 设定的各字段名
		    ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
		  },
		url: '/dappointmentController/dappointmentlistOnly',
		method:'post',
		page: true,
		limit:10,
		where: {order:'id desc',id:pid}, //设定异步数据接口的额外参数
	});
	
	
	layer.open({
		type: 1
		,title: false //不显示标题栏
			,closeBtn: false
			,area: '90%'
				,shade: 0.8
				,id: 'LAY_layuipro' //设定一个id，防止重复弹出
					,btn: ['确定', '取消']
	,btnAlign: 'c'
		,moveType: 1 //拖拽模式，0或者1
		,content:$(".myonly_data")

		,yes: function(index, layero){
			layer.close(index);
		}
	});
	
	
}
 
function delApp(id,name){

	$.ajaxSetup({
		async:false
	})

	layer.open({
		type: 1
		,title: '删除患者信息' //不显示标题栏
			,closeBtn: false
			,area: '300px;'
				,shade: 0.8
				,id: 'LAY_layuipro' //设定一个id，防止重复弹出
					,btn: ['确定删除', '取消']
	,btnAlign: 'c'
		,moveType: 1 //拖拽模式，0或者1
		,content:'<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">确定删除患者【'+name+'】信息吗？</div>'

		,yes: function(index, layero){
			layer.close(index);
			$.post("/back/downpatient","id="+id,function(data){
				layer.open({
					id: 'layerDemo1'+data.code //防止重复弹出
					,content: '<div style="padding: 20px 100px;">'+ data.code +'</div>'
					,btn: '关闭'
						,btnAlign: 'c' //按钮居中
							,shade: 0 //不显示遮罩
							,yes: function(){
								layer.closeAll();
							}
				});
				var table = layui.table;
				tableReload(table);
			},"JSON")
			

		}
	});
}

function showApp(id,name){

	$.ajaxSetup({
		async:false
	})
	inputdata(id);
	
	layer.open({
		id: 'layerDemo44'
		,title:'查看患者信息(可修改)'
		,type: 1
		,shadeClose:true
		,closeBtn: false
		,area: '90%'
		,shade: 0.8
		,id: 'LAY_layuipro44' //设定一个id，防止重复弹出
		,btn: ['确定修改', '取消']
		,btnAlign: 'c'
		,moveType: 1 //拖拽模式，0或者1
		,content:$(".showAll")
		,yes: function(index, layero){
			layer.close(index);
			layer.open({
				type: 1
				,title: '确定修改信息吗？' //不显示标题栏
				,area: '300px;'
				,shade: 0.8
				,id: 'LAY_layuipro34' //设定一个id，防止重复弹出
				,btn: ['确定修改', '取消']
				,btnAlign: 'b'
				,moveType: 1 //拖拽模式，0或者1
				,content:'<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">确定修改患者【'+name+'】信息吗？</div>'

				,yes: function(){
					$("#showPatientdata").submit();
				}
			});



			

		}
	});


}


function addApp(){
	
	$.ajaxSetup({
		async:false
	})
	var data={
		df:1
	}
	ShowDataLoad(data,".showAll","addPatient");
	updateFrom();
	layer.open({
		id: 'lao442'
			,title:'新增患者信息'
				,type: 1
				,shadeClose:true
				,closeBtn: false
				,area: '90%'
					,shade: 0.8
					,id: 'LAY_layuipro44' //设定一个id，防止重复弹出
						,btn: ['确定添加', '取消']
	,btnAlign: 'c'
		,moveType: 1 //拖拽模式，0或者1
		,content:$(".showAll")
		,yes: function(index, layero){
			layer.close(index);
			
			layer.open({
				type: 1
				,title: '确定添加吗？' //不显示标题栏
					,area: '300px;'
						,shade: 0.8
						,id: 'LAY_layuipro34' //设定一个id，防止重复弹出
							,btn: ['确定添加', '取消']
			,btnAlign: 'b'
				,moveType: 1 //拖拽模式，0或者1
				,content:'<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">确定添加？</div>'
				
				,yes: function(){
					$("#addPatientdata").submit();
				}
			});
			
			
			
			
			
		}
	});
	
	
}
function updateFrom(){
	var laydate = layui.laydate;
	var form = layui.form;
	form.render();
	laydate.render({
		elem: '#date11', //需显示日期的元素选择器
		event: 'click', //触发事件
		format: 'yyyy-MM-dd', //日期格式
		istime: false, //是否开启时间选择
		isclear: true, //是否显示清空
		istoday: true, //是否显示今天
		issure: true, //是否显示确认
		festival: true ,//是否显示节日
		fixed: false, //是否固定在可视区域
	});
	laydate.render({
		elem: '#date12', //需显示日期的元素选择器
		event: 'click', //触发事件
		format: 'yyyy-MM-dd', //日期格式
		istime: false, //是否开启时间选择
		isclear: true, //是否显示清空
		istoday: true, //是否显示今天
		issure: true, //是否显示确认
		festival: true ,//是否显示节日
		fixed: false, //是否固定在可视区域
	});
	laydate.render({
		elem: '#date21', //需显示日期的元素选择器
		event: 'click', //触发事件
		format: 'yyyy-MM-dd', //日期格式
		istime: false, //是否开启时间选择
		isclear: true, //是否显示清空
		istoday: true, //是否显示今天
		issure: true, //是否显示确认
		festival: true ,//是否显示节日
		fixed: false, //是否固定在可视区域
	});
	laydate.render({
		elem: '#date1' //需显示日期的元素选择器
			,format: 'yyyy-MM-dd HH:mm'//日期格式
		    ,type: 'datetime'
	});
	
}
function inputdata(id){
	$.post("/back/queryOnePatient","id="+id,function(data){
		var data={
				data:data.data
		}
		ShowDataLoad(data,".showAll","artListComment");
		
		$("#tips").val(data.data.tip);
		$("#telephones").val(data.data.telephone);
		updateFrom();

	},"JSON")

}
/**
 * 添加预约
 * @param id
 * @param name
 */
function pushApp(id,name){
	$.ajaxSetup({
		async:false
	})
	var data={
		df:1
	}
	ShowDataLoad(data,".thetestt","pushApps");
	updateFrom();
	addtime();

	layer.open({
		id: 'layerDemo44',
		title:'预约患者：【'+name+"】"
		,type: 1, 
		shadeClose:true,
		closeBtn: false
		,area: ['490px', '380px']
	,shade: 0.8
	,id: 'LAY_layuipro' //设定一个id，防止重复弹出
		,btn: ['确定预约', '取消']
	,btnAlign: 'c'
		,moveType: 1 //拖拽模式，0或者1
		,content:$(".thetestt")

		,yes: function(index, layero){
			
			var type=$(".layui-form-radioed div").html();
			var apptime=$("#endTime").val();
			var comment=$("#thecomment").val();
			var uptimes=$("#date1").val();
			if($("#date1").val()==""){
				layer.msg('请选择预约时间',{time: 1000}); 
				return;
			}
			$.post("/dappointmentController/addappointments","uptimes="+uptimes+"&pid="+id+"&name="+name+"&type="+type+"&apptime="+apptime+"&comment="+comment,function(data){

				layer.open({
					id: 'layerDemo'+data.code //防止重复弹出
					,content: '<div style="padding: 20px 100px;">'+ data.code +'</div>'
					,btn: '关闭'
						,btnAlign: 'c' //按钮居中
							,shade: 0 //不显示遮罩
							,yes: function(){
								layer.closeAll();
							}
				});

			},"JSON")
			 

			layer.close(index);

		}
	});

}			 
function balanceApp(id,name){
	$.ajaxSetup({
		async:false
	})
	var data={
		df:1
	}
	ShowDataLoad(data,".thetestt","balances");
	updateFrom();
	addtime();
	layer.open({
		id: 'layerDemo44',
		title:'结算患者：【'+name+"】"
		,type: 1, 
		shadeClose:true,
		closeBtn: false
		,area: ['600px', '630px']
	,shade: 0.8
	,id: 'LAY_la2345435' //设定一个id，防止重复弹出
		,btn: ['确定结算', '取消']
	,btnAlign: 'c'
		,moveType: 1 //拖拽模式，0或者1
		,content:$(".thetestt")
		
		,yes: function(index, layero){
			
			
			var type=$(".layui-form-radioed div").html();
			var apptime=$("#endTime").val();
			var comment=$("#thecomments").val();
			var backtime=$("#date21").val();
			var getmoney=$("#getmoney").val();
			var putmoney=$("#putmoney").val();
			var backcomment=$("#backcomment").val();
			var uptime=$("#date1").val();
			if($("#date1").val()==""){
				layer.msg('请选择就诊时间',{time: 1000}); 
				return;
			}
			$.post("/dappointmentController/balanceApp","uptimes="+uptime+"&pid="+id+"&name="+name+"" +
					"&type="+type+"&apptime="+apptime+"" +
							"&comment="+comment+"&backtimes="+backtime+"&getmoney="+getmoney+"&putmoney" +
									"="+putmoney+"&backcomment="+backcomment,function(data){
				
				layer.open({
					id: 'layerDemo'+data.code //防止重复弹出
					,content: '<div style="padding: 20px 100px;">'+ data.code +'</div>'
					,btn: '关闭'
						,btnAlign: 'c' //按钮居中
							,shade: 0 //不显示遮罩
							,yes: function(){
								layer.closeAll();
							}
				});
				
			},"JSON")
			
			layer.close(index);
			
		}
	});
	
}			 
function tableonthis(table){


	table.on('sort(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		console.log(obj.field); //当前排序的字段名
		console.log(obj.type); //当前排序类型：desc（降序）、asc（升序）、null（空对象，默认排序）
		console.log(this); //当前排序的 th 对象

		//尽管我们的 table 自带排序功能，但并没有请求服务端。
		//有些时候，你可能需要根据当前排序的字段，重新向服务端发送请求，从而实现服务端排序，如：
		table.reload('idTest', {
			initSort: obj //记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
			,where: { //请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
				order:obj.field+" "+obj.type //排序方式
			}
		});
	});
}


/**
 * 日期加分钟
 */
function judgFailTime(data,minute) {
	var time = new Date(data.replace("-","/"));
	var b = minute; //分钟数
	time.setMinutes(time.getMinutes() + b, time.getSeconds(), 0);
	return dateToString(time)
	//如何将b的分钟数加到上面的时间上？？？？？
}

/**
 * 日期格式转字符串
 * @param now
 * @returns {string}
 */
function dateToString(now){
	var year = now.getFullYear();
	var month =(now.getMonth() + 1).toString();
	var day = (now.getDate()).toString();
	var hour = (now.getHours()).toString();
	var minute = (now.getMinutes()).toString();
	var second = (now.getSeconds()).toString();
	if (month.length == 1) {
		month = "0" + month;
	}
	if (day.length == 1) {
		day = "0" + day;
	}
	if (hour.length == 1) {
		hour = "0" + hour;
	}
	if (minute.length == 1) {
		minute = "0" + minute;
	}
	if (second.length == 1) {
		second = "0" + second;
	}
	var dateTime = year + "-" + month + "-" + day +" "+ hour +":"+minute+":"+second;
	return dateTime;
}


function ShowDataLoad(data, name, temp) {
	var html = template(temp, data);
	$(name).html(html);
}



