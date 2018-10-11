package com.wya1.iproperty.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author wya1
 * @since 2018-08-13
 */
public class UserInf extends BaseEntity<UserInf> {

	private static final long serialVersionUID = 1L;

	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 身份证
	 */
	private String idCard;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 图片
	 */
	private String picture;
	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * 车辆
	 */
	@TableField(exist = false)
	private List<UserCar> userCars;

	/**
	 * 宠物
	 */
	@TableField(exist = false)
	private List<UserPet> userPets;
	
	/**
	 * 家庭成员
	 */
	@TableField(exist = false)
	private List<UserMemberFamily> userMemberFamilies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public List<UserCar> getUserCars() {
		return userCars;
	}

	public void setUserCars(List<UserCar> userCars) {
		this.userCars = userCars;
	}

	public List<UserPet> getUserPets() {
		return userPets;
	}

	public void setUserPets(List<UserPet> userPets) {
		this.userPets = userPets;
	}

	
	public List<UserMemberFamily> getUserMemberFamilies() {
		return userMemberFamilies;
	}

	public void setUserMemberFamilies(List<UserMemberFamily> userMemberFamilies) {
		this.userMemberFamilies = userMemberFamilies;
	}

	@Override
	public String toString() {
		return "UserInf{" + ", name=" + name + ", idCard=" + idCard + ", tel=" + tel + ", picture=" + picture
				+ ", remarks=" + remarks + "}"+super.toString();
	}
}