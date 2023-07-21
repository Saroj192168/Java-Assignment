package com.JavaInternshipAssignmnet.demo.ServiceImp;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.JavaInternshipAssignmnet.demo.Model.User;

import com.JavaInternshipAssignmnet.demo.Service.IuserService;

@Service
public class UserServiceImp implements IuserService {
	
	

	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User u, Long id) {
		// TODO Auto-generated method stub
		
	}

}
