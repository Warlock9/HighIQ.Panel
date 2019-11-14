package com.augustconsulting.service.impl;

import java.sql.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.augustconsulting.dao.ManageContactsDao;
import com.augustconsulting.model.ContactSites;
import com.augustconsulting.model.Contacts;
import com.augustconsulting.service.ManageContactsService;

@Service
@Transactional("transactionManager")
public class ManageContactsServiceImpl implements ManageContactsService {

	@Autowired
	private ManageContactsDao managecontactdao;

	@Override
	public void updateManageContactHeader(Contacts contacts) {

		contacts.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
		contacts.setUpdatedDate(new java.sql.Date(System.currentTimeMillis()));
		managecontactdao.updateManageContactHeader(contacts);
	}

	@Override
	public void updateContactSites(String arraycontactSites) {
		// TODO Auto-generated method stub
		try {
			ContactSites contactSites = new ContactSites();
			JSONArray jsonArray = new JSONArray(arraycontactSites);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject1 = jsonArray.getJSONObject(i);

				String clientSiteId = jsonObject1.optString("clientSiteId");
				String clientId = jsonObject1.optString("clientId");
				String siteName = jsonObject1.optString("siteName");

				String addressLine1 = jsonObject1.optString("addressLine1");
				String addressLine2 = jsonObject1.optString("addressLine2");
				String addressLine3 = jsonObject1.optString("addressLine3");
				String addressLine4 = jsonObject1.optString("addressLine4");
				String city = jsonObject1.optString("city");
				String state = jsonObject1.optString("state");
				String zipCode = jsonObject1.optString("zipCode");
				String country = jsonObject1.optString("country");

				String contactPerson = jsonObject1.optString("contactPerson");
                 String createdDate=jsonObject1.optString("createdDate");
				String contactNumber = jsonObject1.optString("contactNumber");
				String emailID = jsonObject1.optString("emailID");

				String status = jsonObject1.optString("status");

				contactSites.setClientSiteId(Long.parseLong(clientSiteId));
				contactSites.setClientId(clientId);
				contactSites.setSiteName(siteName);

				contactSites.setAddressLine1(addressLine1);
				contactSites.setAddressLine2(addressLine2);
				contactSites.setAddressLine3(addressLine3);
				contactSites.setAddressLine4(addressLine4);
				contactSites.setCity(city);
				contactSites.setState(state);
				contactSites.setCountry(country);
				contactSites.setZipCode(zipCode);
				contactSites.setContactNumber(contactNumber);
				contactSites.setContactPerson(contactPerson);
				contactSites.setEmailID(emailID);
				contactSites.setStatus(status);
				contactSites.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
				managecontactdao.updateContactSites(contactSites);

			}

		} catch (JSONException jse) {
			// TODO: handle exception
			jse.printStackTrace();
		}

	}

	@Override
	public Contacts getAllcontactDetails(Long contactId) {
		// TODO Auto-generated method stub
		return managecontactdao.getAllcontactDetails(contactId);
	}

	@Override
	public List<Contacts> getAllcontactDetails() {
		// TODO Auto-generated method stub
		return managecontactdao.getAllcontactDetails();
	}

}
