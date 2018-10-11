/**
 * 
 */
package com.wya1.iproperty.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wya1.iproperty.constant.Constant;

/**
 * @author 任远曼
 * @date 2018年10月3日
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(Constant.ACCESS_PATH).addResourceLocations("file:"+Constant.FILE_PATH);
    }
}
