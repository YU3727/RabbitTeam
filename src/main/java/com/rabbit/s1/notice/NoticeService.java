package com.rabbit.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbit.s1.util.Pagination;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getNoticeList(Pagination pagination) throws Exception{
		Long totalCount = noticeDAO.getNoticeCount(pagination);
		pagination.makeNum(totalCount);
		pagination.makeRow();
		List<NoticeDTO> ar = noticeDAO.getNoticeList(pagination);
		return ar;
	}
	
	public NoticeDTO getNoticeDetail(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.getNoticeDetail(noticeDTO);
	}
	
	public int setNoticeAdd(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setNoticeAdd(noticeDTO);
	}
	
	public int setNoticeUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setNoticeUpdate(noticeDTO);
	}
	
	public int setNoticeDelete(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setNoticeDelete(noticeDTO);
	}
	
}
