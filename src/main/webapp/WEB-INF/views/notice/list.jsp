<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice List</title>
	<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>

	<!-- Title -->
	<h1>Notice List Page</h1>
	<hr>
	
	<!-- table -->
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
	
	<!-- Pagination -->
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	  
	  	<li class="page-item">
	      <a class="page-link" href="./list?page=1" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	  
	    <li class="page-item ${page.before eq true ? 'disabled':''}">
	      <a class="page-link" href="./list?page=${page.startNum-1}" aria-label="Previous">
	        <span aria-hidden="true">&lsaquo;</span>
	      </a>
	    </li>
	    
	    <!-- perPage 개수만큼 반복문 -->
	    <c:forEach begin="${page.startNum}" end="${page.lastNum}" step="1" var="i">
	    	<li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
	    </c:forEach>
	    
	    <li class="page-item ${page.after ? 'disabled':''}">
	      <a class="page-link" href="./list?page=${page.lastNum+1}" aria-label="Next">
	        <span aria-hidden="true">&rsaquo;</span>
	      </a>
	    </li>
	    
	    <li class="page-item">
	      <a class="page-link" href="./list?page=${pagination.totalPage}" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
	
	
	<button onclick="javaScript:location.href='./add'">공지등록</button>
	<button onclick="javaScript:location.href='../'">돌아가기</button>
	<!-- <a href="./add">공지 등록</a> -->
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>