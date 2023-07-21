package com.JavaInternshipAssignmnet.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.JavaInternshipAssignmnet.demo.Model.User;


@Transactional
public interface UserRepository extends JpaRepository<User, Long>{

	public boolean existsByEmail(String email);
	public User findByEmailAndPassword(String email,String Password);
	public User findByVerificationcode(String code);
	
	@Query("UPDATE User u set u.enable=1 where u.id= ?1 ")
	@Modifying
	public void updateEnable( Long id);
}
