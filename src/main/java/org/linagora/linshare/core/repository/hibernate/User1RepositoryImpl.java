package org.linagora.linshare.core.repository.hibernate;

import java.util.Date;

import org.apache.commons.lang.Validate;
import org.hibernate.criterion.DetachedCriteria;
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
		return null;
	}

	public void ValidateDetails(User1Dto entity) throws BusinessException {
		Validate.notEmpty(entity.getFirstName(), "Missing required field Name");
		Validate.notEmpty(entity.getMiddleName(), "Missing required field companyName");
		Validate.notEmpty(entity.getLastName(), "Missing required field latitude");
		Validate.notEmpty(entity.getSalutation(), "Missing required field location");
		Validate.notEmpty(entity.getPhoneNumber(), "Missing required field longitude");
		Validate.notEmpty(entity.getEmailId(), "Missing required field role");
	}
	
	
	public User1 Create(User1 entity) throws BusinessException {
		return super.create(entity);
	}
	
	public User1Dto CreateUser(User1Dto entity) throws BusinessException {
		Date date = new Date();
		entity.setCreatedDate(date);
		entity.setModifiedDate(date);
		User1 ent = super.create(new User1(entity));
		return new User1Dto(ent);
	}
}
