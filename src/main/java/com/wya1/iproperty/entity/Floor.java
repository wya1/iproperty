package com.wya1.iproperty.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 楼层
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */

public class Floor extends BaseEntity<Floor> {

	private static final long serialVersionUID = 1L;

	/**
	 * 大楼
	 */
	private String buildingId;
	/**
	 * 用户
	 */
	private String userId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 用户信息
	 */
	@TableField(exist = false)
	private UserInf userInf;
	/**
	 * 大楼
	 */
	@TableField(exist = false)
	private Building building;
	/**
	 * 房间
	 */
	@TableField(exist = false)
	private List<Room> rooms;

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public UserInf getUserInf() {
		return userInf;
	}

	public void setUserInf(UserInf userInf) {
		this.userInf = userInf;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Floor{" + ", buildingId=" + buildingId + ", userId=" + userId + ", name=" + name + ", remarks="
				+ remarks + "}";
	}
}