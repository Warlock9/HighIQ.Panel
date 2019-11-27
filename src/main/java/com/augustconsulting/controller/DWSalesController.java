package com.augustconsulting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.augustconsulting.model.DWSales;
import com.augustconsulting.service.DwSalesService;

@Controller
public class DWSalesController {

	
	private static final String dwSalesLanding="dwSales";
	
	
	@Autowired
	private DwSalesService dwSalesService;
	
	@GetMapping({"/","/digitalWorkerSales"})
	public String landingDwSales(Model model) {
		model.addAttribute("clientSite",dwSalesService.fetchingCLientSiteDetails());
		model.addAttribute("skuCode",dwSalesService.fetchingSKU());
		model.addAttribute("dwSaleDetails", dwSalesService.fetchingDataFromDb());
		return dwSalesLanding;
	}
	
	@PostMapping("/digitalWorkerSales.do")
	public String doActions(@ModelAttribute("DWSales") DWSales dwSales, @RequestParam("action") String action,@RequestParam("createdDate") java.sql.Date createdDate) throws Exception {
		System.out.println(dwSales.getSaleId());
		
		if(action.equals("save")) {	
			   System.out.println(dwSales.getSaleId());
				dwSalesService.insertingDataToDb(dwSales);
			
		}else if(action.equals("update")){
			
			dwSales.setCreatedDate(createdDate);
			dwSalesService.updateDataToDb(dwSales);		
		}
		else if(action.equals("license")) {
	   System.out.println(dwSales.getSaleId()+" >>>>>.");
			DWSales dSales=dwSalesService.fetchingDataFromDb(dwSales.getSaleId());
			 dwSalesService.getFile(dSales);
		   
		}
		return new String("redirect:/digitalWorkerSales");
	}

	
	@PostMapping("/digitalWorkerSales.del")
	public String doDeleteAction(@RequestParam("action") String action, @RequestParam("id") int id) {
		dwSalesService.deleteFromDb(id);
		return new String("redirect:/digitalWorkerSales");
	}
	
}
