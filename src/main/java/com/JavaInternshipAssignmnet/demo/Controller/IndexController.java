package com.JavaInternshipAssignmnet.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class IndexController {
	//Open initial  landing page 
	@GetMapping("/")
	public String showIndex(Model model)
	{
		model.addAttribute("succeess","Successfully registered");
		return "index";
	}
	
	
	
	
	
	

}
