package org.linagora.linshare.core.facade.webservice.delegation.impl;

import java.util.List;

import org.apache.commons.lang.Validate;
//import org.apache.jackrabbit.oak.spi.whiteboard.Registration;
import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationAccessDto;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationDto;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationRegisterDto;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
import org.linagora.linshare.core.facade.webservice.common.dto.User1Dto;
import org.linagora.linshare.core.facade.webservice.delegation.OrganizationRegisterFacade;
import org.linagora.linshare.core.repository.hibernate.AccountRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.ModulesRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.OrganizationAccessRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.OrganizationRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.RegistrationRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.User1RepositoryImpl;
import org.linagora.linshare.core.utils.HashUtils;
import org.linagora.linshare.core.domain.constants.AccountType;
import org.linagora.linshare.core.domain.constants.ContainerQuotaType;
import org.linagora.linshare.core.domain.entities.Account;
import org.linagora.linshare.core.domain.entities.Modules;

public class OrganizationRegisterFacadeImpl implements OrganizationRegisterFacade {
	
	RegistrationRepositoryImpl rri;
	OrganizationRepositoryImpl ori;
	ModulesRepositoryImpl mri;
	OrganizationAccessRepositoryImpl oari;
	User1RepositoryImpl uri;
	AccountRepositoryImpl ari;
	public OrganizationRegisterFacadeImpl(RegistrationRepositoryImpl rri, OrganizationRepositoryImpl ori,
			ModulesRepositoryImpl mri, OrganizationAccessRepositoryImpl oari, User1RepositoryImpl uri, AccountRepositoryImpl ari) {
		super();
		this.rri = rri;
		this.ori = ori;
		this.mri = mri;
		this.oari = oari;
		this.uri = uri;
		this.ari = ari;
	}
	
	
	public OrganizationRegisterDto CreateOrganizationWithUser(OrganizationRegisterDto entity) throws BusinessException {
		//1 - Validate start
		//1.1 - Check Is Registration Id 
		System.out.println("My CreateOrganizationWithUser..."+entity.getRegId());
		Validate.notEmpty(entity.getRegId(), "Missing required field Registration Id");
//		Registration reg = (Registration) rri.findById(entity.getRegId());
		Registration reg = rri.findById(entity.getRegId());
		//1.2 - Validate organizationDto
		ori.ValidateDetails(entity.getOrganizationDto());
		//1.3 - validate userDto
		uri.ValidateDetails(entity.getUser1Dto());
		//1.4 - validate registration is demo created or not, if created return already created
		System.out.println("registration isdemocreated "+reg.getIsDemoCreated());
		if(reg.getIsDemoCreated()) {
			OrganizationRegisterDto odto = new OrganizationRegisterDto();
			
			odto.setMessage("Demo for the organization already created");
			return odto;
		}
		//1.5 Validate the registrationId from the organization row
		if(ori.findByRegistrationId(reg.getId())) {
			OrganizationRegisterDto odto = new OrganizationRegisterDto();
			
			odto.setMessage("Demo for the organization already created1");
			return odto;
		}
		//Validation End
		
		
		
		
		
		//2 - Create Organization
		entity.getOrganizationDto().setRegistrationId(reg.getId());
		OrganizationDto org = this.ori.createLogic(entity.getOrganizationDto());
		//
		//3 - Create Organization Access (roles for organization)
		//3-1 - Get all modules
		List<Modules> modules = mri.findAll();
		//3-2 loop all modules and create organizationaccess with moduleid and registration id
		for(Modules mod : modules) {
			OrganizationAccessDto oadto = new OrganizationAccessDto(mod.getId(), org.getId(), "1", "1");
			OrganizationAccessDto oadto1 = oari.createLogic(oadto);
		}
		
		//4- create user
		entity.getUser1Dto().setOrganizationId(org.getId());
		System.out.println("organization id "+org.getId());
		User1Dto userdto = entity.getUser1Dto();
		userdto.setOrganizationId(org.getId());
		System.out.println("organization id1 "+userdto.getOrganizationId());
		User1Dto udto = uri.CreateUser(userdto);
		
		//Create actor as created user
//		HashUtils.hashSha1withBase64(newPassword.getBytes())
		Account account = new Account() {
			
			@Override
			public String getFullName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ContainerQuotaType getContainerQuotaType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public AccountType getAccountType() {
				// TODO Auto-generated method stub
				
				return AccountType.GUEST;
			}
			
			@Override
			public String getAccountRepresentation() {
				// TODO Auto-generated method stub
				return null;
			}
			
			
		};
		
		account.setPassword(HashUtils.hashSha1withBase64(udto.getPassword().getBytes()));
		account.setLsUuid(udto.getEmailId());
		account.setMail(udto.getEmailId());
//		account.
		//set created organization admin user
		entity.setUser1Dto(udto);;
		//set created organization
		entity.setOrganizationDto(org);
		return entity;
	}
	
	
}
