package com.wmc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注册Controller
 * 
 * @author wmc
 * @since 2017.03.01
 *
 */
@Controller
@RequestMapping("RegisterController")
public class RegisterController {
	
	/**
	 * 跳转到个人注册页面
	 * @return
	 */
	@RequestMapping("redirectRegisterPage")
	public ModelAndView redirectRegisterPage() {
		ModelAndView mav = new ModelAndView("home/register-client");
		return mav;
	}
}
