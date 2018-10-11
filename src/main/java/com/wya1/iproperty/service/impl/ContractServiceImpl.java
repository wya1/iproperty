package com.wya1.iproperty.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.constant.Constant;
import com.wya1.iproperty.entity.Contract;
import com.wya1.iproperty.mapper.ContractMapper;
import com.wya1.iproperty.service.IContractService;
import com.wya1.iproperty.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 合同 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-09-29
 */
@Transactional(readOnly=true)
@Service
public class ContractServiceImpl extends BaseServiceImpl<ContractMapper, Contract> implements IContractService {
	@Override
	public Page<Contract> selectPage(int pageNo,Contract contract) {
		Page<Contract> page = new Page<>(pageNo, Constant.PAGE_SIZE);
		return selectPage(page);
	}
}
