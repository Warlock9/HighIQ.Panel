
package com.augustconsulting.dao;

import java.util.List;

import com.augustconsulting.model.CustomerSites;
import com.augustconsulting.model.CustomerDetails;

public interface ManageContactsDao {

	// getting all details form botcontactTable
	public List<CustomerDetails> getAllcontactDetails();

	public CustomerDetails getAllcontactDetails(Integer clientId);

	void updateManageContactHeader(CustomerDetails contacts);

	void updateContactSites(CustomerSites contactSites);

	List<CustomerSites> getSiteDetails(Integer clientId);

	void deleteContactSites(CustomerSites contactSites);

	void deleteCustomerDetails(CustomerDetails clientId);

}
