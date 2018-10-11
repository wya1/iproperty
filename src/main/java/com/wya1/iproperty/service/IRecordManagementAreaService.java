package com.wya1.iproperty.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.RecordManagementArea;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 记录管理区 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
public interface IRecordManagementAreaService extends IBaseService<RecordManagementArea> {

	/**
	 * @param pageNo
	 * @param recordManagementArea
	 * @return
	 */
	Page<RecordManagementArea> selectPage(int pageNo, RecordManagementArea recordManagementArea);
}
