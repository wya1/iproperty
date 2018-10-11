package com.wya1.iproperty.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.RecordManagementAreaConfigure;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 记录管理区配置 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
public interface IRecordManagementAreaConfigureService extends IBaseService<RecordManagementAreaConfigure> {
	Page<RecordManagementAreaConfigure> selectPage();
}
