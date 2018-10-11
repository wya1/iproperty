package com.wya1.iproperty.entity;

import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 用户组织机构
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */

public class UserOrganization extends BaseEntity<UserOrganization> {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String organizationId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        return "UserOrganization{" +
        ", userId=" + userId +
        ", organizationId=" + organizationId +
        "}";
    }
}