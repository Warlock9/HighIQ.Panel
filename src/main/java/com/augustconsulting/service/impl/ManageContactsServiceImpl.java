package com.augustconsulting.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.augustconsulting.dao.ManageContactsDao;
import com.augustconsulting.model.ContactSites;
import com.augustconsulting.model.Contacts;
import com.augustconsulting.service.ManageContactsService;


@Service
@Transactional("transactionManager")
public class ManageContactsServiceImpl implements ManageContactsService {

	@Autowired
	private ManageContactsDao managecontactdao;
	
	

	public List<Contacts> getAllcontactDetails() {
		// TODO Auto-generated method stub
		return managecontactdao.getAllcontactDetails();
	}
	/*get contact type using contact ID*/
	@Override
	public List<String> getContactType(Long contactId) {
		// TODO Auto-generated method stub
		return managecontactdao.getContactType(contactId);
	}
	
	/*get contactDetails using  contactId*/
	@Override
	public Contacts getAllcontactDetails(Long contactId) {
		// TODO Auto-generated method stub
		return managecontactdao.getAllcontactDetails(contactId);
	}
	
	 /*Get site Details from companyContactNumber*/
	@Override
	public List<ContactSites> getSiteDetails(String companyContactNumber) {
		// TODO Auto-generated method stub
		return managecontactdao.getSiteDetails(companyContactNumber);
	}
	
	@Override
	public void updateManageContactHeader(Contacts contacts) {
		
		Contacts contacts_1 = new Contacts();
		if(contacts.getContactType().equals("Customer"))
		{
			contacts_1.setContactId(contacts.getContactId());
			//contacts_1.setDefaultOrderLineType(contacts.getDefaultOrderLineType());
			contacts_1.setDefaultPaymentTerms(contacts.getDefaultPaymentTerms());
			contacts_1.setDefaultPriceList(contacts.getDefaultPriceList());
			contacts_1.setDefaultTransactionType(contacts.getDefaultTransactionType());
			contacts_1.setDefaultWareHouse(contacts.getDefaultWareHouse());
			contacts_1.setDefaultFobPoint(contacts.getDefaultFobPoint());			
			contacts_1.setBotId(contacts.getBotId());
			contacts_1.setContactCompany(contacts.getContactCompany());
			contacts_1.setContactCompanyNumber(contacts.getContactCompanyNumber());
			contacts_1.setContactEmailId(contacts.getContactEmailId());
			contacts_1.setContactFirstName(contacts.getContactFirstName());
			contacts_1.setContactlastName(contacts.getContactlastName());
			contacts_1.setContactMiddleName(contacts.getContactMiddleName());
			contacts_1.setContactPhone(contacts.getContactPhone());
			contacts_1.setContactType(contacts.getContactType());
		}else
		{
			contacts_1.setContactId(contacts.getContactId());
		System.out.println(contacts.getBankAccount());
		contacts_1.setVatRegno(contacts.getVatRegno());
		contacts_1.setBankAccount(contacts.getBankAccount());
		contacts_1.setBankAccountCode(contacts.getBankAccountCode());
		contacts_1.setBankaccountNumber(contacts.getBankaccountNumber());
		contacts_1.setBotId(contacts.getBotId());
		contacts_1.setContactCompany(contacts.getContactCompany());
		contacts_1.setContactCompanyNumber(contacts.getContactCompanyNumber());
		contacts_1.setContactEmailId(contacts.getContactEmailId());
		contacts_1.setContactFirstName(contacts.getContactFirstName());
		contacts_1.setContactlastName(contacts.getContactlastName());
		contacts_1.setContactMiddleName(contacts.getContactMiddleName());
		contacts_1.setContactPhone(contacts.getContactPhone());
		contacts_1.setContactType(contacts.getContactType());
		
		}
          managecontactdao.updateManageContactHeader(contacts_1);		
	}
	
