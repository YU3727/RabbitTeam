package com.rabbit.s1.notice;

import java.sql.Date;

public class NoticeDTO {

	private Long noticeNum;
	private String noticeTitle;
	private String noticeDetail;
	private String noticeWriter;
	private Date noticeDate;
	private Long noticeHits;
	//Notice는 첨부파일을 가진다.(has관계)
	private NoticeFileDTO noticeFileDTO;
	
	public NoticeDTO() {
		
	}
	
	

	public NoticeFileDTO getNoticeFileDTO() {
		return noticeFileDTO;
	}

	public void setNoticeFileDTO(NoticeFileDTO noticeFileDTO) {
		this.noticeFileDTO = noticeFileDTO;
	}

	public Long getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(Long noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeDetail() {
		return noticeDetail;
	}

	public void setNoticeDetail(String noticeDetail) {
		this.noticeDetail = noticeDetail;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public Long getNoticeHits() {
		return noticeHits;
	}

	public void setNoticeHits(Long noticeHits) {
		this.noticeHits = noticeHits;
	}
	
}
