package com.wya1.iproperty.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wya1.iproperty.entity.UserInf;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author wya1
 * @since 2018-08-13
 */
public interface UserInfMapper extends BaseMapper<UserInf> {
	List<UserInf> selectUserInf(Pagination page,UserInf userInf);
}
