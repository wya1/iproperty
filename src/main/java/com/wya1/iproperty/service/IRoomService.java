package com.wya1.iproperty.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Room;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 房间 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
public interface IRoomService extends IBaseService<Room> {
	Page<Room> selectPage();

	/**
	 * @param floorId
	 * @return
	 */
	List<Room> selectRoomByFloorId(String floorId);
}
