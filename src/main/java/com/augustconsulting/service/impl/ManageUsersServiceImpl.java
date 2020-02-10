package com.augustconsulting.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.augustconsulting.dao.ManageUsersDao;
import com.augustconsulting.model.ManageUsers;
import com.augustconsulting.service.ManageUsersService;

@Service
@Transactional("transactionManager")
public class ManageUsersServiceImpl implements ManageUsersService {

	@Autowired(required = true)
	private ManageUsersDao manageUsersDao;
	
	@Override
	public void insertingUserDetailtoDb(ManageUsers mu) {
		manageUsersDao.insertingUserDetailtoDb(mu);
	}

	@Override
	public void updateUserDetails(ManageUsers mu) {
		manageUsersDao.updateUserDetails(mu);
	}

	@Override
	public void deleteUserDetailsFromDb(String id) {
			manageUsersDao.deleteUserDetailsFromDb(id);
	}

	@Override
	public List<ManageUsers> fetchingUsersDetails() {
		
		return manageUsersDao.fetchingUsersDetails();
	}

	@Override
	public List<ManageUsers> userLoginAttempt(ManageUsers mu) {
		return manageUsersDao.userLoginAttempt(mu);
	}

	@Override
	public List<ManageUsers> validatingUserAndEmail(String userName, String userEmail) {
		return manageUsersDao.validatingUserAndEmail(userName, userEmail);
	}

	@Override
	public List<ManageUsers> validatingEmail(String userName, String userEmail) {
		// TODO Auto-generated method stub
		return manageUsersDao.validatingEmail(userName, userEmail);
	}

	@Override
	public List<ManageUsers> validatingOnlyUserName(String userName) {
		
		return manageUsersDao.validatingOnlyUserName(userName);
	}


}
