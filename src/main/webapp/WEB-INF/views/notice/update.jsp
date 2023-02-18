<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Update</title>
</head>
<body>
	<h1>Notice Update Page</h1>
	<hr>
	
		<form action="./update" method="post">
		<label for="num">글번호</label>
		<input type="text" name="noticeNum" id="num" value="${dto.noticeNum}" readonly>
		<br>
		
		<label for="title">글제목</label>
		<input type="text" name="noticeTitle" id="title" value="${dto.noticeTitle}">
		<br>
		
		<label for="writer">작성자</label>
		<input type="text" name="noticeWriter" id="writer" value="${dto.noticeWriter}">
		<br>
	
		<label for="date">작성날짜</label>
		<input type="text" name="noticeDate" id="date" value="${dto.noticeDate}" readonly>
		<br>
		
		<label for="hits">조회수</label>
		<input type="text" name="noticeHits" id="hits" value="${dto.noticeHits}" readonly>
		<br>		
		
		<label for="detail">글내용</label>
		<textarea rows="12" cols="20" name="noticeDetail" id="detail"></textarea>
		<br>
	
		<button type="submit" value="등록">수정완료</button>
	</form>
		<button onclick="javaScript:location.href='./list'">돌아가기</button>
		<%-- <button onclick="javaScript:location.href='./detail?noticeNum=${dto.noticeNum}'">돌아가기</button> --%>
	
</body>
</html>