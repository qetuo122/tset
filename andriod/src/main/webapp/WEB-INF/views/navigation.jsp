<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		text-align : center;
	}
	.header {
		margin : auto;
		width : 50%;
		background-color : gray;
		height : 30px;
		padding-top : 5px;
		border : 3px solid gray;
	}
	@media(max-width : 980px){
		.header{
			width : 80%;
			height : 30px;
		}
			
	}
</style>
</head>
<body>
<header style = "text-align : center;" class = "header">
	<input type = "button" id = "sens" onclick = "getList('sens')" value = "감성명함">
	<input type = "button" id = "graphic" onclick = "getList('graphic')" value = "그래픽명함">
	<input type = "button" id = "design" onclick = "getList('design')" value = "디자인쿠폰">
</header>
</body>
<script>
function getList(category){
	location.href = '${pageContext.request.contextPath}?category=' + category;
}
</script>
</html>