var path="${pageContext.request.contextPath}";
$(function(){
	
	var browser="";   
	var version="";  
	var browserMatch=uaMatch(userAgent.toLowerCase());   
	if(browserMatch.browser)  {   
	    browser=browserMatch.browser;   
	    version=browserMatch.version;   
	}  
	if(browser == 'firefox'){
		var labels = $(".glyphicon");
		for(var i=0;i<labels.length;i++){
			labels[i].style.top="5px";
		}
	}
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


//获取浏览器信息
var userAgent=window.navigator.userAgent,    
rMsie=/(msie\s|trident.*rv:)([\w.]+)/,    
rFirefox=/(firefox)\/([\w.]+)/,    
rOpera=/(opera).+version\/([\w.]+)/,    
rChrome=/(chrome)\/([\w.]+)/,    
rSafari=/version\/([\w.]+).*(safari)/;  
function uaMatch(ua)  
{  
var match=rMsie.exec(ua);   
if(match != null)  
{   
    return {browser:"IE",version:match[2] || "0"};   
}   
var match=rFirefox.exec(ua);   
if(match != null)   
{   
    return {browser:match[1] || "",version:match[2] || "0"};   
}   
var match=rOpera.exec(ua);   
if(match != null)   
{   
    return {browser:match[1] || "",version:match[2] || "0"};   
}      
var match=rChrome.exec(ua);   
if(match != null)   
{   
    return {browser:match[1] || "",version:match[2] || "0"};   
}   
var match=rSafari.exec(ua);   
if(match != null)   
{   
    return {browser:match[2] || "",version:match[1] || "0"};   
}   
if(match != null)   
{   
    return {browser:"",version:"0"};   
}   
}  
