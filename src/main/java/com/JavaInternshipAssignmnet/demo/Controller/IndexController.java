package com.JavaInternshipAssignmnet.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.JavaInternshipAssignmnet.demo.Model.User;

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
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("userData", new User());
		return "registration";
	}

}
