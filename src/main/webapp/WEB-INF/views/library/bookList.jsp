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
	<h1>도서 정보 목록</h1>
	
	<div>
		<c:forEach var="book" items="${bookList}">
			<p> 
				<a href="/books/${book.id}">
				 ${book.id} / ${book.title} / ${book.author} / ${book.price} 
				</a>
				<button type="button" onClick="modifyBook(${book.id})">수정하기</button>
			</p>
		</c:forEach>
	</div>
	
	<button type="button" onClick="location.href='/books/add'">도서 추가</button>
	
		<script>
		function modifyBook(id) {
			location.href = '/books/modifyBook?id=' + id;
		}
	</script>
	
</body>
</html>