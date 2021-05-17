package com.sms.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SignUpModel {

	String name;
	
	@Id
	String email;
	
	String password;
	
	String mobile;
	
	
	String role;


	public String getName() {
		return name;
	}
	


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public SignUpModel(String name, String email, String password, String mobile, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.role = role;
	}


	public SignUpModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "SignUpModel [name=" + name + ", email=" + email + ", password=" + password + ", mobile=" + mobile
				+ ", role=" + role + "]";
	}
	
	
	
	
}
