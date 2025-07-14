<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <c:out value="${msg}"/> => 이거 오류 안나도록 붙여주는 import 형태 코드! -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	하나  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 둘 
	<!-- &nbsp; => 띄어쓰기 -->
	<br>
	${msg1}
	<br>
	${msg2}
	<br>

<!-- &{msgXml} => 이렇게 부르면 실제 경고창이 뜨니까 밑에 형식으로 사용해줌!! -->

	<!-- c:out => xml 형태를 text 형태로 인식할 때에 사용!! -->
	<c:out value="${msgXml}" escapeXml="true"/>
	<br>
	<c:out value="${msg1}" escapeXml="true"/>
	<br>
	<c:out value="${msg2}" escapeXml="true"/>
	<br>
	
	<a href="/jstl1">jstl1 페이지로 이동</a>
	<br>
	
	<!-- 클릭 함수는 밑에 script 확인!! -->
	<button id="btn">jstl1 페이지로</button> 
	<br>
	
	<!-- 잘 안씀! 그냥 있구나~ -->
	<c:url var="jstl1Url" value="/jstl1"/>
	<br>
	<a href="${jstl1Url}">jstl Url</a> <!-- 40번 줄에 변수 있어서 사용! -->
	<br>
	
	
	
	
<!-- 다이렉트.. 연결...!(접속하는 순간 지정 페이지로 바로 이동!!) -->
<%-- 	<c:redirect url="http://www.naver.com" /> --%>
	
	<script>
	
// location.href = "" => 얘도 다이렉트로 연결 역할!!
// 		location.href = "http://coupang.com";
	
		document.getElementById('btn').addEventListener('click', ()=>{
			location.href = "/jstl1";
		})
	</script>
	
	

</body>
</html>