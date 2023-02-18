<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice List</title>
</head>
<body>
	<h1>Notice List Page</h1>
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성날짜></th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${notice}" var="dto">
				<tr>
					<td>${dto.noticeNum}</td>
					<td><a href="./detail?noticeNum=${dto.noticeNum}">${dto.noticeTitle}</a></td>
					<td>${dto.noticeWriter}</td>
					<td>${dto.noticeDate}</td>
					<td>${dto.noticeHits}</td>			
				</tr>	
			</c:forEach>
		</tbody>
	</table>
	
	<button onclick="javaScript:location.href='./add'">공지등록</button>
	<button onclick="javaScript:location.href='../'">돌아가기</button>
	<!-- <a href="./add">공지 등록</a> -->
	
</body>
</html>