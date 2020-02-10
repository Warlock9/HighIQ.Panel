package com.augustconsulting.service;


import java.util.List;

import com.augustconsulting.model.ManageUsers;

public interface ManageUsersService {
	
	public void insertingUserDetailtoDb(ManageUsers mu);

	public void updateUserDetails(ManageUsers mu);
	
	public void deleteUserDetailsFromDb(String id);
	
	public List<ManageUsers> fetchingUsersDetails();
	
	public List<ManageUsers> userLoginAttempt(ManageUsers mu);
	
	List<ManageUsers> validatingUserAndEmail(String userName, String userEmail);
	
	List<ManageUsers> validatingEmail(String userName, String userEmail);
	
	public List<ManageUsers> validatingOnlyUserName(String userName);
}
