package com.augustconsulting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_UserMaster",uniqueConstraints = {
	@UniqueConstraint(name = "uk_userMailId", columnNames = { "UserEmailId" }) })

public class ManageUsers {
	
	@Id
	@Column(name = "UserName",length=20)
	private String userName;
	
	@Column(name = "Password",length=20)
	private String password;
	
	@Column(name = "UserEmailId",length=200,unique = true)
	private String userEmailId;
	
	@Column(name = "UserFirstName",length=100)
	private String userFirstName;
	
	@Column(name = "UserLastName",length=100)
	private String userLastName;
	
	@Column(name = "AssignedBotId",length=20)
	private String assignedBotId;
	
	@Column(name="Role",length=50)
	private String role;

	@Column(name="UseWindowsAuthentication",length=1)
	private String windowsAuthentication;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getAssignedBotId() {
		return assignedBotId;
	}

	public void setAssignedBotId(String assignedBotId) {
		this.assignedBotId = assignedBotId;
	}
	
	
	public String getWindowsAuthentication() {
		return windowsAuthentication;
	}

	public void setWindowsAuthentication(String windowsAuthentication) {
		this.windowsAuthentication = windowsAuthentication;
	}

	public ManageUsers() {
		
	}
	
	public ManageUsers(String uEmail, String uPass) {
		this.userEmailId = uEmail;
		this.password = uPass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
