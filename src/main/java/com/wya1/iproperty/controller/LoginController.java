package com.wya1.iproperty.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 任远曼
 * @date 2018年6月26日
 */
@Controller
public class LoginController extends BaseController{

//	@RequestMapping(value = { "", "index", "ox" })
//	public String index() {
//		return "modules/test/index";
//	}

	@RequestMapping("login")
	public String login(HttpServletRequest request, Model model) {
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		String error = null;
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			// error = "用户名/密码错误";
			error = "没找到帐号";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			// error = "用户名/密码错误";
			error = "用户名/密码错误";
		} else if ("randomCodeError".equals(exceptionClassName)) {
			error = "验证码错误";
		} else if (exceptionClassName != null) {
			error = "其他错误：" + exceptionClassName;
		}
		model.addAttribute("error", error);
		return "modules/test/login";
	}
	
	

	/*
	 * @RequestMapping("success") public String success() { return
	 * "modules/test/success"; }
	 * 
	 * @RequestMapping("/unauthorized") public String unauthorized() { return
	 * "modules/test/unauthorized"; }
	 */
}
