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
import com.wya1.iproperty.entity.RecordManagementArea;
import com.wya1.iproperty.entity.UserInf;
import com.wya1.iproperty.service.IBuildingService;
import com.wya1.iproperty.service.IRecordManagementAreaService;
import com.wya1.iproperty.service.IUserInfService;

/**
 * 记录管理区控制类
 *
 * @author wya1
 * @since 2018-07-29
 */
@Controller
@RequestMapping(value = { "house/recordManagementArea", "", "house" })
public class RecordManagementAreaController extends BaseController {

	@Autowired
	private IRecordManagementAreaService recordManagementAreaService;
	@Autowired
	private IUserInfService userInfService;
	@Autowired
	private IBuildingService buildingService;

	@ModelAttribute
	public RecordManagementArea get(@RequestParam(required = false) String id) {
		RecordManagementArea entity = null;
		if (id != null && !id.equals("")) {
			entity = recordManagementAreaService.selectById(id);
		}
		if (entity == null) {
			entity = new RecordManagementArea();
		}
		return entity;
	}

	@RequiresPermissions("house:recordManagementArea:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model, Integer pageNo, RecordManagementArea recordManagementArea) {
		if (pageNo == null || pageNo < 1) {
			pageNo = 1;
		}
		Page<RecordManagementArea> page = recordManagementAreaService.selectPage(pageNo, recordManagementArea);
		model.addAttribute("page", page);
		return "modules/house/recordManagementAreaList";
	}

	@RequiresPermissions("house:recordManagementArea:view")
	@RequestMapping(value = "form")
	public String form(RecordManagementArea recordManagementArea, Model model) {
		if (recordManagementArea != null && recordManagementArea.getUserId() != null) {
			UserInf userInf = userInfService.selectById(recordManagementArea.getUserId());
			recordManagementArea.setUserInf(userInf);
			recordManagementArea.setBuildings(buildingService.selectListByRecordManagementAreaId(recordManagementArea.getId()));
		}
		model.addAttribute("recordManagementArea", recordManagementArea);
		return "modules/house/recordManagementAreaForm";
	}

	@RequiresPermissions("house:recordManagementArea:edit")
	@RequestMapping(value = "save")
	public String save(RecordManagementArea recordManagementArea, Model model) {
		recordManagementAreaService.save(recordManagementArea);
		return "redirect:/house/recordManagementArea";
	}

	@ResponseBody
	@RequiresPermissions("house:recordManagementArea:edit")
	@RequestMapping(value = "save2")
	public String save2(RecordManagementArea recordManagementArea, Model model) {
		recordManagementAreaService.save(recordManagementArea);
		return String.valueOf(recordManagementArea.getId());
	}

	@RequiresPermissions("house:recordManagementArea:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(RecordManagementArea recordManagementArea) {
		recordManagementAreaService.deleteById(recordManagementArea);
		return "";
	}
}