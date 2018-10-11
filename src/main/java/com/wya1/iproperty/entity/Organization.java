package com.wya1.iproperty.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;

/**
 * <p>
 * 组织机构
 * </p>
 *
 * @author wya1
 * @since 2018-07-22
 */

public class Organization extends BaseTreeEntity<Organization> {

	private static final long serialVersionUID = 1L;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 备注
	 */
	private String remarks;

	@TableField(exist = false)
	private List<String> roleIds;

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

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	@Override
	public String toString() {
		return "Organization{" + " name=" + name + ", remarks=" + remarks + "}";
	}
}