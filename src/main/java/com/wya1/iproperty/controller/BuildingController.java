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

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Building;
import com.wya1.iproperty.entity.RecordManagementArea;
import com.wya1.iproperty.entity.UserInf;
import com.wya1.iproperty.service.IBuildingService;
import com.wya1.iproperty.service.IFloorService;
import com.wya1.iproperty.service.IRecordManagementAreaService;
import com.wya1.iproperty.service.IUserInfService;

/**
 * 大楼控制类
 *
 * @author wya1
 * @since 2018-07-29
 */
@Controller
@RequestMapping("house/building")
public class BuildingController extends BaseController {

	@Autowired
	public IBuildingService buildingService;
	@Autowired
	public IUserInfService userInfService;
	@Autowired
	public IRecordManagementAreaService recordManagementAreaService;
	@Autowired
	public IFloorService floorService;

	@ModelAttribute
	public Building get(@RequestParam(required = false) String id) {
		Building entity = null;
		if (id != null && !id.equals("")) {
			entity = buildingService.selectById(id);
		}
		if (entity == null) {
			entity = new Building();
		}
		return entity;
	}

	@RequiresPermissions("house:building:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model, Integer pageNo, Building building) {
		if (pageNo == null || pageNo < 1) {
			pageNo = 1;
		}
		Page<Building> page = buildingService.selectPage(pageNo, building);
		model.addAttribute("page", page);
		return "modules/house/buildingList";
	}

	@RequiresPermissions("house:building:view")
	@RequestMapping(value = "form")
	public String form(Building building, Model model) {
		if (building != null && building.getUserId() != null) {
			UserInf userInf = userInfService.selectById(building.getUserId());
			building.setUserInf(userInf);
		}
		model.addAttribute("building", building);
		Wrapper<RecordManagementArea> wrapper = new EntityWrapper<>();
		model.addAttribute("recordManagementAreas", recordManagementAreaService.selectList(wrapper));
		return "modules/house/buildingForm";
	}

	@RequiresPermissions("house:building:view")
	@RequestMapping(value = "recordManagementArea/form")
	public String form2(Building building, Model model) {
		if (building != null && building.getUserId() != null) {
			UserInf userInf = userInfService.selectById(building.getUserId());
			building.setUserInf(userInf);
		}
		if (building != null && building.getRecordManagementAreaId() != null) {
			RecordManagementArea recordManagementArea = recordManagementAreaService
					.selectById(building.getRecordManagementAreaId());
			building.setRecordManagementArea(recordManagementArea);
		}
		if (building != null && building.getId() != null) {
			building.setFloors(floorService.selectFloorByBuildingId(building.getId()));
			model.addAttribute("building", building);
		}

		// Wrapper<RecordManagementArea> wrapper=new EntityWrapper<>();
		// model.addAttribute("recordManagementAreas",
		// recordManagementAreaService.selectList(wrapper));
		return "modules/house/recordManagementAreaAddBuildingForm";
	}

	@RequiresPermissions("house:building:edit")
	@RequestMapping(value = "save")
	public String save(Building building, Model model) {
		buildingService.save(building);
		return "redirect:/house/building";
	}

	@RequiresPermissions("house:building:edit")
	@RequestMapping(value = "recordManagementArea/save")
	public String save2(Building building, Model model) {
		buildingService.save(building);
		return "redirect:/house/recordManagementArea/form?id=" + building.getRecordManagementAreaId();
	}

	@ResponseBody
	@RequiresPermissions("house:building:edit")
	@RequestMapping(value = "save2")
	public String save3(Building building, Model model) {
		buildingService.save(building);
		return building.getId();
	}

	@RequiresPermissions("house:building:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Building building) {
		buildingService.deleteById(building);
		return "";
	}
}