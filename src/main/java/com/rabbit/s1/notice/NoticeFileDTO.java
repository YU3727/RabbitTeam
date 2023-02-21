package com.rabbit.s1.notice;

public class NoticeFileDTO {

	//업로드 파일 정보를 저장하기 위한 DTO
	private Long fileNum;
	private Long noticeNum;
	private String fileName;
	private String originalName;
	
	public NoticeFileDTO() {
		
	}

	public Long getFileNum() {
		return fileNum;
	}

	public void setFileNum(Long fileNum) {
		this.fileNum = fileNum;
	}

	public Long getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(Long noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	
}
