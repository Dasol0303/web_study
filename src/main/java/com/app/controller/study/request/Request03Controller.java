package com.app.controller.study.request;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.Product;
import com.app.dto.study.ProductRequsetForm;

@Controller
@RequestMapping("/request03")
public class Request03Controller {

	@GetMapping("/param1")
	public String param1(HttpServletRequest request) {
		System.out.println("/request03/param1");
		System.out.println(request.getParameter("msg"));
		System.out.println(request.getParameter("page"));
		System.out.println(request.getParameter("level"));
		//		/request03/param1?msg=hi&page=10&level=10
		// 뒤에 하나 빼먹어도 null로만 뜨고 끝!(오류X)


		return "req/param/param1";
	}


	@PostMapping("/param2")
	public String param2(HttpServletRequest request) {
		//  ..../param2?name=abc&count=123
		System.out.println("/request03/param2");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("count"));

		return "req/param/param2";
	}

	@GetMapping("/param3")
	public String param3(HttpServletRequest request) {

		//  http://localhost:8080/request03/param3?p1=10&p2=20&p3=30
		System.out.println("/request03/param3");
		System.out.println(request.getParameter("p1"));
		System.out.println(request.getParameter("p2"));

		//System.out.println(request.getParameter("p3")); //단일 파라미터 값

		//  http://localhost:8080/request03/param3?p1=10&p2=20&p3=30&p3=40
		String[] p3Values = request.getParameterValues("p3"); //여러개 파라미터 값
		for(String s : p3Values) {
			System.out.println(s);
		}

		return "req/param/param2";
	}

	@RequestMapping("/param4")
	public String param4(@RequestParam String p1, @RequestParam String p2) { //요청 파라미터!

		//  http://localhost:8080/request03/param4?p1=10&p2=20
		//  http://localhost:8080/request03/param4?p1=10&p3=20 => 오류!!
		System.out.println("/request03/param4");
		System.out.println(p1);
		System.out.println(p2);

		return "req/param/param2";
	}

	@RequestMapping("/param5")
	public String param5(@RequestParam String p1, @RequestParam(required = false) String p2) { //요청 파라미터!
		//  요구되냐? = 아니요
		//  http://localhost:8080/request03/param5?p1=10&p2=20
		//  http://localhost:8080/request03/param5?p1=10
		//												=>required = false 사용으로 오류가 아닌 null이 뜨면서 실행이 됨!
		System.out.println("/request03/param5");
		System.out.println(p1);
		System.out.println(p2);

		return "req/param/param2";
	}

	@RequestMapping("/param6")
	public String param6(@RequestParam(value="p1") String param1Value, 
			@RequestParam(required = false, defaultValue = "p2Default") String p2) {

		//  http://localhost:8080/request03/param6?p1=10&p2=20
		//  http://localhost:8080/request03/param6?p1=100&ppp2=200
		//												=>ppp2 라는 key 이름이 없어서 지정해둔 p2Default 출력
		System.out.println("/request03/param6");
		System.out.println(param1Value);
		System.out.println(p2);

		return "req/param/param2";
	}

	@RequestMapping("/param7")
	public String param7(@RequestParam Map<String, String> paramMap) {
		//paramMap 안에 요청 들어온 파라미터 값들이 Key:Value 형태로 저장되어 전달됨
		//  http://localhost:8080/request03/param7?p1=hi&p2=hong&count=KKI
		System.out.println("/request03/param7");
		System.out.println(paramMap.get("p1"));
		System.out.println(paramMap.get("p2"));
		System.out.println(paramMap.get("count"));

		return "req/param/param2";
	}

	@GetMapping("/param8")		// GET 조회/읽기  초기화면 연결 
	public String param8() {
		System.out.println("/request03/param8 GET 요청");

		return "req/param/param8";
	}

	@PostMapping("/param8")		// POST 쓰기/데이터 전달  실제 데이터를 전달 받아서 로직 처리
	//public String param8Action(@ModelAttribute Product product) { //  xxxxAction / xxxxProcess 라는 이름 자주사용!
	public String param8(@ModelAttribute ProductRequsetForm productReuwstForm) {	
		System.out.println("/request03/param8 POST 요청");

		//System.out.println(product);
		System.out.println(productReuwstForm);

		//productRequestForm -> product
		//					 -> otherDTO (DTO를 나눠서도 사용가능!)
		
		return "req/param/param8after";
		//전송 버튼으로 들어온 post 메소드에서 리턴하는 페이지랑 데이터를 저장하는 dto가 들어있음!!
		//콘솔로 출력되는건 확인용으로 dto에 toString을 만들어두어서!!
	}
	
	@RequestMapping("/param9/{itemId}")
	public String param9(@PathVariable String itemId) {
	//  http://localhost:8080/request03/param9/10239
		System.out.println("/request03/param9 요청");
		
		System.out.println(itemId);
		
		return "req/param/param2";
	}


}
