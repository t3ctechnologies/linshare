package org.linagora.linshare.core.repository.hibernate;

import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationRegisterDto;

public class OrganizationRegisterImpl {

	public void passDto(OrganizationRegisterDto ord){
		
		String id = ord.getRegId();
		RegistrationRepositoryImpl rri=null;;
		rri.checkRegId(id);
		
	}
}
