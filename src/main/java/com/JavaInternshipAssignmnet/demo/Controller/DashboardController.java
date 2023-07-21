package com.JavaInternshipAssignmnet.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.JavaInternshipAssignmnet.demo.ServiceImp.UserServiceImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {
	
	@Autowired
	private UserServiceImp usi;
	
	
	//Landing page after login
	@GetMapping("/dashboard")
	public String showDashboard(HttpSession session,Model model)
	{
		System.out.println(session.getAttribute("id"));
		if(session.getAttribute("id")==null)
		{
			return "redirect:/signin";
		}
		Long user_id=(Long) session.getAttribute("id");
	
		
		//System.out.println(usi.getUserById(user_id));
		
		model.addAttribute("userData", usi.getUserById(user_id).get());
		
		return "dashboard";
		
	}
}
