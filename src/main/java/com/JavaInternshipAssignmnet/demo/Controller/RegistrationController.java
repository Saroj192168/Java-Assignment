package com.JavaInternshipAssignmnet.demo.Controller;



import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
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
	public String Store( @Valid @ModelAttribute("userData") User userData,BindingResult result,HttpServletRequest request) throws UnsupportedEncodingException, MessagingException
	{

		if(rsi.findEmail(userData.getEmail())==true)
		{
			result.addError(new FieldError("userData","email","Email Already exists"));
		}
		if(result.hasErrors())
		{
			
			return "registration";
		}
		userData.setPassword(DigestUtils.md5DigestAsHex(userData.getPassword().getBytes()));
		String random=RandomStringUtils.randomAlphanumeric(64);
		userData.setVerificationcode(random);
	    rsi.addUser(userData); 
	    String siteURL=Utility.getSiteUrl(request);
	    rsi.sendVerficationEmail(userData,siteURL);
		return "registerSuccess";
	}
	
	
	@GetMapping("verify")
	public String verifyEmail(@Param("code") String code,Model model)
	{
	   boolean verified=rsi.verifyEmail(code);
	   
	   if(verified)
	   {
	   model.addAttribute("message","Email verified successfully");
	   
	   }
	   else
	   {
		   model.addAttribute("message","Email verification Failed");
	   }
		return "emailSuccess";
	}

}
