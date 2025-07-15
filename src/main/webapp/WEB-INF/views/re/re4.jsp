<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		잘못된 접근입니다.
		<button>정상 화면으로 이동!</button>
		<!-- 누르면 화면으로 이동하도록 이벤트 걸어주기도 가능!! -->
	</div>

	<script>
		
		alert('지금 re2 페이지로 이동합니다');
	
	/* 강제로 경로 바꿔주기! 그래서 파라미터에 value값을 넣어도 안뜸! (re2 접속 경로에서 제대로 작성하지 않았으니까!) */
		location.href = "/re/re2"; //	/re/re2 경로로 접속해라~ (페이지 이동)
	</script>

</body>
</html>