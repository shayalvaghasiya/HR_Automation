package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.AllowanceVO;
import com.demo.model.DesignationVO;
import com.demo.model.EmployeeVO;
import com.demo.model.LeaveVO;
import com.demo.model.LoanVO;
import com.demo.model.LoginVO;
import com.demo.model.MedicalCoverVO;
import com.demo.service.AllowanceService;
import com.demo.service.EmployeeService;
import com.demo.service.LeaveService;
import com.demo.service.LoanService;
import com.demo.service.LoginService;
import com.demo.service.MedicalCoverService;
import com.demo.service.SalaryService;

@RestController
public class ChatbotController {

	@Autowired
	LoginService loginService;

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	MedicalCoverService medicalCoverService;
	
	@Autowired
	SalaryService salaryService;
	
	@Autowired
	AllowanceService allowanceService;

	@Autowired
	LeaveService leaveService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	@RequestMapping(value = "chatbot", method = RequestMethod.POST)
	public ModelAndView chat(@RequestBody String str, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String actionname = null;
		String loginId = null;

		JSONObject returnJson = null;

		JSONObject jsonData = new JSONObject(str);
		System.out.println("123 " + jsonData);

		JSONObject result = (JSONObject) jsonData.get("result");
		 String sessionId = (String) jsonData.get("sessionId");

		 String[] dataArray = sessionId.split("/");
		 
		 loginId = dataArray[dataArray.length-1]; 
		 
		 System.out.println("LOGIN ID ::: " + loginId);
		 
		Object action = result.get("action");

		actionname = action.toString();

		EmployeeVO employeeVO = new EmployeeVO();
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(Integer.parseInt(loginId));
		
		employeeVO.setLoginVO(loginVO);
		
		List employeeList = this.employeeService.searchByLoginId(employeeVO);
		
		EmployeeVO employeeVO2 = (EmployeeVO)employeeList.get(0);
		
		DesignationVO designationVO = employeeVO2.getDesignationVO();
		
		
		if (actionname.equals("loanDetails")) {	
			
			
			List loanList = this.loanService.searchByDesId(designationVO);
			System.out.println("loanList:::"+loanList.size());
			
			LoanVO loanVO = (LoanVO)loanList.get(0);
			
			String data = "You are eligible to get a personal loan of " + loanVO.getLoanLimit() + " for "+ loanVO.getLoanTime() + "years at an interest of "+ loanVO.getLoanInterest() + "%";

			returnJson = new JSONObject();
			
			returnJson.put("speech", data);
			
			System.out.println("SPEECH ::::: " + data);
			
		}if (actionname.equals("MedicalDetails")) {	
			
			List medicalCoverList = this.medicalCoverService.searchByDesId(designationVO);
			
			MedicalCoverVO medicalCoverVO = (MedicalCoverVO) medicalCoverList.get(0);
        
			
			
			 String data = "Your medical cover amount is  " + medicalCoverVO.getMedicalcoverAmount();
			
			 returnJson = new JSONObject();
				
			returnJson.put("speech", data);
				
			
			System.out.println("HELLO");
		}if(actionname.equals("SalaryDetails")){
			
			
			List salaryList = this.allowanceService.searchBydesignationid(designationVO.getId());

			System.out.println("******* 1. SALARY SIZE : *******" + salaryList.size());

			String speechText = "";

			String basicSalary = "";
			
			List allowanceList = new ArrayList<>();
			List deductionList = new ArrayList<>();

			for (int i = 0; i < salaryList.size(); i++) {
		
				AllowanceVO	 allowanceVO = (AllowanceVO) salaryList.get(i);
				
				basicSalary = 	allowanceVO.getSalaryBasicSalary();
				
				String deductionType = 	allowanceVO.getAllowORded();
			
				if (deductionType.equals("allowance")) {
					allowanceList.add(allowanceVO);
				}
				if (deductionType.equals("deduction")) {
					deductionList.add(allowanceVO);				
				}
			}


			/******************************************************************************/
			
			String allowance = "";
			String deduction = "";
			
			Double grandTotal = 0.0d;
			Double netPayable = 0.0d;
			Double total = 0.0d;
			
			int bs = Integer.parseInt(basicSalary);
			
			grandTotal = grandTotal + bs;
			
			System.out.println("****************allowances*************************");
			
			for(int i = 0 ; i < allowanceList.size(); i++){
				AllowanceVO allowanceVO = (AllowanceVO) allowanceList.get(i);
				
				String allowanceType =	allowanceVO.getAllowance_dedType();
				int limit = Integer.parseInt(allowanceVO.getAllowance_dedLimit());
			
				
				double d= ( bs * limit) / 100;
				
				String data = "  " +  allowanceType + "  : " + d; 
			
				System.out.println(data);
			
			allowance = allowance + " \n"  + data ;
			
			grandTotal = grandTotal +  d;
			
			}
			
			
			System.out.println("****************DEDUCTION*************************");
			
			
			for(int j = 0 ; j < deductionList.size() ; j++){
				
				AllowanceVO allowanceVO = (AllowanceVO) deductionList.get(j);
				String deductionType = allowanceVO.getAllowance_dedType();
				int limit = Integer.parseInt(allowanceVO.getAllowance_dedLimit());
				
				double d= ( bs * limit) / 100;
				
				total = total + d ;
				
				String data = "  " +deductionType + "  : " + d; 
			
				System.out.println(data);
			
				deduction = deduction + " \n" + data ;
			}
			
			netPayable = grandTotal - total ; 
			
			System.out.println(allowance);
			System.out.println(deduction);

			/************************************************************************************************/		
			 speechText = "Your salary details are"+","+" Basic salary : "+bs+","+" Allowances :"+allowance+" , "
			+"Deductions :"+deduction+" , "+" Net Payable : "+netPayable;
	            
			returnJson = new JSONObject();
			
			returnJson.put("speech", speechText);
			
		}if(actionname.equals("LeaveDetails")){
			
			String speechText = "You are allowed ";
			
	        List leaveList = this.leaveService.search();
	        
	        for (int i = 0  ; i< leaveList.size() ; i++) {
				LeaveVO leaveVO = (LeaveVO) leaveList.get(i);
				speechText = speechText + leaveVO.getLeaveDays() + " " +leaveVO.getLeaveType();
				
				if(i < leaveList.size() - 1 ){
					speechText = speechText + " AND "  ; 	
				}
	        }
	        	returnJson = new JSONObject();
	        	returnJson.put("speech", speechText);
		}if(actionname.equals("Allowance")){
			
			String speechText = "";
			String type = "";
			String limit ="";
			
			
			List ls = allowanceService.searchBydesignationid(designationVO.getId());
			
			for(Object obj : ls){
				AllowanceVO allowanceVO = (AllowanceVO)obj;
				
				if(allowanceVO.getAllowORded().equals("allowance")){
					type = allowanceVO.getAllowance_dedType();
					System.out.println("Type************" + type);
					limit = allowanceVO.getAllowance_dedLimit();
					System.out.println("Limit***********" + limit);

					speechText = speechText + "," + type + " : " + limit;					
				}
			}
			
			speechText = "Your allowances are" + speechText;
		 	returnJson = new JSONObject();
        	returnJson.put("speech", speechText);
			
		}if(actionname.equals("Deduction")){
			
			String speechText = "";
			String type = "";
			String limit ="";
			
			
			List ls = allowanceService.searchBydesignationid(designationVO.getId());
			
			for(Object obj : ls){
				AllowanceVO allowanceVO = (AllowanceVO)obj;
				
				if(allowanceVO.getAllowORded().equals("deduction")){
					type = allowanceVO.getAllowance_dedType();
					System.out.println("Type************" + type);
					limit = allowanceVO.getAllowance_dedLimit();
					System.out.println("Limit***********" + limit);

					speechText = speechText + "," + type + " : " + limit;					
				}
			}
			
			speechText = "Your deductions are" + speechText;
		 	returnJson = new JSONObject();
        	returnJson.put("speech", speechText);
			
		}if(actionname.equals("AllowancesAndDeductions")){

			String speechText = "";
			String speechText1 = " & your allowances are";
			
			String type = "";
			String limit ="";
			
			
			List ls = allowanceService.searchBydesignationid(designationVO.getId());
			
			for(Object obj : ls){
				AllowanceVO allowanceVO = (AllowanceVO)obj;
				
				if(allowanceVO.getAllowORded().equals("deduction")){
					type = allowanceVO.getAllowance_dedType();
					System.out.println("Type************" + type);
					limit = allowanceVO.getAllowance_dedLimit();
					System.out.println("Limit***********" + limit);

					speechText = speechText + "," + type + " : " + limit;					
				}
			}
			for(Object obj : ls){
				AllowanceVO allowanceVO = (AllowanceVO)obj;
				
				if(allowanceVO.getAllowORded().equals("allowance")){
					type = allowanceVO.getAllowance_dedType();
					System.out.println("Type************" + type);
					limit = allowanceVO.getAllowance_dedLimit();
					System.out.println("Limit***********" + limit);

					speechText1 = speechText1 + "," + type + " : " + limit;					
				}
			}
			
			speechText = "Your deductions are" + speechText;
		 	
			speechText = speechText + speechText1;
			
			returnJson = new JSONObject();
        	returnJson.put("speech", speechText);
			
			
		}		
		return new ModelAndView("employee/chatJson", 
				"json", returnJson);
	}

}	

