package com.JavaInternshipAssignmnet.demo.ServiceImp;

import java.io.UnsupportedEncodingException;


import org.springframework.beans.factory.annotation.Autowired;
	
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.JavaInternshipAssignmnet.demo.Model.User;
import com.JavaInternshipAssignmnet.demo.Repository.UserRepository;
import com.JavaInternshipAssignmnet.demo.Service.IregistrationService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class RegistrationServiceImp implements IregistrationService {

	@Autowired
	 private JavaMailSender mailsender;
	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub
		userRepo.save(u);
	}

    @Override	
	public boolean findEmail(String email) {
		if(userRepo.existsByEmail(email)==true)
		{
			return true;
		}
		return false;
	}

	@Override
	public void sendVerficationEmail(User userData,String siteURL) throws UnsupportedEncodingException, MessagingException {
		// TODO Auto-generated method stub
		
		
		
		
		String subject="Please verify your Email";
		String senderName="Saroj Koirala";
		String mailContent="<p>Dear " + userData.getFname()+" "+userData.getLname()+"</p>";
		mailContent +="<p> Please click the link below to verify to our registration</p>";
		String verifyURL=siteURL+"/verify?code="+userData.getVerificationcode();
		mailContent += "<h3><a href=\" "+verifyURL+"\">VERIFY</a><h3>";
		mailContent +="<p>Thank You</p>"; 
		
		MimeMessage message=mailsender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		helper.setFrom("test@gmail.com",senderName);
		helper.setTo(userData.getEmail());
		helper.setSubject(subject);
		helper.setText(mailContent,true);
		
		mailsender.send(message);
		
	}
	
	@Override
	public boolean verifyEmail(String verificationcode)
	{
		User u=userRepo.findByVerificationcode(verificationcode);
		if(u==null || u.getEnable()==1)
		{
			return false;
		}
		
		else
		{
			userRepo.updateEnable(u.getId());
			return true;
		}
	}

	}


