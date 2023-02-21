package com.rabbit.s1.notice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rabbit.s1.util.FileManager;
import com.rabbit.s1.util.Pagination;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//FileManager를 쓰기 위한 Application 객체와 FileManager 클래스 의존성 주입
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	
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
	
	public int setNoticeAdd(NoticeDTO noticeDTO, MultipartFile file) throws Exception{
		int result = noticeDAO.setNoticeAdd(noticeDTO);
		//저장메서드를 실행한 DTO의 noticeNum 알아오기(여기에 파일저장했다고 데이터 넣으려고)
		noticeDTO.getNoticeNum();
		
		//file이 존재 하지 않는경우에 에러 발생. 이것을 피하기 위해서 조건문 사용
		if(!file.isEmpty()) {
		
		//1. file을 HDD에 저장
		//실제 배포시 저장될 파일 위치. 테스트시에는 .metadata의 임시파일에 저장됨
		String realPath = servletContext.getRealPath("resources/upload/notice");
		System.out.println(realPath);
		
		//파일 실제 저장
		String fileName = fileManager.fileSave(file, realPath);
		
		//2. file의 저장 정보를 DB에 저장.(실제 파일이 아닌 파일을 특정지을 수 있는 파일 이름 + 기준 noticeDTO)
		NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
		noticeFileDTO.setFileName(fileName);
		noticeFileDTO.setOriginalName(file.getOriginalFilename());
		//add mapper에 selectkey를 통해 noticeNum 미리 받아오고 그걸 fileDTO에 참조값으로 넣음
		noticeFileDTO.setNoticeNum(noticeDTO.getNoticeNum());
		
		//DB에 file정보(DTO) 저장
		result = noticeDAO.setNoticeFileAdd(noticeFileDTO);
		} //file empty check
		
		return result;
	}
	
	public int setNoticeUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setNoticeUpdate(noticeDTO);
	}
	
	public int setNoticeDelete(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setNoticeDelete(noticeDTO);
	}
	
}
