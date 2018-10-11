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
import com.wya1.iproperty.entity.ContractType;
import com.wya1.iproperty.service.IContractTypeService;

/**
 * 合同类型控制类
 *
 * @author wya1
 * @since 2018-09-29
 */
@Controller
@RequestMapping("lease/contractType")
public class ContractTypeController extends BaseController {
    
    @Autowired
    public IContractTypeService contractTypeService;
    
    @ModelAttribute
	public ContractType get(@RequestParam(required = false) String id) {
		ContractType entity = null;
		if (id != null && !id.equals("")) {
			entity = contractTypeService.selectById(id);
		}
		if (entity == null) {
			entity = new ContractType();
		}
		return entity;
	}
    
    @RequiresPermissions("lease:contractType:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model,Integer pageNo,ContractType contractType) {
    	if (pageNo == null || pageNo < 1) {
			pageNo=1;
		}
		Page<ContractType> page = contractTypeService.selectPage(pageNo,contractType);
		model.addAttribute("page", page);
		return "modules/lease/contractTypeList";
	}

	@RequiresPermissions("lease:contractType:view")
	@RequestMapping(value = "form")
	public String form(ContractType contractType, Model model) {
		model.addAttribute("contractType", contractType);
		return "modules/lease/contractTypeForm";
	}

	@RequiresPermissions("lease:contractType:edit")
	@RequestMapping(value = "save")
	public String save(ContractType contractType, Model model) {
		contractTypeService.save(contractType);
		return "redirect:/lease/contractType";
	}

	@RequiresPermissions("lease:contractType:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ContractType contractType) {
		contractTypeService.deleteById(contractType);
		return "";
	}
}