package com.augustconsulting.utility;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import com.augustconsulting.controller.MainController;
import com.augustconsulting.model.UsersRole;
import com.augustconsulting.service.UsersRoleService;

public class ViewAndOperationAccess  {
	
	public String gettingViewAndOperationAccess(Model model, HttpServletRequest request,UsersRoleService userRoleService, String pageToRedirect, String formName) {
		HttpSession sessionsa = request.getSession(false);
		String specialAccess="";
			try {
				String userRole = (String) sessionsa.getAttribute("uRole");
				userRole.toString();
				model.addAttribute("userName", (String) sessionsa.getAttribute("uUserName"));
				model.addAttribute("userFirstName", (String) sessionsa.getAttribute("uFirstName"));
				model.addAttribute("userLastName", (String) sessionsa.getAttribute("uLastName"));
				
				List<UsersRole> uli = userRoleService.fetchingSelectedRole(userRole);
				
				for(UsersRole ur : uli) {
					String accessName = ur.getAccessName();
					if(accessName.equals(formName)) {
	    				model.addAttribute("createAccess", ur.getCreateAccess());
	    				model.addAttribute("editAccess", ur.getEditAccess());
	    				model.addAttribute("deleteAccess", ur.getDeleteAccess());
	    				specialAccess = "true";
					}
					switch(accessName){
						case "Digital Worker Sales":
							model.addAttribute("digitalWorkerViewAccess",ur.getViewAccess());
						break;
						case "Manage Customer":
							model.addAttribute("manageCustomerViewAccess",ur.getViewAccess());
						break;
						case "Manage Component Bundle":
							model.addAttribute("manageComponentViewAccess",ur.getViewAccess());
						break;
						case "Manage Users":
							model.addAttribute("usersViewAccess",ur.getViewAccess());
						break;
						case "Manage User Roles":
							model.addAttribute("rolesViewAccess",ur.getViewAccess());
						break;
						
						
					}	//
				}
			}catch(NullPointerException ne) {
				MainController.pageUrlToRedirect=pageToRedirect;
				return null;
			}
			return specialAccess;
	}

}
