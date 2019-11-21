package com.augustconsulting.dao;


import java.util.List;

import com.augustconsulting.model.CustomerSites;
import com.augustconsulting.model.CustomerDetails;

public interface ManageContactsDao {

	// getting all details form botcontactTable
	public List<CustomerDetails> getAllcontactDetails();
	
	/*get contactDetails using contactType and contactId*/
    public CustomerDetails getAllcontactDetails(Integer clientId);

	/* update Header manageContacts */
	void updateManageContactHeader(CustomerDetails contacts);

	/* update contactSites */
	void updateContactSites(CustomerSites contactSites);
	
	 /*Get site Details from companyContactNumber*/
    List<CustomerSites> getSiteDetails(String clientId);
    
    /*delete ContactSites for contact */
	void deleteContactSites (CustomerSites contactSites);
	
	/*delete Customer details and site Details*/
	
	void deleteCustomerDetails(CustomerDetails clientId);
	

}
