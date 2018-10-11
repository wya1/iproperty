package com.wya1.iproperty.entity;

import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 记录管理区配置
 * </p>
 *
 * @author wya1
 * @since 2018-07-29
 */

public class RecordManagementAreaConfigure extends BaseEntity<RecordManagementAreaConfigure> {

    private static final long serialVersionUID = 1L;

    /**
     * 记录管理区
     */
    private String recordManagementAreaId;
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

    public String getRecordManagementAreaId() {
        return recordManagementAreaId;
    }

    public void setRecordManagementAreaId(String recordManagementAreaId) {
        this.recordManagementAreaId = recordManagementAreaId;
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
        return "RecordManagementAreaConfigure{" +
        ", recordManagementAreaId=" + recordManagementAreaId +
        ", name=" + name +
        ", number=" + number +
        ", remarks=" + remarks +
        "}";
    }
}