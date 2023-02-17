package com.rabbit.s1.notice;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.rabbit.s1.notice.NoticeDAO.";
	
	
}
