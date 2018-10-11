package com.wya1.iproperty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.constant.Constant;
import com.wya1.iproperty.entity.RecordManagementArea;
import com.wya1.iproperty.mapper.RecordManagementAreaMapper;
import com.wya1.iproperty.service.IRecordManagementAreaService;

/**
 * <p>
 * 记录管理区 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */
@Transactional(readOnly=true)
@Service
public class RecordManagementAreaServiceImpl extends BaseServiceImpl<RecordManagementAreaMapper, RecordManagementArea> implements IRecordManagementAreaService {
	@Autowired
	private RecordManagementAreaMapper recordManagementAreaDao;
	@Override
	public Page<RecordManagementArea> selectPage(int pageNo,RecordManagementArea recordManagementArea) {
		Page<RecordManagementArea> page = new Page<>(pageNo, Constant.PAGE_SIZE);
		return page.setRecords(recordManagementAreaDao.selectRecordManagementArea(page, recordManagementArea));
	}
}
