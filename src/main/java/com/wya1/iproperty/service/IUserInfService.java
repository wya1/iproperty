package com.wya1.iproperty.service;

import java.io.Serializable;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.UserInf;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-08-28
 */
public interface IUserInfService extends IBaseService<UserInf> {
	Page<UserInf> selectPage(int pageNo,UserInf userInf);
	UserInf selectById(Serializable id);
}
