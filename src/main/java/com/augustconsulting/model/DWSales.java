
package com.augustconsulting.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity

@Table(name = "tbl_DWSales")
public class DWSales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SaleID",length = 11)
	private int saleId;

    @NotNull
    @Column(name="ClientSiteID",length = 5)
	private String clientSiteId;

    @NotNull
    @Column(name="SKU",length = 5)
	private String sku;

    @NotNull
    @Column(name="NumberOfRunners",length = 5)
	private int noOfRunners;

    @NotNull
    @Column(name="LicenseEndDate")
	private Date lincenseEndDate;

    @NotNull
    @Column(name="LicenseIssueDate")
	private Date licenseIssueDate;

    @NotNull
    @Column(name="PaymentStatus",length = 10)
	private String paymentStatus;

    @NotNull
    @Column(name="LicenseKey",length = 50)
	private String licenseKey;
	
    @NotNull
    @Column(name="LicenseStatus",length = 15)
	private String licenseStatus;
	
    @NotNull
    @Column(name="ClientIPAddress",length = 30)
	private String clientIpAddress;
	
    @NotNull
    @Column(name="CreatedDate",length = 15)
	private Date createdDate;
	
    @NotNull
    @Column(name="UpdatedDate",length = 15)
	private Date updatedDate;

  

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	
	public String getClientSiteId() {
		return clientSiteId;
	}

	public void setClientSiteId(String clientSiteId) {
		this.clientSiteId = clientSiteId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getNoOfRunners() {
		return noOfRunners;
	}

	public void setNoOfRunners(int noOfRunners) {
		this.noOfRunners = noOfRunners;
	}

	public Date getLincenseEndDate() {
		return lincenseEndDate;
	}

	public void setLincenseEndDate(Date lincenseEndDate) {
		this.lincenseEndDate = lincenseEndDate;
	}

	public Date getLicenseIssueDate() {
		return licenseIssueDate;
	}

	public void setLicenseIssueDate(Date licenseIssueDate) {
		this.licenseIssueDate = licenseIssueDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public String getLicenseStatus() {
		return licenseStatus;
	}

	public void setLicenseStatus(String licenseStatus) {
		this.licenseStatus = licenseStatus;
	}

	public String getClientIpAddress() {
		return clientIpAddress;
	}

	public void setClientIpAddress(String clientIpAddress) {
		this.clientIpAddress = clientIpAddress;
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

    
    
    
}
