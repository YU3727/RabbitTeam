package com.rabbit.s1.notice;

public class NoticeFileDTO {

	//업로드 파일 정보를 저장하기 위한 DTO
	private Long fileNum;
	private Long num;
	private String fileName;
	private String oriName;
	
	public NoticeFileDTO() {
		
	}

	public Long getFileNum() {
		return fileNum;
	}

	public void setFileNum(Long fileNum) {
		this.fileNum = fileNum;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriName() {
		return oriName;
	}

	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	
}
