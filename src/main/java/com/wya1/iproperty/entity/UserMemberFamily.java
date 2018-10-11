package com.wya1.iproperty.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * <p>
 * 业主家庭成员
 * </p>
 *
 * @author wya1
 * @since 2018-09-06
 */
public class UserMemberFamily implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户1
	 */
	@TableId
	private String userIdA;
	/**
	 * 用户2
	 */
	private String userIdB;
	/**
	 * 关系
	 */
	private String relationship;

	/**
	 * 用户信息
	 */
	@TableField(exist = false)
	private UserInf userInf;

	public String getUserIdA() {
		return userIdA;
	}

	public void setUserIdA(String userIdA) {
		this.userIdA = userIdA;
	}

	public String getUserIdB() {
		return userIdB;
	}

	public void setUserIdB(String userIdB) {
		this.userIdB = userIdB;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public UserInf getUserInf() {
		return userInf;
	}

	public void setUserInf(UserInf userInf) {
		this.userInf = userInf;
	}

	@Override
	public String toString() {
		return "UserMemberFamily [userIdA=" + userIdA + ", userIdB=" + userIdB + ", relationship=" + relationship
				+ ", userInf=" + userInf + "]";
	}

	

	
}