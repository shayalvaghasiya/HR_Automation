package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.LoginVO;
import com.demo.service.EmployeeService;
import com.demo.service.LoginService;
import com.demo.service.SalaryService;
import com.demo.utils.BaseMethods;
import com.sun.mail.imap.protocol.BASE64MailboxDecoder;

@SuppressWarnings("unused")
@Controller
public class MainController extends BaseMethods{

	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	SalaryService salaryService;
	
	@Autowired
	LoginService loginService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/index")
	public ModelAndView loadAdmin(){
		List employeeList = employeeService.searchForGraph();
		List salaryList = salaryService.searchForGraph();

		System.out.println(employeeList.size());
		System.out.println(salaryList.size());
		
		
		
		return  new ModelAndView("admin/index").addObject("employeeList",employeeList).addObject("salaryList",salaryList);
}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="employee/index")
	public ModelAndView loadEmployee(HttpSession session){
		List employeeList = employeeService.searchForGraph();
		List salaryList = salaryService.searchForGraph();


		System.out.println(employeeList.size());
		System.out.println(salaryList.size());

		String userName = BaseMethods.getCurrentUser();
		
		List  loginList = this.loginService.searchByUserName(userName);
		
		LoginVO loginVO = (LoginVO)loginList.get(0);
		 
		
		session.setAttribute("loginId", loginVO.getId());
		
		return new ModelAndView ("employee/index").addObject("employeeList",employeeList).addObject("salaryList",salaryList);
		}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})	
	public String viewUserDetails(ModelMap model,HttpServletResponse response,HttpServletRequest request) {

		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            request.getSession().invalidate();
	            request.getSession().setAttribute("tempStatus", "success");
	            request.getSession().setAttribute("statusText", "Logout Successfully!");
	        }
	        return "login";
	}
	
	@RequestMapping(value="step1", method= RequestMethod.GET)
	public ModelAndView step1(@ModelAttribute LoginVO loginVO)
	{
		return new ModelAndView("forgotPassword");
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="searchstep1",method = RequestMethod.POST)
	public ModelAndView searchstep1(@RequestParam("username") String un,LoginVO loginVO,HttpSession session)
	{
		System.out.println("USERNAME>>>"+un);
		session.setAttribute("username", un);
		loginVO.setUserName(un);

		List ls=this.loginService.searchstep1(loginVO);
		System.out.println("List size>>>>>>>>>"+ls.size());
		if(ls!=null && !ls.isEmpty())
		{
			int OTP=generateOTP(4);
			System.out.println("OTP>>>>>"+OTP);
			String subject="otp";
			String content="otp:"+OTP;
			sendMail1(un,subject, content);
			session.setAttribute("generatedOTP",OTP);
			return new ModelAndView("editPassword");
		}
		else
		{
			return new ModelAndView("redirect:/");	
		}   
	}
	@RequestMapping(value="step2", method = RequestMethod.POST)
	public ModelAndView step2(@RequestParam("password") String pwd ,LoginVO loginVO,HttpSession session)
	{
		String userName= (String)session.getAttribute("username");
		loginVO.setUserName(userName);
		loginVO.setPassword(pwd);
		
		this.loginService.updatePassword(loginVO);
		return new ModelAndView("redirect:/");
	}
	
}
