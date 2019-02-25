<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>

	table, tr, td {
		border : 1px solid black;
		text-align : center;
	}

</style>
</head>

<body>
<form action = "/login" method = "POST">
	<table>
	<tr>
		<td>ID</td>
		<td><input type = "text" id = "inputId" name = "inputId" value = "${cookie.remember_id.value}"></td>
		<td rowspan = "3"><button type = "submit" id = "loginBtn" style = "height : 75px;">로그인</button></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type = "password" id = "inputPw" name = "inputPw"></td>
	</tr>
	<tr>
		<td colspan = "2">로그인유지<input type = "checkBox" id = "remember_id" name = "remember_id" ${checked}></td>
	</tr>
	</table>
	<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
</form>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	<font color = "red">
		<p>로그인에 실패하셨습니다 <br>
		${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
		<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope = "session"/>
	</font>
</c:if>
</body>

<!-- <script>
		$('#loginBtn').click(function(){
			var id = $('#inputId').val();
			var pw = $('#inputPw').val();
			var tmp = $('#remember_id').is(':checked');
			if(id == null || pw == null){
				alert("아이디 혹은 비밀번호를 입력해주세요");
			} else {
				$.ajax({
					type : 'post',
					url : '${pageContext.request.contextPath}/',
					data : {
						user_id : id,
						remember_id : tmp
					},
					success : function(data){
						console.log(data)
						if(data != pw){
							alert("아이디 혹은 비밀번호가 일치하지 않습니다");
						} else {
							location.href = '${pageContext.request.contextPath}/board/list';
						}
					}
				});
			}
		});
</script> -->
</html>



