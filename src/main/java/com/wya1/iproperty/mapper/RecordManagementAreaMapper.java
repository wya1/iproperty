package com.wya1.iproperty.mapper;

import com.wya1.iproperty.entity.RecordManagementArea;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
 * 记录管理区 Mapper 接口
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
public interface RecordManagementAreaMapper extends BaseMapper<RecordManagementArea> {
	List<RecordManagementArea> selectRecordManagementArea(Pagination page,RecordManagementArea recordManagementArea);
}
