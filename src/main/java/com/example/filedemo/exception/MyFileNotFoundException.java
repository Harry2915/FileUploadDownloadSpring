package com.example.filedemo.exception;

public class MyFileNotFoundException extends RuntimeException{

	public MyFileNotFoundException(String id) {
		super(id);
	}
}
