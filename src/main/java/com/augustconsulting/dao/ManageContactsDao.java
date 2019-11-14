package com.augustconsulting.dao;


import com.augustconsulting.model.ContactSites;
import com.augustconsulting.model.Contacts;

public interface ManageContactsDao {


	/* update Header manageContacts */
	void updateManageContactHeader(Contacts contacts);

	/* update contactSites */
	void updateContactSites(ContactSites contactSites);

}
