package com.augustconsulting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.augustconsulting.model.ContactSites;
import com.augustconsulting.model.Contacts;
import com.augustconsulting.service.ManageContactsService;



@Controller
@RequestMapping("/")
public class ManageContactsController {

	private final String landingPageViewList = "manageContactsList";
	private final String contactDetails = "manageContactsDetail";
	
	public static String specialAccess;

	@Autowired
	private ManageContactsService manageContactService;
	

	@GetMapping("/contactList")

	public String viewCustomerDetails(Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 model.addAttribute("customerDetailList", manageContactService.getAllcontactDetails());
		return new String(landingPageViewList);
	}

	@GetMapping("/contactDetails")
	public String detailsLanding(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("contacts") Contacts contactsDetails) {

		   Contacts contact=manageContactService.getAllcontactDetails(contactsDetails.getClientId());
		   
		   List<ContactSites> siteDetails=manageContactService.getSiteDetails(contactsDetails.getClientId());
		   System.out.println(siteDetails);
		   model.addAttribute("contact", contact);
		   model.addAttribute("contactSites", siteDetails);
		   


		return new String(contactDetails);
	}

	@PostMapping("/manageContactAction")
	public @ResponseBody String doActionOnManageContacts(@ModelAttribute("Contacts") Contacts contacts,
			@RequestParam("action") String action, @RequestParam("arrayContactSites") String arrayContactSites) {
		System.out.println("<><><>"+contacts.getUpdatedDate());
		String message = "";
		if (action.equals("update")) {
			manageContactService.updateManageContactHeader(contacts);
			manageContactService.updateContactSites(arrayContactSites);
			message="1";
		}

		return message;
	}

	@GetMapping("/manageContactForNewContact")
	public String getNewContactDetails(Model model, HttpServletRequest request, HttpServletResponse response) {
		return new String(contactDetails);
	}
	


	@RequestMapping(value = "/contactSiteDelete.do", method = RequestMethod.POST)
	public @ResponseBody String deleteInvoiceLineDetails(@RequestParam("action") String action,
			@ModelAttribute("ContactSites") ContactSites contactSites) {

		System.out.println("hello");
		String message = "0";
		
		if (action.equals("delete")) {

			manageContactService.deleteContactSites(contactSites);
			
				message = "1";
			
		}
		return message;
	}


}
