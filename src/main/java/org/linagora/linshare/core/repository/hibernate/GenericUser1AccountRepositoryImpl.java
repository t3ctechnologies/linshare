package org.linagora.linshare.core.repository.hibernate;

import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.domain.entities.User1;
import org.linagora.linshare.core.repository.RegistrationAccountRepository;
import org.linagora.linshare.core.repository.User1AccountRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class GenericUser1AccountRepositoryImpl<U extends User1> extends AbstractRepositoryImpl<U> implements User1AccountRepository<U>{

	public GenericUser1AccountRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}
	
	public User1 findById(String id) {
		return super.getHibernateTemplate().get(User1.class, id);
//		return super.findById(entity, id);
	}

}
