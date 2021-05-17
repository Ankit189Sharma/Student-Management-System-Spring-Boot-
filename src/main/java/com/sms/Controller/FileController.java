package com.sms.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.*;

import java.util.ArrayList;
import java.util.List;


import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sms.Model.FileModel;
import com.sms.Repo.FilesRepo;


@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {
	
	@Autowired
	FilesRepo frepo;
	 public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/";

	    @PostMapping("/upload")
	    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException {
	        List<String> filenames = new ArrayList<>();
	        //Defined file model
	        FileModel fm=new FileModel();
	        
	        for(MultipartFile file : multipartFiles) {
	            String filename = StringUtils.cleanPath(file.getOriginalFilename());
	            Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
	            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
	           
	            //my own logic
	            fm.setFiles(filename);
	            frepo.save(fm);
	            
	          
	             filenames.add(filename);
	        }
	        return ResponseEntity.ok().body(filenames);
	    }
	    
	    
	 
	    @GetMapping("download/{filename}")
	    public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
	        Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
	        if(!Files.exists(filePath)) {
	            throw new FileNotFoundException(filename + " was not found on the server");
	        }
	        Resource resource = new UrlResource(filePath.toUri());
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.add("File-Name", filename);
	        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
	        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
	                .headers(httpHeaders).body(resource);
	    }
	    
	    @GetMapping("repoFiles")
	    public ResponseEntity<List<FileModel>> getAllFiles(){
	    	List<FileModel> list=frepo.findAll();
	    	return new ResponseEntity<>(list,HttpStatus.OK);
	    	 
	    	}
	    
	    
	    
	   

}
