package org.linagora.linshare.core.repository.hibernate;

import org.linagora.linshare.core.domain.entities.Modules;

import org.linagora.linshare.core.repository.ModulesAccountRepository;

import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class GenericModulesAccountRepositoryImpl <U extends Modules> extends AbstractRepositoryImpl<U> implements ModulesAccountRepository<U> {
	
	public GenericModulesAccountRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}

	public Modules findById(String id) {
		return super.getHibernateTemplate().get(Modules.class, id);
//		return super.findById(entity, id);
	}
	
}




	
