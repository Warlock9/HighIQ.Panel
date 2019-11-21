
package com.augustconsulting.service;


import java.util.List;

import com.augustconsulting.model.CustomerSites;
import com.augustconsulting.model.CustomerDetails;

public interface ManageContactsService {

	// getting all details form botcontactTable
		public List<CustomerDetails> getAllcontactDetails();
		
	/* update Header manageContacts */
	void updateManageContactHeader(CustomerDetails contacts);

	void updateContactSites(String arraycontactSites,String clientId);
	
	/*get contactDetails using contactType and contactId*/
    public CustomerDetails getAllcontactDetails(Integer contactId);
    
    /*Get site Details from companyContactNumber*/
    List<CustomerSites> getSiteDetails(String clientId);
    
    /* delete contactSites of contact */
	void deleteContactSites(CustomerSites contactSites);
	
/*delete Customer details and site Details*/
	
	void deleteCustomerDetails(CustomerDetails clientId);
	

}