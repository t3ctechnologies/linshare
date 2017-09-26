package org.linagora.linshare.core.facade.webservice.delegation.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.linagora.linshare.core.domain.constants.AccountType;
import org.linagora.linshare.core.domain.constants.ContainerQuotaType;
import org.linagora.linshare.core.domain.constants.LinShareConstants;
import org.linagora.linshare.core.domain.entities.AbstractDomain;
import org.linagora.linshare.core.domain.entities.Account;
import org.linagora.linshare.core.domain.entities.Account1;
import org.linagora.linshare.core.domain.entities.ContainerQuota;
import org.linagora.linshare.core.domain.entities.DomainQuota;
import org.linagora.linshare.core.domain.entities.Internal;
import org.linagora.linshare.core.domain.entities.Modules;
import org.linagora.linshare.core.domain.entities.Quota;
//import org.apache.jackrabbit.oak.spi.whiteboard.Registration;
import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.domain.entities.Root;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationAccessDto;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationDto;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationRegisterDto;
import org.linagora.linshare.core.facade.webservice.common.dto.User1Dto;
import org.linagora.linshare.core.repository.AbstractDomainRepository;
import org.linagora.linshare.core.repository.AccountRepository;
import org.linagora.linshare.core.repository.hibernate.AbstractDomainRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.Account1RepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.AccountQuotaRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.AccountRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.ContainerQuotaRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.DomainQuotaRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.ModulesRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.OrganizationAccessRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.OrganizationRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.RegistrationRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.User1RepositoryImpl;
import org.linagora.linshare.core.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class OrganizationRegisterFacadeImpl {
	
	RegistrationRepositoryImpl rri;
	OrganizationRepositoryImpl ori;
	ModulesRepositoryImpl mri;
	OrganizationAccessRepositoryImpl oari;
	User1RepositoryImpl uri;
	AccountRepositoryImpl ari;
	Account1RepositoryImpl a1ri;
//	private AbstractDomainRepository adRepo;

	AbstractDomainRepositoryImpl abstractDRi;
	AccountQuotaRepositoryImpl accountQuotaRepositoryImpl;
	DomainQuotaRepositoryImpl domainQuotaRepositoryImpl;
	ContainerQuotaRepositoryImpl containerQuotaRepositoryImpl;
	
	//todo
	// default import.sql
		private static final String DOMAIN_IDENTIFIER = LinShareConstants.rootDomainIdentifier;

	    private static final String FIRST_NAME = "first name";
	    private static final String LAST_NAME = "last name";
	    private static final String MAIL = "mail";
	    private static final String UID = "uid";
	     
	     
		@Autowired
		@Qualifier("accountRepository")
		private AccountRepository<Account> accountRepository;
		
		@Autowired
		private AbstractDomainRepository abstractDomainRepository;
	
	public OrganizationRegisterFacadeImpl() {
		
	}


	public OrganizationRegisterFacadeImpl(RegistrationRepositoryImpl rri, OrganizationRepositoryImpl ori,
			ModulesRepositoryImpl mri, OrganizationAccessRepositoryImpl oari, User1RepositoryImpl uri, AccountRepositoryImpl ari,Account1RepositoryImpl a1ri,
			AbstractDomainRepositoryImpl abDRi,
			AccountQuotaRepositoryImpl aqri, DomainQuotaRepositoryImpl dqri, ContainerQuotaRepositoryImpl cqri
			) {
		super();
		this.rri = rri;
		this.ori = ori;
		this.mri = mri;
		this.oari = oari;
		this.uri = uri;
		this.ari = ari;
		this.a1ri = a1ri;
//		this.adRepo = adRepo;
		this.abstractDRi = abDRi;
		this.accountQuotaRepositoryImpl = aqri;
		this.domainQuotaRepositoryImpl = dqri;
		this.containerQuotaRepositoryImpl = cqri;
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
	
	public void createUserActor(OrganizationRegisterDto entity) throws BusinessException {
		System.out.println("CreateuserActor");
		
		Account account = new Account() {
			
			@Override
			public String getFullName() {
				// TODO Auto-generated method stub
				return entity.getUser1Dto().getFirstName();
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
		System.out.println("gafur check1 "+entity.getUser1Dto().getEmailId());
		account.setPassword(HashUtils.hashSha1withBase64(entity.getUser1Dto().getPassword().getBytes()));
		account.setLsUuid(entity.getUser1Dto().getEmailId());
		account.setMail(entity.getUser1Dto().getEmailId());
		System.out.println("Account is "+account);
		System.out.println("Entity is "+entity);
		System.out.println("Account mail is "+account.getMail());
		System.out.println("Account password is "+account.getPassword());
		Account account1 = ari.create(account);
	}

	public void createUserActor1(OrganizationRegisterDto entity) throws BusinessException {
		 Date date = new Date();
		 System.out.println("CreateUserActor1......");
		Account1 account = new Account1();
		 System.out.println("gafur check1 "+entity.getUser1Dto().getEmailId());
			account.setPassword(HashUtils.hashSha1withBase64(entity.getUser1Dto().getPassword().getBytes()));
			account.setLsUuid(entity.getUser1Dto().getEmailId());
			account.setMail(entity.getUser1Dto().getEmailId());
			account.setDomain(1);
			
			
			
//			DomainDto dDto = new DomainDto();
//			dDto.setIdentifier("1");
//			dDto.setType("0");
//			
//			DomainType domainType = DomainType.valueOf(dDto.getType());
//			AbstractDomain parent = abstractDomainService.retrieveDomain(domainDto
//					.getParent());
//			AbstractDomain domain = domainType.getDomain(dDto, parent);
//			
//			
//			account.setDomain(domain);
			
			
			
			account.setCreationDate(date);
			account.setModificationDate(date);
			account.setLocale("en");
			account.setExternalMailLocale("en");
			account.setEnable(true);
			account.setAccount_type(6);
			account.setDestroyed(0);
			account.setPurgeStep("In USE");
			account.setCmisLocale("en");
//			account.setOwner(0);
			System.out.println("Account is "+account);
			System.out.println("Entity is "+entity);
			System.out.println("Account mail is "+account.getMail());
			System.out.println("Account password is "+account.getPassword());
			Account1 account1 = a1ri.create(account);
		 
//		  User user = new User("", "", true, false, false, false);
	   	}

	public void createUserActor2(OrganizationRegisterDto entity) throws BusinessException {
			System.out.println("My abdul check 1 "+entity.getRegId());
			AbstractDomain domain = abstractDRi.findById(DOMAIN_IDENTIFIER);
			System.out.println("domain "+domain);
			System.out.println("Domain id "+domain.getPersistenceId());
			Internal u =  new Internal(entity.getUser1Dto().getFirstName(), entity.getUser1Dto().getLastName(), entity.getUser1Dto().getEmailId(), UID);
//			Root u =  new Root(entity.getUser1Dto().getFirstName(), entity.getUser1Dto().getLastName(), entity.getUser1Dto().getEmailId(), UID);
			u.setLocale(domain.getDefaultTapestryLocale());
			u.setCmisLocale(domain.getDefaultTapestryLocale().toString());
			u.setDomain(domain);
			u.setPassword(HashUtils.hashSha1withBase64(entity.getUser1Dto().getPassword().getBytes()));
//			String MyPassword = HashUtils.hashSha1withBase64(entity.getUser1Dto().getPassword().getBytes());
//			System.out.println("My password = "+MyPassword);
			Account acct = ari.create(u);
//			Account acct=null;
			System.out.println("acct "+acct);
			///todo
		
			AbstractDomain domain2 = acct.getDomain();
			System.out.println("My Check domain2 "+domain2);
		
			AbstractDomain domain1 = domain2.getParentDomain();
			
			if (domain1 == null) {
				//domain2 =domain1;
				domain1 = domain2;
			}
//			System.out.println("My check domain1 "+domain1);
//			Quota result = accountQuotaRepositoryImpl.find(acct);
//			System.out.println("result is "+result);
			DomainQuota domain2Quota = domainQuotaRepositoryImpl.find1(domain2);
			System.out.println("domain2Quota "+domain2Quota);
			System.out.println("ContainerQuotaType.work_group is "+ContainerQuotaType.WORK_GROUP);
			ContainerQuota entity1 = new ContainerQuota(domain2, domain1, domain2Quota, 100, 90, 10, 40, 20, ContainerQuotaType.WORK_GROUP);
			System.out.println("entity1 is "+entity1);
//			entity1.getAccount().setId(acct.getId());
		    entity1.setAccount(u);
			
			
			containerQuotaRepositoryImpl.create(entity1);
			
	}
	
	
	
}
