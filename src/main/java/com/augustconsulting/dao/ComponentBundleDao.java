package com.augustconsulting.dao;

import java.util.List;

import com.augustconsulting.model.ComponentBundle;

public interface ComponentBundleDao {

    public void insertingDataToDb(ComponentBundle ds);
	
	public void updateDataToDb(ComponentBundle ds);
	
	public void deleteFromDb(String distributionName);
	
	public List<ComponentBundle> fetchingDataFromDb();
	
	public List<ComponentBundle> validatingDistributionSetName(String distributionName);
	
}
