package org.linagora.linshare.webservice.registration;

import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationDto;

public interface OrganizationRestService {
	
	OrganizationDto create(OrganizationDto organizationDto) throws BusinessException;
	OrganizationDto find(String id) throws BusinessException;
	OrganizationDto update(OrganizationDto organizationDto) throws BusinessException;

}
