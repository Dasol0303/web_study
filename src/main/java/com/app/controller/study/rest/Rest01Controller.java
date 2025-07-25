package com.app.controller.study.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Rest01Controller {
	
	@GetMapping("/rest/rest01")
	public String rest01() {
		return "rest/rest01";
		
		//view 자원 경로 return
	}
	
	@ResponseBody
	@GetMapping("/rest/rest02")
	public String rest02() {
		return "rest/rest02";
		
		//return 하는 문자열을 그대로 텍스트로 반환 -> html에 들어가는 형태가 아닌 브라우저로 글귀만 띄워주는 형태
	}
	
	@ResponseBody
	@GetMapping("/rest/rest03")
	public String rest03() {
		return "this is rest03 retunr text";
		
		//return 하는 문자열을 그대로 텍스트로 반환 -> html에 들어가는 형태가 아닌 브라우저로 글귀만 띄워주는 형태
	}
	
	
	
}
