package com.augustconsulting.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.augustconsulting.dao.ManageContactsDao;
import com.augustconsulting.model.ContactSites;
import com.augustconsulting.model.Contacts;

@Repository("ManageContactsDAO")

@Transactional("transactionManager")
public class ManageContactsDaoImpl implements ManageContactsDao {

	@Autowired(required = true)
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

		/* update Header manageContacts */
	@Override
	public void updateManageContactHeader(Contacts contacts) {
		// TODO Auto-generated method stub
		System.out.println(contacts.getCreatedDate());
		Session ss = sessionFactory.getCurrentSession();
		ss.saveOrUpdate(contacts);

	}
	
	@Override
	public Contacts getAllcontactDetails(Long contactId) {
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().get(Contacts.class, contactId);
	}

	@Override
	public void updateContactSites(ContactSites contactSites) {
			// sessionFactory.getCurrentSession().saveOrUpdate(contactSites);
			Session ss = sessionFactory.getCurrentSession();
			ss.saveOrUpdate(contactSites);
			ss.flush();
			ss.clear();
		
	}
		

	@SuppressWarnings("unchecked")
	@Override
	public List<Contacts> getAllcontactDetails() {
		// TODO Auto-generated method stub
		 	return (List<Contacts>) sessionFactory.getCurrentSession().createCriteria(Contacts.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactSites> getSiteDetails(long clientId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(ContactSites.class).add(Restrictions.eq("clientId", clientId)).list();
	}

	@Override
	public void deleteContactSites(ContactSites contactSites) {
		String hql = "delete from ContactSites where clientSiteId=:clientSiteId and clientId=:clientId";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setLong("clientSiteId", contactSites.getClientSiteId());
		q.setLong("clientId", contactSites.getClientId());
		
		q.executeUpdate();
		
	}

}
