package com.wya1.iproperty.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Building;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 大楼 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
public interface IBuildingService extends IBaseService<Building> {

	/**
	 * @param pageNo
	 * @param building
	 * @return
	 */
	Page<Building> selectPage(int pageNo, Building building);

	/**
	 * @param recordManagementAreaId
	 * @return
	 */
	List<Building> selectListByRecordManagementAreaId(String recordManagementAreaId);
}
