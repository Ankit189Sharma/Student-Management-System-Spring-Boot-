package com.sms.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.Model.FileModel;

@Repository
public interface FilesRepo extends JpaRepository<FileModel, Integer> {
	

	

}
