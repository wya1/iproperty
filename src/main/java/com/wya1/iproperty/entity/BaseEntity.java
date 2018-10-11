/**
 * 
 */
package com.wya1.iproperty.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 任远曼
 * @date 2018年7月8日
 */
public class BaseEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private String id;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 更新时间
	 */
	private Date gmtModified;
	/**
	 * 是否删除
	 */
	private Integer isDeleted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", isDeleted="
				+ isDeleted + "]";
	}

}
