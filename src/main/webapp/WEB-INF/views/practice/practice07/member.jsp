<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Prac07</h1>

	<c:forEach var="p" items="${member}">
		${p.id} ${p.password} ${p.name} <br>
	</c:forEach>
</body>
</html>