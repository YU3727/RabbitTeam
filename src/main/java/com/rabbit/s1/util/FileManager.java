package com.rabbit.s1.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	
	//file을 HDD에 저장하는 메서드
	public String fileSave(MultipartFile multipartFile, String path) throws Exception{
		
		//매개변수 path로 받는 경로에 file 객체 생성
		File file = new File(path);
		
		//폴더가 없으면 에러발생, 없는경우 폴더 생성
		if(!file.exists()) {
			//경로상 없는폴더 모두 만들기. mkdir은 최상위폴더만
			file.mkdirs();
		}
		
		//중복x 파일명 생성, String 타입 변환
		String name = UUID.randomUUID().toString();
		//확장자 추가하기. uuid_원래파일이름
		name = name+"_"+multipartFile.getOriginalFilename();
		
		//파일 저장(모태가 될 파일객체, 생성할 이름)
		file = new File(file, name);
		
		//파일 저장 하는 api 실행.
		//file 또한 binary 데이터로 0과 1로 쪼개서 저장해야함.
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		//fileDTO를 특정지을 수 있는 이름을 리턴
		return name;
	}
	
}
