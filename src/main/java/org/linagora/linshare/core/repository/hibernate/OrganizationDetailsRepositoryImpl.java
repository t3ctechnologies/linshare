package org.linagora.linshare.core.repository.hibernate;

import java.util.Date;

import org.apache.commons.lang.Validate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.linagora.linshare.core.domain.entities.OrganizationDetails;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationDetailsDto;
import org.linagora.linshare.core.repository.OrganizationDetailsRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;



public class OrganizationDetailsRepositoryImpl extends GenericOrganizationDetailsAccountRepositoryImpl<OrganizationDetails> implements OrganizationDetailsRepository {

	public OrganizationDetailsRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected DetachedCriteria getNaturalKeyCriteria(OrganizationDetails entity) {
		// TODO Auto-generated method stub
		DetachedCriteria det = DetachedCriteria.forClass(OrganizationDetails.class).add(
				Restrictions.eq("organizationId", entity.getOrganizationId()));
		return det;
	}

	@Override
	public OrganizationDetails create(OrganizationDetails entity) throws BusinessException {
//		entity.setCompanyName("asd");
		System.out.println("OrganizationAccessRepositoryImpl Create");
		Validate.notEmpty(entity.getAddressId(), "Missing required field AddressId");
		Validate.notEmpty(entity.getOrganizationId(), "Missing required field OrganizationId");
		Validate.notEmpty(entity.getNumberofEmployee(), "Missing required field NumberofEmployee");
		Validate.notEmpty(entity.getRole(), "Missing required field Role");
		
		return super.create(entity);
	}
	
	
//	@Override
	public OrganizationDetailsDto createLogic(OrganizationDetailsDto entity) throws BusinessException {
		System.out.println("OrganizationAccessRepositoryImpl Create");
		Validate.notEmpty(entity.getAddressId(), "Missing required field AddressId");
		Validate.notEmpty(entity.getOrganizationId(), "Missing required field OrganizationId");
		Validate.notEmpty(entity.getNumberofEmployee(), "Missing required field NumberofEmployee");
		Validate.notEmpty(entity.getRole(), "Missing required field Role");
		
		
		
		OrganizationDetails reg = new OrganizationDetails() ;
		Date date =new Date();
		reg.setNumberofEmployee(entity.getNumberofEmployee());
		reg.setAddressId(entity.getAddressId());
		reg.setModifiedDate(date);
		reg.setCreatedDate(date);
		reg.setOrganizationId(entity.getOrganizationId());	
		reg.setisActive(false);
		reg.setIsdemoCreated(true);
		reg.setRole("hjhjh");
		
		OrganizationDetails reg1 = super.create(reg);
		return new OrganizationDetailsDto(reg1);
	}
	
	public OrganizationDetails findById(String id) throws BusinessException {
		return super.findById(id);
	}
	
	public OrganizationDetailsDto update(OrganizationDetailsDto entity) throws BusinessException {
		Validate.notEmpty(entity.getId(), "Missing required field Id");

		OrganizationDetails regDb = super.findById(entity.getId());
		
		if(entity.getAddressId() != null) {
			regDb.setAddressId(entity.getAddressId());
		}
		
		if(entity.getOrganizationId() != null) {
			regDb.setOrganizationId(entity.getOrganizationId());
		}
		
		if(entity.getCreatedDate() != null) {
			regDb.setCreatedDate(entity.getCreatedDate());
		}
		if(entity.getNumberofEmployee()!= null) {
			regDb.setNumberofEmployee(entity.getNumberofEmployee());
		}
		
		Date date =new Date();
		regDb.setModifiedDate(date);

		OrganizationDetails reg1 = super.update(regDb);
		OrganizationDetailsDto rdto = new OrganizationDetailsDto(reg1);
//		rdto.setDetails(reg1.getName(), reg1.getId());
		return rdto;
	}
}
