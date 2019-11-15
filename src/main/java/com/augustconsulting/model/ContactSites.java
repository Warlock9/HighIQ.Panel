package com.augustconsulting.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_ContactSites")

public class ContactSites implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ClientSiteID")
	private Long clientSiteId;

	@Id
	@Column(name="ClientID")
	private Long clientId;
	
	
	@NotNull
	@Column(name = "SiteName", length = 100)
	private String siteName;

	
	@NotNull
	@Column(name = "AddressLine1", length = 255)
	private String addressLine1;

	
	@NotNull
	@Column(name = "AddressLine2", length = 255)
	private String addressLine2;

	@NotNull
	@Column(name = "AddressLine3", length = 255)
	private String addressLine3;

	
	@NotNull
	@Column(name = "AddressLine4", length = 255)
	private String addressLine4;

	@NotNull
	@Column(name = "City", length = 100)
	private String city;

	@NotNull
	@Column(name = "State", length = 100)
	private String state;

	@NotNull
	@Column(name = "ZipCode", length = 20)
	private String zipCode;

	@NotNull
	@Column(name = "Country", length = 100)
	private String country;

	
	@NotNull
	@Column(name = "ContactPerson", length = 25)
	private String contactPerson;

	@NotNull
	@Column(name = "ContactNumber", length = 15)
	private String contactNumber;

	@NotNull
	@Column(name = "EmailID", length = 30)
	private String emailID;

	@NotNull	
	@Column(name = "CreatedDate", length = 15)
	private Date createdDate;

	@NotNull
	@Column(name = "UpdatedDate", length = 15)
	private Date updatedDate;

	@NotNull
	@Column(name = "Status", length = 5)
	private String status;

	public Long getClientSiteId() {
		return clientSiteId;
	}

	public void setClientSiteId(Long clientSiteId) {
		this.clientSiteId = clientSiteId;
	}


	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return addressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ContactSites [clientSiteId=" + clientSiteId + ", clientId=" + clientId + ", siteName=" + siteName
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3=" + addressLine3
				+ ", addressLine4=" + addressLine4 + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", country=" + country + ", contactPerson=" + contactPerson + ", contactNumber=" + contactNumber
				+ ", emailID=" + emailID + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", status="
				+ status + "]";
	}
	
	

}
