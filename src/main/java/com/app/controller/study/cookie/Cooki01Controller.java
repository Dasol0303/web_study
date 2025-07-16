package com.app.controller.study.cookie;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.util.MyCookieUtil;

@Controller
public class Cooki01Controller {

	@GetMapping("/saveCookie")
	public String saveCookie(HttpServletResponse response) {

		//서버에서 쿠키 생성 -전달-> 사용자(브라우저)
		//						쿠키가 있네? -> 쿠키 저장

		//key value 생김!!
		Cookie ck1 = new Cookie("menu", "cutlet"); //sevlet http Cookie import!!
		ck1.setMaxAge(60 * 60 * 12); //쿠키의 수명(유효한 기간 정해주기) -> 초단위
		//연산으로 쓰는 이유 : 초를 그냥 냅다 1865468 적어버리면 알아보기 힘들어서!! 

		response.addCookie(ck1);

		Cookie ck2 = new Cookie("today", "WED");
		ck2.setMaxAge(30);

		response.addCookie(ck2);

		//쿠키에는 띄어쓰기 -> URLEncode
		String value;
		try {
			value = URLEncoder.encode("plus 15", "UTF-8");

			//Cookie ck3 = new Cookie("temperature", "plus 15");
			Cookie ck3 = new Cookie("temperature", value);
			//쿠키에는 띄어쓰기 그냥 쓰면 오류!! 그래서 인코딩으로 변환된 문자 넣어줌!!
			//그리고 try catch 필수!!
			ck3.setMaxAge(100);

			response.addCookie(ck3);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		
		//util 사용
		Cookie ck4 = MyCookieUtil.createCookie("ck4Name", "ck4Value");
		Cookie ck5 = MyCookieUtil.createCookie("ck5Name", "ck5Value", 3600);
		
		return "cookie/saveCookie";
	}
	
	
	@GetMapping("/removeCookie")
	public String removeCookie(HttpServletResponse response) {
		//쿠키 지우기!!!! 지우지우~
		
		Cookie ck1 = new Cookie ("menu", "vvvv");
		ck1.setMaxAge(0);  //수명 0  -> 브라우저 인식 ->  수명0 쿠키 처리
		
		response.addCookie(ck1);
		
		
		//util 사용
		Cookie ckk = MyCookieUtil.createCookieForRemove("abc");
		response.addCookie(ckk);
		
		return "cookie/saveCookie";
	}

	
	@GetMapping("/readCookie")
	public String redCookie(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		String menu = null;
		for(Cookie ck : cookies) {
			System.out.println(ck.getName() + " " + ck.getValue());
			
			if(ck.getName().equals("menu")) { //key 이름이 menu일 때 menu의 value값 뽑아내기!!
				menu = ck.getValue();
			}
			
			//encode를 했으면 decode로 되돌려주어야함!! (암호화 한 후에 복..복...ㅎ호훟ㅎ학 ㄷ하듯이 ㄷㄷ뭐라구요?
			if(ck.getName().equals("temperature")) {
				try {
					System.out.println("decode : " + URLDecoder.decode(ck.getValue(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		
		//Util 사용
		menu = MyCookieUtil.getCookie(cookies, "menu");
		
		request.setAttribute("menu",  menu);
		
		String temperature = MyCookieUtil.getCookie(cookies, "temperature");
		temperature = MyCookieUtil.getCookie(request, "temperature");
		
		
		return "cookie/readCookie";
	}
	
	@GetMapping("/readCookie2")
	public String redCookie2(@CookieValue(required = false) String menu, @CookieValue String temperature) {
		//해당하는 키값이 없으면 오류남!! 그래서 (required = false) 걸어줌!!
		
		System.out.println(menu);
		System.out.println(temperature);
		
		return "cookie/readCookie";
	}

	
	

}


