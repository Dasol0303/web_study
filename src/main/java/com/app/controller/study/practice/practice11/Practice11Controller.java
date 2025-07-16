package com.app.controller.study.practice.practice11;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice11")
public class Practice11Controller {

	@GetMapping("/first") 
	public String first(HttpServletRequest request, Model model, HttpSession session) {
		
		if(session.getAttribute("accessUrl") == null) {//없다. hide3를 들리지 않았다
			
			model.addAttribute("accessUrl", "/first");
			
		} else { //세션에 "accessUrl" 들어있다. -> hide3를 들렸다가 건너왔다
			
			//model.addAttribute("accessUrl", "/firsthide3");
			model.addAttribute("accessUrl", session.getAttribute("accessUrl"));
										//어떤 경로를 다녀왔따는 기록을 적어준...? 거라는데..?
			
			//session.removeAttribute("accessUrl"); //특정 키값으로 삭제
			session.invalidate(); //세션 클리어
		}
		
		return "practice/practice11/targetPage";
	}
	
	@GetMapping("/firsthide1") 
	public String first1(HttpServletRequest request, Model model, HttpSession session) {
		
		request.setAttribute("accessUrl", "/firsthide1");

		return "practice/practice11/targetPage";
	}
	
	@GetMapping("/firsthide2") 
	public String first2(HttpServletRequest request, Model model, HttpSession session) {
		
		request.setAttribute("accessUrl", "/firsthide2");
		
		return "redirect:/practice11/first";
	}
	
	
	@GetMapping("/firsthide3") 
	public String first3(HttpServletRequest request, HttpSession session) {

		//firsthide3 에 접근했었다 라는 의미를 -> 전달 -> session 영역에 저장
		
		//request.setAttribute("accessUrl", "/firsthide3");
		session.setAttribute("accessUrl", "/firsthide3");
		
		return "redirect:/practice11/first";
	}
	

}
