package org.linagora.linshare.core.repository.hibernate;

import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.repository.AccountRepository;
import org.linagora.linshare.core.repository.RegistrationAccountRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class GenericRegistrationAccountRepositoryImpl<U extends Registration> extends AbstractRepositoryImpl<U> implements RegistrationAccountRepository<U> {

	public GenericRegistrationAccountRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}

	public Registration findById(String id) {
		return super.getHibernateTemplate().get(Registration.class, id);
//		return super.findById(entity, id);
	}
}
