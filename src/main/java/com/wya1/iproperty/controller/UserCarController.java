package com.wya1.iproperty.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.UserCar;
import com.wya1.iproperty.entity.UserInf;
import com.wya1.iproperty.service.IUserCarService;
import com.wya1.iproperty.service.IUserInfService;

/**
 * 车辆信息控制类
 *
 * @author wya1
 * @since 2018-08-13
 */
@Controller
@RequestMapping("user/userCar")
public class UserCarController extends BaseController {
    
    @Autowired
    public IUserCarService userCarService;
    @Autowired
    public IUserInfService userInfService;
    
    @ModelAttribute
	public UserCar get(@RequestParam(required = false) String id) {
		UserCar entity = null;
		if (id != null && !id.equals("")) {
			entity = userCarService.selectById(id);
		}
		if (entity == null) {
			entity = new UserCar();
		}
		return entity;
	}
    
    @RequiresPermissions("user:userCar:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model,Integer pageNo,UserCar userCar) {
    	if (pageNo == null || pageNo < 1) {
			pageNo=1;
		}
		Page<UserCar> page = userCarService.selectPage(pageNo,userCar);
		model.addAttribute("page", page);
		model.addAttribute("userCar", userCar);
		return "modules/user/userCarList";
	}

	@RequiresPermissions("user:userCar:view")
	@RequestMapping(value = "form")
	public String form(UserCar userCar, Model model) {
		model.addAttribute("userCar", userCar);
		return "modules/user/userCarForm";
	}
	
	@RequiresPermissions("user:userCar:view")
	@RequestMapping(value = "userInf/form")
	public String form2(UserCar userCar, Model model) {
		UserInf userInf=userInfService.selectById(userCar.getUserId());
		userCar.setUserInf(userInf);
		model.addAttribute("userCar", userCar);
		return "modules/user/userInfAddUserCarForm";
	}

	@RequiresPermissions("user:userCar:edit")
	@RequestMapping(value = "save")
	public String save(UserCar userCar, Model model) {
		userCarService.save(userCar);
		return "redirect:/user/userCar";
	}
	
	@RequiresPermissions("user:userCar:edit")
	@RequestMapping(value = "userInf/save")
	public String save2(UserCar userCar, Model model) {
		userCarService.save(userCar);
		return "redirect:/user/userInf/form?id="+userCar.getUserId();
	}

	@RequiresPermissions("user:userCar:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserCar userCar) {
		userCarService.deleteById(userCar);
		return "";
	}
}