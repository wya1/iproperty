package com.wya1.iproperty.mapper;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wya1.iproperty.entity.UserMemberFamily;

/**
 * <p>
 * 业主家庭成员 Mapper 接口
 * </p>
 *
 * @author wya1
 * @since 2018-09-06
 */
public interface UserMemberFamilyMapper extends BaseMapper<UserMemberFamily> {
	List<UserMemberFamily> selectByUserId1(Serializable id);

	List<UserMemberFamily> selectByUserId2(Serializable id);
}
