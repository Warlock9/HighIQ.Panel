package com.augustconsulting.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.augustconsulting.dao.DwSalesDao;
import com.augustconsulting.model.ComponentBundle;
import com.augustconsulting.model.CustomerSites;
import com.augustconsulting.model.DWSales;

@Repository("DwSalesDao")
@Transactional
public class DwSalesDaoImpl implements DwSalesDao{

	
	@Autowired(required = true)
	private SessionFactory sessionFactory;
	
	@Override
	public void insertingDataToDb(DWSales dwSal) {
		// TODO Auto-generated method stub
	
			sessionFactory.getCurrentSession().save(dwSal);
		
		
	}

	@Override
	public void updateDataToDb(DWSales dwSal) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(dwSal);
		
	}

	@Override
	public void deleteFromDb(int salesId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q  = session.createQuery("DELETE FROM DWSales WHERE saleId =:salesId");
		q.setInteger("salesId",salesId);
		q.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DWSales> fetchingDataFromDb() {
		return (List<DWSales>) sessionFactory.getCurrentSession()
				.createCriteria(DWSales.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerSites> fetchingCLientSiteDetails() {
		// TODO Auto-generated method stub
		return (List<CustomerSites>) sessionFactory.getCurrentSession()
				.createCriteria(CustomerSites.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ComponentBundle> fetchingSKU() {
		// TODO Auto-generated method stub
		return (List<ComponentBundle>) sessionFactory.getCurrentSession()
				.createCriteria(ComponentBundle.class).list();
	}

	@Override
	public DWSales fetchingDataFromDb(Integer saleId) {
		// TODO Auto-generated method stub
		return (DWSales)sessionFactory.getCurrentSession().createCriteria(DWSales.class).add(Restrictions.eq("saleId", saleId)).uniqueResult();
	}


	
	

}
