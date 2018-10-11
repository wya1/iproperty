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
import com.wya1.iproperty.entity.Permissions;
import com.wya1.iproperty.entity.Role;
import com.wya1.iproperty.entity.RolePermissions;
import com.wya1.iproperty.service.IPermissionsService;
import com.wya1.iproperty.service.IRolePermissionsService;
import com.wya1.iproperty.service.IRoleService;

/**
 * 角色控制类
 * 
 * @author 任远曼
 * @date 2018年6月18日
 */
@Controller
@RequestMapping(value = "/sys/role")
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IPermissionsService permissionsService;
	@Autowired
	private IRolePermissionsService rolePermissionsService;

	@ModelAttribute
	public Role get(@RequestParam(required = false) String id) {
		Role entity = null;
		if (id != null && !id.equals("")) {
			entity = roleService.selectById(id);
		}
		if (entity == null) {
			entity = new Role();
		}
		return entity;
	}

	@RequiresPermissions("sys:role:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model) {
		// List<Role> list = roleService.getRoles();
		Page<Role> page = roleService.selectPage(new Page<>());
		model.addAttribute("page", page);
		return "modules/sys/roleList";
	}

	@RequiresPermissions("sys:role:view")
	@RequestMapping(value = "form")
	public String form(Role role, Model model) {
		model.addAttribute("role", role);
		EntityWrapper<Permissions> wrapper=new EntityWrapper<>();
		wrapper.orderBy("permission");
		model.addAttribute("permissionss", permissionsService.selectList(wrapper));
//		model.addAttribute("permissionss", permissionsService.selectPage().getRecords());
		model.addAttribute("rolePermissionss", rolePermissionsService.getList(role.getId()));
		return "modules/sys/roleForm";
	}

	@RequiresPermissions("sys:role:edit")
	@RequestMapping(value = "save")
	public String save(Role role, Model model) {
		roleService.save(role);
		
		List<RolePermissions> list=new ArrayList<>();
		List<String> permissionIds=role.getPermissionIds();
		for(String permissionId:permissionIds) {
			RolePermissions rolePermissions=new RolePermissions();
			rolePermissions.setPermissionId(permissionId);
			rolePermissions.setRoleId(role.getId());
			list.add(rolePermissions);
		}
		EntityWrapper<RolePermissions> wrapper=new EntityWrapper<>();
		wrapper.eq("role_id", role.getId());
		rolePermissionsService.delete(wrapper);
		rolePermissionsService.insertBatch(list);
		
		return "redirect:/sys/role";
	}

	@RequiresPermissions("sys:role:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Role role) {
		// shopAritleService.delete(shopAritle);
		// addMessage(redirectAttributes, "删除文章成功");
		roleService.deleteById(role);
		return "";
	}
}
