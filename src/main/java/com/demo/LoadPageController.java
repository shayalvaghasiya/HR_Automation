package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoadPageController {
	
	@RequestMapping(value={"/","login"})
	public String loadAdmin(){
		return "login";
	}
	
}
