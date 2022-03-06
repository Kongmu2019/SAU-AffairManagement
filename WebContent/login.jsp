<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登录界面</title>
<link href="css/login.css" type="text/css" rel="stylesheet" />
<style type="text/css">
.error{color:red}
</style>
</head>

<body>
<div class="one">
<img src="images/logo.jpg" id="logo" />
<h1>学生社团联合会事务管理系统</h1>
</div>
<div class="two">
  <h2 class="head">最新社团活动</h2>
    <ul class="content">
    	<li><a href="introductions/greenbank.html">绿色环保协会：“绿色银行”</a></li>
        <li><a href="introductions/lunhuashe.html">Free Top轮滑社新生见面会</a></li>
        <li><a href="introductions/leifeng.html">春芽爱心社：雷锋三月行</a></li>
        <li><a href="introductions/jiewu.html">DFM街舞社：青春绽放，永“舞”止境</a></li>
        <li><a href="introductions/hanwenhua.html">汉文化协会见面会</a></li>
    </ul>
<!-- <input type="button" name="feedback" class="btn02" value="会员意见反馈" > -->
</div>
<div class="three">
<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
	<p>
    	<span>账号：</span>
        <input type="text" name="username" class="user"/>
        <div class="error">${errors.loginname}</div>
    </p>
    <p>
    <span>密码：</span>
    <input type="password" name="password" class="pwd"/>
    <div class="error">${errors.loginpass}</div>
    </p>
    <p>
    <input type="radio" name="leixing" id="tuanwei" value="tuanwei"/><label for="tuanwei">团委老师</label>
     <input type="radio" name="leixing" id="shelian" value="shelian"checked="checked"/><label for="shelian">社联人员</label>
     <input type="radio" name="leixing" id="shezhang" value="shezhang"/><label for="shezhang">社团负责人</label>
    </p>
    <p>
    <input type="submit" class="btn01" value="登录" />
    </p>
</form>
</div>
</body>
</html>
