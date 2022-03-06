<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>社团联合会-社团负责人</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
  <style type="text/css">
  iframe{
  border:0;
  width:100%;
  }
  #current_time{
    font-size:15px;
    color:#4213C9;
    text-align:center;
  }
  
  </style>
</head>
<body class="layui-layout-body" onload="startClock()" onunload="stopClock()">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo"><img src="images/logo.jpg" class="layui-nav-img">社团负责人界面</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <!--<ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul> -->
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="images/touxiang.png" class="layui-nav-img">
           ${sessionScope.currentUserName10}
        </a>
        <dl class="layui-nav-child">
           <dd><a href="tuanwei/about.html" target="iframeMain">关于……</a></dd>
          <dd><a href="tuanwei/modify_password.html" target="iframeMain">修改密码</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/LoginOutServlet?type=shezhang">退出登录</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">活动申请</a>
          <dl class="layui-nav-child">
            <dd><a href="shezhang/activity_application.html" target="iframeMain">社团活动申请</a></dd>
            <dd><a href="shezhang/activity_result.html" target="iframeMain">活动申请结果查询</a></dd>
          </dl>
        </li>
       <li class="layui-nav-item">
          <a class="" href="javascript:;">活动室申请</a>
          <dl class="layui-nav-child">
            <dd><a href="shezhang/activityRoom_application.html" target="iframeMain">活动室使用申请</a></dd>
            <dd><a href="shezhang/activityRoom_result.html" target="iframeMain">活动室申请结果查询</a></dd>
          </dl>
        </li>
         <!-- <li class="layui-nav-item">
          <a class="" href="javascript:;">经费申请</a>
          <dl class="layui-nav-child">
            <dd><a href="shezhang/account_application1.html" target="iframeMain">申请报账</a></dd>
            <dd><a href="shezhang/account_application2.html" target="iframeMain">活动经费申请</a></dd>
          </dl>
        </li> -->
        <li class="layui-nav-item">
          <a class="" href="javascript:;">证书申请</a>
          <dl class="layui-nav-child">
            <dd><a href="shezhang/honor_application.html" target="iframeMain">申请荣誉证书</a></dd>
            <dd><a href="shezhang/honor_result.html" target="iframeMain">荣誉证书审核结果查询</a></dd>
            <dd><a href="shezhang/awardName_submit.html" target="iframeMain">上传获奖人员名单</a></dd>
          </dl>
        </li>
         <li class="layui-nav-item">
          <a class="" href="javascript:;">宣传资料上传</a>
          <dl class="layui-nav-child">
            <dd><a href="shezhang/poster_submit.html" target="iframeMain">上传活动海报</a></dd>
            <dd><a href="shezhang/news_submit.html" target="iframeMain">上传活动新闻稿</a></dd>
          </dl>
        </li>
      <!--  <li class="layui-nav-item"><a href="shezhang/freshman_submit.html" target="iframeMain">社团招新名单上传</a></li>
        <li class="layui-nav-item"><a href="shezhang/sponsor_application.html" target="iframeMain">申请赞助</a></li>
        <li class="layui-nav-item"><a href="shezhang/program_application.html" target="iframeMain">申报晚会节目</a></li> --> 
        <li class="layui-nav-item">
          <a class="" href="javascript:;">成立新社团</a>
          <dl class="layui-nav-child">
            <dd><a href="shezhang/newClub_application.html" target="iframeMain">成立新社团申请</a></dd>
            <dd><a href="shezhang/newClub_result.html" target="iframeMain">申请结果查询</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
<div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
        <div class="layadmin-tabsbody-item layui-show">
            <iframe src="shezhang/shezhang_default.html" class="layadmin-iframe" name="iframeMain" id="iframeBody"></iframe>
        </div>
    </div>
</div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
     <span>欢迎登录系统，当前日期时间：</span><span  id="current_time"></span>
  </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});

$(function(){	
		//获取src值
   // $(".main_left a").on("click",function(){
     //   var address =$(this).attr("data-src");
  //      $("iframe").attr("src",address);
 //   });
	//下面的代码是根据窗口高度在设置iframe的高度
    var frame = $("#iframeBody");

    var frameheight = $(window).height();
    console.log(frameheight);
    frame.css("height",frameheight);


});

//底部固定栏显示即时时间的功能代码
//------------------------代码开始--------------------
var timer=null;
function displayClock(num){//num是传入的startClock中的动态值
if(num<10){
  return "0"+num;
}
else{
  return num;
}
}
//停止计时
function stopClock(){
clearTimeout(timer);
}
//开始计时
function startClock(){
var time =new Date();
var year = time.getFullYear()+"年";
var month =time.getMonth() + 1+"月";
var date = time.getDate()+"日";
var dateArr = ["日","一",'二','三','四','五','六'];
var day = time.getDay();
var hours=displayClock(time.getHours())+":";
var minutes=displayClock(time.getMinutes())+":";
var seconds=displayClock(time.getSeconds());
//显示时间
current_time.innerHTML=" "+year+month+date+ " 星期" + dateArr[day] + " "+hours+minutes+seconds;//在id为show的块区域显示
timer=setTimeout("startClock()",1000);//延时器
}
//------------------代码结束----------------------------

</script>
</body>
</html>