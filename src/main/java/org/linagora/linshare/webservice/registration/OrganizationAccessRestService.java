package org.linagora.linshare.webservice.registration;

import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationAccessDto;

public interface OrganizationAccessRestService {
		
	OrganizationAccessDto create(OrganizationAccessDto organizationaccessDto) throws BusinessException;
	OrganizationAccessDto find(String id) throws BusinessException;
	OrganizationAccessDto update(OrganizationAccessDto organizationaccessDto) throws BusinessException;

}
