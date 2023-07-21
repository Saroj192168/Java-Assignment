package com.JavaInternshipAssignmnet.demo.Controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.JavaInternshipAssignmnet.demo.Model.User;
import com.JavaInternshipAssignmnet.demo.ServiceImp.UserServiceImp;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImp usi;
	
	@PostMapping("/register")
	public String Store( @Valid @ModelAttribute("userData") User userData,BindingResult result)
	{
	  System.out.println(usi.findEmail(userData.getEmail()));
		if(usi.findEmail(userData.getEmail())==true)
		{
			result.addError(new FieldError("userData","email","Email Already exists"));
		}
		if(result.hasErrors())
		{
			
			return "registration";
		}
		userData.setPassword(DigestUtils.md5DigestAsHex(userData.getPassword().getBytes()));
	    usi.addUser(userData);     	
		return "redirect:/signin";
	}

}
