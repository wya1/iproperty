package com.wya1.iproperty.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 房间
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */

public class Room extends BaseEntity<Room> {

	private static final long serialVersionUID = 1L;

	/**
	 * 楼层
	 */
	private String floorId;
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
	 * 用户
	 */
	@TableField(exist = false)
	private UserInf userInf;
	/**
	 * 楼层
	 */
	@TableField(exist = false)
	private Floor floor;

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
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

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "Room{" + ", floorId=" + floorId + ", userId=" + userId + ", name=" + name + ", remarks=" + remarks
				+ "}";
	}
}