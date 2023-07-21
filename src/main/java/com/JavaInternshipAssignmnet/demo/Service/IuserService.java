package com.JavaInternshipAssignmnet.demo.Service;

import java.util.Optional;

import com.JavaInternshipAssignmnet.demo.Model.User;

public interface IuserService {
	
	public  Optional<User> getUserById(Long id);
	public void updateUser(User u,Long id);
	
	
	

}
