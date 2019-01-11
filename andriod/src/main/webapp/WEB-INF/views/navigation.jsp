<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header style = "text-align : center;">
	<input type = "button" id = "sens" onclick = "getList('sens')" value = "감성명함">
	<input type = "button" id = "graphic" onclick = "getList('graphic')" value = "그래픽명함">
	<input type = "button" id = "design" onclick = "getList('design')" value = "디자인쿠폰">
</header>
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
</script>
</html>