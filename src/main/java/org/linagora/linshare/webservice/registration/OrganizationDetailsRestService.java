package org.linagora.linshare.webservice.registration;

import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationDetailsDto;

public interface OrganizationDetailsRestService {

	
	OrganizationDetailsDto create(OrganizationDetailsDto organizationdetailsDto) throws BusinessException;
	OrganizationDetailsDto find(String id) throws BusinessException;
	OrganizationDetailsDto update(OrganizationDetailsDto organizationdetailsDto) throws BusinessException;

	
}
