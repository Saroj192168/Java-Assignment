package com.JavaInternshipAssignmnet.demo.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.JavaInternshipAssignmnet.demo.Model.User;
import com.JavaInternshipAssignmnet.demo.ServiceImp.RegistrationServiceImp;
import com.JavaInternshipAssignmnet.demo.ServiceImp.UserServiceImp;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationServiceImp rsi;
	
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("userData", new User());
		return "registration";
	}
	
	
	
	@PostMapping("/register")
	public String Store( @Valid @ModelAttribute("userData") User userData,BindingResult result)
	{
	  System.out.println(rsi.findEmail(userData.getEmail()));
		if(rsi.findEmail(userData.getEmail())==true)
		{
			result.addError(new FieldError("userData","email","Email Already exists"));
		}
		if(result.hasErrors())
		{
			
			return "registration";
		}
		userData.setPassword(DigestUtils.md5DigestAsHex(userData.getPassword().getBytes()));
	    rsi.addUser(userData);     	
		return "registerSuccess";
	}

}