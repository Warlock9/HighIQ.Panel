package com.augustconsulting.dao;

import java.util.List;

import com.augustconsulting.model.BundleComponentRelation;
import com.augustconsulting.model.ComponentBundle;

public interface ComponentBundleDao {

    public void insertingDataToDb(ComponentBundle ds);
	
	public void updateDataToDb(ComponentBundle ds);
	
	public void deleteFromDb(String id);
	
	public List<ComponentBundle> fetchingDataFromDb();
	
	public List<ComponentBundle> validatingDistributionSetName(String distributionName);
	
	public void insertDataToRelation(BundleComponentRelation rs);
	
	public List<BundleComponentRelation> fetchingDataFromRelation();
	
	public void deleteFromRelationDb(String sku);
	
	public List<BundleComponentRelation> getComponent(String skuCode);
	
	public List<ComponentBundle> validatingSkuCode(String skuCode);
	
	public String getComponentBundleName(String skuCode);
	
}
