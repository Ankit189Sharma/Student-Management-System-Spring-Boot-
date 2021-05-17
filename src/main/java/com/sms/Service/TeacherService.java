package com.sms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.Model.SignUpModel;
import com.sms.Repo.SignUpRepo;

@Service
public class TeacherService {
	
	@Autowired
	SignUpRepo repo;

	public List<SignUpModel> getAllTeachers(String role)
	{
		role="teacher";
		return  repo.findByRole(role);
	}
	
	public SignUpModel saveEmployee(SignUpModel model) {
		
		String tempMail=model.getEmail();
		
		
		return repo.save(model);
	}
	
	
	
	
	
	
	
}
