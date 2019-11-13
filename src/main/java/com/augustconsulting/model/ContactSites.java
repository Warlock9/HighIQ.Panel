package com.augustconsulting.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_ContactSites")
public class ContactSites implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ContactCompanyNumber",length=200)
	private String contactCompanyNumber;

	@Id
	@Column(name = "SiteType",length=50)
	private String siteType;

	@Id
	@Column(name = "SiteUseID",length=15)
	private String siteUseId;

	@Column(name = "BillToSiteUseID",length=15)
	private String billToSiteUseId;

	@Column(name = "LocationID",length=20)
	private String locationId;

	@Column(name = "AddressLine1",length=200)
	private String addressLine1;

	@Column(name = "AddressLine2",length=200)
	private String addressLine2;

	@Column(name = "AddressLine3",length=200)
	private String addressLine3;

	@Column(name = "AddressLine4",length=200)
	private String addressLine4;
	
	@Column(name = "AddressCity",length=100)
	private String addressCity;
	
	@Column(name = "AddressState",length=100)
	private String addressState;
	
	@Column(name = "AddressPostalCode",length=20)
	private String addressPostalCode;
	
	@Column(name = "AddressCountry",length=60)
	private String addressCountry;
	
	@Column(name = "DefaultPaymentTerms",length=100)
	private String defaultPaymentTerms;
	
	@Column(name = "DefaultTransactionType",length=100)
	private String defaultTransactionType;
	
	@Column(name = "DefaultWareHouse",length=100)
	private String defaultWareHouse;
	
	@Column(name = "DefaultPriceList",length=100)
	private String defaultPriceList;
	
	@Column(name = "DefaultFOBPoint",length=100)
	private String defaultFOBPoint;
	
	@Column(name = "DefaultOrderLineType",length=100)
	private String defaultOrderLineType;
	
	@Column(name="OperatingUnitID" ,length=50)
	private String operatingUnit;

	public String getContactCompanyNumber() {
		return contactCompanyNumber;
	}

	public void setContactCompanyNumber(String contactCompanyNumber) {
		this.contactCompanyNumber = contactCompanyNumber;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getSiteUseId() {
		return siteUseId;
	}

	public void setSiteUseId(String siteUseId) {
		this.siteUseId = siteUseId;
	}

	public String getBillToSiteUseId() {
		return billToSiteUseId;
	}

	public void setBillToSiteUseId(String billToSiteUseId) {
		this.billToSiteUseId = billToSiteUseId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
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

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressPostalCode() {
		return addressPostalCode;
	}

	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public String getDefaultPaymentTerms() {
		return defaultPaymentTerms;
	}

	public void setDefaultPaymentTerms(String defaultPaymentTerms) {
		this.defaultPaymentTerms = defaultPaymentTerms;
	}

	public String getDefaultTransactionType() {
		return defaultTransactionType;
	}

	public void setDefaultTransactionType(String defaultTransactionType) {
		this.defaultTransactionType = defaultTransactionType;
	}

	public String getDefaultWareHouse() {
		return defaultWareHouse;
	}

	public void setDefaultWareHouse(String defaultWareHouse) {
		this.defaultWareHouse = defaultWareHouse;
	}

	public String getDefaultPriceList() {
		return defaultPriceList;
	}

	public void setDefaultPriceList(String defaultPriceList) {
		this.defaultPriceList = defaultPriceList;
	}

	public String getDefaultFOBPoint() {
		return defaultFOBPoint;
	}

	public void setDefaultFOBPoint(String defaultFOBPoint) {
		this.defaultFOBPoint = defaultFOBPoint;
	}

	public String getDefaultOrderLineType() {
		return defaultOrderLineType;
	}

	public void setDefaultOrderLineType(String defaultOrderLineType) {
		this.defaultOrderLineType = defaultOrderLineType;
	}

	public String getOperatingUnit() {
		return operatingUnit;
	}

	public void setOperatingUnit(String operatingUnit) {
		this.operatingUnit = operatingUnit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ContactSites [contactCompanyNumber=" + contactCompanyNumber + ", siteType=" + siteType + ", siteUseId="
				+ siteUseId + ", billToSiteUseId=" + billToSiteUseId + ", locationId=" + locationId + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3=" + addressLine3 + ", addressLine4="
				+ addressLine4 + ", addressCity=" + addressCity + ", addressState=" + addressState
				+ ", addressPostalCode=" + addressPostalCode + ", addressCountry=" + addressCountry
				+ ", defaultPaymentTerms=" + defaultPaymentTerms + ", defaultTransactionType=" + defaultTransactionType
				+ ", defaultWareHouse=" + defaultWareHouse + ", defaultPriceList=" + defaultPriceList
				+ ", defaultFOBPoint=" + defaultFOBPoint + ", defaultOrderLineType=" + defaultOrderLineType
				+ ", operatingUnit=" + operatingUnit + "]";
	}

	


	
	
	
}
