package com.wya1.iproperty.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 记录管理区
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */

public class RecordManagementArea extends BaseEntity<RecordManagementArea> {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户
	 */
	private String userId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 地址
	 */
	private String address;
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
	 * 大楼
	 */
	@TableField(exist = false)
	private List<Building> buildings;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

	@Override
	public String toString() {
		return "RecordManagementArea{" + ", userId=" + userId + ", name=" + name + ", address=" + address + ", remarks="
				+ remarks + "}";
	}
}