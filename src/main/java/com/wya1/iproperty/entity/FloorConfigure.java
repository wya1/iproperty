package com.wya1.iproperty.entity;

import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 楼层配置
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */

public class FloorConfigure extends BaseEntity<FloorConfigure> {

    private static final long serialVersionUID = 1L;

    /**
     * 楼层
     */
    private String floorId;
    /**
     * 名称
     */
    private String name;
    private Integer number;
    /**
     * 备注
     */
    private String remarks;

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
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
        return "FloorConfigure{" +
        ", floorId=" + floorId +
        ", name=" + name +
        ", number=" + number +
        ", remarks=" + remarks +
        "}";
    }
}