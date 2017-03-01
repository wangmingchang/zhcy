package com.wmc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * 登录Contorller
 * @author wmc
 * @since 2017.02.28
 */
public class LoginController {
	
	/**
	 * 客户端-登录
	 * @param request
	 * @param response
	 */
	public void login(HttpServletRequest request, HttpServletResponse response){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(password)) {
			
		}
	}
}
