package com.app.controller.study.redirect_forward;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectForward01Controller {

	@GetMapping("/re/re1")
	public String re1() {
		
		
		
		return "re/re1";
	}
	
	
	@GetMapping("/re/re2")
	public String re2(HttpServletRequest request) { //메시지 받아서 처리 가능!
		
		System.out.println("/re/re2");
		System.out.println(request.getParameter("msg"));
		
		//jsp 파일 내부의 ${msg}에 값이 뜨게 만들기!
		request.setAttribute("msg", request.getParameter("msg"));
		
		
		return "re/re2";
	}
	
	
	@GetMapping("/re/re3")
	public String re3(HttpServletRequest request) {
		
		System.out.println("/re/re3");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re2"; 	//요청 /re3 -> 화면(view) re2
	}
	
	
	@GetMapping("/re/re4")
	public String re4(HttpServletRequest request) {
		
		//페이지 내부의 redirect 처리
		System.out.println("/re/re4");
		System.out.println(request.getParameter("msg"));
		
		return "re/re4"; 	//요청 /re4 -> 화면(view) re4 -> 페이지 내부(location.href) -> re2
	}
	
	
	@GetMapping("/re/re5")
	public String re5(HttpServletRequest request) {
		
		//서버에서 redirect 처리
		System.out.println("/re/re5");
		System.out.println(request.getParameter("msg"));
		
		
		return "redirect:/re/re2"; //	/re/re2 경로로 redirect (재접속)
		// 화면view return이 아님!(주의!! => 주소임!!)
		//특정 주소 경로로 redirect를 걸겠다!!
		//페이지 표시x jsp 파일을 거치지 않고 바로 controller 내부에서 접속 경로로 이동!
		
		//view 이름 return	/WEB-INF/views/		"re/re2"	.jsp
		
		//redirect 주소창에 들어갈 경로!		localhost:8080		"/re/re2"
		// 새로운 Request로 재접속
	}
	
	
	@GetMapping("/re/re6")
	public String re6(HttpServletRequest request) {
		
		//서버에서 forward 처리
		System.out.println("/re/re5");
		System.out.println(request.getParameter("msg"));
		
		//forward 서버에서 바로 요청 경로를 바꿔서 수행
		// 그대로 전달~
		
		return "forward:/re/re2"; //	RequestMapping에 해당하는 경로를 작성
		// 얘는 파라미터 값이 그대로 뜬다!!!!
		// Request 유지(주소 유지?)
		// 잘 안씀 ⇒ 주소가 바뀌면 혼동이 와서
	}
	
	
	@GetMapping("/re/re7")
	public String re7(HttpServletRequest request, RedirectAttributes ra) {
												 //3) return용으로 하나 추가!!
		
		//서버에서 redirect 처리
		System.out.println("/re/re7");
		System.out.println(request.getParameter("msg"));

		// request.setAttribute("msg", request.getParameter("msg")) //view 데이터 /객체 전달용
		// redirect 시에 새로운 request 로 요청되기 때문에	redirect 하면 넘어가지 않는다.
		
		
		
		//1) 일반 redirect
		//return "redirect:/re/re2"; //	/re/re2 경로로 redirect (재접속)
		
		//2) Parameter를 받아서 직접 주소에 입력해주는 방법!
		// redirect 경로에 직접 parameter 들어간 주소 형식으로 작성 /re/re2
		//return "redirect:/re/re2?msg=" + request.getParameter("msg");
		
		//3) RedirectAttributes 활용(이렇게 하면 return에 일일이 안적어줘도 주소창에 알아서 처리가 잘됨!!!)
		//ra.addAttribute("msg", request.getParameter("msg")); //경로에 파라미터 추가해서 연결(주소창에 기록 남음!)
			//redirect 요청 주소 경로 뒤에 파라미터 추가해서 연결 
			// -> 연결된 서버측 메소드에서도 경로에 있는 Parameter 확인 가능
		
		ra.addFlashAttribute("msg", request.getParameter("msg")); //화면에는 인식이 되지만 서버에서는 인식 불가!
		//Model 과 같은 역할!
			//redirect 요청 주소는 그대로
			//redirect 된 서버측 메소드에서 연결해주는 화면에서 사용할 수 있도록 전달 (model 저장됨)
			// request.getParameter 에서 확인 X
		
		return "redirect:/re/re2";
		
	}

}
