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

<hr>
1
<hr>
	<!-- case 1 -->	
		<p>스트링 리스트입니다.</p>
		<p>스트링 리스트입니다.</p>
		<p>스트링 리스트입니다.</p>
		<p>스트링 리스트입니다.</p>
		<p>스트링 리스트입니다.</p>
		<p>스트링 리스트입니다.</p>
		<p>스트링 리스트입니다.</p>
		<p>스트링 리스트입니다.</p>
		<p>스트링 리스트입니다.</p>
		<p>스트링 리스트입니다.</p>

<hr>
2
<hr>
	<!-- case 2 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<p>스트링 리스트입니다.</p>
	</c:forEach>
	
<hr>
3
<hr>	
	<!-- case 3 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<p>${msg}</p>
	</c:forEach>
	
<hr>
4
<hr>
	<!-- case 4 -->
	<c:forEach var="m" items="${msgList}" >
		<p>${m}</p>
	</c:forEach>
	
</body>
</html>