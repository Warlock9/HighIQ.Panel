package com.augustconsulting.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_ComponentBundle")
public class ComponentBundle {
	
@Id
@Column(name="Id",length = 5)
private int id;
@Column(name="ComponentBundleName",length = 100)
@NotNull
private String componentBundleName;
@Column(name="Type",length = 10)
@NotNull
private String type;
@Column(name="SkuCode",length = 5)
@NotNull
private String skuCode;
@Column(name="UpdatedDate")
@NotNull
private Date updatedDate;
@Column(name="CreatedDate")
@NotNull
private Date createdDate;
@Column(name="Status",length = 5)
@NotNull
private int status;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getComponentBundleName() {
	return componentBundleName;
}
public void setComponentBundleName(String componentBundleName) {
	this.componentBundleName = componentBundleName;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getSkuCode() {
	return skuCode;
}
public void setSkuCode(String skuCode) {
	this.skuCode = skuCode;
}
public Date getUpdatedDate() {
	return updatedDate;
}
public void setUpdatedDate(Date updatedDate) {
	this.updatedDate = updatedDate;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
@Override
public String toString() {
	return "ComponentBundle [id=" + id + ", componentBundleName=" + componentBundleName + ", type=" + type
			+ ", skuCode=" + skuCode + ", updatedDate=" + updatedDate + ", createdDate=" + createdDate + ", status="
			+ status + "]";
}


}
