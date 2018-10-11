package com.wya1.iproperty.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wya1.iproperty.entity.UserInf;
import com.wya1.iproperty.entity.UserMemberFamily;
import com.wya1.iproperty.mapper.UserInfMapper;
import com.wya1.iproperty.mapper.UserMemberFamilyMapper;
import com.wya1.iproperty.service.IUserMemberFamilyService;

/**
 * <p>
 * 业主家庭成员 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-09-06
 */
@Transactional(readOnly = true)
@Service
public class UserMemberFamilyServiceImpl extends ServiceImpl<UserMemberFamilyMapper, UserMemberFamily>
		implements IUserMemberFamilyService {
	@Autowired
	private UserInfMapper userInfDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wya1.iproperty.service.impl.BaseServiceImpl#save(com.wya1.iproperty.
	 * entity.BaseEntity)
	 */
	@Transactional(readOnly = false)
	@Override
	public boolean save(UserMemberFamily entity) {
		if (entity.getUserInf() == null) {
			insertOrUpdate(entity);
			return true;
		}
		UserInf userInf = entity.getUserInf();
		if (StringUtils.isEmpty(userInf.getId())) {
			userInf.setGmtCreate(new Date());
			userInf.setGmtModified(new Date());
			userInfDao.insert(userInf);
			entity.setUserIdB(userInf.getId());
			insert(entity);
			return true;
		}
		userInf.setGmtModified(new Date());
		userInfDao.updateById(userInf);
		Wrapper<UserMemberFamily> wrapper=new EntityWrapper<>();
		wrapper.eq("user_id_a", entity.getUserIdA());
		wrapper.eq("user_id_b", entity.getUserIdB());
		update(entity, wrapper);
//		userMemberFamilyDao.updateById(entity);
//		insertOrUpdate(entity);
		return true;
	}
}
