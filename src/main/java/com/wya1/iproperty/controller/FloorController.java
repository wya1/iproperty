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
import com.wya1.iproperty.entity.Building;
import com.wya1.iproperty.entity.Floor;
import com.wya1.iproperty.entity.UserInf;
import com.wya1.iproperty.service.IBuildingService;
import com.wya1.iproperty.service.IFloorService;
import com.wya1.iproperty.service.IRoomService;
import com.wya1.iproperty.service.IUserInfService;

/**
 * 楼层控制类
 *
 * @author wya1
 * @since 2018-07-29
 */
@Controller
@RequestMapping("house/floor")
public class FloorController extends BaseController {

	@Autowired
	private IFloorService floorService;
	@Autowired
	private IUserInfService userInfService;
	@Autowired
	private IBuildingService buildingService;
	@Autowired
	private IRoomService roomService;

	@ModelAttribute
	public Floor get(@RequestParam(required = false) String id) {
		Floor entity = null;
		if (id != null && !id.equals("")) {
			entity = floorService.selectById(id);
		}
		if (entity == null) {
			entity = new Floor();
		}
		return entity;
	}

	@RequiresPermissions("house:floor:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model) {
		Page<Floor> page = floorService.selectPage(new Page<>());
		model.addAttribute("page", page);
		return "modules/house/floorList";
	}

	@RequiresPermissions("house:floor:view")
	@RequestMapping(value = "form")
	public String form(Floor floor, Model model) {
		model.addAttribute("floor", floor);
		return "modules/house/floorForm";
	}

	@RequiresPermissions("house:floor:view")
	@RequestMapping(value = "recordManagementArea/form")
	public String form2(Floor floor, Model model) {
		if (floor != null && floor.getUserId() != null) {
			UserInf userInf = userInfService.selectById(floor.getUserId());
			floor.setUserInf(userInf);
		}
		if (floor != null && floor.getBuildingId() != null) {
			Building building = buildingService.selectById(floor.getBuildingId());
			floor.setBuilding(building);
		}
		if (floor != null && floor.getId() != null) {
			floor.setRooms(roomService.selectRoomByFloorId(floor.getId()));
		}
		model.addAttribute("floor", floor);
		return "modules/house/recordManagementAreaAddBuildingAddFloorForm";
	}

	@RequiresPermissions("house:floor:edit")
	@RequestMapping(value = "save")
	public String save(Floor floor, Model model) {
		floorService.save(floor);
		return "redirect:/house/floor";
	}

	@RequiresPermissions("house:floor:edit")
	@RequestMapping(value = "recordManagementArea/save")
	public String save2(Floor floor, Model model) {
		floorService.save(floor);
		return "redirect:/house/building/recordManagementArea/form?id=" + floor.getBuildingId();
	}

	@ResponseBody
	@RequiresPermissions("house:floor:edit")
	@RequestMapping(value = "save2")
	public String save3(Floor floor, Model model) {
		floorService.save(floor);
		return floor.getId();
	}

	@RequiresPermissions("house:floor:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Floor floor) {
		floorService.deleteById(floor);
		return "";
	}
}