package com.sms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.Model.SignUpModel;
import com.sms.Service.SignUpService;

@RestController
public class MainController {
	
	@Autowired
	private SignUpService service;
	
	@CrossOrigin
	@PostMapping("/signup")
	public SignUpModel RegisterUser(@RequestBody SignUpModel model) throws Exception
	{
		System.out.print(model);
		String tempemail=model.getEmail();
		if(tempemail !=null && !"".equals(tempemail))
		{
		SignUpModel user=	service.fetchUserByEmail(tempemail);
			if(user!=null)
			{
				
				throw new Exception("User with "+tempemail+" already exists.");
			}
		}
		SignUpModel obj=null;
		obj=service.signUp(model);
		return obj;
	}
	
	
	
	@PostMapping("/login")
	@CrossOrigin
	public SignUpModel loginUser(@RequestBody SignUpModel model) throws Exception {
		
		String tempemail=model.getEmail();
		String temppass=model.getPassword();
		
		SignUpModel checkexists=null;
		
		if(tempemail!=null && temppass!=null)
		{
			 checkexists=service.fetchUserByEmailAndPassword(tempemail, temppass);
			
		}
		if(checkexists==null)
		{
			throw new Exception("Bad Credentials..");
		}
		return checkexists;
		
	}
	

}
