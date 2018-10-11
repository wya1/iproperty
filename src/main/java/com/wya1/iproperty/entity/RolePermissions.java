package com.wya1.iproperty.entity;

import java.io.Serializable;

/**
 * <p>
 * 角色权限
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */

public class RolePermissions implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleId;
    private String permissionId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermissions{" +
        ", roleId=" + roleId +
        ", permissionId=" + permissionId +
        "}";
    }
}