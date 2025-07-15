package com.app.controller.study.scope;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Scope01Controller {
	
	// scope 영역은 밑에 세가지로 분류!!
	// request / session / application
	
	@GetMapping("/scope1")
	public String scope1(Model model) {
		
		model.addAttribute("requestMsg", "이것은 model에 추가한 메시지(request scope)");
		//request 영역
		
		return "scope/scope1";
	}
	
	
	@GetMapping("/scope2")
	public String scope2(HttpServletRequest request) {
		
		//request scope (session 보다 작은 영역!)
		request.setAttribute("requestMsg", "request scope Msg");
		
		//(ex -> application이 Class라고 했을 때 session은 public void~ 의 형태로 연결!!)
		//session scope
		HttpSession session = request.getSession();
		session.setAttribute("sessionMsg", "session scope Msg");

		//application scope
		//요건 application을 세팅하는 로직!!(application을.. 생성하는건가 테이블처럼..?)
		ServletContext app = request.getServletContext();
		app.setAttribute("applicationMsg", "application scope Msg");
		
		return "scope/scope2";
	}
	
	
	@GetMapping("/scope3")
	public String scope3() {
		// /scope2 에 들어갔다가 /scope3으로 들어가면 아무것도 설정 안한 /scope3에 /scope2 값이 생김!!
		// 공통으로 사용되는 application 에 /scope2에 들어가면 /scope2의 데이터가 생겨서!! 
		// (application에 생긴 값은 쉽게 안없어짐!! -> 없애려면 server 재시작!)
		// request는 /scope3을 요청했을 때 생기는 애라서 얘만 안담기는건가...?
		
		return "scope/scope3";
	}
	
	
	@GetMapping("/scope4")
	public String scope4(HttpSession session) { //session 영역에 접근!
		// session영역에 들어간 값 지우기!!
		
		session.setAttribute("newKey", "session newKey : Value");
		
		session.removeAttribute("sessionMsg"); // sessino scope에서 특정 키값을 삭제
		
		session.invalidate(); // session scope에 저장된 모든 속성(키) 삭제		(세션 초기화)
		
		return "scope/scope3";
	}
	
	
}
