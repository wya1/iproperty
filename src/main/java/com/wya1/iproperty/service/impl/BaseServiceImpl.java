/**
 * 
 */
package com.wya1.iproperty.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wya1.iproperty.entity.BaseEntity;
import com.wya1.iproperty.service.IBaseService;

/**
 * @author 任远曼
 * @date 2018年6月18日
 */
public class BaseServiceImpl<T1 extends BaseMapper<T2>, T2 extends BaseEntity<T2>> extends ServiceImpl<T1, T2> implements IBaseService<T2> {

	/* (non-Javadoc)
	 * @see com.wya1.iproperty.service.IBaseService#save(java.lang.Object)
	 */
	@Override
	public boolean save(T2 entity) {
		if (StringUtils.isEmpty(entity.getId())) {
			entity.setGmtCreate(new Date());
		}
		entity.setGmtModified(new Date());
		return insertOrUpdate(entity);
	}
	
}
