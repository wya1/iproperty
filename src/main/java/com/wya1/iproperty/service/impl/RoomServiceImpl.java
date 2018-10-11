package com.wya1.iproperty.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Room;
import com.wya1.iproperty.mapper.RoomMapper;
import com.wya1.iproperty.service.IRoomService;
import com.wya1.iproperty.service.impl.BaseServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 房间 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
@Transactional(readOnly=true)
@Service
public class RoomServiceImpl extends BaseServiceImpl<RoomMapper, Room> implements IRoomService {
	@Autowired
	private RoomMapper roomDao;
	@Override
	public Page<Room> selectPage() {
		return selectPage(new Page<>());
	}
	
	@Override
	public List<Room> selectRoomByFloorId(String floorId){
		return roomDao.selectRoomByFloorId(floorId);
	}
}
