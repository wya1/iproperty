package com.wya1.iproperty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.constant.Constant;
import com.wya1.iproperty.entity.UserPet;
import com.wya1.iproperty.mapper.UserPetMapper;
import com.wya1.iproperty.service.IUserPetService;

/**
 * <p>
 * 宠物信息 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-08-28
 */
@Transactional(readOnly=true)
@Service
public class UserPetServiceImpl extends BaseServiceImpl<UserPetMapper, UserPet> implements IUserPetService {
	@Autowired
	private UserPetMapper userPetDao;
	@Override
	public Page<UserPet> selectPage(int pageNo,UserPet userPet) {
		Page<UserPet> page = new Page<>(pageNo, Constant.PAGE_SIZE);
		return page.setRecords(userPetDao.selectUserPet(page));
	}
}
