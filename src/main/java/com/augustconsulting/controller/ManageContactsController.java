package com.augustconsulting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.augustconsulting.model.Contacts;


@Controller
@RequestMapping("/")
public class ManageContactsController {

	private final String landingPageViewList = "manageContactsList";
	private final String contactDetails = "manageContactsDetail";
	
	public static String specialAccess;

	

	@GetMapping("/contactList")

	public String viewVendorCustomerDetails(Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		return new String(landingPageViewList);
	}

	@GetMapping("/contactDetails")
	public String detailsLanding(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("contacts") Contacts contactsDetails) {



		return new String(contactDetails);
	}


	

}
