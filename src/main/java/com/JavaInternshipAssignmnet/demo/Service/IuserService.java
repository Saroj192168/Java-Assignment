package com.JavaInternshipAssignmnet.demo.Service;

import java.util.Optional;

import com.JavaInternshipAssignmnet.demo.Model.User;

//Service for User Process
public interface IuserService {
	
	//To get single user infromation from the database 
	public  Optional<User> getUserById(Long id);
	
	//to update a user 
	public void updateUser(User u,Long id);
	
	
	

}
