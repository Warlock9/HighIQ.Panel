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
import com.augustconsulting.dao.ComponentBundleDao;
import com.augustconsulting.model.BundleComponentRelation;
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
	public void deleteFromDb(String dsName) {
		Session session = sessionFactory.getCurrentSession();
		Query q  = session.createQuery("DELETE FROM ComponentBundle WHERE id =:dsName");
		q.setString("dsName",dsName);
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

	@Override
	public void insertDataToRelation(BundleComponentRelation rs) {
		sessionFactory.getCurrentSession().save(rs);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BundleComponentRelation> fetchingDataFromRelation() {
	
		return (List<BundleComponentRelation>) sessionFactory.getCurrentSession()
				.createCriteria(BundleComponentRelation.class).list();
	}

	@Override
	public void deleteFromRelationDb(String sku) {
		Session session = sessionFactory.getCurrentSession();
		Query q  = session.createQuery("DELETE FROM BundleComponentRelation WHERE BundleSKU  =:BundleSKU");
		q.setString("BundleSKU",sku);
		//q.setInt("dsName",dsName);
		q.executeUpdate();
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BundleComponentRelation> getComponent(String skuCode) {
		// TODO Auto-generated method stub
		return (List<BundleComponentRelation>) sessionFactory.getCurrentSession()
		.createCriteria(BundleComponentRelation.class).add(Restrictions.eq("BundleSKU", skuCode)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ComponentBundle> validatingSkuCode(String skuCode) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(ComponentBundle.class).add(Restrictions.eq("skuCode", skuCode)).list();
	}

	@Override
	public String getComponentBundleName(String skuCode) {
		// TODO Auto-generated method stub
		return (String)sessionFactory.getCurrentSession().createCriteria(ComponentBundle.class).setProjection(Projections.property("componentBundleName")).add(Restrictions.eq("skuCode", skuCode)).uniqueResult();
		
	}

	

	

}
