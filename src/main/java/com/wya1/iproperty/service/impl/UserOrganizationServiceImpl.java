package com.wya1.iproperty.service.impl;

import com.wya1.iproperty.entity.UserOrganization;
import com.wya1.iproperty.mapper.UserOrganizationMapper;
import com.wya1.iproperty.service.IUserOrganizationService;
import com.wya1.iproperty.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户组织机构 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */
@Transactional(readOnly=true)
@Service
public class UserOrganizationServiceImpl extends BaseServiceImpl<UserOrganizationMapper, UserOrganization> implements IUserOrganizationService {

}
