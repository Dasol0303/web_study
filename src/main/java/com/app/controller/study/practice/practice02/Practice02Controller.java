package com.app.controller.study.practice.practice02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice02")
public class Practice02Controller {

	@GetMapping("/req1")
	public String req1() {
		System.out.println("/practice02/req1 GET 요청");
		return "practice/practice02/prac02";
	}
	
	@PostMapping("/req2")
	public String req2() {
		System.out.println("/practice02/req2 POST 요청");
		return "practice/practice02/prac02";
	}
	
	@GetMapping("/req3")
	public String req3(HttpServletRequest prac02) {
	//  http://localhost:8080/practice02/req3?data1=10&data2=20
		System.out.println("/practice02/req3 요청");
		System.out.println(prac02.getParameter("data1"));
		System.out.println(prac02.getParameter("data2"));
		return "practice/practice02/prac02";
	}
	
	@PostMapping("/req4")
	public String req4(HttpServletRequest prac02) {
	//  http://localhost:8080/practice02/req4?data1=10&data2=20
		System.out.println("/practice02/req4 요청");
		System.out.println(prac02.getParameter("data1"));
		System.out.println(prac02.getParameter("data2"));
		return "practice/practice02/prac02";
	}
	
}
