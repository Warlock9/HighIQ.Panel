package com.augustconsulting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

			
@Entity
@Table(name="tbl_RoleRights")
public class UsersRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	
	@Column(name="Role",length=50)
	private String role;
	
	@Column(name="AccessName",length=50)
	private String accessName;
	
	@Column(name="ViewAccess",length=1)
	private String viewAccess;
	
	@Column(name="CreateAccess",length=1)
	private String createAccess;
	
	@Column(name="EditAccess",length=1)
	private String editAccess;
	
	@Column(name="DeleteAccess",length=1)
	private String deleteAccess;
	
	/*
	 * @Column(name="ApproveAccess",length=1) private String approveAccess;
	 * 
	 * @Transient
	 * 
	 * @Column(name="specialAccess",length=25) private String specialAccess;
	 */
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	public String getViewAccess() {
		return viewAccess;
	}

	public void setViewAccess(String viewAccess) {
		this.viewAccess = viewAccess;
	}

	public String getCreateAccess() {
		return createAccess;
	}

	public void setCreateAccess(String createAccess) {
		this.createAccess = createAccess;
	}

	public String getEditAccess() {
		return editAccess;
	}

	public void setEditAccess(String editAccess) {
		this.editAccess = editAccess;
	}

	public String getDeleteAccess() {
		return deleteAccess;
	}

	public void setDeleteAccess(String deleteAccess) {
		this.deleteAccess = deleteAccess;
	}

	/*
	 * public String getApproveAccess() { return approveAccess; }
	 * 
	 * public void setApproveAccess(String approveAccess) { this.approveAccess =
	 * approveAccess; }
	 * 
	 * public String getSpecialAccess() { return specialAccess; }
	 * 
	 * public void setSpecialAccess(String specialAccess) { this.specialAccess =
	 * specialAccess; }
	 */
	
	
	
	public UsersRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersRole(String accessName, String viewAccess, String createAccess, String editAccess, String deleteAccess,
			String approveAccess, String specialAccess) {
		super();
		this.accessName = accessName;
		this.viewAccess = viewAccess;
		this.createAccess = createAccess;
		this.editAccess = editAccess;
		this.deleteAccess = deleteAccess;
		/*
		 * this.approveAccess = approveAccess; this.specialAccess = specialAccess;
		 */
	}

	@Override
	public String toString() {
		return "UsersRole [id=" + id + ", role=" + role + ", accessName=" + accessName + ", viewAccess=" + viewAccess
				+ ", createAccess=" + createAccess + ", editAccess=" + editAccess + ", deleteAccess=" + deleteAccess
				+ "]";
	}

	
	
}
