package com.augustconsulting.service;

import java.util.List;

import com.augustconsulting.model.AccessList;
import com.augustconsulting.model.UsersRole;

public interface UsersRoleService {
	public List<AccessList> fetchingAccessNameList();
	
	public void insertingRoleDetailsToDb(UsersRole userRole);
	
	public List<UsersRole> fetchingDistinctRole();
	
	public List<UsersRole> fetchingSelectedRole(String selectedRole); 

	public void deleteRoles(String role);
	
	public List<String> userRoleValidation();
	
}
