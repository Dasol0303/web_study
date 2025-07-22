<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>User 정보받기</h1>

<!-- 모든 값을 입력 받는 케이스 -->
<!-- 	<form action="/admin/users/add" method="post">
		사용자 아이디 : <input type="text" name="id"> <br> 
		사용자 비번 : <inputtype="text" name="pw"> <br> 
		사용자 이름 : <input type="text"name="name"> <br>

		<h4>userType</h4>

		<select name="userType">
			<option value="ADM">관리자</option>
			<option value=" CUS" selected>사용자</option>
		</select> <br>

		<button type="submit">User 정보 등록</button>
	</form> -->


	<form action="/admin/users/add" method="post">
	
		사용자 아이디 : <input type="text" name="id"> <br> 
		사용자 이름 : <input type="text"name="name"> <br>

	<button type="submit">User 정보 등록</button>
	</form>

</body>
</html>