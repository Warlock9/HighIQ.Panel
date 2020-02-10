package com.augustconsulting.controller;

import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.augustconsulting.model.UsersRole;
import com.augustconsulting.service.UsersRoleService;
import com.augustconsulting.utility.ViewAndOperationAccess;

/**
 * Servlet implementation class UsersRoleController
 */
@Controller
@RequestMapping("/")
@WebServlet("/UsersRoleController")
public class UsersRoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsersRoleService userRoleService;

	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersRoleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/usersRole")
	public String userRoleLanding(Model model, HttpServletRequest request, HttpServletResponse response, String userRole) {

		String st = new ViewAndOperationAccess().gettingViewAndOperationAccess(model, request,userRoleService, "usersRole", "Manage User Roles");			
		if(st==null) {
			return new String("redirect:/");
		}

		model.addAttribute("accessNameList", userRoleService.fetchingAccessNameList());
		
		System.out.println(userRoleService.fetchingDistinctRole()+" >>>>>>>>>>>>");
		
		model.addAttribute("distinctRoleDist", userRoleService.fetchingDistinctRole());
		List<UsersRole> li = userRoleService.fetchingSelectedRole(userRole);
		model.addAttribute("retrievedRoles",li);
		model.addAttribute("selectedRole",li.get(0).getRole());
		System.out.println(li+">>>>>>>>><>>>>>>>>>>>>>");
	//	model.addAttribute("selectedSpecialAccess", li.get(0).getSpecialAccess());
		return new String("ManageUsersRole");
	}


	@RequestMapping(value = "/usersRole.do", method = RequestMethod.POST)
	public String doActions(@RequestParam("action") String action, @RequestParam("role") String role,@RequestParam("id[]") int id[],
			/* @RequestParam("specialAccess") String specialAccess, */ @RequestParam("accessName[]") String accessName[],
			@RequestParam("viewAccess[]") String viewAccess[], @RequestParam("createAccess[]") String createAccess[],
			@RequestParam("editAccess[]") String editAccess[], @RequestParam("deleteAccess[]") String deleteAccess[]
			/*@RequestParam("approveAccess[]") String approveAccess[]*/) {
			

		if (action.equals("save")) {
			for (int i = 0; i < accessName.length; i++) {
				UsersRole ur = new UsersRole();
				ur.setRole(role);
				ur.setId(id[i]);
				/* ur.setSpecialAccess(specialAccess); */
				ur.setAccessName(accessName[i]);
				ur.setViewAccess(viewAccess[i]);
				ur.setCreateAccess(createAccess[i]);
				ur.setEditAccess(editAccess[i]);
				ur.setDeleteAccess(deleteAccess[i]);
				/* ur.setApproveAccess(approveAccess[i]); */
				userRoleService.insertingRoleDetailsToDb(ur);
			}
		}
		return new String("redirect:/usersRole");
	}



	@RequestMapping(value = "/userRoleValidate.do", method = RequestMethod.POST)
	public @ResponseBody String userRoleValidation(@RequestParam("role") String role) {
		String message = "";
		List<String> li = userRoleService.userRoleValidation();
		   for(String duplicateRole:li) {
			  if(duplicateRole.equals(role)) {
				 message="1";
			  }
		   }
		return message;
	}
	
	@RequestMapping(value = "/usersRoleSelect.do", method = RequestMethod.POST)
	public String selectedUserRole(@RequestParam("role[]") String[] role, Model model, HttpServletRequest request, HttpServletResponse response) {
		if(role.length==1) {
			return userRoleLanding(model, request, response, role[0]); }
		else if(role.length==2){
			userRoleService.deleteRoles(role[1]);
		}
		return new String("redirect:/usersRole");
	}
}
