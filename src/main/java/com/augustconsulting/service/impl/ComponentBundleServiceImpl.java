package com.augustconsulting.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.augustconsulting.dao.ComponentBundleDao;
import com.augustconsulting.model.BundleComponentRelation;
import com.augustconsulting.model.ComponentBundle;
import com.augustconsulting.service.ComponentBundleService;
import com.augustconsulting.service.DateConversionService;

@Service
public class ComponentBundleServiceImpl implements ComponentBundleService {

	@Autowired
	private ComponentBundleDao manageDao;

	@Autowired
	DateConversionService dateService;
	

	@Override
	public void deleteFromDb(String id) {
		manageDao.deleteFromDb(id);
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
		
		ds.setCreatedDate(dateService.getToDate());
		ds.setUpdatedDate(dateService.getToDate());
		manageDao.insertingDataToDb(ds);
		
	}

	@Override
	public void updateDataToDb(ComponentBundle ds) {
		ds.setUpdatedDate(dateService.getToDate());
		manageDao.updateDataToDb(ds);
		
	}

	@Override
	public void insertDataToRelation(BundleComponentRelation rs) {
		manageDao.insertDataToRelation(rs);
		
	}

}
