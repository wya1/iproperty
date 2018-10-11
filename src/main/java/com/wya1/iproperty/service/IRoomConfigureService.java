package com.wya1.iproperty.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.RoomConfigure;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 房间配置 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
public interface IRoomConfigureService extends IBaseService<RoomConfigure> {
	Page<RoomConfigure> selectPage();
}
