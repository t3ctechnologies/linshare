package org.linagora.linshare.core.repository.hibernate;

import java.lang.reflect.ParameterizedType;

import org.linagora.linshare.core.exception.BusinessErrorCode;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.repository.AbstractRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class AbstractRegistrationImpl<T> implements AbstractRegistration<T> {

	
	 Logger logger = LoggerFactory.getLogger(this.getClass());

	    /** Type of the persistence class. */
	    private final Class<T> persistentClass;

	    /** Hibernate template. */
	    private final HibernateTemplate hibernateTemplate;
	    
	    @SuppressWarnings("unchecked")
		public AbstractRegistrationImpl(HibernateTemplate hibernateTemplate) {
	        this.hibernateTemplate = hibernateTemplate;
	        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
	                .getActualTypeArguments()[0];
	    }
	    
	    public T create(T entity) throws BusinessException {
	        if (entity == null) {
	            throw new IllegalArgumentException("Entity must not be null");
	        }
	        logger.debug("entity created:"+entity);
	        // perform unicity check:
	        

	        hibernateTemplate.save(entity);
	        return entity;
	    }

	    
}
