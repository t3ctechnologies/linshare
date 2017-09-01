package org.linagora.linshare.webservice.registration;

import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.ModulesDto;

public interface ModulesRestService {
	ModulesDto create(ModulesDto modulesDto) throws BusinessException;
	ModulesDto find(String id) throws BusinessException;
	ModulesDto update(ModulesDto modulesDto) throws BusinessException;
}
