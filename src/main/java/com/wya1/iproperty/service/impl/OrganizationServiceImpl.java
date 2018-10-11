package com.wya1.iproperty.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wya1.iproperty.entity.Organization;
import com.wya1.iproperty.mapper.OrganizationMapper;
import com.wya1.iproperty.service.IOrganizationService;
import com.wya1.iproperty.service.impl.BaseServiceImpl;
import com.wya1.iproperty.util.TreeUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 组织机构 服务实现类
 * </p>
 *
 * @author wya1
 * @since 2018-07-21
 */
@Transactional(readOnly=true)
@Service
public class OrganizationServiceImpl extends BaseServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {

	/* (non-Javadoc)
	 * @see com.wya1.iproperty.service.IOrganizationService#save(com.wya1.iproperty.entity.Organization)
	 */
	@Transactional(readOnly=false)
	@Override
	public boolean save(Organization organization) {
		if (StringUtils.isEmpty(organization.getId())) {
			organization.setGmtCreate(new Date());
		}
		organization.setGmtModified(new Date());
		
		String oldParentIds="0,";
		
		if(!StringUtils.isEmpty(organization.getId())) {
			Organization oldOrganization=selectById(organization.getId());
			if(oldOrganization!=null&&!StringUtils.isEmpty(oldOrganization.getParentIds())) {
				oldParentIds=oldOrganization.getParentIds();
			}
		}
		
		if (StringUtils.isEmpty(organization.getParentId())) {
			organization.setParentId("0");
			organization.setParentIds("0,");
		}else {
			Organization parentOrganization=selectById(organization.getParentId());
			if (parentOrganization != null) {
				organization
						.setParentIds(parentOrganization.getParentIds() + organization.getParentId() + ",");
			}
		}
		//新增不修改父类的ParentIds
		if(organization.getId().equals("")) {
			return insertOrUpdate(organization);
		}
		
		EntityWrapper<Organization> wrapper = new EntityWrapper<>();
		// FIXME:organization.getId()可能为""
		wrapper.like("parent_ids", organization.getId());
		List<Organization> list = selectList(wrapper);
		for (Organization oOrganization : list) {
			oOrganization.setParentIds(oOrganization.getParentIds().replace(oldParentIds, organization.getParentIds()));
			insertOrUpdate(oOrganization);
		}
		return insertOrUpdate(organization);
	}

	/* (non-Javadoc)
	 * @see com.wya1.iproperty.service.IOrganizationService#selectPage()
	 */
	@Override
	public Page<Organization> selectPage() {
		EntityWrapper<Organization> wrapper=new EntityWrapper<>();
		//wrapper.orderBy("concat(parent_ids, id)");
		wrapper.orderBy("sort");
		Page<Organization> page = selectPage(new Page<>(),wrapper);
		List<Organization> list=new ArrayList<>();
		TreeUtil.sort(page.getRecords(), "0",list);
		page.setRecords(list);
		return page;
	}

}
