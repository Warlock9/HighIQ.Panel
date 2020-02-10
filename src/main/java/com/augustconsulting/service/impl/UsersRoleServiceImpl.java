package com.augustconsulting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.augustconsulting.dao.UsersRoleDao;
import com.augustconsulting.model.AccessList;
import com.augustconsulting.model.UsersRole;
import com.augustconsulting.service.UsersRoleService;

@Service
@Transactional("transactionManager")
public class UsersRoleServiceImpl implements UsersRoleService {

	
	@Autowired(required=true)
	private UsersRoleDao userRoledao;
	
	@Override
	public List<AccessList> fetchingAccessNameList() {
		
		return userRoledao.fetchingAccessNameList();
	}
	@Override
	public void insertingRoleDetailsToDb(UsersRole userRole) {
		
		userRoledao.insertingRoleDetailsToDb(userRole);
		
	}

	@Override
	public List<UsersRole> fetchingDistinctRole() {
		
		return userRoledao.fetchingDistinctRole();
	}

	@Override
	public List<UsersRole> fetchingSelectedRole(String selectedRole) {
		// TODO Auto-generated method stub
		return userRoledao.fetchingSelectedRole(selectedRole);
	}

	@Override
	public void deleteRoles(String role) {
		userRoledao.deleteRoles(role);
	}
	@Override
	public List<String> userRoleValidation() {
		// TODO Auto-generated method stub
		return userRoledao.userRoleValidation();
	}

	
}
