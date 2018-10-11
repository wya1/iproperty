package com.wya1.iproperty.entity;

import com.wya1.iproperty.entity.BaseEntity;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author wya1
 * @since 2018-07-31
 */

public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 登录名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;
    /**
     * 锁
     */
    private Boolean locked;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "User{" +
        ", username=" + username +
        ", password=" + password +
        ", salt=" + salt +
        ", locked=" + locked +
        "}";
    }

	/**
	 * @return
	 */
	public String getCredentialsSalt() {
		return username + salt;
	}
}