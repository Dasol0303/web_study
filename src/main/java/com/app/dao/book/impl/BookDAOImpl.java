package com.app.dao.book.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.book.BookDAO;
import com.app.dto.book.Book;

@Repository
public class BookDAOImpl implements BookDAO{
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	//책 정보 저장
	@Override
	public int saveBook(Book book) {
		
		int result = sqlSessionTemplate.insert("book_mapper.saveBook", book);
		
		return result;
	}

	@Override
	public List<Book> findBookList() {
		
		List<Book> bookList = sqlSessionTemplate.selectList("book_mapper.findBookList");
		
		return bookList;
	}

	@Override
	public Book findBookById(int id) {
		Book book = sqlSessionTemplate.selectOne("book_mapper.findBookById", id);
		return book;
	}

	@Override
	public int removeBook(int id) {
		int book = sqlSessionTemplate.delete("book_mapper.removeBook", id);
		return book;
	}

	@Override
	public int modifyBook(Book book) {
		int result = sqlSessionTemplate.update("book_mapper.modifyBook", book);
		return result;
	}
	
	
	
}
