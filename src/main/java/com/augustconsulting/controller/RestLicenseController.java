package com.augustconsulting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.augustconsulting.model.DWSales;
import com.augustconsulting.model.Status;
import com.augustconsulting.service.ComponentBundleService;
import com.augustconsulting.service.DwSalesService;

@RestController

public class RestLicenseController {

	@Autowired
	DwSalesService dataServices;

	@Autowired
	ComponentBundleService bundleService;

	/*
	 * @RequestMapping(value = "/create", method = RequestMethod.POST)
	 */
	@PostMapping("/create")
	public @ResponseBody Status addEmployee(@RequestBody DWSales dwSales) {
		try {
			DWSales dw = dataServices.fetchingDataByLicenseKey(dwSales.getLicenseKey());

			int skuCode = dataServices.getSKUCodeFromKey(dwSales.getLicenseKey());
			if (dw == null) {
				return new Status(1, "License Key Invalid!", "");
			} else {
				if (dw.getLicenseStatus().equals("Generated")) {
					String digitalWorkerName = bundleService.getComponentBundleName(String.valueOf(skuCode));
					// get componentBundleName from skuCode
					dw.setClientIpAddress(dwSales.getClientIpAddress());
					dw.setLicenseStatus("Active");
					dataServices.updateDataToDb(dw);

					return new Status(2, "License Successfully Activated !", digitalWorkerName);
				} else {
					return new Status(3, "License Already In Use !", "");
				}

			}

		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString(), "");
		}

	}

}
