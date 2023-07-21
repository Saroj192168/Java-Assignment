package com.JavaInternshipAssignmnet.demo.ServiceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaInternshipAssignmnet.demo.Model.User;
import com.JavaInternshipAssignmnet.demo.Repository.UserRepository;
import com.JavaInternshipAssignmnet.demo.Service.IuserService;

@Service
public class UserServiceImp implements IuserService {

	@Autowired
	private UserRepository userRepo;
	

	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		
		return userRepo.findById(id);
	}

	@Override
	public void updateUser(User u, Long id) {
		// TODO Auto-generated method stub
		
	}

}
