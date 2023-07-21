package com.JavaInternshipAssignmnet.demo.Service;

import java.io.UnsupportedEncodingException;

import com.JavaInternshipAssignmnet.demo.Model.User;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

public interface IregistrationService {
	public void addUser(User u);
	public boolean findEmail(String email);
	
	public void sendVerficationEmail(User u,String siteURL) throws UnsupportedEncodingException, MessagingException;

	public boolean verifyEmail(String verificationcode);
}
