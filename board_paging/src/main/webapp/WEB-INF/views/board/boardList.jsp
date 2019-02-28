<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href = "${pageContext.request.contextPath}/board/write">글쓰기</a>
	</div>
	<div>
		<table>
			<tr>
				<td>게시물 번호</td>
				<td>게시물 제목</td>
				<td>게시물 작성자</td>
				<td>게시물 작성시간</td>
				<td>게시물 조회수</td>
			</tr>
			<c:forEach items = "${list}" var = "list">
			<tr>
				<td>${list.bno}</td>
				<td>${list.title}</td>
				<td>${list.writer}</td>
				<td><fmt:formatDate value="${list.regDate}" pattern = "yyyy-MM-dd"/></td>
				<td>${list.viewCnt}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>