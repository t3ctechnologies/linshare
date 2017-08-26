package org.linagora.linshare.core.repository;

import org.linagora.linshare.core.exception.BusinessException;

public interface AbstractRegistration<T> {
	
	 T create(T entity) throws BusinessException, IllegalArgumentException;

}
