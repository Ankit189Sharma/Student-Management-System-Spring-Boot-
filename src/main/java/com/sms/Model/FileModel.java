package com.sms.Model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	String files;


	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	

}
