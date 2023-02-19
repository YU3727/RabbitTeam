<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Detail</title>
	<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<h1>Notice Detail Page</h1>
	<hr>
	
	<h2>글번호 : ${dto.noticeNum}</h2>
	<h2>글제목 : ${dto.noticeTitle}</h2>
	<h2>작성자 : ${dto.noticeWriter}</h2>
	<h2>작성날짜 : ${dto.noticeDate}</h2>
	<h2>조회수 : ${dto.noticeHits}</h2>
	<h2>글내용 : ${dto.noticeDetail}</h2>
	<hr>
	
	<%-- <a href="./update?noticeNum=${dto.noticeNum}">수정하기</a> --%>
	<button onclick="javaScript:location.href='./update?noticeNum=${dto.noticeNum}'">수정하기</button>
	<button onclick="javaScript:location.href='./delete?noticeNum=${dto.noticeNum}'">삭제하기</button>
	<button onclick="javaScript:location.href='./list'">돌아가기</button>
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>