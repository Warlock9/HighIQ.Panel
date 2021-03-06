package com.augustconsulting.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyException;
import java.util.List;


import com.augustconsulting.model.ComponentBundle;
import com.augustconsulting.model.CustomerSites;
import com.augustconsulting.model.DWSales;
import com.augustconsulting.utility.Security;

public interface DwSalesService {

	public void insertingDataToDb(DWSales dwSal);

	public void updateDataToDb(DWSales dwSal);

	public void deleteFromDb(int id);

	public List<DWSales> fetchingDataFromDb();

	public DWSales fetchingDataFromDb(Integer saleId);

	public List<CustomerSites> fetchingCLientSiteDetails();

	public List<ComponentBundle> fetchingSKU();
	
	public DWSales fetchingDataByLicenseKey(String key);

	long getActiveLicences();
	
	long getGeneratedLincenseCurrentMonth();


	// Get License File to mail
	public void getFileToMail(DWSales dSales,String customerSiteMailID) throws Exception;

	public CustomerSites fetchingClientSiteEmailID(Integer clientSiteId);


	public String sendMail(String host, String port, String fromMail, String password, String toMail, String subject,
			File licenseFile);

	default File createTemFileWriteLicenseKey(Long fileName, String licenceKey) throws IOException {

		File temp = File.createTempFile(String.valueOf(fileName), ".licen");

		// create a temp file

		// write it
		BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
		bw.write(licenceKey);
		bw.close();
		return temp;

	}
	
	default int getSKUCodeFromKey(String licenseKey) throws KeyException, GeneralSecurityException, IOException {
		
		String skuCode=Security.decryptData(licenseKey);
		System.out.println(skuCode.substring(14, 18));
		return Integer.valueOf(skuCode.substring(14, 18));
		
	}

}
