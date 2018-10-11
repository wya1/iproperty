package com.wya1.iproperty.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.ContractType;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 合同类型 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-09-29
 */
public interface IContractTypeService extends IBaseService<ContractType> {
	Page<ContractType> selectPage(int pageNo,ContractType contractType);
}
