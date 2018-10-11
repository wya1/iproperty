/**
 * 
 */
package com.wya1.iproperty.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Organization;
import com.wya1.iproperty.entity.OrganizationRole;
import com.wya1.iproperty.service.IOrganizationRoleService;
import com.wya1.iproperty.service.IOrganizationService;
import com.wya1.iproperty.service.IRoleService;

/**
 * 组织机构控制类
 * 
 * @author 任远曼
 * @date 2018年7月3日
 */
@Controller
@RequestMapping(value = "/sys/organization")
public class OrganizationController extends BaseController {
	@Autowired
	private IOrganizationService organizationService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IOrganizationRoleService organizationRoleService;

	@ModelAttribute
	public Organization get(@RequestParam(required = false) String id) {
		Organization entity = null;
		if (id != null && !id.equals("")) {
			entity = organizationService.selectById(id);
		}
		if (entity == null) {
			entity = new Organization();
		}
		return entity;
	}

	@RequiresPermissions("sys:organization:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model) {
		Page<Organization> page=organizationService.selectPage();
		model.addAttribute("page", page);
		return "modules/sys/organizationList";
	}

	@RequiresPermissions("sys:organization:view")
	@RequestMapping(value = "form")
	public String form(Organization organization, Model model) {
		Page<Organization> page=organizationService.selectPage();
		model.addAttribute("page", page);
		model.addAttribute("roles", roleService.selectPage(new Page<>()).getRecords());
		model.addAttribute("organizationRoles", organizationRoleService.getList(organization.getId()));
		model.addAttribute("organization", organization);
		model.addAttribute("parent", organizationService.selectById(organization.getParentId()));
		return "modules/sys/organizationForm";
	}

	@RequiresPermissions("sys:organization:edit")
	@RequestMapping(value = "save")
	public String save(Organization organization, Model model) {
		organizationService.save(organization);
		List<OrganizationRole> list=new ArrayList<>();
		List<String> roleIds=organization.getRoleIds();
		if (roleIds != null) {
			for (String roleId : roleIds) {
				OrganizationRole organizationRole = new OrganizationRole();
				organizationRole.setOrganizationId(organization.getId());
				organizationRole.setRoleId(roleId);
				list.add(organizationRole);
			}
		}
		EntityWrapper<OrganizationRole> wrapper=new EntityWrapper<>();
		wrapper.eq("organization_id", organization.getId());
		organizationRoleService.delete(wrapper);
		if (list.size()>0) {
			organizationRoleService.insertBatch(list);
		}
		return "redirect:/sys/organization";
	}

	@RequiresPermissions("sys:organization:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Organization organization) {
		organizationService.deleteById(organization);
		return "";
	}
}
