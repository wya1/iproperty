package com.wya1.iproperty.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wya1.iproperty.entity.OrganizationRole;
import com.wya1.iproperty.mapper.OrganizationRoleMapper;
import com.wya1.iproperty.service.IOrganizationRoleService;

/**
 * <p>
 * 组织机构角色 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */
@Transactional(readOnly=true)
@Service
public class OrganizationRoleServiceImpl extends ServiceImpl<OrganizationRoleMapper, OrganizationRole> implements IOrganizationRoleService {

	/* (non-Javadoc)
	 * @see com.wya1.iproperty.service.IOrganizationRoleService#getOrganizationRoles()
	 */
	@Override
	public List<OrganizationRole> getList(String id) {
		EntityWrapper<OrganizationRole> wrapper=new EntityWrapper<>();
		wrapper.eq("organization_id", id);
		Page<OrganizationRole> page = selectPage(new Page<>(),wrapper);
		return page.getRecords();
	}

}
