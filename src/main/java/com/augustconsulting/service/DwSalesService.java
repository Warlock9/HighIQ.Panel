package com.augustconsulting.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.augustconsulting.model.ComponentBundle;
import com.augustconsulting.model.CustomerSites;
import com.augustconsulting.model.DWSales;

public interface DwSalesService {

	public void insertingDataToDb(DWSales dwSal);

	public void updateDataToDb(DWSales dwSal);

	public void deleteFromDb(int id);

	public List<DWSales> fetchingDataFromDb();

	public DWSales fetchingDataFromDb(Integer saleId);

	public List<CustomerSites> fetchingCLientSiteDetails();

	public List<ComponentBundle> fetchingSKU();

	public void getFile(DWSales dSales) throws Exception;

	default File createTemFileWriteLicenseKey(Long fileName,String licenceKey) throws IOException {

		File temp = File.createTempFile(String.valueOf(fileName), ".licen");
		

			// create a temp file
			

			// write it
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
			bw.write(licenceKey);
			bw.close();

			System.out.println("Done");

	   return temp;

	}

}
