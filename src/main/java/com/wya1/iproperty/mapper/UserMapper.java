package com.wya1.iproperty.mapper;

import com.wya1.iproperty.entity.User;

import java.util.Set;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author wya1
 * @since 2018-08-13
 */
public interface UserMapper extends BaseMapper<User> {

	/**
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * @param username
	 * @return
	 */
	Set<String> findRoles(String username);

	/**
	 * @param username
	 * @return
	 */
	Set<String> findPermissions(String username);

}
