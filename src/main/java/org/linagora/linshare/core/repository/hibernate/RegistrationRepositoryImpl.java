package org.linagora.linshare.core.repository.hibernate;

import java.util.Date;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.domain.entities.Thread;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.repository.RegistrationRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class RegistrationRepositoryImpl extends GenericRegistrationAccountRepositoryImpl<Registration>
implements RegistrationRepository{

	public RegistrationRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected DetachedCriteria getNaturalKeyCriteria(Registration entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Registration create(Registration entity) throws BusinessException {
		entity.setCompanyName("asd");
		return super.create(entity);
	}

}
