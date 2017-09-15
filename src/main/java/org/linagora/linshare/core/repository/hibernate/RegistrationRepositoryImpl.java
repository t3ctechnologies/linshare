package org.linagora.linshare.core.repository.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang3.BooleanUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.linagora.linshare.core.domain.entities.Account;
import org.linagora.linshare.core.domain.entities.DocumentEntry;
import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.domain.entities.Thread;
import org.linagora.linshare.core.domain.entities.User;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
import org.linagora.linshare.core.facade.webservice.user.dto.DocumentDto;
import org.linagora.linshare.core.repository.RegistrationRepository;
import org.linagora.linshare.mongo.entities.logs.AuditLogEntryUser;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;


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
	
	
//	@Override
	public RegistrationDto createLogic(RegistrationDto entity) throws BusinessException {
		System.out.println("RegistrationRepositoryImpl Create");
		Validate.notEmpty(entity.getName(), "Missing required field Name");
		Validate.notEmpty(entity.getPhoneNumber(), "Missing required field phoneNumber");
		Validate.notEmpty(entity.getEmailId(), "Missing required field emailId");
		Validate.notEmpty(entity.getCompanyName(), "Missing required field companyName");
		
		
                          		Registration reg = new Registration() ;
		Date date =new Date();
		reg.setCompanyName(entity.getCompanyName());
		reg.setCreatedDate(date);
		reg.setEmailId(entity.getEmailId());
		reg.setIsActive(false);
		reg.setIsDemoCreated(false);
		reg.setModifiedDate(date);
		reg.setName(entity.getName());
		reg.setPhoneNumber(entity.getPhoneNumber());
	
		
		Registration reg1 = super.create(reg);
		return new RegistrationDto(reg1);
	}
	
	public Registration findById(String id) throws BusinessException {
		return super.findById(id);
	}
	
	public RegistrationDto update(RegistrationDto entity) throws BusinessException {
		Validate.notEmpty(entity.getId(), "Missing required field Id");

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
		
		if (BooleanUtils.isTrue(entity.getisActive())) {
			regDb.setIsActive(entity.getisActive());
		}
		else {
			regDb.setIsActive(false);
		}
		
		Date date =new Date();
		regDb.setModifiedDate(date);

		Registration reg1 = super.update(regDb);
		RegistrationDto rdto = new RegistrationDto(reg1);
//		rdto.setDetails(reg1.getName(), reg1.getId());
		return rdto;
	}
	
	@Override
	public List<Registration> findAll() throws BusinessException{
		return super.findAll();
	}
	
	public List<RegistrationDto> findAllToDto() throws BusinessException {
		List<Registration> list = findAll();
		List<RegistrationDto> listDto = new ArrayList<RegistrationDto>();
		for(Registration reg : list) {
				//convert reg to registrationDto
				RegistrationDto regDto = new RegistrationDto(reg);
				listDto.add(regDto);
			}
		return listDto;
	}

	public boolean checkRegId(String id){
		RegistrationRepositoryImpl rri = null ;
		List reg= rri.findAll();
		
		return true;
	}
	
	public void approve(RegistrationDto entity) throws BusinessException {
		entity.setisActive(true);
		this.update(entity);
	}
}
