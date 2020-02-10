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

import com.augustconsulting.dao.ManageUsersDao;
import com.augustconsulting.model.ManageUsers;


@Repository

@Transactional("transactionManager")

public class ManageUserDaoImpl implements ManageUsersDao{

	@Autowired(required = true)
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void insertingUserDetailtoDb(ManageUsers mu) {
		sessionFactory.getCurrentSession().save(mu);
	}

	@Override
	public void updateUserDetails(ManageUsers mu) {
		try {
			Session ss = sessionFactory.getCurrentSession();
			ManageUsers manageUsers = (ManageUsers) ss.get(ManageUsers.class, mu.getUserName());
			manageUsers.setUserName(mu.getUserName());
			manageUsers.setPassword(mu.getPassword());
			manageUsers.setUserEmailId(mu.getUserEmailId());
			manageUsers.setUserFirstName(mu.getUserFirstName());
			manageUsers.setUserLastName(mu.getUserLastName());
			
			manageUsers.setRole(mu.getRole());
			/*
			 * System.out.println(mu.getWindowsAuthentication()+"<<<<<<<<<<<<<<<");
			 * manageUsers.setWindowsAuthentication(mu.getWindowsAuthentication());
			 */
			ss.update(manageUsers);
		} catch (NullPointerException e) {
			
		}
	}

	@Override
	public void deleteUserDetailsFromDb(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query q  = session.createQuery("DELETE FROM ManageUsers WHERE userName =:UserName");
		q.setString("UserName",id);
		q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManageUsers> fetchingUsersDetails() {
		
		return (List<ManageUsers>) sessionFactory.getCurrentSession().createCriteria(ManageUsers.class).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManageUsers> userLoginAttempt(ManageUsers mu) {
		return sessionFactory.getCurrentSession().createCriteria(ManageUsers.class).add(Restrictions.eq("userName",mu.getUserName())).add(Restrictions.eq("password",mu.getPassword())).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManageUsers> validatingUserAndEmail(String userName, String userEmail) {
		return (List<ManageUsers>)sessionFactory.getCurrentSession().createCriteria(ManageUsers.class).add(Restrictions.disjunction().add(Restrictions.eq("userName", userName)).add(Restrictions.eq("userEmailId",userEmail))).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManageUsers> validatingEmail(String userName, String userEmail) {
		return (List<ManageUsers>)sessionFactory.getCurrentSession().createCriteria(ManageUsers.class).add(Restrictions.eq("userEmailId",userEmail)).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ManageUsers> validatingOnlyUserName(String userName) {
		return sessionFactory.getCurrentSession().createCriteria(ManageUsers.class).add(Restrictions.eq("userName",userName)).list();
	}
	
}
