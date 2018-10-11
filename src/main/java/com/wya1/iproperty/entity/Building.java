package com.wya1.iproperty.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 大楼
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */

public class Building extends BaseEntity<Building> {

	private static final long serialVersionUID = 1L;

	/**
	 * 记录管理区id
	 */
	private String recordManagementAreaId;
	/**
	 * 用户id
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
	 * 记录管理区
	 */
	@TableField(exist = false)
	private RecordManagementArea recordManagementArea;

	/**
	 * 楼层
	 */
	@TableField(exist = false)
	private List<Floor> floors;

	public String getRecordManagementAreaId() {
		return recordManagementAreaId;
	}

	public void setRecordManagementAreaId(String recordManagementAreaId) {
		this.recordManagementAreaId = recordManagementAreaId;
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

	public RecordManagementArea getRecordManagementArea() {
		return recordManagementArea;
	}

	public void setRecordManagementArea(RecordManagementArea recordManagementArea) {
		this.recordManagementArea = recordManagementArea;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	@Override
	public String toString() {
		return "Building{" + ", recordManagementAreaId=" + recordManagementAreaId + ", userId=" + userId + ", name="
				+ name + ", address=" + address + ", remarks=" + remarks + "}";
	}
}