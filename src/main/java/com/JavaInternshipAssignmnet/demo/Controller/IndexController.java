package com.JavaInternshipAssignmnet.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String showIndexFoem()
	{
		return "index";
	}
	
	@GetMapping("/signin")
	public String showSignInForm()
	{
		return "signin";
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm()
	{
		return "registration";
	}

}
