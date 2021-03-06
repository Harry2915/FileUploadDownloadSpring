package com.example.filedemo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.filedemo.exception.FileStorageException;
import com.example.filedemo.exception.MyFileNotFoundException;
import com.example.filedemo.model.DBFile;
import com.example.filedemo.repository.DBFileRepository;



@Service
public class DBFileStorageService {
	
	@Autowired
	private DBFileRepository dbFileRepository;
	
	public DBFile storeFile(MultipartFile file)
	{
		// Normalize File Name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			// check if name contains invalid characters
			if(fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}
			
				DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
				
				return dbFileRepository.save(dbFile);
			
		}catch (IOException e) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
		}
	}

	
	public DBFile getFile(String fileId)
	{
		return dbFileRepository.findById(fileId).orElseThrow(()-> new MyFileNotFoundException("File not found with id" + fileId));
	}
}
