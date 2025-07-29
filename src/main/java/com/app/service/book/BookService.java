package com.app.service.book;

import java.util.List;

import com.app.dto.book.Book;

public interface BookService {

	
	int saveBook(Book book);
	
	List<Book> findBookList();
	
	Book findBookById(int id);
	
	int removeBook(int id);
	
	int modifyBook(Book book);
	
}
