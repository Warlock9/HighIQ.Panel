package com.augustconsulting.dao;

import java.util.List;

import com.augustconsulting.model.ComponentBundle;
import com.augustconsulting.model.CustomerSites;
import com.augustconsulting.model.DWSales;

public interface DwSalesDao {

	public void insertingDataToDb(DWSales dwSal);

	public void updateDataToDb(DWSales dwSal);

	public void deleteFromDb(int id);

	public List<DWSales> fetchingDataFromDb();
	
	public DWSales fetchingDataFromDb(Integer saleId);
	
	public List<CustomerSites> fetchingCLientSiteDetails();
	
	public List<ComponentBundle> fetchingSKU();
	
	public CustomerSites fetchingClientSiteEmailID(Integer clientSiteId);

	public DWSales fetchingDataByLicenseKey(String key);
	
 	
}
