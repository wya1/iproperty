package com.wya1.iproperty.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wya1.iproperty.util.ValidateCodeServlet;

/**
 * Servlet注册
 * 
 * @author 任远曼
 * @date 2018年6月1日
 *
 */
@Configuration
public class ServletConfig {
	@Bean
	public ServletRegistrationBean<ValidateCodeServlet> ValidateCode() {
		ServletRegistrationBean<ValidateCodeServlet> registration = new ServletRegistrationBean<ValidateCodeServlet>(
				new ValidateCodeServlet());
		registration.addUrlMappings("/ValidateCode");
		return registration;
	}

}
