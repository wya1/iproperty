/**
 * 
 */
package com.wya1.iproperty.service;

import com.baomidou.mybatisplus.service.IService;

/**
 * @author 任远曼
 * @date 2018年6月18日
 */
public interface IBaseService<T> extends IService<T>{
	boolean save(T entity);
}
