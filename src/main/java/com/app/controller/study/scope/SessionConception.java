package com.app.controller.study.scope;

import java.util.HashMap;
import java.util.Map;

public class SessionConception {
	
	/* 사용자(브라우저)			 -(요청)->서버
	   쿠키값(JSESSIONID)		<-(응답)- 서버	
	   
	   사용자 -(요청:쿠키값)->	서버 : 쿠키값 확인
	   							  -> JSESSIONID key값 -> 그 세션의 저장공간 영역 -> sesion.setAttribute
	   							  
		Map
		Key:JSESSIONID Value:저장공간(SessionStorage)
	*/
	
	public static void main(String[] args) {
		
		Map<String, SessionStorage> sessionMap = new HashMap<String, SessionStorage>();
		
		//새로운 사용자 접근 -> 11AA (아이디 주기) -> key에 따른 session 접근!
		
		sessionMap.put("11AA", new SessionStorage()); //11AA 세션에 대한 저장공간 만들어짐!
		
		SessionStorage session = sessionMap.get("11AA"); // value : SessionStorage
		session.setAttribute("fromBMsg", "fromB");
		session.setAttribute("msg", "hi hello");
		
		
		//또 다른 사용자 접근 -> 22BB
		
		sessionMap.put("22BB", new SessionStorage()); //22BB 세션에 대한 저장공간 만들어짐!
		
		//저 접근 했는데요 저장 공간 좀 주세요! 요청
		session = sessionMap.get("11AA");
		session = sessionMap.get("22BB");
		
		
		
	}
	
}

class SessionStorage {
	
	Map<String, Object> storage;
	
	public SessionStorage() {
		storage = new HashMap<String, Object>();
	}
	
	public void setAttribute(String key, Object value) {
		//storage Map에 값 저장 추가
		storage.put(key, value);
	}
	
	public void removeAttribute(String key) {
		//특정 키값으로 삭제
		storage.remove(key);
	}
	
	public void invalidate() {
		//전부삭제 초기화
		storage.clear();
	}
	
}
