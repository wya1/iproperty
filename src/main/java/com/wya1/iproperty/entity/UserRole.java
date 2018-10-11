package com.wya1.iproperty.entity;

import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 用户角色
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */

public class UserRole extends BaseEntity<UserRole> {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}