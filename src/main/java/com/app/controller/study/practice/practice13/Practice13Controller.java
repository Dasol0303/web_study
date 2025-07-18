package com.app.controller.study.practice.practice13;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.util.MyCookieUtil;

@Controller
@RequestMapping("/practice13")
public class Practice13Controller {

	@GetMapping("/hideAd")
	public String hideAd(HttpServletRequest request) { //쿠키가 있나도 확인!!
		
		String hideAd = MyCookieUtil.getCookie(request, "hideAd");
		if(hideAd != null) {
			request.setAttribute("hideAd", hideAd);
										// 위에 String 값으로 저장한 쿠키에 저장된 원래 있는 이름으로 그냥 저장해주는 거!!
		}
		
		return "practice/practice13/hideAd";
	}
	
	
	@PostMapping("/hideAd")
	public String hideAdAction(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(request.getParameter("hideAd")); //hideAd라는 이름의 파라미터가 들어왔는지 확인용!!
		
		//24시간보지않기 체크후 요청을 했으면?
		//쿠키에 값 저장!! -> 나중에 해당 화면 접근시, 광고 표시 여부로 활용
		
		//null이 아니면 바로 리턴!!
		if(request.getParameter("hideAd") != null) { //체크함 확인~
			Cookie ck = MyCookieUtil.createCookie("hideAd", "hideAd", 60 * 60 * 24);
														//, 쿠키에 값 저장!! , 60초 *= 60분 * 24번 = 24시
			response.addCookie(ck);
		}
		
		return "redirect:/practice13/hideAd";
	}
	
	

}
