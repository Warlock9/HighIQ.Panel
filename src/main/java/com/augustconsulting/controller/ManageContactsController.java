package com.augustconsulting.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ManageContactsController {

	private final String landingPageViewList = "manageContactsList";
	private final String contactDetails = "manageContactsDetail";
	private static String companyNumber = null;
	public static String specialAccess;

	

	@GetMapping("/contactList")

	public String viewVendorCustomerDetails(Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		return new String(landingPageViewList);
	}

	

	

}
