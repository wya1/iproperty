package com.wya1.iproperty.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.wya1.iproperty.util.ValidateCodeServlet;

/**
 * 认证表单过滤器
 * 
 * @author 任远曼
 *
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// 校验验证码
		// 从session获取正确的验证码
		HttpSession session = ((HttpServletRequest) request).getSession();
		// 页面输入的验证码
		String randomcode = request.getParameter("validateCode");
		// 从session中取出验证码
		/*
		 * if(!ValidateCodeServlet.validate((HttpServletRequest) request, randomcode)) {
		 * request.setAttribute("shiroLoginFailure", "randomCodeError"); return true; }
		 */
		String validateCode = (String) session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);

		if (randomcode != null && validateCode != null && !randomcode.toUpperCase().equals(validateCode)) {
			// randomCodeError表示验证码错误
			request.setAttribute("shiroLoginFailure", "randomCodeError");
			// 拒绝访问，不再校验账号和密码
			return true;
		}
		return super.onAccessDenied(request, response, mappedValue);
	}
}
