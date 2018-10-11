package com.wya1.iproperty.service;

import java.io.Serializable;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.UserCar;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 业主车辆 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-31
 */
public interface IUserCarService extends IBaseService<UserCar> {
	UserCar selectById(Serializable id);
	Page<UserCar> selectPage(int pageNo,UserCar userCar);
}
