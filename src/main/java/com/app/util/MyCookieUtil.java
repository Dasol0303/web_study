package com.app.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class MyCookieUtil {

	//상수형 값 하나 만들어서 사용!!
	public static final String CHARACTER_ENCODING = "UTF-8";

	
	
	//바로바로 사용할 수 있게static 걸어주기!
	public static String getCookie(Cookie[] cookies, String cookieName) {

		//cookies 뭉치가 여기 있으니 이중에서 cookieName의 value를 찾아서 반환해라

		//decode에 따로 try catch해주면 복잡시러.. 워서... 전체에 그냥 다 걸어줌!!!
		try {

			for(Cookie ck : cookies) {

				if(ck.getName().equals(cookieName)) {
					String cookieValue = URLDecoder.decode(ck.getValue(), CHARACTER_ENCODING);
					return cookieValue;
				}

			}
		} catch (Exception e) {


		}


		return null; //못찾거나 없으면.. null 리턴!!
	}


	
	// 리팩토링 After
	public static String getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();

		return getCookie(cookies, cookieName);
	}

	/*
	//전부 중복 작성 - 리팩토링 Before
	public static String getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();

		//cookies 뭉치가 여기 있으니 이중에서 cookieName의 value를 찾아서 반환해라
		try {

			for(Cookie ck : cookies) {

				if(ck.getName().equals(cookieName)) {
					String cookieValue = URLDecoder.decode(ck.getValue(), "UTF-8");
					return cookieValue;
				}

			}
		} catch (Exception e) {


		}

		return null; //못찾거나 없으면.. null 리턴!!
	}
	 */


	
	public static Cookie createCookie(String name, String value) {

		Cookie ck = new Cookie(name, encodeCookieValue(value));
		//maxAge 세팅 생략 or maxAge(-1) -> 세션 쿠키 -> 그 브라우저 세션 단위까지만 사용
		return ck;
	}
	
	
	
	public static Cookie createCookie(String name, String value, int maxAgeSecond) {

		Cookie ck = new Cookie(name, encodeCookieValue(value));
		ck.setMaxAge(maxAgeSecond);
		
		return ck;
	}
	
	
	
	//삭제 용도!!
	public static Cookie createCookieForRemove(String name) {
		Cookie ck = new Cookie(name, "");
		ck.setMaxAge(0);
		
		return ck;
	}
	

	
	public static String encodeCookieValue(String value) {

		try {
			return URLEncoder.encode(value, CHARACTER_ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}


}

