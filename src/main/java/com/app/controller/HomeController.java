package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @ => 어노테이션(Annotation) : 주석
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		
		// ViewResolver 설정 이전!
//		return "/WEB-INF/views/home.jsp";
		
		//return "/WEB-INF/views/mainpage.jsp";

		//--ViewResolver 설정 이후
		return "home";
	}
}