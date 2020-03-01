
package com.augustconsulting.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.augustconsulting.dao.ManageContactsDao;
import com.augustconsulting.model.CustomerSites;
import com.augustconsulting.model.CustomerDetails;

@Repository("ManageContactsDAO")

@Transactional("transactionManager")
public class ManageContactsDaoImpl implements ManageContactsDao {

	@Autowired(required = true)

	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void updateManageContactHeader(CustomerDetails contacts) {
		// TODO Auto-generated method stub
		System.out.println(contacts.getCreatedDate());
		Session ss = sessionFactory.getCurrentSession();
		ss.saveOrUpdate(contacts);

	}

	@Override
	public CustomerDetails getAllcontactDetails(Integer contactId) {
		return sessionFactory.getCurrentSession().get(CustomerDetails.class, contactId);
	}

	@Override
	public void updateContactSites(CustomerSites contactSites) { //
		sessionFactory.getCurrentSession().saveOrUpdate(contactSites);
		Session ss = sessionFactory.getCurrentSession();
		ss.saveOrUpdate(contactSites);
		ss.flush();
		ss.clear();

	}

	@SuppressWarnings("unchecked")

	@Override
	public List<CustomerDetails> getAllcontactDetails() {
		return (List<CustomerDetails>) sessionFactory.getCurrentSession().createCriteria(CustomerDetails.class).list();
	}

	@SuppressWarnings("unchecked")

	@Override
	public List<CustomerSites> getSiteDetails(Integer clientId) {
		return sessionFactory.getCurrentSession().createCriteria(CustomerSites.class)
				.add(Restrictions.eq("clientId", clientId)).list();
	}

	@Override
	public void deleteContactSites(CustomerSites contactSites) {
		String hql = "delete from CustomerSites where clientSiteId=:clientSiteId and clientId=:clientId";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setLong("clientSiteId", contactSites.getClientSiteId());
		q.setInteger("clientId", contactSites.getClientId());

		q.executeUpdate();

	}

	@Override
	public void deleteCustomerDetails(CustomerDetails clientId) {
		Session ss = sessionFactory.getCurrentSession();
		String hql = "delete from CustomerDetails where clientId =:clientId";
		String hql1 = "delete from CustomerSites where clientId =:clientId";

		Query q = ss.createQuery(hql);
		Query q1 = ss.createQuery(hql1);

		q.setLong("clientId", clientId.getClientId());
		q1.setLong("clientId", clientId.getClientId());

		q.executeUpdate();
		q1.executeUpdate();

	}

	@Override
	public long getTotalRegisterCustomerCount() {
		return (long) sessionFactory.getCurrentSession().createCriteria(CustomerSites.class)
				.add(Restrictions.eq("status", 1)).setProjection(Projections.rowCount()).uniqueResult();

	}

}
