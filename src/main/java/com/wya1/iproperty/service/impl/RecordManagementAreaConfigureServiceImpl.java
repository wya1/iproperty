package com.wya1.iproperty.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.RecordManagementAreaConfigure;
import com.wya1.iproperty.mapper.RecordManagementAreaConfigureMapper;
import com.wya1.iproperty.service.IRecordManagementAreaConfigureService;
import com.wya1.iproperty.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 记录管理区配置 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
@Transactional(readOnly=true)
@Service
public class RecordManagementAreaConfigureServiceImpl extends BaseServiceImpl<RecordManagementAreaConfigureMapper, RecordManagementAreaConfigure> implements IRecordManagementAreaConfigureService {
	@Override
	public Page<RecordManagementAreaConfigure> selectPage() {
		return selectPage(new Page<>());
	}
}
