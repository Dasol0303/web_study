package com.app.controller.study.practice.practice12;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.util.MyCookieUtil;

@Controller
@RequestMapping("/practice12")
public class Practice12Controller {

	//int count = 0;

	@GetMapping("/login")
	public String login(
						//HttpServletRequest request
						) {

		/*
		String id = MyCookieUtil.getCookie(request, "id");
		
		if(id != null) {
			request.setAttribute("id", id);
			//view 접근가능
		}
		*/

		return "practice/practice12/login";
	}

	@PostMapping("/login")
	public String loginAction(HttpServletRequest request
							//, HttpServletResponse response
							 ) {

		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		
		//로그인 성공으로 간주하고, 로그인한 사용자 id를 세션에 저장
		//					-> 나중에 다른 request에서도 session에 접근 및 데이터 조회 가능
		
		HttpSession session = request.getSession();
		session.setAttribute("loginId", request.getParameter("id")); //session값에 id저장
		session.setAttribute("count", 0); // 해당 세션에 대한 count값 초기화
		
		
		/*
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id == null) {

		} else {
			Cookie ck = MyCookieUtil.createCookie("id", id, 3600);
			count++;

			response.addCookie(ck);
		}
		*/

		return "redirect:/practice12/count";
	}


	@GetMapping("/count")
	public String count(HttpSession session, Model model 
						//, HttpServletRequest request
						) {
		
		//session.getAttribute("loginId");
		
		
		//로그인한 사용자가 있으면 -> conut값도 초기화되어서 있다
		//count가 있어야 처리한다!
		//if(session.getAttribute("count") != null) {} 
		
		if(session.getAttribute("loginId") != null) { //로그인한 사용자가 있다!!
			//count 계산
			// 기존 count + 1
			session.setAttribute("count", ((Integer)( session.getAttribute("count")) + 1) );
		} else { //일시적으로 0으로 보여줌!
			model.addAttribute("count", 0);
		}
		
		
		/* ===== ㅠ
		Integer countStr = Integer.valueOf(count);
		request.setAttribute("count", countStr);

		String id = MyCookieUtil.getCookie(request, "id");
		
		if(id != null) {
			request.setAttribute("id", id);
			request.setAttribute("count", countStr);
		}
		 */
		
		return "practice/practice12/count";
	}


	@GetMapping("/logout")
	public String logout(
						//HttpServletRequest request, HttpServletResponse response, 
						HttpSession session) {
		
		//세션을 삭제하고
		//count 페이지로 이동
		
		//session.removeAttribute("loginId");
		//session.removeAttribute("count");
		session.invalidate();
		
		
		/*
		String id = MyCookieUtil.getCookie(request, "id");

		Cookie ckk = MyCookieUtil.createCookieForRemove("id");
		response.addCookie(ckk);
		count = 0;
		*/

		return "redirect:/practice12/count";
		//이렇게 count로 아이디 없이 들어가면 NullPoint인셉션..ㅎㅎ !! 그래서 오류를 안뜨게 하려고 count 내부에서 if문 사용!!
	}


}
