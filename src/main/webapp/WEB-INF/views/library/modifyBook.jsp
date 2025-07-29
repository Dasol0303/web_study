<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서 수정</h1>
	
	<form action="" method="post">
		<input type="hidden" name="id" value="${book.id}"><br>
	
		<label>책 제목 : <input type="text" name="title" value="${book.title}"></label><br>
		<label>작가 이름 : <input type="text" name="author" value="${book.author}"></label><br> 
		<label>책 가격 : <input type="text" name="price" value="${book.price}"></label><br>
	
		<button type="submit">수정완료</button>
		
		<div>
			<button type="button" onClick="location.href='/books'">도서 목록보기</button>
		</div>
		
	</form>
	
	
</body>
</html>