package com.augustconsulting.service;

import java.util.List;

import com.augustconsulting.model.ComponentBundle;

public interface ComponentBundleService {

	public void insertingDataToDb(ComponentBundle ds);

	public void updateDataToDb(ComponentBundle ds);

	public void deleteFromDb(String dsName);

	public List<ComponentBundle> fetchingDataFromDb();

	public List<ComponentBundle> validatingDistributionSetName(String distributionName);
}