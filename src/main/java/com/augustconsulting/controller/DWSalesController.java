package com.augustconsulting.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.augustconsulting.model.CustomerSites;
import com.augustconsulting.model.DWSales;
import com.augustconsulting.service.DwSalesService;
import com.augustconsulting.service.UsersRoleService;
import com.augustconsulting.utility.ViewAndOperationAccess;

@Controller
public class DWSalesController {

	
	private static final String dwSalesLanding="dwSales";
	
	
	@Autowired
	private DwSalesService dwSalesService;
	
	@Autowired
	private UsersRoleService userRoleService;
	
	@GetMapping("/digitalWorkerSales")
	public String landingDwSales(Model model,HttpServletRequest request, HttpServletResponse response) {
		String st = new ViewAndOperationAccess().gettingViewAndOperationAccess(model, request,userRoleService, "digitalWorkerSales", "Digital Worker Sales");
    	if(st==null) {
			return new String("redirect:/");
		}
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
	     DWSales dSales=dwSalesService.fetchingDataFromDb(dwSales.getSaleId());
	     
	     /*getting customerSite email id*/
	     
	     CustomerSites emailId=dwSalesService.fetchingClientSiteEmailID(Integer.parseInt(dwSales.getClientSiteId()));
	    
		 dwSalesService.getFileToMail(dSales,emailId.getEmailID());
		   
		}
		return new String("redirect:/digitalWorkerSales");
	}

	
	@PostMapping("/digitalWorkerSales.del")
	public String doDeleteAction(@RequestParam("action") String action, @RequestParam("id") int id) {
		dwSalesService.deleteFromDb(id);
		return new String("redirect:/digitalWorkerSales");
	}
	
}
