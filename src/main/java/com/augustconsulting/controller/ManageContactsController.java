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

import com.augustconsulting.model.CustomerSites;
import com.augustconsulting.model.CustomerDetails;
import com.augustconsulting.service.ManageContactsService;

@Controller
@RequestMapping("/")
public class ManageContactsController {

	private static String clientId;
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
			@ModelAttribute("contacts") CustomerDetails contactsDetails) {

		CustomerDetails contact = manageContactService.getAllcontactDetails(contactsDetails.getClientId());

		List<CustomerSites> siteDetails = manageContactService.getSiteDetails(String.valueOf(contactsDetails.getClientId()));
		System.out.println(siteDetails);
		model.addAttribute("contact", contact);
		model.addAttribute("contactSites", siteDetails);
		return new String(contactDetails);
	}

	@PostMapping("/manageContactAction")
	public @ResponseBody String doActionOnManageContacts(@ModelAttribute("Contacts") CustomerDetails contacts,
			@RequestParam("action") String action, @RequestParam("arrayContactSites") String arrayContactSites) {
		String message = "";
		if (action.equals("update")) {
			manageContactService.updateManageContactHeader(contacts);
			clientId=String.valueOf(contacts.getClientId());
			manageContactService.updateContactSites(arrayContactSites,clientId);
			message = "1";
		}

		return message;
	}

	@GetMapping("/manageContactForNewContact")
	public String getNewContactDetails(Model model, HttpServletRequest request, HttpServletResponse response) {
		return new String(contactDetails);
	}

	@RequestMapping(value = "/contactSiteDelete.do", method = RequestMethod.POST)
	public @ResponseBody String deleteInvoiceLineDetails(@RequestParam("action") String action,
			@ModelAttribute("ContactSites") CustomerSites contactSites) {

		String message = "0";

		System.out.println(contactSites.getClientId()+" ?????????????");
		if (action.equals("delete")) {

			manageContactService.deleteContactSites(contactSites);

			message = "1";

		}
		
		return message;
	}

	@RequestMapping(value = "/deleteCustomerList", method = RequestMethod.POST)
	public String deleteCustomerList(@RequestParam("action") String action,
			@ModelAttribute("Contacts") CustomerDetails contact) {
		System.out.println(contact.getClientId());
		manageContactService.deleteCustomerDetails(contact);

		return new String("redirect:/contactList");
	}

}
