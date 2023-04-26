package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.demo.model.FeedbackVO;
import com.demo.service.FeedbackService;

@Controller
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;

	
	@RequestMapping(value="employee/loadFeedback",method=RequestMethod.GET)
	public ModelAndView loadFeedback(){
		return new ModelAndView("employee/addFeedback","FeedbackVO",new FeedbackVO());	
	}

	
	@RequestMapping(value="employee/insertFeedback",method=RequestMethod.POST)
	public ModelAndView insertFeedback(@ModelAttribute FeedbackVO feedbackVO){
		
		
		feedbackVO.setStatus(true);
		this.feedbackService.insert(feedbackVO);
		return new ModelAndView("redirect:/employee/loadFeedback");	
	}

	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="admin/viewFeedback",method=RequestMethod.GET)
	public ModelAndView viewFeedback(){
		List feedbackList = this.feedbackService.search();
		return new ModelAndView("admin/viewFeedback","feedbackList",feedbackList);	
	}
	

}
