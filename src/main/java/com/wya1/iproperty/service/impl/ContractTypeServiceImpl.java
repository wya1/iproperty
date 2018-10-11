package com.wya1.iproperty.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.constant.Constant;
import com.wya1.iproperty.entity.ContractType;
import com.wya1.iproperty.mapper.ContractTypeMapper;
import com.wya1.iproperty.service.IContractTypeService;
import com.wya1.iproperty.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 合同类型 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-09-29
 */
@Transactional(readOnly=true)
@Service
public class ContractTypeServiceImpl extends BaseServiceImpl<ContractTypeMapper, ContractType> implements IContractTypeService {
	@Override
	public Page<ContractType> selectPage(int pageNo,ContractType contractType) {
		Page<ContractType> page = new Page<>(pageNo, Constant.PAGE_SIZE);
		return selectPage(page);
	}
}
