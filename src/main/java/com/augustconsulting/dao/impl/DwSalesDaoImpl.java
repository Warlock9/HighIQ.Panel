package com.augustconsulting.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class DwSalesDaoImpl implements DwSalesDao {

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
		Query q = session.createQuery("DELETE FROM DWSales WHERE saleId =:salesId");
		q.setInteger("salesId", salesId);
		q.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DWSales> fetchingDataFromDb() {
		return (List<DWSales>) sessionFactory.getCurrentSession().createCriteria(DWSales.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerSites> fetchingCLientSiteDetails() {
		// TODO Auto-generated method stub
		return (List<CustomerSites>) sessionFactory.getCurrentSession().createCriteria(CustomerSites.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ComponentBundle> fetchingSKU() {
		return (List<ComponentBundle>) sessionFactory.getCurrentSession().createCriteria(ComponentBundle.class).list();
	}

	@Override
	public DWSales fetchingDataFromDb(Integer saleId) {
		return (DWSales) sessionFactory.getCurrentSession().createCriteria(DWSales.class)
				.add(Restrictions.eq("saleId", saleId)).uniqueResult();
	}

	@Override
	public CustomerSites fetchingClientSiteEmailID(Integer clientSiteId) {
		return (CustomerSites) sessionFactory.getCurrentSession().createCriteria(CustomerSites.class)
				.add(Restrictions.eq("clientSiteId", clientSiteId)).uniqueResult();

	}

	@Override
	public DWSales fetchingDataByLicenseKey(String key) {
		return (DWSales) sessionFactory.getCurrentSession().createCriteria(DWSales.class)
				.add(Restrictions.eq("licenseKey", key)).uniqueResult();
	}

	@Override
	public long getActiveLicences() {
		
		return (long)sessionFactory.getCurrentSession().createCriteria(DWSales.class).
				add(Restrictions.eq("licenseStatus", "Pending")).
				add(Restrictions.eq("licenseStatus", "Active")).
				add(Restrictions.eq("licenseStatus", "Generated")).setProjection(Projections.rowCount()).uniqueResult();
	}

}
