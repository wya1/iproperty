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
import com.wya1.iproperty.entity.UserInf;
import com.wya1.iproperty.entity.UserPet;
import com.wya1.iproperty.service.IUserInfService;
import com.wya1.iproperty.service.IUserPetService;

/**
 * 宠物信息控制类
 *
 * @author wya1
 * @since 2018-08-28
 */
@Controller
@RequestMapping("user/userPet")
public class UserPetController extends BaseController {
    
    @Autowired
    public IUserPetService userPetService;
    @Autowired
    public IUserInfService userInfService;
    
    @ModelAttribute
	public UserPet get(@RequestParam(required = false) String id) {
		UserPet entity = null;
		if (id != null && !id.equals("")) {
			entity = userPetService.selectById(id);
		}
		if (entity == null) {
			entity = new UserPet();
		}
		return entity;
	}
    
    @RequiresPermissions("user:userPet:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model,Integer pageNo,UserPet userPet) {
    	if (pageNo == null || pageNo < 1) {
			pageNo=1;
		}
		Page<UserPet> page = userPetService.selectPage(pageNo,userPet);
		model.addAttribute("page", page);
		return "modules/user/userPetList";
	}

	@RequiresPermissions("user:userPet:view")
	@RequestMapping(value = "form")
	public String form(UserPet userPet, Model model) {
		if (userPet != null && userPet.getUserId() != null) {
			UserInf userInf = userInfService.selectById(userPet.getUserId());
			userPet.setUserInf(userInf);
		}
		model.addAttribute("userPet", userPet);
		return "modules/user/userPetForm";
	}
	
	@RequiresPermissions("user:userPet:view")
	@RequestMapping(value = "userInf/form")
	public String form2(UserPet userPet, Model model) {
		UserInf userInf=userInfService.selectById(userPet.getUserId());
		userPet.setUserInf(userInf);
		model.addAttribute("userPet", userPet);
		return "modules/user/userInfAddUserPetForm";
	}

	@RequiresPermissions("user:userPet:edit")
	@RequestMapping(value = "save")
	public String save(UserPet userPet, Model model) {
		userPetService.save(userPet);
		return "redirect:/user/userPet";
	}
	
	@RequiresPermissions("user:userPet:edit")
	@RequestMapping(value = "userInf/save")
	public String save2(UserPet userPet, Model model) {
		userPetService.save(userPet);
		return "redirect:/user/userInf/form?id="+userPet.getUserId();
	}

	@RequiresPermissions("user:userPet:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserPet userPet) {
		userPetService.deleteById(userPet);
		return "";
	}
}