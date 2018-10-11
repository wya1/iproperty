package com.wya1.iproperty.controller;

import org.springframework.stereotype.Controller;
import com.wya1.iproperty.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Contract;
import com.wya1.iproperty.service.IContractService;

/**
 * 合同控制类
 *
 * @author wya1
 * @since 2018-09-29
 */
@Controller
@RequestMapping("lease/contract")
public class ContractController extends BaseController {
    
    @Autowired
    public IContractService contractService;
    
    @ModelAttribute
	public Contract get(@RequestParam(required = false) String id) {
		Contract entity = null;
		if (id != null && !id.equals("")) {
			entity = contractService.selectById(id);
		}
		if (entity == null) {
			entity = new Contract();
		}
		return entity;
	}
    
    @RequiresPermissions("lease:contract:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model,Integer pageNo,Contract contract) {
    	if (pageNo == null || pageNo < 1) {
			pageNo=1;
		}
		Page<Contract> page = contractService.selectPage(pageNo,contract);
		model.addAttribute("page", page);
		return "modules/lease/contractList";
	}

	@RequiresPermissions("lease:contract:view")
	@RequestMapping(value = "form")
	public String form(Contract contract, Model model) {
		model.addAttribute("contract", contract);
		return "modules/lease/contractForm";
	}

	@RequiresPermissions("lease:contract:edit")
	@RequestMapping(value = "save")
	public String save(Contract contract, Model model) {
		contractService.save(contract);
		return "redirect:/lease/contract";
	}

	@RequiresPermissions("lease:contract:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Contract contract) {
		contractService.deleteById(contract);
		return "";
	}
}