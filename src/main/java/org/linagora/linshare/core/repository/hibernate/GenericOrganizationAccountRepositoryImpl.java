package org.linagora.linshare.core.repository.hibernate;

import org.linagora.linshare.core.domain.entities.Organization;
import org.linagora.linshare.core.repository.OrganizationAccountRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class GenericOrganizationAccountRepositoryImpl <U extends Organization> extends AbstractRepositoryImpl<U> implements OrganizationAccountRepository<U> {

	public GenericOrganizationAccountRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}
	
	public Organization findById(String id) {
		return super.getHibernateTemplate().get(Organization.class, id);
//		return super.findById(entity, id);
	}
      
}
