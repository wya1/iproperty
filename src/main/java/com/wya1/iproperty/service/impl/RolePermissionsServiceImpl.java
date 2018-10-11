package com.wya1.iproperty.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wya1.iproperty.entity.RolePermissions;
import com.wya1.iproperty.mapper.RolePermissionsMapper;
import com.wya1.iproperty.service.IRolePermissionsService;

/**
 * <p>
 * 角色权限 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */
@Transactional(readOnly=true)
@Service
public class RolePermissionsServiceImpl extends ServiceImpl<RolePermissionsMapper, RolePermissions> implements IRolePermissionsService{

	/* (non-Javadoc)
	 * @see com.wya1.iproperty.service.IRolePermissionsService#getList(java.lang.String)
	 */
	@Override
	public List<RolePermissions> getList(String id) {
		EntityWrapper<RolePermissions> wrapper=new EntityWrapper<>();
		wrapper.eq("role_id", id);
//		Page<RolePermissions> page = selectPage(new Page<>(),wrapper);
		return selectList(wrapper);
	}

}
