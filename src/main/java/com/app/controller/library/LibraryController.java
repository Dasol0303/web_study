package com.app.controller.library;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.book.Book;
import com.app.service.book.BookService;

@Controller
public class LibraryController {
	
	@Autowired
	BookService bookService;
	
	

	//책 정보 표시 -> List형 책 목록
	@GetMapping("/books")
	public String books(Model model) {
		
		List<Book> bookList = bookService.findBookList();
		System.out.println(bookList);
		
		model.addAttribute("bookList", bookList);
		
		return "library/bookList";
	}
	
	
	//책 정보 표시 -> 책 하나
	@GetMapping("/books/{id}")
	public String booksInfo(@PathVariable String id, Model model) {
		
		Book book = bookService.findBookById(Integer.parseInt(id));
		model.addAttribute("book", book);
		
		return "library/bookInfo";
	}
	
	
	//추가 기능 -> 페이지
	@GetMapping("/books/add")
	public String add() {
		return "library/bookAdd";
	}
	
	@PostMapping("/books/add")
	public String addAction(Book book) {
		
		System.out.println(book.toString());
		
		int result = bookService.saveBook(book);
		System.out.println(result);
		
		if(result > 0) {
			return "redirect:/books";
		} else {
			return "library/bookAdd";
		}

	}
	
	
	//삭제 기능 -> 페이지 -> redirect:/books
	@GetMapping("/books/removeBook")
	public String removeBook(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		
		int result = bookService.removeBook(Integer.parseInt(id));
		
		if(result > 0) {
			return "redirect:/books";
		} else {
			return "redirect:/books";
		}
		
		
	}
	
	
	//수정 기능 -> 페이지
	@GetMapping("/books/modifyBook")
	public String modifyBook(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		
		Book book = bookService.findBookById(Integer.parseInt(id));
		
		System.out.println(book);
		
		request.setAttribute("book", book);
		
		return "library/modifyBook";
	}
	
	
	@PostMapping("/books/modifyBook")
	public String modifyBookAction(Book book) {
		
		int result = bookService.modifyBook(book);
		
		if(result > 0) { // 성공
			return "redirect:/books/" + book.getId();
		} else { //실패
			return "redirect:/books/modifyBook?id=" + book.getId();
		}
	}
	
}
