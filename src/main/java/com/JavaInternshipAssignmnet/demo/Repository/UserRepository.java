package com.JavaInternshipAssignmnet.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaInternshipAssignmnet.demo.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public boolean existsByEmail(String email);
	public User findByEmailAndPassword(String email,String Password);
}
