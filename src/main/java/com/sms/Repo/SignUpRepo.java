package com.sms.Repo;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.Model.SignUpModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface SignUpRepo  extends  JpaRepository<SignUpModel,String>{

	public SignUpModel findByEmail(String email);
	
	public List<SignUpModel> findByRole(String role);
	
	public SignUpModel findByEmailAndPassword(String email,String password);
	
	

}

