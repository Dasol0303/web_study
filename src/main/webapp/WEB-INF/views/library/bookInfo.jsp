<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${book.title} 정보</h1>
	
	<p>도서 ID : ${book.id}</p>
	<p>책 제목 : ${book.title}</p>
	<p>저자 : ${book.author}</p>
	<p>가격 : ${book.price}</p>
	
	<button type="button" onClick="removeBook(${book.id})">삭제하기</button>
	<div>
		<button type="button" onClick="location.href='/books'">도서 목록보기</button>
	</div>
	
	<script>
		function removeBook(id) {
			if(confirm("정말 삭제하시겠습니까?")) {
				location.href='/books/removeBook?id=' + id;
			}
		}
	</script>
	
	
</body>
</html>