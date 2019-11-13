package com.augustconsulting.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
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

	// get all contact details
	@SuppressWarnings("unchecked")
	public List<Contacts> getAllcontactDetails() {
		return (List<Contacts>) sessionFactory.getCurrentSession().createCriteria(Contacts.class).list();
	}

	/*get contact type using contact ID*/
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getContactType(Long contactId) {
		// TODO Auto-generated method stub
		return (List<String>)sessionFactory.getCurrentSession().createCriteria(Contacts.class).add(Restrictions.eq("contactId", contactId)).setProjection(Projections.property("contactType")).list();
	}

	@Override
	public Contacts getAllcontactDetails(Long contactId) {
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().get(Contacts.class, contactId);
	}

	 /*Get site Details from companyContactNumber*/
	@SuppressWarnings("unchecked")
	@Override
	public List<ContactSites> getSiteDetails(String companyContactNumber) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(ContactSites.class).add(Restrictions.eq("contactCompanyNumber", companyContactNumber)).list();
	}

	/*update Header manageContacts*/
	@Override
	public void updateManageContactHeader(Contacts contacts) {
		// TODO Auto-generated method stub
		Session ss=sessionFactory.getCurrentSession();
		ss.saveOrUpdate(contacts);
	
		
	}

	@Override
	public void updateContactSites(ContactSites contactSites) {
		System.out.println(contactSites);
		// sessionFactory.getCurrentSession().saveOrUpdate(contactSites);
		 Session ss=sessionFactory.getCurrentSession();
		 ss.saveOrUpdate(contactSites);
		ss.flush();
		 ss.clear();
	}

	@Override
	public void updateContactSitesCustomer(ContactSites contactSites) {
		// TODO Auto-generated method stub
		Session ss = sessionFactory.getCurrentSession();
		ss.saveOrUpdate(contactSites);
		ss.flush();
		ss.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactSites> fetchDistinctBillToSiteId(String companyNumber) {
		Session ss = sessionFactory.getCurrentSession();
		System.out.println("<><><><><><><>><<><>><<>><><");
		return ss.createCriteria(ContactSites.class).setProjection(Projections.distinct(Projections.property("siteUseId"))).add(Restrictions.eq("contactCompanyNumber", companyNumber)).add(Restrictions.eq("siteType","BILL_TO")).list();	
	}

	@Override
	public void deleteContactSites(ContactSites contactSites) {
		String hql = "delete from ContactSites where contactCompanyNumber=:contactCompanyNumber and siteUseId=:siteUseId and siteType=:siteType";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString("contactCompanyNumber", contactSites.getContactCompanyNumber());
		q.setString("siteUseId", contactSites.getSiteUseId());
		q.setString("siteType", contactSites.getSiteType());
		q.executeUpdate();
		
	}

	@Override
	public void deleteContactSitesList(Contacts contact) {
		String hql = "delete from ContactSites where contactCompanyNumber=:contactCompanyNumber";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString("contactCompanyNumber", contact.getContactCompanyNumber());
		q.executeUpdate();
		String hql1 = "delete from Contacts where contactId=:contactId";
		Query q1 = sessionFactory.getCurrentSession().createQuery(hql1);
		q1.setLong("contactId", contact.getContactId());
		q1.executeUpdate();
		
	}

	@Override
	public void saveAllcontactsHeader(Contacts contacts) {
		
		Session ss = sessionFactory.getCurrentSession();
		if((ss.createCriteria(Contacts.class).add(Restrictions.eq("contactCompanyNumber", contacts.getContactCompanyNumber())).list().size()==0)) {
			ss.saveOrUpdate(contacts);
		};
		ss.flush();
		ss.clear();
		
	}

	@Override
	public void saveAllcontactSitesDetails(ContactSites contactSites) {
		Session ss = sessionFactory.getCurrentSession();
		ss.saveOrUpdate(contactSites);
		ss.flush();
		ss.clear();
		
	}

	


}
