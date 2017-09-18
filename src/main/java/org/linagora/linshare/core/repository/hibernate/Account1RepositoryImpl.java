package org.linagora.linshare.core.repository.hibernate;

import java.util.Date;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.linagora.linshare.core.domain.entities.Account;
import org.linagora.linshare.core.domain.entities.Account1;
import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.repository.Account1Repository;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class Account1RepositoryImpl extends GenericAccount1AccountRepositoryImpl<Account1> implements Account1Repository {

	public Account1RepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Account1 create(Account1 entity) throws BusinessException {
		System.out.println("ACcount is creating");
		entity.setCreationDate(new Date());
		entity.setModificationDate(new Date());
		entity.setLsUuid(UUID.randomUUID().toString());
		return super.create(entity);
	}

	@Override
	protected DetachedCriteria getNaturalKeyCriteria(Account1 entity) {
		// TODO Auto-generated method stub
		DetachedCriteria det = DetachedCriteria.forClass(Account1.class).add(
	    Restrictions.eq("mail", entity.getMail()));
		return det;
		
	}

}
