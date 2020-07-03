<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="/guestbook4/guest/delete" method="get"> 
			비밀번호: <input type= "text" name="pw">
			<button type="submit">확인</button>
			<input type = "text" name = "no" value = "${param.no}">
			
		</form>
		<p><a href ="/guestbook4/guest/list" >메인으로 돌아가기</a></p>
</body>
</html>