package org.linagora.linshare.core.repository.hibernate;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.Validate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.linagora.linshare.core.domain.entities.Account;
import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.domain.entities.Thread;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
import org.linagora.linshare.core.repository.RegistrationRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class RegistrationRepositoryImpl extends GenericRegistrationAccountRepositoryImpl<Registration>
implements RegistrationRepository{

	public RegistrationRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected DetachedCriteria getNaturalKeyCriteria(Registration entity) {
		// TODO Auto-generated method stub
		DetachedCriteria det = DetachedCriteria.forClass(Registration.class).add(
				Restrictions.eq("phoneNumber", entity.getPhoneNumber()));
		return det;
		
	}
	
	@Override
	public Registration create(Registration entity) throws BusinessException {
//		entity.setCompanyName("asd");
		System.out.println("RegistrationRepositoryImpl Create");
		Validate.notEmpty(entity.getName(), "Missing required field Name");
		Validate.notEmpty(entity.getPhoneNumber(), "Missing required field phoneNumber");
		Validate.notEmpty(entity.getEmailId(), "Missing required field emailId");
		Validate.notEmpty(entity.getCompanyName(), "Missing required field companyName");
		
		return super.create(entity);
	}
	
	public Registration findById(String id) throws BusinessException {
		return super.findById(id);
	}
	
	public RegistrationDto update(RegistrationDto entity) throws BusinessException {
		Validate.notEmpty(entity.getId(), "Missing required field Id");
//		Validate.notEmpty(entity.getName(), "Missing required field Name");
//		Validate.notEmpty(entity.getPhoneNumber(), "Missing required field phoneNumber");
//		Validate.notEmpty(entity.getEmailId(), "Missing required field emailId");
//		Validate.notEmpty(entity.getCompanyName(), "Missing required field companyName");
		Registration regDb = super.findById(entity.getId());
		if(entity.getName() != null) {
			regDb.setName(entity.getName());
		}
		if(entity.getPhoneNumber() != null) {
			regDb.setPhoneNumber(entity.getPhoneNumber());
		}
		
		if(entity.getEmailId() != null) {
			regDb.setEmailId(entity.getEmailId());
		}
		if(entity.getCompanyName() != null) {
			regDb.setCompanyName(entity.getCompanyName());
		}
		
		Date date =new Date();
		regDb.setModifiedDate(date);
//		Registration reg = new Registration();
//		reg.setId(entity.getId());
//		reg.setName(entity.getName());
//		reg.setCompanyName(entity.getCompanyName());
//		reg.setEmailId(entity.getEmailId());
//		reg.setPhoneNumber(entity.getPhoneNumber());
		Registration reg1 = super.update(regDb);
		RegistrationDto rdto = new RegistrationDto();
		rdto.setDetails(reg1.getName(), reg1.getId());
		return rdto;
	}

}
