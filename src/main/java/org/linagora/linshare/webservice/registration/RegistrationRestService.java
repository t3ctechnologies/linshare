package org.linagora.linshare.webservice.registration;

import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;

public interface RegistrationRestService {

	
	RegistrationDto create(RegistrationDto registrationDto) throws BusinessException;
	RegistrationDto find(String id) throws BusinessException;
	RegistrationDto update(RegistrationDto registrationDto) throws BusinessException;
}
