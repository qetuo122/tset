<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	@media(max-width : 980px){
		p {
			font-size : 50px;
		}
	}
</style>
</head>
<body>

<div id = "container" style = "text-align:center;">
	<div>
		<img src = "${pageContext.request.contextPath}/resources/img/${detail.img}" style = "width : 50%;">
		<p>${detail.title}</p>
		<p>${detail.con}</p>
	</div>
</div>

</body>
</html>