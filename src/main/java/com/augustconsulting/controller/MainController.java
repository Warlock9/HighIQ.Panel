	package com.augustconsulting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.augustconsulting.model.ManageUsers;
import com.augustconsulting.service.DwSalesService;
import com.augustconsulting.service.ManageContactsService;
import com.augustconsulting.service.ManageUsersService;
import com.augustconsulting.service.UsersRoleService;
import com.augustconsulting.utility.ViewAndOperationAccess;

@Controller

public class MainController {

	@Autowired
	private ManageUsersService manageUserService;
	
	@Autowired
	private UsersRoleService userRoleService;
	
	@Autowired
	private DwSalesService dwSales;
	
	@Autowired
	private ManageContactsService contactService;

	private static String result = "";
	
	public static String pageUrlToRedirect="dashboard";
	

	@RequestMapping("/")
	public String mainLandingPageonLogout(Model model) {
		
		model.addAttribute("userCredentials",result);
		result = "";
		return new String("index");
	}
	
	@RequestMapping("/dashboard")
	public String dahsBoardLandingPage(HttpServletRequest request, HttpServletResponse response, Model model) {
    	String st = new ViewAndOperationAccess().gettingViewAndOperationAccess(model, request,userRoleService, "dashboard", "");
		if(st==null) {
			return new String("redirect:/");
		}
		model.addAttribute("totalRegisterCustomer", contactService.getTotalRegisterCustomerCount());
		model.addAttribute("totalActiveLicense",dwSales.getActiveLicences());
		model.addAttribute("totalActiveLicenseCurrentMonth",dwSales.getGeneratedLincenseCurrentMonth());

    	return new String("dashboard");
	}
	
	@RequestMapping(value="/userLogin.do", method=RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
		String action = request.getParameter("action");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("password");
		if(action.equals("save")) {
			ManageUsers manageUsers = new ManageUsers();
			manageUsers.setUserName(userName);
			manageUsers.setPassword(pass);
			HttpSession session=request.getSession();  
			List<ManageUsers> li = manageUserService.userLoginAttempt(manageUsers);
			if(li.size()>0) {
				for(ManageUsers mu : li) { 
					session.setAttribute("uRole", mu.getRole());
				    session.setAttribute("uEmail", mu.getUserEmailId());
				    session.setAttribute("uUserName", mu.getUserName());
				    session.setAttribute("uFirstName", mu.getUserFirstName());
				    session.setAttribute("uLastName", mu.getUserLastName());
				    result="";
					return new String("redirect:/"+pageUrlToRedirect);
				}
			}else {
					result="incorrect";
			} 
		}
					return new String("redirect:/");
	}
	
	@RequestMapping(value="/logOut.do",method=RequestMethod.GET)
	public String doLogout(HttpServletRequest request,@RequestParam("logOut") String logOut) {
		pageUrlToRedirect="dashboard";
		HttpSession sessionsa = request.getSession(false);
		try {
			sessionsa.invalidate();
	
		} catch (NullPointerException ex) {
			return new String("redirect:/");
		}
		return new String("redirect:/");
	}
}	