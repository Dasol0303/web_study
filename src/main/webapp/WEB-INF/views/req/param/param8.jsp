<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/request03/param8 페이지</h1>
	
	<div>
	
		<form action="/request03/param8" method="post">
		<!-- 전송을 누르면 /param8의 post로 연결이 되기 때문에 post 메소드로 연결!! -->
		
			id : <input type="text" name="id"> <br>
			name : <input type="text" name="name"> <br>
			price : <input type="text" name="price"> <br>	
			<button type="submit">전송</button>
		
		</form>
	
	</div>
	
</body>
</html>