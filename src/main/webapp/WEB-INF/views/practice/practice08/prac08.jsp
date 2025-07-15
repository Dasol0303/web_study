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

	<h1>Prac08</h1>
	
	<h2>서버에서 화면에 보여줄 리스트를 필터링하고 넘겨줬을 때</h2>

	<c:forEach var="p" items="${viewMemberList}">
			${p.id} ${p.pw} ${p.name} ${p.type}<br>
	</c:forEach>
	

	<h2>서버에서 리스트 전체 넘기고, 화면에서 JSTL로 구분 출력 했을 때</h2>

	<c:choose>
		<c:when test="${auth == 'basic'}">
			<c:forEach var="p" items="${memberList}">
				<c:if test="${m.type == 'basic'}">
					${p.id} ${p.pw} ${p.name} ${p.type}<br>
				</c:if>
			</c:forEach>
		</c:when>

		<c:when test="${auth == 'manager'}">
			<c:forEach var="p" items="${memberList}">
				<c:if test="${m.type == 'manager'}">
					${p.id} ${p.pw} ${p.name} ${p.type}<br>
				</c:if>
			</c:forEach>
		</c:when>

		<c:when test="${auth == 'admin'}">
			<c:forEach var="p" items="${memberList}">
					${p.id} ${p.pw} ${p.name} ${p.type}<br>
			</c:forEach>
		</c:when>
	</c:choose>


	<%-- 	<!-- /practice08/member?auth=basic -->
	<c:if test="${type == 'basic'}">
		<c:forEach var="p" items="${member}">
			${p.id} ${p.pw} ${p.name} ${p.type}<br>
		</c:forEach>
	</c:if>


	<!-- /practice08/member?auth=manager -->
	<c:if test="${type == 'member'}">
		<c:forEach var="p" items="${member}">
			${p.id} ${p.pw} ${p.name} ${p.type}<br>
		</c:forEach>
	</c:if>
	
	
	<!-- /practice08/member?auth=admin -->
	<c:if test="${ type != 'basic' && type != 'member'}">
		<c:forEach var="p" items="${member}">
			${p.id} ${p.pw} ${p.name} ${p.type}<br>
		</c:forEach>
	</c:if> --%>



</body>
</html>