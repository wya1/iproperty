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
import com.wya1.iproperty.service.IUserInfService;

/**
 * 用户控制类
 *
 * @author wya1
 * @since 2018-08-28
 */
@Controller
@RequestMapping("user/userInf")
public class UserInfController extends BaseController {
    
    @Autowired
    public IUserInfService userInfService;
    
    @ModelAttribute
	public UserInf get(@RequestParam(required = false) String id) {
		UserInf entity = null;
		if (id != null && !id.equals("")) {
			entity = userInfService.selectById(id);
		}
		if (entity == null) {
			entity = new UserInf();
		}
		return entity;
	}
    
    @RequiresPermissions("user:userInf:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model,Integer pageNo,UserInf userInf) {
    	if (pageNo == null || pageNo < 1) {
			pageNo=1;
		}
		Page<UserInf> page = userInfService.selectPage(pageNo,userInf);
		model.addAttribute("page", page);
		return "modules/user/userInfList";
	}
    
    @RequiresPermissions("user:userInf:view")
	@RequestMapping(value = { "list2"})
    @ResponseBody
	public Page<UserInf> list2(Integer page,String q) {
    	if (page == null || page < 1) {
    		page=1;
		}
    	UserInf userInf=new UserInf();
//    	userInf.setIdCard(q);
    	userInf.setName(q);
//    	userInf.setRemarks(q);
//    	userInf.setTel(q);
    	
		Page<UserInf> pages = userInfService.selectPage(page,userInf);
//		pages.getPages()
//		model.addAttribute("page", page);
//		return "modules/user/userInfList";
//    	return "{\"total\":4,\"param\":\"" + q + "\",\"page\":" + page + ",\"items\":" +
//        "[{\"id\":\"itag1\",\"text\":\"tag1\"},{\"id\":\"itag2\",\"text\":\"tag2\"}," +
//        "{\"id\":\"itag3\",\"text\":\"tag3\"},{\"id\":\"itag4\",\"text\":\"tag4\"}]}";
		return pages;
	}

	@RequiresPermissions("user:userInf:view")
	@RequestMapping(value = "form")
	public String form(UserInf userInf, Model model) {
		model.addAttribute("userInf", userInf);
		return "modules/user/userInfForm";
	}

	@RequiresPermissions("user:userInf:edit")
	@RequestMapping(value = "save")
	public String save(UserInf userInf, Model model) {
		userInfService.save(userInf);
		return "redirect:/user/userInf";
	}
	
	@ResponseBody
	@RequiresPermissions("user:userInf:edit")
	@RequestMapping(value = "save2")
	public String save2(UserInf userInf) {
		userInfService.save(userInf);
		return String.valueOf(userInf.getId());
	}

	@RequiresPermissions("user:userInf:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserInf userInf) {
		userInfService.deleteById(userInf);
		return "";
	}
}