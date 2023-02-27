<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Add</title>
	<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<h1>Notice Add Page</h1>
	<hr>
	
	<form action="./add" method="post" enctype="multipart/form-data">
		<label for="title">글제목</label>
		<input type="text" name="title" id="title" placeholder="글제목을 입력하세요">
		<br>
		
		<label for="writer">작성자</label>
		<input type="text" name="writer" id="writer" placeholder="작성자를 입력하세요">
		<br>
	
		<label for="contents">글내용</label>
		<textarea rows="12" cols="20" name="contents" id="contents"></textarea>
		<br>
		<!-- <input type="text" name="noticeDetail" id="detail" placeholder="글내용을 입력하세요"> -->
		
		<!-- 파일 추가, name = file임을 기억. Controller의 MultipartFile의 매개변수 이름도 file로 입력 -->
		<input type="file" class="form-control" id="files" name="file">
	
		<button type="submit" value="등록">공지등록</button>
	</form>
		<button onclick="javaScript:location.href='./list'">돌아가기</button>
	<!-- <a href="./list">돌아가기</a> -->
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>