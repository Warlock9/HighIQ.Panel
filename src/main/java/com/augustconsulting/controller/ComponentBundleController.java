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
	return new String("ComponentBundle");
}

@PostMapping("/ComponentBundle.do")
public String doActions(@ModelAttribute("ComponentBundle") ComponentBundle manageSet, @RequestParam("action") String action,@RequestParam("cDate") java.sql.Date cdate) {
	System.out.println("fsdakjffffffffffff");
	if(action.equals("save")) {	 
		System.out.println("saaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvv");
		
		services.insertingDataToDb(manageSet);
	}else if(action.equals("update")){
		System.out.println("updaaaaaaaaaaaateeeeeeeeeeeeeeeeeeeeeeee");
		manageSet.setCreatedDate(cdate);
		services.updateDataToDb(manageSet);		
	}
	return new String("redirect:/componentBundle");
}

@PostMapping("/componentBundle.del")
public String doDeleteAction(@RequestParam("action") String action,@RequestParam("id") String id) {
	System.out.println("fdsafasdfsafasdfllllllllllllllllllllllllllll");
	services.deleteFromDb(id);
	return new String("redirect:/componentBundle");		
}

	
	@PostMapping("/componentBundle.val")
	public @ResponseBody String validatingDistributionSetName(
			@RequestParam("distributionSetName") String distributionSetName) {
		String msg = "0";
		List<ComponentBundle> adl = services.validatingDistributionSetName(distributionSetName);
		if (adl.size() > 0) {
			msg = "1";
		}
		return msg;
	}
	 
	/*
	 * @RequestMapping(value = "/FetchComponent.du", method = RequestMethod.POST)
	 * public @ResponseBody String doActionBot(@ModelAttribute("botparamerter")
	 * ManageBotParameter botparameter,@ModelAttribute("botParameterMaster")
	 * BotParameterMaster botParameterMaster,
	 * 
	 * @RequestParam("action") String action, @RequestParam("botId") String botId) {
	 * String message=""; if (action.equals("onSelectBotId")) { StringBuilder sb =
	 * new StringBuilder(); List<BotParameterMaster> li =
	 * botParmaterService.fetchingParameterNameAndValues(botParameterMaster.
	 * getBotType(), botId); if (li != null) { for(BotParameterMaster ab:li) {
	 * sb.append("<div class=\"form-group row\">\r\n" +
	 * "   <div class=\"col-sm-2\">\r\n" +
	 * "      <input type=\"text\" class=\"form-control text-right  \" value='"+ab.
	 * getParameterName()+"' id=\"fname\" name=\"parameterName[]\"  readonly>\r\n" +
	 * "   </div>\r\n" + "   <div class=\"col-sm-5\">\r\n" +
	 * "      <input type=\"text\" class=\"form-control\" id=\"fname\" name=\"parameterDescription[]\" value='"
	 * +ab.getParameterDescription()+"'  readonly>\r\n" + "   </div>\r\n" +
	 * "   <div class=\"col-sm-5\">\r\n" +
	 * "      <input type=\"text\" class=\"form-control "+ab.getParameterName()
	 * +" \" id=\"fname\" name=\"parameterValue[]\" value='"+ab.getParameterValue()
	 * +"' >\r\n" + "   </div>\r\n" + "</div>"); } } message = sb.toString(); }
	 * return message; }
	 */

}
