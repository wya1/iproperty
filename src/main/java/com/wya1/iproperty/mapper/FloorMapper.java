package com.wya1.iproperty.mapper;

import com.wya1.iproperty.entity.Floor;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 楼层 Mapper 接口
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
public interface FloorMapper extends BaseMapper<Floor> {
	public List<Floor> selectFloorByBuildingId(String buildingId);
}
