package com.sms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.Model.SignUpModel;
import com.sms.Repo.SignUpRepo;
import com.sms.Service.StudentService;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	StudentService ss;
	
	@Autowired
	SignUpRepo repo;
	
	@GetMapping("/allStudents")
	public ResponseEntity<List<SignUpModel>> getAllStudents(String role)
	{
		List<SignUpModel>allStudents=ss.getAllStudents(role);
		return new ResponseEntity<>(allStudents,HttpStatus.OK);
	}
	
	
}
