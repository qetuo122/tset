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
		<button onclick = "perPageNum(10)">10개보기</button>
		<button onclick = "perPageNum(20)">20개보기</button>
		<button onclick = "perPageNum(30)">30개보기</button>
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
	
	<div>
		<ul>
			<c:if test="${pageMaker.prev}">
				<li><a href = "listPage?page=${pageMaker.startPage - 1}&perPageNum=${pageMaker.cri.perPageNum}">이전</a></li>
			</c:if>
			<c:forEach begin = "${pageMaker.startPage}" end = "${pageMaker.endPage}" var = "idx">
				<li><a href = "listPage?page=${idx}&perPageNum=${pageMaker.cri.perPageNum}">${idx}</a></li>
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a href = "listPage?page=${pageMaker.endPage + 1}&perPageNum=${pageMaker.cri.perPageNum}">다음</a>
			</c:if>
		</ul>
	</div>
</body>
<script>
	function perPageNum(num){
		location.href = "${pageContext.request.contextPath}/board/listPage?page=1&perPageNum=" + num;
	}
</script>
</html>