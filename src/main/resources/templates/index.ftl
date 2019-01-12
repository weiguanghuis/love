<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>测试</title>
  <link rel="stylesheet" href="${base}/static/layui/css/layui.css">
  <link rel="stylesheet" href="${base}/static/css/frame.css">
</head>
<body>
<!--header 导航栏-->
<header class="layui-layout layui-layout-admin">
  <div class="layui-header lps-header header header-demo">
    <div class="layui-main">
      <a class="logo" href="/">
        <img src="${base}/static/img/logo.png" alt="layui">
      </a>
      <h2 class="title">微广汇后台管理系统</h2>
      <ul class="lps-nav">
        <li>欢迎您，</li>
        <li  ><span><i class="iconfont icon-moban162"></i></span><span>修改密码</span></li>
        <li onclick="window.location.href='${base}/duserController/loginout.html'"><span><i class="iconfont icon-tuichu"></i></span><span>退出登录</span></li>
      </ul>
    </div>
  </div>
</header>

<!--menu 左侧菜单-->
<nav class="lps-menu">
  <ul class="layui-nav layui-nav-tree" lay-filter="menu">
  <li class="layui-nav-item layui-nav-itemed">
      <a href="javascript:;">
        <i class="iconfont icon-augiclingdaihou"></i><span class="menu-title">今日工作</span>
      </a>
      <dl class="layui-nav-child">
        <dd class="layui-this" lps-menu="${base}/dappointmentController/showDAppointment.html"><a href="javascript:;">今日预约</a></dd>
        <dd lps-menu="${base}/dappointmentController/showReturnVisit.html"><a href="javascript:;">今日回访</a></dd>
      </dl>
    </li>
     
    <li class="layui-nav-item layui-nav-itemed">
      <a href="javascript:;">
        <i class="iconfont icon-yonghu"></i><span class="menu-title">患者管理</span>
      </a>
      <dl class="layui-nav-child">
        <dd lps-menu="${base}/back/patient.html" ><a href="javascript:;">患者资料</a></dd>
      </dl>
    </li>
    
    
    <li class="layui-nav-item ">
      <a href="javascript:void(0);">
        <i class="iconfont icon-suo"></i><span class="menu-title">用户管理</span>
      </a>
      <dl class="layui-nav-child">
        <dd lps-menu="${base}/tuserdataController/showTUserdata.html" ><a href="javascript:;">普通用户管理</a></dd>
        <dd lps-menu="javascript:void(0);" ><a href="javascript:;">广告商管理</a></dd>
        <dd lps-menu="javascript:void(0);" ><a href="javascript:;">用户权限管理</a></dd>
      </dl>
    </li>

    <li class="layui-nav-item ">
      <a href="javascript:void(0);">
        <i class="iconfont icon-suo"></i><span class="menu-title">用户日志管理</span>
      </a>
      <dl class="layui-nav-child">
        <dd lps-menu="javascript:void(0);" ><a href="javascript:;">普通用户日志</a></dd>
        <dd lps-menu="javascript:void(0);" ><a href="javascript:;">广告商日志</a></dd>
      </dl>
    </li>

    <li class="layui-nav-item ">
      <a href="javascript:void(0);">
        <i class="iconfont icon-suo"></i><span class="menu-title">广告管理</span>
      </a>
      <dl class="layui-nav-child">
        <dd lps-menu="javascript:void(0);" ><a href="javascript:;">广告发布</a></dd>
        <dd lps-menu="javascript:void(0);" ><a href="javascript:;">广告列表</a></dd>
      </dl>
    </li>

    <li class="layui-nav-item ">
      <a href="javascript:void(0);">
        <i class="iconfont icon-suo"></i><span class="menu-title">订单管理</span>
      </a>
      <dl class="layui-nav-child">
        <dd lps-menu="javascript:void(0);" ><a href="javascript:;">商城订单</a></dd>
      </dl>
    </li>
    <li class="layui-nav-item ">
      <a href="javascript:void(0);">
        <i class="iconfont icon-suo"></i><span class="menu-title">账单管理</span>
      </a>
      <dl class="layui-nav-child">
        <dd lps-menu="javascript:void(0);" ><a href="javascript:;">商城账单</a></dd>
        <dd lps-menu="javascript:void(0);" ><a href="javascript:;">微信账单</a></dd>
      </dl>
    </li>
    <li class="layui-nav-item ">
      <a href="javascript:void(0);">
        <i class="iconfont icon-suo"></i><span class="menu-title">商品管理（世晓做）</span>
      </a>
      <dl class="layui-nav-child">
        <dd lps-menu="javascript:void(0);" ><a href="javascript:;">商品发布</a></dd>
        <dd lps-menu="javascript:void(0);" ><a href="javascript:;">商品列表</a></dd>
      </dl>
    </li>



  </ul>
</nav>

<div class="lps-module">
  <div class="lps-breadcrumb">
    <span class="layui-breadcrumb">
      <a href="javascript:void(0);">权限管理</a>
      <a><cite>后台管理员</cite></a>
    </span>
  </div>
  <div class="lps-iframe">
    <iframe id="lps-iframe" src="${base}/dappointmentController/showDAppointment.html"></iframe>
  </div>
</div>

<script src="${base}/static/layui/layui.js"></script>
<script src="${base}/static/js/underscore-min.js"></script>
<script src="${base}/static/js/frame.js"></script>
</body>
</html>