package com.rabbit.s1.notice;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rabbit.s1.TestDefaultSet;
import com.rabbit.s1.util.Pagination;

public class NoticeDAOTest extends TestDefaultSet{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
	public void getNoticeListTest(Pagination pagination) throws Exception{
		List<NoticeDTO> ar = noticeDAO.getNoticeList(pagination);
		assertNotEquals(0, ar.size());
	}
	
//	@Test
	public void getNoticeDetailTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeNum(1L);
		noticeDTO = noticeDAO.getNoticeDetail(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
//	@Test
	public void setNoticeAddTest() throws Exception{
		for(int i=1; i<=50; i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			Random r = new Random();
			double d = r.nextDouble();
			int num = (int)(d*1000);
			d = num/100.0;
			noticeDTO.setNoticeTitle("testTitle"+i);
			noticeDTO.setNoticeDetail("testDetail"+d);
			noticeDTO.setNoticeWriter("testWriter"+i);
			int result = noticeDAO.setNoticeAdd(noticeDTO);
//			assertNotEquals(0, result);
		}
	}
	
//	@Test
	public void setNoticeUpdateTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeNum(6L);
		noticeDTO.setNoticeTitle("modi6title");
		noticeDTO.setNoticeDetail("modi6detail");
		noticeDTO.setNoticeWriter("modi6writer");
		int result = noticeDAO.setNoticeUpdate(noticeDTO);
		assertNotEquals(0, result);
	}
	
//	@Test
	public void setNoticeDeleteTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeNum(6L);
		int result = noticeDAO.setNoticeDelete(noticeDTO);
		assertNotEquals(0, result);
	}
	
}
