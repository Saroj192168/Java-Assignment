package com.JavaInternshipAssignmnet.demo.Service;

import java.io.UnsupportedEncodingException;

import com.JavaInternshipAssignmnet.demo.Model.User;

import jakarta.mail.MessagingException;

//Service for registration process 

public interface IregistrationService {
	
	//add the user in database
	public void addUser(User u);
	
	//check if email is present in database if presesnt then return true or false 
	public boolean findEmail(String email);
	
	//Send verification email to the user 
	public void sendVerficationEmail(User u,String siteURL) throws UnsupportedEncodingException, MessagingException;

	//After user click verify email from their gmail account ,this method check the code for verification
	public boolean verifyEmail(String verificationcode);
}
