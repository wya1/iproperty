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
import com.wya1.iproperty.entity.Floor;
import com.wya1.iproperty.entity.Room;
import com.wya1.iproperty.entity.UserInf;
import com.wya1.iproperty.service.IBuildingService;
import com.wya1.iproperty.service.IFloorService;
import com.wya1.iproperty.service.IRoomService;
import com.wya1.iproperty.service.IUserInfService;

/**
 * 房间控制类
 *
 * @author wya1
 * @since 2018-07-29
 */
@Controller
@RequestMapping("house/room")
public class RoomController extends BaseController {
    
    @Autowired
    public IRoomService roomService;
    @Autowired
    public IUserInfService userInfService;
    @Autowired
    public IFloorService floorService;
    @Autowired
    public IBuildingService buildingService;
    
    @ModelAttribute
	public Room get(@RequestParam(required = false) String id) {
		Room entity = null;
		if (id != null && !id.equals("")) {
			entity = roomService.selectById(id);
		}
		if (entity == null) {
			entity = new Room();
		}
		return entity;
	}
    
    @RequiresPermissions("house:room:view")
	@RequestMapping(value = { "list", "" })
	public String list(Model model) {
		Page<Room> page = roomService.selectPage(new Page<>());
		model.addAttribute("page", page);
		return "modules/house/roomList";
	}

	@RequiresPermissions("house:room:view")
	@RequestMapping(value = "form")
	public String form(Room room, Model model) {
		model.addAttribute("room", room);
		return "modules/house/roomForm";
	}
	
	@RequiresPermissions("house:room:view")
	@RequestMapping(value = "recordManagementArea/form")
	public String form2(Room room, Model model) {
		model.addAttribute("room", room);
		if (room != null && room.getUserId() != null) {
			UserInf userInf = userInfService.selectById(room.getUserId());
			room.setUserInf(userInf);
		}
		if (room != null && room.getFloorId() != null) {
			Floor floor = floorService.selectById(room.getFloorId());
			if(floor!=null&&floor.getBuildingId()!=null) {
				floor.setBuilding(buildingService.selectById(floor.getBuildingId()));
			}
			room.setFloor(floor);
			
		}
		return "modules/house/recordManagementAreaAddBuildingAddFloorAddRoomForm";
	}

	@RequiresPermissions("house:room:edit")
	@RequestMapping(value = "save")
	public String save(Room room, Model model) {
		roomService.save(room);
		return "redirect:/house/room";
	}
	
	@RequiresPermissions("house:room:edit")
	@RequestMapping(value = "recordManagementArea/save")
	public String save2(Room room, Model model) {
		roomService.save(room);
		return "redirect:/house/floor/recordManagementArea/form?id="+room.getFloorId();
	}

	@RequiresPermissions("house:room:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Room room) {
		roomService.deleteById(room);
		return "";
	}
}