<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"	%>
<%@ taglib  uri="http://java.sun.com/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/publicResources/js/jQuery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/publicResources/js/uploadify/jquery.uploadify.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/publicResources/js/uploadify/uploadify.css" />
<style type="text/css">
#addForm div{ height: 40px;display: block;}
.uploadify{opacity:0.3;margin-top: -80px;}
.uploadify-button{border-radius:0px;}
.uploadifyProgressBar {
    background-color: #0099FF;
    width: 1px;
    height:3px;
   float:left;
}
</style>
<script type="text/javascript">
function save(){
	$.ajax({
		type:"post",
		data:$("#addForm").serialize(),
		url:"${pageContext.request.contextPath}/helloController/save.action",
		dataType:"text",
		success:function(data){
			alert(data);
		}
		
	});
}

function gosubmit(){
	$("#uploadForm").submit();
}
function gosubmit2(){
	
	$.ajax({
		type:"post",
		data:$("#uploadForm2").serialize(),
		url:"${pageContext.request.contextPath}/helloController/uploadMongo.action",
		dataType:"text",
		success:function(data){
			if(data){
				$("#img_div").append("<img src='${pageContext.request.contextPath}/helloController/showImg.action?id="+data+"' style='width: 80px;height: 80px;' />");
			}
			console.debug(data);
		}
		
	});
}
$(function() {
    $('#file_upload').uploadify({
 
        'swf'      : '${pageContext.request.contextPath}/publicResources/js/uploadify/uploadify.swf',
        'uploader' : '${pageContext.request.contextPath}/helloController/uploadFile.action',
            'buttonText': '上传图片',
            //显示的高度和宽度，默认 height 30；width 120
            'height': 80,
            'width': 80,
            //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
            //在浏览窗口底部的文件类型下拉菜单中显示的文本
            'fileTypeDesc': 'false',
            //允许上传的文件后缀
            'fileTypeExts': '*.gif; *.jpg; *.png',
            //发送给后台的其他参数通过formData指定
            //'formData': { 'someKey': 'someValue', 'someOtherKey': 1 },
            //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
            //'queueID': 'fileQueue',
            'fileSizeLimit':'10MB',
            //选择文件后自动上传
            'auto': true,
            //设置为true将允许多文件上传
            'multi': true,
            'onInit':function(){
            		$("#file_upload-queue").hide(); //隐藏进度条
            	},
            'cancelImg': '${pageContext.request.contextPath}/publicResources/js/uploadify/uploadify-cancel.png', 

            'onUploadSuccess':function(file,data,response){
            	$('#' + file.id).find('.data').html(' 上传完毕');
            	console.debug(file,data,response);
            	var data = eval("("+data+")");
            	var arr = data.split(";");
            	$("#uploadImg").attr("src","${pageContext.request.contextPath}"+arr[1] );
            	$("#filePath").val(arr[1]);
            	console.debug(data);
            }
    });
});

function delImage(id){
	$.ajax({
		type:"post",
		data:{id:id},
		url:"${pageContext.request.contextPath}/helloController/delImage.action",
		dataType:"text",
		success:function(data){
			alert(data);
		}
		
	});
}

</script>

</head>
<body>
	<h1>${msg}</h1>
	
	<div>
		<form id="addForm" >
				<div>
					<span>姓名：</span>
					<input  type="text" name="name"/>
				</div>
				<div>
					<span>性别</span>
					<input  type="radio" name="sex"  value="0"/>	
					<input  type="radio" name="sex"  value="1"/>				
				</div>
				<div>
					<a href="javascript:void(0)"  style="padding: 5px 15px;background: orange;text-decoration: none;margin-top: 10px;" onclick="save()">提交</a>
				</div>
		</form>
	</div>
	<div>
		<form id="uploadForm" action="${pageContext.request.contextPath}/helloController/uploadImage.action" method="post" enctype="multipart/form-data">
				<input type="file" name="uploadFile"  id="uploadFile"/>
				<input type="submit" onclick="gosubmit()"/>
		</form>
	</div>
	<div style="height: 130px">
		<form id="uploadForm2" action="" method="post" enctype="multipart/form-data">
			<div>
				<img id="uploadImg" src="" style="height: 80px; width: 80px;  z-index: -1;">
				<input type="file" name="uploadFile"  id="file_upload"/>
			</div>
			<input type="text" name="filePath"  id="filePath"/>
			<a href="javascript:void(0)"  style="padding: 5px 15px;background: orange;text-decoration: none;margin-top: 10px;" onclick="gosubmit2()">提交</a>
		</form>
	</div>
	<div id="img_div" style="margin: 10px;">
		<img src="${pageContext.request.contextPath}/helloController/showImg.action?id=3d70556ae34a42c2872f36127f88e5a9" style="width: 80px;height: 80px;" />
		<!-- 
		<img alt="" src="${pageContext.request.contextPath}/helloController/showImg.action?id=895db547ac4e45b2940ad2e47dd14c08" style="width: 80px;height: 80px;" />
		<img alt="" src="${pageContext.request.contextPath}/helloController/showImg.action?id=49545836780a488c8f41467ee29b706a" style="width: 80px;height: 80px;" />
		 -->
	</div>
	<div style="height: 50px;">
			<a href="javascript:void(0)"  style="padding: 5px 15px;background: orange;text-decoration: none;margin-top: 10px;" onclick="delImage('3d70556ae34a42c2872f36127f88e5a9')">删除图片</a>
	</div>
	
	
	
</body>
</html>