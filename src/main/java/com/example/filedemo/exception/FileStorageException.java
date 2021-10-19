package com.example.filedemo.exception;

import java.io.IOException;

public class FileStorageException extends RuntimeException{

	public FileStorageException(String message) {
		super(message);
	}

	public FileStorageException(String string, IOException e) {
		super(string, e);
	}

}
