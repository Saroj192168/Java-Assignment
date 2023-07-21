package com.JavaInternshipAssignmnet.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.JavaInternshipAssignmnet.demo.Model.User;
import com.JavaInternshipAssignmnet.demo.ServiceImp.SigninServiceImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class SignInController {
	@Autowired
	private SigninServiceImp ssi;
	
	
	@GetMapping("/signin")
	public String showSignInForm(Model model)
	{
		model.addAttribute("message","");
		return "signin";
	}
	
	
	
	@PostMapping("/signin")
	public String login(@ModelAttribute User userData,Model model,HttpSession session )
	{
		userData.setPassword(DigestUtils.md5DigestAsHex(userData.getPassword().getBytes()));
		User u=ssi.getEmailandPasssword(userData.getEmail(),userData.getPassword());
		if(u!=null)
		{
			if(u.getEnable()==0)
			{
				model.addAttribute("message","Email has not been verified");
				return "signin";
			}
			session.setAttribute("id", u.getId());
			session.setMaxInactiveInterval(300);
			 return "redirect:/dashboard";
		}
		if(userData.getEnable()==0)
		{
			
		}
		model.addAttribute("message","Credential Donot Match");
		return "signin";
		
	}
	
	@GetMapping("/signout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/signin";
	}

}
