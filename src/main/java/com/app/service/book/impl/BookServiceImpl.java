package com.app.service.book.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.book.BookDAO;
import com.app.dto.book.Book;
import com.app.service.book.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDAO bookDAO;

	@Override
	public int saveBook(Book book) {
		
		int result = bookDAO.saveBook(book);
		
		return result;
	}

	@Override
	public List<Book> findBookList() {
		
		List<Book> bookList = bookDAO.findBookList();
		
		return bookList;
	}

	@Override
	public Book findBookById(int id) {
		Book book = bookDAO.findBookById(id);
		return book;
	}

	@Override
	public int removeBook(int id) {
		int result = bookDAO.removeBook(id);
		return result;
	}

	@Override
	public int modifyBook(Book book) {
		int result = bookDAO.modifyBook(book);
		return result;
	}
	
	
	
}
