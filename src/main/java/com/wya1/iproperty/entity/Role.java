package com.wya1.iproperty.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author wya1
 * @since 2018-07-22
 */

public class Role extends BaseEntity<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名
     */
    private String role;
    /**
     * 描述
     */
    private String description;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 是否可用
     */
    private Boolean available;
    
    @TableField(exist = false)
	private List<String> permissionIds;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

	public List<String> getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(List<String> permissionIds) {
		this.permissionIds = permissionIds;
	}

	@Override
    public String toString() {
        return "Role{" +
        ", role=" + role +
        ", description=" + description +
        ", remarks=" + remarks +
        ", available=" + available +
        "}";
    }
}