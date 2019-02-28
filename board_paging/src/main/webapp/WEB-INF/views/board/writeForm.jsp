<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form method = "post">
			글제목 : <input type = "text" id = "title" name = "title">
			글내용 : <textarea id = "content" name = "content"></textarea>
			글쓴이 : <input type = "text" id = "writer" name = "writer">
			<button type = "submit">글쓰기</button>
		</form>
	</div>
</body>
</html>