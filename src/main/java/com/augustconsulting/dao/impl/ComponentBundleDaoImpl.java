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
	public List<String> getComponent(String skuCode) {
		// TODO Auto-generated method stub
		return (List<String>) sessionFactory.getCurrentSession()
		.createCriteria(BundleComponentRelation.class).setProjection(Projections.property("ComponentSKUs")).add(Restrictions.eq("BundleSKU", skuCode)).list();
	}

	@Override
	public List<ComponentBundle> getComponentName(@SuppressWarnings("rawtypes") List li) {
		// TODO Auto-generated method stub
		System.out.println(li+" :::::::::");
		Session ss = sessionFactory.getCurrentSession();
		String hql = "from ComponentBundle c where c.skuCode in (:skuCode)";
		Query query1 = ss.createQuery(hql);
		query1.setParameterList("skuCode", li);
		@SuppressWarnings("unchecked")
		List<ComponentBundle> li1 = query1.list();
		return li1;
	}	

	

}
