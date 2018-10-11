package com.wya1.iproperty.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.UserPet;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 宠物信息 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-08-28
 */
public interface IUserPetService extends IBaseService<UserPet> {
	Page<UserPet> selectPage(int pageNo,UserPet userPet);
}
