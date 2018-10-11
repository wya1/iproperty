package com.wya1.iproperty.entity;

import java.io.Serializable;

/**
 * <p>
 * 组织机构角色
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */

public class OrganizationRole implements Serializable{

    private static final long serialVersionUID = 1L;

    private String organizationId;
    private String roleId;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "OrganizationRole{" +
        ", organizationId=" + organizationId +
        ", roleId=" + roleId +
        "}";
    }
}