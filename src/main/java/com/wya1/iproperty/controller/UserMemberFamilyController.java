package com.wya1.iproperty.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.wya1.iproperty.entity.UserInf;
import com.wya1.iproperty.entity.UserMemberFamily;
import com.wya1.iproperty.service.IUserInfService;
import com.wya1.iproperty.service.IUserMemberFamilyService;

/**
 * 业主家庭成员控制类
 *
 * @author wya1
 * @since 2018-09-06
 */
@Controller
@RequestMapping("user/userMemberFamily")
public class UserMemberFamilyController extends BaseController {
    
    @Autowired
    public IUserMemberFamilyService userMemberFamilyService;
    @Autowired
    public IUserInfService userInfService;
    

	@RequiresPermissions("user:userMemberFamily:view")
	@RequestMapping(value = "form")
	public String form(UserMemberFamily userMemberFamily, Model model) {
//		model.addAttribute("userMemberFamily", userMemberFamily);
		return "modules/user/userMemberFamilyForm";
	}
	
	@RequiresPermissions("user:userMemberFamily:view")
	@RequestMapping(value = "userInf/form")
	public String form2(UserMemberFamily userMemberFamily, Model model,String id,String userId) {
		if (!StringUtils.isEmpty(id)) {
			Wrapper<UserMemberFamily> wrapper=new EntityWrapper<>();
			wrapper.eq("user_id_a", id);
			userMemberFamily=userMemberFamilyService.selectOne(wrapper);
			if(userMemberFamily==null) {
				Wrapper<UserMemberFamily> wrapper2=new EntityWrapper<>();
				wrapper2.eq("user_id_b", id);
				userMemberFamily=userMemberFamilyService.selectOne(wrapper2);	
//				userMemberFamily.setUserInf(userInfService.selectById(userMemberFamily.getUserIdA()));
				model.addAttribute("userInf", userInfService.selectById(userMemberFamily.getUserIdA()));
			}else {
//				userMemberFamily.setUserInf(userInfService.selectById(userMemberFamily.getUserIdB()));
				model.addAttribute("userInf", userInfService.selectById(userMemberFamily.getUserIdB()));
			}
			userMemberFamily.setUserInf(userInfService.selectById(id));
//			UserInf userInf=userInfService.selectById(id);
//			model.addAttribute("userInf", userInf);
		}else {
			userMemberFamily=new UserMemberFamily();
			userMemberFamily.setUserIdA(userId);
			UserInf userInf=userInfService.selectById(userId);
			model.addAttribute("userInf", userInf);
		}
		model.addAttribute("userMemberFamily", userMemberFamily);
		return "modules/user/userInfAdduserMemberFamilyForm";
	}

	@RequiresPermissions("user:userMemberFamily:edit")
	@RequestMapping(value = "save")
	public String save(UserMemberFamily userMemberFamily, Model model) {
		userMemberFamilyService.save(userMemberFamily);
		return "redirect:/user/userMemberFamily";
	}
	
	@RequiresPermissions("user:userMemberFamily:edit")
	@RequestMapping(value = "userInf/save")
	public String save2(UserMemberFamily userMemberFamily, Model model,String userId) {
		userMemberFamilyService.save(userMemberFamily);
		return "redirect:/user/userInf/form?id="+userId;
	}

	@RequiresPermissions("user:userMemberFamily:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserMemberFamily userMemberFamily) {
		userMemberFamilyService.deleteById(userMemberFamily);
		return "";
	}
}