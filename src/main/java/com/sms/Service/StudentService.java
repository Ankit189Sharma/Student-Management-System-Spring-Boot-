package com.sms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.Model.SignUpModel;
import com.sms.Repo.SignUpRepo;

@Service
public class StudentService {

	@Autowired
	SignUpRepo repo;
	
	public List<SignUpModel> getAllStudents(String role)
	{
		role="student";
		return repo.findByRole(role);
	}
	
	
}
