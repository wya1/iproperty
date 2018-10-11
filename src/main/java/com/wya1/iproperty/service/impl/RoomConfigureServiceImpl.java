package com.wya1.iproperty.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.RoomConfigure;
import com.wya1.iproperty.mapper.RoomConfigureMapper;
import com.wya1.iproperty.service.IRoomConfigureService;
import com.wya1.iproperty.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 房间配置 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
@Transactional(readOnly=true)
@Service
public class RoomConfigureServiceImpl extends BaseServiceImpl<RoomConfigureMapper, RoomConfigure> implements IRoomConfigureService {
	@Override
	public Page<RoomConfigure> selectPage() {
		return selectPage(new Page<>());
	}
}
