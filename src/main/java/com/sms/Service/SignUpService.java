package com.sms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.Model.SignUpModel;
import com.sms.Repo.SignUpRepo;

@Service
public class SignUpService {
	
	@Autowired
	private SignUpRepo repo;
	
	public SignUpModel signUp(SignUpModel model)
	{
		return repo.save(model);
	}

	
	public SignUpModel fetchUserByEmail(String email)
	{
		return repo.findByEmail(email);
	}
	
	public SignUpModel fetchUserByEmailAndPassword(String email,String password)
	{
		return repo.findByEmailAndPassword(email,password);
	}
	
	
	
}
