package com.JavaInternshipAssignmnet.demo.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaInternshipAssignmnet.demo.Model.User;
import com.JavaInternshipAssignmnet.demo.Repository.UserRepository;
import com.JavaInternshipAssignmnet.demo.Service.IregistrationService;

@Service
public class RegistrationServiceImp implements IregistrationService {

	
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

	}


