<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href = "${pageContext.request.contextPath}/board/boardList">게시판가기</a>
<a href = "${pageContext.request.contextPath}/board/listPage">페이징처리 게시판가기</a>
</body>
</html>
