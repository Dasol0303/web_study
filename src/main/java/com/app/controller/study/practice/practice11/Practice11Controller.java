package com.app.controller.study.practice.practice11;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice11")
public class Practice11Controller {

	@GetMapping("/first") 
	public String first(HttpServletRequest request) {
		
		request.setAttribute("accessUrl", "/first");
		
		return "practice/practice11/targetPage";
	}
	
	@GetMapping("/firsthide1") 
	public String first1(HttpServletRequest request) {
		
		request.setAttribute("accessUrl", "/firsthide1");
		
		return "practice/practice11/targetPage";
	}
	
	@GetMapping("/first2") 
	public String first2(HttpServletRequest request) {
		
		return "redirect:/practice11/first";
	}
	

}
