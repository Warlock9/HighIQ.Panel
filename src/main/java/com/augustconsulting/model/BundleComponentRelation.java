package com.augustconsulting.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_ComponentBundleRelation")
public class BundleComponentRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", length = 11)
	private int id;
	
	
	@NotNull
	@Column(name = "BundleSKU", length = 50)
	private String BundleSKU;
	
	@NotNull
	@Column(name = "ComponentSKUs", length = 10)
	private String ComponentSKUs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBundleSKU() {
		return BundleSKU;
	}

	public void setBundleSKU(String bundleSKU) {
		BundleSKU = bundleSKU;
	}

	public String getComponentSKUs() {
		return ComponentSKUs;
	}

	public void setComponentSKUs(String componentSKUs) {
		ComponentSKUs = componentSKUs;
	}

	@Override
	public String toString() {
		return "BundleComponentRelation [id=" + id + ", BundleSKU=" + BundleSKU + ", ComponentSKUs=" + ComponentSKUs
				+ "]";
	}
	
	
}
