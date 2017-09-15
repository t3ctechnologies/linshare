package org.linagora.linshare.core.repository.hibernate;

import java.util.Date;

import org.apache.commons.lang.Validate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.linagora.linshare.core.domain.entities.OrganizationAccess;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationAccessDto;
import org.linagora.linshare.core.repository.OrganizationAccessRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class OrganizationAccessRepositoryImpl extends GenericOrganizationAccessAccountRepositoryImpl<OrganizationAccess> implements OrganizationAccessRepository {

	public OrganizationAccessRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected DetachedCriteria getNaturalKeyCriteria(OrganizationAccess entity) {
		// TODO Auto-generated method stub
		DetachedCriteria det = DetachedCriteria.forClass(OrganizationAccess.class).add(
				Restrictions.eq("organizationId", entity.getOrganizationId()));
		return det;
		
	}

	@Override
	public OrganizationAccess create(OrganizationAccess entity) throws BusinessException {
//		entity.setCompanyName("asd");
		System.out.println("OrganizationAccessRepositoryImpl Create");
		this.ValidateEntity(entity);
		
		return super.create(entity);
	}
	
	public void ValidateEntity(OrganizationAccess entity) throws BusinessException {
		Validate.notEmpty(entity.getModuleId(), "Missing required field ModuleId");
		Validate.notEmpty(entity.getOrganizationId(), "Missing required field OrganizationId");
		Validate.notEmpty(entity.getStatusId(), "Missing required field StatusId");
		Validate.notEmpty(entity.getSubscriptionId(), "Missing required field SubscriptionId");
		
	}
	
	
	public void ValidateDto(OrganizationAccessDto entity) throws BusinessException {
		entity.validateMe();

	}
	
	
//	@Override
	public OrganizationAccessDto createLogic(OrganizationAccessDto entity) throws BusinessException {
		System.out.println("OrganizationAccessRepositoryImpl Create");
		ValidateDto(entity);
		
		
        OrganizationAccess reg = new OrganizationAccess() ;
		Date date =new Date();
		reg.setModifiedDate(date);
		reg.setModuleId(entity.getModuleId());
		
		reg.setCreatedDate(date);
		reg.setOrganizationId(entity.getOrganizationId());
		
		reg.setStatusId(entity.getStatusId());
		reg.setSubscriptionId("1");
		
		
		OrganizationAccess reg1 = super.create(reg);
		return new OrganizationAccessDto(reg1);
	}
	
	public OrganizationAccess findById(String id) throws BusinessException {
		return super.findById(id);
	}
	
	public OrganizationAccessDto update(OrganizationAccessDto entity) throws BusinessException {
		Validate.notEmpty(entity.getId(), "Missing required field Id");

		OrganizationAccess regDb = super.findById(entity.getId());
		
		if(entity.getModuleId() != null) {
			regDb.setModuleId(entity.getModuleId());
		}
		
		if(entity.getOrganizationId() != null) {
			regDb.setOrganizationId(entity.getOrganizationId());
		}
		
		
//		if(entity.getUserId()!= null) {
//			regDb.setUserId(entity.getUserId());
//		}
		
		if(entity.getCreatedDate() != null) {
			regDb.setCreatedDate(entity.getCreatedDate());
		}
		if(entity.getSubscriptionId()!= null) {
			regDb.setSubscriptionId(entity.getSubscriptionId());
		}
		if(entity.getStatusId() != null) {
			regDb.setStatusId(entity.getStatusId());
		}
		Date date =new Date();
		regDb.setModifiedDate(date);

		OrganizationAccess reg1 = super.update(regDb);
		OrganizationAccessDto rdto = new OrganizationAccessDto(reg1);
//		rdto.setDetails(reg1.getName(), reg1.getId());
		return rdto;
	}

}
