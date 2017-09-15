package org.linagora.linshare.core.repository.hibernate;

import java.util.Date;

import org.apache.commons.lang.Validate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.linagora.linshare.core.domain.entities.Organization;
import org.linagora.linshare.core.domain.entities.User1;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.User1Dto;
import org.linagora.linshare.core.repository.User1Repository;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class User1RepositoryImpl extends GenericUser1AccountRepositoryImpl<User1>
implements User1Repository{

	public User1RepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected DetachedCriteria getNaturalKeyCriteria(User1 entity) {
		// TODO Auto-generated method stub
		DetachedCriteria det = DetachedCriteria.forClass(User1.class).add(
				Restrictions.eq("organizationId", entity.getOrganizationId()));
		return det;
	}

	public void ValidateDetails(User1Dto entity) throws BusinessException {
		Validate.notEmpty(entity.getFirstName(), "Missing required field Name");
		Validate.notEmpty(entity.getMiddleName(), "Missing required field MiddleName in User");
		Validate.notEmpty(entity.getLastName(), "Missing required field Last Name");
		Validate.notEmpty(entity.getSalutation(), "Missing required field Saluatation");
		Validate.notEmpty(entity.getPhoneNumber(), "Missing required field Phonenumber");
		Validate.notEmpty(entity.getEmailId(), "Missing required field email id");
	} 
	
	
	public User1 Create(User1 entity) throws BusinessException {
		return super.create(entity);
	}
	
	public User1Dto CreateUser(User1Dto entity) throws BusinessException {
		System.out.println("Create User in User1RepositoryImpl");
		Date date = new Date();
		entity.setCreatedDate(date);
		entity.setModifiedDate(date);
		User1 ent = super.create(new User1(entity));
		return new User1Dto(ent);
	}
}
