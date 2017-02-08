<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath }/publicResources/js/bootstrap-3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/publicResources/js/jiaoben/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/publicResources/js/jiaoben/css/animate.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/publicResources/js/jiaoben/css/bootstrap-touch-slider.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/publicResources/js/jQuery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/publicResources/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/publicResources/js/jiaoben/js/bootstrap-touch-slider.js"></script>
<title>首页</title>

<style type="text/css">
.navbar-brand img{width: 96px;height: 23px;}
#bootstrap-touch-slider{margin-top: 48px;}
.jumbotron {margin-bottom: 0px;}
.jumbotron .container .row .active{z-index: 100;border: 1px solid #00c1de;box-shadow: 0 0 20px rgba(0, 198, 226, 0.5);}
.jumbotron .container .row .col-md-4{text-align: center;padding: 0px;}
.jumbotron .container .row .col-md-4 .headed-bg{background-color: #e5e5e6;padding-bottom: 10px;}
.jumbotron .container .row .active .headed-bg{background-color: #00c1de;padding-bottom: 10px;}
.jumbotron .container .row .active p{color: #337ab7;cursor: pointer;}
.jumbotron .container .row {border: 1px solid #dbdbdb;}
.col-md-4-border{border-left:1px solid #dbdbdb;border-right: 1px solid #dbdbdb; }
#bottom{background: #373D41;padding: 10px 0px;color: #fff;text-align: center;}
</style>
<script type="text/javascript">
$('#bootstrap-touch-slider').bsTouchSlider(); //鼠标经过停止轮播
$(function(){
	$("#content .col-md-4").mouseover(function(){
		$(this).addClass("active");
	});
	$("#content .col-md-4").mouseout(function(){
		$(this).removeClass("active");
	});
})

</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	  <div id="" class="container">
	  	<div class="navbar-header">
	    	<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath }/publicResources/images/index/logo.png"/></a>
        </div>
	  	<div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="navbar-link"><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
            <li><a href="javascript:void(0)">产品</a></li>
            <li><a href="javascript:void(0)">渠道</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}/login.jsp" >登录</a></li>
            <li><a href="javascript:void(0)" >加入我们</a></li>
      
          </ul>
        </div>
	  </div>
	</nav>
   	<div id="bootstrap-touch-slider" class="carousel bs-slider fade  control-round indicators-line" data-ride="carousel" data-pause="hover" data-interval="5000" >
		<ol class="carousel-indicators">
			<li data-target="#bootstrap-touch-slider" data-slide-to="0" class="active"></li>
			<li data-target="#bootstrap-touch-slider" data-slide-to="1"></li>
			<li data-target="#bootstrap-touch-slider" data-slide-to="2"></li>
		</ol>

		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="${pageContext.request.contextPath }/publicResources/images/banner/banner1.jpg" alt="Bootstrap Touch Slider"  class="slide-image"/>
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath }/publicResources/images/banner/banner2.jpg" alt="Bootstrap Touch Slider"  class="slide-image"/>
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath }/publicResources/images/banner/banner3.jpg" alt="Bootstrap Touch Slider"  class="slide-image"/>
			</div>
		</div>
		<a class="left carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="prev">
			<span class="fa fa-angle-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="next">
			<span class="fa fa-angle-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div> 
	<div id="content" class="jumbotron">
      <div class="container">
	      <div class="row">
	        <div class="col-md-4">
	          <div class="headed-bg">
	          	<img  src="${pageContext.request.contextPath}/publicResources/images/index/icon_qudao.png">
	          	<h2>渠道服务</h2>
	          </div>
	          <p>支撑与服务</p>
	          <p>合作共赢</p>
	        </div>
	        <div class="col-md-4 col-md-4-border">
	          <div class="headed-bg">
	          	<img  src="${pageContext.request.contextPath}/publicResources/images/index/icon_product.png">
		        <h2>产品介绍</h2>
	          </div>
	          <p>固定机</p>
	          <p>移动机</p>
	       </div>
	        <div class="col-md-4">
	          <div class="headed-bg">
	          	<img  src="${pageContext.request.contextPath}/publicResources/images/index/icon_dongtai.png">
		        <h2>公司动态</h2>
	          </div>
	          <p>2017开年</p>
	          <p>更多动态</p>
	        </div>
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