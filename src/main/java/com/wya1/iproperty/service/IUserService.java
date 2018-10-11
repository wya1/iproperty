package com.wya1.iproperty.service;

import java.util.Set;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.User;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-31
 */
public interface IUserService extends IBaseService<User> {
	Page<User> selectPage(User user);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	Set<String> findRoles(String username);

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	Set<String> findPermissions(String username);

}
