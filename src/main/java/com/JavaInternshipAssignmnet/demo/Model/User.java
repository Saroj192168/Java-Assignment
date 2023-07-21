package com.JavaInternshipAssignmnet.demo.Model;



import java.sql.Date;
import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty(message="First Name Cannot Null")
	private String fname;
	@NotEmpty(message="Last Name Cannot be Null")
	private String lname;
	@NotEmpty
	@Size(min=10,max=10,message="Number must be of 10 digit")
	private String phone;
	@NotEmpty
	private String address;
	private String gender;
	@NotEmpty
	@Size(min=8,max=50)
	
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="please insert dob")
	private LocalDate dob;
	
	@Column(unique=true)
	@Email
	@NotEmpty
	private String email;
	
	
	
	
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public User()
	{
		
	}
	

}
