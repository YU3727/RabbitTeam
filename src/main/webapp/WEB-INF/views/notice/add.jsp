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
	
	<form action="./add" method="post">
		<label for="title">글제목</label>
		<input type="text" name="noticeTitle" id="title" placeholder="글제목을 입력하세요">
		<br>
		
		<label for="writer">작성자</label>
		<input type="text" name="noticeWriter" id="writer" placeholder="작성자를 입력하세요">
		<br>
	
		<label for="detail">글내용</label>
		<textarea rows="12" cols="20" name="noticeDetail" id="detail"></textarea>
		<br>
		<!-- <input type="text" name="noticeDetail" id="detail" placeholder="글내용을 입력하세요"> -->
	
		<button type="submit" value="등록">공지등록</button>
	</form>
		<button onclick="javaScript:location.href='./list'">돌아가기</button>
	<!-- <a href="./list">돌아가기</a> -->
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>