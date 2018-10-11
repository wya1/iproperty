package com.wya1.iproperty.mapper;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wya1.iproperty.entity.UserCar;

/**
 * <p>
 * 车辆信息 Mapper 接口
 * </p>
 *
 * @author wya1
 * @since 2018-08-13
 */
public interface UserCarMapper extends BaseMapper<UserCar> {
	UserCar selectById(Serializable id);
	List<UserCar> selectUserCar(Pagination page,UserCar userCar);
}
