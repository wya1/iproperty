package com.wya1.iproperty.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.constant.Constant;
import com.wya1.iproperty.entity.UserCar;
import com.wya1.iproperty.mapper.UserCarMapper;
import com.wya1.iproperty.service.IUserCarService;

/**
 * <p>
 * 车辆信息 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-08-13
 */
@Transactional(readOnly = true)
@Service
public class UserCarServiceImpl extends BaseServiceImpl<UserCarMapper, UserCar> implements IUserCarService {
	@Autowired
	private UserCarMapper userCarDao;
	
	/* (non-Javadoc)
	 * @see com.baomidou.mybatisplus.service.impl.ServiceImpl#selectById(java.io.Serializable)
	 */
	@Override
	public UserCar selectById(Serializable id) {
		return userCarDao.selectById(id);
	}
	

	@Override
	public Page<UserCar> selectPage(int pageNo, UserCar userCar) {
		// return selectPage(new Page<>());
		Page<UserCar> page = new Page<>(pageNo, Constant.PAGE_SIZE);
		// System.out.println(userPetDao.selectUserPet(page));
		return page.setRecords(userCarDao.selectUserCar(page,userCar));
	}
}
