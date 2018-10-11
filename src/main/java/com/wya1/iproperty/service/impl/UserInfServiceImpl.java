package com.wya1.iproperty.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.constant.Constant;
import com.wya1.iproperty.entity.UserCar;
import com.wya1.iproperty.entity.UserInf;
import com.wya1.iproperty.entity.UserMemberFamily;
import com.wya1.iproperty.entity.UserPet;
import com.wya1.iproperty.mapper.UserCarMapper;
import com.wya1.iproperty.mapper.UserInfMapper;
import com.wya1.iproperty.mapper.UserMemberFamilyMapper;
import com.wya1.iproperty.mapper.UserPetMapper;
import com.wya1.iproperty.service.IUserInfService;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-08-28
 */
@Transactional(readOnly = true)
@Service
public class UserInfServiceImpl extends BaseServiceImpl<UserInfMapper, UserInf> implements IUserInfService {
	@Autowired
	private UserCarMapper userCarDao;
	@Autowired
	private UserInfMapper userInfDao;
	@Autowired
	private UserPetMapper userPetDao;
	@Autowired
	private UserMemberFamilyMapper userMemberFamilyDao;

	@Override
	public Page<UserInf> selectPage(int pageNo, UserInf userInf) {
		// Page<UserInf> page = new Page<>(pageNo, Constant.PAGE_SIZE);
		// return selectPage(page);
		Page<UserInf> page = new Page<>(pageNo, Constant.PAGE_SIZE);
		return page.setRecords(userInfDao.selectUserInf(page, userInf));
	}

	public UserInf selectById(Serializable id) {
		UserInf userInf = userInfDao.selectById(id);
		Wrapper<UserCar> userCarWrapper = new EntityWrapper<>();
		userCarWrapper.eq("user_id", userInf.getId());
		List<UserCar> userCars = userCarDao.selectList(userCarWrapper);
		userInf.setUserCars(userCars);

		Wrapper<UserPet> userPetWrapper = new EntityWrapper<>();
		userPetWrapper.eq("user_id", userInf.getId());
		List<UserPet> userPets = userPetDao.selectList(userPetWrapper);
		userInf.setUserPets(userPets);

		List<UserMemberFamily> userMemberFamilies = userMemberFamilyDao.selectByUserId1(id);
		List<UserMemberFamily> userMemberFamilies2 = userMemberFamilyDao.selectByUserId2(id);
		userMemberFamilies.addAll(userMemberFamilies2);
		userInf.setUserMemberFamilies(userMemberFamilies);
		return userInf;
	}
}
