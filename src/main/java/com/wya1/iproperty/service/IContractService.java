package com.wya1.iproperty.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Contract;
import com.wya1.iproperty.service.IBaseService;

/**
 * <p>
 * 合同 服务类
 * </p>
 *
 * @author wya1
 * @since 2018-09-29
 */
public interface IContractService extends IBaseService<Contract> {
	Page<Contract> selectPage(int pageNo,Contract contract);
}
