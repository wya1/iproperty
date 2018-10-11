package com.wya1.iproperty.config;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.wya1.iproperty.shiro.CustomFormAuthenticationFilter;
import com.wya1.iproperty.shiro.RetryLimitHashedCredentialsMatcher;
import com.wya1.iproperty.shiro.UserRealm;

/**
 * Shiro配置
 * 
 * @author 任远曼
 * @date 2018年6月1日
 */
@Configuration
public class ShiroConfig {

	@Bean
	public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}

	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager,
			FormAuthenticationFilter formAuthenticationFilter) {
//		System.out.println("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		Map<String, Filter> filters = new LinkedHashMap<>();
		filters.put("authc", formAuthenticationFilter);
		shiroFilterFactoryBean.setFilters(filters);

		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/index", "anon");
		filterChainDefinitionMap.put("/unauthorized", "anon");
		filterChainDefinitionMap.put("/ValidateCode", "anon");
		filterChainDefinitionMap.put("/static/**", "anon"); // 匿名访问静态资源
		filterChainDefinitionMap.put("/druid/**", "anon");
		filterChainDefinitionMap.put("/mini-web/**", "anon");
		filterChainDefinitionMap.put("/favicon.ico", "anon");// Shiro 解决登录成功后跳转到favicon.ico
		filterChainDefinitionMap.put("/login", "authc");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/**", "user");

		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/");

		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

		// 未授权界面;
		// shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean
	public EhCacheManager cacheManager() {
		EhCacheManager bean = new EhCacheManager();
		bean.setCacheManagerConfigFile("classpath:ehcache.xml");
		return bean;
	}

	@Bean
	public RetryLimitHashedCredentialsMatcher credentialsMatcher(EhCacheManager cacheManager) {
		RetryLimitHashedCredentialsMatcher bean = new RetryLimitHashedCredentialsMatcher(cacheManager);
		bean.setHashAlgorithmName("md5");
		bean.setHashIterations(2);
		bean.setStoredCredentialsHexEncoded(true);
		return bean;
	}

	@Bean
	public UserRealm userRealm(RetryLimitHashedCredentialsMatcher credentialsMatcher) {
		UserRealm bean = new UserRealm();
		bean.setCredentialsMatcher(credentialsMatcher);
		bean.setCachingEnabled(true);
		bean.setAuthenticationCachingEnabled(true);
		bean.setAuthenticationCacheName("authenticationCache");
		bean.setAuthorizationCachingEnabled(true);
		// bean.setAuthorizationCachingEnabled(false);
		bean.setAuthorizationCacheName("authorizationCache");
		return bean;
	}

	/**
	 * 基于Form表单的身份验证过滤器
	 * 
	 * @return
	 */
	@Bean
	public CustomFormAuthenticationFilter formAuthenticationFilter() {
		CustomFormAuthenticationFilter bean = new CustomFormAuthenticationFilter();
		bean.setUsernameParam("username");
		bean.setPasswordParam("password");
		bean.setRememberMeParam("rememberMe");
		// TODO:
		bean.setLoginUrl("/login");
		return bean;
	}
	/*
	 * @Bean public FormAuthenticationFilter formAuthenticationFilter() {
	 * FormAuthenticationFilter bean = new FormAuthenticationFilter();
	 * bean.setUsernameParam("username"); bean.setPasswordParam("password");
	 * bean.setRememberMeParam("rememberMe"); // TODO: bean.setLoginUrl("/login");
	 * return bean; }
	 */

	public SimpleCookie rememberMeCookie() {
		SimpleCookie bean = new SimpleCookie("rememberMe");
		bean.setHttpOnly(true);
		bean.setMaxAge(180000);
		return bean;

	}

	@Bean
	public CookieRememberMeManager rememberMeManager(SimpleCookie rememberMeCookie) {
		CookieRememberMeManager bean = new CookieRememberMeManager();
		bean.setCipherKey(Base64.decode("RgniJLGKYsiCjUx6iv7NWg=="));
		bean.setCookie(rememberMeCookie);
		return bean;
	}

	@Bean
	public SecurityManager securityManager(UserRealm userRealm, DefaultWebSessionManager sessionManager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		securityManager.setCacheManager(cacheManager());
		securityManager.setSessionManager(sessionManager);
		// securityManager.setRememberMeManager(rememberMeManager);
		return securityManager;
	}

	/**
	 * 会话ID生成器
	 * 
	 * @return
	 */
	@Bean
	public JavaUuidSessionIdGenerator sessionIdGenerator() {
		JavaUuidSessionIdGenerator bean = new JavaUuidSessionIdGenerator();
		return bean;
	}

	/**
	 * 会话DAO
	 * 
	 * @param sessionIdGenerator
	 * @return
	 */
	@Bean
	public EnterpriseCacheSessionDAO sessionDAO(JavaUuidSessionIdGenerator sessionIdGenerator) {
		EnterpriseCacheSessionDAO bean = new EnterpriseCacheSessionDAO();
		bean.setActiveSessionsCacheName("shiro-activeSessionCache");
		bean.setSessionIdGenerator(sessionIdGenerator);
		return bean;
	}

	/**
	 * 会话验证调度器
	 * 
	 * @param sessionManager
	 * @return
	 */
	@Bean
	public QuartzSessionValidationScheduler sessionValidationScheduler() {
		QuartzSessionValidationScheduler bean = new QuartzSessionValidationScheduler();
		bean.setSessionValidationInterval(1800000);
		return bean;
	}

	/**
	 * 会话Cookie模板
	 * 
	 * @return
	 */
	@Bean
	public SimpleCookie sessionIdCookie() {
		SimpleCookie bean = new SimpleCookie("sid");
		bean.setHttpOnly(true);
		// bean.setMaxAge(180000);
		bean.setMaxAge(-1);
		return bean;
	}

	/**
	 * 会话管理器
	 * 
	 * @param sessionValidationScheduler
	 * @param sessionDAO
	 * @param sessionIdCookie
	 * @return
	 */
	@Bean
	public DefaultWebSessionManager sessionManager(EnterpriseCacheSessionDAO sessionDAO, SimpleCookie sessionIdCookie,
			QuartzSessionValidationScheduler sessionValidationScheduler) {
		DefaultWebSessionManager bean = new DefaultWebSessionManager();
		// TODO:
		bean.setSessionIdUrlRewritingEnabled(false);

		bean.setGlobalSessionTimeout(1800000);
		bean.setDeleteInvalidSessions(true);
		bean.setSessionValidationSchedulerEnabled(false);
		bean.setSessionValidationScheduler(sessionValidationScheduler);
		bean.setSessionDAO(sessionDAO);
		bean.setSessionIdCookieEnabled(true);
		bean.setSessionIdCookie(sessionIdCookie);
		return bean;
	}

	/**
	 * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean(name = "simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.setProperty("DatabaseException", "databaseError");// 数据库异常处理
		mappings.setProperty("UnauthorizedException", "403");
		r.setExceptionMappings(mappings); // None by default
		r.setDefaultErrorView("error"); // No default
		r.setExceptionAttribute("ex"); // Default is "exception"
		// r.setWarnLogCategory("example.MvcLogger"); // No default
		return r;
	}

}
