
package com.augustconsulting.service;


import java.util.List;

import com.augustconsulting.model.ContactSites;
import com.augustconsulting.model.Contacts;

public interface ManageContactsService {

	// getting all details form botcontactTable
		public List<Contacts> getAllcontactDetails();
		
	/* update Header manageContacts */
	void updateManageContactHeader(Contacts contacts);

	void updateContactSites(String arraycontactSites);
	
	/*get contactDetails using contactType and contactId*/
    public Contacts getAllcontactDetails(Integer contactId);
    
    /*Get site Details from companyContactNumber*/
    List<ContactSites> getSiteDetails(int clientId);
    
    /* delete contactSites of contact */
	void deleteContactSites(ContactSites contactSites);
	
/*delete Customer details and site Details*/
	
	void deleteCustomerDetails(Contacts clientId);
	

}