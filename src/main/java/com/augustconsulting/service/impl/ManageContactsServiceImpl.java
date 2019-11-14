package com.augustconsulting.service.impl;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.augustconsulting.dao.ManageContactsDao;
import com.augustconsulting.model.Contacts;
import com.augustconsulting.service.ManageContactsService;


@Service
@Transactional("transactionManager")
public class ManageContactsServiceImpl implements ManageContactsService {

	@Autowired
	private ManageContactsDao managecontactdao;
	
	
	
	@Override
	public void updateManageContactHeader(Contacts contacts) {
		
		contacts.setCreatedDate(new java.sql.Date (System.currentTimeMillis()));
		contacts.setUpdatedDate(new java.sql.Date (System.currentTimeMillis()));
		managecontactdao.updateManageContactHeader(contacts);		
	}
	@Override
	public void updateContactSites(String arraycontactSites) {
		// TODO Auto-generated method stub
		
		
	}
	

}
