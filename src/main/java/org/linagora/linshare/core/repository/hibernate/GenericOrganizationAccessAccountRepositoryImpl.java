package org.linagora.linshare.core.repository.hibernate;

import org.linagora.linshare.core.domain.entities.OrganizationAccess;
import org.linagora.linshare.core.repository.OrganizationAccessAccountRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class GenericOrganizationAccessAccountRepositoryImpl <U extends OrganizationAccess> extends AbstractRepositoryImpl<U> implements OrganizationAccessAccountRepository<U>  {

	public GenericOrganizationAccessAccountRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}
	public OrganizationAccess findById(String id) {
		return super.getHibernateTemplate().get(OrganizationAccess.class, id);
//		return super.findById(entity, id);
	}
      
}
