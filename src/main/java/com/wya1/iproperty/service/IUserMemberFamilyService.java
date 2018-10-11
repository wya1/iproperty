package com.wya1.iproperty.service;

import com.baomidou.mybatisplus.service.IService;
import com.wya1.iproperty.entity.UserMemberFamily;

/**
 * <p>
 * 业主家庭成员 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-09-06
 */
public interface IUserMemberFamilyService extends IService<UserMemberFamily> {

	/**
	 * @param entity
	 * @return
	 */
	boolean save(UserMemberFamily entity);
	
}
