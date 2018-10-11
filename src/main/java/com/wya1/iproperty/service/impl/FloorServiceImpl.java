package com.wya1.iproperty.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Floor;
import com.wya1.iproperty.mapper.FloorMapper;
import com.wya1.iproperty.service.IFloorService;
import com.wya1.iproperty.service.impl.BaseServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 楼层 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
@Transactional(readOnly=true)
@Service
public class FloorServiceImpl extends BaseServiceImpl<FloorMapper, Floor> implements IFloorService {
	@Autowired
	private FloorMapper floorDao;
	@Override
	public Page<Floor> selectPage() {
		return selectPage(new Page<>());
	}
	
	@Override
	public List<Floor> selectFloorByBuildingId(String buildingId) {
		return floorDao.selectFloorByBuildingId(buildingId);
	}
}
