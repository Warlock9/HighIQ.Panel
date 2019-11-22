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

import com.augustconsulting.model.BundleComponentRelation;
import com.augustconsulting.model.ComponentBundle;
import com.augustconsulting.service.ComponentBundleService; 


@Controller
public class ComponentBundleController {
	
	private static final long serialVersionUID = 1L;

@Autowired
ComponentBundleService services;




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
	model.addAttribute("setDetails",services.fetchingDataFromDb());
	model.addAttribute("relationDetails",services.fetchingDataFromRelation());
	return new String("ComponentBundle");
}

@PostMapping("/ComponentBundle.do")
public String doActions(@ModelAttribute("ComponentBundle") ComponentBundle manageSet, @RequestParam("action") String action,@RequestParam("cDate") java.sql.Date cdate,@RequestParam("ComponentList") List<String> componentSkuList ) {
	System.out.println("fsdakjffffffffffff");
	
	if(action.equals("save")) {	 
		
		System.out.println("saaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvv");
		if(componentSkuList != null)
		{
			
			for(String componentSku:componentSkuList) {
				BundleComponentRelation rs = new BundleComponentRelation();
				rs.setComponentSKUs(componentSku);
				rs.setBundleSKU(manageSet.getSkuCode());
				services.insertDataToRelation(rs);
			}
				
		}
		services.insertingDataToDb(manageSet);
	}else if(action.equals("update")){
		if(manageSet.getType().equals("Bundle"))
		{
			System.out.println("rrrrrrrrrrriiiiiiissssssssabbbbbbbbb");
			services.deleteFromRelationDb(manageSet.getSkuCode());
			if(componentSkuList != null)
			{
				
				for(String componentSku:componentSkuList) {
					BundleComponentRelation rs = new BundleComponentRelation();
					rs.setComponentSKUs(componentSku);
					rs.setBundleSKU(manageSet.getSkuCode());
					services.insertDataToRelation(rs);
				}
					
			}
		}
		System.out.println("updaaaaaaaaaaaateeeeeeeeeeeeeeeeeeeeeeee");
		manageSet.setCreatedDate(cdate);
		services.updateDataToDb(manageSet);		
	}
	return new String("redirect:/componentBundle");
}

@PostMapping("/componentBundle.del")
public String doDeleteAction(@RequestParam("action") String action,@RequestParam("id") String id) {
	System.out.println("fdsafasdfsafasdfllllllllllllllllllllllllllll");
	services.deleteFromRelationDb(id);
	services.deleteFromDb(id);
	return new String("redirect:/componentBundle");		
}

	

/* get components by SKU */
@PostMapping("/getComponents.do")
public @ResponseBody String getComponents(@RequestParam("skuCode") String skuCode) {
	String response = "";
	List<String>li=services.getComponent(skuCode);
	System.out.println(li);
	List<ComponentBundle>com=services.getComponentName(li);
	System.out.println(com+" ??????????");
	StringBuilder sb = new StringBuilder();
	sb.append("<label for=\"lname\"\r\n" + 
			"class=\"col-sm-2 text-right control-label col-form-label\">Components In Bundle</label>\r\n" + 
			"<div class=\"col-sm-3\">");
	sb.append("<select readonly name=\"Component\"\r\n" + 
			"class=\"form-control custom-select\" required>\r\n" + 
			"<option>Components In Bundle</option>");
	  for(ComponentBundle c:com) {
		 sb.append("<option>"+c.getComponentBundleName()+"</option>");
	  }
	sb.append("</select>");
	sb.append("</div>");
	response=sb.toString();
	return response;
}
}
