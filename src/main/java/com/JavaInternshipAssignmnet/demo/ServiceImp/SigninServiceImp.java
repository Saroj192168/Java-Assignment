package com.JavaInternshipAssignmnet.demo.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaInternshipAssignmnet.demo.Model.User;
import com.JavaInternshipAssignmnet.demo.Repository.UserRepository;
import com.JavaInternshipAssignmnet.demo.Service.ISiginService;

@Service
public class SigninServiceImp implements ISiginService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public User getEmailandPasssword(String email,String password) {
		// TODO Auto-generated method stub
		
		return userRepo.findByEmailAndPassword(email, password);
	}

}
