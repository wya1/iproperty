package com.wya1.iproperty.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wya1.iproperty.entity.Role;
import com.wya1.iproperty.mapper.RoleMapper;
import com.wya1.iproperty.service.IRoleService;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */
@Transactional(readOnly=true)
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements IRoleService {

}
