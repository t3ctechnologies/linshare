package org.linagora.linshare.core.repository.hibernate;

import org.linagora.linshare.core.domain.entities.OrganizationDetails;
import org.linagora.linshare.core.repository.OrganizationDetailsAccountRepository;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class GenericOrganizationDetailsAccountRepositoryImpl <U extends OrganizationDetails> extends AbstractRepositoryImpl<U> implements OrganizationDetailsAccountRepository<U>  {

	public GenericOrganizationDetailsAccountRepositoryImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		// TODO Auto-generated constructor stub
	}
	public OrganizationDetails findById(String id) {
		return super.getHibernateTemplate().get(OrganizationDetails.class, id);
//		return super.findById(entity, id);
	}
      
}
