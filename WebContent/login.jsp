<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath }/publicResources/js/bootstrap-3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/publicResources/js/jQuery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/publicResources/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<title>登录页面</title>

<style type="text/css">
.navbar-brand img{height: 40px;}
.nav li a{font-size: 20px;}
.jumbotron {margin-bottom: 0px;}

#bottom{background: #373D41;padding: 10px 0px;color: #fff;text-align: center;}
</style>
<script type="text/javascript">
$('#bootstrap-touch-slider').bsTouchSlider(); //鼠标经过停止轮播
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