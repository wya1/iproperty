package com.wya1.iproperty.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 车辆信息
 * </p>
 *
 * @author wya1
 * @since 2018-08-13
 */
public class UserCar extends BaseEntity<UserCar> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户
     */
    private String userId;
    /**
     * 名称
     */
    private String name;
    /**
     * 车牌号
     */
    private String plateNumber;
    /**
     * 图片
     */
    private String picture;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 用户
     */
    @TableField(exist = false)
    private UserInf userInf;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    
    public UserInf getUserInf() {
		return userInf;
	}

	public void setUserInf(UserInf userInf) {
		this.userInf = userInf;
	}

	@Override
	public String toString() {
		return "UserCar [userId=" + userId + ", name=" + name + ", plateNumber=" + plateNumber + ", picture=" + picture
				+ ", remarks=" + remarks + ", userInf=" + userInf + "]"+super.toString();
	}
}