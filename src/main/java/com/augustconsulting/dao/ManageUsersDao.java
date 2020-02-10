package com.augustconsulting.dao;


import java.util.List;

import com.augustconsulting.model.ManageUsers;

public interface ManageUsersDao {
	
	public void insertingUserDetailtoDb(ManageUsers mu);

	public void updateUserDetails(ManageUsers mu);
	
	public void deleteUserDetailsFromDb(String id);
	
	public List<ManageUsers> fetchingUsersDetails();
	
	public List<ManageUsers> userLoginAttempt(ManageUsers mu);

	public List<ManageUsers> validatingUserAndEmail(String userName, String userEmail);
	
	public List<ManageUsers> validatingEmail(String userName, String userEmail);
	
	public List<ManageUsers> validatingOnlyUserName(String userName);
}
