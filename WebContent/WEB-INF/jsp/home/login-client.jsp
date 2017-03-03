<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath }/publicResources/js/bootstrap-3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/publicResources/css/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/publicResources/js/jQuery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/publicResources/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/publicResources/js/pc/login.js"></script>
<title>登录</title>


<script type="text/javascript">
$(function(){
	
})

</script>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	  <div id="" class="container">
	  	<div class="navbar-header">
	    	<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath }/publicResources/images/index/logo.png"/></a>
        </div>
	  	<div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a class="" href="javascript:void(0)">欢迎登录</a></li>
          </ul>
        </div>
	  </div>
	</nav>
   
	<div id="content" class="jumbotron">
	    <div class="container">
			<div class="login-box">
		      <form class="form-signin">
		       <div class="form-signin-p"><p>用户登录</p></div>
		       	<input type="hidden" value="${uuid}" />
		        <div class="form-signin-input">
		          <label for="userName" class="glyphicon glyphicon-user"></label>
		          <input id="userName" name="userName" class="form-control" placeholder="用户名/手机号/邮箱" required="" autofocus="" type="text">
		       	</div>
		       	<div class="form-signin-input">
		          <label for="password" class="glyphicon glyphicon-lock"></label>
		          <input id="password" name="password" class="form-control" placeholder="密码" required="" type="password">
		        </div>
		        <div class="checkbox">
		          <label><input value="remember-me" type="checkbox"> 保持登录</label>
		        </div>
		        <div class="form-signin-btn">
			        <button id="submit-btn" class="btn btn-lg btn-danger btn-block" type="button">登录</button>
		        </div>
		        <div class="checkbox">
		          <a href="javascript:void(0)">忘记密码</a>
		          <a href="${pageContext.request.contextPath}/RegisterController/redirectRegisterPage.action" style="float: right;">免费注册</a>
		        </div>
		      </form>
			</div>
	    </div>
    </div>
    <div id="bottom" class="jumbotron">
		<div class="container">
	      <footer>
	        <span>© 2016 珠海成易科技有限公司 版权所有</span>
	      </footer>
	    </div>
    </div>
    
</body>
</html>