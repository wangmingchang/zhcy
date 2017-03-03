package com.wmc.web;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录Contorller
 * @author wmc
 * @since 2017.02.28
 */
@Controller
@RequestMapping("LoginController")
public class LoginController {
	
	/**
	 * 跳转到客户端登录页面
	 * @return
	 */
	@RequestMapping("redirectLoginPage")
	public ModelAndView redirectLoginPage() {
		ModelAndView mac = new ModelAndView("home/login-client");
		String uuid = UUID.randomUUID().toString();
		mac.addObject("uuid", uuid);
		return mac;
	}
	
	/**
	 * 客户端-登录
	 * @param request
	 * @param response
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(password)) {
			
		}
	}
}
