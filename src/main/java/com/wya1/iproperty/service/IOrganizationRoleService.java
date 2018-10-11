package com.wya1.iproperty.service;

import com.wya1.iproperty.entity.OrganizationRole;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 组织机构角色 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-24
 */
public interface IOrganizationRoleService extends IService<OrganizationRole> {
	List<OrganizationRole> getList(String id);
}
