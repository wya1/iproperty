package com.wya1.iproperty.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.BuildingConfigure;
import com.wya1.iproperty.mapper.BuildingConfigureMapper;
import com.wya1.iproperty.service.IBuildingConfigureService;
import com.wya1.iproperty.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 大楼配置 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
@Transactional(readOnly=true)
@Service
public class BuildingConfigureServiceImpl extends BaseServiceImpl<BuildingConfigureMapper, BuildingConfigure> implements IBuildingConfigureService {
	@Override
	public Page<BuildingConfigure> selectPage() {
		return selectPage(new Page<>());
	}
}
