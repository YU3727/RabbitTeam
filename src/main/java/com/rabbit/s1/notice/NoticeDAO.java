package com.rabbit.s1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.rabbit.s1.notice.NoticeDAO.";
	
	
	public List<NoticeDTO> getNoticeList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getNoticeList");
	}
	
	public NoticeDTO getNoticeDetail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getNoticeDetail", noticeDTO);
	}
	
	public int setNoticeAdd(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setNoticeAdd", noticeDTO);
	}
	
	public int setNoticeUpdate(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setNoticeUpdate", noticeDTO);
	}
	
	public int setNoticeDelete(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setNoticeDelete", noticeDTO);
	}
}
