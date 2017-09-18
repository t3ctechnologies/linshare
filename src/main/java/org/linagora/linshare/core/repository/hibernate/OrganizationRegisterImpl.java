package org.linagora.linshare.core.repository.hibernate;

import java.util.Set;

import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.DomainDto;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationRegisterDto;

public class OrganizationRegisterImpl {

	
	
	
	public void passDto(OrganizationRegisterDto ord){
		
		String id = ord.getRegId();
		RegistrationRepositoryImpl rri=null;;
		rri.checkRegId(id);
		
	}
	
}
