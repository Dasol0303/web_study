<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <c:out value="${msg}"/> => 이거 오류 안나도록 붙여주는 import 형태 코드! -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL1</h1>

	<p>${msg}</p>

	<p>
		<c:out value="${msg}" />
	</p>
	<!-- 번잡스러움! 잘 안씀! -->
	<!-- c => jstl 문법 -->

	<p>${product.id}</p>
	<p>${product.name}</p>

	<p>${productList[0].id} ${productList[0].name} ${productList[0].price}</p>
	<p>${productList[1].id}${productList[1].name} ${productList[1].price}</p>
	<!-- 	list로 들어가면 요러케.. 인덱스로 다 지정해주면 좀 힘든데?? -->
	
	<hr>
	<hr>
	
	<p>===== list 반복문 사용!! =====</p>
	<!-- list 반복문 사용!! -->
	<!-- for(int i=1; i<=5; i++) -->
	
	<c:forEach var="i" begin="1" end="5" step="1"> 
	<!-- var를 begin 부터 시작해서 end까지 step만큼 증가 -->
		<p>forEach 반복 ${i}</p>
		<p>${productList[i-1].id}</p>
	</c:forEach>
	
	
	<p>===== 향상 for문! =====</p>
	<!-- 향상 for문 => for(Product p : productList) -->
	<c:forEach var="p" items="${productList}">
		<p>${p.id} ${p.name} ${p.price}</p>
	</c:forEach>
	<!-- box단위로 반복! <div class="box">요렇게 된 div에 <p>가 감싸여진 것처럼 작용! -->
	
	
	<p>===== 조건부분! =====</p>
	<!-- 조건부분! -->
	<!-- test의 결과가 참일 때 실행! -->
	<c:choose>
		
		<c:when test="${drinkType == 'coffee'}">
			<p>커피를 선택하셨군용?</p>
		</c:when>
		<c:when test="${drinkType == 'juice'}">
			<p>주스 골랐네에에~</p>
		</c:when>
		
		<c:otherwise>
			물 드세요~
		</c:otherwise>
		
	</c:choose>
	
	<!-- 활용 예제 -->
		<c:choose>
		
		<c:when test="${ score >= 800 && score <= 1000 }">
			<p>xxxx 등급</p>
		</c:when>
		
	</c:choose>
	
	
	<p>환영합니다~</p>
	
	
	<p>===== if문! =====</p>
	<!-- if문!! -->
	<c:if test="${userType == 'admin'}">
		<button>상품관리연결</button>
	</c:if>
	
	<!-- 활용 예제(else가 없어서 반대 케이스는 직접 걸어줘야함!!) -->
	<c:if test="${isLogin == true}">
		<button>로그아웃</button>
	</c:if>
	
	<c:if test="${isLogin == false}">
		<button>로그인</button>
	</c:if>
	
	
	

</body>
</html>

