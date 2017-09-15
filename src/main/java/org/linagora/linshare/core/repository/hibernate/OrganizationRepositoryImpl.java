package org.linagora.linshare.core.repository.hibernate;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.linagora.linshare.core.domain.entities.Organization;
import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationDto;
import org.linagora.linshare.core.repository.OrganizationRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class OrganizationRepositoryImpl extends GenericOrganizationAccountRepositoryImpl<Organization> implements OrganizationRepository {

	public OrganizationRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected DetachedCriteria getNaturalKeyCriteria(Organization entity) {
		// TODO Auto-generated method stub
		DetachedCriteria det = DetachedCriteria.forClass(Organization.class).add(
				Restrictions.eq("name", entity.getName()));
		return det;
	}
	
	@Override
	public Organization create(Organization entity) throws BusinessException {
//		entity.setCompanyName("asd");
		System.out.println("OrganizationRepositoryImpl Create");
		Validate.notEmpty(entity.getName(), "Missing required field Name");
		Validate.notEmpty(entity.getLatitude(), "Missing required field latitude");
		Validate.notEmpty(entity.getLocation(), "Missing required field location");
		Validate.notEmpty(entity.getLongitude(), "Missing required field longitude");
//		Validate.notEmpty(entity.getRole(), "Missing required field role");
		
		
		return super.create(entity);
	}
	
	
//	@Override
	public OrganizationDto createLogic(OrganizationDto entity) throws BusinessException {
		System.out.println("OrganizationRepositoryImpl Create");
		ValidateDetails(entity);
		
  		Organization reg = new Organization() ;
		Date date =new Date();
		reg.setLongitude(entity.getLongitude());
		reg.setCompanyName(entity.getCompanyName());
		reg.setCreatedDate(date);
		reg.setLocation(entity.getLocation());
		reg.setisActive(false);
		reg.setIsdemoCreated(true);
		reg.setModifiedDate(date);
		reg.setName(entity.getName());
		reg.setLatitude(entity.getLatitude());
		reg.setRegistrationId(entity.getRegistrationId());
		Organization reg1 = super.create(reg);
		return new OrganizationDto(reg1);
	}
	
	public Organization findById(String id) throws BusinessException {
		return super.findById(id);
	}
	
	public Boolean findByRegistrationId(String id) throws BusinessException {
		
		DetachedCriteria det = DetachedCriteria.forClass(Organization.class).add(
				Restrictions.eq("registrationId", id));
		List<Registration> regList = (List<Registration>) super.getHibernateTemplate().findByCriteria(det);
		System.out.println("findbyRegistrationId "+regList.size());
		if (regList.size() > 0) {
			return true;
		}
		return false;
	}
	
	public OrganizationDto update(OrganizationDto entity) throws BusinessException {
		Validate.notEmpty(entity.getId(), "Missing required field Id");

		Organization regDb = super.findById(entity.getId());
		if(entity.getName() != null) {
			regDb.setName(entity.getName());
		}
		
		if(entity.getCompanyName() != null) {
			regDb.setCompanyName(entity.getCompanyName());
		}
		
		if(entity.getCreatedDate() != null) {
			regDb.setCreatedDate(entity.getCreatedDate());
		}
		if(entity.getLocation() != null) {
			regDb.setLocation(entity.getLocation());
		}
		if(entity.getLatitude() != null) {
			regDb.setLatitude(entity.getLatitude());
		}
		if(entity.getLongitude() != null) {
			regDb.setLongitude(entity.getLongitude());
		}
		Date date =new Date();
		regDb.setModifiedDate(date);

		Organization reg1 = super.update(regDb);
		OrganizationDto rdto = new OrganizationDto(reg1);
//		rdto.setDetails(reg1.getName(), reg1.getId());
		return rdto;
	}
	
	//common
	public void ValidateDetails(OrganizationDto entity) throws BusinessException {
		Validate.notEmpty(entity.getName(), "Missing required field Name");
		Validate.notEmpty(entity.getCompanyName(), "Missing required field companyName of Organization");
		Validate.notEmpty(entity.getLatitude(), "Missing required field latitude");
		Validate.notEmpty(entity.getLocation(), "Missing required field location");
		Validate.notEmpty(entity.getLongitude(), "Missing required field longitude");
//		Validate.notEmpty(entity.getRole(), "Missing required field role");
	}

}