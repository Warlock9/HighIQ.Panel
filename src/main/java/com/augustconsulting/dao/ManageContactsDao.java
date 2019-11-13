package com.augustconsulting.dao;

import java.util.List;

import com.augustconsulting.model.ContactSites;
import com.augustconsulting.model.Contacts;

public interface ManageContactsDao {

	// getting all details form botcontactTable
	public List<Contacts> getAllcontactDetails();
	
	// saving all contacts Header form Excel
	public void saveAllcontactsHeader(Contacts contacts);
	
	// saving all contacts Sites details form Excel
	public void saveAllcontactSitesDetails(ContactSites contactSites);
	
	/*get contact type using contact ID*/
	List<String> getContactType(Long contactId);
	
	/*get contactDetails using contactType and contactId*/
     public Contacts getAllcontactDetails(Long contactId);     
     
     /*Get site Details from companyContactNumber*/
    List<ContactSites> getSiteDetails(String companyContactNumber);
    
    /*update Header manageContacts*/
    void updateManageContactHeader( Contacts contacts);
    
    /* update contactSites */
	void updateContactSites(ContactSites contactSites);
	
	/*Update ContactSites for customer*/
	void updateContactSitesCustomer(ContactSites contactSites);
	
	/*fetching distinct billToSiteId */
	List<ContactSites> fetchDistinctBillToSiteId(String companyNumber);
	
	/*delete ContactSites for contact */
	void deleteContactSites (ContactSites contactSites);
	
	/*delete ContactSitesList for contact */
	void deleteContactSitesList(Contacts contact);
}
