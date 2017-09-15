package org.linagora.linshare.core.facade.webservice.delegation.impl;

import java.util.List;

import org.apache.jackrabbit.oak.spi.whiteboard.Registration;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationAccessDto;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationDto;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationRegisterDto;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
import org.linagora.linshare.core.facade.webservice.common.dto.User1Dto;
import org.linagora.linshare.core.facade.webservice.delegation.OrganizationRegisterFacade;
import org.linagora.linshare.core.repository.hibernate.ModulesRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.OrganizationAccessRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.OrganizationRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.RegistrationRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.User1RepositoryImpl;
import org.linagora.linshare.core.domain.entities.Modules;

public class OrganizationRegisterFacadeImpl implements OrganizationRegisterFacade {
	
	RegistrationRepositoryImpl rri;
	OrganizationRepositoryImpl ori;
	ModulesRepositoryImpl mri;
	OrganizationAccessRepositoryImpl oari;
	User1RepositoryImpl uri;
	
	public OrganizationRegisterFacadeImpl(RegistrationRepositoryImpl rri, OrganizationRepositoryImpl ori,
			ModulesRepositoryImpl mri, OrganizationAccessRepositoryImpl oari, User1RepositoryImpl uri) {
		super();
		this.rri = rri;
		this.ori = ori;
		this.mri = mri;
		this.oari = oari;
		this.uri = uri;
	}
	
	
	public OrganizationRegisterDto CreateOrganizationWithUser(OrganizationRegisterDto entity) throws BusinessException {
		//1 - Validate start
		//1.1 - Check Is Registration Id 
		Registration reg = (Registration) rri.findById(entity.getRegId());
		
		//1.2 - Validate organizationDto
		ori.ValidateDetails(entity.getOrganizationdto());
		//1.3 - validate userDto
		uri.ValidateDetails(entity.getUser1dto());
		
		//Validation End
		//2 - Create Organization
		OrganizationDto org = this.ori.createLogic(entity.getOrganizationdto());
		//3 - Create Organization Access (roles for organization)
		//3-1 - Get all modules
		List<Modules> modules = mri.findAll();
		//3-2 loop all modules and create organizationaccess with moduleid and registration id
		for(Modules mod : modules) {
			OrganizationAccessDto oadto = new OrganizationAccessDto(mod.getId(), org.getId(), "1", "1");
			OrganizationAccessDto oadto1 = oari.createLogic(oadto);
		}
		
		//4- create user
		User1Dto udto = uri.CreateUser(entity.getUser1dto());
		
		//set created organization admin user
		entity.setUser1dto(udto);
		//set created organization
		entity.setOrganizationdto(org);
		return entity;
	}
	
	
}
