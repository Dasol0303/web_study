<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Prac06(ask-bmi)</h1>
	
	<h2>입력항목</h2>
	
	<div>
	
		<!-- <form action="/practice06/result-bmi04" method="post"> -->
		<form action="/practice06/result-bmi04" method="get">
			이름 : <input type="text" name="name"> <br>
			키 : <input type="text" name="height"> <br>
			몸무게 : <input type="text" name="weight"> <br>
			<button type="submit">확인하기</button>
		</form>
		
	</div>
	
</body>
</html>