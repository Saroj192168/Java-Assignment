package com.JavaInternshipAssignmnet.demo.Controller;

import jakarta.servlet.http.HttpServletRequest;

public class Utility {

	public static String getSiteUrl(HttpServletRequest request)
	{
		String siteURL=request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}
}
