package com.augustconsulting.controller;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	

}
