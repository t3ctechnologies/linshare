package org.linagora.linshare.webservice.registration;

import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationRegisterDto;


public interface OrganizationRegisterRestService {

	OrganizationRegisterDto create(OrganizationRegisterDto organizationRegisterDto) throws BusinessException;
	String create1(OrganizationRegisterDto organizationRegisterDto) throws BusinessException;
	String create2(OrganizationRegisterDto organizationRegisterDto) throws BusinessException;
}
