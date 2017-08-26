package org.linagora.linshare.core.facade.webservice.registration;

import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
import org.linagora.linshare.core.facade.webservice.user.GenericFacade;

public interface RegistrationFacade extends GenericFacade  {

	
	
		RegistrationDto create(RegistrationDto registerDto) throws BusinessException;
}
