package com.wya1.iproperty.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 合同
 * </p>
 *
 * @author wya1
 * @since 2018-10-08
 */
public class Contract extends BaseEntity<Contract> {

    private static final long serialVersionUID = 1L;

    /**
     * 合同类型
     */
    private String contractTypeId;
    /**
     * 名称
     */
    private String name;
    /**
     * 内容
     */
    private String content;
    /**
     * 电子合同图片
     */
    private String electronicContractPictures;
    /**
     * 甲方
     */
    private String firstParty;
    /**
     * 乙方
     */
    private String secondParty;
    /**
     * 签订日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date signingDate;
    /**
     * 生效日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date effectiveDate;
    /**
     * 失效日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expiredDate;
    /**
     * 提醒提前到期天数
     */
    private Integer remindingAheadDay;
    /**
     * 备注
     */
    private String remarks;

    public String getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(String contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getElectronicContractPictures() {
        return electronicContractPictures;
    }

    public void setElectronicContractPictures(String electronicContractPictures) {
        this.electronicContractPictures = electronicContractPictures;
    }

    public String getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(String firstParty) {
        this.firstParty = firstParty;
    }

    public String getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(String secondParty) {
        this.secondParty = secondParty;
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getRemindingAheadDay() {
        return remindingAheadDay;
    }

    public void setRemindingAheadDay(Integer remindingAheadDay) {
        this.remindingAheadDay = remindingAheadDay;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Contract{" +
        ", contractTypeId=" + contractTypeId +
        ", name=" + name +
        ", content=" + content +
        ", electronicContractPictures=" + electronicContractPictures +
        ", firstParty=" + firstParty +
        ", secondParty=" + secondParty +
        ", signingDate=" + signingDate +
        ", effectiveDate=" + effectiveDate +
        ", expiredDate=" + expiredDate +
        ", remindingAheadDay=" + remindingAheadDay +
        ", remarks=" + remarks +
        "}";
    }
}