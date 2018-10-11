package com.wya1.iproperty.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Permissions;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */
public interface IPermissionsService extends IBaseService<Permissions> {

	/**
	 * @param pageNo
	 * @param permissions
	 * @return
	 */
	Page<Permissions> selectPage(int pageNo, Permissions permissions);
}
