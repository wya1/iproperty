package com.wya1.iproperty.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wya1.iproperty.entity.Room;

/**
 * <p>
 * 房间 Mapper 接口
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
public interface RoomMapper extends BaseMapper<Room> {
	List<Room> selectRoomByFloorId(String floorId);
}
