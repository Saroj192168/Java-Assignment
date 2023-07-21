package com.JavaInternshipAssignmnet.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {
	
	@GetMapping("/dashboard")
	public String showDashboard(HttpSession session)
	{
		System.out.println(session.getAttribute("id"));
		if(session.getAttribute("id")==null)
		{
			return "redirect:/signin";
		}
		return "dashboard";
		
	}
}
