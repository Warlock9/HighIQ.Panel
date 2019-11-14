package com.augustconsulting.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.augustconsulting.dao.ComponentBundleDao;
import com.augustconsulting.model.ComponentBundle;
import com.augustconsulting.service.ComponentBundleService;

@Service
public class ComponentBundleServiceImpl implements ComponentBundleService {

	@Autowired
	private ComponentBundleDao manageDao;

	

	@Override
	public void deleteFromDb(String dsName) {
		manageDao.deleteFromDb(dsName);
	}

	@Override
	public List<ComponentBundle> fetchingDataFromDb() {
		return manageDao.fetchingDataFromDb();
	}

	@Override
	public List<ComponentBundle> validatingDistributionSetName(String distributionName) {
		// TODO Auto-generated method stub
		return manageDao.validatingDistributionSetName(distributionName);
	}

	@Override
	public void insertingDataToDb(ComponentBundle ds) {
		manageDao.insertingDataToDb(ds);
		
	}

	@Override
	public void updateDataToDb(ComponentBundle ds) {
		manageDao.updateDataToDb(ds);
		
	}

}
