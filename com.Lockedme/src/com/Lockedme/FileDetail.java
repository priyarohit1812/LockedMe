package com.Lockedme;

public class FileDetail {
	private int id;
	private String fileName;
	public FileDetail() {
		
	}
	public FileDetail(int id, String fileName) {
		super();
		this.id = id;
		this.fileName = fileName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
