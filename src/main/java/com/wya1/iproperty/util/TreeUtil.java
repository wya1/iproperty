/**
 * 
 */
package com.wya1.iproperty.util;

import java.util.List;

import com.wya1.iproperty.entity.BaseTreeEntity;

/**
 * @author 任远曼
 * @date 2018年7月8日
 */
public class TreeUtil {
	public static <T extends BaseTreeEntity<T>> void sort(List<T> data, String parentId,List<T> sysodata) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getParentId().equals(parentId)) {
				sysodata.add(data.get(i));
				sort(data, data.get(i).getId(),sysodata);
			}
		}
	}
}
