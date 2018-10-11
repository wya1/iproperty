package com.wya1.iproperty.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.User;
import com.wya1.iproperty.mapper.UserMapper;
import com.wya1.iproperty.service.IUserService;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-31
 */
@Transactional(readOnly = true)
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {
	@Autowired
	private UserMapper userDao;

	@Override
	public Page<User> selectPage(User user) {
//		System.out.println(user);
		Page<User> page=new Page<User>();
		EntityWrapper<User> wrapper=new EntityWrapper<>();
		wrapper.like("username", user.getUsername());
		return selectPage(page,wrapper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wya1.iproperty.service.IUserService#findByUsername(java.lang.String)
	 */
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wya1.iproperty.service.IUserService#findRoles(java.lang.String)
	 */
	@Override
	public Set<String> findRoles(String username) {
		return userDao.findRoles(username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wya1.iproperty.service.IUserService#findPermissions(java.lang.String)
	 */
	@Override
	public Set<String> findPermissions(String username) {
		return userDao.findPermissions(username);
	}

}
