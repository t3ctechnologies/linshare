package org.linagora.linshare.core.repository.hibernate;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.linagora.linshare.core.domain.entities.Modules;
import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.ModulesDto;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
import org.linagora.linshare.core.repository.ModulesRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class ModulesRepositoryImpl  extends GenericModulesAccountRepositoryImpl<Modules>
implements ModulesRepository{

	public ModulesRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected DetachedCriteria getNaturalKeyCriteria(Modules entity) {
		// TODO Auto-generated method stub
		DetachedCriteria det = DetachedCriteria.forClass(Modules.class).add(
				Restrictions.eq("id", entity.getId()));
		return det;	
		}
	
	@Override
	public Modules create(Modules entity) throws BusinessException {
//		entity.setCompanyName("asd");
		System.out.println("RegistrationRepositoryImpl Create");
		Validate.notEmpty(entity.getName(), "Missing required field Name");
//		Validate.notEmpty(entity.getId(), "Missing required field phoneNumber");
		Validate.notEmpty(entity.getDescription(), "Missing required field emailId");
		
		
		return super.create(entity);
	}
	
	
	public ModulesDto createLogic(ModulesDto entity) throws BusinessException {
		System.out.println("ModulesRepositoryImpl Create");
		Validate.notEmpty(entity.getName(), "Missing required field Name");
		Validate.notEmpty(entity.getDescription(), "Missing required field Description");
		Validate.notEmpty(entity.getStatusId(), "Missing required field StatusID");
		
		System.out.println("Status id "+entity.getStatusId());
        Modules reg = new Modules() ;
		Date date =new Date();
//		reg.setId("010");
		reg.setName(entity.getName());
		reg.setDescription(entity.getDescription()); 
		reg.setStatusId(entity.getStatusId());
		reg.setCreateDate(date);
		reg.setModifiedDate(date);
		/*reg.setCompanyName(entity.getCompanyName());
		
		reg.setEmailId(entity.getEmailId());
		r eg.setIsActive(false);
		reg.setIsDemoCreated(true);
		reg.setModifiedDate(date);
		reg.setName(entity.getName());
		reg.setPhoneNumber(entity.getPhoneNumber());
		reg.setRole("hjhjh");*/
		System.out.println("Status idreg "+reg.getStatusId());
		Modules reg1 = super.create(reg);
		return new ModulesDto(reg1);
	}

	
	
	public Modules findById(String id) throws BusinessException {
		return super.findById(id);
	}
	

	public List<Modules> findAll() throws BusinessException {
		return super.findAll();
	}
	
	public ModulesDto update(ModulesDto reg) throws BusinessException {
		Validate.notEmpty(reg.getId(), "Missing required field Id"); {
		

			Modules regDb = super.findById(reg.getId());
			if(reg.getName() != null) {
				regDb.setName(reg.getName());
			}
			if(reg.getDescription() != null) {
				regDb.setDescription(reg.getDescription());
			}
			
			/*if(entity.getEmailId() != null) {
				regDb.setEmailId(entity.getEmailId());
			}
			if(entity.getCompanyName() != null) {
				regDb.setCompanyName(entity.getCompanyName());
			}*/
			
			Date date =new Date();
			regDb.setModifiedDate(date);

			Modules reg1 = super.update(regDb);
			ModulesDto rdto = new ModulesDto(reg1);
//			rdto.setDetails(reg1.getName(), reg1.getId());
			return rdto;
	}
}	
}