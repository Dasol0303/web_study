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
	<h1>관리자 페이지</h1>
	<h2>rooms 객실 목록</h2>
	
	<button id="btn_registerRoom">객실 추가하기</button>
	<br>
	<br>
	
	<c:forEach var="room" items="${roomList}">
	
		<p>
			<a href="/admin/room/${room.roomId}">
				${room.roomId} ${room.buildingName} ${room.roomNumber} ${room.floor} ${room.maxGuestCount} ${room.viewType}
					
					<c:choose>
						<c:when test="${room.viewType == 'OCN'}">오션뷰</c:when>
						<c:when test="${room.viewType == 'CTY'}">시티뷰</c:when>
						<c:when test="${room.viewType == 'MOT'}">마운틴뷰</c:when>
					</c:choose>
				</a>
				
				<%-- <button type="button" onClick=" location.href='/admin/removeRoom?roomId=${room.roomId}' ">삭제하기</button> --%>
				<!-- /admin/removeRoom?roomId=? 가 뭔지 알아야함! -->
				<button type="button" onClick="removeRoom(${room.roomId})">삭제하기</button>
				
			</p>
		
	</c:forEach>
	
	<script>
		const btn_registerRoom = document.getElementById('btn_registerRoom');
		
		btn_registerRoom.addEventListener('click', ()=>{
			location.href = "/admin/registerRoom";
		})
		
		function removeRoom(roomId) {
			/* confirm => alert같은 알림창의 '확인' 과 '취소' 버튼에 따라 true, flase를 반환해주는 코드 */
			if(confirm("정말 삭제하시겠습니까?")) {
				location.href='/admin/removeRoom?roomId=' + roomId;
			}
		}
	
	</script>
	
</body>
</html>