<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/navigation.jsp"%>

<div id = "container">
	<div id = "listWrap">
	<c:if test="${!empty list}">
		<c:forEach var = "list" items = "${list}">
			<div onclick = "goDetail('${list.id}', '${list.image}', '${list.title}', '${list.con}')">
				<img src = "resources/img/${list.image}" id = "image">
				<p id = "title">${list.title}</p>
				<p id = "con">${list.con}</p>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${empty list}">
	
	</c:if>
	</div>
</div>

</body>
<script>
	function getList(str){
		var list;
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath}/?str=' + str,
			success : function(data){
				console.log(data);
				for(var i = 0; i < data.length; i++){
					list += "<div onclick = 'goDetail(" + data[i].id +',' + '"' + data[i].image + '"' + ',' +  '"' + data[i].title + '"' + ',' + '"' + data[i].con + '"' + ")'>";
					list += "<img src = 'resources/img/" + data[i].image + "'>";
					list += "<p id = 'title'>" + data[i].title;
					list += "<p id = 'con'>" + data[i].con;
				}
				$('#listWrap').html(list);
			}
		});
	}
	function goDetail(id, image, title, con){
		location.href = '${pageContext.request.contextPath}/detail?id=' + id + '&image=' + image + '&title=' + title + '&con=' + con;
	}
</script>
</html>