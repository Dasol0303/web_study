<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
		.ad-display-hide {
			display : none;
		}	
	</style>


</head>
<body>

	<h1>Prac13</h1>
	
	<!-- HTML 주석 -->
	<%-- JSP 서버 주석 --%>

	<c:if test="${hideAd == null}">

	<form action="/practice13/hideAd" method="post" id="adForm">
		<h2>광고</h2>
		<label>
			<input type="checkbox" name="hideAd" value="true" id="chk_hide"> 광고 24시간보지않기 <button type="submit">닫기</button>
		</label>
	</form>
	
	</c:if>

	<h2>페이지에 표시되는 내용</h2>

	<!-- 버튼 그냥 눌렀을 때 일시적으로 보이지 않게하기 위한 처리!! => 자바스크립트 처리 -->
	<!-- 스크립트로 처리하는 경우! => 요소에는 잡히지만 안보임! -->
	<!-- 쿠키로 처리하는 경우! => 요소 자체를 서버에서 지워버림! -->
	<script>
		
		const adForm = document.getElementById("adForm");
		const chkHide = document.getElementById("chk_hide");
		
		adForm.addEventListener("submit", (e)=>{
			e.preventDefault(); /* 일시적으로 작동 중지 이벤트! */
			
			//checkbox 체크 O -> form 요청 -> 서버 Post
			//checkbox 체크 X -> 일시적으로 안보이게 -> display:none;
			
			if(chkHide.checked == true) {	//check O
				adForm.submit(); //submit 작동해!
			} else {	//check X
				
				//1) 직접 스타일 걸어주기
				//adForm.style.display = 'none';
		
				//2) -> display:none을 적용한 스타일에 만들어둔 클래스 추가!!
				adForm.classList.add('ad-display-hide');
			}
			
		});
	
	</script>
	

</body>
</html>