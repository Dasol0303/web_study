<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>viewData1 페이지</h1>
	
	<!-- 옛날 방식 -->
	<%=request.getAttribute("store") %>
	<%=request.getAttribute("menu") %>
	
	<!-- 요즘 방식(끝에 빨간줄이 떠도 버그임 문제없음 파일 껐다 켜보슈..) -->
	<div>
		<p>${store}</p>
		<p>${menu}</p>
	</div>
	
</body>
</html>