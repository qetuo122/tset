<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	.data {
		width : 50%;
		margin : auto;
		border : 3px solid darkgray;
	}
	.image{
		float : left;
		margin-left : 10%;
	}
	
	@media(max-width : 980px){
		.data{
			width : 80%;
			height : 120px;
		}
		.image{
			width : 150px;
		}
		p{
   			margin-top: 20px;
		}
	}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navigation.jsp"%>

<div id = "container">
	<div id = "listWrap">
	<c:if test="${!empty list}">
		<c:forEach var = "list" items = "${list}">
			<div class = "data" onclick = "goDetail('${list.id}')">
				<img src = "resources/img/${list.image}" id = "image" class = "image">
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
	
	function goDetail(id){
		location.href = '${pageContext.request.contextPath}/detail?id=' + id;
	}
	/* function getList(category){
		var list;
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath}/?category=' + category,
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
	} */
</script>
</html>