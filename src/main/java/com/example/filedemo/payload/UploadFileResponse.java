package com.example.filedemo.payload;

public class UploadFileResponse {
	
	private String fileName;
	
	private String fileDownloadUri;
	
	private String contentType;
	
	private long size;



	public UploadFileResponse(String fileName, String fileDownloadUri, String contentType, long size) {
		super();
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.contentType = contentType;
		this.size = size;
	}

}