	@Override
	public void updateVendorContactSites(String arraycontactSites) {
		// TODO Auto-generated method stub
		
		try {
			ContactSites contactSites=new ContactSites();
			JSONArray jsonArray = new JSONArray(arraycontactSites);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject1 = jsonArray.getJSONObject(i);
				String siteType=jsonObject1.optString("siteType");
				String siteUseId = jsonObject1.optString("siteUseId");
				String contactCompanyNumber = jsonObject1.optString("contactCompanyNumber");
			    System.out.println(siteType+" "+siteUseId+" "+contactCompanyNumber+" ???????????");
				String locationId = jsonObject1.optString("locationId");
				String addressLine1 = jsonObject1.optString("addressLine1");
				String addressLine2 = jsonObject1.optString("addressLine2");
				System.out.println(addressLine2+ ">>>>>>>>++++++");
				String addressLine3 = jsonObject1.optString("addressLine3");
				String addressLine4 = jsonObject1.optString("addressLine4");
				String addressCity = jsonObject1.optString("addressCity");
				String addressState = jsonObject1.optString("addressState");
				String addressCountry = jsonObject1.optString("addressCountry");
				String addressPostalCode = jsonObject1.optString("addressPostalCode");
				
				 String operatingUnitID=  jsonObject1.optString("operatingUnitID");
			    
				contactSites.setSiteType(siteType);
				contactSites.setSiteUseId(siteUseId);
				contactSites.setContactCompanyNumber(contactCompanyNumber);
				contactSites.setBillToSiteUseId("");
				contactSites.setLocationId(locationId);
                contactSites.setAddressLine1(addressLine1);
                contactSites.setAddressLine2(addressLine2);
                contactSites.setAddressLine3(addressLine3);
                contactSites.setAddressLine4(addressLine4);
                contactSites.setAddressCity(addressCity);
                contactSites.setAddressState(addressState);
                contactSites.setAddressCountry(addressCountry);
                contactSites.setAddressPostalCode(addressPostalCode);
                contactSites.setDefaultFOBPoint("");
                contactSites.setDefaultPaymentTerms("");
                contactSites.setDefaultPriceList("");
                contactSites.setDefaultTransactionType("");
                contactSites.setDefaultWareHouse("");
                contactSites.setDefaultOrderLineType("");
                contactSites.setOperatingUnit(operatingUnitID);
                
                
                System.out.println("*******************"+operatingUnitID);
                managecontactdao.updateContactSites(contactSites);
               

			}

		} catch (JSONException jse) {
			// TODO: handle exception
			jse.printStackTrace();
		}
		
	}
	@Override
	public void updateContactSitesCustomer(String arraycontactSites) {
		// TODO Auto-generated method stub
		ContactSites contactSites=new ContactSites();
		try {
			JSONArray jsonArray = new JSONArray(arraycontactSites);
			for (int i = 0; i < jsonArray.length(); i++) {
				
				System.out.println("*****************");
				JSONObject jsonObject1 = jsonArray.getJSONObject(i);
				String siteType=jsonObject1.optString("siteType");
				String siteUseId = jsonObject1.optString("siteUseId");
				String contactCompanyNumber = jsonObject1.optString("contactCompanyNumber");
				String locationId = jsonObject1.optString("locationId");
				String billToSiteUseId=jsonObject1.optString("billToSiteUseId");
				String addressLine1 = jsonObject1.optString("addressLine1");
				String addressLine2 = jsonObject1.optString("addressLine2");
				String addressLine3 = jsonObject1.optString("addressLine3");
				String addressLine4 = jsonObject1.optString("addressLine4");
				String addressCity = jsonObject1.optString("addressCity");
				String addressState = jsonObject1.optString("addressState");
				String addressCountry = jsonObject1.optString("addressCountry");
				String addressPostalCode = jsonObject1.optString("addressPostalCode");
			    String defaultPaymentTerms=jsonObject1.optString("defaultPaymentTerms");
			    String defaultTransactionType=jsonObject1.optString("defaultTransactionType");
			    String defaultWareHouse=jsonObject1.optString("defaultWareHouse");
			    String defaultPriceList=jsonObject1.optString("defaultPriceList");
			    String defaultFOBPoint=jsonObject1.optString("defaultFOBPoint");
			    String operatingUnitID=  jsonObject1.optString("operatingUnitID");
			    		 
				contactSites.setSiteType(siteType);
				contactSites.setSiteUseId(siteUseId);
				contactSites.setContactCompanyNumber(contactCompanyNumber);
				contactSites.setBillToSiteUseId(billToSiteUseId);
				contactSites.setLocationId(locationId);
                contactSites.setAddressLine1(addressLine1);
                contactSites.setAddressLine2(addressLine2);
                contactSites.setAddressLine3(addressLine3);
                contactSites.setAddressLine4(addressLine4);
                contactSites.setAddressCity(addressCity);
                contactSites.setAddressState(addressState);
                contactSites.setAddressCountry(addressCountry);
                contactSites.setAddressPostalCode(addressPostalCode);
                contactSites.setDefaultPaymentTerms(defaultPaymentTerms);
                contactSites.setDefaultTransactionType(defaultTransactionType);
                contactSites.setDefaultWareHouse(defaultWareHouse);
                contactSites.setDefaultPriceList(defaultPriceList);
                contactSites.setDefaultFOBPoint(defaultFOBPoint);
                contactSites.setDefaultOrderLineType("");
                contactSites.setOperatingUnit(operatingUnitID);
                
                
                System.out.println("*******************"+operatingUnitID);
                
                
              managecontactdao.updateContactSites(contactSites);;

			}

		} catch (JSONException jse) {
			// TODO: handle exception
			jse.printStackTrace();
		}
		
	}
	@Override
	public List<ContactSites> fetchDistinctBillToSiteId(String companyNumber) {
		return managecontactdao.fetchDistinctBillToSiteId(companyNumber);
	}

	@Override
	public void deleteContactSites(ContactSites contactSites) {
		// TODO Auto-generated method stub
		 managecontactdao.deleteContactSites(contactSites);
	}
	@Override
	public void deleteContactSitesList(Contacts contact) {
		// TODO Auto-generated method stub
		 managecontactdao.deleteContactSitesList(contact);
	}
	@Override
	public int saveCustomerContactsDetailFromExcel(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(file.getInputStream());
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			LinkedHashMap<Contacts, ArrayList<ContactSites>> mapObj = new LinkedHashMap<Contacts, ArrayList<ContactSites>>();
			ArrayList<ContactSites> contactSiteslistObj = new ArrayList<ContactSites>();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();

				Contacts contactsObj = new Contacts();

				ContactSites contactSitesObj = new ContactSites();

				if (currentRow.getRowNum() > 2) {
					// fetching contact header information
				    contactsObj.setContactType("Customer");
					contactsObj.setContactCompany(getCellValue(currentRow, 0));
					contactsObj.setContactCompanyNumber(getCellValue(currentRow, 1));
					contactsObj.setContactEmailId(getCellValue(currentRow, 2));
					contactsObj.setContactFirstName(getCellValue(currentRow, 3));
					contactsObj.setContactMiddleName(getCellValue(currentRow, 4));
					contactsObj.setContactlastName(getCellValue(currentRow, 5));
					contactsObj.setContactPhone(getCellValue(currentRow, 6));
					contactsObj.setDefaultPaymentTerms(getCellValue(currentRow, 7));
					contactsObj.setDefaultTransactionType(getCellValue(currentRow, 8));
					contactsObj.setDefaultWareHouse(getCellValue(currentRow, 9));
					contactsObj.setDefaultPriceList(getCellValue(currentRow, 10));
					contactsObj.setDefaultFobPoint(getCellValue(currentRow, 11));
				

					// fetching contact site information
			
					contactSitesObj.setContactCompanyNumber(getCellValue(currentRow, 1));
					contactSitesObj.setSiteType(getCellValue(currentRow, 12));
					contactSitesObj.setSiteUseId(getCellValue(currentRow, 13));
					contactSitesObj.setBillToSiteUseId(getCellValue(currentRow, 14));
					contactSitesObj.setLocationId(getCellValue(currentRow, 15));
					contactSitesObj.setAddressLine1(getCellValue(currentRow, 16));
					contactSitesObj.setAddressLine2(getCellValue(currentRow, 17));
					contactSitesObj.setAddressLine3(getCellValue(currentRow, 18));
					contactSitesObj.setAddressLine4(getCellValue(currentRow, 19));
					contactSitesObj.setAddressCity(getCellValue(currentRow, 20));
					contactSitesObj.setAddressState(getCellValue(currentRow, 21));
					contactSitesObj.setAddressPostalCode(getCellValue(currentRow, 22));
					contactSitesObj.setAddressCountry(getCellValue(currentRow, 23));
					contactSitesObj.setDefaultPaymentTerms(getCellValue(currentRow, 24));
					contactSitesObj.setDefaultTransactionType(getCellValue(currentRow, 25));
					contactSitesObj.setDefaultWareHouse(getCellValue(currentRow, 26));
					contactSitesObj.setDefaultPriceList(getCellValue(currentRow, 27));
					contactSitesObj.setDefaultFOBPoint(getCellValue(currentRow, 28));

					if (mapObj.put(contactsObj, contactSiteslistObj) == null) {
						contactSiteslistObj = new ArrayList<ContactSites>();
						contactSiteslistObj.add(contactSitesObj);
						mapObj.put(contactsObj, contactSiteslistObj);
					} else {
						contactSiteslistObj.add(contactSitesObj);
						mapObj.put(contactsObj, contactSiteslistObj);
					}															
				}
			}

			Set<Contacts> contactSetObj =  mapObj.keySet();
			
			for (Contacts contactObj : contactSetObj) {
				ArrayList<ContactSites> contactSitesListObj = mapObj.get(contactObj);
				managecontactdao.saveAllcontactsHeader(contactObj);
				for (ContactSites contactSitesObj : contactSitesListObj) {
					managecontactdao.saveAllcontactSitesDetails(contactSitesObj);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private static String getCellValue(Row currentRow, int cellIndex) {
		try {
			if (currentRow.getCell(cellIndex).getCellType() == CellType.STRING) {
				return currentRow.getCell(cellIndex).getStringCellValue().trim();
			} else if (currentRow.getCell(cellIndex).getCellType() == CellType.NUMERIC) {
				return String.valueOf(currentRow.getCell(cellIndex).getNumericCellValue()).replace(".0", "").trim();
			} else {
				return "";
			}
		} catch (NullPointerException ex) {
			return "";
		}
		
	}
	
	@Override
	public int saveVendorContactsDetailFromExcel(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(file.getInputStream());
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			LinkedHashMap<Contacts, ArrayList<ContactSites>> mapObj = new LinkedHashMap<Contacts, ArrayList<ContactSites>>();
			ArrayList<ContactSites> contactSiteslistObj = new ArrayList<ContactSites>();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();

				Contacts contactsObj = new Contacts();

				ContactSites contactSitesObj = new ContactSites();

				if (currentRow.getRowNum() > 2) {
					// fetching contact header information
				    contactsObj.setContactType("Vendor");
					contactsObj.setContactCompany(getVendorCellValue(currentRow, 0));
					contactsObj.setContactCompanyNumber(getVendorCellValue(currentRow, 1));
					contactsObj.setContactEmailId(getVendorCellValue(currentRow, 2));
					contactsObj.setContactFirstName(getVendorCellValue(currentRow, 3));
					contactsObj.setContactMiddleName(getVendorCellValue(currentRow, 4));
					contactsObj.setContactlastName(getVendorCellValue(currentRow, 5));
					contactsObj.setContactPhone(getVendorCellValue(currentRow, 6));
					contactsObj.setBankAccount(getVendorCellValue(currentRow, 7));
					contactsObj.setBankAccountCode(getVendorCellValue(currentRow, 8));
					contactsObj.setBankaccountNumber(getVendorCellValue(currentRow, 9));
					contactsObj.setVatRegno(getVendorCellValue(currentRow, 10));

					// fetching contact site information
			
					contactSitesObj.setContactCompanyNumber(getVendorCellValue(currentRow, 1));
					contactSitesObj.setSiteType(getVendorCellValue(currentRow, 11));
					contactSitesObj.setSiteUseId(getVendorCellValue(currentRow, 12));
					contactSitesObj.setBillToSiteUseId("");
					contactSitesObj.setLocationId(getVendorCellValue(currentRow, 13));
					contactSitesObj.setAddressLine1(getVendorCellValue(currentRow, 14));
					contactSitesObj.setAddressLine2(getVendorCellValue(currentRow, 15));
					contactSitesObj.setAddressLine3(getVendorCellValue(currentRow, 16));
					contactSitesObj.setAddressLine4(getVendorCellValue(currentRow, 17));
					contactSitesObj.setAddressCity(getVendorCellValue(currentRow, 18));
					contactSitesObj.setAddressState(getVendorCellValue(currentRow, 19));
					contactSitesObj.setAddressPostalCode(getVendorCellValue(currentRow, 20));
					contactSitesObj.setAddressCountry(getVendorCellValue(currentRow, 21));

					if (mapObj.put(contactsObj, contactSiteslistObj) == null) {
						contactSiteslistObj = new ArrayList<ContactSites>();
						contactSiteslistObj.add(contactSitesObj);
						mapObj.put(contactsObj, contactSiteslistObj);
					} else {
						contactSiteslistObj.add(contactSitesObj);
						mapObj.put(contactsObj, contactSiteslistObj);
					}															
				}
			}

			Set<Contacts> contactSetObj =  mapObj.keySet();
			
			
			for (Contacts contactObj : contactSetObj) {
				ArrayList<ContactSites> contactSitesListObj = mapObj.get(contactObj);
				managecontactdao.saveAllcontactsHeader(contactObj);
				for (ContactSites contactSitesObj : contactSitesListObj) {
					managecontactdao.saveAllcontactSitesDetails(contactSitesObj);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private static String getVendorCellValue(Row currentRow, int cellIndex) {
		try {
			if (currentRow.getCell(cellIndex).getCellType() == CellType.STRING) {
				return currentRow.getCell(cellIndex).getStringCellValue().trim();
			} else if (currentRow.getCell(cellIndex).getCellType() == CellType.NUMERIC) {
				return String.valueOf(currentRow.getCell(cellIndex).getNumericCellValue()).replace(".0", "").trim();
			} else {
				return "";
			}
		} catch (NullPointerException ex) {
			return "";
		}
		
	}
	
	  

}
