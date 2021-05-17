package com.sms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.DTO.SignUpDTO;
import com.sms.Model.SignUpModel;
import com.sms.Repo.SignUpRepo;
import com.sms.Service.SignUpService;
import com.sms.Service.TeacherService;

import java.util.*;

@RestController
@CrossOrigin
public class TeacherController {
	

	@Autowired
	TeacherService ts;
	SignUpService service;
	
	@Autowired
	SignUpRepo repo;
	
	@GetMapping("/allTeachers")
	public ResponseEntity <List<SignUpModel>> getAllTeachers(String role){
		List<SignUpModel> allTeachers=ts.getAllTeachers(role);
		
		return new ResponseEntity<>(allTeachers,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/addNewTeacher")
	public SignUpModel AddNewUser(@RequestBody SignUpModel model) throws Exception
	{
		return ts.saveEmployee(model);
		
	
	}
	
	@GetMapping("/teacher/{email}")
	public ResponseEntity<SignUpModel> getTeacherById(@PathVariable String email)
	{
		SignUpModel model=repo.findById(email).orElseThrow(()->new RuntimeException("Employee doesnot Exits"+email));
		return ResponseEntity.ok(model);
	}

	//update employee
	@PutMapping("/updateTeacher/{email}")
	public ResponseEntity<SignUpModel> updateTeacher(@PathVariable String email,@RequestBody SignUpDTO modelDetails)
	{
		SignUpModel model=repo.findById(email).orElseThrow(()->new RuntimeException("Employee doesnot Exits"+email));
	
		model.setName(modelDetails.getName());
		model.setMobile(modelDetails.getMobile());
		model.setPassword(modelDetails.getPassword());
		
		SignUpModel updateTeacher=repo.save(model);
		return ResponseEntity.ok(updateTeacher);
	}
	
	
	//delete teacher
	@DeleteMapping("/deleteTeacher/{email}")
	public ResponseEntity<Map<String, Boolean>> deleteTeacher(@PathVariable String email)
	{
		SignUpModel model=repo.findById(email).orElseThrow(()->new RuntimeException("Employee doesnot Exits"+email));
		
		repo.deleteById(email);
		Map<String, Boolean >response=new HashMap<>();
		response.put("Deleted Successfully", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
}
