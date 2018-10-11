package com.wya1.iproperty.service.impl;

import com.wya1.iproperty.entity.UserRole;
import com.wya1.iproperty.mapper.UserRoleMapper;
import com.wya1.iproperty.service.IUserRoleService;
import com.wya1.iproperty.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */
@Transactional(readOnly=true)
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
