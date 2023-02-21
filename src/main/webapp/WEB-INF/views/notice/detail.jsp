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
	
	<h3>글번호 : ${dto.noticeNum}</h3>
	<h3>글제목 : ${dto.noticeTitle}</h3>
	<h3>작성자 : ${dto.noticeWriter}</h3>
	<h3>작성날짜 : ${dto.noticeDate}</h3>
	<h3>조회수 : ${dto.noticeHits}</h3>
	<h3>글내용 : ${dto.noticeDetail}</h3>
	<!-- fileDTO가 있는경우에만 출력 -->
	<c:if test="${not empty dto.noticeFileDTO}">
		<h3>첨부파일 : <a href="../resources/upload/notice/${dto.noticeFileDTO.fileName}">확인하기</a></h3>
	</c:if>
	<hr>
	
	<%-- <a href="./update?noticeNum=${dto.noticeNum}">수정하기</a> --%>
	<button onclick="javaScript:location.href='./update?noticeNum=${dto.noticeNum}'">수정하기</button>
	<button onclick="javaScript:location.href='./delete?noticeNum=${dto.noticeNum}'">삭제하기</button>
	<button onclick="javaScript:location.href='./list'">돌아가기</button>
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>