/**
 * 
 */
package com.wya1.iproperty.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wya1.iproperty.entity.Permissions;
import com.wya1.iproperty.service.IPermissionsService;

/**
 * 权限控制类
 * 
 * @author 任远曼
 * @date 2018年6月26日
 */
@Controller
@RequestMapping(value = "/sys/permissions")
public class PermissionsController extends BaseController {
	@Autowired
	private IPermissionsService permissionsService;

	@ModelAttribute
	public Permissions get(@RequestParam(required = false) String id) {
		Permissions entity = null;
		if (id != null && !id.equals("")) {
			entity = permissionsService.selectById(id);
		}
		if (entity == null) {
			entity = new Permissions();
		}
		return entity;
	}

	@RequiresPermissions("sys:permissions:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model,Integer pageNo,Permissions permissions) {
		if (pageNo == null || pageNo < 1) {
			pageNo=1;
		}
		model.addAttribute("page", permissionsService.selectPage(pageNo,permissions));
		return "modules/sys/permissionsList";
	}

	@RequiresPermissions("sys:permissions:view")
	@RequestMapping(value = "form")
	public String form(Permissions permissions, Model model) {
		model.addAttribute("permissions", permissions);
		return "modules/sys/permissionsForm";
	}

	@RequiresPermissions("sys:permissions:edit")
	@RequestMapping(value = "save")
	public String save(Permissions permissions, Model model) {
		permissionsService.save(permissions);
		return "redirect:/sys/permissions";
	}

	@RequiresPermissions("sys:permissions:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Permissions permissions) {
		permissionsService.deleteById(permissions);
		return "";
	}
}
