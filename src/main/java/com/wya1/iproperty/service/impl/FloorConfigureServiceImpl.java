package com.wya1.iproperty.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.FloorConfigure;
import com.wya1.iproperty.mapper.FloorConfigureMapper;
import com.wya1.iproperty.service.IFloorConfigureService;
import com.wya1.iproperty.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 楼层配置 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
@Transactional(readOnly=true)
@Service
public class FloorConfigureServiceImpl extends BaseServiceImpl<FloorConfigureMapper, FloorConfigure> implements IFloorConfigureService {
	@Override
	public Page<FloorConfigure> selectPage() {
		return selectPage(new Page<>());
	}
}
