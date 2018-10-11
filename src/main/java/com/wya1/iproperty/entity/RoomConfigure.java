package com.wya1.iproperty.entity;

import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 房间配置
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */

public class RoomConfigure extends BaseEntity<RoomConfigure> {

    private static final long serialVersionUID = 1L;

    /**
     * 房间
     */
    private String roomId;
    /**
     * 名称
     */
    private String name;
    private Integer number;
    /**
     * 备注
     */
    private String remarks;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
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
        return "RoomConfigure{" +
        ", roomId=" + roomId +
        ", name=" + name +
        ", number=" + number +
        ", remarks=" + remarks +
        "}";
    }
}