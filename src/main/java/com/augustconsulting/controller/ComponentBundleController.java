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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.augustconsulting.model.ComponentBundle;
import com.augustconsulting.service.ComponentBundleService;


@Controller
public class ComponentBundleController {
	
	private static final long serialVersionUID = 1L;

@Autowired
ComponentBundleService distributionServices;


public ComponentBundleController() {
 super();
 // TODO Auto-generated constructor stub
}


@GetMapping("/componentBundle")
public String botManagerLandingPage(Model model,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String st = new ViewAndOperationAccess().gettingViewAndOperationAccess(model,
		 * request,userRoleService, "ManageDistributionSet", "Manage Distribution Set");
		 * if(st==null) { return new String("redirect:/"); }
		 */
	model.addAttribute("manageDistributionSetDetails",distributionServices.fetchingDataFromDb());
	return new String("ComponentBundle");
}

@PostMapping(value = "/componentBundle.do")
public String doActions(@ModelAttribute("ComponentBundle") ComponentBundle manageDistributionSet, @RequestParam("action") String action) {
	if(action.equals("save")) {
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiii");
		distributionServices.insertingDataToDb(manageDistributionSet);
	}else if(action.equals("update")){
		distributionServices.updateDataToDb(manageDistributionSet);		
	}	
	return new String("redirect:/ComponentBundle");
}

@PostMapping(value = "/manageDistributionSet.del")
public String doDeleteAction(@RequestParam("action") String action,@RequestParam("dsName") String dsName) {
	distributionServices.deleteFromDb(dsName);
	return new String("redirect:/ComponentBundle");		
}

@PostMapping(value = "/manageDistributionSet.val")
public @ResponseBody String validatingDistributionSetName(@RequestParam("distributionSetName") String distributionSetName) {
	String msg="0";
	List<ComponentBundle> adl = distributionServices.validatingDistributionSetName(distributionSetName);
	if(adl.size()>0) {
		msg="1";
	}
	return msg;		
}

}
