<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 변경</h1>

	<form action="/customer/modifyPw" method="post">
	
		<p>
			새로운 비밀번호 : <input type="password" name="pw">
		</p>
		
		<button onClick="location.href='/customer/mypage'">마이페이지로 돌아가기</button>
		<button type="submit" onClick="location.href='/customer/mypage'">비밀번호 변경하기</button>

	</form>


</body>
</html>