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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.augustconsulting.model.ManageCostCenter;
import com.augustconsulting.model.UsersRole;
import com.augustconsulting.service.ManageCostCenterService;
import com.augustconsulting.service.UsersRoleService;
import com.augustconsulting.utility.ViewAndOperationAccess;


@Controller
@RequestMapping("/")
@WebServlet("/ManageCostCenterController")
public class ManageCostCenterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private ManageCostCenterService manageCostCenterService;
	
	@Autowired
	private UsersRoleService userRoleService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageCostCenterController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@GetMapping("/CostCenterManager")
	public String botManagerLandingPage(Model model,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new ViewAndOperationAccess().gettingViewAndOperationAccess(model, request,userRoleService, "CostCenterManager", "Manage Cost Center");				
		model.addAttribute("manageCostCenterDetails",manageCostCenterService.fetchingDataFromDb());
		return new String("CostCenterManager");
	}
    
	@RequestMapping(value = "/costCenterManager.do", method = RequestMethod.POST)
	public  String doActions(@ModelAttribute("manageCostCenter") ManageCostCenter manageCostCenter, @RequestParam("action") String action) {

		if(action.equals("save")) {
			manageCostCenterService.insertingDataToDb(manageCostCenter);
		}else if(action.equals("update")) {
			manageCostCenterService.updateDataToDb(manageCostCenter);
		}else if(action.equals("delete")) {
			manageCostCenterService.deleteFromDb(manageCostCenter);
		}
		
		return new String("redirect:/CostCenterManager");
	}
	@RequestMapping(value="/costCenterNumValidation.do", method=RequestMethod.POST)
	public @ResponseBody String doValidation(@RequestParam("costCenterNum") String costCenterNum) {
		String message="";
		if(costCenterNum!="") {
			List<ManageCostCenter> li = manageCostCenterService.validatingCostCenterNumber(costCenterNum);
			if(li.size()>0) {
				message="1";
			}else {message="0";}
		}
		return message;
	}
}
