package com.augustconsulting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.augustconsulting.model.ManageUsers;
import com.augustconsulting.service.ManageUsersService;
import com.augustconsulting.service.UsersRoleService;
import com.augustconsulting.utility.ViewAndOperationAccess;

/**
 * Servlet implementation class ManageUsersController
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping("/")
@WebServlet("/ManageUsersController")
public class ManageUsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Autowired
	private ManageUsersService manageUserService;

	@Autowired
	private UsersRoleService userRoleService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageUsersController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/manageUsers")
	public String ManageUserslanding(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String st = new ViewAndOperationAccess().gettingViewAndOperationAccess(model, request,userRoleService, "manageUsers", "Manage Users");			
		
		  System.out.println(st+">>>>>>>>>>>>>>>>>.");
		if(st==null) {
			return new String("redirect:/");
		}
		
		model.addAttribute("distinctRoleDist", userRoleService.fetchingDistinctRole());
		System.out.println( userRoleService.fetchingDistinctRole()+" >??>?>?");
		model.addAttribute("userDetailList", manageUserService.fetchingUsersDetails());
		

		return new String("ManageUsers");
	}

	@RequestMapping(value = "/manageUsers.do", method = RequestMethod.POST)
	public String doActions(@RequestParam("action") String action, @RequestParam("userName") String userName,
			@RequestParam("password") String password, @RequestParam("userEmailId") String userEmailId,
			@RequestParam("userFirstName") String userFirstName, @RequestParam("userLastName") String userLastName,
			@RequestParam("role") String role) {
		// @RequestParam("assignedBotID") String assignedBotID) {
		ManageUsers manageUsers = new ManageUsers();
		if (action.equals("save")) {
			manageUsers.setUserName(userName);
			manageUsers.setPassword(password);
			manageUsers.setUserEmailId(userEmailId);
			manageUsers.setUserFirstName(userFirstName);
			manageUsers.setUserLastName(userLastName);
			// manageUsers.setAssignedBotId(assignedBotID);
			manageUsers.setRole(role);
			/*
			 * if (windowsAuthentication.equals("Yes")) {
			 * manageUsers.setWindowsAuthentication("Y"); } else if
			 * (windowsAuthentication.equals("No")) {
			 * manageUsers.setWindowsAuthentication("N"); }
			 */

			manageUserService.insertingUserDetailtoDb(manageUsers);
		} else if (action.equals("update")) {
			manageUsers.setUserName(userName);
			manageUsers.setPassword(password);
			manageUsers.setUserEmailId(userEmailId);
			manageUsers.setUserFirstName(userFirstName);
			manageUsers.setUserLastName(userLastName);
			// manageUsers.setAssignedBotId(assignedBotID);
			manageUsers.setRole(role);
			/*
			 * if (windowsAuthentication.equals("Yes")) {
			 * manageUsers.setWindowsAuthentication("Y"); } else if
			 * (windowsAuthentication.equals("No")) {
			 * manageUsers.setWindowsAuthentication("N"); }
			 */			manageUserService.updateUserDetails(manageUsers);
		}
		return new String("redirect:/manageUsers");
	}

	@RequestMapping(value = "/manageUsers.del", method = RequestMethod.POST)
	public String doActions(@RequestParam("action") String action, @RequestParam("userName") String userName) {
		if (action.equals("delete")) {
			manageUserService.deleteUserDetailsFromDb(userName);
		}
		return new String("redirect:/manageUsers");
	}

	@RequestMapping(value = "/validatingUserAndEmail", method = RequestMethod.POST)
	public @ResponseBody String userNameAndEmailValidation(String userName, String userEmail) {
		String message = "noResponse";
		List<ManageUsers> li = manageUserService.validatingUserAndEmail(userName, userEmail);
		if (li.size() > 0) {
			for (ManageUsers mu : li) {
				if (mu.getUserName().equals(userName)) {
					message = userName;
				} else if (mu.getUserEmailId().equals(userEmail)) {
					message = userEmail;
				}
			}
		}
		return message;
	}

	@RequestMapping(value="/validateEmailOnUpdate",method=RequestMethod.POST)
	public @ResponseBody String EmailValidation(String userName, String userEmail) {
		String message="noResponse";
		List<ManageUsers> li = manageUserService.validatingEmail(userName, userEmail);
		if(li.size()>0) {
			for(ManageUsers mu : li) {
			if(mu.getUserEmailId().trim().equals(userEmail.trim()) && !mu.getUserName().trim().equals(userName.trim())) {
					message=userEmail;
					break;
				}
			}
		}
		return message;
	}
}
