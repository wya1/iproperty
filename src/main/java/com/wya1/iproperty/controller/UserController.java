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
import com.wya1.iproperty.entity.User;
import com.wya1.iproperty.service.IUserService;

/**
 * 用户控制类
 *
 * @author wya1
 * @since 2018-08-13
 */
@Controller
@RequestMapping("user/user")
public class UserController extends BaseController {
    
    @Autowired
    public IUserService userService;
    
    @ModelAttribute
	public User get(@RequestParam(required = false) String id) {
		User entity = null;
		if (id != null && !id.equals("")) {
			entity = userService.selectById(id);
		}
		if (entity == null) {
			entity = new User();
		}
		return entity;
	}
    
    @RequiresPermissions("user:user:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model) {
		Page<User> page = userService.selectPage(new Page<>());
		model.addAttribute("page", page);
		return "modules/user/userList";
	}

	@RequiresPermissions("user:user:view")
	@RequestMapping(value = "form")
	public String form(User user, Model model) {
		model.addAttribute("user", user);
		return "modules/user/userForm";
	}

	@RequiresPermissions("user:user:edit")
	@RequestMapping(value = "save")
	public String save(User user, Model model) {
		userService.save(user);
		return "redirect:/user/user";
	}

	@RequiresPermissions("user:user:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(User user) {
		userService.deleteById(user);
		return "";
	}
}