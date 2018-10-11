package com.wya1.iproperty.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Floor;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 楼层 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
public interface IFloorService extends IBaseService<Floor> {
	Page<Floor> selectPage();

	/**
	 * @param buildingId
	 * @return
	 */
	List<Floor> selectFloorByBuildingId(String buildingId);
}
