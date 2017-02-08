var path="${pageContext.request.contextPath}";
$(function(){
	
	
})

function login(){
	var userName = $("#userName").val();
	var password = $("#possword").val();
	$.ajax({
		type:"post",
		data:{userName:userName,password:password},
		url:path+""
	});
	
}