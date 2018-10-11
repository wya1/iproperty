package com.wya1.iproperty.entity;

import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 合同类型
 * </p>
 *
 * @author wya1
 * @since 2018-09-29
 */
public class ContractType extends BaseEntity<ContractType> {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String name;
    /**
     * 模板
     */
    private String template;
    /**
     * 备注
     */
    private String remarks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "ContractType{" +
        ", name=" + name +
        ", template=" + template +
        ", remarks=" + remarks +
        "}";
    }
}