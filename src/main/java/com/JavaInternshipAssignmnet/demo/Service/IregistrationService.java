package com.JavaInternshipAssignmnet.demo.Service;

import com.JavaInternshipAssignmnet.demo.Model.User;

public interface IregistrationService {
	public void addUser(User u);
	public boolean findEmail(String email);

}
