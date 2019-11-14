package com.augustconsulting.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
		System.out.println(contactSites);
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

}
