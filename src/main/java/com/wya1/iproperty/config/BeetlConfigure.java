package com.wya1.iproperty.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wya1.iproperty.config.beetl.ShiroExt;

/**
 * Beetl配置
 * <p>
 * BeetlConfigure不能取 BeetlConfig名字因为造成bean名重复
 * 
 * @author 任远曼
 * @date 2018年6月1日
 */
@Configuration
public class BeetlConfigure {

	@Value("${beetl.suffix:.html}")
	String suffix;// 模板后缀

	@Value("${beetl.prefix:/views/}")
	String prefix;// 模板后缀

	@Bean(initMethod = "init", name = "beetlConfig")
	public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() throws IOException {
		BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
		ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader();
		beetlGroupUtilConfiguration.setResourceLoader(classpathResourceLoader);
		return beetlGroupUtilConfiguration;
	}

	@Bean(name = "beetlViewResolver")
	public BeetlSpringViewResolver getBeetlSpringViewResolver() throws IOException {
		BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
		beetlSpringViewResolver.setPrefix(prefix);
		beetlSpringViewResolver.setSuffix(suffix);
		beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
		beetlSpringViewResolver.setOrder(0);
		beetlSpringViewResolver.setConfig(getBeetlGroupUtilConfiguration());
		return beetlSpringViewResolver;
	}

	@Bean(name = "groupTemplate")
	public GroupTemplate getGroupTemplate(
			@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
		GroupTemplate groupTemplate = beetlGroupUtilConfiguration.getGroupTemplate();

		groupTemplate.registerFunctionPackage("shiro", new ShiroExt());

		Map<String, Object> sharedVars = new HashMap<>();
		sharedVars.put("ctxStatic", "caabdde");
		groupTemplate.setSharedVars(sharedVars);

		return beetlGroupUtilConfiguration.getGroupTemplate();
	}

}
