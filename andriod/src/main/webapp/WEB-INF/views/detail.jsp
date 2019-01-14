<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.listWrap{
		border : 3px solid darkgray;
		width : 50%;
		margin : auto;
	}
	p{
		font-size : 30px;
	}
	@media(max-width : 980px){
		.listWrap {
			width : 80%;
		}
		p {
			font-size : 20px;
		}
	
	}

</style>
</head>
<body>
<%@ include file="/WEB-INF/views/navigation.jsp"%>
	
	<div id = "container">
		<div id = "listWrap" class = "listWrap">
		<p id = "title">${listVO.title}</p>
		<img src = "resources/img/${listVO.image}" style = "width : 100%;">
		<p id = "con">${listVO.con}</p>
		</div>
	</div>
</body>
</html>