package com.app.controller.study.practice.practice10;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice10")
public class Pracitce10Controller {

	@GetMapping("/A")
	public String A(HttpServletRequest request) {

		
		return "practice/practice10/A";
	}


	@GetMapping("/B")
	public String B(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionMsgF", "FromB");

		
		return "practice/practice10/B";
	}

}
