package com.wya1.iproperty.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wya1.iproperty.entity.Building;

/**
 * <p>
 * 大楼 Mapper 接口
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
public interface BuildingMapper extends BaseMapper<Building> {
	List<Building> selectBuild(Pagination page,Building building);
	List<Building> selectBuildByRecordManagementAreaId(String recordManagementAreaId);
}
