package com.app.dao.book;

import java.util.List;

import com.app.dto.book.Book;

public interface BookDAO{
	
	int saveBook(Book book);
	
	List<Book> findBookList();
	
	Book findBookById(int id);
	
	int removeBook(int id);
	
	int modifyBook(Book book);
	
}
