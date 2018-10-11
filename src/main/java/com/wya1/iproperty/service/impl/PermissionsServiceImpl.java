package com.wya1.iproperty.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.constant.Constant;
import com.wya1.iproperty.entity.Permissions;
import com.wya1.iproperty.mapper.PermissionsMapper;
import com.wya1.iproperty.service.IPermissionsService;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */
@Transactional(readOnly=true)
@Service
public class PermissionsServiceImpl extends BaseServiceImpl<PermissionsMapper, Permissions> implements IPermissionsService {

	/* (non-Javadoc)
	 * @see com.wya1.iproperty.service.IPermissionsService#selectPage()
	 */
	@Override
	public Page<Permissions> selectPage(int pageNo,Permissions permissions) {
		EntityWrapper<Permissions> wrapper=new EntityWrapper<>();
		wrapper.orderBy("permission");
		Page<Permissions> page=new Page<>(pageNo, Constant.PAGE_SIZE);
		return selectPage(page,wrapper);
	}

}
