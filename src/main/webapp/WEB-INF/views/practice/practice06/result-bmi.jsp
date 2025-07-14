<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Prac06(result-bmi)</h1>
	
	<div>
		<p>이름 : ${name}</p>
		<p>키 : ${height}</p>
		<p>몸무게 : ${weight}</p>
		<p>BMI : ${bmi}</p>
	</div>
	
		<div>
		<p>이름 : ${prac06DTO.name}</p>
		<p>키 : ${prac06DTO.height}</p>
		<p>몸무게 : ${prac06DTO.weight}</p>
		<p>BMI : ${prac06DTO.bmi}</p>
	</div>
</body>
</html>