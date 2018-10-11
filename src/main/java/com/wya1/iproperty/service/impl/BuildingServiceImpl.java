package com.wya1.iproperty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.constant.Constant;
import com.wya1.iproperty.entity.Building;
import com.wya1.iproperty.mapper.BuildingMapper;
import com.wya1.iproperty.service.IBuildingService;

/**
 * <p>
 * 大楼 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
@Transactional(readOnly=true)
@Service
public class BuildingServiceImpl extends BaseServiceImpl<BuildingMapper, Building> implements IBuildingService {
	@Autowired
	private BuildingMapper buildingDao;
	@Override
	public Page<Building> selectPage(int pageNo, Building building) {
		Page<Building> page = new Page<>(pageNo, Constant.PAGE_SIZE);
//		return selectPage(new Page<>());
		return page.setRecords(buildingDao.selectBuild(page, building));
	}
	
	@Override
	public List<Building> selectListByRecordManagementAreaId(String recordManagementAreaId) {
		return buildingDao.selectBuildByRecordManagementAreaId(recordManagementAreaId);
	}
}
