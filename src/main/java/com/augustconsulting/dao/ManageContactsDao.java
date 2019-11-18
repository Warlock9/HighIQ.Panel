package com.augustconsulting.dao;


import java.util.List;

import com.augustconsulting.model.ContactSites;
import com.augustconsulting.model.Contacts;

public interface ManageContactsDao {

	// getting all details form botcontactTable
	public List<Contacts> getAllcontactDetails();
	
	/*get contactDetails using contactType and contactId*/
    public Contacts getAllcontactDetails(Integer clientId);

	/* update Header manageContacts */
	void updateManageContactHeader(Contacts contacts);

	/* update contactSites */
	void updateContactSites(ContactSites contactSites);
	
	 /*Get site Details from companyContactNumber*/
    List<ContactSites> getSiteDetails(Integer clientId);
    
    /*delete ContactSites for contact */
	void deleteContactSites (ContactSites contactSites);
	
	/*delete Customer details and site Details*/
	
	void deleteCustomerDetails(Contacts clientId);
	

}
