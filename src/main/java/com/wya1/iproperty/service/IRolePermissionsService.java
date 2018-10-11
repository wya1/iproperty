package com.wya1.iproperty.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.wya1.iproperty.entity.RolePermissions;

/**
 * <p>
 * 角色权限 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */
public interface IRolePermissionsService extends IService<RolePermissions> {

	List<RolePermissions> getList(String id);
}
