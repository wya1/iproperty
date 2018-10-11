package com.wya1.iproperty.entity;

import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author wya1
 * @since 2018-07-22
 */

public class Permissions extends BaseEntity<Permissions> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限字符串
     */
    private String permission;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

    @Override
    public String toString() {
        return "Permissions{" +
        ", permission=" + permission +
        ", description=" + description +
        ", remarks=" + remarks +
        ", available=" + available +
        "}";
    }
}