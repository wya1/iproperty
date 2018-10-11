/**
 * 
 */
package com.wya1.iproperty.entity;

import java.math.BigDecimal;

/**
 * @author 任远曼
 * @date 2018年7月8日
 */
public class BaseTreeEntity<T> extends BaseEntity<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 父级编号
	 */
	private String parentId;
	/**
	 * 所有父级编号
	 */
	private String parentIds;
	/**
	 * 排序
	 */
	private BigDecimal sort;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public BigDecimal getSort() {
		return sort;
	}

	public void setSort(BigDecimal sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "BaseTreeEntity [parentId=" + parentId + ", parentIds=" + parentIds + ", sort=" + sort + "]"+super.toString();
	}
	
	

}
