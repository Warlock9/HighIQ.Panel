
package com.augustconsulting.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.augustconsulting.model.ContactSites;
import com.augustconsulting.model.Contacts;


public interface ManageContactsService {
	
	// saving Customer contacts Header form Excel
		public int saveCustomerContactsDetailFromExcel(MultipartFile file);
		
		public int saveVendorContactsDetailFromExcel(MultipartFile file);

	// getting all details form botcontactTable
	List<Contacts> getAllcontactDetails();

	/*get contact type using contact ID*/
	List<String> getContactType(Long contactId);
	
	/*get contactDetails using  contactId*/
	Contacts getAllcontactDetails(Long contactId);
	
	 /*Get site Details from companyContactNumber*/
    List<ContactSites> getSiteDetails(String companyContactNumber);
    
    /*update Header manageContacts*/
    void updateManageContactHeader( Contacts contacts);
    
    /* update contactSites */
	void updateVendorContactSites(String arraycontactSites);
	
	 /* update contactSites for customer */
		void updateContactSitesCustomer(String arraycontactSites);
		
		/*fetching distinct billToSiteId */
		List<ContactSites> fetchDistinctBillToSiteId(String companyNumber);
		
		/* delete contactSites of contact */
		void deleteContactSites(ContactSites contactSites);
		
		/* delete contact of contact */
		void deleteContactSitesList(Contacts contact);
	
}