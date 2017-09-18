package org.linagora.linshare.core.repository.hibernate;



import org.linagora.linshare.core.domain.entities.Account1;
import org.linagora.linshare.core.repository.Account1AccountRepository;
import org.linagora.linshare.core.repository.RegistrationAccountRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class GenericAccount1AccountRepositoryImpl<U extends Account1> extends AbstractRepositoryImpl<U> implements Account1AccountRepository<U> {

	public GenericAccount1AccountRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}

}
