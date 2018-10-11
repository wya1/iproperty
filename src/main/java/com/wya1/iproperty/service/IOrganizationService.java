package com.wya1.iproperty.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Organization;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 组织机构 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */
public interface IOrganizationService extends IBaseService<Organization> {
	/**
	 * 我使用的是SERIALIZABLE
	 * <p>
	 * 这是花费最高代价但是最可靠的事务隔离级别。
	 * <p>
	 * 事务被处理为顺序执行
	 * <p>
	 * 可以使用乐观锁和悲观锁
	 * 
	 * @param organization
	 */
	boolean save(Organization organization);

	/**
	 * 翻页查询
	 * 
	 * @return
	 */
	Page<Organization> selectPage();
}
