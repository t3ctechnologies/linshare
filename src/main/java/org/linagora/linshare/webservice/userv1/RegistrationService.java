package org.linagora.linshare.webservice.userv1;

import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.WorkGroupDto;

public interface RegistrationService {
	WorkGroupDto create(WorkGroupDto thread) throws BusinessException;

}
