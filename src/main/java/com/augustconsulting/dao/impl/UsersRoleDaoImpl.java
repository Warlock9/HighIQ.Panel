package com.augustconsulting.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.augustconsulting.dao.UsersRoleDao;
import com.augustconsulting.model.AccessList;
import com.augustconsulting.model.UsersRole;

@Repository
@Transactional("transactionManager")
public class UsersRoleDaoImpl implements UsersRoleDao {


	@Autowired(required = true)
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	@Override
	public List<AccessList> fetchingAccessNameList() {
		return (List<AccessList>) sessionFactory.getCurrentSession().createCriteria(AccessList.class).addOrder(Order.asc("accessId")).list();
	}

	@Override
	public void insertingRoleDetailsToDb(UsersRole userRole) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(userRole);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersRole> fetchingDistinctRole() {
		return sessionFactory.getCurrentSession().createCriteria(UsersRole.class)
				.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("role"), "role"))).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersRole> fetchingSelectedRole(String selectedRole) {
		List<UsersRole> uRoleList = new ArrayList<UsersRole>();
		List<AccessList> accessList= (List<AccessList>) sessionFactory.getCurrentSession().createCriteria(AccessList.class).addOrder(Order.asc("accessId")).list();
		for(AccessList al : accessList) {
			UsersRole userRole = (UsersRole)sessionFactory.getCurrentSession().createCriteria(UsersRole.class).add(Restrictions.eq("role", selectedRole)).add(Restrictions.eq("accessName", al.getAccessName())).uniqueResult();
			try {
				userRole.toString();
			}catch(NullPointerException ex) {
				userRole = new UsersRole(al.getAccessName(), "0", "0", "0", "0", "0", "None");
			}
			uRoleList.add(userRole);
		}
		return uRoleList;
	}

	@Override
	public void deleteRoles(String role) {
		String hql = "delete from UsersRole where role=:Role";
		sessionFactory.getCurrentSession().createQuery(hql).setString("Role", role).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> userRoleValidation() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(UsersRole.class).setProjection(Projections.distinct(Projections.property("role"))).list();
	}

}