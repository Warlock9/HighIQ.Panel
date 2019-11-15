package com.augustconsulting.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.augustconsulting.dao.ComponentBundleDao;
import com.augustconsulting.model.ComponentBundle;

@Repository
@Transactional
public class ComponentBundleDaoImpl implements ComponentBundleDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public void insertingDataToDb(ComponentBundle ds) {
		sessionFactory.getCurrentSession().save(ds);

	}

	@Override
	public void updateDataToDb(ComponentBundle ds) {
		sessionFactory.getCurrentSession().saveOrUpdate(ds);

	}

	@Override
	public void deleteFromDb(int dsName) {
		Session session = sessionFactory.getCurrentSession();
		Query q  = session.createQuery("DELETE FROM ComponentBundle WHERE id =:dsName");
		q.setInteger("dsName",dsName);
		//q.setInt("dsName",dsName);
		q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ComponentBundle> fetchingDataFromDb() {
		return (List<ComponentBundle>) sessionFactory.getCurrentSession()
				.createCriteria(ComponentBundle.class).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ComponentBundle> validatingDistributionSetName(String distributionName) {
		return sessionFactory.getCurrentSession().createCriteria(ComponentBundle.class).add(Restrictions.eq("distributionSetName", distributionName)).list();
	}

}
