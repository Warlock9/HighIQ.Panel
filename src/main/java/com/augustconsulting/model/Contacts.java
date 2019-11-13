package com.augustconsulting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Contacts")
public class Contacts{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ClientID ")
	private Long clientId;
	
	@Column(name="ClientCompanyName" ,length=10)
	private String clientCompanyName;
	
	@Column(name="AddressLine1" ,length=255)
	private String addressLine1;
	
	@Column(name="AddressLine2" ,length=255)
	private String addressLine2;
	
	@Column(name="AddressLine3" ,length=255)
	private String addressLine3;
	
	@Column(name="AddressLine4" ,length=255)
	private String addressLine4;
	
	@Column(name="City" ,length=100)
	private String city;
	
	@Column(name="State" ,length=100)
	private String state;
	
	@Column(name="ZipCode" ,length=20)
	private String zipCode;
	
	@Column(name="Country" ,length=100)
	private String country;
	
	@Column(name="ContactPerson" ,length=25)
	private String contactPerson;
	
	@Column(name="ContactNumber" ,length=15)
	private String contactNumber;
	
	@Column(name="EmailID" ,length=30)
	private String emailID;
	
	@Column(name="CreatedDate" ,length=15)
	private String createdDate;
	
	@Column(name="UpdatedDate" ,length=15)
	private String updatedDate;
	
	@Column(name="Status" ,length=5)
	private String status;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientCompanyName() {
		return clientCompanyName;
	}

	public void setClientCompanyName(String clientCompanyName) {
		this.clientCompanyName = clientCompanyName;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
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
		return "Contacts [clientId=" + clientId + ", clientCompanyName=" + clientCompanyName + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3=" + addressLine3 + ", addressLine4="
				+ addressLine4 + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", country=" + country
				+ ", contactPerson=" + contactPerson + ", contactNumber=" + contactNumber + ", emailID=" + emailID
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", status=" + status + "]";
	}
	


	
}