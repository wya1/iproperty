package com.wya1.iproperty.entity;

import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 大楼配置
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */

public class BuildingConfigure extends BaseEntity<BuildingConfigure> {

    private static final long serialVersionUID = 1L;

    /**
     * 大楼
     */
    private String buildingId;
    /**
     * 名称
     */
    private String name;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 备注
     */
    private String remarks;

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "BuildingConfigure{" +
        ", buildingId=" + buildingId +
        ", name=" + name +
        ", number=" + number +
        ", remarks=" + remarks +
        "}";
    }
}