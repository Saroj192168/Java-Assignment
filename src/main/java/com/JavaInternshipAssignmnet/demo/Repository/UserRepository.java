package com.JavaInternshipAssignmnet.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;

import com.JavaInternshipAssignmnet.demo.Model.User;


@Transactional
public interface UserRepository extends JpaRepository<User, Long>{

	//Check email from database and return true if email is present 
	public boolean existsByEmail(String email);
	public User findByEmailAndPassword(String email,String Password);
	
	//To get the user detail associate with the verification code
	public User findByVerificationcode(String code);
	
	
	//To update the enable field after successful email verification based on user id
	@Query("UPDATE User u set u.enable=1 where u.id= ?1 ")
	@Modifying
	public void updateEnable( Long id);
}
